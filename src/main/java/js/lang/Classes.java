/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import kiss.I;
import booton.translator.Translator;

/**
 * @version 2013/01/09 23:45:29
 */
public class Classes {

    /**
     * <p>
     * Create new instance from {@link Class}.
     * </p>
     * 
     * @param type A target class to instantiate.
     * @return A new instance.
     */
    public static <T> T newInstance(Class<T> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Create new instance from {@link Class}.
     * </p>
     * 
     * @param type A target class to instantiate.
     * @return A new instance.
     */
    public static <T> T newInstance(Class<T> type, Object[] params) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/01/09 23:48:39
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Classes> {

        /**
         * <p>
         * Create new instance from {@link Class}.
         * </p>
         * 
         * @param type A target class to instantiate.
         * @return A new instance.
         */
        public String newInstance(Class type) {
            return param(0) + ".newInstance(0)";
        }

        /**
         * <p>
         * Create new instance from {@link Class}.
         * </p>
         * 
         * @param type A target class to instantiate.
         * @return A new instance.
         */
        public String newInstance(Class type, Object[] params) {
            return param(0) + ".newInstance(0," + param(1) + ")";
        }
    }
}
