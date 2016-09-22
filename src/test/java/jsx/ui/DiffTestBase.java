/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.List;

import js.dom.Node;
import js.dom.NodeComparator;
import jsx.style.Style;
import jsx.style.StyleDSL;

/**
 * @version 2015/10/05 0:15:02
 */
public class DiffTestBase extends StructureDSL {

    /** Empty style. */
    protected static final Style style = () -> {
    };

    /**
     * <p>
     * Create {@link VirtualWidget}.
     * </p>
     * 
     * @param writer
     * @return
     */
    protected final VirtualWidget make(Runnable writer) {
        return createWidget(make(DSLWidget.class, writer));
    }

    /**
     * <p>
     * Create sub widget with DSL.
     * </p>
     * 
     * @param type
     * @param dsl
     * @return
     */
    protected final Widget make(Class<? extends DSLWidget> type, Runnable dsl) {
        DSLWidget widget = Widget.of(type);
        widget.dsl = dsl;

        return widget;
    }

    /**
     * <p>
     * Assert structure diff.
     * </p>
     * 
     * @param prev
     * @param next
     * @param expectedOperationCount
     */
    protected final void assertDiff(VirtualElement prev, VirtualElement next, int expectedOperationCount) {
        Node prevNode = prev.dom != null ? prev.dom : prev.materialize();
        Node nextNode = next.dom != null ? next.dom : next.materialize();
        clean(next);

        List<Patch> ops = PatchDiff.diff(prev, next);

        for (int i = 0; i < ops.size(); i++) {
            try {
                ops.get(i).apply();
            } catch (IndexOutOfBoundsException e) {
                AssertionError error = new AssertionError(message(prevNode, nextNode, ops, i));
                error.addSuppressed(e);

                throw error;
            }
        }

        String message = message(prevNode, nextNode, ops, ops.size());
        assert expectedOperationCount == ops.size() : message;

        try {
            NodeComparator.equals(prevNode, nextNode);
        } catch (AssertionError e) {
            e.addSuppressed(new Error(message));
            throw e;
        }
    }

    /**
     * <p>
     * Clean up dom reference.
     * </p>
     * 
     * @param node
     */
    private void clean(VirtualNode node) {
        node.dom = null;

        if (node instanceof VirtualElement) {
            VirtualElement element = (VirtualElement) node;

            for (int i = 0; i < element.items.length(); i++) {
                clean(element.items.get(i));
            }
        }
    }

    /**
     * <p>
     * Helper to write erro message.
     * </p>
     * 
     * @param prev
     * @param next
     * @param ops
     * @param size
     * @return
     */
    private String message(Node prev, Node next, List<Patch> ops, int size) {
        StringBuilder message = new StringBuilder("\r\n");
        message.append("PREV: ").append(prev).append("\r\n");
        message.append("NEXT: ").append(next).append("\r\n");
        message.append("OPERATIONS:\r\n");

        for (int i = 0; i < size; i++) {
            message.append(ops.get(i)).append("  ").append("\r\n");
        }

        if (size != ops.size()) {
            message.append("\r\nNOEXECUTED:\r\n");

            for (int i = size; i < ops.size(); i++) {
                message.append(ops.get(i)).append("\r\n");
            }
        }
        return message.toString();
    }

    /**
     * @version 2015/10/04 22:38:07
     */
    protected static class DSLWidget extends Widget<StyleDSL> {

        /** The actual dsl. */
        private Runnable dsl;

        /**
         * {@inheritDoc}
         */
        @Override
        protected StructureDSL virtualize() {
            return new StructureDSL() {

                {
                    dsl.run();
                }
            };
        }
    }
}
