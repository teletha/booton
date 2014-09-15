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

import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.JavascriptNativePropertyAccessor;
import booton.translator.Translator;

/**
 * @version 2014/08/31 12:11:27
 */
public abstract class Attributes implements JavascriptNative {

    /**
     * <p>
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor
    protected abstract int length();

    /**
     * @param index
     * @return
     */
    @JavascriptNativeProperty
    protected abstract Attribute get(int index);

    /**
     * @version 2014/09/14 2:27:03
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Attributes> {

        /**
         * <p>
         * </p>
         * 
         * @return
         */
        public String length() {
            return that + ".length";
        }

        /**
         * @param index
         * @return
         */
        public String get(int index) {
            return that + "[" + param(0) + "]";
        }
    }
}
