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

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import booton.translator.JavascriptNative;

/**
 * @version 2013/04/01 13:58:21
 */
public abstract class Node implements org.w3c.dom.Node, JavascriptNative {

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getNodeName();

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getNodeValue() throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setNodeValue(String nodeValue) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native short getNodeType();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node getParentNode();

    /**
     * {@inheritDoc}
     */
    @Override
    public native NodeList getChildNodes();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node getFirstChild();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node getLastChild();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node getPreviousSibling();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node getNextSibling();

    /**
     * {@inheritDoc}
     */
    @Override
    public native NamedNodeMap getAttributes();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Document getOwnerDocument();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node insertBefore(org.w3c.dom.Node newChild, org.w3c.dom.Node refChild) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node replaceChild(org.w3c.dom.Node newChild, org.w3c.dom.Node oldChild) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node removeChild(org.w3c.dom.Node oldChild) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node appendChild(org.w3c.dom.Node newChild) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean hasChildNodes();

    /**
     * {@inheritDoc}
     */
    @Override
    public native Node cloneNode(boolean deep);

    /**
     * {@inheritDoc}
     */
    @Override
    public native void normalize();

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean isSupported(String feature, String version);

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getNamespaceURI();

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getPrefix();

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setPrefix(String prefix) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getLocalName();

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean hasAttributes();

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getBaseURI();

    /**
     * {@inheritDoc}
     */
    @Override
    public native short compareDocumentPosition(org.w3c.dom.Node other) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native String getTextContent() throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native void setTextContent(String textContent) throws DOMException;

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean isSameNode(org.w3c.dom.Node other);

    /**
     * {@inheritDoc}
     */
    @Override
    public native String lookupPrefix(String namespaceURI);

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean isDefaultNamespace(String namespaceURI);

    /**
     * {@inheritDoc}
     */
    @Override
    public native String lookupNamespaceURI(String prefix);

    /**
     * {@inheritDoc}
     */
    @Override
    public native boolean isEqualNode(org.w3c.dom.Node arg);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Object getFeature(String feature, String version);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Object setUserData(String key, Object data, UserDataHandler handler);

    /**
     * {@inheritDoc}
     */
    @Override
    public native Object getUserData(String key);
}
