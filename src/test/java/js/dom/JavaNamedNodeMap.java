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

import js.dom.EmulateElement.Attributes;
import js.dom.EmulateElement.Key;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * @version 2014/01/22 13:30:33
 */
class JavaNamedNodeMap implements NamedNodeMap {

    /** The delegator. */
    private final JavaElement element;

    /** The delegator. */
    private final Attributes attributes;

    /**
     * @param attributes
     */
    JavaNamedNodeMap(JavaElement element, Attributes attributes) {
        this.element = element;
        this.attributes = attributes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNamedItem(String name) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node setNamedItem(Node arg) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node removeNamedItem(String name) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node item(int index) {
        Key key = attributes.entries.get(index).getKey();

        return new JavaAttr(element, key.namespace, key.name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLength() {
        return attributes.entries.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNamedItemNS(String namespaceURI, String localName) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node setNamedItemNS(Node arg) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
