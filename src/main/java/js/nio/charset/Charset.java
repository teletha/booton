/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.nio.charset;

import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/08 1:23:04
 */
@JavaAPIProvider(java.nio.charset.Charset.class)
class Charset {

    /** The charset name. */
    private final String name;

    /**
     * @param name
     */
    private Charset(String name) {
        this.name = name;
    }

    /**
     * Returns this charset's canonical name.
     *
     * @return The canonical name of this charset
     */
    public final String name() {
        return name;
    }

    /**
     * Tells whether the named charset is supported.
     *
     * @param charsetName The name of the requested charset; may be either a canonical name or an
     *            alias
     * @return <tt>true</tt> if, and only if, support for the named charset is available in the
     *         current Java virtual machine
     * @throws IllegalCharsetNameException If the given charset name is illegal
     * @throws IllegalArgumentException If the given <tt>charsetName</tt> is null
     */
    public static boolean isSupported(String charsetName) {
        return true;
    }

    /**
     * Returns the default charset of this Java virtual machine.
     * <p>
     * The default charset is determined during virtual-machine startup and typically depends upon
     * the locale and charset of the underlying operating system.
     *
     * @return A charset object for the default charset
     * @since 1.5
     */
    public static Charset defaultCharset() {
        return new Charset("UTF-8");
    }

    /**
     * Returns a charset object for the named charset.
     *
     * @param name The name of the requested charset; may be either a canonical name or an alias
     * @return A charset object for the named charset
     * @throws IllegalCharsetNameException If the given charset name is illegal
     * @throws IllegalArgumentException If the given <tt>charsetName</tt> is null
     * @throws UnsupportedCharsetException If no support for the named charset is available in this
     *             instance of the Java virtual machine
     */
    public static Charset forName(String name) {
        return new Charset(name);
    }
}
