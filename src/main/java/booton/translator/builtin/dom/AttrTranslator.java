/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin.dom;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.TypeInfo;

/**
 * @version 2012/12/02 10:23:39
 */
class AttrTranslator extends AbstractDOMSupport<Attr> {

    /**
     * Returns the name of this attribute. If <code>Node.localName</code> is different from
     * <code>null</code>, this attribute is a qualified name.
     */
    public native String getName();

    /**
     * <code>True</code> if this attribute was explicitly given a value in the instance document,
     * <code>false</code> otherwise. If the application changed the value of this attribute node
     * (even if it ends up having the same value as the default value) then it is set to
     * <code>true</code>. The implementation may handle attributes with default values from other
     * schemas similarly but applications should use <code>Document.normalizeDocument()</code> to
     * guarantee this information is up-to-date.
     */
    public native boolean getSpecified();

    /**
     * On retrieval, the value of the attribute is returned as a string. Character and general
     * entity references are replaced with their values. See also the method
     * <code>getAttribute</code> on the <code>Element</code> interface. <br>
     * On setting, this creates a <code>Text</code> node with the unparsed contents of the string,
     * i.e. any characters that an XML processor would recognize as markup are instead treated as
     * literal text. See also the method <code>Element.setAttribute()</code>. <br>
     * Some specialized implementations, such as some [<a
     * href='http://www.w3.org/TR/2003/REC-SVG11-20030114/'>SVG 1.1</a>] implementations, may do
     * normalization automatically, even after mutation; in such case, the value on retrieval may
     * differ from the value on setting.
     */
    public native String getValue();

    /**
     * On retrieval, the value of the attribute is returned as a string. Character and general
     * entity references are replaced with their values. See also the method
     * <code>getAttribute</code> on the <code>Element</code> interface. <br>
     * On setting, this creates a <code>Text</code> node with the unparsed contents of the string,
     * i.e. any characters that an XML processor would recognize as markup are instead treated as
     * literal text. See also the method <code>Element.setAttribute()</code>. <br>
     * Some specialized implementations, such as some [<a
     * href='http://www.w3.org/TR/2003/REC-SVG11-20030114/'>SVG 1.1</a>] implementations, may do
     * normalization automatically, even after mutation; in such case, the value on retrieval may
     * differ from the value on setting.
     * 
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised when the node is readonly.
     */
    public native void setValue(String value) throws DOMException;

    /**
     * The <code>Element</code> node this attribute is attached to or <code>null</code> if this
     * attribute is not in use.
     * 
     * @since DOM Level 2
     */
    public native Element getOwnerElement();

    /**
     * The type information associated with this attribute. While the type information contained in
     * this attribute is guarantee to be correct after loading the document or invoking
     * <code>Document.normalizeDocument()</code>, <code>schemaTypeInfo</code> may not be reliable if
     * the node was moved.
     * 
     * @since DOM Level 3
     */
    public native TypeInfo getSchemaTypeInfo();

    /**
     * Returns whether this attribute is known to be of type ID (i.e. to contain an identifier for
     * its owner element) or not. When it is and its value is unique, the <code>ownerElement</code>
     * of this attribute can be retrieved using the method <code>Document.getElementById</code> .
     * The implementation could use several ways to determine if an attribute node is known to
     * contain an identifier:
     * <ul>
     * <li>If validation occurred using an XML Schema [<a
     * href='http://www.w3.org/TR/2001/REC-xmlschema-1-20010502/'>XML Schema Part 1</a>] while
     * loading the document or while invoking <code>Document.normalizeDocument()</code>, the
     * post-schema-validation infoset contributions (PSVI contributions) values are used to
     * determine if this attribute is a schema-determined ID attribute using the <a
     * href='http://www.w3.org/TR/2003/REC-xptr-framework-20030325/#term-sdi'> schema-determined
     * ID</a> definition in [<a
     * href='http://www.w3.org/TR/2003/REC-xptr-framework-20030325/'>XPointer</a>] .</li>
     * <li>If validation occurred using a DTD while loading the document or while invoking
     * <code>Document.normalizeDocument()</code>, the infoset <b>[type definition]</b> value is used
     * to determine if this attribute is a DTD-determined ID attribute using the <a
     * href='http://www.w3.org/TR/2003/REC-xptr-framework-20030325/#term-ddi'> DTD-determined ID</a>
     * definition in [<a href='http://www.w3.org/TR/2003/REC-xptr-framework-20030325/'>XPointer</a>]
     * .</li>
     * <li>from the use of the methods <code>Element.setIdAttribute()</code>,
     * <code>Element.setIdAttributeNS()</code>, or <code>Element.setIdAttributeNode()</code>, i.e.
     * it is an user-determined ID attribute;
     * <p >
     * <b>Note:</b> XPointer framework (see section 3.2 in [<a
     * href='http://www.w3.org/TR/2003/REC-xptr-framework-20030325/'>XPointer</a>] ) consider the
     * DOM user-determined ID attribute as being part of the XPointer externally-determined ID
     * definition.</li>
     * <li>using mechanisms that are outside the scope of this specification, it is then an
     * externally-determined ID attribute. This includes using schema languages different from XML
     * schema and DTD.</li>
     * </ul>
     * <br>
     * If validation occurred while invoking <code>Document.normalizeDocument()</code>, all
     * user-determined ID attributes are reset and all attribute nodes ID information are then
     * reevaluated in accordance to the schema used. As a consequence, if the
     * <code>Attr.schemaTypeInfo</code> attribute contains an ID type, <code>isId</code> will always
     * return true.
     * 
     * @since DOM Level 3
     */
    public native boolean isId();
}
