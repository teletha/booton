/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import js.dom.CSSStyleSheet;

/**
 * @version 2016/09/17 9:35:49
 */
public class Font implements CharSequence {

    /**
     * Glyphs have finishing strokes, flared or tapering ends, or have actual serifed endings. E.g.
     * Palatino, "Palatino Linotype", Palladio, "URW Palladio", serif
     */
    public static final Font Serif = new Font("serif", "");

    /**
     * <p>
     * Glyphs have stroke endings that are plain. E.g. 'Trebuchet MS', 'Liberation Sans', 'Nimbus
     * Sans L', sans-serif
     * </p>
     */
    public static final Font SansSerif = new Font("sans-serif", "");

    /**
     * <p>
     * Glyphs in cursive fonts generally have either joining strokes or other cursive
     * characteristics beyond those of italic typefaces. The glyphs are partially or completely
     * connected, and the result looks more like handwritten pen or brush writing than printed
     * letterwork.
     * </p>
     */
    public static final Font Cursive = new Font("cursive", "");

    /**
     * <p>
     * Fantasy fonts are primarily decorative fonts that contain playful representations of
     * characters.
     * </p>
     */
    public static final Font Fantasy = new Font("fantasy", "");

    /**
     * <p>
     * All glyphs have the same fixed width. E.g. "DejaVu Sans Mono", Menlo, Consolas,
     * "Liberation Mono", Monaco, "Lucida Console", monospace
     * </p>
     */
    public static final Font Monospace = new Font("monospace", "");

    /** The built-in font. */
    public static final Font Awesome = new Font("FontAwesome", "https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css");

    /** The font name. */
    public final String name;

    /** The font uri. */
    public final String uri;

    /**
     * <p>
     * Create font with name and uri.
     * </p>
     * 
     * @param name A font name.
     * @param uri A font uri.
     */
    public Font(String name, String uri) {
        this.name = name;
        this.uri = uri;

        CSSStyleSheet.define(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int length() {
        return name.length();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char charAt(int index) {
        return name.charAt(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CharSequence subSequence(int start, int end) {
        return name.substring(start, end);
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
        return name;
    }

    /**
     * <p>
     * Load from <a href="https://www.google.com/fonts">Google Fonts</a>.
     * </p>
     * 
     * @param name A name of font to load.
     * @param params A list of extra parameters.
     * @return A loaded font.
     */
    public static Font fromGoogle(String name, String... params) {
        StringBuilder builder = new StringBuilder("http://fonts.googleapis.com/css?family=");
        builder.append(name.replaceAll("\\s", "+"));

        if (params != null && params.length != 0) {
            builder.append(":");

            for (String param : params) {
                builder.append(param).append(",");
            }
        }
        return new Font(name, builder.toString());
    }
}
