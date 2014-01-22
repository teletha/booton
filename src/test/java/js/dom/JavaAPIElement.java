/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

/**
 * @version 2014/01/22 0:55:59
 */
class JavaAPIElement implements org.w3c.dom.Element {

    /** The delegator. */
    final EmulateElement element;

    /**
     * @param element
     */
    JavaAPIElement(EmulateElement element) {
        this.element = element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLocalName() {
        return getTagName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NamedNodeMap getAttributes() {
        return new JavaAPINamedNodeMap(this, element.attributes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNodeName() {
        return getTagName();
    }

    /**
     * The name of the element. If <code>Node.localName</code> is different from <code>null</code>,
     * this attribute is a qualified name. For example, in:
     * 
     * <pre> &lt;elementExample id="demo"&gt; ... 
     * &lt;/elementExample&gt; , </pre>
     * 
     * <code>tagName</code> has the value <code>"elementExample"</code>. Note that this is
     * case-preserving in XML, as are all of the operations of the DOM. The HTML DOM returns the
     * <code>tagName</code> of an HTML element in the canonical uppercase form, regardless of the
     * case in the source HTML document.
     */
    public String getTagName() {
        return element.nameOriginal;
    }

    /**
     * Retrieves an attribute value by name.
     * 
     * @param name The name of the attribute to retrieve.
     * @return The <code>Attr</code> value as a string, or the empty string if that attribute does
     *         not have a specified or default value.
     */
    public String getAttribute(String name) {
        return element.attr(name);
    }

    /**
     * Adds a new attribute. If an attribute with that name is already present in the element, its
     * value is changed to be that of the value parameter. This value is a simple string; it is not
     * parsed as it is being set. So any markup (such as syntax to be recognized as an entity
     * reference) is treated as literal text, and needs to be appropriately escaped by the
     * implementation when it is written out. In order to assign an attribute value that contains
     * entity references, the user must create an <code>Attr</code> node plus any <code>Text</code>
     * and <code>EntityReference</code> nodes, build the appropriate subtree, and use
     * <code>setAttributeNode</code> to assign it as the value of an attribute. <br>
     * To set an attribute with a qualified name and namespace URI, use the
     * <code>setAttributeNS</code> method.
     * 
     * @param name The name of the attribute to create or alter.
     * @param value Value to set in string form.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified name is not an XML
     *                name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public void setAttribute(String name, String value) throws DOMException {
        element.attr(name, String.valueOf(value));
    }

    /**
     * Removes an attribute by name. If a default value for the removed attribute is defined in the
     * DTD, a new attribute immediately appears with the default value as well as the corresponding
     * namespace URI, local name, and prefix when applicable. The implementation may handle default
     * values from other schemas similarly but applications should use
     * <code>Document.normalizeDocument()</code> to guarantee this information is up-to-date. <br>
     * If no attribute with this name is found, this method has no effect. <br>
     * To remove an attribute by local name and namespace URI, use the
     * <code>removeAttributeNS</code> method.
     * 
     * @param name The name of the attribute to remove.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public void removeAttribute(String name) throws DOMException {
        element.removeAttribute(name);
    }

    /**
     * Retrieves an attribute node by name. <br>
     * To retrieve an attribute node by qualified name and namespace URI, use the
     * <code>getAttributeNodeNS</code> method.
     * 
     * @param name The name (<code>nodeName</code>) of the attribute to retrieve.
     * @return The <code>Attr</code> node with the specified name ( <code>nodeName</code>) or
     *         <code>null</code> if there is no such attribute.
     */
    public Attr getAttributeNode(String name) {
        return new JavaAPIAttr(this, "", name);
    }

    /**
     * Adds a new attribute node. If an attribute with that name ( <code>nodeName</code>) is already
     * present in the element, it is replaced by the new one. Replacing an attribute node by itself
     * has no effect. <br>
     * To add a new attribute node with a qualified name and namespace URI, use the
     * <code>setAttributeNodeNS</code> method.
     * 
     * @param newAttr The <code>Attr</code> node to add to the attribute list.
     * @return If the <code>newAttr</code> attribute replaces an existing attribute, the replaced
     *         <code>Attr</code> node is returned, otherwise <code>null</code> is returned.
     * @exception DOMException WRONG_DOCUMENT_ERR: Raised if <code>newAttr</code> was created from a
     *                different document than the one that created the element. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                INUSE_ATTRIBUTE_ERR: Raised if <code>newAttr</code> is already an attribute of
     *                another <code>Element</code> object. The DOM user must explicitly clone
     *                <code>Attr</code> nodes to re-use them in other elements.
     */
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Removes the specified attribute node. If a default value for the removed <code>Attr</code>
     * node is defined in the DTD, a new node immediately appears with the default value as well as
     * the corresponding namespace URI, local name, and prefix when applicable. The implementation
     * may handle default values from other schemas similarly but applications should use
     * <code>Document.normalizeDocument()</code> to guarantee this information is up-to-date.
     * 
     * @param oldAttr The <code>Attr</code> node to remove from the attribute list.
     * @return The <code>Attr</code> node that was removed.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                NOT_FOUND_ERR: Raised if <code>oldAttr</code> is not an attribute of the
     *                element.
     */
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        throw new Error();
    }

    /**
     * Returns a <code>NodeList</code> of all descendant <code>Elements</code> with a given tag
     * name, in document order.
     * 
     * @param name The name of the tag to match on. The special value "*" matches all tags.
     * @return A list of matching <code>Element</code> nodes.
     */
    public NodeList getElementsByTagName(String name) {
        throw new Error();
    }

    /**
     * Retrieves an attribute value by local name and namespace URI. <br>
     * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] ,
     * applications must use the value <code>null</code> as the <code>namespaceURI</code> parameter
     * for methods if they wish to have no namespace.
     * 
     * @param namespaceURI The namespace URI of the attribute to retrieve.
     * @param localName The local name of the attribute to retrieve.
     * @return The <code>Attr</code> value as a string, or the empty string if that attribute does
     *         not have a specified or default value.
     * @exception DOMException NOT_SUPPORTED_ERR: May be raised if the implementation does not
     *                support the feature <code>"XML"</code> and the language exposed through the
     *                Document does not support XML Namespaces (such as [<a
     *                href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
     * @since DOM Level 2
     */
    public String getAttributeNS(String namespaceURI, String localName) throws DOMException {
        throw new Error();
    }

    /**
     * Adds a new attribute. If an attribute with the same local name and namespace URI is already
     * present on the element, its prefix is changed to be the prefix part of the
     * <code>qualifiedName</code>, and its value is changed to be the <code>value</code> parameter.
     * This value is a simple string{ throw new Error();} it is not parsed as it is being set. So
     * any markup (such as syntax to be recognized as an entity reference) is treated as literal
     * text, and needs to be appropriately escaped by the implementation when it is written out. In
     * order to assign an attribute value that contains entity references, the user must create an
     * <code>Attr</code> node plus any <code>Text</code> and <code>EntityReference</code> nodes,
     * build the appropriate subtree, and use <code>setAttributeNodeNS</code> or
     * <code>setAttributeNode</code> to assign it as the value of an attribute. <br>
     * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] ,
     * applications must use the value <code>null</code> as the <code>namespaceURI</code> parameter
     * for methods if they wish to have no namespace.
     * 
     * @param namespaceURI The namespace URI of the attribute to create or alter.
     * @param qualifiedName The qualified name of the attribute to create or alter.
     * @param value The value to set in string form.
     * @exception DOMException INVALID_CHARACTER_ERR: Raised if the specified qualified name is not
     *                an XML name according to the XML version in use specified in the
     *                <code>Document.xmlVersion</code> attribute. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                NAMESPACE_ERR: Raised if the <code>qualifiedName</code> is malformed per the
     *                Namespaces in XML specification, if the <code>qualifiedName</code> has a
     *                prefix and the <code>namespaceURI</code> is <code>null</code>, if the
     *                <code>qualifiedName</code> has a prefix that is "xml" and the
     *                <code>namespaceURI</code> is different from "<a
     *                href='http://www.w3.org/XML/1998/namespace'>
     *                http://www.w3.org/XML/1998/namespace</a>", if the <code>qualifiedName</code>
     *                or its prefix is "xmlns" and the <code>namespaceURI</code> is different from
     *                "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>",
     *                or if the <code>namespaceURI</code> is
     *                "<a href='http://www.w3.org/2000/xmlns/'>http://www.w3.org/2000/xmlns/</a>"
     *                and neither the <code>qualifiedName</code> nor its prefix is "xmlns". <br>
     *                NOT_SUPPORTED_ERR: May be raised if the implementation does not support the
     *                feature <code>"XML"</code> and the language exposed through the Document does
     *                not support XML Namespaces (such as [<a
     *                href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
     * @since DOM Level 2
     */
    public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException {
        throw new Error();
    }

    /**
     * Removes an attribute by local name and namespace URI. If a default value for the removed
     * attribute is defined in the DTD, a new attribute immediately appears with the default value
     * as well as the corresponding namespace URI, local name, and prefix when applicable. The
     * implementation may handle default values from other schemas similarly but applications should
     * use <code>Document.normalizeDocument()</code> to guarantee this information is up-to-date. <br>
     * If no attribute with this local name and namespace URI is found, this method has no effect. <br>
     * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] ,
     * applications must use the value <code>null</code> as the <code>namespaceURI</code> parameter
     * for methods if they wish to have no namespace.
     * 
     * @param namespaceURI The namespace URI of the attribute to remove.
     * @param localName The local name of the attribute to remove.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                NOT_SUPPORTED_ERR: May be raised if the implementation does not support the
     *                feature <code>"XML"</code> and the language exposed through the Document does
     *                not support XML Namespaces (such as [<a
     *                href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
     * @since DOM Level 2
     */
    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
        throw new Error();
    }

    /**
     * Retrieves an <code>Attr</code> node by local name and namespace URI. <br>
     * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] ,
     * applications must use the value <code>null</code> as the <code>namespaceURI</code> parameter
     * for methods if they wish to have no namespace.
     * 
     * @param namespaceURI The namespace URI of the attribute to retrieve.
     * @param localName The local name of the attribute to retrieve.
     * @return The <code>Attr</code> node with the specified attribute local name and namespace URI
     *         or <code>null</code> if there is no such attribute.
     * @exception DOMException NOT_SUPPORTED_ERR: May be raised if the implementation does not
     *                support the feature <code>"XML"</code> and the language exposed through the
     *                Document does not support XML Namespaces (such as [<a
     *                href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
     * @since DOM Level 2
     */
    public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException {
        throw new Error();
    }

    /**
     * Adds a new attribute. If an attribute with that local name and that namespace URI is already
     * present in the element, it is replaced by the new one. Replacing an attribute node by itself
     * has no effect. <br>
     * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] ,
     * applications must use the value <code>null</code> as the <code>namespaceURI</code> parameter
     * for methods if they wish to have no namespace.
     * 
     * @param newAttr The <code>Attr</code> node to add to the attribute list.
     * @return If the <code>newAttr</code> attribute replaces an existing attribute with the same
     *         local name and namespace URI, the replaced <code>Attr</code> node is returned,
     *         otherwise <code>null</code> is returned.
     * @exception DOMException WRONG_DOCUMENT_ERR: Raised if <code>newAttr</code> was created from a
     *                different document than the one that created the element. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                INUSE_ATTRIBUTE_ERR: Raised if <code>newAttr</code> is already an attribute of
     *                another <code>Element</code> object. The DOM user must explicitly clone
     *                <code>Attr</code> nodes to re-use them in other elements. <br>
     *                NOT_SUPPORTED_ERR: May be raised if the implementation does not support the
     *                feature <code>"XML"</code> and the language exposed through the Document does
     *                not support XML Namespaces (such as [<a
     *                href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
     * @since DOM Level 2
     */
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        throw new Error();
    }

    /**
     * Returns a <code>NodeList</code> of all the descendant <code>Elements</code> with a given
     * local name and namespace URI in document order.
     * 
     * @param namespaceURI The namespace URI of the elements to match on. The special value "*"
     *            matches all namespaces.
     * @param localName The local name of the elements to match on. The special value "*" matches
     *            all local names.
     * @return A new <code>NodeList</code> object containing all the matched <code>Elements</code>.
     * @exception DOMException NOT_SUPPORTED_ERR: May be raised if the implementation does not
     *                support the feature <code>"XML"</code> and the language exposed through the
     *                Document does not support XML Namespaces (such as [<a
     *                href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
     * @since DOM Level 2
     */
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {
        throw new Error();
    }

    /**
     * Returns <code>true</code> when an attribute with a given name is specified on this element or
     * has a default value, <code>false</code> otherwise.
     * 
     * @param name The name of the attribute to look for.
     * @return <code>true</code> if an attribute with the given name is specified on this element or
     *         has a default value, <code>false</code> otherwise.
     * @since DOM Level 2
     */
    public boolean hasAttribute(String name) {
        throw new Error();
    }

    /**
     * Returns <code>true</code> when an attribute with a given local name and namespace URI is
     * specified on this element or has a default value, <code>false</code> otherwise. <br>
     * Per [<a href='http://www.w3.org/TR/1999/REC-xml-names-19990114/'>XML Namespaces</a>] ,
     * applications must use the value <code>null</code> as the <code>namespaceURI</code> parameter
     * for methods if they wish to have no namespace.
     * 
     * @param namespaceURI The namespace URI of the attribute to look for.
     * @param localName The local name of the attribute to look for.
     * @return <code>true</code> if an attribute with the given local name and namespace URI is
     *         specified or has a default value on this element, <code>false</code> otherwise.
     * @exception DOMException NOT_SUPPORTED_ERR: May be raised if the implementation does not
     *                support the feature <code>"XML"</code> and the language exposed through the
     *                Document does not support XML Namespaces (such as [<a
     *                href='http://www.w3.org/TR/1999/REC-html401-19991224/'>HTML 4.01</a>]).
     * @since DOM Level 2
     */
    public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException {
        throw new Error();
    }

    /**
     * The type information associated with this element.
     * 
     * @since DOM Level 3
     */
    public TypeInfo getSchemaTypeInfo() {
        throw new Error();
    }

    /**
     * If the parameter <code>isId</code> is <code>true</code>, this method declares the specified
     * attribute to be a user-determined ID attribute . This affects the value of
     * <code>Attr.isId</code> and the behavior of <code>Document.getElementById</code>, but does not
     * change any schema that may be in use, in particular this does not affect the
     * <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code> node. Use the value
     * <code>false</code> for the parameter <code>isId</code> to undeclare an attribute for being a
     * user-determined ID attribute. <br>
     * To specify an attribute by local name and namespace URI, use the
     * <code>setIdAttributeNS</code> method.
     * 
     * @param name The name of the attribute.
     * @param isId Whether the attribute is a of type ID.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                NOT_FOUND_ERR: Raised if the specified node is not an attribute of this
     *                element.
     * @since DOM Level 3
     */
    public void setIdAttribute(String name, boolean isId) throws DOMException {
        throw new Error();
    }

    /**
     * If the parameter <code>isId</code> is <code>true</code>, this method declares the specified
     * attribute to be a user-determined ID attribute . This affects the value of
     * <code>Attr.isId</code> and the behavior of <code>Document.getElementById</code>, but does not
     * change any schema that may be in use, in particular this does not affect the
     * <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code> node. Use the value
     * <code>false</code> for the parameter <code>isId</code> to undeclare an attribute for being a
     * user-determined ID attribute.
     * 
     * @param namespaceURI The namespace URI of the attribute.
     * @param localName The local name of the attribute.
     * @param isId Whether the attribute is a of type ID.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                NOT_FOUND_ERR: Raised if the specified node is not an attribute of this
     *                element.
     * @since DOM Level 3
     */
    public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
        throw new Error();
    }

