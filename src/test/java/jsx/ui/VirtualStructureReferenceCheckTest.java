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
import java.util.List;
import java.util.Set;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.junit.Test;

/**
 * @version 2014/10/06 23:29:29
 */
public class VirtualStructureReferenceCheckTest {

    @Test
    public void text() throws Exception {
        SingleRootText widget = Widget.of(SingleRootText.class);

        VirtualNodeInfo prev = new VirtualNodeInfo(widget);

        // change widget state
        widget.property.set("change");

        VirtualNodeInfo next = new VirtualNodeInfo(widget, prev);
    }

    /**
     * @version 2014/10/06 23:42:12
     */
    private static class SingleRootText extends Widget {

        private StringProperty property = new SimpleStringProperty("base");

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.asis.〡(property);
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

        private VirtualNodeInfo(Widget widget) {
            // virtualize element
            this.root = widget.virtualize();

            // collect all nodes to test
            collect(root);

            // all nodes don't have reference yet
            hasNoDOMReference();

            // create real DOM
            root.materialize();

            // all nodes create the reference
            hasDOMReference();
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
            hasNoDOMReference();

            // create real DOM from previous
            List<Patch> diff = Diff.diff(previous.root, root);

            for (Patch patch : diff) {
                patch.apply();
            }
            previous.root.dispose();

            // all nodes accept the reference
            hasDOMReference();

            // all previous nodes pass or discard the reference
            previous.hasNoDOMReference();
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
         * Check DOM reference of {@link VirtualNode} recursively.
         * </p>
         */
        private void hasDOMReference() {
            for (VirtualNode node : nodes) {
                assert node.dom != null;
            }
        }

        /**
         * <p>
         * Check DOM reference of {@link VirtualNode} recursively.
         * </p>
         */
        private void hasNoDOMReference() {
            for (VirtualNode node : nodes) {
                assert node.dom == null;
            }
        }
    }
}
