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

/**
 * @version 2014/08/31 12:44:42
 */
class EmulateAttribute extends Attribute {

    /** The name. */
    private String uri;

    /** The name. */
    private String name;

    /** The value. */
    private String value;

    /**
     * @param name
     * @param value
     */
    public EmulateAttribute(String name, String value) {
        this(null, name, value);
    }

    /**
     * @param name
     * @param value
     */
    public EmulateAttribute(String uri, String name, String value) {
        this.uri = String.valueOf(uri).toLowerCase();
        this.name = String.valueOf(name).toLowerCase();
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String name() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String namespaceURI() {
        return uri;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String value() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void value(String value) {
        this.value = value;
    }
}
