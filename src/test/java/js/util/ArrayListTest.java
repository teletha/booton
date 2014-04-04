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

import java.util.ArrayList;
import java.util.ListIterator;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/02 9:42:22
 */
@RunWith(ScriptRunner.class)
public class ArrayListTest {

    @Test
    public void listIteratorSet() throws Exception {
        ArrayList<String> list = list();
        ListIterator<String> iterator = list.listIterator();
        assert iterator.hasNext();
        assert iterator.next().equals("one");

        assert iterator.hasNext();
        assert iterator.next().equals("two");

        assert list.get(1).equals("two");
        iterator.set("set");
        assert list.get(1).equals("set");

        assert iterator.hasNext();
        assert iterator.next().equals("three");
        assert !iterator.hasNext();
    }

    @Test
    public void listIteratorAdd() throws Exception {
        ArrayList<String> list = list();
        ListIterator<String> iterator = list.listIterator();
        assert iterator.hasNext();
        assert iterator.next().equals("one");

        assert iterator.hasNext();
        assert iterator.next().equals("two");

        assert list.get(1).equals("two");
        assert list.size() == 3;
        iterator.add("add");
        assert list.get(2).equals("add");
        assert list.size() == 4;

        assert iterator.hasNext();
        assert iterator.next().equals("three");
        assert !iterator.hasNext();
    }

    @Test
    public void ToString() throws Exception {
        ArrayList<String> list = list();
        assert list.toString().equals("[one, two, three]");
    }

    /**
     * <p>
     * Helper method to prepare list.
     * </p>
     * 
     * @return
     */
    private ArrayList<String> list() {
        ArrayList list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");

        return list;
    }
}
