/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import static java.lang.Integer.*;

import java.util.HashMap;
import java.util.Map;

import booton.css.value.Color;

/**
 * @version 2014/10/21 13:59:35
 */
public class StyleDeclarationTestBase {

    /**
     * <p>
     * Parse the specified style definition class.
     * </p>
     * 
     * @param definition
     * @return
     */
    protected ParsedStyle parse(Runnable style) {
        PropertyHolder holder = new PropertyHolder();
        PropertyDefinition.declarable = holder;

        style.run();

        // API definition
        return new ParsedStyle(holder);
    }

    /**
     * @version 2014/10/21 14:07:49
     */
    @SuppressWarnings("serial")
    private static class PropertyHolder extends HashMap<String, String> implements StyleDeclarable {

        /**
         * {@inheritDoc}
         */
        @Override
        public void setProperty(String name, String value) {
            put(name, value);
        }
    }

    /**
     * @version 2014/10/21 14:21:36
     */
    public static class ParsedStyle {

        /** The parsed properties. */
        private final Map<String, String> properties;

        /**
         * @param properties
         */
        private ParsedStyle(Map<String, String> properties) {
            this.properties = properties;
        }

        /**
         * @param name
         * @param value
         * @return
         */
        public boolean property(String name, String value) {
            assert name != null;
            assert value != null;

            if (value.startsWith("rgb(")) {
                value = convertRGB(value);
            }

            assert properties.containsKey(name);
            return properties.get(name).equals(value);
        }

        /**
         * <p>
         * Convert color expression.
         * </p>
         */
        private String convertRGB(String value) {
            String[] v = value.substring(4, value.length() - 1).split(",");

            return Color.rgb(parseInt(v[0].trim()), parseInt(v[1].trim()), parseInt(v[2].trim())).toString();
        }
    }
}
