/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.net;

import java.net.URISyntaxException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:03:20
 */
@JavaAPIProvider(java.net.URI.class)
class URI {

    /**
     * Creates a URI by parsing the given string.
     * <p>
     * This convenience factory method works as if by invoking the {@link #URI(String)} constructor;
     * any {@link URISyntaxException} thrown by the constructor is caught and wrapped in a new
     * {@link IllegalArgumentException} object, which is then thrown.
     * <p>
     * This method is provided for use in situations where it is known that the given string is a
     * legal URI, for example for URI constants declared within in a program, and so it would be
     * considered a programming error for the string not to parse as such. The constructors, which
     * throw {@link URISyntaxException} directly, should be used situations where a URI is being
     * constructed from user input or from some other source that may be prone to errors.
     * </p>
     *
     * @param str The string to be parsed into a URI
     * @return The new URI
     * @throws NullPointerException If {@code str} is {@code null}
     * @throws IllegalArgumentException If the given string violates RFC&nbsp;2396
     */
    public static URI create(String str) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
