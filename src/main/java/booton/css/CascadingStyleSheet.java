/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;

import jsx.style.Style;
import jsx.style.StyleName;
import jsx.style.StyleRule;
import jsx.style.value.Font;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import booton.BootonConfiguration;

/**
 * @version 2014/11/15 16:05:39
 */
@Manageable(lifestyle = Singleton.class)
public class CascadingStyleSheet {

    /** The style classes which any javascript refers. */
    private final Set<Style> styles = new LinkedHashSet();

    /**
     * <p>
     * Write css file.
     * </p>
     * 
     * @param file
     */
    public void write(Path file) throws Exception {
        Writer root = new Writer();

        // write font imports
        for (Font font : Font.used) {
            root.write("@import url(" + font.uri + ");").line();
        }

        // parse all styles and create rules.
        for (Style style : styles) {
            StyleRule.create("$", style);
        }

        // write rules
        for (StyleRule rule : StyleRule.rules) {
            if (rule.properties.size() != 0) {
                // write requested properties only.
                root.write(rule.selector, "{");

                for (int i = 0; i < rule.properties.size(); i++) {
                    root.property(rule.properties.key(i), rule.properties.value(i));
                }
                root.write("}");
            }
        }

        // make css file actually
        Files.write(file, root.toString().getBytes(I.$encoding));
    }

    /**
     * <p>
     * Register style definition.
     * </p>
     * 
     * @param style
     */
    public String register(Class clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);

            Style style = (Style) field.get(null);

            if (!styles.contains(style)) {
                styles.add(style);
            }
            return StyleName.name(style);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2014/11/15 16:06:27
     */
    private static class Writer {

        /** The optimization flag. */
        private final boolean compression = I.make(BootonConfiguration.class).compression;

        /** The actual builder. */
        private final StringBuilder builder = new StringBuilder();

        /**
         * <p>
         * Write comment for debug.
         * </p>
         * 
         * @param comment A comment.
         * @return Chainable API.
         */
        public Writer comment(Object comment) {
            if (!compression) {
                builder.append("/* ").append(comment).append(" */");
                line();
            }
            return this;
        }

        /**
         * <p>
         * Formt line for debug.
         * </p>
         * 
         * @return Chainable API.
         */
        public Writer line() {
            if (!compression) {
                builder.append("\r\n");
            }
            return this;
        }

        /**
         * <p>
         * Formt indent for debug.
         * </p>
         * 
         * @return Chainable API.
         */
        public Writer indent() {
            if (!compression) {
                builder.append("  ");
            }
            return this;
        }

        /**
         * <p>
         * Helper method to write css.
         * </p>
         * 
         * @param params
         * @return Chainable API.
         */
        public Writer write(String... params) {
            for (String param : params) {
                if (param != null) {
                    if (!compression) {
                        switch (param) {
                        case "{":
                            builder.append(" ");
                            break;
                        }
                    }

                    builder.append(param);

                    if (!compression) {
                        switch (param) {
                        case ":":
                            builder.append(" ");
                            break;

                        case ";":
                        case "{":
                            line();
                            break;

                        case "}":
                            line().line();
                            break;
                        }
                    }
                }
            }
            return this;
        }

        /**
         * <p>
         * Declare the specified property.
         * </p>
         * 
         * @param name A property name.
         * @param value A property value.
         */
        public void property(String name, String value) {
            indent().write(name, ":", value, ";");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return builder.toString();
        }
    }

}
