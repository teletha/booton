/*
 * Copyright (C) 2015 Nameless Production Committee
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
import jsx.ui.Style;

/**
 * @version 2015/09/28 22:16:53
 */
public class StyleTester extends StyleDescriptor {

    protected ValidatableStyle style(Style style) {
        // empty style sheet
        StyleRule rule = StyleRule.create("$", style);

        // search specified rule
        String name = "." + style.name();

        assert rule.selector.equals(name);
        return new ValidatableStyle(rule);
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
         * <p>
         * Helper method to find {@link StyleRule} for the specified combinator or pseudo selector.
         * </p>
         * 
         * @param selector
         * @return
         */
        public ValidatableStyle sub(String selector) {
            String combinator = rules.selector + ":" + selector;
            String pseudo = rules.selector + "::" + selector;

            ValidatableStyle found = find(rules, combinator, pseudo);

            if (found != null) {
                return found;
            }
            throw new AssertionError("The rule[" + combinator + "] or [" + pseudo + "] is not found.");
        }

        /**
         * <p>
         * Helper method to find {@link StyleRule} for the specified combinator or pseudo selector.
         * </p>
         * 
         * @param rule A target {@link StyleRule}.
         * @param combinator A selector pattern.
         * @param pseudo A selector pattern.
         * @return A result.
         */
        private ValidatableStyle find(StyleRule rule, String combinator, String pseudo) {
            if (rule.selector.equals(combinator) || rule.selector.equals(pseudo)) {
                return new ValidatableStyle(rule);
            }

            for (int i = 0; i < rule.children.length(); i++) {
                ValidatableStyle found = find(rule.children.get(i), combinator, pseudo);

                if (found != null) {
                    return found;
                }
            }
            return null;
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
