/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.builtin;

import booton.translator.Translator;

/**
 * <p>
 * The console object provides access to the browser's debugging console. The specifics of how it
 * works vary from browser to browser, but there is a de facto set of features that are typically
 * provided.
 * </p>
 * 
 * @version 2013/05/16 19:08:10
 */
public class Console {

    /**
     * <p>
     * Displays an interactive list of the properties of the specified JavaScript object. The output
     * is presented as a hierarchical listing with disclosure triangles that let you see the
     * contents of child objects.
     * </p>
     * 
     * @param object A JavaScript object whose properties should be output.
     */
    public static native void dir(Object object);

    /**
     * <p>
     * Outputs an error message to the Web Console.
     * </p>
     * 
     * @param messages A list of objects to output. The string representations of each of these
     *            objects are appended together in the order listed and output.
     */
    public static native void error(Object messages);

    /**
     * <p>
     * Outputs an informational message to the Web Console. In Firefox, a small "i" icon is
     * displayed next to these items in the Web Console's log.
     * </p>
     * 
     * @param messages A list of objects to output. The string representations of each of these
     *            objects are appended together in the order listed and output.
     */
    public static native void info(Object messages);

    /**
     * <p>
     * Outputs a message to the Web Console.
     * </p>
     * 
     * @param messages A list of objects to output. The string representations of each of these
     *            objects are appended together in the order listed and output.
     */
    public static native void log(Object messages);

    /**
     * <p>
     * Outputs a warning message to the Web Console.
     * </p>
     * 
     * @param messages A list of objects to output. The string representations of each of these
     *            objects are appended together in the order listed and output.
     */
    public static native void warn(Object messages);

    /**
     * <p>
     * Outputs a stack trace to the Web Console.
     * </p>
     */
    public static native void trace();

    /**
     * <p>
     * Clears the console output area.
     * </p>
     */
    public static native void clear();

    /**
     * <p>
     * Displays tabular data as a table.
     * </p>
     * 
     * @param value
     */
    public static void table(Object value) {

    }

    /**
     * @version 2013/05/16 19:08:55
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Console> {

        /**
         * <p>
         * Displays an interactive list of the properties of the specified JavaScript object. The
         * output is presented as a hierarchical listing with disclosure triangles that let you see
         * the contents of child objects.
         * </p>
         * 
         * @param object A JavaScript object whose properties should be output.
         */
        public String dir(Object object) {
            return "console.dir(" + param(0) + ")";
        }

        /**
         * <p>
         * Outputs an error message to the Web Console.
         * </p>
         * 
         * @param messages A list of objects to output. The string representations of each of these
         *            objects are appended together in the order listed and output.
         */
        public String error(Object messages) {
            return "console.error(" + param(0) + ")";
        }

        /**
         * <p>
         * Outputs an informational message to the Web Console. In Firefox, a small "i" icon is
         * displayed next to these items in the Web Console's log.
         * </p>
         * 
         * @param messages A list of objects to output. The string representations of each of these
         *            objects are appended together in the order listed and output.
         */
        public String info(Object messages) {
            return "console.info(" + param(0) + ")";
        }

        /**
         * <p>
         * Outputs a message to the Web Console.
         * </p>
         * 
         * @param messages A list of objects to output. The string representations of each of these
         *            objects are appended together in the order listed and output.
         */
        public String log(Object messages) {
            return "console.log(" + param(0) + ")";
        }

        /**
         * <p>
         * Outputs a warning message to the Web Console.
         * </p>
         * 
         * @param messages A list of objects to output. The string representations of each of these
         *            objects are appended together in the order listed and output.
         */
        public String warn(Object messages) {
            return "console.warn(" + param(0) + ")";
        }

        /**
         * <p>
         * Outputs a stack trace to the Web Console.
         * </p>
         */
        public String trace() {
            return "console.trace()";
        }

        /**
         * <p>
         * Clears the console output area.
         * </p>
         */
        public String clear() {
            return "console.clear()";
        }

        /**
         * <p>
         * Displays tabular data as a table.
         * </p>
         * 
         * @param value
         */
        public String table(Object value) {
            return "console.table(" + param(0) + ")";
        }
    }
}
