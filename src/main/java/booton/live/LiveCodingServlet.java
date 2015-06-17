/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import static java.util.concurrent.TimeUnit.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;
import org.eclipse.jetty.websocket.WebSocketServlet;

import kiss.Disposable;
import kiss.Events;
import kiss.I;
import kiss.XML;

/**
 * @version 2013/08/08 11:48:43
 */
@SuppressWarnings("serial")
public class LiveCodingServlet extends WebSocketServlet {

    /** The target. */
    private final Path root;

    /**
     * @param project
     */
    public LiveCodingServlet(Path root) {
        this.root = root.toAbsolutePath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        return new LiveCoder(request, root.resolve(request.getPathInfo().substring(1)));
    }

    /**
     * @version 2014/03/07 15:48:20
     */
    private class LiveCoder implements OnTextMessage {

        /** The html file. */
        private final Path html;

        /** The user agnet. */
        private final String agent;

        /** The actual connection. */
        private Connection connection;

        /** For source observers. */
        private Disposable sources;

        /**
         * @param request
         * @param html
         */
        private LiveCoder(HttpServletRequest request, Path html) {
            this.html = html;
            this.agent = analyzeAgent(request.getHeader("User-Agent"));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onOpen(Connection connection) {
            System.out.println("CONNECT [" + agent + "]");

            this.connection = connection;
            this.connection.setMaxIdleTime(Integer.MAX_VALUE);

            // observe html
            Events<WatchEvent<Path>> observable = I.observe(html);

            XML xml = I.xml(html);

            // observe js
            for (XML js : xml.find("script[src]")) {
                String src = js.attr("src");

                if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("https://")) {
                    observable = observable.merge(observeFile(src));
                }
            }
            observable = observable.merge(observeFile("live.js"));

            // observe css
            for (XML css : xml.find("link[rel=stylesheet]")) {
                String href = css.attr("href");

                if (href.length() != 0 && !href.startsWith("http://") && !href.startsWith("https://")) {
                    observable = observable.merge(observeFile(href));
                }
            }

            sources = observable.debounce(1, SECONDS).to(event -> {
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("modify " + event.context());
                    send(event.context().getFileName().toString());
                }
            });
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClose(int closeCode, String message) {
            System.out.println("DISCONNECT [" + agent + "]");

            connection = null;
            sources.dispose();
            sources = null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onMessage(String data) {
            Source application = create(html.resolveSibling("application.js"));
            Source live = create(html.resolveSibling("live.js"));
            ClientStackTrace.decode(data, application, live).printStackTrace(System.err);
        }

        /**
         * <p>
         * Helper method to create source code.
         * </p>
         * 
         * @param path
         * @return
         */
        private Source create(Path path) {
            try {
                return new Source(path.getFileName().toString(), Files.readAllLines(path, StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw I.quiet(e);
            }
        }

        /**
         * <p>
         * Helper method to send message.
         * </p>
         * 
         * @param message
         */
        private void send(String message) {
            try {
                connection.sendMessage(message);
            } catch (IOException e) {
                throw I.quiet(e);
            }
        }

        /**
         * <p>
         * Observe source file modification.
         * </p>
         * 
         * @param relativePath A relative path from root.
         * @param file A target file.
         * @return A {@link Events}.
         */
        private Events<WatchEvent<Path>> observeFile(String relativePath) {
            int index = relativePath.indexOf('?');

            if (index != -1) {
                relativePath = relativePath.substring(0, index);
            }
            return I.observe(root.resolve(relativePath));
        }

        /**
         * <p>
         * Analyze user-agent name.
         * </p>
         * 
         * @param agent
         * @return
         */
        private String analyzeAgent(String agent) {
            if (agent.contains("Firefox")) {
                return agent.substring(agent.indexOf("Firefox"));
            } else {
                return agent;
            }
        }
    }
}
