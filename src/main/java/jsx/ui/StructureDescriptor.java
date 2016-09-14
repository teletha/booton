/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyProperty;

import js.lang.NativeString;
import jsx.style.StyleDescriptor;
import kiss.Events;

/**
 * @version 2015/10/14 10:18:46
 */
public class StructureDescriptor {

    /** The namespace uri for HTML. */
    static final String HTML = "http://www.w3.org/1999/xhtml";

    /** The namespace uri for SVG. */
    static final String SVG = "http://www.w3.org/2000/svg";

    /** The latest element. */
    static VirtualElement latestElement;

    private static Widget<?> latestWidget;

    /** The context object to propagate implicitly. */
    private static Object localContext;

    /** The modifier of context id. */
    private static int localContextIdModifier = 31;

    /**
     * <p>
     * Declara widget.
     * </p>
     * 
     * @param widget A widget to define.
     */
    public static void widget(Widget widget) {
        widget(LocalId.findContextLineNumber(), widget);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param widget A widget to define.
     */
    private static void widget(int id, Widget widget) {
        createWidget(id, widget);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param widget A widget to define.
     */
    static VirtualWidget createWidget(int id, Widget widget) {
        return createWidget(id, widget, widget::virtualize);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param widget A widget to define.
     */
    static VirtualWidget createWidget(int id, Widget widget, Runnable method) {
        // store parent
        Widget parentWidget = latestWidget;
        VirtualElement parentElement = latestElement;

        widget.root = parentWidget == null ? widget : parentWidget.root;

        // create virtual element for this widget
        VirtualWidget virtualize = new VirtualWidget(widget.id, widget, localContext);

        // mount virtual element on virtual structure
        if (latestElement != null) {
            latestElement.items.push(virtualize);
        }

        latestWidget = widget;
        latestElement = virtualize;

        // process child nodes
        Class clazz = widget.getClass();

        /**
         * <p>
         * Enter the hierarchy of {@link VirtualStructure}.
         * </p>
         */
        Widget previous = VirtualWidgetHierarchy.hierarchy.putIfAbsent(clazz, widget);

        // if (previous != null) {
        // throw new IllegalStateException(clazz + " is a nest in virtual structure.");
        // }

        /**
         * Assemble {@link VirtualStructure} actually.
         */
        WidgetLog.Virtualize.start();
        method.run();
        WidgetLog.Virtualize.stop();

        /**
         * <p>
         * Leave the hierarchy of {@link VirtualStructure}.
         * </p>
         */
        VirtualWidgetHierarchy.hierarchy.remove(clazz);

        // restore parent
        latestWidget = parentWidget;
        latestElement = parentElement;

        // API definition
        return virtualize;
    }

    /**
     * <p>
     * Declare text contents.
     * </p>
     * 
     * @param text A list of text contents.
     */
    public static void text(Object... texts) {
        text(LocalId.findContextLineNumber(), texts);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A content id.
     * @param text A content to append.
     */
    private static void text(int id, Object... texts) {
        for (Object text : texts) {
            if ("\r\n".equals(text)) {
                latestElement.items.push(new VirtualElement(id, "br", latestWidget));
            } else {
                latestElement.items.push(new VirtualText(String.valueOf(text)));
            }
        }
    }

    /**
     * <p>
     * Declare text contents with the specified {@link Style} container.
     * </p>
     * 
     * @param style A style of the parent container.
     * @param texts A list of text contents.
     */
    public static void text(Style style, Object... texts) {
        text(LocalId.findContextLineNumber(), style, texts);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A container id.
     * @param style A style of the parent container.
     * @param texts A list of text contents.
     */
    private static void text(int id, Style style, Object... texts) {
        html(id, "span", style, contents(texts));
    }

    /**
     * <p>
     * Declara span element with the specified contents (attributes, children nodes etc).
     * </p>
     * 
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    public static void box(Declarable... declarables) {
        box(LocalId.findContextLineNumber(), declarables);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    private static void box(int id, Declarable... declarables) {
        html(id, "span", declarables);
    }

    /**
     * <p>
     * Declara element definition with the specified name.
     * </p>
     * 
     * @param name A name of element.
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    public static void html(String name, Declarable... declarables) {
        html(LocalId.findContextLineNumber(), name, declarables);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param name A name of element.
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    private static void html(int id, String name, Declarable... declarables) {
        element(id, HTML, name, declarables, null);
    }

    /**
     * <p>
     * Declara element definition with the specified name.
     * </p>
     * 
     * @param name A name of element.
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    public static void svg(String name, Declarable... declarables) {
        svg(LocalId.findContextLineNumber(), name, declarables);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param name A name of element.
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    private static void svg(int id, String name, Declarable... declarables) {
        element(id, SVG, name, declarables, null);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param ns A namespace uri.
     * @param name A name of element.
     * @param declarables A list of contents (attributes, children nodes etc).
     * @param process
     */
    private static void element(int id, String ns, String name, Declarable[] declarables, Runnable process) {
        // enter into the child node (store context)
        VirtualElement parentElement = latestElement;

        // create element and connect it to the parent element
        VirtualElement element = new VirtualElement((31 + id) ^ localContextIdModifier, ns, name, localContext, latestWidget);
        parentElement.items.push(latestElement = element);

        for (Declarable declarable : declarables) {
            if (declarable != null) {
                declarable.declare();
            }
        }

        if (process != null) {
            process.run();
        }

        // leave from the child node (revert context)
        latestElement = parentElement;
    }

    /**
     * <p>
     * The viewBox attribute allows to specify that a given set of graphics stretch to fit a
     * particular container element.
     * </p>
     * <p>
     * The value of the viewBox attribute is a list of four numbers min-x, min-y, width and height,
     * separated by whitespace and/or a comma, which specify a rectangle in user space which should
     * be mapped to the bounds of the viewport established by the given element, taking into account
     * attribute preserveAspectRatio.
     * </p>
     * <p>
     * Negative values for width or height are not permitted and a value of zero disables rendering
     * of the element.
     * </p>
     * 
     * @param minX
     * @param minY
     * @param width
     * @param height
     */
    public static Declarable viewBox(int minX, int minY, int width, int height) {
        return attr("viewBox", new NativeString(minX).concat(" ")
                .concat(minY)
                .concat(" ")
                .concat(width)
                .concat(" ")
                .concat(height)
                .toString());
    }

    public static Declarable position(double x, double y) {
        return () -> {
            latestElement.attributes.add("x", String.valueOf(x));
            latestElement.attributes.add("y", String.valueOf(y));
        };
    }

    public static Declarable size(double width, double height) {
        return () -> {
            latestElement.attributes.add("width", String.valueOf(width));
            latestElement.attributes.add("height", String.valueOf(height));
        };
    }

    public static SVGPath d() {
        return new SVGPath();
    }

    /**
     * <p>
     * Declare "id" attribute with the specified value.
     * </p>
     * 
     * @param id A value of "id" attribute.
     * @return An attribute declaration.
     */
    public static Declarable id(String id) {
        return attr("id", id);
    }

    /**
     * <p>
     * Declare "title" attribute with the specified value.
     * </p>
     * 
     * @param title A value of "title" attribute.
     * @return An attribute declaration.
     */
    public static Declarable title(String title) {
        return attr("title", title);
    }

    /**
     * <p>
     * Declare "xlink:href" attribute with the specified value.
     * </p>
     * 
     * @param id A value of "xlink:href" attribute.
     * @return An attribute declaration.
     */
    public static Declarable xlink(String href) {
        return attr("xlink:href", href);
    }

    /**
     * <p>
     * General attribute definition method.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return
     */
    public static Declarable attr(String name, Object value) {
        return value == null ? null : attr(name, value.toString());
    }

    /**
     * <p>
     * General attribute definition method.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return
     */
    public static Declarable attr(String name, Supplier value) {
        return value == null ? null : attr(name, value.get());
    }

    /**
     * <p>
     * General attribute definition method.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return
     */
    public static Declarable attr(String name, Property value) {
        return value == null ? null : attr(name, value.getValue());
    }

    /**
     * <p>
     * General attribute definition method.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return
     */
    public static Declarable attr(String name, String value) {
        return name == null || name.length() == 0 || value == null ? null : () -> {
            latestElement.attributes.add(name, value);
        };
    }

    /**
     * <p>
     * Conditional expression.
     * </p>
     * 
     * @param condition
     * @param declarables
     * @return
     */
    public static Declarable If(String condition, Declarable... declarables) {
        return If(condition != null && condition.length() != 0, declarables);
    }

    /**
     * <p>
     * Conditional expression.
     * </p>
     * 
     * @param condition
     * @param declarables
     * @return
     */
    public static Declarable If(Supplier<Boolean> condition, Declarable... declarables) {
        return If(condition != null && Boolean.TRUE.equals(condition.get()), declarables);
    }

    /**
     * <p>
     * Conditional expression.
     * </p>
     * 
     * @param condition
     * @param declarables
     * @return
     */
    public static Declarable If(ReadOnlyProperty<Boolean> condition, Declarable... declarables) {
        return If(condition != null && Boolean.TRUE.equals(condition.getValue()), declarables);
    }

    /**
     * <p>
     * Conditional expression.
     * </p>
     * 
     * @param condition
     * @param declarables
     * @return
     */
    public static Declarable If(boolean condition, Declarable... declarables) {
        return () -> {
            if (condition) {
                for (Declarable declarable : declarables) {
                    declarable.declare();
                }
            }
        };
    }

    /**
     * <p>
     * Conditional expression.
     * </p>
     * 
     * @param condition
     * @param declarables
     * @return
     */
    public static Declarable If(Events<Boolean> condition, Declarable... declarables) {
        return () -> {
            if (latestWidget.value(condition)) {
                for (Declarable declarable : declarables) {
                    declarable.declare();
                }
            }
        };
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param children A list of child widget.
     */
    public static Declarable contents(int size, Consumer<Integer> process) {
        return contents(0, size, process);
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param children A list of child widget.
     */
    public static Declarable contents(int initial, int size, Consumer<Integer> process) {
        // we can optimize code using IntConsumer, but the uniformity has high priority than that
        return contents(new Range(initial, initial + size), process);
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param children A list of child widget.
     */
    public static <Styles extends StyleDescriptor, E extends Enum> Declarable contents(Class<? extends Widget1<Styles, E>> childType, Class<E> children) {
        return contents(childType, children.getEnumConstants());
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param children A list of child widget.
     */
    public static <Styles extends StyleDescriptor, C> Declarable contents(Class<? extends Widget1<Styles, C>> childType, C[] children) {
        return contents(childType, Arrays.asList(children));
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param children A list of child widget.
     */
    public static <Styles extends StyleDescriptor, C> Declarable contents(Class<? extends Widget1<Styles, C>> childType, Iterable<C> children) {
        return contents(children, child -> {
            widget(Widget.of(childType, child));
        });
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param type A type of {@link Enum} contents.
     * @param process A content writer.
     * @return A declaration of contents.
     */
    public static <E extends Enum> Declarable contents(Class<E> type, Consumer<E> process) {
        return contents(type.getEnumConstants(), process);
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param contents A list of contents.
     * @param process A content writer.
     * @return A declaration of contents.
     */
    public static <C> Declarable contents(C[] contents, Consumer<C> process) {
        return contents(Arrays.asList(contents), process);
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param children A list of child widget.
     */
    public static <C> Declarable contents(Events<C> contents, Consumer<C> process) {
        return contents(latestWidget.values(contents), process);
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param contents A list of contents.
     * @param process A content writer.
     * @return A declaration of contents.
     */
    public static <C> Declarable contents(Iterable<C> contents, Consumer<C> process) {
        return () -> {
            // store parent context
            Object parentContext = localContext;
            int parentModifier = localContextIdModifier;

            for (C content : contents) {
                localContext = content;
                localContextIdModifier = (Objects.hash(content) + 117) ^ 31;
                process.accept(content);
            }

            // restore parent context
            localContext = parentContext;
            localContextIdModifier = parentModifier;
        };
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param texts A list of child text contents.
     */
    public static Declarable contents(Widget... widgets) {
        return () -> {
            for (Widget widget : widgets) {
                widget(widget);
            }
        };
    }

    /**
     * <p>
     * Define children.
     * </p>
     *
     * @param texts A list of child text contents.
     */
    public static Declarable contents(Object... texts) {
        return () -> {
            text(texts);
        };
    }

    /**
     * @version 2015/10/16 10:19:45
     */
    private static class Range implements Iterator<Integer>, Iterable<Integer> {

        /** The current number. */
        private int current;

        /** The end number. */
        private final int end;

        /**
         * @param start
         * @param end
         */
        private Range(int start, int end) {
            this.current = start;
            this.end = end;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return current < end;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Integer next() {
            return current++;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Iterator<Integer> iterator() {
            return this;
        }
    }

    /**
     * @version 2015/09/15 11:18:03
     */
    public static class SVGPath implements Declarable {

        /** The current draw mode. */
        private boolean relativeMode = false;

        /** The buffer. */
        private StringBuilder builder = new StringBuilder();

        /**
         * 
         */
        private SVGPath() {
            super();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void declare() {
            latestElement.attributes.add("d", builder.toString());
        }

        /**
         * <p>
         * Set the start position to draw.
         * </p>
         * 
         * @param x A horizontal position.
         * @param y A vertical position.
         * @return Chainable API.
         */
        public SVGPath moveTo(double x, double y) {
            command("M").append(x).append(" ").append(y);
            return this;
        }

        /**
         * <p>
         * Draw line to the specified position.
         * </p>
         * 
         * @param x A horizontal position.
         * @param y A vertical position.
         * @return Chainable API.
         */
        public SVGPath lineTo(double x, double y) {
            command("L").append(x).append(" ").append(y);
            return this;
        }

        /**
         * <p>
         * Draw horizontal line to the specified position.
         * </p>
         * 
         * @param x A horizontal position.
         * @return Chainable API.
         */
        public SVGPath hlineTo(double x) {
            command("H").append(x);
            return this;
        }

        /**
         * <p>
         * Draw vertical line to the specified position.
         * </p>
         * 
         * @param y A vertical position.
         * @return Chainable API.
         */
        public SVGPath vlineTo(double y) {
            command("V").append(y);
            return this;
        }

        /**
         * <p>
         * Close the current path.
         * </p>
         * 
         * @return Chainable API.
         */
        public SVGPath end() {
            command("Z");
            return this;
        }

        /**
         * <p>
         * Draw cubic Bézier curve to the path. It requires three points. The first two points are
         * control points and the third one is the end point. The starting point is the last point
         * in the current path, which can be changed using moveTo() before creating the Bézier
         * curve.
         * </p>
         * 
         * @param cp1x The x axis of the coordinate for the first control point.
         * @param cp1y The y axis of the coordinate for first control point.
         * @param cp2x The x axis of the coordinate for the second control point.
         * @param cp2y The y axis of the coordinate for the second control point.
         * @param x The x axis of the coordinate for the end point.
         * @param y The y axis of the coordinate for the end point.
         * @return Chainable API.
         */
        public SVGPath curveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
            command("C").append(cp1x)
                    .append(" ")
                    .append(cp1y)
                    .append(" ")
                    .append(cp2x)
                    .append(" ")
                    .append(cp2y)
                    .append(" ")
                    .append(x)
                    .append(" ")
                    .append(y);
            return this;
        }

        /**
         * <p>
         * Draw cubic Bézier curve to the path. It requires three points. The first two points are
         * control points and the third one is the end point. The starting point is the last point
         * in the current path, which can be changed using moveTo() before creating the Bézier
         * curve.
         * </p>
         * 
         * @param cp1x The x axis of the coordinate for the first control point.
         * @param cp1y The y axis of the coordinate for first control point.
         * @param cp2x The x axis of the coordinate for the second control point.
         * @param cp2y The y axis of the coordinate for the second control point.
         * @param x The x axis of the coordinate for the end point.
         * @param y The y axis of the coordinate for the end point.
         * @return Chainable API.
         */
        public SVGPath curveRelativeTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
            command("C").append(cp1x)
                    .append(" ")
                    .append(cp1y)
                    .append(" ")
                    .append(cp2x)
                    .append(" ")
                    .append(cp2y)
                    .append(" ")
                    .append(x)
                    .append(" ")
                    .append(y);
            return this;
        }

        /**
         * <p>
         * Make drawing context relative.
         * </p>
         * 
         * @return
         */
        public final SVGPath relatively() {
            relativeMode = true;

            return this;
        }

        /**
         * <p>
         * Make drawing context relative.
         * </p>
         * 
         * @return
         */
        public final SVGPath absolutely() {
            relativeMode = false;

            return this;
        }

        /**
         * <p>
         * Make command expression.
         * </p>
         * 
         * @param command
         * @return
         */
        private final StringBuilder command(String command) {
            builder.append(" ").append(relativeMode ? command.toLowerCase() : command).append(" ");
            return builder;
        }
    }
}