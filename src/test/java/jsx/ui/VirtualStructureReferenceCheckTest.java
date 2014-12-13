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

import java.util.HashSet;
import java.util.Set;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jsx.style.Style;
import jsx.ui.piece.Input;
import jsx.ui.piece.UI;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/10/06 23:29:29
 */
@RunWith(ScriptRunner.class)
public class VirtualStructureReferenceCheckTest {

    /** Empty style. */
    private static final Style style = () -> {
    };

    @Test
    public void text() throws Exception {
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
     * @version 2014/10/06 23:42:12
     */
    private static class SingleRootText extends Widget {

        private final StringProperty property = new SimpleStringProperty("base");

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.asis.〡$(property);
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
     * @version 2014/10/06 23:42:12
     */
    private static class NestedElement extends Widget {

        private final IntegerProperty property = new SimpleIntegerProperty(3);

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.hbox.〡(style, () -> {
                for (int i = 1; i <= property.get(); i++) {
                    $〡.vbox(i).〡$("Text" + i);
                }
            });
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
     * @version 2014/10/06 23:42:12
     */
    private static class SingleWidget extends Widget {

        private final Input input = UI.input();

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.asis.〡$(input);
        }
    }

    /**
     * @version 2014/10/07 10:27:26
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
            this.root = widget.virtualize();

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
            this.root = widget.virtualize();

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

            if (node instanceof VirtualFragment) {
                VirtualFragment<?> fragment = (VirtualFragment) node;

                for (int i = 0; i < fragment.items.length(); i++) {
                    collect(fragment.items.get(i));
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

                if (node instanceof VirtualElement) {
                    assert ((VirtualElement) node).events == null;
                }
            }
        }
    }
}
