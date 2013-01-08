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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kiss.I;
import bee.api.Project;

/**
 * @version 2013/01/05 0:16:22
 */
@SuppressWarnings("serial")
public class ResourceServlet extends HttpServlet {

    /** The current project. */
    private final Project project;

    /** The current root path. */
    private final Path root;

    /**
     * @param root
     */
    public ResourceServlet(Project project) {
        this.project = project;
        this.root = project.getRoot();
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

        Path file = root.resolve(path.substring(1));
        I.copy(Files.newInputStream(file), response.getOutputStream(), true);
    }
}
