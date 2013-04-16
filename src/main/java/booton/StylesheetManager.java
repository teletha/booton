/*
 * Copyright (C) 2012 Nameless Production Committee
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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import booton.css.CSS;
import booton.css.Combine;
import booton.translator.Literal;
import booton.util.Font;

/**
 * @version 2012/12/23 17:27:55
 */
@Manageable(lifestyle = Singleton.class)
public class StylesheetManager implements Literal<CSS> {

    /** The used web fonts. */
    private static final Set<Font> fonts = new HashSet();

    /** The used styles. */
    private final Set<Class<? extends CSS>> used = new LinkedHashSet();

    /**
     * <p>
     * Write css file.
     * </p>
     * 
     * @param file
     */
    public void write(Path file) throws Exception {
        // collect defined styles
        // Table<Class, CSS> cascading = new Table();
        //
        // for (CSS style : I.find(CSS.class)) {
        // System.out.println(style.getClass().getName());
        // Class type = style.getClass();
        //
        // while (type != CSS.class) {
        // cascading.push(type, style);
        //
        // type = type.getSuperclass();
        // }
        // }

        // collect required styles
        Set<CSS> required = new LinkedHashSet();

        for (Class<? extends CSS> type : used) {
            required.add(I.make(type));
        }

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

    public static void register(Font font) {
        fonts.add(font);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String write(Class<? extends CSS> clazz) {
        Set<Class<? extends CSS>> styles = new LinkedHashSet();

        collectStyle(clazz, styles);

        used.addAll(styles);

        StringBuilder builder = new StringBuilder();
        for (Class<? extends CSS> style : styles) {
            builder.append(Obfuscator.computeCSSName(style)).append(' ');
        }

        return '"' + builder.toString().trim() + '"';
    }

    /**
     * <p>
     * Collect combined style.
     * </p>
     * 
     * @param clazz
     * @param set
     */
    private void collectStyle(Class<? extends CSS> clazz, Set<Class<? extends CSS>> set) {
        if (clazz != null && set.add(clazz)) {
            Combine combine = clazz.getAnnotation(Combine.class);

            if (combine != null) {
                for (Class<? extends CSS> style : combine.value()) {
                    collectStyle(style, set);
                }
            }
        }
    }
}
