/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.EnumSet;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/11/07 15:02:06
 */
@RunWith(ScriptRunner.class)
public class EnumSetTest {

    @Test
    public void noneOf() throws Exception {
        EnumSet<Flag> set = EnumSet.noneOf(Flag.class);
        assert set.isEmpty();
    }

    @Test
    public void allOf() throws Exception {
        EnumSet<Flag> set = EnumSet.allOf(Flag.class);
        assert set.size() == 3;
        assert set.contains(Flag.One);
        assert set.contains(Flag.Two);
        assert set.contains(Flag.Three);
    }

    @Test
    public void add() throws Exception {
        EnumSet<Flag> set = EnumSet.noneOf(Flag.class);
        assert set.add(Flag.One);
        assert set.size() == 1;
        assert set.contains(Flag.One);

        assert set.add(Flag.Two);
        assert set.size() == 2;
        assert set.contains(Flag.One);
        assert set.contains(Flag.Two);

        assert !set.add(Flag.One);
        assert set.size() == 2;
        assert set.contains(Flag.One);
        assert set.contains(Flag.Two);
    }

    @Test
    public void remove() throws Exception {
        EnumSet<Flag> set = EnumSet.allOf(Flag.class);
        assert set.remove(Flag.One);
        assert set.size() == 2;
        assert !set.contains(Flag.One);
        assert set.contains(Flag.Two);
        assert set.contains(Flag.Three);

        assert set.remove(Flag.Two);
        assert set.size() == 1;
        assert !set.contains(Flag.One);
        assert !set.contains(Flag.Two);
        assert set.contains(Flag.Three);

        assert !set.remove(Flag.One);
        assert set.size() == 1;
        assert !set.contains(Flag.One);
        assert !set.contains(Flag.Two);
        assert set.contains(Flag.Three);
    }

    @Test
    public void clear() throws Exception {
        EnumSet<Flag> set = EnumSet.allOf(Flag.class);
        assert !set.isEmpty();

        set.clear();
        assert set.isEmpty();
    }

    @Test
    public void iterator() throws Exception {
        EnumSet<Flag> set = EnumSet.allOf(Flag.class);
        Iterator<Flag> iterator = set.iterator();

        assert iterator.hasNext();
        assert iterator.next() == Flag.One;

        assert iterator.hasNext();
        assert iterator.next() == Flag.Two;

        assert iterator.hasNext();
        assert iterator.next() == Flag.Three;

        assert !iterator.hasNext();

        iterator.remove();
        assert !set.contains(Flag.Three);
    }

    @Test(expected = IllegalStateException.class)
    public void iteratorRemoveFirst() throws Exception {
        EnumSet<Flag> set = EnumSet.allOf(Flag.class);
        Iterator<Flag> iterator = set.iterator();
        iterator.remove();
    }

    @Test(expected = IllegalStateException.class)
    public void iteratorRemoveMultiple() throws Exception {
        EnumSet<Flag> set = EnumSet.allOf(Flag.class);
        Iterator<Flag> iterator = set.iterator();

        assert iterator.hasNext();
        assert iterator.next() == Flag.One;
        iterator.remove();
        iterator.remove();
    }

    @Test
    public void range() throws Exception {
        EnumSet<Flag> set = EnumSet.range(Flag.Two, Flag.Three);
        assert set.size() == 2;
        assert !set.contains(Flag.One);
        assert set.contains(Flag.Two);
        assert set.contains(Flag.Three);
    }

    @Test
    public void copyOf() throws Exception {
        EnumSet<Flag> set = EnumSet.copyOf(EnumSet.of(Flag.Two));
        assert set.size() == 1;
        assert !set.contains(Flag.One);
        assert set.contains(Flag.Two);
        assert !set.contains(Flag.Three);
    }

    @Test
    public void complementOf() throws Exception {
        EnumSet<Flag> set = EnumSet.complementOf(EnumSet.of(Flag.Two));
        assert set.size() == 2;
        assert set.contains(Flag.One);
        assert !set.contains(Flag.Two);
        assert set.contains(Flag.Three);
    }

    /**
     * @version 2013/11/07 15:02:59
     */
    private static enum Flag {

        One, Two, Three;
    }
}
