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

import java.util.List;

import js.dom.Element;

/**
 * @version 2014/08/29 9:19:56
 */
public abstract class PatchListOperation {

    public final Object content;

    public final int index;

    /**
     * @param type
     */
    private PatchListOperation(Object content, int index) {
        this.content = content;
        this.index = index;
    }

    /**
     * 
     */
    protected abstract void operate(List target);

    /**
     * 
     */
    protected abstract void operate(Element parent);

    /**
     * 
     */
    protected Element createElementFromVirtualElement(Object element) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return getClass().getSimpleName().toUpperCase() + " " + content + " at " + index;
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    public static class Remove extends PatchListOperation {

        /**
         * @param content
         */
        public Remove(Object content, int index) {
            super(content, index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(List target) {
            target.remove(index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Element parent) {
            parent.children().get(index).remove();
        }
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    public static class Insert extends PatchListOperation {

        /**
         * @param content
         */
        public Insert(Object content, int index) {
            super(content, index);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(List target) {
            target.add(index, content);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Element parent) {
            parent.children().get(index).before(createElementFromVirtualElement(content));
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
        public Last(Object content) {
            super(content, 0);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(List target) {
            target.remove(content);
            target.add(content);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Element parent) {
            parent.append(createElementFromVirtualElement(content));
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

        public Replace(Object content, Object replace, int index) {
            super(content, index);

            this.replace = replace;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(List target) {
            target.set(index, replace);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Element parent) {
            parent.replace(parent.children().get(index), createElementFromVirtualElement(content));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "REPLACE " + content + " at " + index;
        }
    }
}
