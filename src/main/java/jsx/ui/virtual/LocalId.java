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

import booton.translator.Translator;

/**
 * @version 2014/09/13 9:44:24
 */
class LocalId {

    /** The class name. */
    private static final String CLASS = StructureDSL.class.getName() + "$";

    /**
     * <p>
     * Generate local id.
     * </p>
     * 
     * @return A generated local id.
     */
    static final int generate() {
        Error error = new Error();
        StackTraceElement[] elements = error.getStackTrace();

        for (int i = 0; i < elements.length; i++) {
            StackTraceElement e = elements[i];
            StackTraceElement n = elements[i + 1];

            if (e.getClassName().startsWith(CLASS) && !n.getClassName().startsWith(CLASS)) {
                return elements[i + 1].getLineNumber();
            }
        }

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2014/09/13 9:36:39
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<LocalId> {

        /**
         * <p>
         * Generate local id.
         * </p>
         * 
         * @return A generated local id.
         */
        public String generate() {
            return "0";
        }
    }
}
