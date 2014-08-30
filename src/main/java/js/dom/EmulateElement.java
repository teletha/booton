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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import js.lang.NativeFunction;
import kiss.I;
import kiss.XML;
import booton.css.CSS;

/**
 * @version 2013/10/05 10:40:36
 */
class EmulateElement extends Element implements EmulateNodable {

    /** The child nodes holder. */
    final Nodes nodes = new Nodes();

    /** The original element name. */
    final String nameOriginal;

    /** The element name. */
    private final String name;

    /** The style manager. */
    private final EmulateCSSStyleDeclaration css = new EmulateCSSStyleDeclaration();

    /** The event listeners holder. */
    private final EmulateEventTarget events = new EmulateEventTarget();

    /** The child nodes holder. */
    private final EmulateHTMLCollection elements = new EmulateHTMLCollection();

    /** The attribute holder. */
    final Attributes attributes = new Attributes();

    /** The parent element. */
    private EmulateElement parent;

    /** The form value. */
    private String value;

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
        this.nameOriginal = name;
        this.name = name.toUpperCase();
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
    protected void addEventListener(String type, NativeFunction listener) {
        events.addEventListener(type, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void removeEventListener(String type, NativeFunction listener) {
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
    protected Node removeChild(Node childNode) {
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
    protected Node insertBefore(Node newNode, Node referenceNode) {
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
    public NodeList<Element> getElementsByClassName(Class<? extends CSS> className) {
        return new ByClassNameCollection(className);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element querySelector(String selector) {
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
    public NodeList<Element> querySelectorAll(String selector) {
        return new JavaNonLiveNodeList(I.xml(new JavaElement(this)).find(selector));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(String selector) {
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
    protected CSSStyleDeclaration style() {
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
        return ((JavaElement) xml.to()).element;
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

        private Class<? extends CSS> className;

        /**
         * @param className
         */
        private ByClassNameCollection(Class<? extends CSS> className) {
            this.className = className;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int length() {
            int count = 0;

            for (int i = 0; i < nodes.elementCount; i++) {
                Element element = nodes.getElement(i);

                if (element.classList().contains(className)) {
                    count++;
                }
                count += element.getElementsByClassName(className).length();
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

                if (element.classList().contains(className)) {
                    if (index == count) {
                        return element;
                    }
                    count++;
                }
                count += element.getElementsByClassName(className).length();
            }
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * @version 2013/07/11 14:10:27
     */
    static class Attributes {

        /** The manager. */
        final List<Entry<Key, String>> entries = new ArrayList();

        /** The class attribute. */
        final EmulateDOMTokenList classes = new EmulateDOMTokenList();

        /**
         * <p>
         * Add attribute.
         * </p>
         * 
         * @param namespace
         * @param name
         * @param value
         */
        void add(String namespace, String name, String value) {
            Key key = new Key(namespace, name);
            value = String.valueOf(value);

            if (Key.CLASS.equals(key)) {
                classes.clear();

                for (String className : value.trim().split(" ")) {
                    classes.add(className);
                }
            }

            Entry<Key, String> entry = find(key);

            if (entry == null) {
                entry = new SimpleEntry(key, value);
                entries.add(entry);
            } else {
                entry.setValue(value);
            }
        }

        /**
         * <p>
         * Remove attribute.
         * </p>
         * 
         * @param namespace
         * @param name
         */
        void remove(String namespace, String name) {
            Key key = new Key(namespace, name);

            if (Key.CLASS.equals(key)) {
                classes.clear();
            }

            Entry<Key, String> entry = find(key);

            if (entry != null) {
                entries.remove(entry);
            }
        }

        /**
         * <p>
         * Test attribute.
         * </p>
         * 
         * @param namespace
         * @param name
         * @return
         */
        boolean has(String namespace, String name) {
            Key key = new Key(namespace, name);

            if (Key.CLASS.equals(key)) {
                return classes.length() != 0;
            } else {
                return find(key) != null;
            }
        }

        /**
         * <p>
         * Get attribute.
         * </p>
         * 
         * @param namespace
         * @param name
         * @return
         */
        String get(String namespace, String name) {
            Key key = new Key(namespace, name);

            Entry<Key, String> entry = find(key);

            if (entry == null) {
                return null;
            } else {
                return entry.getValue();
            }
        }

        /**
         * <p>
         * Helper method to find entry.
         * </p>
         * 
         * @param key
         * @return
         */
        private Entry<Key, String> find(Key key) {
            for (Entry<Key, String> entry : entries) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
            }
            return null;
        }
    }

    /**
     * @version 2013/07/11 14:16:13
     */
    static class Key {

        /** The html class attribute name. */
        private static final Key CLASS = new Key("", "class");

        /** The uri. */
        final String namespace;

        /** The name. */
        final String name;

        /**
         * @param namespace
         * @param name
         */
        private Key(String namespace, String name) {
            if (namespace == null) {
                namespace = "";
            }

            this.namespace = namespace.toLowerCase();
            this.name = String.valueOf(name).toLowerCase();

            if (this.name.length() == 0) {
                throw new EmulateDOMError();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key attr = (Key) obj;

                return name.equals(attr.name) && namespace.equals(attr.namespace);
            }
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return name.hashCode() + namespace.hashCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return (namespace == null ? "" : namespace + ":") + name;
        }
    }
}
