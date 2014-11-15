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

import kiss.I;
import booton.BootonConfiguration;

/**
 * @version 2014/11/15 14:43:40
 */
public class CSSWriter {

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
    public CSSWriter comment(Object comment) {
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
    public CSSWriter line() {
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
    public CSSWriter indent() {
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
    public CSSWriter writeDown(String... params) {
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
    public void prop(String name, String value) {
        indent().writeDown(name, ":", value, ";");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return builder.toString();
    }
}
