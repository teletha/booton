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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/09 0:44:17
 */
@RunWith(ScriptRunner.class)
public class UnmodifiableSetTest {

    @Test
    public void size() throws Exception {
        Set<String> set = new HashSet();
        Set<String> unmodifiable = Collections.unmodifiableSet(set);

        assert set.size() == 0;
        assert unmodifiable.size() == 0;

        set.add("");
        assert set.size() == 1;
        assert unmodifiable.size() == 1;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() throws Exception {
        Collections.unmodifiableSet(new HashSet()).add("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() throws Exception {
        Collections.unmodifiableSet(new HashSet()).remove("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() throws Exception {
        Collections.unmodifiableSet(new HashSet()).addAll(new HashSet());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() throws Exception {
        Collections.unmodifiableSet(new HashSet()).removeAll(new HashSet());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() throws Exception {
        Collections.unmodifiableSet(new HashSet()).clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator() throws Exception {
        Collections.unmodifiableSet(new HashSet()).iterator().remove();
    }
}
