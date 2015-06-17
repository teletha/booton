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

import kiss.I;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.UserDataHandler;

/**
 * @version 2014/09/20 11:01:04
 */
abstract class JavaNode<Emulation extends js.dom.Node> implements Node {

    /** The emulated node. */
    final Emulation emulation;

    /**
     * @param node
     */
    JavaNode(Emulation node) {
        this.emulation = node;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getParentNode() {
        return convert(emulation.parentNode());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getFirstChild() {
        return convert(emulation.firstChild());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getLastChild() {
        return convert(emulation.lastChild());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getPreviousSibling() {
        return convert(emulation.previousSibling());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNextSibling() {
        return convert(emulation.nextSibling());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Document getOwnerDocument() {
        return new JavaDocument(I.make(EmulateDocument.class));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasChildNodes() {
        return emulation.firstChild() != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getFeature(String feature, String version) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getUserData(String key) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Helper method to convert {@link js.dom.Node} to {@link Node}.
     * </p>
     * 
     * @param node
     * @return
     */
    static Node convert(js.dom.Node node) {
        if (node == null) {
            return null;
        } else if (node instanceof EmulateElement) {
            return new JavaElement((EmulateElement) node);
        } else if (node instanceof EmulateText) {
            return new JavaText((EmulateText) node);
        } else if (node instanceof EmulateDocument) {
            return new JavaDocument((EmulateDocument) node);
        } else {
            throw new Error();
        }
    }
}
