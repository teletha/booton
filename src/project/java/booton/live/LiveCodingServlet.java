/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import js.util.ArrayList;
import kiss.Disposable;
import kiss.I;
import kiss.PathListener;
import kiss.XML;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import bee.api.Project;

/**
 * @version 2013/01/04 15:44:31
 */
@SuppressWarnings("serial")
public class LiveCodingServlet extends WebSocketServlet {

    /** The target. */
    private final Project project;

    /**
     * @param project
     */
    public LiveCodingServlet(Project project) {
        this.project = project;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        String path = request.getPathInfo();

        return new LiveCodingSocket(project.getRoot().toAbsolutePath().resolve(path.substring(1)));
    }

    /**
     * @version 2013/01/04 15:45:16
     */
    private static class LiveCodingSocket implements WebSocket.OnTextMessage {

        /** The coding html. */
        private final Path html;

        /** The file observers. */
        private List<Disposable> observers = new ArrayList();

        /** The actual connection. */
        private Connection connection;

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

            System.out.println("open " + html);

            // observe html
            new FileObserver(html.getFileName().toString());

            XML xml = I.xml(html);

            // observe js
            for (XML js : xml.find("script")) {
                String src = js.attr("src");

                if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("https://")) {
                    new FileObserver(src);
                }
            }

            // observe css
            for (XML css : xml.find("link[rel=stylesheet]")) {
                String src = css.attr("href");

                if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("https://")) {
                    new FileObserver(src);
                }
            }
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
         * {@inheritDoc}
         */
        @Override
        public void onMessage(String data) {
            System.out.println("message  " + data);
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
        private class FileObserver implements PathListener {

            /** The original path. */
            protected final String path;

            /** The target. */
            protected final Path file;

            /**
             * @param file
             */
            private FileObserver(String path) {
                this.path = path;
                this.file = html.resolveSibling(path);

                observers.add(I.observe(file, this));
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public final void create(Path path) {
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public final void delete(Path path) {
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public final void modify(Path path) {
                send(this.path);
            }
        }
    }
}
