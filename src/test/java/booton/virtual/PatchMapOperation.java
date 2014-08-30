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
public abstract class PatchMapOperation {

    /** The key. */
    public final Object key;

    /** The value. */
    public final Object value;

    /**
     * @param key
     * @param value
     */
    private PatchMapOperation(Object key, Object value) {
        this.key = key;
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
        public Add(Object key, Object value) {
            super(key, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Map target) {
            target.put(key, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ADD [" + key + " = " + value + "]";
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    public static class Change extends PatchMapOperation {

        /**
         * 
         */
        public Change(Object key, Object value) {
            super(key, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Map target) {
            target.put(key, value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "CHANGE to [" + key + " = " + value + "]";
        }
    }

    /**
     * @version 2014/08/31 8:20:20
     */
    public static class Remove extends PatchMapOperation {

        /**
         * 
         */
        public Remove(Object key) {
            super(key, null);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Map target) {
            target.remove(key);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "REMOVE key " + key;
        }
    }
}
