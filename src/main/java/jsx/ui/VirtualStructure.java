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
import java.util.function.Supplier;

import javafx.beans.value.ObservableValue;

import jsx.style.Style;

/**
 * @version 2014/09/13 1:52:02
 */
public final class VirtualStructure {

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
    public final ContainerDescriptor nbox = new ContainerDescriptor("span", NBOX);

    /** The descriptor of properties. */
    public final AttributeDescriptor attr = new AttributeDescriptor();

    /** The descriptor of properties. */
    public final StyleDescriptor style = new StyleDescriptor();

    /** The latest context line number. */
    protected int latestContextId;

    /** The local id modifier. */
    protected int modifier;

    /** The node route. */
    private final Deque<VirtualElement> parents = new ArrayDeque();

    /** The latest element. */
    private VirtualElement latest;

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
        parents.add(latest = root);
    }

    /**
     * <p>
     * Define children of the current processing element.
     * </p>
     * 
     * @param item A list of children items.
     */
    public void 〡(Object... items) {
        for (Object item : items) {
            process(latest, item);
        }
    }

    /**
     * <p>
     * Define the child of the current processing element.
     * </p>
     * 
     * @param item A child item.
     */
    public void 〡(Object item) {
        process(latest, item);
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
        return latest;
    }

    private void process(VirtualElement container, Object child) {
        WidgetLog.Process.start();

        if (child.equals("\r\n")) {
            container.items.push(new VirtualElement(0, "br"));
        } else {
            container.items.push(new VirtualText(String.valueOf(child)));
        }

        WidgetLog.Process.end();
    }

    /**
     * @version 2015/01/21 14:20:59
     */
    public class ContainerDescriptor {

        /** The container element name. */
        private final String name;

        /** The built-in style. */
        private final Style builtin;

        /** The container {@link VirtualElement}. */
        private VirtualElement container;

        /** The local id. */
        private int localId;

        /** The latest local id. */
        private int latestLocalId;

        /**
         * <p>
         * DSL to define element.
         * </p>
         * 
         * @param name A container element name.
         * @param style A element style.
         */
        private ContainerDescriptor(String name, Style builtin) {
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
        private final VirtualElement container(int contextId) {
            WidgetLog.Container.start();

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
                latest.items.push(container);
            }

            WidgetLog.Container.end();
            return container;
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

        public final void 〡(Style style, Widget widget) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());
            if (style != null) style.assignTo(container.classList, container.inlines);

            // enter into the child node
            parents.addLast(latest = container);

            // process into child nodes
            // create virtual element for this widget
            VirtualWidget virtualize = new VirtualWidget(widget.id, widget);

            // mount virtual element on virtual structure
            container.items.push(virtualize);

            // process child nodes
            widget.assemble(new VirtualStructure(virtualize));

            // leave from the child node
            parents.pollLast();
            latest = parents.peekLast();
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
            if (style != null) style.assignTo(container.classList, container.inlines);

            // enter into the child node
            parents.addLast(latest = container);

            // process into child nodes
            for (Object child : children) {
                process(container, child);
            }

            // leave from the child node
            parents.pollLast();
            latest = parents.peekLast();
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Style style, Class<? extends Widget1<T>> childType, T child) {
            〡(style, childType, Arrays.asList(child));
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
            WidgetLog.VirtualizeWidgetCollection.start();
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());
            if (style != null) style.assignTo(container.classList, container.inlines);

            // enter into the child node
            parents.addLast(latest = container);

            // process into child nodes

            for (T child : children) {
                WidgetLog.SubWidget.start();
                Widget widget = Widget.of(childType, child);

                // create virtual element for this widget
                VirtualWidget virtualize = new VirtualWidget(widget.id, widget);

                // mount virtual element on virtual structure
                container.items.push(virtualize);

                // process child nodes
                widget.assemble(new VirtualStructure(virtualize));
                WidgetLog.SubWidget.end();
            }

            // leave from the child node
            parents.pollLast();
            latest = parents.peekLast();
            WidgetLog.VirtualizeWidgetCollection.end();
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
         * @param children A list of child nodes.
         */
        public final void 〡(Style style, Runnable children) {
            // store the current context
            VirtualElement container = container(LocalId.findContextLineNumber());
            if (style != null) style.assignTo(container.classList, container.inlines);

            // then, clean it for nested invocation
            parents.addLast(latest = container);
            this.container = null;

            // precess into child items
            children.run();

            // restore context environment
            parents.pollLast();
            latest = parents.peekLast();
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
            〡(style, () -> {
                for (T item : items) {
                    modifier = item.hashCode();
                    child.accept(item);
                }
            });
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public final <T> void 〡(Style style, int size, IntConsumer child) {
            〡(style, () -> {
                for (int i = 0; i < size; i++) {
                    modifier = (i + 117 + latestContextId) * 31;
                    child.accept(i);
                }
            });
        }
    }

    /**
     * @version 2015/01/21 13:18:17
     */
    public class AttributeDescriptor {

        /**
         * <p>
         * Define attribute of the latest element.
         * </p>
         * 
         * @param name An attribute name.
         * @param value An attribute value.
         * @return A descriptor for property.
         */
        public AttributeDescriptor 〡(String name, String value) {
            VirtualElement e = parents.peekLast();
            e.attributes.add(name, value);

            return this;
        }

        /**
         * <p>
         * Define attribute of the latest element.
         * </p>
         * 
         * @param name An attribute name.
         * @param value An attribute value.
         * @return A descriptor for property.
         */
        public AttributeDescriptor 〡(String name, Supplier value) {
            if (value == null) {
                return this;
            } else {
                return 〡(name, String.valueOf(value.get()));
            }
        }

        /**
         * <p>
         * Define attribute of the latest element.
         * </p>
         * 
         * @param name An attribute name.
         * @param value An attribute value.
         * @return A descriptor for property.
         */
        public AttributeDescriptor 〡(String name, ObservableValue value) {
            if (value == null) {
                return this;
            } else {
                return 〡(name, String.valueOf(value.getValue()));
            }
        }
    }

    /**
     * @version 2015/01/21 13:18:17
     */
    public class StyleDescriptor {

        public StyleDescriptor 〡(Style style) {
            style.assignTo(latest.classList, latest.inlines);
            return this;
        }

        /**
         * <p>
         * Add {@link Style} if the given codition is true.
         * </p>
         * 
         * @param condition A style condition.
         * @param style A target style to apply.
         */
        public void 〡(Style style, boolean condition) {
            if (condition) {
                style.assignTo(latest.classList, latest.inlines);
            }
        }

        /**
         * <p>
         * Add {@link Style} if the given attribute is valid.
         * < /p>
         * 
         * @param name An attribute name.
         * @param value An attribute value.
         * @param style A target style to apply.
         */
        public void 〡(Style style, String name, String value) {
            if (name != null && name.length() != 0 && value != null && value.length() != 0) {
                style.assignTo(latest.classList, latest.inlines);
                latest.attributes.add(name, value);
            }
        }
    }
}
