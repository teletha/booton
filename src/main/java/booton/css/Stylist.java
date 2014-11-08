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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;

import jsx.style.StyleClass;
import jsx.style.StyleName;
import jsx.style.StyleRule;
import jsx.style.StyleSheet;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import booton.css.value.Font;

/**
 * @version 2014/10/20 16:16:42
 */
@Manageable(lifestyle = Singleton.class)
public class Stylist {

    /** The style classes which javascript reference. */
    private final List<CSS> styles = new ArrayList();

    /** The style classes which any javascript refers. */
    private final List<StyleClass> styles2 = new ArrayList();

    public String write(CSS style) {
        return write(style.rules);
    }

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

        // write require styles
        Collections.sort(styles, new Sorter());

        for (CSS style : styles) {
            String css = write(style.rules);

            if (css.length() != 0) {
                root.comment(style.getClass().getName());
                root.writeDown(css);
            }
        }

        for (StyleClass item : styles2) {
            StyleSheet.add(item);
        }

        for (StyleRule rule : StyleSheet.rules) {
            root.writeDown(write(rule));
        }

        Files.write(file, root.toString().getBytes(I.$encoding));
    }

    private String write(StyleRule rule) {
        CSSWriter writer = new CSSWriter();

        // count requested properties
        int counter = 0;

        // write requested properties only.
        writer.writeDown(rule.name.replaceAll("STYLE", ".STYLE"), "{");

        for (Entry<String, String> entry : rule.holder.entrySet()) {
            counter++;
            writer.property(entry.getKey(), entry.getValue());
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
    public void register(Class<? extends CSS> style) {
        if (style != null) {
            CSS css = I.make(style);

            if (!styles.contains(css)) {
                styles.add(css);
            }
        }
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

            StyleClass style = (StyleClass) field.get(null);

            if (!styles2.contains(style)) {
                styles2.add(style);
            }
            return StyleName.name(style);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/07/21 14:42:48
     */
    private static class Sorter implements Comparator<CSS> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(CSS o1, CSS o2) {
            Priority priority1 = o1.getClass().getAnnotation(Priority.class);
            Priority priority2 = o2.getClass().getAnnotation(Priority.class);
            int value1 = priority1 == null ? 0 : priority1.value();
            int value2 = priority2 == null ? 0 : priority2.value();

            if (value1 == value2) {
                return 0;
            }
            return value1 < value2 ? -1 : 1;
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
