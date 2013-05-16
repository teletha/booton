/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.io;

import java.io.OutputStream;
import java.io.PrintStream;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/05/16 16:31:56
 */
@JavaAPIProvider(PrintStream.class)
class JSPrintStream extends JSFilterOutputStream {

    /**
     * Creates a new print stream. This stream will not flush automatically.
     * 
     * @param out The output stream to which values and objects will be printed
     * @see java.io.PrintWriter#PrintWriter(java.io.OutputStream)
     */
    public JSPrintStream PrintStream(OutputStream out) {
        return null;
    }
}
