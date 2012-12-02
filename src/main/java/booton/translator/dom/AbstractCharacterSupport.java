/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.dom;

import org.w3c.dom.DOMException;

/**
 * @version 2012/12/02 10:33:32
 */
abstract class AbstractCharacterSupport<T> extends AbstractDOMSupport<T> {

    /**
     * The character data of the node that implements this interface. The DOM implementation may not
     * put arbitrary limits on the amount of data that may be stored in a <code>CharacterData</code>
     * node. However, implementation limits may mean that the entirety of a node's data may not fit
     * into a single <code>DOMString</code>. In such cases, the user may call
     * <code>substringData</code> to retrieve the data in appropriately sized pieces.
     * 
     * @exception DOMException DOMSTRING_SIZE_ERR: Raised when it would return more characters than
     *                fit in a <code>DOMString</code> variable on the implementation platform.
     */
    public native String getData() throws DOMException;

    /**
     * The character data of the node that implements this interface. The DOM implementation may not
     * put arbitrary limits on the amount of data that may be stored in a <code>CharacterData</code>
     * node. However, implementation limits may mean that the entirety of a node's data may not fit
     * into a single <code>DOMString</code>. In such cases, the user may call
     * <code>substringData</code> to retrieve the data in appropriately sized pieces.
     * 
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised when the node is readonly.
     */
    public native void setData(String data) throws DOMException;

    /**
     * The number of 16-bit units that are available through <code>data</code> and the
     * <code>substringData</code> method below. This may have the value zero, i.e.,
     * <code>CharacterData</code> nodes may be empty.
     */
    public native int getLength();

    /**
     * Extracts a range of data from the node.
     * 
     * @param offset Start offset of substring to extract.
     * @param count The number of 16-bit units to extract.
     * @return The specified substring. If the sum of <code>offset</code> and <code>count</code>
     *         exceeds the <code>length</code>, then all 16-bit units to the end of the data are
     *         returned.
     * @exception DOMException INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
     *                negative or greater than the number of 16-bit units in <code>data</code>, or
     *                if the specified <code>count</code> is negative. <br>
     *                DOMSTRING_SIZE_ERR: Raised if the specified range of text does not fit into a
     *                <code>DOMString</code>.
     */
    public native String substringData(int offset, int count) throws DOMException;

    /**
     * Append the string to the end of the character data of the node. Upon success,
     * <code>data</code> provides access to the concatenation of <code>data</code> and the
     * <code>DOMString</code> specified.
     * 
     * @param arg The <code>DOMString</code> to append.
     * @exception DOMException NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public native void appendData(String arg) throws DOMException;

    /**
     * Insert a string at the specified 16-bit unit offset.
     * 
     * @param offset The character offset at which to insert.
     * @param arg The <code>DOMString</code> to insert.
     * @exception DOMException INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
     *                negative or greater than the number of 16-bit units in <code>data</code>. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public native void insertData(int offset, String arg) throws DOMException;

    /**
     * Remove a range of 16-bit units from the node. Upon success, <code>data</code> and
     * <code>length</code> reflect the change.
     * 
     * @param offset The offset from which to start removing.
     * @param count The number of 16-bit units to delete. If the sum of <code>offset</code> and
     *            <code>count</code> exceeds <code>length</code> then all 16-bit units from
     *            <code>offset</code> to the end of the data are deleted.
     * @exception DOMException INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
     *                negative or greater than the number of 16-bit units in <code>data</code>, or
     *                if the specified <code>count</code> is negative. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public native void deleteData(int offset, int count) throws DOMException;

    /**
     * Replace the characters starting at the specified 16-bit unit offset with the specified
     * string.
     * 
     * @param offset The offset from which to start replacing.
     * @param count The number of 16-bit units to replace. If the sum of <code>offset</code> and
     *            <code>count</code> exceeds <code>length</code>, then all 16-bit units to the end
     *            of the data are replaced; (i.e., the effect is the same as a <code>remove</code>
     *            method call with the same range, followed by an <code>append</code> method
     *            invocation).
     * @param arg The <code>DOMString</code> with which the range must be replaced.
     * @exception DOMException INDEX_SIZE_ERR: Raised if the specified <code>offset</code> is
     *                negative or greater than the number of 16-bit units in <code>data</code>, or
     *                if the specified <code>count</code> is negative. <br>
     *                NO_MODIFICATION_ALLOWED_ERR: Raised if this node is readonly.
     */
    public native void replaceData(int offset, int count, String arg) throws DOMException;
}
