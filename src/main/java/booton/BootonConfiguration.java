/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.nio.file.Files;
import java.nio.file.Path;

import jsx.application.ApplicationTheme;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2014/03/09 13:06:59
 */
@Manageable(lifestyle = Singleton.class)
public class BootonConfiguration {

    /** The outpu root directory. */
    public Path root;

    /** The application design. */
    public Class<? extends ApplicationTheme> design;

    /** The code compression flag. */
    public boolean compression = false;

    /**
     * <p>
     * Validate this configuration.
     * </p>
     */
    void validate(BootonConfiguration config) {
        if (config != null) {
            // copy configuration
            root = config.root;
            design = config.design;
            compression = config.compression;
        }

        validateRoot();
        validateTheme();
    }

    /**
     * <p>
     * Validate the root directory of build process.
     * </p>
     */
    private void validateRoot() {
        if (root == null) {
            root = I.locate("");
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
        if (design == null) {
            design = ApplicationTheme.class;
        }
    }
}
