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

import java.util.Map;

/**
 * @version 2014/08/31 7:47:07
 */
public abstract class PatchMapOperation extends PatchOperation<VirtualElement> {

    /** The name. */
    public final String name;

    /** The value. */
    public final String value;

    /**
     * @param name
     * @param value
     */
    private PatchMapOperation(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 
     */
    protected abstract void operate(Map target);

    /**
     * @version 2014/08/31 8:20:20
     */
    public static class Add extends PatchMapOperation {

        /**
         * 
         */
        public Add(VirtualElement context, String name, String value) {
            super(name, value);

            this.context = context;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Map target) {
            target.put(name, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate() {
            context.dom.attr(name, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ADD [" + name + " = " + value + "]";
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    public static class Change extends PatchMapOperation {

        /**
         * 
         */
        public Change(VirtualElement context, String name, String value) {
            super(name, value);

            this.context = context;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Map target) {
            target.put(name, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate() {
            context.dom.attr(name, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "CHANGE to [" + name + " = " + value + "]";
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    public static class Remove extends PatchMapOperation {

        /**
         * 
         */
        public Remove(VirtualElement context, String name) {
            super(name, null);

            this.context = context;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Map target) {
            target.remove(name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate() {
            context.dom.remove(name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "REMOVE key " + name;
        }
    }
}
