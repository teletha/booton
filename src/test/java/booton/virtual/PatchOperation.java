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
 * @version 2014/09/08 18:21:16
 */
public abstract class PatchOperation {

    /** The parent element. */
    protected final VirtualElement parent;

    /**
     * <p>
     * Create operation.
     * </p>
     * 
     * @param parent A parent (context) element.
     */
    protected PatchOperation(VirtualElement parent) {
        this.parent = parent;
    }

    /**
     * <p>
     * Apply this patch operation.
     * </p>
     */
    public abstract void apply();

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase();
    }

    /**
     * @version 2014/08/29 9:19:56
     */
    private static abstract class ChildOperation extends PatchOperation {

        /** The target child node. */
        protected final VirtualNode child;

        /**
         * <p>
         * Create operation for child node manipulation.
         * </p>
         * 
         * @param parent A parent element.
         * @param child A target child node.
         */
        private ChildOperation(VirtualElement parent, VirtualNode child) {
            super(parent);

            this.child = child;
        }

        /**
     * 
     */
        protected Node createElementFromVirtualElement(Object element) {
            return ((VirtualNode) element).createNode();
        }
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    static class RemoveChild extends ChildOperation {

        /**
         * <p>
         * Create child remove operation.
         * </p>
         * 
         * @param parent
         * @param child
         */
        RemoveChild(VirtualElement parent, VirtualNode child) {
            super(parent, child);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.removeChild(child.dom);
        }
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    static class InsertChild extends ChildOperation {

        /** The new contents to insert. */
        private final VirtualNode insert;

        /**
         * <p>
         * Create child insert operation.
         * </p>
         * 
         * @param parent
         * @param child
         * @param insert
         */
        InsertChild(VirtualElement parent, VirtualNode child, VirtualNode insert) {
            super(parent, child);
            this.insert = insert;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            Node created = createElementFromVirtualElement(insert);

            if (this.child == null) {
                parent.dom.append(created);
            } else {
                parent.dom.insertBefore(created, child.dom);
            }
        }
    }

    /**
     * @version 2014/08/29 12:45:20
     */
    static class MoveChild extends ChildOperation {

        /**
         * <p>
         * Create child move operation.
         * </p>
         * 
         * @param parent
         * @param child
         */
        MoveChild(VirtualElement parent, VirtualNode child) {
            super(parent, child);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.append(child.dom);
        }
    }

    /**
     * @version 2014/08/29 12:45:20
     */
    static class ReplaceChild extends ChildOperation {

        /** The new contents to replace. */
        private final VirtualNode replace;

        /**
         * <p>
         * Create child replace operation.
         * </p>
         * 
         * @param parent
         * @param child
         * @param replace
         */
        ReplaceChild(VirtualElement parent, VirtualNode child, VirtualNode replace) {
            super(parent, child);

            this.replace = replace;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.replace(child.dom, createElementFromVirtualElement(replace));
        }
    }

    /**
     * @version 2014/09/08 18:19:19
     */
    private static abstract class AttributeOperation extends PatchOperation {

        /** The name. */
        protected final String name;

        /** The value. */
        protected final String value;

        /**
         * @param name
         * @param value
         */
        private AttributeOperation(VirtualElement parent, String name, String value) {
            super(parent);

            this.name = name;
            this.value = value;
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    static class AddAttribute extends AttributeOperation {

        /**
         * <p>
         * Create add attribute operation.
         * </p>
         * 
         * @param parent
         * @param name
         * @param value
         */
        AddAttribute(VirtualElement parent, String name, String value) {
            super(parent, name, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.attr(name, value);
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    static class ChangeAttribute extends AttributeOperation {

        /**
         * <p>
         * Create change attribute value operation.
         * </p>
         * 
         * @param parent
         * @param name
         * @param value
         */
        ChangeAttribute(VirtualElement parent, String name, String value) {
            super(parent, name, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.attr(name, value);
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    static class RemoveAttribute extends AttributeOperation {

        /**
         * <p>
         * Create remove attribute operation.
         * </p>
         * 
         * @param parent
         * @param name
         */
        RemoveAttribute(VirtualElement parent, String name) {
            super(parent, name, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.remove(name);
        }
    }
}
