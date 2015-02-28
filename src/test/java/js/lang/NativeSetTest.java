/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2015/02/28 14:27:23
 */
@RunWith(ScriptRunner.class)
public class NativeSetTest {

    @Test
    public void add() {
        NativeSet<String> set = new NativeSet();
        assert set.has("1") == false;

        set.add("1");
        assert set.has("1") == true;
    }

    @Test
    public void delete() {
        NativeSet<String> set = new NativeSet();
        assert set.delete("1") == false;

        set.add("1");
        assert set.delete("1") == true;
    }

    @Test
    public void clear() {
        NativeSet<String> set = new NativeSet();
        set.add("1");
        set.add("2");
        assert set.size() == 2;

        set.clear();
        assert set.size() == 0;
    }

    @Test
    public void forEach() {
        NativeSet<Integer> set = new NativeSet();
        set.add(1);
        set.add(2);
        set.add(3);

        AtomicInteger sum = new AtomicInteger();
        set.forEach(value -> sum.addAndGet(value));
        assert sum.get() == 6;
    }
}
