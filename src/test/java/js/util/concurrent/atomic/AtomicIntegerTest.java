/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/12/30 13:20:32
 */
@RunWith(ScriptRunner.class)
public class AtomicIntegerTest {

    @Test
    public void accessor() throws Exception {
        AtomicInteger value = new AtomicInteger();
        assert value.get() == 0;

        value.set(10);
        assert value.get() == 10;

        value.set(20);
        assert value.get() == 20;
    }

    @Test
    public void compareAndSet() throws Exception {
        AtomicInteger value = new AtomicInteger();
        assert value.compareAndSet(0, 10);
        assert value.get() == 10;

        assert !value.compareAndSet(20, 30);
        assert value.get() == 10;
    }

    @Test
    public void weakCompareAndSet() throws Exception {
        AtomicInteger value = new AtomicInteger();
        assert value.weakCompareAndSet(0, 10);
        assert value.get() == 10;

        assert !value.weakCompareAndSet(20, 30);
        assert value.get() == 10;
    }

    @Test
    public void lazySet() throws Exception {
        AtomicInteger value = new AtomicInteger();
        value.lazySet(20);
        assert value.get() == 20;
    }

    @Test
    public void getAndSet() throws Exception {
        AtomicInteger value = new AtomicInteger();
        assert value.getAndSet(10) == 0;
        assert value.getAndSet(20) == 10;
    }
}
