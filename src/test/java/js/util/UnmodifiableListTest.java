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
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/09 0:43:41
 */
@RunWith(ScriptRunner.class)
public class UnmodifiableListTest {

    @Test
    public void size() throws Exception {
        List<String> list = new ArrayList();
        List<String> unmodifiable = Collections.unmodifiableList(list);

        assert list.size() == 0;
        assert unmodifiable.size() == 0;

        list.add("");
        assert list.size() == 1;
        assert unmodifiable.size() == 1;
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add() throws Exception {
        Collections.unmodifiableList(new ArrayList()).add("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addIndex() throws Exception {
        Collections.unmodifiableList(new ArrayList()).add(0, "");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() throws Exception {
        Collections.unmodifiableList(new ArrayList()).remove("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeIndex() throws Exception {
        Collections.unmodifiableList(new ArrayList()).remove(0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll() throws Exception {
        Collections.unmodifiableList(new ArrayList()).addAll(new ArrayList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAllIndex() throws Exception {
        Collections.unmodifiableList(new ArrayList()).addAll(0, new ArrayList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeAll() throws Exception {
        Collections.unmodifiableList(new ArrayList()).removeAll(new ArrayList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear() throws Exception {
        Collections.unmodifiableList(new ArrayList()).clear();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator() throws Exception {
        Collections.unmodifiableList(new ArrayList()).iterator().remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorAdd() throws Exception {
        Collections.unmodifiableList(new ArrayList()).listIterator().add("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorRemove() throws Exception {
        Collections.unmodifiableList(new ArrayList()).listIterator().remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIteratorSet() throws Exception {
        Collections.unmodifiableList(new ArrayList()).listIterator().set("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void set() throws Exception {
        Collections.unmodifiableList(new ArrayList()).set(0, "");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subListAdd() throws Exception {
        List list = new ArrayList();
        list.add("1");
        list.add("2");

        Collections.unmodifiableList(list).subList(0, 1).add("a");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subListRemove() throws Exception {
        List list = new ArrayList();
        list.add("1");
        list.add("2");

        Collections.unmodifiableList(list).subList(0, 1).remove(0);
    }
}
