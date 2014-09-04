/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import kiss.I;
import booton.css.CSS;
import booton.virtual.VNode;

/**
 * @version 2014/09/04 16:39:32
 */
public class VirtualStructure {

    /** The node stack. */
    private final Deque<VNode> nodes = new ArrayDeque();

    /** The current node. */
    private VNode current;

    /**
     * 
     */
    public VirtualStructure() {
        this(new VNode("div"));
    }

    /**
     * 
     */
    public VirtualStructure(VNode root) {
        nodes.add(root);
        current = root;
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public void h(Object... children) {
        h(null, children);
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public void h(Class<? extends CSS> css, Object... children) {

    }

    /**
     * <p>
     * Add child item.
     * </p>
     * 
     * @param child
     */
    private void add(Object child) {
        if (child instanceof ObservableValue) {

        } else {
        }
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public void h(Runnable children) {
        h(null, children);
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public void h(Class<? extends CSS> css, Runnable children) {
    }

    public <T> void v(ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass, ObservableValue<? extends Predicate<T>> filter) {
        for (T item : list) {
            Widget<T> child = I.make(childWidgetClass);
            child.context = item;

            child.virtualize(this);
        }
    }

    public <T> void v(Class<? extends CSS> css, ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass, ObservableValue<? extends Predicate<T>> filter) {
        for (T item : list) {
            Widget<T> child = I.make(childWidgetClass);
            child.context = item;

            child.virtualize(this);
        }
    }
}
