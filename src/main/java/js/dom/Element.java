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
        classList().add(className);

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
     * @param content A content to insert.
     * @return Chainable API.
     */
    public Element after(Object content) {
        if (content != null) {
            Node parent = parentElement();

            if (parent != null) {
                parent.insertBefore(nodify(content), nextSibling());
            }
        }

        // API definition
        return this;
    }

    /**
     * <p>
     * Insert content to the end of this element.
     * </p>
     * 
     * @param content DOM element to insert at the end of this element.
     * @return Chainable API.
     */
    public Element append(Object content) {
        if (content != null) {
            appendChild(nodify(content));
        }

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
     * @param content A content to insert.
     * @return Chainable API.
     */
    public Element before(Object content) {
        if (content != null) {
            Node parent = parentElement();

            if (parent != null) {
                parent.insertBefore(nodify(content), this);
            }
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

    public Element css(String name, String value) {
        $(this).css(name, value);

        return this;
    }

    /**
     * <p>
     * Remove all child nodes of this element from the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public Element empty() {
        for (Element child : getElementsByClassName(EventListenable.class)) {
            child.off();
        }

        textContent("");

        // API definition
        return this;
    }

    /**
     * <p>
     * Determine whether any of this element is assigned the given class.
     * </p>
     * 
     * @param className The class name to search for.
     * @return A result
     */
    public boolean has(Class<? extends CSS> className) {
        return classList().contains(className);
    }

    /**
     * <p>
     * Determine whether any of this element is assigned the given class.
     * </p>
     * 
     * @param classes A list of class names to check.
     * @return A result.
     */
    public boolean has(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            if (!has(clazz)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Create child {@link Image} element.
     * </p>
     * 
     * @param classNames A class name to be added to the class attribute of each matched element.
     * @return A created image.
     */
    public Image image(Class<? extends CSS> className) {
        return new Image(this, className);
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
                    remove(EventListenable.class);
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
                        remove(EventListenable.class);
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
                add(EventListenable.class);
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
     * @param content DOM element to insert at the begining of this element.
     * @return Chainable API.
     */
    public Element prepend(Object content) {
        if (content != null) {
            insertBefore(nodify(content), firstChild());
        }

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
        for (Element child : getElementsByClassName(EventListenable.class)) {
            child.off();
        }
        off();

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
        classList().remove(className);

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
     * Add or remove class from this element, depending on either the class's presence or the value
     * of the switch argument.
     * </p>
     * 
     * @param className A class name to be toggled for this element.
     * @return Chainable API.
     */
    public Element toggle(Class<? extends CSS> className) {
        classList().toggle(className);

        // API definition
        return this;
    }

    /**
     * <p>
     * Add or remove one or more classes from this element, depending on either the class's presence
     * or the value of the switch argument.
     * </p>
     * 
     * @param classes A list of class names to add or remove.
     * @return Chainable API.
     */
    public Element toggle(Class<? extends CSS>... classes) {
        for (Class<? extends CSS> clazz : classes) {
            classList().toggle(clazz);
        }

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

    /**
     * <p>
     * Create {@link Node}.
     * </p>
     * 
     * @param content A content like {@link Element}, {@link String}.
     * @return
     */
    private Node nodify(Object content) {
        if (content instanceof Node) {
            return (Node) content;
        } else {
            return document.createTextNode(content.toString());
        }
    }

    @JavascriptNativePropertyAccessor
    protected abstract String value();

    @JavascriptNativePropertyAccessor
    protected abstract void value(String value);

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
    protected abstract String tagName();

    /**
     * <p>
     * Returns a token list of the class attribute of the element.
     * </p>
     * 
     * @return
     */
    @JavascriptNativePropertyAccessor()
    protected abstract DOMTokenList classList();

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
     * <p>
     * Returns the string value of the attribute with the specified name. If the named attribute
     * does not exist, the value returned will either be null.
     * </p>
     * 
     * @param name The name of the attribute to look for.
     * @return The string value of the specified attribute. If the attribute doesn't exist, the
     *         result is null.
     */
    protected native String getAttribute(String name);

    /**
     * <p>
     * Returns the string value of the attribute with the specified namespace and name. If the named
     * attribute does not exist, the value returned will either be null.
     * </p>
     * 
     * @param namespaces The namespace in which to look for the specified attribute.
     * @param name The name of the attribute to look for.
     * @return The string value of the specified attribute. If the attribute doesn't exist, the
     *         result is null.
     */
    protected native String getAttributeNS(String namespaces, String name);

    /**
     * <p>
     * Adds a new attribute or changes the value of an attribute with the given name.
     * </p>
     * 
     * @param name A string identifying the attribute to be set.
     * @param value The desired string value of the new attribute.
     */
    protected native void setAttribute(String name, String value);

    /**
     * <p>
     * Adds a new attribute or changes the value of an attribute with the given namespace and name.
     * </p>
     * 
     * @param namespace A string specifying the namespace of the attribute.
     * @param name A string identifying the attribute to be set.
     * @param value The desired string value of the new attribute.
     */
    protected native void setAttributeNS(String namespace, String name, String value);

    /**
     * <p>
     * Removes the specified attribute from an element.
     * </p>
     * 
     * @param name A string that names the attribute to be removed from the current node.
     */
    protected native void removeAttribute(String name);

    /**
     * <p>
     * Removes the specified attribute from an element.
     * </p>
     * 
     * @param namespace A string that contains the namespace of the attribute.
     * @param name A string that names the attribute to be removed from the current node.
     */
    protected native void removeAttributeNS(String namespace, String name);

    /**
     * <p>
     * Returns a boolean value indicating whether the current element has the specified attribute.
     * </p>
     * 
     * @param name The name of the attribute.
     * @return A result.
     */
    protected native boolean hasAttribute(String name);

    /**
     * <p>
     * Returns a boolean value indicating whether the current element has the specified attribute.
     * </p>
     * 
     * @param namespace A string specifying the namespace of the attribute.
     * @param name The name of the attribute.
     * @return A result.
     */
    protected native boolean hasAttributeNS(String namespace, String name);

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
    public final native NodeList<Element> querySelectorAll(String selector);

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
    public final native boolean matchesSelector(String selector);

    /**
     * <p>
     * Returns a set of elements which have all the given class names. When called on the document
     * object, the complete document is searched, including the root node. You may also call
     * getElementsByClassName on any element; it will return only elements which are descendants of
     * the specified root element with the given class names.
     * </p>
     * 
     * @param className A class name.
     * @return A HTMLCollection of found elements.
     */
    @JavascriptNativeProperty
    public abstract HTMLCollection getElementsByClassName(Class<? extends CSS> className);

    /**
     * <p>
     * Returns a HTMLCollection of elements with the given tag name. The complete document is
     * searched, including the root node. The returned HTMLCollection is live, meaning that it
     * updates itself automatically to stay in sync with the DOM tree without having to call
     * document.getElementsByTagName again.
     * </p>
     * 
     * @param tagName A string representing the name of the elements. The special string "*"
     *            represents all elements.
     * @return A live HTMLCollection (but see the note below) of found elements in the order they
     *         appear in the tree.
     */
    @JavascriptNativeProperty
    public final native HTMLCollection getElementsByTagName(String tagName);

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
     * <p>
     * Marker class.
     * </p>
     * 
     * @version 2013/07/28 18:15:38
     */
    private static class EventListenable extends CSS {
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
