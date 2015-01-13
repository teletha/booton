/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import booton.translator.Translator;

/**
 * @version 2015/01/13 12:33:49
 */
public abstract class Attributes {

    /**
     * <p>
     * Returns the amount of values in this Attributes.
     * </p>
     * 
     * @return Value size.
     */
    protected abstract int length();

    /**
     * <p>
     * Retrieve the {@link Attribute} by numerical indexing.
     * </p>
     * 
     * @param index A index number.
     * @return A indexed {@link Attribute}.
     */
    protected abstract Attribute get(int index);

    /**
     * @version 2015/01/13 12:42:05
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Attributes> {

        /**
         * <p>
         * Returns the amount of values in this Attributes.
         * </p>
         * 
         * @return Value size.
         */
        public String length() {
            return that + ".length";
        }

        /**
         * <p>
         * Retrieve the {@link Attribute} by numerical indexing.
         * </p>
         * 
         * @param index A index number.
         * @return A indexed {@link Attribute}.
         */
        public String get(int index) {
            return that + "[" + param(0) + "]";
        }
    }
}
