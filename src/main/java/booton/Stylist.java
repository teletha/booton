/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

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
import booton.css.CSS;
import booton.css.CSSWriter;
import booton.css.Priority;
import booton.util.Font;

/**
 * @version 2013/07/21 15:09:13
 */
@Manageable(lifestyle = Singleton.class)
public class Stylist {

    /** The used web fonts. */
    private final Set<Font> fonts = new HashSet();

    /** The style classes which javascript reference. */
    private final List<CSS> styles = new ArrayList();

    /**
     * <p>
     * Write css file.
     * </p>
     * 
     * @param file
     */
    public void write(Path file) throws Exception {
        CSSWriter writer = new CSSWriter();

        // write font imports
        for (Font font : fonts) {
            writer.write("@import url(" + font.uri + ");").line();
        }

        // write require styles
        Collections.sort(styles, new Sorter());

        for (CSS style : styles) {
            String css = style.toString();

            if (css.length() != 0) {
                writer.comment(style.getClass().getName());
                writer.write(css);
            }
        }

        Files.write(file, writer.toString().getBytes(I.$encoding));
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
