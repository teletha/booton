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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import booton.css.value.Font;

/**
 * @version 2013/07/21 15:09:13
 */
@Manageable(lifestyle = Singleton.class)
public class Stylist {

    /** The used web fonts. */
    private final Set<Font> fonts = new HashSet();

    /** The style classes which javascript reference. */
    private final List<CSS> styles = new ArrayList();

    public String write(StyleDeclaration style) {
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
        writer.write(I.join(",", assigned), "{");

        for (CSSProperty property : rule.properties) {
            if (property.used) {
                counter++;
                writer.write(property.toString());
            }
        }
        writer.write("}");

        if (counter == 0) {
            // this class has no properties, so we can remove it
            writer = new CSSWriter();
        }

        for (RuleSet child : rule.children) {
            writer.write(write(child));
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
        for (Font font : fonts) {
            root.write("@import url(" + font.uri + ");").line();
        }

        // write require styles
        Collections.sort(styles, new Sorter());

        for (CSS style : styles) {
            String css = write(style.rules);

            if (css.length() != 0) {
                root.comment(style.getClass().getName());
                root.write(css);
            }
        }

        Files.write(file, root.toString().getBytes(I.$encoding));
    }

    /**
     * <p>
     * Register font definition.
     * </p>
     * 
     * @param font
     */
    public void register(Font font) {
        if (font != null) {
            fonts.add(font);
        }
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
}
