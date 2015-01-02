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

import static jsx.ui.VirtualStructureStyle.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import js.lang.NativeArray;
import jsx.style.Style;

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

    public final OptionalStyleDescriptor style = new OptionalStyleDescriptor();

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
    public final ContainerDescriptor hbox = new ContainerDescriptor("hbox", HBOX);

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
    public final ContainerDescriptor sbox = new ContainerDescriptor("sbox", SBOX);

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
    public final ContainerDescriptor vbox = new ContainerDescriptor("vbox", VBOX);

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
    public final ContainerDescriptor nbox = new ContainerDescriptor("nbox", NBOX);

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
     * @param string
     */
    public <W extends Widget1<M>, M> void 〡(Class<W> widgetType, M model) {
        Widget widget = Widget.of(widgetType, model);

        // create virtual element for this widget
        VirtualWidget virtualize = new VirtualWidget(widget.id, widget);

        // mount virtual element on virtual structure
        parents.peekLast().items.push(virtualize);

        // process child nodes
        widget.assemble(new VirtualStructure(virtualize));
    }

    /**
     * @param string
     */
    public void 〡(Object... texts) {
        VirtualElement latest = parents.peekLast();

        for (Object text : texts) {
            if (text.equals("\r\n")) {
                latest.items.push(new VirtualElement(0, "br"));
            } else {
                latest.items.push(new VirtualText(String.valueOf(text)));
            }
        }
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
     * Define stackable container with local id.
     * </p>
     * 
     * @param localId A local id for the container element.
     * @return A descriptor of the container element.
     * @see #sbox
     */
    public final ContainerDescriptor nbox(int localId) {
        nbox.localId = localId;
        return nbox;
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
        protected final Style builtin;

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
        private Descriptor(String name, Style builtin) {
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
                        localId = id = LocalId.generate();
                    }

                    if (modifier != 0) {
                        latestLocalId = id = (31 + id) ^ modifier;
                    }

                    // built-in container
                    container = new VirtualElement(id, name);

                    if (builtin != null) {
                        container.classList.push(builtin);
                    }
                    style.apply(container);

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
        public final void 〡$(Object... children) {
            〡((Style) null, children);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child nodes.
         */
        public final void 〡(Style style, String text) {
            if (text != null && text.length() != 0) {
                〡(style, new Object[] {text});
            }
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child nodes.
         */
        public final void 〡(Style style, Object... children) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());
            if (style != null) container.classList.push(style);

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
                    LowLevelWidget<?> widget = (LowLevelWidget) child;

                    // create descriptor
                    ContainerDescriptor descriptor = new ContainerDescriptor(widget.virtualizeName(), null);
                    descriptor.localId = widget.hashCode();

                    // process child node
                    widget.virtualizeStructure(descriptor);

                    // pass event listners and styles
                    descriptor.container(0).events = widget.events;

                    if (widget.styles != null) {
                        for (Style s : widget.styles) {
                            descriptor.container(0).classList.push(s);
                        }
                    }
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
        private ContainerDescriptor(String name, Style style) {
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
            〡((Style) null, children);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Style style, Class<? extends Widget1<T>> childType, T[] children) {
            〡(style, childType, Arrays.asList(children));
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Style style, Class<? extends Widget1<T>> childType, Collection<T> children) {
            // precess into child items
            int index = 0;
            Object[] childrenUI = new Object[children.size()];

            for (T child : children) {
                childrenUI[index++] = Widget.of(childType, child);
            }

            〡(style, childrenUI);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Style style, Class<? extends Widget1<T>> childType, T child) {
            〡(style, Widget.of(childType, child));
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child nodes.
         */
        public final void 〡(Style style, Runnable children) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());
            if (style != null) container.classList.push(style);

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
        public final <T> void 〡(Style style, T[] items, Consumer<T> child) {
            〡(style, Arrays.asList(items), child);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Style style, Collection<T> items, Consumer<T> child) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());
            if (style != null) container.classList.push(style);

            // then, clean it for nested invocation
            parents.addLast(container);
            this.container = null;

            // precess into child items
            for (T item : items) {
                modifier = item.hashCode();
                child.accept(item);
            }

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
        public final <T> void 〡(Style style, int size, IntConsumer child) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());
            if (style != null) container.classList.push(style);

            // then, clean it for nested invocation
            parents.addLast(container);
            this.container = null;

            // precess into child items
            for (int i = 0; i < size; i++) {
                modifier = i + size;
                child.accept(i);
            }

            // restore context environment
            parents.pollLast();
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

    /**
     * @version 2014/12/29 10:39:30
     */
    public class OptionalStyleDescriptor {

        /** The style manager. */
        private final NativeArray<Style> styles = new NativeArray();

        /** The attribute name manager. */
        private final NativeArray<String> names = new NativeArray();

        /** The attribute value manager. */
        private final NativeArray<String> values = new NativeArray();

        /**
         * <p>
         * Add {@link Style} if the given codition is true.
         * </p>
         * 
         * @param condition A style condition.
         * @param style A target style to apply.
         */
        public void 〡(boolean condition, Style style) {
            if (condition) {
                styles.push(style);
            }
        }

        /**
         * <p>
         * Add {@link Style} if the given attribute is valid.
         * < /p>
         * 
         * @param attributeName An attribute name.
         * @param attributeValue An attribute value.
         * @param style A target style to apply.
         */
        public void 〡(String attributeName, String attributeValue, Style style) {
            if (attributeName != null && attributeName.length() != 0 && attributeValue != null && attributeValue
                    .length() != 0) {
                styles.push(style);
                names.push(attributeName);
                values.push(attributeValue);
            }
        }

        /**
         * <p>
         * Apply optional properties(attribute, style, etc).
         * </p>
         * 
         * @param element
         */
        private void apply(VirtualElement element) {
            if (styles.length() != 0) {
                // assign
                element.classList.push(styles);
                element.attributes.names.push(names);
                element.attributes.values.push(values);

                // clear
                styles.clear();
                names.clear();
                values.clear();
            }
        }
    }
}
