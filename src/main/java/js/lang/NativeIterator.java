/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.Iterator;

import booton.translator.Translator;

/**
 * @version 2015/02/27 15:16:29
 */
public class NativeIterator<V> {

    /** Java emulator. */
    private final Iterator<V> iterator;

    /**
     * @param iterator
     */
    NativeIterator(Iterator<V> iterator) {
        this.iterator = iterator;
    }

    public Result<V> next() {
        return new Result(iterator);
    }

    /**
     * @version 2015/02/27 15:34:23
     */
    @SuppressWarnings("unused")
    private static class Corder extends Translator<NativeIterator> {

        public String next() {
            return that + ".next()";
        }
    }

    /**
     * @version 2015/02/27 15:32:23
     */
    public static class Result<V> {

        /** The value indicator. */
        private final boolean done;

        /** The value. */
        private final V value;

        /**
         * @param value
         * @param done
         */
        private Result(Iterator<V> iterator) {
            this.done = !iterator.hasNext();
            this.value = done ? null : iterator.next();
        }

        /**
         * Get the done property of this {@link NativeIterator.Result}.
         * 
         * @return The done property.
         */
        public boolean done() {
            return done;
        }

        /**
         * Get the value property of this {@link NativeIterator.Result}.
         * 
         * @return The value property.
         */
        public V value() {
            return value;
        }

        /**
         * @version 2015/02/27 15:35:44
         */
        @SuppressWarnings("unused")
        private static class Corder extends Translator<Result> {

            /**
             * Get the done property of this {@link NativeIterator.Result}.
             * 
             * @return The done property.
             */
            public String done() {
                return that + ".done";
            }

            /**
             * Get the value property of this {@link NativeIterator.Result}.
             * 
             * @return The value property.
             */
            public String value() {
                return that + ".value";
            }

        }
    }
}
