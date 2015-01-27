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

import java.util.List;

import jsx.style.value.Color;

/**
 * @version 2014/11/13 13:22:44
 */
public class StyleTester extends StyleRuleDescriptor {

    protected ValidatableStyle style(Style style) {
        // empty style sheet
        StyleRule.create("$", style);

        // search specified rule
        String name = "." + StyleId.of(style);

        for (StyleRule rule : StyleRule.rules) {
            if (rule.selector.equals(name)) {
                return new ValidatableStyle(rule);
            }
        }
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2014/11/13 13:31:06
     */
    public static class ValidatableStyle {

        /** The target to validate. */
        private final StyleRule rules;

        /**
         * @param rules
         */
        private ValidatableStyle(StyleRule rules) {
            this.rules = rules;
        }

        /**
         * @param name
         * @param value
         * @return
         */
        public boolean property(String name, String... values) {
            assert name != null;
            assert values != null;
            assert values.length != 0;

            List<String> matches = rules.properties.getAll(name);
            assert matches.size() == values.length;

            for (String value : values) {
                if (value.startsWith("rgb(")) {
                    value = convertRGB(value);
                }

                if (value.startsWith("transparent")) {
                    value = "hsla(0,0%,0%,0)";
                }
                assert matches.contains(value);
            }
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
        public ValidatableStyle sub(String selector) {
            String combinator = rules.selector + ":" + selector;
            String pseudo = rules.selector + "::" + selector;

            for (StyleRule rule : StyleRule.rules) {
                selector = rule.selector;

                if (selector.equals(combinator) || selector.equals(pseudo)) {
                    return new ValidatableStyle(rule);
                }
            }
            throw new AssertionError("The rule[" + combinator + "] or [" + pseudo + "] is not found.");
        }

        /**
         * <p>
         * Property has no prefix.
         * </p>
         */
        public boolean noPrefix() {
            return false;
        }
    }
}
