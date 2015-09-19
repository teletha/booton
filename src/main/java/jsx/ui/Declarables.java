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
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import js.lang.NativeString;
import jsx.style.Style;

/**
 * @version 2015/09/14 16:51:36
 */
public class Declarables {

    private static final Declarable NOP = () -> {
    };

    /** The latest element. */
    public static VirtualElement latestElement;

    private static Widget latestWidget;

    private static Object context;

    private static int latestContextId;

    private static int modifier = 31;

    public static void widget(Widget widget) {
        widget(LocalId.findContextLineNumber(), widget);
    }

    static void widget(int id, Widget widget) {
        // store parent
        Widget parentWidget = latestWidget;
        VirtualElement parentElement = latestElement;

        // create virtual element for this widget
        VirtualWidget virtualize = new VirtualWidget(widget.id, widget);
        virtualize.context = context;

        // mount virtual element on virtual structure
        latestElement.items.push(virtualize);

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

        if (previous != null) {
            throw new IllegalStateException(clazz + " is a nest in virtual structure.");
        }

        /**
         * Assemble {@link VirtualStructure} actually.
         */
        WidgetLog.Virtualize.start();
        widget.virtualize2();
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
    }

    public static void text(Object text) {
        text(LocalId.findContextLineNumber(), text);
    }

    private static void text(int id, Object text) {
        if ("\r\n".equals(text)) {
            Declarables.latestElement.items.push(new VirtualElement(id, "br", latestWidget));
        } else {
            Declarables.latestElement.items.push(new VirtualText(String.valueOf(text)));
        }
    }

    public static void text(Style style, Object... texts) {
        text(LocalId.findContextLineNumber(), style, texts);
    }

    private static void text(int id, Style style, Object... texts) {
        element(id, "span", new Declarable[] {style}, () -> {
            NativeString values = new NativeString();

            for (Object text : texts) {
                values = values.concat(String.valueOf(text));
            }
            Declarables.latestElement.items.push(new VirtualText(values.toString()));
        });
    }

    public static void box(Declarable... declarables) {
        box(LocalId.findContextLineNumber(), declarables);
    }

    private static void box(int id, Declarable... declarables) {
        element(id, "span", declarables);
    }

    public static void element(String name, Declarable... declarables) {
        element(LocalId.findContextLineNumber(), name, declarables);
    }

    private static void element(int id, String name, Declarable... declarables) {
        element(id, name, declarables, null);
    }

    private static void element(int id, String name, Declarable[] declarables, Runnable process) {
        VirtualElement element = new VirtualElement((31 + id) ^ modifier, name, latestWidget);
        element.context = context;

        // enter into the child node (store context)
        VirtualElement parent = Declarables.latestElement;
        Declarables.latestElement = element;
        latestContextId = element.id;

        for (int i = 0, length = declarables.length; i < length; i++) {
            if (declarables[i] != null) declarables[i].define();
        }

        if (process != null) {
            process.run();
        }

        // leave from the child node (revert context)
        Declarables.latestElement = parent;

        if (Declarables.latestElement != null) {
            Declarables.latestElement.items.push(element);
        }
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
            Declarables.latestElement.attributes.add("x", String.valueOf(x));
            Declarables.latestElement.attributes.add("y", String.valueOf(y));
        };
    }

    public static Declarable size(double width, double height) {
        return () -> {
            Declarables.latestElement.attributes.add("width", String.valueOf(width));
            Declarables.latestElement.attributes.add("height", String.valueOf(height));
        };
    }

    public static Declarables.SVGPath d() {
        return new Declarables.SVGPath();
    }

    /**
     * <p>
     * Declare "placeholder" attribute with the specified value.
     * </p>
     * 
     * @param type A value of "placeholder" attribute.
     * @return An attribute declaration.
     */
    public static Declarable placeholder(String placeholder) {
        return attr("placeholder", placeholder);
    }

    /**
     * <p>
     * Declare "type" attribute with the specified value.
     * </p>
     * 
     * @param type A value of "type" attribute.
     * @return An attribute declaration.
     */
    public static Declarable type(String type) {
        return attr("type", type);
    }

    /**
     * <p>
     * Declare "value" attribute with the specified value.
     * </p>
     * 
     * @param value A value of "value" attribute.
     * @return An attribute declaration.
     */
    public static Declarable value(String value) {
        return attr("value", value);
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
    public static Declarable attr(String name, String value) {
        return name == null || name.length() == 0 || value == null || value.length() == 0 ? NOP : () -> {
            Declarables.latestElement.attributes.add(name, value);
        };
    }

    public static Declarable If(String condition, Declarable... declarables) {
        return If(condition != null && condition.length() != 0, declarables);
    }

    public static Declarable If(boolean condition, Declarable... declarables) {
        return () -> {
            if (condition) {
                for (Declarable declarable : declarables) {
                    declarable.define();
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
    public static <T> Declarable contents(Class<? extends Widget1<T>> childType, T[] children) {
        return contents(childType, Arrays.asList(children));
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param children A list of child widget.
     */
    public static <T> Declarable contents(Class<? extends Widget1<T>> childType, List<T> children) {
        return () -> {
            Object parent = context;

            for (T child : children) {
                context = child;
                modifier = Objects.hash(child);
                widget(Widget.of(childType, child));
            }

            context = parent;
        };
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param children A list of child widget.
     */
    public static <T> Declarable contents(T[] children, Consumer<T> process) {
        return contents(Arrays.asList(children), process);
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param children A list of child widget.
     */
    public static <T> Declarable contents(List<T> children, Consumer<T> process) {
        return () -> {
            Object stored = context;

            for (T child : children) {
                if (child != null) {
                    context = child;
                    process.accept(child);
                }
            }

            context = stored;
        };
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param children A list of child widget.
     */
    public static <T> Declarable contents(int size, IntConsumer process) {
        return contents(0, size, process);
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param children A list of child widget.
     */
    public static <T> Declarable contents(int initial, int size, IntConsumer process) {
        return () -> {
            for (int i = 0; i < size; i++) {
                modifier = (i + 117 + latestContextId) * 31;
                process.accept(i + initial);
            }
        };
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