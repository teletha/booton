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

import java.util.Iterator;
import java.util.LinkedHashSet;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/04/19 9:28:15
 */
@RunWith(ScriptRunner.class)
public class LinkedHashSetTest {

    @Test
    public void add() throws Exception {
        LinkedHashSet<String> set = new LinkedHashSet();
        set.add("a");
        set.add("b");

        assert set.size() == 2;
        assert set.contains("a");
        assert set.contains("b");
        assert set.contains("c") == false;
    }

    @Test
    public void iterator() throws Exception {
        LinkedHashSet<String> set = create();

        Iterator<String> iterator = set.iterator();
        assert iterator.next().equals("one");
        assert iterator.next().equals("two");
        assert iterator.next().equals("three");
        assert iterator.next().equals("four");
        assert iterator.next().equals("five");

        // remove
        set.remove("three");
        iterator = set.iterator();
        assert iterator.next().equals("one");
        assert iterator.next().equals("two");
        assert iterator.next().equals("four");
        assert iterator.next().equals("five");
    }

    /**
     * <p>
     * Create new set.
     * </p>
     * 
     * @return
     */
    private LinkedHashSet<String> create() {
        LinkedHashSet<String> set = new LinkedHashSet();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");

        return set;
    }
}
