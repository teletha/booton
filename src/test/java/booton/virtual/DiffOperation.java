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
public abstract class DiffOperation {

    public final Object content;

    public final int index;

    /**
     * @param type
     */
    private DiffOperation(Object content, int index) {
        this.content = content;
        this.index = index;
    }

    /**
     * 
     */
    protected abstract void operate(List target);

    /**
     * @param child TODO
     */
    protected abstract void operate(Element parent, Element child);

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
    public static class Remove extends DiffOperation {

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
        protected void operate(Element parent, Element child) {
            child.remove();
        }
    }

    /**
     * @version 2014/08/29 9:49:18
     */
    public static class Insert extends DiffOperation {

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
        protected void operate(Element parent, Element child) {
            parent.children().get(index).before(child);
        }
    }

    /**
     * @version 2014/08/29 12:45:20
     */
    public static class Up extends DiffOperation {

        /** The from index. */
        private final int from;

        public Up(Object content, int from, int to) {
            super(content, to);

            this.from = from;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(List target) {
            target.remove(from);
            target.add(index, content);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Element parent, Element child) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "UP " + content + " from " + from + " to " + index;
        }
    }

    /**
     * @version 2014/08/29 12:45:20
     */
    public static class Down extends DiffOperation {

        /** The from index. */
        private final int from;

        public Down(Object content, int from, int to) {
            super(content, to);

            this.from = from;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(List target) {
            target.remove(from);
            target.add(index, content);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Element parent, Element child) {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "DOWN " + content + " from " + from + " to " + index;
        }
    }

    /**
     * @version 2014/08/29 12:45:20
     */
    public static class Replace extends DiffOperation {

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
        protected void operate(Element parent, Element child) {
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
