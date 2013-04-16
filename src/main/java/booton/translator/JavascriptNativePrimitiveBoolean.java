/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;


/**
 * @version 2013/04/16 14:37:53
 */
public interface JavascriptNativePrimitiveBoolean extends JavascriptNative {

    /**
     * <p>
     * Returns the primitive value of this object.
     * </p>
     * <p>
     * JavaScript calls the valueOf method to convert an object to a primitive value. You rarely
     * need to invoke the valueOf method yourself; JavaScript automatically invokes it when
     * encountering an object where a primitive value is expected.
     * </p>
     * <p>
     * You can create a function to be called in place of the default valueOf method. Your function
     * must take no arguments.
     * </p>
     * 
     * @return A primitive value.
     */
    boolean valueOf();
}
