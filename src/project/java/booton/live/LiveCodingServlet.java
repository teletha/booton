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
            System.out.println("open " + html);

            // observe html
            observers.add(I.observe(html, new HTMLObserver()));

            XML xml = I.xml(html);

            // observe js
            for (XML js : xml.find("script")) {
                String src = js.attr("src");

                if (src.length() != 0) {
                    Path path = html.getParent().resolve(src);
                    System.out.println(path);
                    observers.add(I.observe(path, new JSListener()));
                }
            }

            // observe css
            for (XML css : xml.find("link[rel=stylesheet]")) {
                String src = css.attr("href");

                if (src.length() != 0) {
                    Path path = html.getParent().resolve(src);
                    System.out.println(path);
                    observers.add(I.observe(path, new CSSListener()));
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
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onMessage(String data) {
            System.out.println("message  " + data);
        }

        /**
         * @version 2013/01/08 1:56:48
         */
        private class HTMLObserver implements PathListener {

            /**
             * {@inheritDoc}
             */
            @Override
            public void create(Path path) {
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void delete(Path path) {
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void modify(Path path) {
                System.out.println("modify html " + path);
            }
        }

        /**
         * @version 2013/01/08 2:00:00
         */
        private class JSListener extends HTMLObserver {

            /**
             * {@inheritDoc}
             */
            @Override
            public void modify(Path path) {
                System.out.println("modify js " + path);
            }
        }

        /**
         * @version 2013/01/08 2:00:00
         */
        private class CSSListener extends HTMLObserver {

            /**
             * {@inheritDoc}
             */
            @Override
            public void modify(Path path) {
                System.out.println("modify css " + path);
            }
        }
    }
}
