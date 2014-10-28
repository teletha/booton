/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;

import kiss.I;
import booton.translator.Translator;

/**
 * @version 2014/10/28 22:47:27
 */
public class FontFamily {

    /** The used fonts. */
    public static final Set<FontFamily> used = new HashSet();

    /**
     * <p>
     * Glyphs have finishing strokes, flared or tapering ends, or have actual serifed endings. E.g.
     * Palatino, "Palatino Linotype", Palladio, "URW Palladio", serif
     * </p>
     */
    public static final FontFamily serif = new FontFamily("serif");

    /**
     * <p>
     * Glyphs have stroke endings that are plain. E.g. 'Trebuchet MS', 'Liberation Sans', 'Nimbus
     * Sans L', sans-serif
     * </p>
     */
    public static final FontFamily sansSerif = new FontFamily("sans-serif");

    /**
     * <p>
     * Glyphs in cursive fonts generally have either joining strokes or other cursive
     * characteristics beyond those of italic typefaces. The glyphs are partially or completely
     * connected, and the result looks more like handwritten pen or brush writing than printed
     * letterwork.
     * </p>
     */
    public static final FontFamily cursive = new FontFamily("cursive");

    /**
     * <p>
     * Fantasy fonts are primarily decorative fonts that contain playful representations of
     * characters.
     * </p>
     */
    public static final FontFamily fantasy = new FontFamily("fantasy");

    /**
     * <p>
     * All glyphs have the same fixed width. E.g. "DejaVu Sans Mono", Menlo, Consolas,
     * "Liberation Mono", Monaco, "Lucida Console", monospace
     * </p>
     */
    public static final FontFamily monospace = new FontFamily("monospace");

    /** The font name. */
    public final String name;

    /** The font uri. */
    public final String uri;

    /**
     * @param Title
     * @param uri
     */
    public FontFamily(String uri) {
        String[] info = FontInfo.parse(uri);
        this.name = info[0];
        this.uri = info[1];

        used.add(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return name.hashCode() ^ uri.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FontFamily) {
            FontFamily other = (FontFamily) obj;

            return name.equals(other.name) && uri.equals(other.uri);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Font [name=" + name + ", uri=" + uri + "]";
    }

    /**
     * @version 2014/10/13 17:49:39
     */
    private static class FontInfo {

        /**
         * <p>
         * Locate font.
         * </p>
         * 
         * @param uri
         * @return
         */
        static String[] parse(String uri) {
            String[] info = new String[2];

            if (!uri.startsWith("http")) {
                info[0] = uri;
                info[1] = uri;
            } else {
                try {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    URLConnection connection = new URL(uri).openConnection();
                    connection.connect();
                    I.copy(connection.getInputStream(), out, true);

                    String contents = out.toString();
                    int start = contents.indexOf("font-family");
                    int end = contents.indexOf(";", start);

                    String name = contents.substring(start + 11, end).trim();

                    if (name.charAt(0) == ':') {
                        name = name.substring(1).trim();
                    }

                    if (name.charAt(0) == '\'') {
                        name = name.substring(1, name.length() - 1);
                    }

                    info[0] = name;
                    info[1] = uri;
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
            return info;
        }

        /**
         * @version 2014/10/13 17:55:12
         */
        @SuppressWarnings("unused")
        private static class Coder extends Translator<FontInfo> {

            /**
             * <p>
             * Locate font.
             * </p>
             * 
             * @param uri
             * @return
             */
            public String parse(String uri) {
                return "['" + uri + "','" + uri + "']";
            }
        }
    }
}
