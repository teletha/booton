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

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @version 2014/01/22 23:05:34
 */
class JavaNodeList implements NodeList {

    /** The delegator. */
    private js.dom.NodeList<Element> list;

    /**
     * @param list
     */
    JavaNodeList(js.dom.Node node) {
        this.list = new JavaNonLiveNodeList(node);
    }

    /**
     * @param list
     */
    JavaNodeList(js.dom.NodeList<Element> list) {
        this.list = list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node item(int index) {
        return JavaElement.convert(list.item(index));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLength() {
        return list.length();
    }
}
