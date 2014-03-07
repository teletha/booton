/*
 * Copyright (C) 2013 Nameless Production Committee
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
import java.nio.file.WatchEvent.Kind;

import javax.servlet.http.HttpServletRequest;

import kiss.Disposable;
import kiss.I;
import kiss.Observable;
import kiss.Observer;
import kiss.XML;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import booton.Booton;

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
        this.root = root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        String path = request.getPathInfo();

        return new LiveCodingSocket(root.toAbsolutePath().resolve(path.substring(1)));
    }

    /**
     * @version 2013/08/08 11:48:39
     */
    private static class LiveCodingSocket implements WebSocket.OnTextMessage {

        /** The coding html. */
        private final Path html;

        /** The actual connection. */
        private Connection connection;

        /** The publish flag. */
        private boolean whileBuilding = false;

        /** The last send time. */
        private long last = System.currentTimeMillis();

        /** For source observers. */
        private Disposable souces;

        /** For mutex observer. */
        private Disposable mutex;

        /**
         * @param target
         */
        private LiveCodingSocket(Path target) {
            this.html = target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onOpen(Connection connection) {
            this.connection = connection;
            this.connection.setMaxIdleTime(Integer.MAX_VALUE);

            System.out.println("open " + html);

            // observe html
            Observable<WatchEvent<Path>> observable = observe(html.getFileName().toString());

            XML xml = I.xml(html);

            // observe js
            for (XML js : xml.find("script[src]")) {
                String src = js.attr("src");

                if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("https://")) {
                    observable = observable.merge(observe(src));
                }
            }
            observable = observable.merge(observe("live.js"));

            // observe css
            for (XML css : xml.find("link[rel=stylesheet]")) {
                String href = css.attr("href");

                if (href.length() != 0 && !href.startsWith("http://") && !href.startsWith("https://")) {
                    observable = observable.merge(observe(href));
                }
            }

            souces = observable.debounce(1, SECONDS).subscribe(value -> {
                if (value.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    if (!whileBuilding) {
                        System.out.println("modify " + value.context().getFileName().toString());
                        send(value.context().getFileName().toString());
                    }
                }
            });

            // observe publishing file
            mutex = I.observe(html.resolveSibling(Booton.BuildPhase))
                    .debounce(1, SECONDS)
                    .subscribe(new BuildObserver());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClose(int closeCode, String message) {
            System.out.println("close " + html);

            souces.dispose();
            mutex.dispose();
            connection = null;
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
         * Reload all resources.
         * </p>
         */
        private void reload() {
            send("reload");
        }

        /**
         * <p>
         * Helper method to send message.
         * </p>
         * 
         * @param message
         */
        private void send(String message) {
            long current = System.currentTimeMillis();

            if (last + 1000 < current) {
                last = current;

                try {
                    connection.sendMessage(message);
                } catch (IOException e) {
                    throw I.quiet(e);
                }
            }
        }

        private Observable<WatchEvent<Path>> observe(String path) {
            int index = path.indexOf('?');

            if (index != -1) {
                path = path.substring(0, index);
            }
            return I.observe(html.resolveSibling(path));
        }

        /**
         * @version 2013/01/08 16:25:47
         */
        private class BuildObserver implements Observer<WatchEvent<Path>> {

            /**
             * {@inheritDoc}
             */
            @Override
            public void onNext(WatchEvent<Path> value) {
                Kind kind = value.kind();

                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    whileBuilding = true;
                    System.out.println("start build");
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    whileBuilding = false;
                    System.out.println("end build");
                    reload();
                }
            }
        }
    }
}
