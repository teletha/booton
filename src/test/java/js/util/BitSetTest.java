/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.BitSet;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/06/25 19:23:28
 */
@RunWith(ScriptRunner.class)
public class BitSetTest {

    @Test
    public void get() throws Exception {
        BitSet set = new BitSet();
        assert set.get(0) == false;

        set.set(0);
        assert set.get(0) == true;
    }
}
