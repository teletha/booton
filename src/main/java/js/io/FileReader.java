/*
 * Copyright (C) 2016 Nameless Production Committee
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
 * @version 2014/04/25 10:17:14
 */
@JavaAPIProvider(java.io.FileReader.class)
class FileReader extends Reader {

    /**
     * {@inheritDoc}
     */
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws IOException {
    }
}
