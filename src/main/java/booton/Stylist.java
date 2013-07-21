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
import java.util.concurrent.CopyOnWriteArrayList;

import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import booton.css.CSS;
import booton.css.Priority;
import booton.util.Font;

/**
 * @version 2013/07/20 16:57:52
 */
@Manageable(lifestyle = Singleton.class)
public class Stylist {

    /** The used web fonts. */
    private final Set<Font> fonts = new HashSet();

    /** The style classes which javascript reference. */
    private final CopyOnWriteArrayList<Class<? extends CSS>> styles = new CopyOnWriteArrayList();

    /** The style classes which stylesheet requires. */
    private final Set<Class<? extends CSS>> requires = new HashSet();

    /**
     * <p>
     * Write css file.
     * </p>
     * 
     * @param file
     */
    public void write(Path file) throws Exception {
        // collect required styles
        List<CSS> required = new ArrayList();

        for (int i = 0; i < styles.size(); i++) {
            required.add(I.make(styles.get(i)));
        }

        Collections.sort(required, new Comparator<CSS>() {

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
        });

        StringBuilder builder = new StringBuilder();

        // write font imports
        for (Font font : fonts) {
            builder.append("@import url(" + font.uri + ");\r\n");
        }

        // write require styles
        for (CSS style : required) {
            builder.append(style);
        }

        Files.write(file, builder.toString().getBytes(I.$encoding));
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
            styles.addIfAbsent(style);
        }
    }
}
