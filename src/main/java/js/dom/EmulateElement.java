/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import js.lang.NativeFunction;
import jsx.ui.Style;
import kiss.I;
import kiss.XML;

/**
 * @version 2015/10/05 0:05:55
 */
class EmulateElement extends Element implements EmulateNodable {

    /** The child nodes holder. */
    final Nodes nodes = new Nodes();

    /** The original element name. */
    final String nameOriginal;

    /** The element namespace. */
    private final String ns;

    /** The element name. */
    private final String name;

    /** The style manager. */
    private final EmulateCSSStyleDeclaration css = new EmulateCSSStyleDeclaration();

    /** The event listeners holder. */
    private final EmulateEventTarget events = new EmulateEventTarget();

    /** The child nodes holder. */
    private final EmulateHTMLCollection elements = new EmulateHTMLCollection();

    /** The attribute holder. */
    final EmulateAttributes attributes = new EmulateAttributes();

    /** The parent element. */
    private EmulateElement parent;

    /** The form value. */
    private String value;

    /** The property holder. */
    private Map<String, Object> properties = new HashMap();

    /**
     * 
     */
    public EmulateElement() {
        this("span");
    }

    /**
     * <p>
     * Create new element.
     * </p>
     * 
     * @param name
     */
    public EmulateElement(String name) {
        this("", name);
    }

    /**
     * <p>
     * Create new element.
     * </p>
     * 
     * @param name
     */
    public EmulateElement(String ns, String name) {
        this.nameOriginal = name;
        this.ns = ns;
        this.name = name.toUpperCase();
    }

    /**
     * <p>
     * Get the value of the specified attribute.
     * </p>
     * 
     * @param name The name of the attribute to get.
     * @return The specified attribute value.
     */
    @Override
    public String attr(String name) {
        return getAttribute(String.valueOf(name));
    }

