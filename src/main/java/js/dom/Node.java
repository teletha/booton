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
public abstract class Node implements JavascriptNative {

    protected abstract Node appedChild(Object child);

    /**
     * {@inheritDoc}
     */
    public native String getNodeName();

    /**
     * {@inheritDoc}
     */
    public native String getNodeValue() throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native void setNodeValue(String nodeValue) throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native short getNodeType();

    /**
     * {@inheritDoc}
     */
    public native Node getParentNode();

    /**
     * {@inheritDoc}
     */
    public native NodeList getChildNodes();

    /**
     * {@inheritDoc}
     */
    public native Node getFirstChild();

    /**
     * {@inheritDoc}
     */
    public native Node getLastChild();

    /**
     * {@inheritDoc}
     */
    public native Node getPreviousSibling();

    /**
     * {@inheritDoc}
     */
    public native Node getNextSibling();

    /**
     * {@inheritDoc}
     */
    public native NamedNodeMap getAttributes();

    /**
     * {@inheritDoc}
     */
    public native Document getOwnerDocument();

    /**
     * {@inheritDoc}
     */
    public native Node insertBefore(org.w3c.dom.Node newChild, org.w3c.dom.Node refChild) throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native Node replaceChild(org.w3c.dom.Node newChild, org.w3c.dom.Node oldChild) throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native Node removeChild(org.w3c.dom.Node oldChild) throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native boolean hasChildNodes();

    /**
     * {@inheritDoc}
     */
    public native Node cloneNode(boolean deep);

    /**
     * {@inheritDoc}
     */
    public native void normalize();

    /**
     * {@inheritDoc}
     */
    public native boolean isSupported(String feature, String version);

    /**
     * {@inheritDoc}
     */
    public native String getNamespaceURI();

    /**
     * {@inheritDoc}
     */
    public native String getPrefix();

    /**
     * {@inheritDoc}
     */
    public native void setPrefix(String prefix) throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native String getLocalName();

    /**
     * {@inheritDoc}
     */
    public native boolean hasAttributes();

    /**
     * {@inheritDoc}
     */
    public native String getBaseURI();

    /**
     * {@inheritDoc}
     */
    public native short compareDocumentPosition(org.w3c.dom.Node other) throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native String getTextContent() throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native void setTextContent(String textContent) throws DOMException;

    /**
     * {@inheritDoc}
     */
    public native boolean isSameNode(org.w3c.dom.Node other);

    /**
     * {@inheritDoc}
     */
    public native String lookupPrefix(String namespaceURI);

    /**
     * {@inheritDoc}
     */
    public native boolean isDefaultNamespace(String namespaceURI);

    /**
     * {@inheritDoc}
     */
    public native String lookupNamespaceURI(String prefix);

    /**
     * {@inheritDoc}
     */
    public native boolean isEqualNode(org.w3c.dom.Node arg);

    /**
     * {@inheritDoc}
     */
    public native Object getFeature(String feature, String version);

    /**
     * {@inheritDoc}
     */
    public native Object setUserData(String key, Object data, UserDataHandler handler);

    /**
     * {@inheritDoc}
     */
    public native Object getUserData(String key);
}
