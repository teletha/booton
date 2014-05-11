/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import js.lang.JSLong.Primitive;
import booton.translator.Translator;

/**
 * @version 2014/03/26 23:30:56
 */
class JSLongHelper {

    /**
     * <p>
     * Convert to primitive long.
     * </p>
     * 
     * @param value
     * @return
     */
    static long $(Primitive value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2014/03/26 23:28:55
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<JSLongHelper> {

        /**
         * <p>
         * Convert to primitive long.
         * </p>
         * 
         * @param value
         * @return
         */
        public String $(Primitive value) {
            return param(0);
        }
    }
}
