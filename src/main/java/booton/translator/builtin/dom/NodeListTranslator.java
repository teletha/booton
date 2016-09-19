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

import org.w3c.dom.NodeList;

import booton.translator.Translator;

/**
 * @version 2012/12/02 10:37:04
 */
public class NodeListTranslator extends Translator<NodeList> {

    /**
     * Returns the <code>index</code>th item in the collection. If <code>index</code> is greater
     * than or equal to the number of nodes in the list, this returns <code>null</code>.
     * 
     * @param index Index into the collection.
     * @return The node at the <code>index</code>th position in the <code>NodeList</code>, or
     *         <code>null</code> if that is not a valid index.
     */
    public String item(int index) {
        return that + "[" + param(0) + "]";
    }

    /**
     * The number of nodes in the list. The range of valid child node indices is 0 to
     * <code>length-1</code> inclusive.
     */
    public String getLength() {
        return that + ".length";
    }
}
