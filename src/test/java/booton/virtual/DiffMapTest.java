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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @version 2014/08/29 9:17:17
 */
public class DiffMapTest {

    @Test
    public void changeValue() throws Exception {
        assertDiff(map("a", "A"), map("a", "1"), 1);
        assertDiff(map("a", "A", "b", "B"), map("a", "1", "b", "2"), 2);
        assertDiff(map("a", "A"), map("a", "A"), 0);
    }

    @Test
    public void remove() throws Exception {
        assertDiff(map("a", "A"), map(), 1);
        assertDiff(map("a", "A", "b", "B"), map("b", "B"), 1);
        assertDiff(map("a", "A", "b", "B"), map(), 2);
    }

    @Test
    public void add() throws Exception {
        assertDiff(map(), map("a", "A"), 1);
        assertDiff(map("a", "A"), map("a", "A", "b", "B"), 1);
    }

    @Test
    public void change() throws Exception {
        assertDiff(map("a", "A"), map("b", "B"), 2);
    }

    /**
     * Create map.
     * 
     * @param values
     * @return
     */
    private Map map(Object... values) {
        Map map = new HashMap();

        for (int i = 0; i < values.length; i++) {
            map.put(values[i], values[++i]);
        }
        return map;
    }

    /**
     * Assert map diff.
     * 
     * @param prev
     * @param next
     */
    private void assertDiff(Map<String, String> prev, Map<String, String> next, int expectedOperationCount) {
        List<PatchMapOperation> ops = Diff.diff(prev, next);
        List<Map> snapshots = new ArrayList();

        for (int i = 0; i < ops.size(); i++) {
            try {
                ops.get(i).operate(prev);
                snapshots.add(new HashMap(prev));
            } catch (IndexOutOfBoundsException e) {
                AssertionError error = new AssertionError(message(prev, next, ops, snapshots, i));
                error.addSuppressed(e);

                throw error;
            }
        }

        String message = message(prev, next, ops, snapshots, ops.size());

        assert expectedOperationCount == ops.size() : message;
        assert prev.size() == next.size() : message;

        for (Object key : prev.keySet()) {
            assert next.containsKey(key) : message;
            assert prev.get(key) == next.get(key) : message;
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
    private String message(Map prev, Map next, List<PatchMapOperation> ops, List<Map> snapshots, int size) {
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
