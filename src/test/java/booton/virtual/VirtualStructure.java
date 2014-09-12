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

import javafx.beans.value.ObservableValue;

import booton.css.CSS;
import booton.virtual.VirtualStructureStyle.HBOX;
import booton.virtual.VirtualStructureStyle.SBOX;
import booton.virtual.VirtualStructureStyle.VBOX;

/**
 * @version 2014/09/13 1:52:02
 */
public class VirtualStructure {

    /**
     * <p>
     * Define anonymous-transparent container and get the descriptor of the container element.
     * </p>
     */
    public final Descriptor asis = new Descriptor(null, null);

    /**
     * <p>
     * Define horizontal container and get the descriptor of the container element.
     * </p>
     * <p>
     * This field is equivalent to the method call <code>hbox(auto-assignment-id)</code>.
     * </p>
     * 
     * @see #hbox(int)
     */
    public final ContainerDescriptor hbox = new ContainerDescriptor("hbox", HBOX.class);

    /**
     * <p>
     * Define vertiacal container and get the descriptor of the container element.
     * </p>
     * <p>
     * This field is equivalent to the method call <code>vbox(auto-assignment-id)</code>.
     * </p>
     * 
     * @see #vbox(int)
     */
    public final ContainerDescriptor sbox = new ContainerDescriptor("sbox", SBOX.class);

    /**
     * <p>
     * Define stackable container and get the descriptor of the container element.
     * </p>
     * <p>
     * This field is equivalent to the method call <code>sbox(auto-assignment-id)</code>.
     * </p>
     * 
     * @see #sbox(int)
     */
    public final ContainerDescriptor vbox = new ContainerDescriptor("vbox", VBOX.class);

    /** The node stack. */
    private final Deque<VirtualElement> nodes = new ArrayDeque();

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
     * Define horizontal container with local id.
     * </p>
     * 
     * @param localID A local id for the container element.
     * @return A descriptor of the container element.
     * @see #hbox
     */
    public final ContainerDescriptor hbox(int localID) {
        hbox.localID = localID;
        return hbox;
    }

    /**
     * <p>
     * Define vertical container with local id.
     * </p>
     * 
     * @param localID A local id for the container element.
     * @return A descriptor of the container element.
     * @see #vbox
     */
    public final ContainerDescriptor vbox(int localID) {
        vbox.localID = localID;
        return vbox;
    }

    /**
     * <p>
     * Define stackable container with local id.
     * </p>
     * 
     * @param localID A local id for the container element.
     * @return A descriptor of the container element.
     * @see #sbox
     */
    public final ContainerDescriptor sbox(int localID) {
        sbox.localID = localID;
        return sbox;
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
     * @return
     */
    public VirtualElement getRoot() {
        return nodes.peekFirst();
    }

    /**
     * @version 2014/09/12 13:08:06
     */
    public class Descriptor {

        /** The container element name. */
        protected final String name;

        /** The built-in style. */
        protected final Class<? extends CSS> builtin;

        /** The container */
        protected VirtualElement container;

        /** The local id. */
        protected int localID;

        /**
         * @param name
         * @param builtin
         */
        private Descriptor(String name, Class<? extends CSS> builtin) {
            this.name = name;
            this.builtin = builtin;
        }

        /**
         * <p>
         * Retrieve the current container element.
         * </p>
         * 
         * @return The current container element.
         */
        protected VirtualElement container() {
            if (container == null) {
                if (name == null) {
                    // as-is
                    container = nodes.peekLast();
                } else {
                    // built-in containers
                    container = new VirtualElement(LocalID.find(), name);

                    if (builtin != null) {
                        container.classList.push(builtin);
                    }
                    nodes.peekLast().children.items.push(container);
                    nodes.addLast(container);
                }
            }
            return container;
        }

        /**
         * @param children
         */
        public final void 〡(Object... children) {
            for (Object child : children) {
                if (child instanceof Widget) {
                    ((Widget) child).virtualize(VirtualStructure.this);
                } else {
                    append(new VirtualText(child.hashCode(), child.toString()));
                }
            }

            // reset context environment
            if (name != null) {
                nodes.pollLast();
            }

            container = null;
            localID = 0;
        }

        /**
         * <p>
         * Append child node.
         * </p>
         * 
         * @param child
         */
        private void append(VirtualNode child) {
            container().children.items.push(child);
        }

        /**
         * @param children
         */
        public final void 〡(Runnable children) {
        }
    }

    /**
     * @version 2014/09/12 19:03:27
     */
    public class ContainerDescriptor extends Descriptor {

        /**
         * <p>
         * DSL to define element.
         * </p>
         * 
         * @param name A container element name.
         * @param style A element style.
         */
        private ContainerDescriptor(String name, Class<? extends CSS> style) {
            super(name, style);
        }

        /**
         * <p>
         * Append the specified items as child node.
         * </p>
         * 
         * @param items Child nodes to append.
         */
        public final ContainerDescriptor 〡﹟(Class<? extends CSS> className) {
            container().classList.push(className);

            return this;
        }
    }
}
