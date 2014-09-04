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

import js.dom.Node;
import js.dom.NodeComparator;

import org.junit.Test;

/**
 * @version 2014/08/31 10:07:37
 */
public class DiffNodeTest {

    /** The reusable child list. */
    private static final List<VirtualNode> noChild = new ArrayList();

    /** The reusable attribute map. */
    private static final Map<String, String> noAttr = new HashMap();

    @Test
    public void addAttribute() {
        VirtualNode n1 = new VirtualElement("div");
        VirtualNode n2 = new VirtualElement("div", attr("a", "A"), noChild);

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeAttribute() {
        VirtualNode n1 = new VirtualElement("div", attr("a", "A"), noChild);
        VirtualNode n2 = new VirtualElement("div");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void addChild() {
        VirtualNode n1 = new VirtualElement("div");
        VirtualNode n2 = new VirtualElement("div", noAttr, children("c"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeChild1() {
        VirtualNode n1 = new VirtualElement("div", noAttr, children("c"));
        VirtualNode n2 = new VirtualElement("div");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeChild2() {
        VirtualNode n1 = new VirtualElement("div", noAttr, children("c1", "c2"));
        VirtualNode n2 = new VirtualElement("div", noAttr, children("c1"));

        assertDiff(n1, n2, 1);
    }

    /**
     * Assert map diff.
     * 
     * @param prev
     * @param next
     */
    private void assertDiff(VirtualNode prev, VirtualNode next, int expectedOperationCount) {
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

    /**
     * <p>
     * Helper method to create attribute map.
     * </p>
     * 
     * @param attributes
     * @return
     */
    private static Map<String, String> attr(String... attributes) {
        Map<String, String> map = new HashMap();

        for (int i = 0; i < attributes.length; i++) {
            map.put(attributes[i], attributes[i + 1]);
        }
        return map;
    }

    /**
     * <p>
     * Helper method to create child list.
     * </p>
     * 
     * @param children
     * @return
     */
    private static List<VirtualNode> children(String... children) {
        List<VirtualNode> list = new ArrayList();

        for (String child : children) {
            list.add(new VirtualElement(child));
        }
        return list;
    }
}
