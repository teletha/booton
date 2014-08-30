/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @version 2014/08/29 9:17:17
 */
public class DiffListTest {

    @Test
    public void insertTail() {
        assertDiff(list("a", "b"), list("a", "b", "c"), 1);
        assertDiff(list("a", "b"), list("a", "b", "c", "d"), 2);
    }

    @Test
    public void insertHead() {
        assertDiff(list("a", "b"), list("0", "a", "b"), 1);
        assertDiff(list("a", "b"), list("0", "1", "a", "b"), 2);
    }

    @Test
    public void insertMiddle() {
        assertDiff(list("a", "b"), list("a", "0", "b"), 1);
        assertDiff(list("a", "b"), list("a", "0", "1", "b"), 2);
    }

    @Test
    public void removeTail() {
        assertDiff(list("a", "b", "c"), list("a", "b"), 1);
        assertDiff(list("a", "b", "c"), list("a"), 2);
    }

    @Test
    public void removeHead() {
        assertDiff(list("a", "b", "c"), list("b", "c"), 1);
        assertDiff(list("a", "b", "c"), list("c"), 2);
    }

    @Test
    public void removeMiddle() {
        assertDiff(list("a", "b", "c"), list("a", "c"), 1);
        assertDiff(list("a", "b", "c", "d"), list("a", "d"), 2);
    }

    @Test
    public void reverse() {
        assertDiff(list("a", "b"), list("b", "a"), 1);
        assertDiff(list("a", "b", "c"), list("c", "b", "a"), 2);
    }

    @Test
    public void up() throws Exception {
        assertDiff(list("a", "b", "c", "d"), list("c", "d", "a", "b"), 2);
        assertDiff(list("a", "b", "c", "d"), list("b", "d", "a", "c"), 2);
    }

    @Test
    public void down() throws Exception {
        assertDiff(list("a", "b", "c", "d"), list("b", "c", "d", "a"), 1);
        assertDiff(list("a", "b", "c", "d"), list("b", "d", "c", "a"), 2);
    }

    @Test
    public void change() {
        assertDiff(list("a"), list("1"), 1);
        assertDiff(list("a", "b", "c"), list("1", "2"), 3);
        assertDiff(list("a", "b"), list("1", "2", "3"), 3);
    }

    @Test
    public void complex1() {
        assertDiff(list("a", "b", "c"), list("0", "1", "a", "c"), 3);

    }

    @Test
    public void complex2() throws Exception {
        assertDiff(list("a", "b", "c", "d", "e"), list("0", "d", "a"), 5);
    }

    @Test
    public void complex3() throws Exception {
        assertDiff(list("a", "b", "c"), list("0", "b", "1", "a", "c"), 4);
    }

    @Test
    public void complex4() {
        assertDiff(list("a", "b", "c", "d", "e"), list("0", "d", "e", "a"), 4);
    }

    @Test
    public void complex5() {
        assertDiff(list("a", "b", "c", "d", "e"), list("0", "c", "d", "a"), 4);
    }

    @Test
    public void complex6() {
        assertDiff(list("a", "b", "c"), list("0", "b", "1", "a", "2", "c"), 5);
    }

    /**
     * Create list.
     * 
     * @param values
     * @return
     */
    private List list(Object... values) {
        List list = new ArrayList();

        for (Object value : values) {
            list.add(value);
        }
        return list;
    }

    /**
     * Assert list diff.
     * 
     * @param prev
     * @param next
     */
    private void assertDiff(List prev, List next, int expectedOperationCount) {
        List<PatchListOperation> ops = Diff.diff(prev, next);
        List<List> snapshots = new ArrayList();

        for (int i = 0; i < ops.size(); i++) {
            try {
                ops.get(i).operate(prev);
                snapshots.add(new ArrayList(prev));
            } catch (IndexOutOfBoundsException e) {
                AssertionError error = new AssertionError(message(prev, next, ops, snapshots, i));
                error.addSuppressed(e);

                throw error;
            }
        }

        String message = message(prev, next, ops, snapshots, ops.size());

        assert expectedOperationCount == ops.size() : message;
        assert prev.size() == next.size() : message;

        for (int i = 0; i < prev.size(); i++) {
            assert prev.get(i) == next.get(i) : message;
        }
    }

    /**
     * Helper to write erro message.
     * 
     * @param prev
     * @param next
     * @param ops
     * @param snapshots
     * @param size
     * @return
     */
    private String message(List prev, List next, List<PatchListOperation> ops, List<List> snapshots, int size) {
        StringBuilder message = new StringBuilder("\r\n");
        message.append("PREV: ").append(prev).append("\r\n");
        message.append("NEXT: ").append(next).append("\r\n");
        message.append("OPERATIONS:\r\n");

        for (int i = 0; i < size; i++) {
            message.append(ops.get(i)).append("  ").append(snapshots.get(i)).append("\r\n");
        }

        if (size != ops.size()) {
            message.append("\r\nNOEXECUTED:\r\n");

            for (int i = size; i < ops.size(); i++) {
                message.append(ops.get(i)).append("\r\n");
            }
        }
        return message.toString();
    }
}
