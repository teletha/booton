/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.concurrent.CopyOnWriteArraySet;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/11 11:48:40
 */
@RunWith(ScriptRunner.class)
public class CopyOnWriteArraySetTest {

    @Test
    public void add() throws Exception {
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
        assert set.add(1);
        assert set.add(2);
        assert !set.add(1);
    }
}
