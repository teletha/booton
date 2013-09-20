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

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/08 11:14:37
 */
@RunWith(ScriptRunner.class)
public class CharacterTest {

    @Test
    public void isAlphabetic() throws Exception {
        assert Character.isAlphabetic('a');
        assert Character.isAlphabetic('z');
        assert Character.isAlphabetic('A');
        assert Character.isAlphabetic('Z');
        assert !Character.isAlphabetic('1');
        assert !Character.isAlphabetic('$');
        assert !Character.isAlphabetic(':');
        assert !Character.isAlphabetic(',');
        assert !Character.isAlphabetic(' ');
    }
}