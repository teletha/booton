/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.ref;

import java.lang.ref.WeakReference;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/02/26 14:23:40
 */
@RunWith(ScriptRunner.class)
public class WeakReferenceTest {

    @Test
    public void get() throws Exception {
        WeakReference reference = new WeakReference("Value");
        assert reference.get().equals("Value");
    }
}
