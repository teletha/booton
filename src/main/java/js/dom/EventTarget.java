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

import booton.translator.JavascriptNative;
import js.lang.NativeFunction;

/**
 * <p>
 * EventTarget is not common class in variaous platforms. (IE and Webkit doesn't have it.)
 * </p>
 * 
 * @version 2015/10/03 9:50:23
 */
public abstract class EventTarget<T extends EventTarget<T>> implements JavascriptNative {

    /**
     * <p>
     * Registers the specified listener on the EventTarget it's called on.
     * </p>
     * 
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type
     *            occurs.
     */
    public native void addEventListener(String type, NativeFunction listener);

    /**
     * <p>
     * Removes the event listener previously registered.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener to be removed.
     */
    public native void removeEventListener(String type, NativeFunction listener);

    /**
     * <p>
     * Dispatches an Event at the specified EventTarget, invoking the affected EventListeners in the
     * appropriate order. The normal event processing rules (including the capturing and optional
     * bubbling phase) apply to events dispatched manually with dispatchEvent().
     * </p>
     * 
     * @param event A Event object to be dispatched.
     */
    protected native void dispatchEvent(UIEvent event);
}
