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

import booton.translator.JavascriptNativePropertyAccessor;

/**
 * @version 2014/08/31 12:40:20
 */
public abstract class Attribute {

    /**
     * <p>
     * The attribute's name.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    protected abstract String name();

    /**
     * <p>
     * The attribute's name.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    protected abstract String namespaceURI();

    /**
     * <p>
     * The attribute's value.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    protected abstract String value();

    /**
     * <p>
     * Set the attribute's value.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    protected abstract void value(String value);
}
