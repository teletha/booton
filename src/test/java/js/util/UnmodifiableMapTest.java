/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/09 0:44:11
 */
@RunWith(ScriptRunner.class)
public class UnmodifiableMapTest {

    @Test
    public void size() throws Exception {
        Map set = new HashMap();
        Map unmodifiable = Collections.unmodifiableMap(set);

        assert set.size() == 0;
        assert unmodifiable.size() == 0;

        set.put("name", "value");
        assert set.size() == 1;
        assert unmodifiable.size() == 1;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() throws Exception {
        Collections.unmodifiableMap(new HashMap()).put("name", "value");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() throws Exception {
        Collections.unmodifiableMap(new HashMap()).remove("name");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() throws Exception {
        Collections.unmodifiableMap(new HashMap()).putAll(new HashMap());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() throws Exception {
        Collections.unmodifiableMap(new HashMap()).clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void keySetAdd() throws Exception {
        Collections.unmodifiableMap(new HashMap()).keySet().add("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void keySetRemove() throws Exception {
        Collections.unmodifiableMap(new HashMap()).keySet().remove("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void keySetIterator() throws Exception {
        Collections.unmodifiableMap(new HashMap()).keySet().iterator().remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void valuesAdd() throws Exception {
        Collections.unmodifiableMap(new HashMap()).values().add("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void valuesRemove() throws Exception {
        Collections.unmodifiableMap(new HashMap()).values().remove("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void valuesIterator() throws Exception {
        Collections.unmodifiableMap(new HashMap()).values().iterator().remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void entrySetAdd() throws Exception {
        Collections.unmodifiableMap(new HashMap()).entrySet().add("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void entrySetRemove() throws Exception {
        Collections.unmodifiableMap(new HashMap()).entrySet().remove("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void entrySetIterator() throws Exception {
        Collections.unmodifiableMap(new HashMap()).entrySet().iterator().remove();
    }
}
