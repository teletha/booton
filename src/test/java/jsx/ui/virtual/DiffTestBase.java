/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.virtual;

import java.util.List;

import js.dom.Node;
import js.dom.NodeComparator;

/**
 * @version 2014/09/13 14:18:22
 */
public class DiffTestBase {

    /**
     * <p>
     * Assert structure diff.
     * </p>
     * 
     * @param prev
     * @param next
     * @param expectedOperationCount
     */
    protected void assertDiff(VirtualStructure prev, VirtualStructure next, int expectedOperationCount) {
        assertDiff(prev.getRoot(), next.getRoot(), expectedOperationCount);
    }

    /**
     * <p>
     * Assert structure diff.
     * </p>
     * 
     * @param prev
     * @param next
     * @param expectedOperationCount
     */
    protected void assertDiff(VirtualElement prev, VirtualElement next, int expectedOperationCount) {
        Node prevNode = prev.materialize();
        Node nextNode = next.materialize();

        clean(next);

        List<Patch> ops = Diff.diff(prev, next);

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
        System.out.println(prevNode);
        System.out.println(nextNode);
        NodeComparator.equals(prevNode, nextNode);
    }

    /**
     * <p>
     * Clean up dom reference.
     * </p>
     * 
     * @param node
     */
    private void clean(VirtualNode node) {
        node.dom = null;

        if (node instanceof VirtualElement) {
            VirtualElement element = (VirtualElement) node;

            for (int i = 0; i < element.children.items.length(); i++) {
                clean(element.children.items.get(i));
            }
        }
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
