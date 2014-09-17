/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;

import jsx.ui.StructureDSLStyle.HBOX;
import jsx.ui.StructureDSLStyle.SBOX;
import jsx.ui.StructureDSLStyle.VBOX;
import booton.css.CSS;

/**
 * @version 2014/09/13 1:52:02
 */
public final class StructureDSL {

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

    /** The local id modifier. */
    protected int modifier;

    /** The node stack. */
    private final Deque<VirtualElement> nodes = new ArrayDeque();

    /**
     * 
     */
    public StructureDSL() {
        this(new VirtualElement(0, "div"));
    }

    /**
     * 
     */
    public StructureDSL(VirtualElement root) {
        nodes.add(root);
    }

    /**
     * <p>
     * Define horizontal container with local id.
     * </p>
     * 
     * @param localId A local id for the container element.
     * @return A descriptor of the container element.
     * @see #hbox
     */
    public final ContainerDescriptor hbox(int localId) {
        hbox.localId = localId;
        return hbox;
    }

    /**
     * <p>
     * Define vertical container with local id.
     * </p>
     * 
     * @param localId A local id for the container element.
     * @return A descriptor of the container element.
     * @see #vbox
     */
    public final ContainerDescriptor vbox(int localId) {
        vbox.localId = localId;
        return vbox;
    }

    /**
     * <p>
     * Define stackable container with local id.
     * </p>
     * 
     * @param localId A local id for the container element.
     * @return A descriptor of the container element.
     * @see #sbox
     */
    public final ContainerDescriptor sbox(int localId) {
        sbox.localId = localId;
        return sbox;
    }

    /**
     * <p>
     * Define html element with local id.
     * </p>
     * 
     * @param name A element name.
     * @param localId A local id for the container element.
     * @return A descriptor of the container element.
     */
    public final ContainerDescriptor e(String name, int localId) {
        ContainerDescriptor container = new ContainerDescriptor(name, null);
        container.localId = localId;

        return container;
    }

    /**
     * <p>
     * Retrieve the root {@link VirtualElement}.
     * </p>
     * 
     * @return A single root element.
     */
    protected final VirtualElement getRoot() {
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
        protected int localId;

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
        protected final VirtualElement container() {
            if (container == null) {
                if (name == null) {
                    // as-is
                    container = nodes.peekLast();
                } else {
                    int id = localId;

                    if (id == 0) {
                        id = LocalId.generate();
                    }

                    if (modifier != 0) {
                        id = id ^ modifier;
                    }

                    // built-in container
                    container = new VirtualElement(id, name);

                    if (name != null) {
                        container.classList.push(builtin);
                    }
                    nodes.peekLast().children.items.push(container);
                    nodes.addLast(container);
                }
            }
            return container;
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child nodes.
         */
        @SafeVarargs
        public final void 〡(Object... children) {
            // store the current context
            VirtualElement container = container();

            // then, clean it for nested invocation
            this.container = null;

            // precess into child items
            for (Object child : children) {
                if (child instanceof Widget) {
                    ((Widget) child).virtualize(StructureDSL.this);
                } else if (child instanceof UI) {
                    VirtualElement virtualize = ((UI) child).virtualize();

                    if (virtualize != null) {
                        container.children.items.push(virtualize);
                    }
                } else {
                    container.children.items.push(new VirtualText(child.hashCode(), child.toString()));
                }
            }

            // reset context environment
            if (name != null) {
                nodes.pollLast();
            }
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
         * Define children.
         * </p>
         * 
         * @param children A list of child nodes.
         */
        public final void 〡(Runnable children) {
            // store the current context
            container();

            // then, clean it for nested invocation
            this.container = null;

            // precess into child items
            children.run();

            // restore context environment
            nodes.pollLast();
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Class<? extends Widget<T>> childType, T... children) {
            〡(childType, Arrays.asList(children));
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Class<? extends Widget<T>> childType, Collection<T> children) {
            // store the current context
            container();
            int storedModifier = modifier;

            // then, clean it for nested invocation
            this.container = null;

            // precess into child items
            for (T child : children) {
                modifier = child.hashCode();

                Widget.create(childType, child).virtualize(StructureDSL.this);
            }

            // reset context environment
            nodes.pollLast();
            modifier = storedModifier;
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
