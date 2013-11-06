/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.lambda;

import java.util.function.Function;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/11/07 2:12:10
 */
@RunWith(ScriptRunner.class)
public class ConstructorReferenceTest {

    @Test
    public void constructor() throws Exception {
        Function<char[], String> f = String::new;
        assert f.apply(new char[] {'a', 'b', 'c'}).equals("abc");
    }

    /**
     * @version 2013/11/07 2:13:34
     */
    private static class Target {

        /**
         * 
         */
        Target() {
        }

        /**
         * @param value
         */
        Target(int value) {
        }
    }
}
