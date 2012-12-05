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

import java.util.Iterator;

import booton.translator.Translator;

/**
 * @version 2012/12/02 19:21:52
 */
public class IteratorTranslator extends Translator<Iterator> {

    public String next() {
        return that + ".next()";
    }

    public String hasNext() {
        return that + ".hasNext()";
    }

    public String remove() {
        return that + ".remove()";
    }
}
