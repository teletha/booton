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

import java.util.concurrent.atomic.AtomicReference;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/12/30 13:06:59
 */
@RunWith(ScriptRunner.class)
public class AtomicReferenceTest {

    @Test
    public void accessor() throws Exception {
        AtomicReference<String> reference = new AtomicReference();
        reference.set("test");

        assert reference.get().equals("test");
    }

    @Test
    public void compareAndSet() throws Exception {
        AtomicReference<String> reference = new AtomicReference();
        reference.compareAndSet(null, "test");
        assert reference.get().equals("test");

        assert reference.compareAndSet("test", "update");
        assert reference.get().equals("update");

        assert !reference.compareAndSet("don't", "apply");
        assert reference.get().equals("update");
    }

    @Test
    public void getAndSet() throws Exception {
        AtomicReference<String> reference = new AtomicReference();
        assert reference.getAndSet("test") == null;
        assert reference.getAndSet("update").equals("test");
        assert reference.get().equals("update");
    }
}