    /**
     * If the parameter <code>isId</code> is <code>true</code>, this method declares the specified
     * attribute to be a user-determined ID attribute . This affects the value of
     * <code>Attr.isId</code> and the behavior of <code>Document.getElementById</code>, but does not
     * change any schema that may be in use, in particular this does not affect the
     * <code>Attr.schemaTypeInfo</code> of the specified <code>Attr</code> node. Use the value
     * <code>false</code> for the parameter <code>isId</code> to undeclare an attribute for being a
     * user-determined ID attribute.
     * 
     * @param idAttr The attribute node.
     * @param isId Whether the attribute is a of type ID.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly. <br>
     *                NOT_FOUND_ERR: Raised if the specified node is not an attribute of this
     *                element.
     * @since DOM Level 3
     */
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNodeValue() throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNodeValue(String nodeValue) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short getNodeType() {
        return Node.ELEMENT_NODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getParentNode() {
        return convert(element.parentNode());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NodeList getChildNodes() {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getFirstChild() {
        return convert(element.firstChild());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getLastChild() {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getPreviousSibling() {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node getNextSibling() {
        return convert(element.nextSibling());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Document getOwnerDocument() {
        return new JavaAPIDocument(element.ownerDocument());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node removeChild(Node oldChild) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node appendChild(Node newChild) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasChildNodes() {
        return element.firstChild() != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node cloneNode(boolean deep) {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void normalize() {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSupported(String feature, String version) {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNamespaceURI() {
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPrefix() {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPrefix(String prefix) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasAttributes() {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBaseURI() {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short compareDocumentPosition(Node other) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTextContent() throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTextContent(String textContent) throws DOMException {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSameNode(Node other) {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String lookupPrefix(String namespaceURI) {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDefaultNamespace(String namespaceURI) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String lookupNamespaceURI(String prefix) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEqualNode(Node arg) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getFeature(String feature, String version) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object setUserData(String key, Object data, UserDataHandler handler) {
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getUserData(String key) {
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
    private Node convert(js.dom.Node node) {
        if (node == null) {
            return null;
        } else if (node instanceof EmulateElement) {
            return new JavaAPIElement((EmulateElement) node);
        } else if (node instanceof EmulateText) {
            throw new Error();
        } else if (node instanceof EmulateDocument) {
            return new JavaAPIDocument((EmulateDocument) node);
        } else {
            throw new Error();
        }
    }
}
