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

import js.dom.CSSStyleSheet;

/**
 * @version 2015/09/29 2:28:25
 */
public class Font {

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
