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

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativePropertyAccessor;

/**
 * @version 2013/07/29 17:06:12
 */
@JavascriptAPIProvider
public class ClientRect implements JavascriptNative {

    /**
     * <p>
     * Width of the rectangle box (This is identical to right minus left)
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float width();

    /**
     * <p>
     * Height of the rectangle box (This is identical to bottom minus top).
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float height();

    /**
     * <p>
     * Y-coordinate, relative to the viewport origin, of the top of the rectangle box.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float top();

    /**
     * <p>
     * X-coordinate, relative to the viewport origin, of the right of the rectangle box.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float right();

    /**
     * <p>
     * Y-coordinate, relative to the viewport origin, of the bottom of the rectangle box.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float bottom();

    /**
     * <p>
     * X-coordinate, relative to the viewport origin, of the left of the rectangle box.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float left();
}
