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
 * @version 2014/09/05 9:24:53
 */
public class DiffElementTest {

    /** The reusable child list. */
    private static final List<VirtualNode> noChild = new ArrayList();

    /** The reusable attribute map. */
    private static final Map<String, String> noAttr = new HashMap();

    @Test
    public void addAttribute() {
        VirtualElement n1 = new VirtualElement("div");
        VirtualElement n2 = new VirtualElement("div", attr("a", "A"), noChild);

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeAttribute() {
        VirtualElement n1 = new VirtualElement("div", attr("a", "A"), noChild);
        VirtualElement n2 = new VirtualElement("div");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void replaceAttributeValue() {
        VirtualElement n1 = new VirtualElement("div", attr("a", "A"), noChild);
        VirtualElement n2 = new VirtualElement("div", attr("a", "B"), noChild);

        assertDiff(n1, n2, 1);
    }

    @Test
    public void addChild() {
        VirtualElement n1 = new VirtualElement("div");
        VirtualElement n2 = new VirtualElement("div", noAttr, children("c"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void addChildText() {
        VirtualElement n1 = new VirtualElement("div");
        VirtualElement n2 = new VirtualElement("div", noAttr, children("text1"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeChild1() {
        VirtualElement n1 = new VirtualElement("div", noAttr, children("c"));
        VirtualElement n2 = new VirtualElement("div");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeChild2() {
        VirtualElement n1 = new VirtualElement("div", noAttr, children("c1", "c2"));
        VirtualElement n2 = new VirtualElement("div", noAttr, children("c1"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void replaceChildElement() {
        VirtualElement n1 = new VirtualElement("div", noAttr, children("c1"));
        VirtualElement n2 = new VirtualElement("div", noAttr, children("c2"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void replaceChildNode() {
        VirtualElement n1 = new VirtualElement("div", noAttr, children("c"));
        VirtualElement n2 = new VirtualElement("div", noAttr, children("text1"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void nestNoDiff() {
        VirtualElement n1 = new VirtualElement("div", noAttr, children(new VirtualElement("child", noAttr, children("c"))));
        VirtualElement n2 = new VirtualElement("div", noAttr, children(new VirtualElement("child", noAttr, children("c"))));

        assertDiff(n1, n2, 0);
    }

    @Test
    public void dontCheckNestedDiff() {
        VirtualElement n1 = new VirtualElement("div", noAttr, children(new VirtualElement("child", noAttr, children("c1"))));
        VirtualElement n2 = new VirtualElement("div", noAttr, children(new VirtualElement("child", noAttr, children("c2"))));

        assert Diff.diff(n1, n2).size() == 0;
    }

    /**
     * Assert map diff.
     * 
     * @param prev
     * @param next
     */
    private void assertDiff(VirtualElement prev, VirtualElement next, int expectedOperationCount) {
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

        for (int i = 0; i < attributes.length; i += 2) {
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
    private static List<VirtualNode> children(Object... children) {
        List<VirtualNode> list = new ArrayList();

        for (Object child : children) {
            if (child instanceof VirtualElement) {
                list.add((VirtualElement) child);
            } else {
                String value = child.toString();

                if (value.startsWith("text")) {
                    list.add(new VirtualText(value));
                } else {
                    list.add(new VirtualElement(value));
                }
            }
        }
        return list;
    }
}
