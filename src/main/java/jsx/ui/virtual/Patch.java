/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.virtual;

import js.dom.Node;
import booton.css.CSS;

/**
 * @version 2014/09/08 18:21:16
 */
public abstract class Patch {

    /** The parent element. */
    protected final VirtualElement parent;

    /**
     * <p>
     * Create operation.
     * </p>
     * 
     * @param parent A parent (context) element.
     */
    protected Patch(VirtualElement parent) {
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
        return getClass().getSimpleName();
    }

    /**
     * @version 2014/08/29 9:19:56
     */
    private static abstract class ChildPatch extends Patch {

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
        private ChildPatch(VirtualElement parent, VirtualNode child) {
            super(parent);

            this.child = child;
        }

        /**
     * 
     */
        protected Node createElementFromVirtualElement(Object element) {
            return ((VirtualNode) element).materialize();
        }
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    static class RemoveChild extends ChildPatch {

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
    static class InsertChild extends ChildPatch {

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
    static class MoveChild extends ChildPatch {

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
    static class ReplaceChild extends ChildPatch {

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
     * @version 2014/09/14 12:51:53
     */
    static class ReplaceText extends ChildPatch {

        /** The new contents to replace. */
        private final VirtualText replace;

        /**
         * <p>
         * Create text replace operation.
         * </p>
         * 
         * @param child
         * @param replace
         */
        ReplaceText(VirtualText child, VirtualText replace) {
            super(null, child);

            this.replace = replace;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            child.dom.text(replace.text);
        }
    }

    /**
     * @version 2014/09/08 18:19:19
     */
    private static abstract class AttributePatch extends Patch {

        /** The name. */
        protected final String name;

        /** The value. */
        protected final String value;

        /**
         * @param name
         * @param value
         */
        private AttributePatch(VirtualElement parent, String name, String value) {
            super(parent);

            this.name = name;
            this.value = value;
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    static class AddAttribute extends AttributePatch {

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
    static class ChangeAttribute extends AttributePatch {

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
     * @version 2014/09/12 12:11:25
     */
    static class RemoveAttribute extends AttributePatch {

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

    /**
     * @version 2014/09/08 18:19:19
     */
    private static abstract class ClassPatch extends Patch {

        /** The class name. */
        protected final Class<? extends CSS> className;

        /**
         * @param parent
         * @param className
         */
        private ClassPatch(VirtualElement parent, Class<? extends CSS> className) {
            super(parent);

            this.className = className;
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    static class AddClass extends ClassPatch {

        /**
         * <p>
         * Create remove attribute operation.
         * </p>
         * 
         * @param parent
         * @param name
         */
        AddClass(VirtualElement parent, Class<? extends CSS> className) {
            super(parent, className);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.add(className);
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    static class RemoveClass extends ClassPatch {

        /**
         * <p>
         * Create remove attribute operation.
         * </p>
         * 
         * @param parent
         * @param name
         */
        RemoveClass(VirtualElement parent, Class<? extends CSS> className) {
            super(parent, className);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void apply() {
            parent.dom.remove(className);
        }
    }
}
