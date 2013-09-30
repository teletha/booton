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

import java.util.ArrayDeque;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/25 17:10:43
 */
@RunWith(ScriptRunner.class)
public class ArrayDequeTest {

    @Test
    public void peek() throws Exception {
        ArrayDeque deque = create();
        assert deque.size() == 4;
        assert deque.peek().equals("1");
        assert deque.peekFirst().equals("1");
        assert deque.peekLast().equals("4");
        assert deque.size() == 4;
    }

    @Test
    public void poll() throws Exception {
        ArrayDeque deque = create();
        assert deque.size() == 4;
        assert deque.poll().equals("1");
        assert deque.size() == 3;
        assert deque.pollFirst().equals("2");
        assert deque.size() == 2;
        assert deque.pollLast().equals("4");
        assert deque.size() == 1;
    }

    @Test
    public void add() throws Exception {
        ArrayDeque deque = new ArrayDeque();
        assert deque.size() == 0;
        assert deque.add("1");
        assert deque.size() == 1;
        assert deque.peekLast().equals("1");

        assert deque.add("2");
        assert deque.size() == 2;
        assert deque.peekLast().equals("2");
    }

    @Test
    public void remove() throws Exception {
        ArrayDeque deque = create();
        assert deque.remove("1");
        assert deque.size() == 3;
        assert deque.peekFirst().equals("2");

        assert deque.remove("4");
        assert deque.size() == 2;
        assert deque.peekLast().equals("3");
    }

    @Test
    public void contains() throws Exception {
        ArrayDeque deque = create();
        assert deque.contains("3");
        assert deque.contains("4");
        assert !deque.contains("none");
    }

    @Test
    public void iterator() throws Exception {
        Iterator iterator = create().iterator();
        assert iterator.hasNext();
        assert iterator.next().equals("1");
        assert iterator.hasNext();
        assert iterator.next().equals("2");
        assert iterator.hasNext();
        assert iterator.next().equals("3");
        assert iterator.hasNext();
        assert iterator.next().equals("4");
        assert !iterator.hasNext();
    }

    @Test
    public void descendingIterator() throws Exception {
        Iterator iterator = create().descendingIterator();
        assert iterator.hasNext();
        assert iterator.next().equals("4");
        assert iterator.hasNext();
        assert iterator.next().equals("3");
        assert iterator.hasNext();
        assert iterator.next().equals("2");
        assert iterator.hasNext();
        assert iterator.next().equals("1");
        assert !iterator.hasNext();
    }

    @Test
    public void iteratorRemove() throws Exception {
        ArrayDeque deque = create();
        Iterator iterator = deque.iterator();
        assert iterator.hasNext();
        assert iterator.next().equals("1");
        assert iterator.hasNext();
        assert iterator.next().equals("2");

        assert deque.contains("2");
        iterator.remove();
        assert !deque.contains("2");
    }

    @Test(expected = IllegalStateException.class)
    public void iteratorRemoves() throws Exception {
        Iterator iterator = create().iterator();
        assert iterator.next().equals("1");
        assert iterator.next().equals("2");

        iterator.remove();
        iterator.remove();
    }

    /**
     * <p>
     * Helper method to create {@link ArrayDeque}.
     * </p>
     * 
     * @return
     */
    private ArrayDeque<String> create() {
        ArrayDeque deque = new ArrayDeque();

        deque.add("1");
        deque.add("2");
        deque.add("3");
        deque.add("4");

        return deque;
    }
}
