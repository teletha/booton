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

import static js.dom.JavaElement.*;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/**
 * @version 2014/09/05 9:40:21
 */
class JavaText implements org.w3c.dom.Text {

    /** The actual text. */
    private final EmulateText text;

    /**
     * @param text
     */
    JavaText(EmulateText text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getData() throws DOMException {
        return text.textContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(String data) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLength() {
        return text.textContent().length();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String substringData(int offset, int count) throws DOMException {
        return text.textContent().substring(offset, count);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void appendData(String arg) throws DOMException {
        text.textContent(text.textContent().concat(arg));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insertData(int offset, String arg) throws DOMException {
        StringBuilder builder = new StringBuilder(text.textContent());
        builder.insert(offset, arg);
        text.textContent(builder.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteData(int offset, int count) throws DOMException {
        StringBuilder builder = new StringBuilder(text.textContent());
        builder.delete(offset, offset + count);
        text.textContent(builder.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void replaceData(int offset, int count, String arg) throws DOMException {
        StringBuilder builder = new StringBuilder(text.textContent());
        builder.replace(offset, offset + count, arg);
        text.textContent(builder.toString());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNodeName() {
        return "TEXT";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNodeValue() throws DOMException {
        return text.textContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNodeValue(String nodeValue) throws DOMException {
        text.textContent(nodeValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short getNodeType() {
        return Node.TEXT_NODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getParentNode() {
        return JavaElement.convert(text.parentNode());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeList getChildNodes() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getFirstChild() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getLastChild() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getPreviousSibling() {
        return convert(text.previousSibling());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNextSibling() {
        return convert(text.nextSibling());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NamedNodeMap getAttributes() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Document getOwnerDocument() {
        return new JavaDocument((EmulateDocument) text.ownerDocument());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node appendChild(Node newChild) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasChildNodes() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node cloneNode(boolean deep) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void normalize() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSupported(String feature, String version) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNamespaceURI() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPrefix() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrefix(String prefix) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLocalName() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasAttributes() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBaseURI() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short compareDocumentPosition(Node other) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTextContent() throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTextContent(String textContent) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSameNode(Node other) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String lookupPrefix(String namespaceURI) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String lookupNamespaceURI(String prefix) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEqualNode(Node arg) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
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
     * {@inheritDoc}
     */
    @Override
    public org.w3c.dom.Text splitText(int offset) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isElementContentWhitespace() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getWholeText() {
        return text.textContent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public org.w3c.dom.Text replaceWholeText(String content) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
