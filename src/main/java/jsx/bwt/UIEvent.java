/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import js.dom.Element;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;

/**
 * @version 2012/12/02 23:06:56
 */
public class UIEvent implements JavascriptNative {

    /** The DOM element that initiated the event. */
    @JavascriptNativeProperty
    public Element target;

    /** The current DOM element within the event bubbling phase. */
    @JavascriptNativeProperty
    public Element currentTarget;

    /** The other DOM element involved in the event, if any. */
    @JavascriptNativeProperty
    public Element relatedTarget;

    /** The element where the currently-called jQuery event handler was attached. */
    @JavascriptNativeProperty
    public Element delegateTarget;

    /** The namespace specified when the event was triggered. */
    @JavascriptNativeProperty
    public String namespace;

    /** The mouse position relative to the left edge of the document. */
    @JavascriptNativeProperty
    public int pageX;

    /** The mouse position relative to the top edge of the document. */
    @JavascriptNativeProperty
    public int pageY;

    /**
     * The difference in milliseconds between the time the browser created the event and January 1,
     * 1970.
     */
    @JavascriptNativeProperty
    public long timeStamp;

    /** Describes the nature of the event. */
    @JavascriptNativeProperty
    public String type;

    /**
     * For key or mouse events, this property indicates the specific key or button that was pressed.
     */
    @JavascriptNativeProperty
    public int which;

    /**
     * <p>
     * Returns whether event.preventDefault() was ever called on this event object.
     * </p>
     * 
     * @return
     */
    public native boolean isDefaultPrevented();

    /**
     * <p>
     * Returns whether event.stopImmediatePropagation() was ever called on this event object.
     * </p>
     * 
     * @return
     */
    public native boolean isImmediatePropagationStopped();

    /**
     * <p>
     * Returns whether event.stopPropagation() was ever called on this event object.
     * </p>
     * 
     * @return
     */
    public native boolean isPropagationStopped();

    /**
     * <p>
     * If this method is called, the default action of the event will not be triggered.
     * </p>
     */
    public native void preventDefault();

    /**
     * <p>
     * Prevents the event from bubbling up the DOM tree, preventing any parent handlers from being
     * notified of the event.
     * </p>
     */
    public native void stopPropagation();

    /**
     * <p>
     * Keeps the rest of the handlers from being executed and prevents the event from bubbling up
     * the DOM tree.
     * </p>
     */
    public native void stopImmediatePropagation();

    /**
     * @version 2013/04/02 16:51:33
     */
    public static class Offset implements JavascriptNative {

        /** The top offset. */
        @JavascriptNativeProperty
        public int top;

        /** The left offset. */
        @JavascriptNativeProperty
        public int left;
    }
}