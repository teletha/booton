/*
 * Copyright (C) 2016 Nameless Production Committee
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
import jsx.ui.User;

/**
 * <p>
 * EventTarget is not common class in variaous platforms. (IE and Webkit doesn't have it.)
 * </p>
 * 
 * @version 2016/11/08 15:45:24
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
     * Registers the specified listener on the EventTarget it's called on.
     * </p>
     * 
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type
     *            occurs.
     */
    public void addEventListener(User type, NativeFunction listener) {
        addEventListener(type.name, listener);
    }

    /**
     * <p>
     * Registers the specified listener on the EventTarget it's called on.
     * </p>
     * 
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type
     *            occurs.
     */
    public void addEventListener(User type, Runnable listener) {
        addEventListener(type.name, new NativeFunction(listener));
    }

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
     * Removes the event listener previously registered.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener to be removed.
     */
    public void removeEventListener(User type, NativeFunction listener) {
        removeEventListener(type.name, listener);
    }

    /**
     * <p>
     * Removes the event listener previously registered.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener to be removed.
     */
    public void removeEventListener(User type, Runnable listener) {
        removeEventListener(type.name, new NativeFunction(listener));
    }

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
