/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.List;
import java.util.Objects;

import js.dom.Element;
import kiss.Disposable;
import booton.virtual.Diff;
import booton.virtual.Patch;
import booton.virtual.VirtualElement;

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
        System.out.println("render");
        Objects.nonNull(root);
        System.out.println("render");
        Objects.nonNull(widget);
        System.out.println("render");
        Rendering rendering = new Rendering(root, widget);
        System.out.println("render");
        rendering.execute();
    }

    /**
     * @version 2014/09/06 10:16:13
     */
    private static class Rendering implements Disposable {

        /** The widget to render. */
        private final Widget widget;

        /** The real root element. */
        private final Element real;

        /** The virtual root element. */
        private VirtualElement virtual = new VirtualElement(0, "div");

        /**
         * @param root A target to DOM element to render widget.
         * @param widget A rendering widget.
         */
        private Rendering(Element root, Widget widget) {
            this.real = root;
            this.widget = widget;
        }

        /**
         * <p>
         * Render UI if needed.
         * </p>
         */
        private void execute() {
            // create new virtual element
            VirtualElement next = widget.virtualize();

            // create patch to manipulate DOM
            List<Patch> patches = Diff.diff(virtual, next);

            // update virtual element
            virtual.dom = real;
            virtual = next;

            // update real element
            for (Patch patch : patches) {
                System.out.println(patch);
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
