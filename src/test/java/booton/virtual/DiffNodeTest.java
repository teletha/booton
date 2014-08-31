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

import java.util.List;

import js.dom.Node;
import js.dom.NodeComparator;

import org.junit.Test;

/**
 * @version 2014/08/31 10:07:37
 */
public class DiffNodeTest {

    @Test
    public void addAttribute() {
        VNode n1 = new VNode("div");
        VNode n2 = new VNode("div").attr("a", "A");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeAttribute() {
        VNode n1 = new VNode("div").attr("a", "A");
        VNode n2 = new VNode("div");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void addChild() {
        VNode n1 = new VNode("div");
        VNode n2 = new VNode("div").add("c");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeChild1() {
        VNode n1 = new VNode("div").add("c");
        VNode n2 = new VNode("div");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeChild2() {
        VNode n1 = new VNode("div").add("c1").add("c2");
        VNode n2 = new VNode("div").add("c1");

        assertDiff(n1, n2, 1);
    }

    /**
     * Assert map diff.
     * 
     * @param prev
     * @param next
     */
    private void assertDiff(VNode prev, VNode next, int expectedOperationCount) {
        List<PatchOperation> ops = Diff.diff(prev, next);

        Node prevNode = prev.createNode();
        Node nextNode = next.createNode();

        for (int i = 0; i < ops.size(); i++) {
            try {
                ops.get(i).operate(prevNode);
            } catch (IndexOutOfBoundsException e) {
                AssertionError error = new AssertionError(message(prevNode, nextNode, ops, i));
                error.addSuppressed(e);

                throw error;
            }
        }

        String message = message(prevNode, nextNode, ops, ops.size());

        assert expectedOperationCount == ops.size() : message;
        NodeComparator.equals(prevNode, nextNode);
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
    private String message(Node prev, Node next, List<PatchOperation> ops, int size) {
        StringBuilder message = new StringBuilder("\r\n");
        message.append("PREV: ").append(prev).append("\r\n");
        message.append("NEXT: ").append(next).append("\r\n");
        message.append("OPERATIONS:\r\n");

        for (int i = 0; i < size; i++) {
            message.append(ops.get(i)).append("  ").append("\r\n");
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
