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

import static js.lang.Global.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import jsx.bwt.Listen;
import jsx.bwt.UIAction;
import jsx.bwt.UIEvent;
import booton.css.CSS;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.JavascriptNativePropertyAccessor;

/**
 * <p>
 * Enhanced {@link org.w3c.dom.Element} for web platform.
 * </p>
 * 
 * @version 2013/07/01 2:12:14
 */
@JavascriptAPIProvider
public abstract class Element extends Node implements JavascriptNative {

    /** The localName attribute must return the context object's local name. */
    @JavascriptNativeProperty
    public String localName;

    /**
     * <p>
     * The tagName attribute must run these steps:
     * </p>
     * <ol>
     * <li>If context object's namespace prefix is not null, let qualified name be its namespace
     * prefix, followed by a ":" (U+003A), followed by its local name. Otherwise, let qualified name
     * be its local name.</li>
     * <li>If the context object is in the HTML namespace and its node document is an HTML document,
     * let qualified name be converted to ASCII uppercase.</li>
     * <li>Return qualified name.</li>
     * </ol>
     */
    @JavascriptNativeProperty
    public String tagName;

    /** The class name list. */
    @JavascriptNativeProperty
    public DOMTokenList classList;

    /** The event listener holder. */
    private Map<UIAction, Listeners> events;

    /**
     * <p>
     * Adds the specified class to this elements.
     * </p>
     * 
     * @param classNames A class name to be added to the class attribute of this element.
     * @return Chainable API.
     */
    public Element add(Class<? extends CSS> className) {
        classList.add(className);

        // API definition
        return this;
    }

