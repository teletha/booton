/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import org.junit.Test;

import booton.translator.api.ObjectScript;

/**
 * @version 2012/11/30 15:33:13
 */
public class NullTest extends ScriptTranslatorTestcase {

    @Test
    public void Null() {
        test(new ObjectScript() {

            public Object act(Object value) {
                return null;
            }
        });
    }
}
