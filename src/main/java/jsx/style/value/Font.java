/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * @version 2014/11/15 14:27:13
 */
public class Font {

    /** The used fonts. */
    public static final Set<Font> used = new HashSet();

    /** The font name. */
    public final String name;

    /** The font uri. */
    public final String uri;

    /**
     * @param Title
     * @param uri
     */
    public Font(String uri) {
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
        if (obj instanceof Font) {
            Font other = (Font) obj;

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
