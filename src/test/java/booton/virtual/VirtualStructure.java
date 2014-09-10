/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.function.Predicate;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import kiss.I;
import booton.css.CSS;
import booton.reactive.Widget;

/**
 * @version 2014/09/04 16:39:32
 */
public class VirtualStructure {

    /** The node stack. */
    private final Deque<VirtualElement> nodes = new ArrayDeque();

    /** The current value. */
    private Object value;

    /**
     * 
     */
    public VirtualStructure() {
        this(new VirtualElement(0, "div"));
    }

    /**
     * 
     */
    public VirtualStructure(VirtualElement root) {
        nodes.add(root);
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
        int id = Objects.hash(children);

        for (Object child : children) {
            add(id, child);
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
        add(Objects.hash(children), children);
    }

    public <T> void h(Class<? extends CSS> css, ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass, ObservableValue<? extends Predicate<T>> filter) {
        h(css, () -> {
            for (T item : list) {
                Widget<T> child = I.make(childWidgetClass);

                add(Objects.hash(item), child);
            }
        });
    }

    /**
     * <p>
     * Add child item.
     * </p>
     * 
     * @param child
     */
    private void add(int id, Object child) {
        if (child instanceof Widget) {
            nodes.peekLast().children.items.push(new VirtualWidgetElement(id, (Widget) child));
        } else if (child instanceof ObservableValue) {
            nodes.peekLast().children.items.push(new VirtualReactiveElement(id, "div", (ObservableValue) child));
        } else if (child instanceof Runnable) {
            VirtualElement e = new VirtualElement(id, "div");
            nodes.peekLast().children.items.push(e);
            nodes.addLast(e);
            ((Runnable) child).run();
            nodes.pollLast();
        } else {
            nodes.peekLast().children.items.push(new VirtualText(id, String.valueOf(child)));
        }
    }

    /**
     * @return
     */
    public VirtualElement getRoot() {
        return nodes.peekFirst();
    }
}
