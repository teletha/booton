/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import booton.translator.Translator;

/**
 * @version 2014/05/19 22:52:27
 */
public class JavascriptSnippet {

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Integer nocast(int value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Long nocast(long value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Float nocast(float value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Double nocast(double value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Short nocast(short value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Byte nocast(byte value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Character nocast(char value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Write uncast primitive code.
     * </p>
     * 
     * @param value
     * @return
     */
    public static Boolean nocast(boolean value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2014/05/19 22:54:23
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<JavascriptSnippet> {

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(int value) {
            return param(0);
        }

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(long value) {
            return param(0);
        }

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(float value) {
            return param(0);
        }

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(double value) {
            return param(0);
        }

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(char value) {
            return param(0);
        }

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(byte value) {
            return param(0);
        }

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(short value) {
            return param(0);
        }

        /**
         * <p>
         * Write uncast primitive code.
         * </p>
         * 
         * @param value
         * @return
         */
        public String nocast(boolean value) {
            return param(0);
        }
    }
}
