/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import java.io.PrintStream;

import booton.translator.Translator;

/**
 * @version 2012/11/28 1:57:58
 */
public class PrintWriterTranslator extends Translator<PrintStream> {

    public String println(String value) {
        return that + ".log(" + param(0) + ")";
    }

    public String println(int value) {
        return that + ".log(" + param(0) + ")";
    }

    public String println(boolean value) {
        return that + ".log(" + param(0) + ")";
    }

    public String println(Object value) {
        return that + ".log(" + param(0) + ")";
    }
}
