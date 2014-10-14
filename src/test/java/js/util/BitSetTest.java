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

    @Test
    public void setByRange() throws Exception {
        BitSet set = new BitSet();
        set.set(0, 3);

        assert set.get(0) == true;
        assert set.get(1) == true;
        assert set.get(2) == true;
        assert set.get(3) == false;
    }

    @Test
    public void cardinality() throws Exception {
        BitSet set = new BitSet();
        assert set.cardinality() == 0;

        set.set(0);
        assert set.cardinality() == 1;

        set.set(2);
        assert set.cardinality() == 2;
    }

    @Test
    public void flip() throws Exception {
        BitSet set = new BitSet();
        assert set.get(0) == false;

        set.flip(0);
        assert set.get(0) == true;

        set.flip(0);
        assert set.get(0) == false;
    }
}
