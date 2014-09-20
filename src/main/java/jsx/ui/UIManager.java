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

import java.util.List;
import java.util.Objects;

import js.dom.Element;
import kiss.Disposable;

/**
 * @version 2014/09/06 10:10:57
 */
public class UIManager {

    /**
     * <p>
     * Render UI {@link Widget} on the specified {@link Element}.
     * </p>
     * 
     * @param root A target to DOM element to render widget.
     * @param widget A rendering widget.
     */
    public static void render(Element root, Widget widget) {
        Objects.nonNull(root);
        Objects.nonNull(widget);

        Rendering rendering = new Rendering(root, widget);
        rendering.execute();
    }

    /**
     * @version 2014/09/06 10:16:13
     */
    private static class Rendering implements Disposable {

        /** The widget to render. */
        private final Widget widget;

        /** The virtual root element. */
        private VirtualElement virtual;

        /**
         * @param root A target to DOM element to render widget.
         * @param widget A rendering widget.
         */
        private Rendering(Element root, Widget widget) {
            this.widget = widget;
            this.virtual = new VirtualElement(0, "div");
            this.virtual.dom = root;
        }

        /**
         * <p>
         * Render UI if needed.
         * </p>
         */
        private void execute() {
            // create new virtual element
            StructureDSL structure = new StructureDSL();
            widget.virtualize(structure);
            VirtualElement next = structure.getRoot();

            // create patch to manipulate DOM
            List<Patch> patches = Diff.diff(virtual, next);

            // update virtual element
            virtual = next;

            // update real element
            for (Patch patch : patches) {
                patch.apply();
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void dispose() {
        }
    }
}
