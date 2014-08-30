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
public class DifferenceListTest {

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
    }

    @Test
    public void down() throws Exception {
        assertDiff(list("a", "b", "c", "d"), list("b", "c", "d", "a"), 1);
    }

    @Test
    public void change() {
        assertDiff(list("a"), list("1"), 1);
        assertDiff(list("a", "b", "c"), list("1", "2"), 3);
        assertDiff(list("a", "b"), list("1", "2", "3"), 3);
    }

    @Test
    public void complex() {
        assertDiff(list("a", "b", "c"), list("0", "1", "a", "c"), 3);
        assertDiff(list("a", "b", "c"), list("0", "b", "1", "a", "c"), 3);
        assertDiff(list("a", "b", "c", "d", "e"), list("0", "d", "a"), 5);
    }

    @Test
    public void complex4() {
        assertDiff(list("a", "b", "c", "d", "e"), list("0", "d", "e", "a"), 5);
    }

    @Test
    public void complex5() {
        assertDiff(list("a", "b", "c", "d", "e"), list("0", "c", "d", "a"), 5);
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
     * @param left
     * @param right
     */
    private void assertDiff(List left, List right, int expectedOperationCount) {
        List<DiffOperation> ops = Difference.diff(left, right);
        List<List> snapshots = new ArrayList();

        for (int i = 0; i < ops.size(); i++) {
            try {
                ops.get(i).operate(left);
                snapshots.add(new ArrayList(left));
            } catch (IndexOutOfBoundsException e) {
                AssertionError error = new AssertionError(message(left, right, ops, snapshots, i));
                error.addSuppressed(e);

                throw error;
            }
        }

        String message = message(left, right, ops, snapshots, ops.size());

        assert expectedOperationCount == ops.size() : message;
        assert left.size() == right.size() : message;

        for (int i = 0; i < left.size(); i++) {
            assert left.get(i) == right.get(i) : message;
        }
    }

    /**
     * Helper to write erro message.
     * 
     * @param left
     * @param right
     * @param ops
     * @param snapshots
     * @param size
     * @return
     */
    private String message(List left, List right, List<DiffOperation> ops, List<List> snapshots, int size) {
        StringBuilder message = new StringBuilder("\r\n");
        message.append("LEFT: ").append(left).append("\r\n");
        message.append("RIGHT: ").append(right).append("\r\n");
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
