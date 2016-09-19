/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/12/30 13:20:32
 */
@RunWith(ScriptRunner.class)
public class AtomicBooleanTest {

    @Test
    public void accessor() throws Exception {
        AtomicBoolean value = new AtomicBoolean();
        assert !value.get();

        value.set(true);
        assert value.get();

        value.set(false);
        assert !value.get();
    }

    @Test
    public void compareAndSet() throws Exception {
        AtomicBoolean value = new AtomicBoolean();
        assert value.compareAndSet(false, true);

        value.set(true);
        assert !value.compareAndSet(false, false);
    }

    @Test
    public void weakCompareAndSet() throws Exception {
        AtomicBoolean value = new AtomicBoolean();
        assert value.weakCompareAndSet(false, true);

        value.set(true);
        assert !value.weakCompareAndSet(false, false);
    }

    @Test
    public void lazySet() throws Exception {
        AtomicBoolean value = new AtomicBoolean();
        value.lazySet(true);
        assert value.get();
    }

    @Test
    public void getAndSet() throws Exception {
        AtomicBoolean value = new AtomicBoolean();
        assert !value.getAndSet(true);
        assert value.getAndSet(false);
        assert !value.get();
    }
}
