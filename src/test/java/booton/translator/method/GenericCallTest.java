/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/17 15:25:53
 */
@RunWith(ScriptRunner.class)
public class GenericCallTest {

    @Test
    public void compare() {
        String o = "b";

        assert o.compareTo("b") == 0;
        assert o.compareTo("c") == -1;
        assert o.compareTo("a") == 1;
    }

    @Test
    public void compareAsComparable() {
        Comparable o = "b";

        assert o.compareTo("b") == 0;
        assert o.compareTo("c") == -1;
        assert o.compareTo("a") == 1;
    }

    @Test
    public void compareAsComparableString() {
        Comparable<String> o = "b";

        assert o.compareTo("b") == 0;
        assert o.compareTo("c") == -1;
        assert o.compareTo("a") == 1;
    }
}
