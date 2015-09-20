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
 * @version 2015/09/19 21:45:20
 */
public class Declarables {

    /** The latest element. */
    public static VirtualElement latestElement;

    private static Widget latestWidget;

    /** The context object to propagate implicitly. */
    private static Object localContext;

    /** The modifier of context id. */
    private static int localContextIdModifier = 31;

    protected Declarables() {

    }

    protected Declarables(VirtualElement root) {
        latestElement = root;
    }

    /**
     * <p>
     * Declara widget.
     * </p>
     * 
     * @param widget A widget to define.
     */
    protected static void widget(Widget widget) {
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
        // store parent
        Widget parentWidget = latestWidget;
        VirtualElement parentElement = latestElement;

        // create virtual element for this widget
        VirtualWidget virtualize = new VirtualWidget(widget.id, widget, localContext);

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

    protected void text(Object text) {
        text(LocalId.findContextLineNumber(), text);
    }

    private void text(int id, Object text) {
        if ("\r\n".equals(text)) {
            latestElement.items.push(new VirtualElement(id, "br", latestWidget));
        } else {
            latestElement.items.push(new VirtualText(String.valueOf(text)));
        }
    }

    protected void text(Style style, Object... texts) {
        text(LocalId.findContextLineNumber(), style, texts);
    }

    private void text(int id, Style style, Object... texts) {
        element(id, "span", new Declarable[] {style}, () -> {
            NativeString values = new NativeString();

            for (Object text : texts) {
                values = values.concat(String.valueOf(text));
            }
            latestElement.items.push(new VirtualText(values.toString()));
        });
    }

    /**
     * <p>
     * Declara span element with the specified contents (attributes, children nodes etc).
     * </p>
     * 
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    protected Box box(Declarable... declarables) {
        return box(LocalId.findContextLineNumber(), declarables);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    private Box box(int id, Declarable... declarables) {
        return element(id, "span", declarables, null);
    }

    /**
     * <p>
     * Declara element definition with the specified name.
     * </p>
     * 
     * @param name A name of element.
     * @param declarables A list of contents (attributes, children nodes etc).
     */
    protected Box element(String name, Declarable... declarables) {
        return element(LocalId.findContextLineNumber(), name, declarables);
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
    private Box element(int id, String name, Declarable... declarables) {
        return element(id, name, declarables, null);
    }

    /**
     * <p>
     * Internal API.
     * </p>
     * 
     * @param id A local id.
     * @param name A name of element.
     * @param declarables A list of contents (attributes, children nodes etc).
     * @param process
     */
    private Box element(int id, String name, Declarable[] declarables, Runnable process) {
        // enter into the child node (store context)
        VirtualElement parentElement = latestElement;

        // create element and connect it to the parent element
        VirtualElement element = new VirtualElement((31 + id) ^ localContextIdModifier, name, localContext, latestWidget);
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

        return element;
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
    protected Declarable viewBox(int minX, int minY, int width, int height) {
        return attr("viewBox", new NativeString(minX).concat(" ")
                .concat(minY)
                .concat(" ")
                .concat(width)
                .concat(" ")
                .concat(height)
                .toString());
    }

    protected Declarable position(double x, double y) {
        return () -> {
            latestElement.attributes.add("x", String.valueOf(x));
            latestElement.attributes.add("y", String.valueOf(y));
        };
    }

    protected Declarable size(double width, double height) {
        return () -> {
            latestElement.attributes.add("width", String.valueOf(width));
            latestElement.attributes.add("height", String.valueOf(height));
        };
    }

    protected Declarables.SVGPath d() {
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
    protected Declarable placeholder(String placeholder) {
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
    protected Declarable type(String type) {
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
    protected Declarable value(String value) {
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
    protected Declarable id(String id) {
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
    protected Declarable title(String title) {
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
    protected Declarable xlink(String href) {
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
    protected Declarable attr(String name, String value) {
        return name == null || name.length() == 0 || value == null || value.length() == 0 ? null : () -> {
            latestElement.attributes.add(name, value);
        };
    }

    protected Declarable If(String condition, Declarable... declarables) {
        return If(condition != null && condition.length() != 0, declarables);
    }

    protected Declarable If(boolean condition, Declarable... declarables) {
        return () -> {
            if (condition) {
                for (Declarable declarable : declarables) {
                    declarable.declare();
                }
            }
        };
    }

    // /**
    // * <p>
    // * Define children.
    // * </p>
    // *
    // * @param children A list of child widget.
    // */
    // protected <T> Declarable contents(Class<? extends Widget1<T>> childType, T[] children) {
    // return contents(childType, Arrays.asList(children));
    // }
    //
    // /**
    // * <p>
    // * Define children.
    // * </p>
    // *
    // * @param children A list of child widget.
    // */
    // protected <T> Declarable contents(Class<? extends Widget1<T>> childType, List<T> children) {
    // return () -> {
    // // store parent context
    // Object parentContext = localContext;
    //
    // for (T child : children) {
    // localContext = child;
    // localContextIdModifier = Objects.hash(child);
    // widget(Widget.of(childType, child));
    // }
    //
    // // restore parent context
    // localContext = parentContext;
    // };
    // }

    // /**
    // * <p>
    // * Define children.
    // * </p>
    // *
    // * @param children A list of child widget.
    // */
    // protected <T> Declarable contents(T[] children, Consumer<T> process) {
    // return contents(Arrays.asList(children), process);
    // }
    //
    // /**
    // * <p>
    // * Define children.
    // * </p>
    // *
    // * @param children A list of child widget.
    // */
    // protected <T> Declarable contents(List<T> children, Consumer<T> process) {
    // return () -> {
    // // store parent context
    // Object parentContext = localContext;
    //
    // for (T child : children) {
    // if (child != null) {
    // localContext = child;
    // process.accept(child);
    // }
    // }
    //
    // // restore parent context
    // localContext = parentContext;
    // };
    // }

    // /**
    // * <p>
    // * Define children.
    // * </p>
    // *
    // * @param children A list of child widget.
    // */
    // protected <T> Declarable contents(int size, IntConsumer process) {
    // return contents(LocalId.findContextLineNumber(), size, process);
    // }
    //
    // /**
    // * <p>
    // * Define children.
    // * </p>
    // *
    // * @param children A list of child widget.
    // */
    // protected <T> Declarable contents(int initial, int size, IntConsumer process) {
    // return () -> {
    // for (int i = 0; i < size; i++) {
    // localContextIdModifier = (i + 117 + latestElement.id) * 31;
    // process.accept(i + initial);
    // }
    // };
    // }

    /**
     * @version 2015/09/20 16:25:19
     */
    public interface Box {

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        default <T> void contents(Class<? extends Widget1<T>> childType, T[] children) {
            contents(childType, Arrays.asList(children));
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        default <T> void contents(Class<? extends Widget1<T>> childType, List<T> children) {
            VirtualElement parentElement = latestElement;
            latestElement = (VirtualElement) this;

            // store parent context
            Object parentContext = localContext;

            for (T child : children) {
                localContext = child;
                localContextIdModifier = Objects.hash(child);
                widget(Widget.of(childType, child));
            }

            // restore parent context
            localContext = parentContext;

            latestElement = parentElement;
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public default <T> void contents(T[] children, Consumer<T> process) {
            contents(Arrays.asList(children), process);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        public default <T> void contents(List<T> children, Consumer<T> process) {
            // store parent context
            VirtualElement parentElement = latestElement;
            Object parentContext = localContext;

            latestElement = (VirtualElement) this;

            for (T child : children) {
                if (child != null) {
                    localContext = child;
                    process.accept(child);
                }
            }

            // restore parent context
            latestElement = parentElement;
            localContext = parentContext;
        };

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        default <T> void contents(int size, IntConsumer process) {
            contents(LocalId.findContextLineNumber(), size, process);
        }

        /**
         * <p>
         * Define children.
         * </p>
         * 
         * @param children A list of child widget.
         */
        default <T> void contents(int initial, int size, IntConsumer process) {
            VirtualElement parentElement = latestElement;
            latestElement = (VirtualElement) this;

            for (int i = 0; i < size; i++) {
                localContextIdModifier = (i + 117 + latestElement.id) * 31;
                process.accept(i + initial);
            }

            latestElement = parentElement;
        }
    }

    /**
     * @version 2015/09/15 11:18:03
     */
    protected class SVGPath implements Declarable {

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