    /**
     * <p>
     * Set attribute for this element.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    @Override
    public Element attr(String name, Object value) {
        return attr(null, name, value);
    }

    /**
     * <p>
     * Set attribute with namespace for this element.
     * </p>
     * 
     * @param namespace The namespace uri of the attribute.
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    @Override
    public Element attr(String namespace, String name, Object value) {
        setAttributeNS(namespace, name, String.valueOf(value));

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object property(String name) {
        return properties.get(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element property(String name, Object value) {
        properties.put(name, value);

        return this;
    }

    /**
     * <p>
     * Remove an attribute from this element.
     * </p>
     * 
     * @param attributeName An attribute to remove.
     * @return A chainable API.
     */
    @Override
    public Element remove(String name) {
        removeAttribute(String.valueOf(name));

        // API definition
        return this;
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
    public void addEventListener(String type, NativeFunction listener) {
        events.addEventListener(type, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEventListener(String type, NativeFunction listener) {
        events.removeEventListener(type, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void dispatchEvent(UIEvent event) {
        events.dispatchEvent(event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getAttribute(String name) {
        return getAttributeNS(null, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getAttributeNS(String namespaces, String name) {
        return attributes.get(namespaces, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setAttribute(String name, String value) {
        setAttributeNS(null, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setAttributeNS(String namespace, String name, String value) {
        attributes.add(namespace, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeAttribute(String name) {
        removeAttributeNS(null, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeAttributeNS(String namespace, String name) {
        attributes.remove(namespace, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasAttribute(String name) {
        return hasAttributeNS(null, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasAttributeNS(String namespace, String name) {
        return attributes.has(namespace, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Document ownerDocument() {
        return I.make(EmulateDocument.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected <T extends Node> T appendChild(T newNode) {
        if (newNode == null) {
            throw new EmulateDOMError();
        }
        nodes.add(newNode);

        return newNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node removeChild(Node childNode) {
        int index = nodes.indexOf(childNode);

        if (index == -1) {
            throw new EmulateDOMError();
        }
        nodes.remove(index);

        return childNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node insertBefore(Node newNode, Node referenceNode) {
        if (newNode != null) {
            int index;

            if (referenceNode == null) {
                index = nodes.size();
            } else {
                index = nodes.indexOf(referenceNode);
            }

            if (index == -1) {
                throw new EmulateDOMError();
            }
            nodes.add(index, newNode);
        }
        return newNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node replaceChild(Node newChild, Node oldChild) {
        if (newChild != null) {
            if (oldChild != null) {
                Node ref = oldChild.nextSibling();
                removeChild(oldChild);

                if (ref == null) {
                    appendChild(newChild);
                } else {
                    insertBefore(newChild, ref);
                }
            }
        }
        return oldChild;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Node node) {
        while (node != null) {
            if (node == this) {
                return true;
            }
            node = node.parentNode();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node parentNode() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node firstChild() {
        return nodes.size() == 0 ? null : nodes.getNode(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Node lastChild() {
        int size = nodes.size();
        return size == 0 ? null : nodes.getNode(size - 1);
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
        return index < 0 ? null : parent.nodes.getNode(index);
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
        return parent.nodes.size() <= index ? null : parent.nodes.getNode(index);
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
    protected DOMTokenList classList() {
        return attributes.classes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLCollection childElements() {
        return elements;
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
            Node node = nodes.getNode(i);

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
            Node node = nodes.getNode(i);

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
            Node node = parent.nodes.getNode(index);

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
            Node node = parent.nodes.getNode(index);

            if (node instanceof Element) {
                return (Element) node;
            }
            index++;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Attributes attributes() {
        return attributes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String tagName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String value() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void value(String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected NodeList<Element> getElementsByClassName(Style className) {
        return new ByClassNameCollection(className);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Element querySelector(String selector) {
        NodeList<Element> query = querySelectorAll(selector);

        if (query.length() == 0) {
            return null;
        }
        return query.item(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected NodeList<Element> querySelectorAll(String selector) {
        return new JavaNonLiveNodeList(I.xml(new JavaElement(this)).find(selector));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean matches(String selector) {
        Element root = this;

        while (root.parent() != null) {
            root = root.parent();
        }
        NodeList<Element> query = root.querySelectorAll(selector);

        for (Element element : query) {
            if (element == this) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CSSStyleDeclaration style() {
        return css;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ClientRect getBoundingClientRect() {
        return new EmulateClientRect();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return I.xml(new JavaElement(this)).toString();
    }

    /**
     * <p>
     * Convert to {@link XML} to {@link EmulateElement}.
     * </p>
     * 
     * @param xml
     * @return
     */
    static EmulateElement convert(XML xml) {
        return ((JavaElement) xml.to()).emulation;
    }

    /**
     * @version 2013/07/01 9:30:36
     */
    class Nodes implements Iterable<Node> {

        /** The current node set. */
        private final List<Node> nodes = new ArrayList();

        /** The number of elements. */
        private int elementCount = 0;

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
                if (node instanceof EmulateNodable) {
                    ((EmulateNodable) node).setParent(EmulateElement.this);
                }

                if (node instanceof Element && found == -1) {
                    elementCount++;
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
                if (node instanceof EmulateNodable) {
                    ((EmulateNodable) node).setParent(null);
                }

                if (node instanceof Element) {
                    elementCount--;
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
        Node getNode(int index) {
            if (index < 0 || size() <= index) {
                throw new EmulateDOMError();
            }
            return nodes.get(index);
        }

        /**
         * <p>
         * Helper method to get element by index.
         * </p>
         * 
         * @param index
         * @return
         */
        Element getElement(int index) {
            if (index < 0 || elementCount <= index) {
                throw new EmulateDOMError();
            }

            int count = 0;

            for (Node node : nodes) {
                if (node instanceof Element) {
                    if (index == count++) {
                        return (Element) node;
                    }
                }
            }

            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped DOMError in here.
            throw new EmulateDOMError();
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

    /**
     * @version 2013/07/09 9:42:24
     */
    private class EmulateHTMLCollection extends HTMLCollection {

        /**
         * {@inheritDoc}
         */
        @Override
        public int length() {
            return nodes.elementCount;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Element item(int index) {
            return nodes.getElement(index);
        }
    }

    /**
     * @version 2013/07/28 19:11:23
     */
    private class ByClassNameCollection extends NodeList<Element> {

        private Style style;

        /**
         * @param style
         */
        private ByClassNameCollection(Style style) {
            this.style = style;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int length() {
            int count = 0;

            for (int i = 0; i < nodes.elementCount; i++) {
                Element element = nodes.getElement(i);

                if (element.has(style)) {
                    count++;
                }
                count += element.getElementsByClassName(style).length();
            }
            return count;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Element item(int index) {
            int count = 0;

            for (int i = 0; i < nodes.elementCount; i++) {
                Element element = nodes.getElement(i);

                if (element.has(style)) {
                    if (index == count) {
                        return element;
                    }
                    count++;
                }
                count += element.getElementsByClassName(style).length();
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
