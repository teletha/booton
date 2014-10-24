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
    protected ParsedStyle parse(Style style) {
        StyleRule rules = new StyleRule();
        PropertyDefinition.declarable = rules;

        style.declare();

        // API definition
        return new ParsedStyle(rules);
    }

    /**
     * @version 2014/10/21 14:21:36
     */
    public static class ParsedStyle {

        /** The parsed properties. */
        private final StyleRule rules;

        /**
         * @param rules
         */
        private ParsedStyle(StyleRule rules) {
            this.rules = rules;
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

            assert rules.properties.containsKey(name);
            return rules.properties.get(name).equals(value);
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

        /**
         * <p>
         * Find sub rule.
         * </p>
         * 
         * @param index
         * @return
         */
        public ParsedStyle sub(int index) {
            return new ParsedStyle(rules.children.get(index));
        }
    }
}
