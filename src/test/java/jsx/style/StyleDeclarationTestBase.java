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

import java.util.Map;

import jsx.style.value.Color;

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
    protected ValidatableStyleSheet parse(Style style) {
        StyleSheet sheet = new StyleSheet();
        sheet.add(style);

        // API definition
        return new ValidatableStyleSheet(sheet, style);
    }

    /**
     * @version 2014/10/26 21:43:52
     */
    public static class ValidatableStyleSheet {

        /** The parsed styles. */
        private final StyleSheet sheet;

        /** The target style. */
        private final Style style;

        /**
         * @param sheet
         */
        private ValidatableStyleSheet(StyleSheet sheet, Style style) {
            this.sheet = sheet;
            this.style = style;
        }

        /**
         * <p>
         * Find main rule.
         * </p>
         * 
         * @return
         */
        public ValidatableStyleRule rule() {
            for (StyleRule rule : sheet.rules) {
                if (rule.name.endsWith(String.valueOf(style.hashCode()))) {
                    return new ValidatableStyleRule(sheet, rule);
                }
            }
            throw new AssertionError("The rule[STYLE" + style.hashCode() + "] is not found.");
        }

        /**
         * <p>
         * Find main rule.
         * </p>
         * 
         * @param index A rule index.
         * @return
         */
        public ValidatableStyleRule rule(int index) {
            return new ValidatableStyleRule(sheet, sheet.rules.get(index));
        }
    }

    /**
     * @version 2014/10/25 15:55:53
     */
    public static class ValidatableStyleRule {

        /** The target stylesheet. */
        private final StyleSheet sheet;

        /** The target to validate. */
        private final StyleRule rules;

        /**
         * @param rules
         */
        private ValidatableStyleRule(StyleSheet sheet, StyleRule rules) {
            this.sheet = sheet;
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

            if (value.startsWith("transparent")) {
                value = "hsla(0,0%,0%,0)";
            }

            Map<String, String> properties = rules.holder;

            assert properties.containsKey(name);
            assert properties.get(name).equals(value);
            return true;
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
         * @param selector
         * @return
         */
        public ValidatableStyleRule sub(String selector) {
            String combinator = rules.name + ":" + selector;
            String pseudo = rules.name + "::" + selector;

            for (StyleRule rule : sheet.rules) {
                if (rule.name.equals(combinator) || rule.name.equals(pseudo)) {
                    return new ValidatableStyleRule(sheet, rule);
                }
            }
            throw new AssertionError("The rule[" + combinator + "] or [" + pseudo + "] is not found.");
        }
    }
}
