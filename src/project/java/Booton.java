/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
import java.nio.file.Path;

import js.Application;
import kiss.I;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import bee.api.Command;
import bee.api.Task;
import booton.live.LiveCodingServlet;
import booton.live.ResourceServlet;

/**
 * @version 2012/12/29 12:06:39
 */
public class Booton extends Task {

    /** The server port number. */
    protected int port = 10021;

    /** The application class. */
    protected Class<? extends Application> applicationClass;

    /** The application output directory. */
    private final Path output = project.getRoot().resolve("");

    @Command("Launch live coding server.")
    public void live() {
        ui.talk("Start up live coding server. Port : ", port);
        ui.talk("");

        ServletContextHandler servletHandler = new ServletContextHandler();
        servletHandler.addServlet(new ServletHolder(new LiveCodingServlet(output)), "/live/*");
        servletHandler.addServlet(new ServletHolder(new ResourceServlet(output)), "/*");

        Server server = new Server(port);
        server.setHandler(servletHandler);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    // @Command("Build application.")
    // public void build() {
    // booton.Booton boot = new booton.Booton(output, applicationClass);
    // boot.build();
    // }
    //
    // @Command("Publish application to the external repository.")
    // public void publish() {
    //
    // }
}
