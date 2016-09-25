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

import static jsx.ui.StructureDSL.*;

import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import jsx.style.Style;
import jsx.style.StyleDSL;
import jsx.ui.piece.Input;
import jsx.ui.piece.UI;

/**
 * @version 2015/10/05 1:52:57
 */
@RunWith(ScriptRunner.class)
public class ReferenceCheckTest {

    private static final Style style = () -> {
    };

    @Test
    public void textChange() throws Exception {
        SingleRootText widget = Widget.of(SingleRootText.class);

        VirtualNodeInfo info = new VirtualNodeInfo(widget);

        // change widget state
        widget.property.set("change");

        info = new VirtualNodeInfo(widget, info);

        // change widget state
        widget.property.set("change again");

        info = new VirtualNodeInfo(widget, info);
    }

    /**
     * @version 2015/10/05 1:45:14
     */
    private static class SingleRootText extends Widget<StyleDSL> {

        private final StringProperty property = new SimpleStringProperty("base");

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            /**
             * {@inheritDoc}
             */
            @Override
            protected void virtualize() {
                text(property);
            }
        }
    }

    @Test
    public void nestedElement() throws Exception {
        NestedElement widget = Widget.of(NestedElement.class);

        VirtualNodeInfo info = new VirtualNodeInfo(widget);

        // change widget state
        widget.property.set(5);

        info = new VirtualNodeInfo(widget, info);

        // change widget state
        widget.property.set(1);

        info = new VirtualNodeInfo(widget, info);
    }

    /**
     * @version 2015/10/05 1:50:40
     */
    private static class NestedElement extends Widget<StyleDSL> {

        private final IntegerProperty property = new SimpleIntegerProperty(3);

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            /**
             * {@inheritDoc}
             */
            @Override
            protected void virtualize() {
                box(style, contents(1, property.get(), i -> {
                    text("Text" + i);
                }));
            }
        }
    }

    @Test
    public void widget() throws Exception {
        SingleWidget widget = Widget.of(SingleWidget.class);

        VirtualNodeInfo info = new VirtualNodeInfo(widget);

        // change widget state
        widget.input.value.set("change");

        info = new VirtualNodeInfo(widget, info);

        // change widget state
        widget.input.value.set("change again");

        info = new VirtualNodeInfo(widget, info);
    }

    /**
     * @version 2015/10/05 1:52:04
     */
    private static class SingleWidget extends Widget<StyleDSL> {

        private final Input input = UI.input();

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            /**
             * {@inheritDoc}
             */
            @Override
            protected void virtualize() {
                box(input);
            }
        }
    }

    /**
     * @version 2015/10/05 1:38:33
     */
    private static class VirtualNodeInfo {

        /** The root element. */
        private final VirtualElement root;

        /** The node container. */
        private final Set<VirtualNode> nodes = new HashSet();

        /**
         * <p>
         * Collect {@link VirtualNode} info.
         * </p>
         * 
         * @param widget A target widget.
         */
        private VirtualNodeInfo(Widget widget) {
            // virtualize element
            this.root = createWidget(widget);

            // collect all nodes to test
            collect(root);

            // all nodes don't have reference yet
            hasNoReference();

            // create real DOM
            root.materialize();

            // all nodes create the reference
            hasReference();
        }

        /**
         * <p>
         * Collect {@link VirtualNode} info.
         * </p>
         * 
         * @param widget A target widget.
         * @param previous A previous state.
         */
        private VirtualNodeInfo(Widget widget, VirtualNodeInfo previous) {
            // virtualize element
            this.root = createWidget(widget);

            // collect all nodes to test
            collect(root);

            // all nodes don't have reference yet
            hasNoReference();

            // create real DOM from previous
            PatchDiff.apply(previous.root, root);

            // all nodes accept the reference
            hasReference();

            // all previous nodes pass or discard the reference
            previous.hasNoReference();
        }

        /**
         * Collect all {@link VirtualNode} recursively.
         */
        private void collect(VirtualNode node) {
            nodes.add(node);

            if (node instanceof VirtualElement) {
                VirtualElement element = (VirtualElement) node;

                for (int i = 0; i < element.items.length(); i++) {
                    collect(element.items.get(i));
                }
            }
        }

        /**
         * <p>
         * Check reference of {@link VirtualNode} recursively.
         * </p>
         */
        private void hasReference() {
            for (VirtualNode node : nodes) {
                assert node.dom != null;
            }
        }

        /**
         * <p>
         * Check reference of {@link VirtualNode} recursively.
         * </p>
         */
        private void hasNoReference() {
            for (VirtualNode node : nodes) {
                assert node.dom == null;
            }
        }
    }
}
