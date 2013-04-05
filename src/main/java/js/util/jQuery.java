/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import static js.lang.Global.*;

import java.util.Iterator;

import js.dom.Element;
import js.dom.Image;
import js.ui.UI;
import booton.css.CSS;
import booton.translator.JavascriptNative;

/**
 * @version 2013/04/03 9:26:06
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
     * @param Title A element name.
     * @return Chainable API.
     */
    public jQuery child(Class<? extends CSS> className) {
        return child("span").addClass(className);
    }

    /**
     * <p>
     * Create child element with class name.
     * </p>
     * 
     * @param Title A element name.
     * @return Chainable API.
     */
    public jQuery child(CSS className) {
        return child("span").addClass(className);
    }

    /**
     * <p>
     * Create child user interface.
     * </p>
     * 
     * @param ui A child ui.
     * @return Chainable API.
     */
    public <T extends UI> T child(T ui) {
        append(ui.root);

        return ui;
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
     * Adds the specified class(es) to each of the set of matched elements.
     * </p>
     * 
     * @param classNames One or more class names to be added to the class attribute of each matched
     *            element.
     * @return
     */
    public Image image(Class<? extends CSS> className) {
        return new Image(this, className);
    }

    /**
     * <p>
     * Bind an event handler to the "right click" JavaScript event, or trigger that event on an
     * element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public jQuery contextmenu(Listener listener) {
        return on("contextmenu", listener);
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
     * Adds the specified class(es) to each of the set of matched elements.
     * </p>
     * 
     * @param classes A list of class names to assign.
     * @return Chainable API.
     */
    public jQuery addClass(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            addClass(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Adds the specified class(es) to each of the set of matched elements.
     * </p>
     * 
     * @param classNames One or more class names to be added to the class attribute of each matched
     *            element.
     * @return
     */
    public native jQuery addClass(CSS className);

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
     * Insert content, specified by the parameter, to the end of each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents DOM element, HTML string, or jQuery object to insert at the end of each
     *            element in the set of matched elements.
     * @return
     */
    public native jQuery append(Element contents);

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
    public jQuery append(UI contents) {
        return append(contents.root);
    }

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
     * Set one or more attributes for the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to set.
     * @param value A value to set for the attribute.
     * @return
     */
    public native jQuery attr(String name, int value);

    /**
     * <p>
     * Set one or more attributes for the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to set.
     * @param value A value to set for the attribute.
     * @return
     */
    public native jQuery attr(String name, long value);

    /**
     * <p>
     * Set one or more attributes for the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to set.
     * @param value A value to set for the attribute.
     * @return
     */
    public native jQuery attr(String name, float value);

    /**
     * <p>
     * Set one or more attributes for the set of matched elements.
     * </p>
     * 
     * @param name The name of the attribute to set.
     * @param value A value to set for the attribute.
     * @return
     */
    public native jQuery attr(String name, double value);

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
     * Set one or more CSS properties for the set of matched elements.
     * </p>
     * 
     * @param property A CSS property name.
     * @param value A value to set for the property.
     * @return
     */
    public native jQuery css(String property, int value);

    /**
     * <p>
     * Set one or more CSS properties for the set of matched elements.
     * </p>
     * 
     * @param property A CSS property name.
     * @param value A value to set for the property.
     * @return
     */
    public native jQuery css(String property, long value);

    /**
     * <p>
     * Set one or more CSS properties for the set of matched elements.
     * </p>
     * 
     * @param property A CSS property name.
     * @param value A value to set for the property.
     * @return
     */
    public native jQuery css(String property, float value);

    /**
     * <p>
     * Set one or more CSS properties for the set of matched elements.
     * </p>
     * 
     * @param property A CSS property name.
     * @param value A value to set for the property.
     * @return
     */
    public native jQuery css(String property, double value);

    /**
     * <p>
     * Return the value at the named data store for the first element in the jQuery collection, as
     * set by data(name, value) or by an HTML5 data-* attribute.
     * </p>
     * 
     * @param key Name of the data stored.
     * @return
     */
    private native Object data(String key);

    /**
     * <p>
     * Store arbitrary data associated with the matched elements.
     * </p>
     * 
     * @param key A string naming the piece of data to set.
     * @param data The new data value; it can be any Javascript type including Array or Object.
     * @return
     */
    private native jQuery data(String key, Object data);

    /**
     * <p>
     * Get typed key-value pair.
     * </p>
     * 
     * @param key A typed key.
     * @return A paired value.
     */
    public <T> T data(Class<T> key) {
        return key == null ? null : (T) data(key.getClass().getName());
    }

    /**
     * <p>
     * Set typed key-value pair.
     * </p>
     * 
     * @param value A paired value.
     * @return
     */
    public jQuery data(Object value) {
        if (value != null) {
            data(value.getClass().getName(), value);
        }

        // API definition
        return this;
    }

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
     * Display the matched elements by fading them to opaque.
     * </p>
     * 
     * @return
     */
    public native jQuery fadeIn();

    /**
     * <p>
     * Display the matched elements by fading them to opaque.
     * </p>
     * 
     * @param ms number determining how long the animation will run.
     * @return
     */
    public native jQuery fadeIn(int ms);

    /**
     * <p>
     * Hide the matched elements by fading them to transparent.
     * </p>
     * 
     * @return
     */
    public native jQuery fadeOut();

    /**
     * <p>
     * Hide the matched elements by fading them to transparent.
     * </p>
     * 
     * @param ms number determining how long the animation will run.
     * @return
     */
    public native jQuery fadeOut(int ms);

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
     * Determine whether any of the matched elements are assigned the given class.
     * </p>
     * 
     * @param className The class name to search for.
     * @return A result
     */
    public native boolean hasClass(String className);

    /**
     * <p>
     * Determine whether any of the matched elements are assigned the given class.
     * </p>
     * 
     * @param className The class name to search for.
     * @return A result
     */
    public native boolean hasClass(Class<? extends CSS> className);

    /**
     * <p>
     * Determine whether any of the matched elements are assigned the given class.
     * </p>
     * 
     * @param classes A list of class names to check.
     * @return A result.
     */
    public boolean hasClass(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            if (!hasClass(clazz)) {
                return false;
            }
        }
        return true;
    }

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
     * Get the current computed height for the first element in the set of matched elements.
     * </p>
     * <p>
     * The difference between .css('height') and .height() is that the latter returns a unit-less
     * pixel value (for example, 400) while the former returns a value with units intact (for
     * example, 400px). The .height() method is recommended when an element's height needs to be
     * used in a mathematical calculation.
     * </p>
     * 
     * @return
     */
    public native int height();

    /**
     * <p>
     * Get the current computed height for the first element in the set of matched elements,
     * including padding but not border.
     * </p>
     * 
     * @return
     */
    public native int innerHeight();

    /**
     * <p>
     * Get the current computed height for the first element in the set of matched elements,
     * including padding, border, and optionally margin. Returns an integer (without "px")
     * representation of the value or null if called on an empty set of elements.
     * </p>
     * 
     * @return
     */
    public native int outerHeight();

    /**
     * <p>
     * Get the current computed height for the first element in the set of matched elements,
     * including padding, border, and optionally margin. Returns an integer (without "px")
     * representation of the value or null if called on an empty set of elements.
     * </p>
     * 
     * @param includeMargin A Boolean indicating whether to include the element's margin in the
     *            calculation.
     * @return
     */
    public native int outerHeight(boolean includeMargin);

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
     * Bind an event handler to the “mousedown” JavaScript event, or trigger that event on an
     * element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery mousedown(Listener listener);

    /**
     * <p>
     * Bind an event handler to be fired when the mouse enters an element, or trigger that handler
     * on an element.
     * </p>
     * <p>
     * The mouseenter JavaScript event is proprietary to Internet Explorer. Because of the event's
     * general utility, jQuery simulates this event so that it can be used regardless of browser.
     * This event is sent to an element when the mouse pointer enters the element. Any HTML element
     * can receive this event.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery mouseenter(Listener listener);

    /**
     * <p>
     * Bind an event handler to be fired when the mouse leaves an element, or trigger that handler
     * on an element.
     * </p>
     * <p>
     * The mouseleave JavaScript event is proprietary to Internet Explorer. Because of the event's
     * general utility, jQuery simulates this event so that it can be used regardless of browser.
     * This event is sent to an element when the mouse pointer leaves the element. Any HTML element
     * can receive this event.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery mouseleave(Listener listener);

    /**
     * <p>
     * Bind an event handler to the “mousemove” JavaScript event, or trigger that event on an
     * element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery mousemove(Listener listener);

    /**
     * <p>
     * Bind an event handler to the "mouseout" JavaScript event, or trigger that event on an
     * element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery mouseout(Listener listener);

    /**
     * <p>
     * Bind an event handler to the “mouseover” JavaScript event, or trigger that event on an eleme.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery mouseover(Listener listener);

    /**
     * <p>
     * Bind an event handler to the “mouseup” JavaScript event, or trigger that event on an element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery mouseup(Listener listener);

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
     * Get the current coordinates of the first element in the set of matched elements, relative to
     * the document.
     * </p>
     * <p>
     * The .offset() method allows us to retrieve the current position of an element relative to the
     * document. Contrast this with .position(), which retrieves the current position relative to
     * the offset parent. When positioning a new element on top of an existing one for global
     * manipulation (in particular, for implementing drag-and-drop), .offset() is the more useful.
     * </p>
     */
    public native Offset offset();

    /**
     * <p>
     * Remove an event handler.
     * </p>
     * 
     * @param event An object where the string keys represent one or more space-separated event
     *            types and optional namespaces, and the values represent handler functions
     *            previously attached for the event(s).
     * @return
     */
    public native jQuery off(Event event);

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
     * Remove an event handler.
     * </p>
     * 
     * @param eventType One or more space-separated event types and optional namespaces, or just
     *            namespaces, such as "click", "keydown.myPlugin", or ".myPlugin".
     * @param selector A selector which should match the one originally passed to .on() when
     *            attaching event handlers.
     * @param listener A handler function previously attached for the event(s), or the special value
     *            false.
     * @return
     */
    public native jQuery off(String eventType, String selector, Listener listener);

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
     * Attach a handler to an event for the elements. The handler is executed at most once per
     * element.
     * </p>
     * 
     * @param eventType One or more space-separated event types and optional namespaces, such as
     *            "click" or "keydown.myPlugin".
     * @param listener A function to execute when the event is triggered. The value false is also
     *            allowed as a shorthand for a function that simply does return false.
     * @return
     */
    public native jQuery one(String eventType, Listener listener);

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
     * Get the current coordinates of the first element in the set of matched elements, relative to
     * the offset parent.
     * </p>
     * <p>
     * The .position() method allows us to retrieve the current position of an element relative to
     * the offset parent. Contrast this with .offset(), which retrieves the current position
     * relative to the document. When positioning a new element near another one and within the same
     * containing DOM element, .position() is the more useful.
     * </p>
     */
    public native Offset position();

    /**
     * <p>
     * Remove an attribute from each element in the set of matched elements.
     * </p>
     * 
     * @param attributeName An attribute to remove.
     * @return
     */
    public native jQuery removeAttr(String attributeName);

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
     * Remove a single class, multiple classes, or all classes from each element in the set of
     * matched elements.
     * </p>
     * 
     * @param classes A list of class names to remove.
     * @return Chainable API.
     */
    public jQuery removeClass(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            removeClass(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove a previously-stored piece of data.
     * </p>
     * 
     * @param key A string naming the piece of data to delete.
     * @return
     */
    private native jQuery removeData(String key);

    /**
     * <p>
     * This is a shortcut for .trigger("scroll").
     * </p>
     * 
     * @return
     */
    public native jQuery scroll();

    /**
     * <p>
     * Bind an event handler to the "scroll" JavaScript event, or trigger that event on an element.
     * </p>
     * 
     * @param listener A function to execute each time the event is triggered.
     * @return
     */
    public native jQuery scroll(Listener listener);

    /**
     * <p>
     * Get the current horizontal position of the scroll bar for the first element in the set of
     * matched elements.
     * </p>
     * <p>
     * The horizontal scroll position is the same as the number of pixels that are hidden from view
     * to the left of the scrollable area. If the scroll bar is at the very left, or if the element
     * is not scrollable, this number will be 0.
     * </p>
     * 
     * @return
     */
    public native int scrollLeft();

    /**
     * <p>
     * Get the current vertical position of the scroll bar for the first element in the set of
     * matched elements or set the vertical position of the scroll bar for every matched element.
     * </p>
     * <p>
     * The vertical scroll position is the same as the number of pixels that are hidden from view
     * above the scrollable area. If the scroll bar is at the very top, or if the element is not
     * scrollable, this number will be 0.
     * </p>
     * 
     * @return
     */
    public native int scrollTop();

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
     * Display the matched elements with a sliding motion.
     * </p>
     */
    public native jQuery slideDown();

    /**
     * <p>
     * Display the matched elements with a sliding motion.
     * </p>
     * 
     * @param duration A string or number determining how long the animation will run.
     * @return
     */
    public native jQuery slideDown(int duration);

    /**
     * <p>
     * Hide the matched elements with a sliding motion.
     * </p>
     */
    public native jQuery slideUp();

    /**
     * <p>
     * Hide the matched elements with a sliding motion.
     * </p>
     * 
     * @param duration A string or number determining how long the animation will run.
     * @return
     */
    public native jQuery slideUp(int duration);

    /**
     * <p>
     * Display or hide the matched elements with a sliding motion.
     * </p>
     */
    public native jQuery slideToggle();

    /**
     * <p>
     * Display or hide the matched elements with a sliding motion.
     * </p>
     * 
     * @param duration A string or number determining how long the animation will run.
     * @return
     */
    public native jQuery slideToggle(int duration);

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
     * Set the content of each element in the set of matched elements to the specified text.
     * </p>
     * 
     * @param text
     * @return
     */
    public native jQuery text(Object text);

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
     * Add or remove one or more classes from each element in the set of matched elements, depending
     * on either the class's presence or the value of the switch argument.
     * </p>
     * 
     * @param classes A list of class names to remove.
     * @return Chainable API.
     */
    public jQuery toggleClass(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            toggleClass(clazz);
        }

        // API definition
        return this;
    }

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
     * <p>
     * Get the current computed width for the first element in the set of matched elements.
     * </p>
     * <p>
     * The difference between .css(width) and .width() is that the latter returns a unit-less pixel
     * value (for example, 400) while the former returns a value with units intact (for example,
     * 400px). The .width() method is recommended when an element's width needs to be used in a
     * mathematical calculation.
     * </p>
     * 
     * @return
     */
    public native int width();

    /**
     * <p>
     * Get the current computed width for the first element in the set of matched elements,
     * including padding but not border.
     * </p>
     * 
     * @return
     */
    public native int innerWidth();

    /**
     * <p>
     * Get the current computed width for the first element in the set of matched elements,
     * including padding and border.
     * </p>
     * 
     * @return
     */
    public native int outerWidth();

    /**
     * <p>
     * Get the current computed width for the first element in the set of matched elements,
     * including padding and border.
     * </p>
     * 
     * @param includeMargin A Boolean indicating whether to include the element's margin in the
     *            calculation.
     * @return
     */
    public native int outerWidth(boolean includeMargin);

    /**
     * @version 2012/12/02 23:08:01
     */
    public static interface Listener {

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
     * @version 2013/04/02 19:04:44
     */
    public static class DebounceListener implements Listener, Runnable {

        /** The delay time. */
        private final int delay;

        /** The delegator. */
        private final Listener listener;

        /** The lastest event. */
        private Event event;

        /** The time out id. */
        private long id = -1;

        /**
         * @param listener
         */
        public DebounceListener(int delay, Listener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handler(Event event) {
            if (id != -1) {
                clearTimeout(id);
            }
            this.event = event;
            this.id = setTimeout(this, delay);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            id = -1;
            listener.handler(event);
            event = null;
        }
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

    /**
     * @version 2013/04/02 16:51:33
     */
    public static class Offset implements JavascriptNative {

        /** The top offset. */
        public int top;

        /** The left offset. */
        public int left;
    }
}
