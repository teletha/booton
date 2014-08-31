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

import js.dom.Element;

/**
 * @version 2014/08/31 7:47:07
 */
public abstract class PatchMapOperation extends PatchOperation<Element> {

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
        public Add(String name, String value) {
            super(name, value);
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
        protected void operate(Element target) {
            target.attr(name, value);
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
        public Change(String name, String value) {
            super(name, value);
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
        protected void operate(Element target) {
            target.attr(name, value);
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
        public Remove(String name) {
            super(name, null);
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
        protected void operate(Element target) {
            target.remove(name);
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
