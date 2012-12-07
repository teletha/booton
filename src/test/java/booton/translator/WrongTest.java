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

/**
 * @version 2012/12/07 12:34:26
 */
public class WrongTest extends ScriptTester {

    @Test
    public void testname() throws Exception {
        test(new Scriptable() {

            public int act(String value) {
                return 31 + (value == null ? 0 : value.length());
            }
        });
    }
}
