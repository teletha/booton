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
 * @version 2014/09/05 15:45:45
 */
public class VirtualStructureDiffTest {

    @Test
    public void textChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.asis(1).〡("text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.asis(1).〡("change");

        assertDiff(prev〡, next〡, 1);
    }

    @Test
    public void textNoChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.asis〡(1, "text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.asis〡(1, "text");

        assertDiff(prev〡, next〡, 0);
    }

    @Test
    public void hboxTextChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.hbox(1, "text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.hbox(1, "change");

        assertDiff(prev〡, next〡, 1);
    }

    /**
     * <p>
     * Assert map diff.
     * </p>
     * 
     * @param prev
     * @param next
     * @param expectedOperationCount
     */
    private void assertDiff(VirtualStructure prev, VirtualStructure next, int expectedOperationCount) {
        List<Patch> ops = Diff.diff(prev.getRoot(), next.getRoot());

        Node prevNode = prev.getRoot().createNode();
        Node nextNode = next.getRoot().createNode();

        for (int i = 0; i < ops.size(); i++) {
            try {
                ops.get(i).apply();
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
     * <p>
     * Helper to write erro message.
     * </p>
     * 
     * @param prev
     * @param next
     * @param ops
     * @param size
     * @return
     */
    private String message(Node prev, Node next, List<Patch> ops, int size) {
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
