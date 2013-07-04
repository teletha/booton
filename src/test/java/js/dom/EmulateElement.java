/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xml.sax.helpers.AttributesImpl;

/**
 * @version 2013/07/01 23:55:23
 */
public class EmulateElement extends Element implements Nodable {

    /** The child nodes holder. */
    final Nodes nodes = new Nodes();

    /** The attribute holder. */
    private final AttributesImpl attributes = new AttributesImpl();

    /** The parent element. */
    private EmulateElement parent;

    /**
     * 
     */
    public EmulateElement() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParent(EmulateElement parent) {
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getAttribute(String name) {
        return attributes.getValue(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setAttribute(String name, String value) {
        attributes.addAttribute("", name, name, "", value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setAttributeNS(String namespace, String name, String value) {
        name = String.valueOf(name);

        attributes.addAttribute(namespace, name, name, "", value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeAttribute(String name) {
        attributes.removeAttribute(attributes.getIndex(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <T> T appedChild(T newNode) {
        if (newNode == null) {
            throw new Error();
        }
        nodes.add(newNode);

        return newNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node removeChild(Node childNode) {
        int index = nodes.indexOf(childNode);

        if (index == -1) {
            throw new Error();
        }
        nodes.remove(index);

        return childNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node insertBefore(Node newNode, Node referenceNode) {
        if (newNode != null) {
            int index;

            if (referenceNode == null) {
                index = nodes.size();
            } else {
                index = nodes.indexOf(referenceNode);
            }

            if (index == -1) {
                throw new Error();
            }
            nodes.add(index, newNode);
        }
        return newNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node firstChild() {
        return nodes.size() == 0 ? null : nodes.get(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node lastChild() {
        int size = nodes.size();
        return size == 0 ? null : nodes.get(size - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node previousSibling() {
        if (parent == null) {
            return null;
        }

        int index = parent.nodes.indexOf(this) - 1;
        return index < 0 ? null : parent.nodes.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node nextSibling() {
        if (parent == null) {
            return null;
        }

        int index = parent.nodes.indexOf(this) + 1;
        return parent.nodes.size() <= index ? null : parent.nodes.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String textContent() {
        StringBuilder text = new StringBuilder();

        for (Node item : nodes) {
            text.append(item.textContent());
        }
        return text.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void textContent(String textContent) {
        nodes.clear();
        nodes.add(textContent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Element parentElement() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Element firstElementChild() {
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);

            if (node instanceof Element) {
                return (Element) node;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Element lastElementChild() {
        for (int i = nodes.size() - 1; 0 <= i; i--) {
            Node node = nodes.get(i);

            if (node instanceof Element) {
                return (Element) node;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Element previousElementSibling() {
        if (parent == null) {
            return null;
        }

        int index = parent.nodes.indexOf(this) - 1;

        while (0 <= index) {
            Node node = parent.nodes.get(index);

            if (node instanceof Element) {
                return (Element) node;
            }
            index--;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Element nextElementSibling() {
        if (parent == null) {
            return null;
        }

        int index = parent.nodes.indexOf(this) + 1;

        while (index < parent.nodes.size()) {
            Node node = parent.nodes.get(index);

            if (node instanceof Element) {
                return (Element) node;
            }
            index++;
        }
        return null;
    }

    /**
     * @version 2013/07/01 9:30:36
     */
    class Nodes implements Iterable<Node> {

        /** The current node set. */
        private final List<Node> nodes = new ArrayList();

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<Node> iterator() {
            return nodes.iterator();
        }

        /**
         * <p>
         * Return collection size.
         * </p>
         * 
         * @return
         */
        int size() {
            return nodes.size();
        }

        /**
         * <p>
         * Add node at end.
         * </p>
         * 
         * @param node
         */
        void add(Object node) {
            add(size(), node);
        }

        /**
         * <p>
         * Add node.
         * </p>
         * 
         * @param contents
         */
        void add(int index, Object contents) {
            if (contents != null) {
                Node node = makeNode(contents);

                // remove duplication for live emulation
                int found = nodes.indexOf(node);

                if (found != -1) {
                    nodes.remove(found);

                    if (found <= index) {
                        index--;
                    }
                }

                // append it
                nodes.add(index, node);

                // modify tree
                if (node instanceof Nodable) {
                    ((Nodable) node).setParent(EmulateElement.this);
                }
            }
        }

        /**
         * <p>
         * Add node.
         * </p>
         * 
         * @param contents
         */
        void remove(int index) {
            if (0 <= index && index < size()) {
                // remove it
                Node node = nodes.remove(index);

                // modify tree
                // modify tree
                if (node instanceof Nodable) {
                    ((Nodable) node).setParent(null);
                }
            }
        }

        /**
         * <p>
         * Find index of the specified node.
         * </p>
         * 
         * @param node A target node to search.
         * @return A index.
         */
        int indexOf(Object node) {
            return nodes.indexOf(node);
        }

        /**
         * <p>
         * Helper method to clear all nodes.
         * </p>
         */
        void clear() {
            while (0 < size()) {
                remove(0);
            }
        }

        /**
         * <p>
         * Helperr method to get node by index.
         * </p>
         * 
         * @param index
         * @return
         */
        Node get(int index) {
            return nodes.get(index);
        }

        /**
         * <p>
         * Helper method to create node object.
         * </p>
         * 
         * @param node
         * @return
         */
        private Node makeNode(Object node) {
            if (node instanceof Node) {
                return (Node) node;
            } else {
                return new EmulateText(node);
            }
        }
    }
}
