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
import java.util.Collection;
import java.util.Deque;

import jsx.ui.VirtualStructureStyle.HBOX;
import jsx.ui.VirtualStructureStyle.SBOX;
import jsx.ui.VirtualStructureStyle.VBOX;
import booton.css.CSS;

/**
 * @version 2014/09/13 1:52:02
 */
public final class VirtualStructure {

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

    /** The latest context line number. */
    protected int latestContextId;

    /** The local id modifier. */
    protected int modifier;

    /** The node route. */
    private final Deque<VirtualElement> parents = new ArrayDeque();

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
        parents.add(root);
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
     * Define horizontal container with local id.
     * </p>
     * 
     * @param localId A local id for the container element.
     * @return A descriptor of the container element.
     * @see #hbox
     */
    public final ContainerDescriptor hbox(Runnable styleDefinition) {
        return hbox(0, styleDefinition);
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
    public final ContainerDescriptor hbox(int localId, Runnable styleDefinition) {
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
     * Define vertical container with local id.
     * </p>
     * 
     * @param localId A local id for the container element.
     * @return A descriptor of the container element.
     * @see #vbox
     */
    public final ContainerDescriptor vbox(Runnable styleDefinition) {
        return vbox(0, styleDefinition);
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
    public final ContainerDescriptor vbox(int localId, Runnable styleDefinition) {
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
        return parents.peekFirst();
    }

    /**
     * @version 2014/09/12 13:08:06
     */
    public class Descriptor {

        /** The container element name. */
        protected final String name;

        /** The built-in style. */
        protected final Class<? extends CSS> builtin;

        /** The container {@link VirtualElement}. */
        protected VirtualElement container;

        /** The local id. */
        protected int localId;

        /** The latest local id. */
        private int latestLocalId;

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
        protected final VirtualElement container(int contextId) {
            // This process is used in java environment only. (because js implementation of
            // LocalId always return 0)
            if (contextId != 0 && latestContextId != contextId) {
                if (localId == latestContextId) {
                    localId = contextId;
                }
                // update context line number
                latestContextId = contextId;
            }

            //
            if (localId != 0 && latestLocalId != localId) {
                latestLocalId = localId;
                container = null;
            }

            if (container == null) {
                if (name == null) {
                    // as-is
                    container = parents.peekLast();
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

                    if (builtin != null) {
                        container.classList.push(builtin);
                    }
                    parents.peekLast().items.push(container);
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
        public final void 〡(Object... children) {
            〡((Class<? extends CSS>) null, children);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child nodes.
         */
        public final void 〡(Class<? extends CSS> style, Object... children) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());

            // enter into the child node
            if (name != null) parents.addLast(container);

            // process into child nodes
            for (Object child : children) {
                if (child instanceof Widget) {
                    Widget widget = (Widget) child;

                    // create virtual element for this widget
                    VirtualWidget virtualize = new VirtualWidget(widget.id, widget);

                    // mount virtual element on virtual structure
                    container.items.push(virtualize);

                    // process child nodes
                    widget.assemble(new VirtualStructure(virtualize));
                } else if (child instanceof LowLevelWidget) {
                    LowLevelWidget widget = (LowLevelWidget) child;

                    // create descriptor
                    ContainerDescriptor descriptor = new ContainerDescriptor(widget.virtualizeName(), null);
                    descriptor.localId = widget.hashCode();

                    // process child node
                    widget.virtualizeStructure(descriptor);

                    // pass event listners
                    descriptor.container(0).events = widget.events;
                } else {
                    container.items.push(new VirtualText(String.valueOf(child)));
                }
            }

            // leave from the child node
            if (name != null) parents.pollLast();
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
            VirtualElement container = container(LocalId.findContextLineNumber());

            // then, clean it for nested invocation
            parents.addLast(container);
            this.container = null;

            // precess into child items
            children.run();

            // restore context environment
            parents.pollLast();
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child nodes.
         */
        public final void 〡(Class<? extends CSS> style, Runnable children) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());

            // then, clean it for nested invocation
            parents.addLast(container);
            this.container = null;

            // precess into child items
            children.run();

            // restore context environment
            parents.pollLast();
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Class<? extends Widget1<T>> childType, Collection<T> children) {
            〡((Class<? extends CSS>) null, childType, children);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Class<? extends CSS> style, Class<? extends Widget1<T>> childType, Collection<T> children) {
            // precess into child items
            int index = 0;
            Object[] childrenUI = new Object[children.size()];

            for (T child : children) {
                childrenUI[index++] = Widget.of(childType, child);
            }

            〡(childrenUI);
        }

        /**
         * <p>
         * Define attribute or property of this container.
         * </p>
         * 
         * @param name An attribute or property name.
         * @param value An attribute or property value.
         */
        public final ContainerDescriptor 〡ª(String name, String value) {
            container(LocalId.findContextLineNumber()).attribute(name, value);

            return this;
        }
    }
}
