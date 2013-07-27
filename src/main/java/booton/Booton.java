/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import jsx.application.Application;
import jsx.application.ApplicationTheme;
import jsx.application.Page;
import kiss.ClassListener;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.XML;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import teemowork.Teemowork;
import booton.live.LiveCoding;
import booton.live.LiveCodingServlet;
import booton.live.ResourceServlet;
import booton.translator.Javascript;
import booton.util.HTMLWriter;

/**
 * @version 2013/07/24 13:19:32
 */
public class Booton {

    /** The file name for build phase. */
    public static final String BuildPhase = ".building";

    /** The application class. */
    private final Class<? extends Application> application;

    /** The application design. */
    private final Class<? extends ApplicationTheme> design;

    /** The outpu root directory. */
    private final Path root;

    /** The html file. */
    private Path html;

    /** The javascript file. */
    private Path js;

    /** The cascading stylesheet file. */
    private Path css;

    /**
     * <p>
     * Booton web application builder.
     * </p>
     */
    public Booton(Path root, Class<? extends Application> application) {
        this(root, application, null);
    }

    /**
     * <p>
     * Booton web application builder.
     * </p>
     */
    public Booton(Path root, Class<? extends Application> application, Class<? extends ApplicationTheme> design) {
        // normalize root directory
        if (root == null) {
            root = I.locate("");
        }

        if (Files.isRegularFile(root)) {
            root = root.getParent();
        }

        this.root = root.toAbsolutePath();
        this.application = application;
        this.design = design == null ? ApplicationTheme.class : design;
    }

    /**
     * <p>
     * Launch live coding server.
     * </p>
     * 
     * @param port
     */
    public void launch(int port) {
        if (requireServer(port)) {
            try {
                ServletContextHandler servletHandler = new ServletContextHandler();
                servletHandler.addServlet(new ServletHolder(new LiveCodingServlet(root)), "/live/*");
                servletHandler.addServlet(new ServletHolder(new ResourceServlet(root)), "/*");

                Server server = new Server(port);
                server.setHandler(servletHandler);
                server.start();
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
    }

    /**
     * <p>
     * Check server existence.
     * </p>
     * 
     * @param port
     * @return
     */
    private boolean requireServer(int port) {
        ServerSocket socket = null;

        try {
            socket = new ServerSocket(port);

            return true;
        } catch (IOException e) {
            return false;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw I.quiet(e);
                }
            }
        }
    }

    /**
     * <p>
     * Build application.
     * </p>
     * 
     * @param output An output location
     */
    public void build() {
        this.html = root.resolve("index.html");
        this.js = root.resolve("application.js");
        this.css = root.resolve("application.css");

        // load booton extensions
        I.load(Booton.class, false);

        // load application extensions
        I.load(application, true);

        Path mutex = root.resolve(BuildPhase);

        try {
            // starting build phase
            Files.createFile(mutex);

            // build html file
            buildHTML();

            // build js file
            Javascript.getScript(application).writeTo(js, PageManager.getPages());

            // Don't build live coding script out of build process, because all scripts must share
            // compiled and obfuscated class information.
            Javascript.getScript(LiveCoding.class).writeTo(root.resolve("live.js"));

            // create source map
            Javascript.createSourceInfo();

            // build css file
            I.make(Stylist.class).write(css);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            // ending build phase
            I.delete(mutex);
        }
    }

    /**
     * <p>
     * Build html file.
     * </p>
     * 
     * @param file
     */
    private void buildHTML() throws Exception {
        XML html = I.xml("html");
        XML head = html.child("head");
        head.child("meta").attr("charset", "utf-8");
        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", "normalize.css");
        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", root.relativize(css));

        XML body = html.child("body");
        body.child("header").attr("id", "Header");
        body.child("div").attr("id", "Content");
        body.child("footer").attr("id", "Footer");

        body.child("script").attr("type", "text/javascript").attr("src", "jQuery.js");
        body.child("script").attr("type", "text/javascript").attr("src", "pointer-events.js");
        body.child("script").attr("type", "text/javascript").attr("src", "boot.js");
        body.child("script").attr("type", "text/javascript").attr("src", root.relativize(js));

        html.to(new HTMLWriter(Files.newBufferedWriter(this.html, I.$encoding)));
    }

    /**
     * <p>
     * Invocation point.
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        Booton booton = new Booton(null, Teemowork.class);
        booton.launch(10021);
        booton.build();
    }

    /**
     * @version 2013/01/19 10:56:11
     */
    @Manageable(lifestyle = Singleton.class)
    private static class PageManager implements ClassListener<Page> {

        /** The pages. */
        private static final List<Class<Page>> pages = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public void load(Class<Page> clazz) {
            pages.add(clazz);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void unload(Class<Page> clazz) {
            pages.remove(clazz);
        }

        /**
         * @return
         */
        private static Class[] getPages() {
            return pages.toArray(new Class[pages.size()]);
        }
    }
}
