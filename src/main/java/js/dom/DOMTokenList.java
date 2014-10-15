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

import jsx.style.StyleDeclaration;
import booton.css.CSS;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;

/**
 * @version 2013/03/22 16:42:04
 */
@JavascriptAPIProvider
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
     * @param className A class name to add.
     */
    public native void add(StyleDeclaration className);

    /**
     * <p>
     * Add class.
     * </p>
     * 
     * @param className A class name to add.
     */
    public native void add(Class<? extends CSS> className);

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
     * @param className A class name to remove.
     */
    public native void remove(StyleDeclaration className);

    /**
     * <p>
     * Remove class.
     * </p>
     * 
     * @param className A class name to remove.
     */
    public native void remove(Class<? extends CSS> className);

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
     * @param className A class name to toggle.
     */
    public native boolean toggle(Class<? extends CSS> className);

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
     * @param className A class name to test.
     */
    public native boolean contains(Class<? extends CSS> className);

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
