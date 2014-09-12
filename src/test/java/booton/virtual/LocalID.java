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

import booton.virtual.VirtualStructure.Descriptor;

/**
 * @version 2014/09/12 21:41:01
 */
class LocalID {

    /** The class name. */
    private static final String CLASS = Descriptor.class.getName();

    /**
     * <p>
     * Find local id.
     * </p>
     * 
     * @return A local id.
     */
    static final int find() {
        Error error = new Error();
        StackTraceElement[] elements = error.getStackTrace();

        for (int i = 0; i < elements.length; i++) {
            StackTraceElement e = elements[i];

            if (e.getClassName().equals(CLASS)) {
                return elements[i + 1].getLineNumber();
            }
        }

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
