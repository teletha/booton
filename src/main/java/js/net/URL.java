/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.net;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:03:20
 */
@JavaAPIProvider(java.net.URL.class)
class URL {
    /**
     * Returns a {@link java.net.URI} equivalent to this URL. This method functions in the same way
     * as {@code new URI (this.toString())}.
     * <p>
     * Note, any URL instance that complies with RFC 2396 can be converted to a URI. However, some
     * URLs that are not strictly in compliance can not be converted to a URI.
     *
     * @exception URISyntaxException if this URL is not formatted strictly according to to RFC2396
     *                and cannot be converted to a URI.
     * @return a URI instance equivalent to this URL.
     * @since 1.5
     */
    public URI toURI() throws URISyntaxException {
        return new URI(toString());
    }

    /**
     * Opens a connection to this {@code URL} and returns an {@code InputStream} for reading from
     * that connection. This method is a shorthand for: <blockquote><pre>
     *     openConnection().getInputStream()
     * </pre></blockquote>
     *
     * @return an input stream for reading from the URL connection.
     * @exception IOException if an I/O exception occurs.
     * @see java.net.URL#openConnection()
     * @see java.net.URLConnection#getInputStream()
     */
    public final InputStream openStream() throws java.io.IOException {
        return new ByteArrayInputStream(null);
    }
}
