/*
 * Copyright (C) 2016 Nameless Production Committee
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

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import booton.BootonConfiguration;
import filer.Filer;
import kiss.Disposable;
import kiss.I;
import kiss.Signal;
import kiss.XML;

/**
 * @version 2016/12/04 13:07:59
 */
@SuppressWarnings("serial")
public class LiveCodingServlet extends WebSocketServlet {

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.getPolicy().setIdleTimeout(Integer.MAX_VALUE);
        factory.register(LiveCoder.class);
    }

    /**
     * @version 2016/12/04 13:11:02
     */
    public static class LiveCoder extends WebSocketAdapter {

        /** The booton setting. */
        private BootonConfiguration config = I.make(BootonConfiguration.class);

        /** The html file. */
        private Path html;

        /** The user agnet. */
        private String agent;

        /** The actual connection. */
        private Session session;

        /** For source observers. */
        private Disposable sources;

        /**
         * {@inheritDoc}
         */
        @Override
        public void onWebSocketConnect(Session session) {
            UpgradeRequest request = session.getUpgradeRequest();
            this.agent = analyzeAgent(request.getHeader("User-Agent"));
            this.html = config.root.resolve("application.html");
            System.out.println("CONNECT [" + agent + "]");

            this.session = session;

            // observe html
            Signal<WatchEvent<Path>> observable = Filer.observe(html);

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
        public void onWebSocketClose(int statusCode, String reason) {
            System.out.println("DISCONNECT [" + agent + "]");

            session = null;
            sources.dispose();
            sources = null;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onWebSocketText(String message) {
            Source application = create(html.resolveSibling("application.js"));
            Source live = create(html.resolveSibling("live.js"));
            ClientStackTrace.decode(message, application, live).printStackTrace(System.err);
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
                Source source = new Source(path.getFileName().toString());
                source.add(Files.readAllLines(path, StandardCharsets.UTF_8));

                return source;
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
                session.getRemote().sendString(message);
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
         * @return A {@link Signal}.
         */
        private Signal<WatchEvent<Path>> observeFile(String relativePath) {
            int index = relativePath.indexOf('?');

            if (index != -1) {
                relativePath = relativePath.substring(0, index);
            }
            return Filer.observe(config.root.resolve(relativePath));
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
