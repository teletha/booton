/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kiss.I;
import kiss.XML;
import booton.Booton;
import booton.util.HTMLWriter;

/**
 * @version 2014/03/07 10:22:55
 */
@SuppressWarnings("serial")
public class ResourceServlet extends HttpServlet {

    /** The current root path. */
    private final Path root;

    /**
     * @param root
     */
    public ResourceServlet(Path root) {
        this.root = root;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String path = request.getPathInfo();

        if (path == null) {
            path = "/index.html";
        }

        waitBuilding();

        Path file = root.resolve(path.substring(1));

        if (path.endsWith(".html")) {
            rebuild(file).to(new HTMLWriter(new OutputStreamWriter(response.getOutputStream(), I.$encoding)));
        } else {
            if (path.endsWith(".css")) {
                response.addHeader("Content-Type", "text/css");
            }

            if (path.endsWith(".js")) {
                response.addHeader("Content-Type", "text/javascript");
            }
            I.copy(Files.newInputStream(file), response.getOutputStream(), true);
        }
    }

    /**
     * <p>
     * Check building phase.
     * </p>
     */
    private synchronized void waitBuilding() {
        int timer = 0;
        Path build = root.resolve(Booton.BuildPhase);

        while (timer < 10000 && Files.exists(build)) {
            try {
                timer += 100;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /**
     * <p>
     * Rebuild html file.
     * </p>
     * 
     * @param file
     */
    private synchronized XML rebuild(Path file) {
        long now = new Date().getTime();
        XML html = I.xml(file);

        // append live coding script
        html.find("script[src=\"application.js\"]").after(I.xml("script")
                .attr("type", "text/javascript")
                .attr("src", "live.js"));

        // ignore cache
        for (XML link : html.find("link[rel=stylesheet]")) {
            String href = link.attr("href");

            if (href.length() != 0 && !href.startsWith("http://") && !href.startsWith("htttps://")) {
                link.attr("href", href + "?" + now);
            }
        }

        for (XML link : html.find("script[src]")) {
            String src = link.attr("src");

            if (src.length() != 0 && !src.startsWith("http://") && !src.startsWith("htttps://")) {
                link.attr("src", src + "?" + now);
            }
        }

        return html;
    }
}
