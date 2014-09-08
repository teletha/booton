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
    private static final VirtualNode[] noChild = new VirtualNode[0];

    /** The reusable attribute map. */
    private static final Map<String, String> noAttr = new HashMap();

    @Test
    public void addAttribute() {
        VirtualElement n1 = e("div");
        VirtualElement n2 = e("div", attr("a", "A"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeAttribute() {
        VirtualElement n1 = e("div", attr("a", "A"));
        VirtualElement n2 = e("div");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void replaceAttributeValue() {
        VirtualElement n1 = e("div", attr("a", "A"));
        VirtualElement n2 = e("div", attr("a", "B"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void addChildText() {
        VirtualElement n1 = e("root");
        VirtualElement n2 = e("root", text("text1"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void removeChildText() {
        VirtualElement n1 = e("root", text("text1"));
        VirtualElement n2 = e("root");

        assertDiff(n1, n2, 1);
    }

    @Test
    public void replaceChildText() {
        VirtualElement n1 = e("root", text("text1"));
        VirtualElement n2 = e("root", text("text2"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void insertChildFromEmpty() {
        assertDiff(e("root"), e("root", e("child")), 1);
    }

    @Test
    public void insertChildAtTail() {
        assertDiff(root("c1", "c2"), root("c1", "c2", "c3"), 1);
        assertDiff(root("c1", "c2"), root("c1", "c2", "A", "B"), 2);
    }

    @Test
    public void insertChildAtHead() {
        assertDiff(root("c1", "c2"), root("c1", "c2", "c3"), 1);
        assertDiff(root("c1", "c2"), root("A", "B", "c1", "c2"), 2);
    }

    @Test
    public void insertChildAtMiddle() {
        assertDiff(root("c1", "c2"), root("c1", "c2", "c3"), 1);
        assertDiff(root("c1", "c2"), root("c1", "A", "B", "c2"), 2);
    }

    @Test
    public void removeChildAtTail() {
        assertDiff(root("c1", "c2", "c3"), root("c1", "c2"), 1);
        assertDiff(root("c1", "c2", "c3"), root("c1"), 2);
    }

    @Test
    public void removeChildAtHead() {
        assertDiff(root("c1", "c2", "c3"), root("c2", "c3"), 1);
        assertDiff(root("c1", "c2", "c3"), root("c3"), 2);
    }

    @Test
    public void removeChildAtMiddle() {
        assertDiff(root("c1", "c2", "c3"), root("c1", "c3"), 1);
        assertDiff(root("c1", "c2", "c3", "c4"), root("c1", "c4"), 2);
    }

    @Test
    public void reverseChild() {
        assertDiff(root("c1", "c2"), root("c2", "c1"), 1);
        assertDiff(root("c1", "c2", "c3"), root("c3", "c2", "c1"), 2);
    }

    @Test
    public void upChild() {
        assertDiff(root("a", "b", "c", "d"), root("c", "d", "a", "b"), 2);
        assertDiff(root("a", "b", "c", "d"), root("b", "d", "a", "c"), 2);
    }

    @Test
    public void replaceChildElement() {
        VirtualElement n1 = e("root", e("c1"));
        VirtualElement n2 = e("root", e("c2"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void replaceChildNode() {
        VirtualElement n1 = e("root", e("child"));
        VirtualElement n2 = e("root", text("child"));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void nestNoDiff() {
        VirtualElement n1 = e("root", e("child", e("grand")));
        VirtualElement n2 = e("root", e("child", e("grand")));

        assertDiff(n1, n2, 0);
    }

    @Test
    public void nestAttributeAdd() {
        VirtualElement n1 = e("root", e("child"));
        VirtualElement n2 = e("root", e("child", attr("a", "A")));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void nestChildAdd() {
        VirtualElement n1 = e("root", e("child"));
        VirtualElement n2 = e("root", e("child", e("grand")));

        assertDiff(n1, n2, 1);
    }

    @Test
    public void nestComplex() {
        VirtualElement n1 = e("root", e("child", e("grand")));
        VirtualElement n2 = e("root", e("inserted", e("grand")), e("child", e("changed")));

        assertDiff(n1, n2, 2);
    }

    /**
     * Assert map diff.
     * 
     * @param prev
     * @param next
     */
    private void assertDiff(VirtualElement prev, VirtualElement next, int expectedOperationCount) {
        assertDiff(prev, next, expectedOperationCount, new Class[0]);
    }

    /**
     * Assert map diff.
     * 
     * @param prev
     * @param next
     */
    private void assertDiff(VirtualElement prev, VirtualElement next, int expectedOperationCount, Class... patches) {
        List<PatchOperation> ops = Diff.diff(prev, next);

        Node prevNode = prev.createNode();
        Node nextNode = next.createNode();

        for (int i = 0; i < ops.size(); i++) {
            try {
                ops.get(i).operate();
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
        message.append("PREV:\r\n").append(prev).append("\r\n\r\n");
        message.append("NEXT:\r\n").append(next).append("\r\n\r\n");
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
     * Helper method to create element.
     * </p>
     * 
     * @param attributes
     * @return
     */
    private static VirtualElement root(String... children) {
        VirtualElement[] elements = new VirtualElement[children.length];

        for (int i = 0; i < children.length; i++) {
            elements[i] = e(children[i]);
        }
        return e("root", elements);
    }

    /**
     * <p>
     * Helper method to create element.
     * </p>
     * 
     * @param attributes
     * @return
     */
    private static VirtualElement root(VirtualNode... children) {
        return e("root", children);
    }

    /**
     * <p>
     * Helper method to create element.
     * </p>
     * 
     * @param attributes
     * @return
     */
    private static VirtualElement e(String key, VirtualNode... children) {
        return new VirtualElement(key.hashCode(), key, noAttr, children);
    }

    /**
     * <p>
     * Helper method to create element.
     * </p>
     * 
     * @param attributes
     * @return
     */
    private static VirtualElement e(String key, Map<String, String> attributes, VirtualNode... children) {
        return new VirtualElement(key.hashCode(), key, attributes, children);
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
     * Helper method to create attribute map.
     * </p>
     * 
     * @param attributes
     * @return
     */
    private static VirtualText text(String value) {
        return new VirtualText(value.hashCode() ^ 31, value);
    }
}