    /**
     * <p>
     * Adds the specified class(es) to this elements.
     * </p>
     * 
     * @param classes A list of class names to assign.
     * @return Chainable API.
     */
    public Element add(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            add(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content, specified by the parameter, after this element.
     * </p>
     * 
     * @param element A content to insert.
     * @return Chainable API.
     */
    public Element after(Element element) {
        Node parent = parentElement();

        if (parent != null) {
            parent.insertBefore(element, nextSibling());
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content to the end of this element.
     * </p>
     * 
     * @param contents DOM element to insert at the end of this element.
     * @return Chainable API.
     */
    public Element append(Object contents) {
        appendChild(contents);

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert this element to the end of the target element.
     * </p>
     * 
     * @param target This element will be inserted at the end of the element specified by this
     *            parameter.
     * @return Chainable API.
     */
    public Element appendTo(Element target) {
        if (target != null) {
            target.append(this);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Get the value of the specified attribute.
     * </p>
     * 
     * @param name The name of the attribute to get.
     * @return The specified attribute value.
     */
    public String attr(String name) {
        return getAttribute(String.valueOf(name));
    }

    /**
     * <p>
     * Set attribute for this element.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    public Element attr(String name, Object value) {
        return attr(null, name, value);
    }

    /**
     * <p>
     * Set attribute with namespace for this element.
     * </p>
     * 
     * @param namespace The namespace uri of the attribute.
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    public Element attr(String namespace, String name, Object value) {
        setAttributeNS(namespace, name, String.valueOf(value));

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content, specified by the parameter, before this element.
     * </p>
     * 
     * @param element A content to insert.
     * @return Chainable API.
     */
    public Element before(Element element) {
        Node parent = parentElement();

        if (parent != null) {
            parent.insertBefore(element, this);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Attach all event handlers which are defined in the given subscriber to the selected elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public Element bind(Object subscriber) {
        if (subscriber != null) {
            Class clazz = subscriber.getClass();
            String namespace = "." + clazz.getSimpleName() + subscriber.hashCode();

            for (Method method : clazz.getDeclaredMethods()) {
                Listen listen = method.getAnnotation(Listen.class);

                if (listen != null) {
                    EventListener listener = new Subscriber(subscriber, method, listen.abort());

                    // ===========================
                    // Execution Count Wrapper
                    // ===========================
                    int count = listen.count();

                    if (0 < count) {
                        listener = new Count(count, listener);
                    }

                    // ===========================
                    // Timing Related Wrappers
                    // ===========================
                    long time = listen.delay();

                    if (0 < time) {
                        listener = new Delay(time, listener);
                    }

                    time = listen.throttle();

                    if (0 < time) {
                        listener = new Throttle(time, listener);
                    }

                    time = listen.debounce();

                    if (0 < time) {
                        listener = new Debounce(time, listener);
                    }

                    for (UIAction type : listen.value()) {
                        // ===========================
                        // KeyCode Wrapper
                        // ===========================
                        int keyCode = type.code;

                        if (keyCode != -1) {
                            listener = new KeyBind(keyCode, listener);
                        }
                        on(type, listener);
                    }
                }
            }
        }

        // API defintion
        return this;
    }

    /**
     * <p>
     * Create child element.
     * </p>
     * 
     * @param name A element name.
     * @return A created child element.
     */
    public Element child(String name) {
        return document.createElement(name).appendTo(this);
    }

    /**
     * <p>
     * Create a child element with the specified class.
     * </p>
     * 
     * @param className A class name of the new child element.
     * @return A created child element.
     */
    public Element child(Class<? extends CSS> className) {
        return child("span", className);
    }

    /**
     * <p>
     * Create a child element with the specified class.
     * </p>
     * 
     * @param className A class name of the new child element.
     * @return A created child element.
     */
    public Element child(String name, Class<? extends CSS> className) {
        return child(name).add(className);
    }

    /**
     * <p>
     * Get the children of this element.
     * </p>
     * 
     * @return A list of child elements.
     */
    public List<Element> children() {
        List<Element> list = new ArrayList();
        Element element = firstElementChild();

        while (element != null) {
            list.add(element);

            element = element.nextElementSibling();
        }
        return list;
    }

    /**
     * <p>
     * Dispose this element.
     * </p>
     */
    private void dispose() {
        // Dispose child elements.
        for (Element child : children()) {
            child.dispose();
        }

        // =======================
        // Disposal Process
        // =======================
        // Dettach event handlers.
        off();
    }

    /**
     * <p>
     * Remove all child nodes of this element from the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public Element empty() {
        for (Element child : childElements()) {
            child.dispose();
        }

        textContent("");

        // API definition
        return this;
    }

    /**
     * <p>
     * Returns the first following sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first following sibling that is an element, and null otherwise.
     */
    public Element next() {
        return nextElementSibling();
    }

    /**
     * <p>
     * Dettach all event handlers from this element.
     * </p>
     * 
     * @return A chainable API.
     */
    public Element off() {
        if (events != null) {
            for (UIAction type : events.keySet()) {
                off(type);
            }
        }

        // API defintion
        return this;
    }

    /**
     * <p>
     * Dettach all specified-type event handlers from this element.
     * </p>
     * 
     * @return A chainable API.
     */
    public Element off(UIAction type) {
        if (events != null) {
            Listeners listeners = events.get(type);

            if (listeners != null) {
                events.remove(type);
                removeEventListener(type.name, listeners);

                if (events.size() == 0) {
                    events = null;
                }
            }
        }

        // API defintion
        return this;
    }

    /**
     * <p>
     * Dettach all event handlers which are defined in the given subscriber to the selected
     * elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public Element off(UIAction type, EventListener subscriber) {
        if (events != null && type != null && subscriber != null) {
            Listeners listeners = events.get(type);

            if (listeners != null) {
                int size = listeners.remove(subscriber);

                if (size == 0) {
                    events.remove(type);
                    removeEventListener(type.name, listeners);

                    if (events.size() == 0) {
                        events = null;
                    }
                }
            }
        }

        // API defintion
        return this;
    }

    /**
     * <p>
     * Attach all event handlers which are defined in the given subscriber to the selected elements.
     * </p>
     * 
     * @param subscriber A subscriber that holds user action event listeners.
     * @return A chainable API.
     */
    public Element on(UIAction type, EventListener subscriber) {
        if (type != null && subscriber != null) {
            if (events == null) {
                events = new HashMap();
            }

            Listeners listeners = events.get(type);

            if (listeners == null) {
                listeners = new Listeners();
                events.put(type, listeners);
                addEventListener(type.name, listeners);
            }
            listeners.add(subscriber);
        }

        // API defintion
        return this;
    }

    /**
     * <p>
     * Returns the first following sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first following sibling that is an element, and null otherwise.
     */
    public Element parent() {
        return parentElement();
    }

    /**
     * <p>
     * Insert content to the begining of this element.
     * </p>
     * 
     * @param contents DOM element to insert at the begining of this element.
     * @return Chainable API.
     */
    public Element prepend(Element contents) {
        insertBefore(contents, firstChild());

        // API definition
        return this;
    }

    /**
     * <p>
     * Returns the first preceding sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first preceding sibling that is an element, and null otherwise.
     */
    public Element prev() {
        return nextElementSibling();
    }

    /**
     * <p>
     * Remove this element from the DOM.
     * </p>
     * 
     * @param element
     * @return
     */
    public Element remove() {
        dispose();

        // parent node exist surely
        parent().removeChild(this);

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove an attribute from this element.
     * </p>
     * 
     * @param attributeName An attribute to remove.
     * @return A chainable API.
     */
    public Element remove(String name) {
        removeAttribute(String.valueOf(name));

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove a class from this element.
     * </p>
     * 
     * @param className A class name to be removed from the class attribute of this element.
     * @return Chainable API.
     */
    public Element remove(Class<? extends CSS> className) {
        classList.remove(className);

        // API definition
        return this;
    }

    /**
     * <p>
     * Remove a single class, multiple classes, or all classes from this element.
     * </p>
     * 
     * @param classes A list of class names to remove.
     * @return Chainable API.
     */
    public Element remove(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            remove(clazz);
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Get the combined text contents of this element, including its descendants.
     * </p>
     * 
     * @return A text contents.
     */
    public String text() {
        return textContent();
    }

    /**
     * <p>
     * Set the content of this element.
     * </p>
     * 
     * @param text A text to set.
     * @return Chainable API.
     */
    public Element text(Object text) {
        textContent(String.valueOf(text));

        // API definition
        return this;
    }

    /**
     * <p>
     * Get the current value of this element.
     * </p>
     * <p>
     * The .val() method is primarily used to get the values of form elements such as input, select
     * and textarea. In the case of <select multiple="multiple"> elements, the .val() method returns
     * an array containing each selected option; if no option is selected, it returns null.
     * </p>
     * 
     * @return
     */
    public String val() {
        return value();
    }

    @JavascriptNativePropertyAccessor
    protected abstract String value();

    @JavascriptNativePropertyAccessor
    protected abstract void value(String value);

    /**
     * <p>
     * Returns the DOM node's parent Element, or null if the node either has no parent, or its
     * parent isn't a DOM Element.
     * </p>
     * 
     * @return The parent element.
     */
    @JavascriptNativePropertyAccessor("children")
    protected abstract HTMLCollection childElements();

    /**
     * <p>
     * Returns the DOM node's parent Element, or null if the node either has no parent, or its
     * parent isn't a DOM Element.
     * </p>
     * 
     * @return The parent element.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element parentElement();

    /**
     * <p>
     * Returns the first child that is an element, and null otherwise.
     * </p>
     * 
     * @return The first child that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element firstElementChild();

    /**
     * <p>
     * Returns the last child that is an element, and null otherwise.
     * </p>
     * 
     * @return The last child that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element lastElementChild();

    /**
     * <p>
     * Returns the first preceding sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first preceding sibling that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element previousElementSibling();

    /**
     * <p>
     * Returns the first following sibling that is an element, and null otherwise.
     * </p>
     * 
     * @return The first following sibling that is an element, and null otherwise.
     */
    @JavascriptNativePropertyAccessor
    protected abstract Element nextElementSibling();

    /**
     * <p>
     * Registers the specified listener on the EventTarget it's called on.
     * </p>
     * 
     * @param type A string representing the event type to listen for.
     * @param listener The object that receives a notification when an event of the specified type
     *            occurs.
     */
    protected native void addEventListener(String type, EventListener listener);

    /**
     * <p>
     * Removes the event listener previously registered.
     * </p>
     * 
     * @param type A string representing the event type being removed.
     * @param listener The listener to be removed.
     */
    protected native void removeEventListener(String type, EventListener listener);

    /**
     * <p>
     * Indicates whether a node is a descendant of a given node.
     * </p>
     * 
     * @param target The node that's being compared against.
     * @return Return true if target is a descendant of this element, or element itself. Otherwise
     *         false.
     */
    protected native boolean contains(Element target);

    /**
     * {@inheritDoc}
     */
    protected native String getAttribute(String name);

    /**
     * {@inheritDoc}
     */
    protected native void setAttribute(String name, String value);

    /**
     * {@inheritDoc}
     */
    protected native void setAttributeNS(String namespace, String name, String value);

    /**
     * {@inheritDoc}
     */
    protected native void removeAttribute(String name);

    /**
     * <p>
     * Returns the first element that is a descendent of the element on which it is invoked that
     * matches the specified group of selectors.
     * </p>
     * 
     * @param selector
     * @return
     */
    @JavascriptNativeProperty
    protected final native Element querySelector(String selector);

    /**
     * <p>
     * Returns a non-live NodeList of all elements descended from the element on which it is invoked
     * that match the specified group of CSS selectors.
     * </p>
     * 
     * @param selector
     * @return
     */
    @JavascriptNativeProperty
    protected final native NodeList<Element> querySelectorAll(String selector);

    /**
     * <p>
     * Returns true if the element would be selected by the specified selector; otherwise, returns
     * false.
     * </p>
     * 
     * @param selector A css selector.
     * @return A result.
     */
    @JavascriptNativeProperty
    protected final native boolean matchesSelector(String selector);

    /**
     * <p>
     * The scrollIntoView() method scrolls the element into view.
     * </p>
     */
    @JavascriptNativeProperty
    public final native void scrollIntoView();

    /**
     * @version 2013/07/07 13:50:26
     */
    private static class Listeners implements EventListener {

        /** The actual listener holder. */
        private CopyOnWriteArrayList<EventListener> listeners = new CopyOnWriteArrayList();

        /**
         * <p>
         * Register event listener.
         * </p>
         * 
         * @param listener
         */
        private void add(EventListener listener) {
            listeners.addIfAbsent(listener);
        }

        /**
         * <p>
         * Unregister event listener.
         * </p>
         * 
         * @param listener
         * @return
         */
        private int remove(EventListener listener) {
            listeners.remove(listener);

            return listeners.size();
        }

        /**
         * <p>
         * Unregister all event listeners.
         * </p>
         */
        private void clear() {
            listeners.clear();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            for (EventListener listener : listeners) {
                listener.handleEvent(event);
            }
        }
    }

    /**
     * @version 2013/07/05 1:19:49
     */
    public static interface EventListener extends JavascriptNative {

        /**
         * <p>
         * Handle registered event.
         * </p>
         * 
         * @param event
         * @return
         */
        @JavascriptNativeProperty
        void handleEvent(UIEvent event);
    }

    /**
     * @version 2013/04/08 10:11:19
     */
    private static class Subscriber implements EventListener {

        /** The subscriber instance. */
        private final Object subscriber;

        /** The subscriber method. */
        private final Method method;

        /** The event termination. */
        private final boolean abort;

        /**
         * @param subscriber
         * @param method
         * @param abort
         */
        private Subscriber(Object subscriber, Method method, boolean abort) {
            this.subscriber = subscriber;
            this.method = method;
            this.abort = abort;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            if (abort) {
                event.stopPropagation();
                event.preventDefault();
            }

            try {
                method.invoke(subscriber, event);
            } catch (Exception e) {
                throw new Error(e);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 10:11:19
     */
    private static class KeyBind implements EventListener {

        /** The target key code. */
        private final int keyCode;

        /** The delegation. */
        private final EventListener listener;

        /**
         * @param keyCode
         * @param listener
         */
        private KeyBind(int keyCode, EventListener listener) {
            this.keyCode = keyCode;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            if (event.which == keyCode) {
                listener.handleEvent(event);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 13:42:03
     */
    private static class Count implements EventListener {

        /** The delegator. */
        private final EventListener listener;

        /** The execution limit. */
        private final int limit;

        /** The current number of execution. */
        private int current = 0;

        /**
         * @param limit
         */
        private Count(int limit, EventListener listener) {
            this.limit = limit;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            listener.handleEvent(event);

            if (++current == limit) {
                $(event.target).off(event);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 14:58:44
     */
    private static class Debounce implements EventListener, Runnable {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final EventListener listener;

        /** The lastest event. */
        private UIEvent event;

        /** The time out id. */
        private long id = -1;

        /**
         * @param listener
         */
        private Debounce(long delay, EventListener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
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
            listener.handleEvent(event);
            event = null;
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 14:37:30
     */
    private static class Throttle implements EventListener {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final EventListener listener;

        /** The latest execution time. */
        private long latest;

        /**
         * @param listener
         */
        private Throttle(long delay, EventListener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            long now = event.timeStamp;

            if (latest + delay < now) {
                latest = now;

                listener.handleEvent(event);
            }
        }
    }

    /**
     * <p>
     * Built-in listener wrapper.
     * </p>
     * 
     * @version 2013/04/08 13:57:10
     */
    private static class Delay implements EventListener, Runnable {

        /** The delay time. */
        private final long delay;

        /** The delegator. */
        private final EventListener listener;

        /** The lastest event. */
        private UIEvent event;

        /**
         * @param listener
         */
        public Delay(long delay, EventListener listener) {
            this.delay = delay;
            this.listener = listener;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(UIEvent event) {
            this.event = event;
            setTimeout(this, delay);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {
            listener.handleEvent(event);
        }
    }
}
