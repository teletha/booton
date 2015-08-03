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

import java.nio.file.Files;
import java.nio.file.Path;

import antibug.profiler.Profiler;
import jsx.application.ApplicationTheme;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.model.ClassUtil;

/**
 * @version 2014/03/09 13:06:59
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

    /** The build process profiling. */
    public Profiler<String, Class, Object> profiler = new Profiler<String, Class, Object>() {

        /**
         * {@inheritDoc}
         */
        @Override
        protected String name(String key1, Class key2, Object key3) {
            Path archive = key2 == null ? null : ClassUtil.getArchive(key2);

            return key1 + "(" + key2 + ")";
        }

        // /**
        // * {@inheritDoc}
        // */
        // @Override
        // protected Object group(String key1, Class key2, Object key3) {
        // Path archive = key2 == null ? null : ClassUtil.getArchive(key2);
        //
        // return Objects.hash(key1, archive);
        // }
    };

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
        if (theme == null) {
            theme = ApplicationTheme.class;
        }
    }
}
