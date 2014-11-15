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

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import jsx.style.Style;
import jsx.style.StyleName;
import jsx.style.StyleRule;
import jsx.style.StyleSheet;
import jsx.style.value.Font;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2014/10/20 16:16:42
 */
@Manageable(lifestyle = Singleton.class)
public class Stylist {

    /** The style classes which any javascript refers. */
    private final Set<Style> styles = new LinkedHashSet();

    public String write(RuleSet rule) {
        CSSWriter writer = new CSSWriter();

        // count requested properties
        int counter = 0;

        List<String> assigned = new ArrayList();

        for (String selector : rule.selectors) {
            assigned.add(rule.template.replace("$", selector));
        }

        // write requested properties only.
        writer.writeDown(I.join(",", assigned), "{");

        for (CSSProperty property : rule.properties) {
            if (property.used) {
                counter++;

                writer.property(property);
            }
        }
        writer.writeDown("}");

        if (counter == 0) {
            // this class has no properties, so we can remove it
            writer = new CSSWriter();
        }

        for (RuleSet child : rule.children) {
            writer.writeDown(write(child));
        }

        return writer.toString();
    }

    /**
     * <p>
     * Write css file.
     * </p>
     * 
     * @param file
     */
    public void write(Path file) throws Exception {
        CSSWriter root = new CSSWriter();

        // write font imports
        for (Font font : Font.used) {
            root.writeDown("@import url(" + font.uri + ");").line();
        }

        StyleSheet sheet = I.make(StyleSheet.class);

        for (Style style : styles) {
            sheet.createRule("$", style);
        }

        for (StyleRule rule : sheet.rules) {
            root.writeDown(write(rule));
        }

        Files.write(file, root.toString().getBytes(I.$encoding));
    }

    private String write(StyleRule rule) {
        CSSWriter writer = new CSSWriter();

        // count requested properties
        int counter = 0;

        // write requested properties only.
        writer.writeDown(rule.selector, "{");

        for (Entry<String, List<String>> entry : rule.holder.entrySet()) {
            for (String value : entry.getValue()) {
                counter++;
                writer.property(entry.getKey(), value);
            }
        }
        writer.writeDown("}");

        if (counter == 0) {
            // this class has no properties, so we can remove it
            writer = new CSSWriter();
        }
        return writer.toString();
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

    //
    // /**
    // * @version 2014/10/27 15:24:12
    // */
    // private static class StyleWrapper implements StyleClass {
    //
    // /** The style delegation. */
    // private final StyleClass delegater;
    //
    // /** The obfuscated name. */
    // private final String name;
    //
    // /**
    // * @param delegater
    // * @param name
    // */
    // private StyleWrapper(StyleClass delegater, String name) {
    // this.delegater = delegater;
    // this.name = name;
    // }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public void declare() {
    // delegater.declare();
    // }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public String intern() {
    // return name;
    // }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public int hashCode() {
    // return name.hashCode();
    // }
    //
    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public boolean equals(Object obj) {
    // if (obj instanceof StyleWrapper) {
    // StyleWrapper other = (StyleWrapper) obj;
    //
    // return name.equals(other.name);
    // }
    // return false;
    // }
    // }
}
