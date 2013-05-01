/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.builtin;

import js.lang.NativeObject;
import js.persistence.Persister;

import org.junit.Test;

/**
 * @version 2013/05/01 22:01:29
 */
public class JSONTest {

    @Test
    public void write() throws Exception {
        String text = Persister.store(new Model());

        assert Persister.restore(Model.class, text).value == 10;
    }

    private static class Model extends NativeObject {

        private int value = 10;

    }

}
