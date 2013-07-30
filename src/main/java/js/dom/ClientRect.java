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
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float width();

    /**
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float height();

    /**
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float top();

    /**
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float right();

    /**
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float bottom();

    /**
     * @return
     */
    @JavascriptNativePropertyAccessor
    public native float left();
}
