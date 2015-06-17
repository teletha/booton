/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.io;

import java.io.IOException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 11:05:24
 */
@JavaAPIProvider(java.io.Reader.class)
abstract class Reader {

    /**
     * Resets the stream. If the stream has been marked, then attempt to reposition it at the mark.
     * If the stream has not been marked, then attempt to reset it in some way appropriate to the
     * particular stream, for example by repositioning it to its starting point. Not all
     * character-input streams support the reset() operation, and some support reset() without
     * supporting mark().
     *
     * @exception IOException If the stream has not been marked, or if the mark has been
     *                invalidated, or if the stream does not support reset(), or if some other I/O
     *                error occurs
     */
    public void reset() throws IOException {
        throw new IOException("reset() not supported");
    }

    /**
     * Reads characters into a portion of an array. This method will block until some input is
     * available, an I/O error occurs, or the end of the stream is reached.
     *
     * @param cbuf Destination buffer
     * @param off Offset at which to start storing characters
     * @param len Maximum number of characters to read
     * @return The number of characters read, or -1 if the end of the stream has been reached
     * @exception IOException If an I/O error occurs
     */
    abstract public int read(char cbuf[], int off, int len) throws IOException;

    /**
     * Closes the stream and releases any system resources associated with it. Once the stream has
     * been closed, further read(), ready(), mark(), reset(), or skip() invocations will throw an
     * IOException. Closing a previously closed stream has no effect.
     *
     * @exception IOException If an I/O error occurs
     */
    abstract public void close() throws IOException;

}
