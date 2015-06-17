/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.ArrayList;
import java.util.Iterator;
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
    public void constructor() throws Exception {
        ArrayList list = new ArrayList();
        assert list.size() == 0;
    }

    @Test
    public void constructorSize() throws Exception {
        ArrayList list = new ArrayList(10);
        assert list.size() == 0;
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorNegativeSize() throws Exception {
        new ArrayList(-1);
    }

    @Test
    public void constructorFromOtherCollection() throws Exception {
        ArrayList<String> list = new ArrayList(Arrays.asList("one", "two", "three"));
        assert list.size() == 3;
    }

    // @Test(expected = NullPointerException.class)
    // public void constructorFromNull() throws Exception {
    // new ArrayList(null);
    // }

    @Test
    public void add() throws Exception {
        ArrayList<String> list = list();
        list.add("four");
        assert list.get(3).equals("four");

        list.add(1, "insert");
        assert list.get(0).equals("one");
        assert list.get(1).equals("insert");
        assert list.get(2).equals("two");

        list.add(2, null);
        assert list.get(1).equals("insert");
        assert list.get(2) == null;
        assert list.get(3).equals("two");

        list.add(list.size(), "last");
        assert list.get(6).equals("last");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addUnderflow() throws Exception {
        list().add(-1, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addOverflow() throws Exception {
        ArrayList<String> list = list();
        list.add(list.size() + 1, null);
    }

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

    @Test
    public void iteratorRemove() throws Exception {
        ArrayList<String> list = list();
        Iterator<String> iterator = list.iterator();
        assert iterator.hasNext();
        assert iterator.next().equals("one");
        iterator.remove();
        assert list.size() == 2;

        assert iterator.hasNext();
        assert iterator.next().equals("two");
        iterator.remove();
        assert list.size() == 1;

        assert iterator.hasNext();
        assert iterator.next().endsWith("three");
        iterator.remove();
        assert list.size() == 0;
    }

    @Test
    public void removeIf() throws Exception {
        ArrayList<String> list = list();
        list.removeIf(item -> item.length() == 3);
        assert list.size() == 1;
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
