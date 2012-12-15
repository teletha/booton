/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;

import kiss.I;

/**
 * @version 2012/12/13 19:18:29
 */
public class FontFamily {

    /** The font name. */
    public final String name;

    /** The font uri. */
    public final String uri;

    /**
     * @param name
     * @param uri
     */
    public FontFamily(String uri) {
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
