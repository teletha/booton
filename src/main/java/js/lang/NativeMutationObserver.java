/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import js.dom.Element;
import js.dom.Node;
import js.dom.NodeList;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.Translator;

/**
 * <p>
 * MutationObserver provides developers a way to react to changes in a DOM. It is designed as a
 * replacement for Mutation Events defined in the DOM3 Events specification.
 * </p>
 * 
 * @version 2013/07/26 11:59:56
 */
public class NativeMutationObserver extends NativeObject {

    /** The event listener. */
    private final MutationListener listener;

    /**
     * <p>
     * Constructor for instantiating new DOM mutation observers.
     * </p>
     * 
     * @param listener
     */
    public NativeMutationObserver(MutationListener listener) {
        this.listener = listener;
    }

    /**
     * <p>
     * Registers the MutationObserver instance to receive notifications of DOM mutations on the
     * specified node.
     * </p>
     * 
     * @param target The Node on which to observe DOM mutations.
     * @param option A {@link MutationObserverOption} object, specifies which DOM mutations should
     *            be reported.
     */
    public native void observe(final Element target, MutationObserverOption option);

    /**
     * <p>
     * Stops the MutationObserver instance from receiving notifications of DOM mutations. Until the
     * observe() method is used again, observer's callback will not be invoked.
     * </p>
     */
    public native void disconnect();

    /**
     * <p>
     * Empties the MutationObserver instance's record queue and returns what was in there.
     * </p>
     * 
     * @return
     */
    public native MutationRecord[] takeRecords();

    /**
     * @version 2013/07/26 12:11:29
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeMutationObserver> {

        /**
         * <p>
         * Constructor for instantiating new DOM mutation observers.
         * </p>
         * 
         * @param listener
         */
        public String NativeMutationObserver(MutationListener listener) {
            return "new MutationObserver(" + param(0) + ")";
        }

        /**
         * <p>
         * Registers the MutationObserver instance to receive notifications of DOM mutations on the
         * specified node.
         * </p>
         * 
         * @param target The Node on which to observe DOM mutations.
         * @param option A {@link MutationObserverOption} object, specifies which DOM mutations
         *            should be reported.
         */
        public String observe(final Element target, MutationObserverOption option) {
            return that + ".observe(" + param(0) + "," + param(1) + ")";
        }
    }

    /**
     * @version 2013/07/26 12:01:00
     */
    public static interface MutationListener {

        /**
         * <p>
         * Listen mutation events.
         * </p>
         * 
         * @param events
         */
        void change(MutationRecord[] events);
    }

    /**
     * @version 2013/07/26 12:02:08
     */
    public static class MutationRecord {

        /**
         * <p>
         * Returns attributes if it was an attribute mutation. characterData if it was a mutation to
         * a CharacterData node. And childList if it was a mutation to the tree of nodes.
         * </p>
         */
        @JavascriptNativeProperty
        public String type;

        /**
         * <p>
         * Returns the node the mutation affected, depending on the type. For attributes, it is the
         * element whose attribute changed. For characterData, it is the CharacterData node. For
         * childList, it is the node whose children changed.
         * </p>
         */
        public Node target;

        /**
         * <p>
         * Return the nodes added, or null.
         * </p>
         */
        public NodeList addedNodes;

        /**
         * <p>
         * Return the nodes removed, or null.
         * </p>
         */
        public NodeList removedNodes;

        /**
         * <p>
         * Return the previous sibling of the added or removed nodes, or null.
         * </p>
         */
        public Node previousSibling;

        /**
         * <p>
         * Return the next sibling of the added or removed nodes, or null.
         * </p>
         */
        public Node nextSibling;

        /**
         * <p>
         * Returns the local name of the changed attribute, or null.
         * </p>
         */
        public String attributeName;

        /**
         * <p>
         * Returns the namespace of the changed attribute, or null.
         * </p>
         */
        public String attributeNamespace;

        /**
         * <p>
         * The return value depends on the type. For attributes, it is the value of the changed
         * attribute before the change. For characterData, it is the data of the changed node before
         * the change. For childList, it is null.
         * </p>
         */
        public String oldValue;
    }

    /**
     * @version 2013/07/26 12:01:18
     */
    public static class MutationObserverOption implements JavascriptNative {

        /**
         * <p>
         * Set to true if mutations to target's attributes are to be observed.
         * </p>
         */
        @JavascriptNativeProperty
        public boolean attributes = false;

        /**
         * <p>
         * Set to true if mutations to target's children are to be observed.
         * </p>
         */
        @JavascriptNativeProperty
        public boolean childList = false;

        /**
         * <p>
         * Set to true if mutations to target's data are to be observed.
         * </p>
         */
        @JavascriptNativeProperty
        public boolean characterData = false;

        /**
         * <p>
         * Set to true if mutations to not just target, but also target's descendants are to be
         * observed.
         * </p>
         */
        @JavascriptNativeProperty
        public boolean subtree = false;

        /**
         * <p>
         * Set to true if attributes is set to true and target's attribute value before the mutation
         * needs to be recorded.
         * </p>
         */
        @JavascriptNativeProperty
        public boolean attributeOldValue = false;

        /**
         * <p>
         * Set to true if characterData is set to true and target's data before the mutation needs
         * to be recorded.
         * </p>
         */
        @JavascriptNativeProperty
        public boolean characterDataOldValue = false;

        /**
         * <p>
         * Set to an array of attribute local names (without namespace) if not all attribute
         * mutations need to be observed.
         * </p>
         */
        @JavascriptNativeProperty
        public String[] attributeFilter;
    }
}
