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
    public FontFamily(String name, String uri) {
        this.name = name;
        this.uri = uri;
    }

}
