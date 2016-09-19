/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/20 12:16:19
 */
@RunWith(ScriptRunner.class)
public class SystemArrayCopyTest {

    private Object[] source = {"a", "b", "c"};

    @Test
    public void object() throws Exception {
        Object[] copy = new Object[source.length];
        assert copy.length == 3;
        assert copy[0] == null;
        assert copy[1] == null;
        assert copy[2] == null;

        System.arraycopy(source, 0, copy, 0, source.length);
        assert copy[0] == "a";
        assert copy[1] == "b";
        assert copy[2] == "c";
    }
}
