/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.util;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;

import kiss.I;

/**
 * @version 2012/12/23 19:49:51
 */
public class Font {

    /** The font name. */
    public final String name;

    /** The font uri. */
    public final String uri;

    /**
     * @param Title
     * @param uri
     */
    public Font(String uri) {
        if (!uri.startsWith("http")) {
            this.name = "icon";
            this.uri = uri;
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

                this.name = name;
                this.uri = uri;
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
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
}
