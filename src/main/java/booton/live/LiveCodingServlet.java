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

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kiss.Disposable;
import kiss.I;
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

        /** The file observers. */
        private List<Disposable> observers = new ArrayList();

        /** The actual connection. */
        private Connection connection;

        /** The publish flag. */
        private boolean whileBuilding = false;

        /** The last send time. */
        private long last = System.currentTimeMillis();

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
            new FileObserver(html.getFileName().toString());

            XML xml = I.xml(html);

            // observe js
            for (XML js : xml.find("script[src]")) {
                String src = js.attr("src");

                if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("https://")) {
                    new FileObserver(src);
                }
            }
            new FileObserver("live.js");

            // observe css
            for (XML css : xml.find("link[rel=stylesheet]")) {
                String href = css.attr("href");

                if (href.length() != 0 && !href.startsWith("http://") && !href.startsWith("https://")) {
                    new FileObserver(href);
                }
            }

            // observe publishing file
            observers.add(I.observe(html.resolveSibling(Booton.BuildPhase)).subscribe(new BuildObserver()));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClose(int closeCode, String message) {
            System.out.println("close " + html);

            for (Disposable observer : observers) {
                observer.dispose();
            }
            observers.clear();
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
                    System.out.println(message);
                    connection.sendMessage(message);
                } catch (IOException e) {
                    throw I.quiet(e);
                }
            }
        }

        /**
         * @version 2013/01/08 9:36:32
         */
        private class FileObserver implements Observer<WatchEvent<Path>> {

            /** The original path. */
            protected final String path;

            /** The target. */
            protected final Path file;

            /**
             * @param file
             */
            private FileObserver(String path) {
                int index = path.indexOf('?');

                if (index != -1) {
                    path = path.substring(0, index);
                }

                this.path = path;
                this.file = html.resolveSibling(path);

                observers.add(I.observe(file).subscribe(this));
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void onNext(WatchEvent<Path> value) {
                if (value.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    if (!whileBuilding) {
                        send(path);
                    }
                }
            }
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
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    whileBuilding = false;

                    reload();
                }
            }
        }
    }
}
