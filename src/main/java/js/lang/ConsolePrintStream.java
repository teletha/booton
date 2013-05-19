/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.io.IOException;
import java.io.OutputStream;

import booton.translator.Translator;

/**
 * @version 2013/05/19 23:03:44
 */
class ConsolePrintStream {

    /**
     * @param out
     */
    public ConsolePrintStream() {
    }

    /**
     * @version 2013/05/19 23:06:28
     */
    private static class ConsoleOutputStream extends OutputStream {

        /**
         * {@inheritDoc}
         */
        @Override
        public void write(int b) throws IOException {
        }
    }

    /**
     * @version 2013/05/19 23:07:52
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<ConsolePrintStream> {

        public String ConsolePrintStream() {
            return "console";
        }
    }
}
