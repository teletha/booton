/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import static booton.css.Vendor.*;

import java.util.ArrayList;
import java.util.List;

import kiss.I;
import booton.Booton;
import booton.Obfuscator;

/**
 * @version 2013/07/24 0:37:47
 */
public class MyCSS extends CSS {

    static {
        I.load(Booton.class, false);
    }

    /** The style analyzer. */
    private static final Stylist stylist = I.make(Stylist.class);

    /**
     * <p>
     * Test property name.
     * </p>
     * 
     * @param name
     * @return
     */
    public boolean has(String name) {
        return stylist.write(this).contains(name + ":");
    }

    /**
     * <p>
     * Test property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public boolean has(String name, String value) {
        return stylist.write(this).contains(name + ": " + value + ";");
    }

    /**
     * <p>
     * Test property name with vendor prefix.
     * </p>
     * 
     * @param vendor
     * @return
     */
    public boolean has(Vendor vendor) {
        return stylist.write(this).contains(vendor.toString());
    }

    /**
     * <p>
     * Test property with vendor prefix.
     * </p>
     * 
     * @param vendor
     * @return
     */
    public boolean no(Vendor... vendors) {
        String code = stylist.write(this);

        for (Vendor vendor : vendors) {
            if (code.contains(vendor.toString())) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Test property with vendor prefix.
     * </p>
     * 
     * @param vendor
     * @return
     */
    public boolean noVendor() {
        return no(IE, Mozilla, Webkit);
    }

    /**
     * <p>
     * Count a number of selectors.
     * </p>
     * 
     * @return A number of selectors.
     */
    public int countSelector() {
        Stylesheet css = parse();
        int counter = 0;

        for (Rule rule : css.rules) {
            counter += rule.selectors.size();
        }
        return counter;
    }

    /**
     * <p>
     * Count a number of properties.
     * </p>
     * 
     * @return A number of properties.
     */
    public int countProperty() {
        Stylesheet css = parse();
        int counter = 0;

        for (Rule rule : css.rules) {
            counter += rule.properties.size();
        }
        return counter;
    }

    /**
     * <p>
     * Count a number of rules.
     * </p>
     * 
     * @return A number of rules.
     */
    public int countRule() {
        return parse().rules.size();
    }

    /**
     * <p>
     * Test selector.
     * </p>
     * 
     * @param rule
     * @param pseudo
     * @return
     */
    public boolean hasSelector(Object... fragments) {
        StringBuilder builder = new StringBuilder();

        for (Object fragment : fragments) {
            if (fragment instanceof Class) {
                builder.append(".").append(Obfuscator.computeCSSName(((Class) fragment).getName()));
            } else {
                builder.append(fragment);
            }
        }
        String selector = builder.toString();
        Stylesheet css = parse();

        for (Rule rule : css.rules) {
            if (rule.selectors.contains(selector)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Parse stylesheet outline.
     * </p>
     * 
     * @return
     */
    private Stylesheet parse() {
        return new Stylesheet(stylist.write(this));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return stylist.write(this);
    }

    /**
     * @version 2013/07/24 9:24:57
     */
    private static class Stylesheet {

        /** The rule list. */
        private List<Rule> rules = new ArrayList();

        /**
         * Parse stylesheet.
         * 
         * @param code
         */
        private Stylesheet(String code) {
            int start = 0;
            int end = code.indexOf('}');

            while (end != -1) {
                rules.add(new Rule(code.substring(start, end)));

                start = end + 1;
                end = code.indexOf('}', start);
            }
        }
    }

    /**
     * @version 2013/07/24 9:27:45
     */
    private static class Rule {

        /** The selector list. */
        private List<String> selectors = new ArrayList();

        /** The property list. */
        private List<String[]> properties = new ArrayList();

        /**
         * Parse rule set.
         * 
         * @param code
         */
        private Rule(String code) {
            int index = code.indexOf('{');

            String selectorPart = code.substring(0, index - 1).trim();
            String propertyPart = code.substring(index + 1).trim();

            // parse selector
            for (String selector : selectorPart.split(",")) {
                selectors.add(selector);
            }

            // parse property
            for (String property : propertyPart.split(";")) {
                int colon = property.indexOf(':');
                properties.add(new String[] {property.substring(0, colon - 1).trim(),
                        property.substring(colon + 1).trim()});
            }
        }
    }
}
