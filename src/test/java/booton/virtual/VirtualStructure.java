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
import java.util.List;
import java.util.Objects;

import javafx.beans.value.ObservableValue;

import booton.css.CSS;
import booton.reactive.Widget;
import booton.virtual.VirtualStructureStyle.HBOX;

/**
 * @version 2014/09/04 16:39:32
 */
public class VirtualStructure {

    /** The Attribute helper. */
    public final AttributeMode hbox〡 = new AttributeMode();

    /** The Attribute helper. */
    public final AttributeMode sbox〡 = new AttributeMode();

    /** The Attribute helper. */
    public final AttributeMode vbox〡 = new AttributeMode();

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
     * <p>
     * Append the specified items as child node.
     * </p>
     * 
     * @param items Child nodes to append.
     */
    @SafeVarargs
    public final void asis〡(Object... children) {
        for (Object child : children) {
            append(new VirtualText(child.hashCode(), child.toString()));
        }
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public void hbox〡(Object... children) {
        throw new Error("Use virtual mode.");
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    void hbox(int localID, Object... children) {
        VirtualElement next = new VirtualElement(localID, "div");
        next.classList.push(HBOX.class);

        nodes.addLast(next);
        for (Object child : children) {
            append(new VirtualText(child.hashCode(), child.toString()));
        }
        append(nodes.pollLast());
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public void sbox〡(Object... children) {
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public <T> void vbox〡(Class<? extends Widget<T>> childWidget, List<T> items) {
    }

    /**
     * Define horizontal box with children.
     * 
     * @param children A list of children.
     * @return A styler.
     */
    public void hbox〡(Class<? extends CSS> css, Runnable children) {
        append(Objects.hash(children), children);
    }

    /**
     * <p>
     * Add child item.
     * </p>
     * 
     * @param child
     */
    private void append(int id, Object child) {
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
     * <p>
     * Append child node.
     * </p>
     * 
     * @param child
     */
    private void append(VirtualNode child) {
        nodes.peekLast().children.items.push(child);
    }

    /**
     * @return
     */
    public VirtualElement getRoot() {
        return nodes.peekFirst();
    }

    /**
     * @version 2014/09/12 13:08:06
     */
    public class AttributeMode {

        /**
         * <p>
         * Append the specified items as child node.
         * </p>
         * 
         * @param items Child nodes to append.
         */
        public final ChildMode ﹟(Class<? extends CSS> className) {
            throw new Error("Use virtual mode.");
        }
    }

    /**
     * @version 2014/09/12 13:28:26
     */
    public class ChildMode {

        /** The container id. */
        private int containerID;

        /**
         * @param children
         */
        public final void 〡(Object... children) {
            VirtualElement next = new VirtualElement(containerID, "div");
            next.classList.push(HBOX.class);

            nodes.addLast(next);
            for (Object child : children) {
                append(new VirtualText(child.hashCode(), child.toString()));
            }
            append(nodes.pollLast());
        }

        /**
         * @param children
         */
        public final void 〡(Runnable children) {

        }
    }
}
