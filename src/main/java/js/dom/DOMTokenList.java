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

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import jsx.style.StyleName;
import jsx.ui.Style;

/**
 * @version 2015/09/29 2:55:30
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "DOMTokenList")
public class DOMTokenList implements JavascriptNative {

    /**
     * <p>
     * Add class.
     * </p>
     * 
     * @param className A class name to add.
     */
    public native void add(String className);

    /**
     * <p>
     * Add class.
     * </p>
     * 
     * @param style A class name to add.
     */
    public void add(Style style) {
        CSSStyleSheet.define(style);

        add(StyleName.of(style));
    }

    /**
     * <p>
     * Remove class.
     * </p>
     * 
     * @param className A class name to remove.
     */
    public native void remove(String className);

    /**
     * <p>
     * Remove class.
     * </p>
     * 
     * @param style A class name to remove.
     */
    public void remove(Style style) {
        remove(StyleName.of(style));
    }

    /**
     * <p>
     * Removes class from string and returns false. If class doesn't exist it's added and the
     * function returns true.
     * </p>
     * 
     * @param className A class name to toggle.
     */
    public native boolean toggle(String className);

    /**
     * <p>
     * Removes class from string and returns false. If class doesn't exist it's added and the
     * function returns true.
     * </p>
     * 
     * @param style A class name to toggle.
     */
    public boolean toggle(Style style) {
        CSSStyleSheet.define(style);

        return toggle(StyleName.of(style));
    }

    /**
     * <p>
     * Test class.
     * </p>
     * 
     * @param className A class name to test.
     */
    public native boolean contains(String className);

    /**
     * <p>
     * Test class.
     * </p>
     * 
     * @param style A class name to test.
     */
    public boolean contains(Style style) {
        return contains(StyleName.of(style));
    }

    /**
     * <p>
     * Retrieve a number of class names.
     * </p>
     * 
     * @return
     */
    public native int length();

    /**
     * <p>
     * Retrieve class name by index.
     * </p>
     * 
     * @param index
     * @return
     */
    public native String item(int index);
}
