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

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.Debuggable;
import booton.translator.ScriptRunner;

/**
 * @version 2013/11/03 14:41:38
 */
@RunWith(ScriptRunner.class)
public class LambdaTest {

    @Test
    @Debuggable
    public void lambda() throws Exception {
        List<String> values = Arrays.asList("One", "Two", "Three");
        values.replaceAll((String value) -> {
            return value + " Value";
        });

        assert values.get(0).equals("One Value");
        assert values.get(1).equals("Two Value");
        assert values.get(2).equals("Three Value");
    }
}
