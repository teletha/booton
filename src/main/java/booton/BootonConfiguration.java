/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import filer.Filer;
import jsx.ApplicationTheme;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2016/12/04 13:04:43
 */
@Manageable(lifestyle = Singleton.class)
public class BootonConfiguration {

    /** The outpu root directory. */
    public Path root;

    /** The application theme. */
    public Class<? extends ApplicationTheme> theme;

    /** The code compression flag. */
    public boolean compression = false;

    /** The port of live coding server. */
    public int port = 10021;

    /**
     * <p>
     * Validate this configuration.
     * </p>
     */
    void validate(BootonConfiguration config) {
        if (config != null && this != config) {
            // copy configuration
            root = config.root;
            port = config.port;
            theme = config.theme;
            compression = config.compression;
        }

        validatePort();
        validateRoot();
        validateTheme();
    }

    /**
     * <p>
     * Validate configuration.
     * </p>
     */
    private void validatePort() {
        if (port <= 1024) {
            port = 1025;
        }

        if (65535 < port) {
            port = 65535;
        }
    }

    /**
     * <p>
     * Validate the root directory of build process.
     * </p>
     */
    private void validateRoot() {
        if (root == null) {
            root = Filer.locate("");
        }

        if (Files.notExists(root)) {
            try {
                Files.createDirectories(root);
            } catch (IOException e) {
                throw I.quiet(e);
            }
        }

        if (Files.isRegularFile(root)) {
            root = root.getParent();
        }

        if (!root.isAbsolute()) {
            root = root.toAbsolutePath();
        }
    }

    /**
     * <p>
     * Validate Application theme.
     * </p>
     */
    private void validateTheme() {
        if (theme == null) {
            theme = ApplicationTheme.class;
        }
    }
}
