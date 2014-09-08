/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import js.dom.Node;

/**
 * @version 2014/08/29 9:19:56
 */
public abstract class PatchListOperation extends PatchOperation<VirtualElement> {

    /** The target child node. */
    protected VirtualNode child;

    public final Object content;

    /**
     * @param type
     */
    private PatchListOperation(Object content) {
        this.content = content;
    }

    /**
     * 
     */
    protected Node createElementFromVirtualElement(Object element) {
        return ((VirtualNode) element).createNode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase() + " " + content;
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    public static class Remove extends PatchListOperation {

        /**
         * @param content
         */
        public Remove(VirtualElement context, VirtualNode child) {
            super(null);

            this.context = context;
            this.child = child;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate() {
            context.dom.removeChild(child.dom);
        }
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    public static class Insert extends PatchListOperation {

        /**
         * @param content
         */
        public Insert(VirtualElement context, Object content, VirtualNode indexChild) {
            super(content);

            this.context = context;
            this.child = indexChild;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate() {
            Node insert = createElementFromVirtualElement(content);

            if (this.child == null) {
                context.dom.append(insert);
            } else {
                context.dom.insertBefore(insert, child.dom);
            }
        }
    }

    /**
     * @version 2014/08/29 12:45:20
     */
    public static class Last extends PatchListOperation {

        /**
         * @param content
         * @param to
         */
        public Last(VirtualElement context, VirtualNode child) {
            super(null);

            this.context = context;
            this.child = child;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate() {
            context.dom.append(child.dom);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "LAST " + content;
        }
    }

    /**
     * @version 2014/08/29 12:45:20
     */
    public static class Replace extends PatchListOperation {

        /** The from index. */
        private final Object replace;

        public Replace(VirtualElement context, Object replace, VirtualNode child) {
            super(null);

            this.replace = replace;
            this.context = context;
            this.child = child;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate() {
            context.dom.replace(child.dom, createElementFromVirtualElement(replace));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "REPLACE " + content;
        }
    }
}
