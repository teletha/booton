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

/**
 * @version 2013/11/06 10:26:52
 */
public class CharSequenceTest {

    @Test
    public void chars() throws Exception {
        String value = "test";
        assert value.chars().count() == 4;
    }

    @Test
    public void codePoints() throws Exception {

    }
}
