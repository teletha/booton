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

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2013/07/01 3:47:02
 */
public class EmulateHTMLCollection extends HTMLCollection {

    /** The element holder. */
    private List<Element> items = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    public Element item(int index) {
        return items.get(index);
    }

    /**
     * <p>
     * Add contents.
     * </p>
     * 
     * @param contents
     */
    public void add(Object contents) {
        if (contents != null) {
            if (contents instanceof Element) {
                Element element = (Element) contents;

                // remove duplication for live emulation
                items.remove(element);

                // append it at last
                items.add(element);
            }
        }
    }
}
