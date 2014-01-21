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
import org.w3c.dom.TypeInfo;

/**
 * @version 2014/01/22 1:12:34
 */
class JavaAPIAttr implements Attr {

    private JavaAPIElement element;

    private String name;

    /**
     * @param element
     * @param name
     */
    JavaAPIAttr(JavaAPIElement element, String name) {
        this.element = element;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getSpecified() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return element.getAttribute(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(String value) throws DOMException {
        element.setAttribute(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public org.w3c.dom.Element getOwnerElement() {
        return element;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeInfo getSchemaTypeInfo() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isId() {
        return false;
    }
}
