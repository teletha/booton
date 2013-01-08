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
import java.nio.file.Files;
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
            new HTMLObserver(html.getFileName().toString());

            XML xml = I.xml(html);

            // observe js
            for (XML js : xml.find("script")) {
                String src = js.attr("src");

                if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("https://")) {
                    new JSObserver(src);
                }
            }

            // observe css
            for (XML css : xml.find("link[rel=stylesheet]")) {
                String src = css.attr("href");

                if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("https://")) {
                    new CSSObserver(src);
                }
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClose(int closeCode, String message) {
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
            try {
                connection.sendMessage(message);
            } catch (IOException e) {
                throw I.quiet(e);
            }
        }

        /**
         * @version 2013/01/08 9:36:32
         */
        protected abstract class FileModificationObserver implements PathListener {

            /** The original path. */
            protected final String path;

            /** The target. */
            protected final Path file;

            /** The last modified time. */
            private long last;

            /**
             * @param file
             */
            protected FileModificationObserver(String path) {
                try {
                    this.path = path;
                    this.file = html.resolveSibling(path);
                    this.last = Files.getLastModifiedTime(file).toMillis();

                    observers.add(I.observe(file, this));
                } catch (IOException e) {
                    throw I.quiet(e);
                }
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
                try {
                    long current = Files.getLastModifiedTime(path).toMillis();

                    if (last + 1000 < current) {
                        last = current;
                        modify();
                    }
                } catch (IOException e) {
                    throw I.quiet(e);
                }
            }

            /**
             * <p>
             * Invoke whenever the target file is modified.
             * </p>
             */
            protected abstract void modify();
        }

        /**
         * @version 2013/01/08 2:00:00
         */
        private class HTMLObserver extends FileModificationObserver {

            /**
             * @param file
             */
            private HTMLObserver(String file) {
                super(file);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            protected void modify() {
                System.out.println("modify " + file);

                send(path);
            }
        }

        /**
         * @version 2013/01/08 2:00:00
         */
        private class JSObserver extends FileModificationObserver {

            /**
             * @param file
             */
            private JSObserver(String file) {
                super(file);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            protected void modify() {
                System.out.println("modify " + file);

                send(path);
            }
        }

        /**
         * @version 2013/01/08 2:00:00
         */
        private class CSSObserver extends FileModificationObserver {

            /**
             * @param file
             */
            private CSSObserver(String file) {
                super(file);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            protected void modify() {
                System.out.println("modify " + file);

                send(path);
            }
        }
    }
}
