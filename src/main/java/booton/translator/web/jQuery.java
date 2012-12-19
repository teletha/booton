/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.web;

import static booton.translator.web.WebSupport.*;

import java.util.Iterator;

import booton.css.CSS;
import booton.translator.JavascriptNative;
import booton.translator.dom.Element;

/**
 * @version 2012/12/10 13:23:39
 */
public abstract class jQuery implements Iterable<jQuery>, JavascriptNative {

    /**
     * <p>
     * Create child element.
     * </p>
     * 
     * @param name A element name.
     * @return Chainable API.
     */
    public jQuery child(String name) {
        return $(document.createElement(name)).appendTo(this);
    }

    /**
     * <p>
     * Create child element with class name.
     * </p>
     * 
     * @param name A element name.
     * @return Chainable API.
     */
    public jQuery child(Class<? extends CSS> className) {
        return child("span").addClass(className);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<jQuery> iterator() {
        return new Iterator<jQuery>() {

            /** The current position. */
            private int index = 0;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return index < size();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public jQuery next() {
                return $(get(index++));
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void remove() {
            }
        };
    }

    /**
     * <p>
     * Add elements to the set of matched elements.
     * </p>
     * 
     * @param selector A string representing a selector expression to find additional elements to
     *            add to the set of matched elements.
     * @return
     */
    public native jQuery add(String selector);

    /**
     * <p>
     * Add elements to the set of matched elements.
     * </p>
     * 
     * @param selector An existing jQuery object to add to the set of matched elements.
     * @return
     */
    public native jQuery add(jQuery other);

    /**
     * <p>
     * Adds the specified class(es) to each of the set of matched elements.
     * </p>
     * 
     * @param classNames One or more class names to be added to the class attribute of each matched
     *            element.
     * @return
     */
    public native jQuery addClass(String classNames);

    /**
     * <p>
     * Adds the specified class(es) to each of the set of matched elements.
     * </p>
     * 
     * @param classNames One or more class names to be added to the class attribute of each matched
     *            element.
     * @return
     */
    public native jQuery addClass(Class<? extends CSS> className);

    /**
     * <p>
     * Insert content, specified by the parameter, after each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents HTML string, DOM element, or jQuery object to insert after each element in
     *            the set of matched elements.
     * @return
     */
    public native jQuery after(String contents);

    /**
     * <p>
     * Insert content, specified by the parameter, after each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents HTML string, DOM element, or jQuery object to insert after each element in
     *            the set of matched elements.
     * @return
     */
    public native jQuery after(jQuery contents);

    /**
     * <p>
     * Add the previous set of elements on the stack to the current set.
     * </p>
     * 
     * @return
     */
    public native jQuery andSelf();

    /**
     * <p>
     * Insert content, specified by the parameter, to the end of each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents DOM element, HTML string, or jQuery object to insert at the end of each
     *            element in the set of matched elements.
     * @return
     */
    public native jQuery append(String contents);

    /**
     * <p>
     * Insert content, specified by the parameter, to the end of each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents DOM element, HTML string, or jQuery object to insert at the end of each
     *            element in the set of matched elements.
     * @return
     */
    public native jQuery append(jQuery contents);

    /**
     * <p>
     * Insert every element in the set of matched elements to the end of the target.
     * </p>
     * 
     * @param target A selector, element, HTML string, or jQuery object; the matched set of elements
     *            will be inserted at the end of the element(s) specified by this parameter.
     * @return
     */
    public native jQuery appendTo(String target);

    /**
     * <p>
     * Insert every element in the set of matched elements to the end of the target.
     * </p>
     * 
     * @param target A selector, element, HTML string, or jQuery object; the matched set of elements
     *            will be inserted at the end of the element(s) specified by this parameter.
     * @return
     */
    public native jQuery appendTo(jQuery target);

    /**
     * <p>
     * Get the value of an attribute for the first element in the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to get.
     * @return
     */
    public native String attr(String name);

    /**
     * <p>
     * Set one or more attributes for the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to set.
     * @param value A value to set for the attribute.
     * @return
     */
    public native jQuery attr(String name, String value);

    /**
     * <p>
     * Insert content, specified by the parameter, before each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents HTML string, DOM element, or jQuery object to insert before each element in
     *            the set of matched elements.
     * @return
     */
    public native jQuery before(String contents);

    /**
     * <p>
     * Insert content, specified by the parameter, before each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents HTML string, DOM element, or jQuery object to insert before each element in
     *            the set of matched elements.
     * @return
     */
    public native jQuery before(jQuery contents);

    /**
     * <p>
     * Get the children of each element in the set of matched elements, optionally filtered by a
     * selector.
     * </p>
     * 
     * @return
     */
    public native jQuery children();

    /**
     * <p>
     * Get the children of each element in the set of matched elements, optionally filtered by a
     * selector.
     * </p>
     * 
     * @param A string containing a selector expression to match elements against.
     * @return
     */
    public native jQuery children(String selector);

    /**
     * <p>
     * This is a shortcut for .trigger("click").
     * </p>
     * 
     * @return
     */
    public native jQuery click();

    /**
     * <p>
     * Bind an event handler to the "click" JavaScript event, or trigger that event on an element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery click(Listener listener);

    /**
     * <p>
     * For each element in the set, get the first element that matches the selector by testing the
     * element itself and traversing up through its ancestors in the DOM tree.
     * </p>
     * 
     * @param selector A string containing a selector expression to match elements against.
     * @return
     */
    public native jQuery closest(String selector);

    /**
     * <p>
     * Get the value of a style property for the first element in the set of matched elements.
     * </p>
     * 
     * @param property A CSS property.
     * @return
     */
    public native String css(String property);

    /**
     * <p>
     * Set one or more CSS properties for the set of matched elements.
     * </p>
     * 
     * @param property A CSS property name.
     * @param value A value to set for the property.
     * @return
     */
    public native jQuery css(String property, String value);

    /**
     * <p>
     * This is a shortcut for .trigger("dblclick").
     * </p>
     * 
     * @return
     */
    public native jQuery dblclick();

    /**
     * <p>
     * Bind an event handler to the "dblclick" JavaScript event, or trigger that event on an
     * element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery dblclick(Listener listener);

    /**
     * <p>
     * Remove all child nodes of the set of matched elements from the DOM.
     * </p>
     * 
     * @return
     */
    public native jQuery empty();

    /**
     * <p>
     * Retrieve the DOM elements matched by the jQuery object.
     * </p>
     * 
     * @param index A zero-based integer indicating which element to retrieve.
     * @return
     */
    public native Element get(int index);

    /**
     * <p>
     * Hide the matched elements.
     * </p>
     * 
     * @return
     */
    public native jQuery hide();

    /**
     * <p>
     * This is a shortcut for .trigger("keydown").
     * </p>
     * 
     * @return
     */
    public native jQuery keydown();

    /**
     * <p>
     * Bind an event handler to the "keydown" JavaScript event, or trigger that event on an element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery keydown(Listener listener);

    /**
     * <p>
     * This is a shortcut for .trigger("keypress").
     * </p>
     * 
     * @return
     */
    public native jQuery keypress();

    /**
     * <p>
     * Bind an event handler to the "keypress" JavaScript event, or trigger that event on an
     * element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery keypress(Listener listener);

    /**
     * <p>
     * This is a shortcut for .trigger("keyup").
     * </p>
     * 
     * @return
     */
    public native jQuery keyup();

    /**
     * <p>
     * Bind an event handler to the "keyup" JavaScript event, or trigger that event on an element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery keyup(Listener listener);

    /**
     * <p>
     * Get the immediately following sibling of each element in the set of matched elements. If a
     * selector is provided, it retrieves the next sibling only if it matches that selector.
     * </p>
     * 
     * @return
     */
    public native jQuery next();

    /**
     * <p>
     * Get the immediately following sibling of each element in the set of matched elements. If a
     * selector is provided, it retrieves the next sibling only if it matches that selector.
     * </p>
     * 
     * @param selector A string containing a selector expression to match elements against.
     * @return
     */
    public native jQuery next(String selector);

    /**
     * <p>
     * Remove an event handler.
     * </p>
     * 
     * @param eventType One or more space-separated event types and optional namespaces, or just
     *            namespaces, such as "click", "keydown.myPlugin", or ".myPlugin".
     * @param listener A handler function previously attached for the event(s), or the special value
     *            false.
     * @return
     */
    public native jQuery off(String eventType, Listener listener);

    /**
     * <p>
     * Attach an event handler function for one or more events to the selected elements.
     * </p>
     * 
     * @param eventType One or more space-separated event types and optional namespaces, such as
     *            "click" or "keydown.myPlugin".
     * @param listener A function to execute when the event is triggered. The value false is also
     *            allowed as a shorthand for a function that simply does return false.
     * @return
     */
    public native jQuery on(String eventType, Listener listener);

    /**
     * <p>
     * Get the parent of each element in the current set of matched elements, optionally filtered by
     * a selector.
     * </p>
     * 
     * @return
     */
    public native jQuery parent();

    /**
     * <p>
     * Get the parent of each element in the current set of matched elements, optionally filtered by
     * a selector.
     * </p>
     * 
     * @param selector A string containing a selector expression to match elements against.
     * @return
     */
    public native jQuery parent(String selector);

    /**
     * <p>
     * Remove a single class, multiple classes, or all classes from each element in the set of
     * matched elements.
     * </p>
     * 
     * @param classNames One or more space-separated classes to be removed from the class attribute
     *            of each matched element.
     * @return
     */
    public native jQuery removeClass(String classNames);

    /**
     * <p>
     * Remove a single class, multiple classes, or all classes from each element in the set of
     * matched elements.
     * </p>
     * 
     * @param classNames One or more space-separated classes to be removed from the class attribute
     *            of each matched element.
     * @return
     */
    public native jQuery removeClass(Class<? extends CSS> classNames);

    /**
     * <p>
     * Display the matched elements.
     * </p>
     * 
     * @return
     */
    public native jQuery show();

    /**
     * <p>
     * Return the number of elements in the jQuery object.
     * </p>
     * 
     * @return
     */
    public native int size();

    /**
     * <p>
     * Get the combined text contents of each element in the set of matched elements, including
     * their descendants.
     * </p>
     * 
     * @return
     */
    public native String text();

    /**
     * <p>
     * Set the content of each element in the set of matched elements to the specified text.
     * </p>
     * 
     * @param text
     * @return
     */
    public native jQuery text(String text);

    /**
     * <p>
     * Add or remove one or more classes from each element in the set of matched elements, depending
     * on either the class's presence or the value of the switch argument.
     * </p>
     * 
     * @param className One or more class names (separated by spaces) to be toggled for each element
     *            in the matched set.
     * @return
     */
    public native jQuery toggleClass(String classNames);

    /**
     * <p>
     * Add or remove one or more classes from each element in the set of matched elements, depending
     * on either the class's presence or the value of the switch argument.
     * </p>
     * 
     * @param className One or more class names (separated by spaces) to be toggled for each element
     *            in the matched set.
     * @return
     */
    public native jQuery toggleClass(Class<? extends CSS> classNames);

    /**
     * <p>
     * Get the current value of the first element in the set of matched elements.
     * </p>
     * <p>
     * The .val() method is primarily used to get the values of form elements such as input, select
     * and textarea. In the case of <select multiple="multiple"> elements, the .val() method returns
     * an array containing each selected option; if no option is selected, it returns null.
     * </p>
     * 
     * @return
     */
    public native String val();

    /**
     * <p>
     * Set the value of each element in the set of matched elements.
     * </p>
     * <p>
     * The .val() method is primarily used to get the values of form elements such as input, select
     * and textarea. In the case of <select multiple="multiple"> elements, the .val() method returns
     * an array containing each selected option; if no option is selected, it returns null.
     * </p>
     * 
     * @param value A string of text or an array of strings corresponding to the value of each
     *            matched element to set as selected/checked.
     * @return
     */
    public native jQuery val(String value);

    /**
     * @version 2012/12/02 23:08:01
     */
    public static interface Listener extends JavascriptNative {

        /**
         * <p>
         * Handle registered event.
         * </p>
         * 
         * @param event
         * @return
         */
        void handler(Event event);
    }

    /**
     * @version 2012/12/02 23:06:56
     */
    public static class Event implements JavascriptNative {

        /** The DOM element that initiated the event. */
        public Element target;

        /** The current DOM element within the event bubbling phase. */
        public Element currentTarget;

        /** The other DOM element involved in the event, if any. */
        public Element relatedTarget;

        /** The element where the currently-called jQuery event handler was attached. */
        public Element delegateTarget;

        /** The namespace specified when the event was triggered. */
        public String namespace;

        /** The mouse position relative to the left edge of the document. */
        public int pageX;

        /** The mouse position relative to the top edge of the document. */
        public int pageY;

        /**
         * The difference in milliseconds between the time the browser created the event and January
         * 1, 1970.
         */
        public long timeStamp;

        /** Describes the nature of the event. */
        public String type;

        /**
         * For key or mouse events, this property indicates the specific key or button that was
         * pressed.
         */
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
         * Prevents the event from bubbling up the DOM tree, preventing any parent handlers from
         * being notified of the event.
         * </p>
         */
        public native void stopPropagation();

        /**
         * <p>
         * Keeps the rest of the handlers from being executed and prevents the event from bubbling
         * up the DOM tree.
         * </p>
         */
        public native void stopImmediatePropagation();
    }
}
