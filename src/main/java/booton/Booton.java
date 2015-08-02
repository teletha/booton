/*
 * Copyright (C) 2015 Nameless Production Committee
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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import booton.css.CascadingStyleSheet;
import booton.live.LiveCoding;
import booton.live.LiveCodingServlet;
import booton.live.ResourceServlet;
import booton.translator.Javascript;
import booton.util.HTMLWriter;
import jsx.ui.samaple.todo.HelloWorld;
import kiss.I;
import kiss.XML;

/**
 * @version 2014/03/09 13:08:45
 */
public class Booton {

    /** The file name for build phase. */
    public static final String BuildPhase = ".building";

    /** The configuration. */
    private final BootonConfiguration config = I.make(BootonConfiguration.class);

    /** The application class. */
    private final Class application;

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
    public Booton(Class application) {
        this(application, null);
    }

    /**
     * <p>
     * Booton web application builder.
     * </p>
     */
    public Booton(Class application, BootonConfiguration config) {
        this.config.validate(config);

        this.application = application;
    }

    /**
     * <p>
     * Launch live coding server.
     * </p>
     * 
     * @param port
     */
    public void launch() {
        if (requireServer()) {
            try {
                ServletContextHandler servletHandler = new ServletContextHandler();
                servletHandler.addServlet(new ServletHolder(new LiveCodingServlet(config.root)), "/live/*");
                servletHandler.addServlet(new ServletHolder(new ResourceServlet(config.root)), "/*");

                Server server = new Server(config.port);
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
    private boolean requireServer() {
        ServerSocket socket = null;

        try {
            socket = new ServerSocket(config.port);

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
        Path root = config.root;

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
            if (Files.notExists(mutex)) {
                Files.createFile(mutex);
            }

            // build html file
            buildHTML();

            Set set = new HashSet();

            // build js file
            Javascript.getScript(application).writeTo(js, set);

            // Don't build live coding script out of build process, because all scripts must share
            // compiled and obfuscated class information.
            Javascript.getScript(LiveCoding.class).writeTo(root.resolve("live.js"), set);

            // build css file
            I.make(CascadingStyleSheet.class).write(css);
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
    private void buildHTML() {
        XML html = I.xml("html");
        XML head = html.child("head");
        head.child("meta").attr("charset", "utf-8");
        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", "normalize.css");
        head.child("link").attr("type", "text/css").attr("rel", "stylesheet").attr("href", config.root.relativize(css));

        XML body = html.child("body");
        body.child("header").attr("id", "Header");
        body.child("div").attr("id", "Content");
        body.child("footer").attr("id", "Footer");

        // body.child("script").attr("type", "text/javascript").attr("src", "pointer-events.js");
        body.child("script").attr("type", "text/javascript").attr("src", "boot.js");
        body.child("script").attr("type", "text/javascript").attr("src", config.root.relativize(js));

        try {
            html.to(new HTMLWriter(Files.newBufferedWriter(this.html, I.$encoding)));
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Invocation point.
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        launch(HelloWorld.class);
    }

    /**
     * Launch application with debuggable server.
     * 
     * @param applicationClass A target application.
     */
    public static void launch(Class applicationClass) {
        Booton booton = new Booton(applicationClass);
        booton.launch();
        booton.build();
    }
}
