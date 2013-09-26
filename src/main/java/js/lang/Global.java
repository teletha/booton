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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import js.dom.Document;
import js.dom.Element;
import js.dom.EmulateDocument;
import js.dom.History;
import js.dom.Location;
import js.dom.Window;
import js.lang.builtin.JSON;
import js.lang.builtin.Storage;
import jsx.jQuery;

import org.w3c.dom.DocumentFragment;

import booton.translator.Translator;

/**
 * <p>
 * Define global objects and static methods in Booton environment.
 * </p>
 * 
 * @version 2013/09/26 16:30:55
 */
public class Global {

    /** The booton root object. */
    public static NativeObject boot;

    /** The global object in web environment. */
    public static Window window;

    /** The root document in web environment. */
    public static final Document document = new EmulateDocument();

    /**
     * <p>
     * Returns a reference to the History object, which provides an interface for manipulating the
     * browser session history (pages visited in the tab or frame that the current page is loaded
     * in).
     * </p>
     */
    public static History history;

    /**
     * <p>
     * Returns a Location object, which contains information about the URL of the document and
     * provides methods for changing that URL. You can also assign to this property to load another
     * URL.
     * </p>
     */
    public static Location location;

    /**
     * <p>
     * localStorage is the same as sessionStorage with same same-origin rules applied but it is
     * persistent. localStorage was introduced in Firefox 3.5.
     * </p>
     */
    public static Storage localStorage;

    /**
     * <p>
     * This is a global object (sessionStorage) that maintains a storage area that's available for
     * the duration of the page session. A page session lasts for as long as the browser is open and
     * survives over page reloads and restores. Opening a page in a new tab or window will cause a
     * new session to be initiated.
     * </p>
     */
    public static Storage sessionStorage;

    /**
     * <p>
     * The JSON object contains methods for converting values to JavaScript Object Notation (JSON)
     * and for converting JSON to values.
     * </p>
     */
    public static final JSON JSON = new JSON();

    /** The async task manager. */
    private static final TaskManager manager = new TaskManager();

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param expression
     * @return A empty {@link jQuery} instance.
     */
    public static native jQuery $();

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param expression
     * @return
     */
    public static native jQuery $(String expression);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param expression
     * @return
     */
    public static native jQuery $(Element element);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param document
     * @return
     */
    public static native jQuery $(Document document);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param document
     * @return
     */
    public static native jQuery $(DocumentFragment document);

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param window
     * @return
     */
    public static native jQuery $(Window window);

    /**
     * <p>
     * Calls a function or executes a code snippet after specified delay.
     * </p>
     * 
     * @param function A callable function.
     * @param delay A delay time.
     * @return A timeout id.
     */
    public static long setTimeout(Runnable runnable, long delay) {
        return manager.add(new NativeFunction(runnable).bind(runnable), delay);
    }

    /**
     * <p>
     * Clears the delay set by setTimeout().
     * </p>
     * 
     * @param timeoutId The ID of the timeout you wish to clear, as returned by setTimeout().
     */
    public static void clearTimeout(long timeoutId) {
        manager.remove(timeoutId);
    }

    /**
     * <p>
     * Retrieve context (this).
     * </p>
     * 
     * @return
     */
    public static native Object getContext();

    /**
     * <p>
     * Retrieve current function (arguments.callee).
     * </p>
     * 
     * @return
     */
    public static native NativeFunction getContextFuntion();

    /**
     * <p>
     * Retrieve arguments as array.
     * </p>
     * 
     * @return
     */
    public static native Object[] getArgumentArray();

    /**
     * <p>
     * Parses a string argument and returns an integer of 10 radix.
     * </p>
     * 
     * @param value The value to parse. If string is not a string, then it is converted to one.
     *            Leading whitespace in the string is ignored.
     * @return A parsed number value.
     */
    public static int parseInt(String value) {
        double parsed = Double.parseDouble(value);

        if (0 <= parsed) {
            return (int) Math.floor(parsed);
        } else {
            return (int) Math.ceil(parsed);
        }
    }

    /**
     * <p>
     * Parses a string argument and returns an integer of the specified radix or base.
     * </p>
     * 
     * @param value The value to parse. If string is not a string, then it is converted to one.
     *            Leading whitespace in the string is ignored.
     * @param radix An integer that represents the radix of the above mentioned string. Always
     *            specify this parameter to eliminate reader confusion and to guarantee predictable
     *            behavior. Different implementations produce different results when a radix is not
     *            specified.
     * @return A parsed number value.
     */
    public static native int parseInt(String value, int radix);

    /**
     * <p>
     * Parses a string argument and returns a floating point number.
     * </p>
     * 
     * @param value A string that represents the value you want to parse.
     * @return A parsed number value.
     */
    public static native float parseFloat(char value);

    /**
     * <p>
     * Parses a string argument and returns a floating point number.
     * </p>
     * 
     * @param value A string that represents the value you want to parse.
     * @return A parsed number value.
     */
    public static float parseFloat(String value) {
        if (value == null) {
            return Float.NaN;
        }

        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            return Float.NaN;
        }
    }

    /**
     * <p>
     * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
     * interested in ECMAScript 6 Number.isNaN.
     * </p>
     * 
     * @param value The value to be tested.
     * @return A result.
     */
    public static boolean isNaN(int value) {
        return false;
    }

    /**
     * <p>
     * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
     * interested in ECMAScript 6 Number.isNaN.
     * </p>
     * 
     * @param value The value to be tested.
     * @return A result.
     */
    public static boolean isNaN(long value) {
        return false;
    }

    /**
     * <p>
     * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
     * interested in ECMAScript 6 Number.isNaN.
     * </p>
     * 
     * @param value The value to be tested.
     * @return A result.
     */
    public static boolean isNaN(float value) {
        return Float.isNaN(value);
    }

    /**
     * <p>
     * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
     * interested in ECMAScript 6 Number.isNaN.
     * </p>
     * 
     * @param value The value to be tested. Stringt.
     */
    public static boolean isNaN(double value) {
        return Double.isNaN(value);
    }

    /**
     * <p>
     * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
     * interested in ECMAScript 6 Number.isNaN.
     * </p>
     * 
     * @param value The value to be tested.
     * @return A result.
     */
    public static native boolean isNaN(Object value);

    /**
     * <p>
     * Evaluates an argument to determine whether it is a finite number.
     * </p>
     * <p>
     * You can use this function to determine whether a number is a finite number. The isFinite
     * function examines the number in its argument. If the argument is NaN, positive infinity, or
     * negative infinity, this method returns false; otherwise, it returns true.
     * </p>
     * 
     * @param value The number to evaluate.
     * @return A result.
     */
    public static native boolean isFinit(int value);

    /**
     * <p>
     * Evaluates an argument to determine whether it is a finite number.
     * </p>
     * <p>
     * You can use this function to determine whether a number is a finite number. The isFinite
     * function examines the number in its argument. If the argument is NaN, positive infinity, or
     * negative infinity, this method returns false; otherwise, it returns true.
     * </p>
     * 
     * @param value The number to evaluate.
     * @return A result.
     */
    public static native boolean isFinit(long value);

    /**
     * <p>
     * Evaluates an argument to determine whether it is a finite number.
     * </p>
     * <p>
     * You can use this function to determine whether a number is a finite number. The isFinite
     * function examines the number in its argument. If the argument is NaN, positive infinity, or
     * negative infinity, this method returns false; otherwise, it returns true.
     * </p>
     * 
     * @param value The number to evaluate.
     * @return A result.
     */
    public static native boolean isFinit(float value);

    /**
     * <p>
     * Evaluates an argument to determine whether it is a finite number.
     * </p>
     * <p>
     * You can use this function to determine whether a number is a finite number. The isFinite
     * function examines the number in its argument. If the argument is NaN, positive infinity, or
     * negative infinity, this method returns false; otherwise, it returns true.
     * </p>
     * 
     * @param value The number to evaluate.
     * @return A result.
     */
    public static native boolean isFinit(double value);

    /**
     * <p>
     * Evaluates an argument to determine whether it is a finite number.
     * </p>
     * <p>
     * You can use this function to determine whether a number is a finite number. The isFinite
     * function examines the number in its argument. If the argument is NaN, positive infinity, or
     * negative infinity, this method returns false; otherwise, it returns true.
     * </p>
     * 
     * @param value The number to evaluate.
     * @return A result.
     */
    public static native boolean isFinit(Object value);

    /**
     * <p>
     * Determines whether its argument is a number.
     * </p>
     * 
     * @param character The value to be tested.
     * @return A result.
     */
    public static native boolean isNumeric(char value);

    /**
     * <p>
     * Throw native error to build stack trace.
     * </p>
     * 
     * @return
     */
    static native NativeError error();

    /**
     * @version 2013/07/30 19:34:33
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<Global> {

        /** The booton root object. */
        public String boot = "boot";

        /** The global object in web environment. */
        public String window = "window";

        /** The root document. */
        public String document = "document";

        /** The root document. */
        public String history = "history";

        /**
         * <p>
         * Returns a Location object, which contains information about the URL of the document and
         * provides methods for changing that URL. You can also assign to this property to load
         * another URL.
         * </p>
         */
        public String location = "location";

        /**
         * <p>
         * localStorage is the same as sessionStorage with same same-origin rules applied but it is
         * persistent. localStorage was introduced in Firefox 3.5.
         * </p>
         */
        public String localStorage = "localStorage";

        /**
         * <p>
         * This is a global object (sessionStorage) that maintains a storage area that's available
         * for the duration of the page session. A page session lasts for as long as the browser is
         * open and survives over page reloads and restores. Opening a page in a new tab or window
         * will cause a new session to be initiated.
         * </p>
         */
        public String sessionStorage = "sessionStorage";

        /**
         * <p>
         * The JSON object contains methods for converting values to JavaScript Object Notation
         * (JSON) and for converting JSON to values.
         * </p>
         */
        public String JSON = "JSON";

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param expression
         * @return A empty {@link jQuery} instance.
         */
        public String $() {
            return "$()";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param expression
         * @return
         */
        public String $(String expression) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param expression
         * @return
         */
        public String $(Element element) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param object
         * @return
         */
        public String $(Document object) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param document
         * @return
         */
        public String $(DocumentFragment document) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Provide Raphael support.
         * </p>
         * 
         * @param parent
         * @param width
         * @param height
         * @return
         */
        public String $(Element parent, int width, int height) {
            return "Raphael(" + param(0) + "," + param(1) + "," + param(2) + ")";
        }

        /**
         * <p>
         * Provide JQuery support.
         * </p>
         * 
         * @param object
         * @return
         */
        public String $(Window object) {
            return "$(" + param(0) + ")";
        }

        /**
         * <p>
         * Calls a function or executes a code snippet after specified delay.
         * </p>
         * 
         * @param function A callable function.
         * @param delay A delay time.
         * @return A timeout id.
         */
        public String setTimeout(Runnable runnable, long delay) {
            return "setTimeout(" + function(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Clears the delay set by setTimeout().
         * </p>
         * 
         * @param timeoutId The ID of the timeout you wish to clear, as returned by setTimeout().
         */
        public String clearTimeout(long timeoutId) {
            return "clearTimeout(" + param(0) + ")";
        }

        /**
         * <p>
         * Retrieve context (this).
         * </p>
         * 
         * @return
         */
        public String getContext() {
            return "this";
        }

        /**
         * <p>
         * Retrieve current function (arguments.callee).
         * </p>
         * 
         * @return
         */
        public String getContextFuntion() {
            return "arguments.callee";
        }

        /**
         * <p>
         * Clears the delay set by setTimeout().
         * </p>
         * 
         * @param timeoutId The ID of the timeout you wish to clear, as returned by setTimeout().
         */
        public String getArgumentArray() {
            return "Array.prototype.slice.call(arguments)";
        }

        /**
         * <p>
         * Parses a string argument and returns an integer of 10 radix.
         * </p>
         * 
         * @param value The value to parse. If string is not a string, then it is converted to one.
         *            Leading whitespace in the string is ignored.
         * @return A parsed number value.
         */
        public String parseInt(String value) {
            return "parseInt(" + param(0) + ")";
        }

        /**
         * <p>
         * Parses a string argument and returns an integer of the specified radix or base.
         * </p>
         * 
         * @param value The value to parse. If string is not a string, then it is converted to one.
         *            Leading whitespace in the string is ignored.
         * @param radix An integer that represents the radix of the above mentioned string. Always
         *            specify this parameter to eliminate reader confusion and to guarantee
         *            predictable behavior. Different implementations produce different results when
         *            a radix is not specified.
         * @return A parsed number value.
         */
        public String parseInt(String value, int radix) {
            return "parseInt(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * Parses a string argument and returns a floating point number.
         * </p>
         * 
         * @param value A string that represents the value you want to parse.
         * @return A parsed number value.
         */
        public String parseFloat(String value) {
            return "parseFloat(" + param(0) + ")";
        }

        /**
         * <p>
         * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
         * interested in ECMAScript 6 Number.isNaN.
         * </p>
         * 
         * @param value The value to be tested.
         * @return A result.
         */
        public String isNaN(int value) {
            return "isNaN(" + param(0) + ")";
        }

        /**
         * <p>
         * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
         * interested in ECMAScript 6 Number.isNaN.
         * </p>
         * 
         * @param value The value to be tested.
         * @return A result.
         */
        public String isNaN(long value) {
            return "isNaN(" + param(0) + ")";
        }

        /**
         * <p>
         * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
         * interested in ECMAScript 6 Number.isNaN.
         * </p>
         * 
         * @param value The value to be tested.
         * @return A result.
         */
        public String isNaN(float value) {
            return "isNaN(" + param(0) + ")";
        }

        /**
         * <p>
         * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
         * interested in ECMAScript 6 Number.isNaN.
         * </p>
         * 
         * @param value The value to be tested.
         * @return A result.
         */
        public String isNaN(double value) {
            return "isNaN(" + param(0) + ")";
        }

        /**
         * <p>
         * Determines whether a value is NaN or not. Be careful, this function is broken. You may be
         * interested in ECMAScript 6 Number.isNaN.
         * </p>
         * 
         * @param value The value to be tested.
         * @return A result.
         */
        public String isNaN(Object value) {
            return "isNaN(" + param(0) + ")";
        }

        /**
         * <p>
         * Evaluates an argument to determine whether it is a finite number.
         * </p>
         * <p>
         * You can use this function to determine whether a number is a finite number. The isFinite
         * function examines the number in its argument. If the argument is NaN, positive infinity,
         * or negative infinity, this method returns false; otherwise, it returns true.
         * </p>
         * 
         * @param value The number to evaluate.
         * @return A result.
         */
        public String isFinit(int value) {
            return "isFinite(" + param(0) + ")";
        }

        /**
         * <p>
         * Evaluates an argument to determine whether it is a finite number.
         * </p>
         * <p>
         * You can use this function to determine whether a number is a finite number. The isFinite
         * function examines the number in its argument. If the argument is NaN, positive infinity,
         * or negative infinity, this method returns false; otherwise, it returns true.
         * </p>
         * 
         * @param value The number to evaluate.
         * @return A result.
         */
        public String isFinit(long value) {
            return "isFinite(" + param(0) + ")";
        }

        /**
         * <p>
         * Evaluates an argument to determine whether it is a finite number.
         * </p>
         * <p>
         * You can use this function to determine whether a number is a finite number. The isFinite
         * function examines the number in its argument. If the argument is NaN, positive infinity,
         * or negative infinity, this method returns false; otherwise, it returns true.
         * </p>
         * 
         * @param value The number to evaluate.
         * @return A result.
         */
        public String isFinit(float value) {
            return "isFinite(" + param(0) + ")";
        }

        /**
         * <p>
         * Evaluates an argument to determine whether it is a finite number.
         * </p>
         * <p>
         * You can use this function to determine whether a number is a finite number. The isFinite
         * function examines the number in its argument. If the argument is NaN, positive infinity,
         * or negative infinity, this method returns false; otherwise, it returns true.
         * </p>
         * 
         * @param value The number to evaluate.
         * @return A result.
         */
        public String isFinit(double value) {
            return "isFinite(" + param(0) + ")";
        }

        /**
         * <p>
         * Evaluates an argument to determine whether it is a finite number.
         * </p>
         * <p>
         * You can use this function to determine whether a number is a finite number. The isFinite
         * function examines the number in its argument. If the argument is NaN, positive infinity,
         * or negative infinity, this method returns false; otherwise, it returns true.
         * </p>
         * 
         * @param value The number to evaluate.
         * @return A result.
         */
        public String isFinit(Object value) {
            return "isFinite(" + param(0) + ")";
        }

        /**
         * <p>
         * Determines whether its argument is a number.
         * </p>
         * 
         * @param character The value to be tested.
         * @return A result.
         */
        public String isNumeric(char value) {
            return "boot.isNumeric(" + param(0) + ")";
        }

        /**
         * <p>
         * Throw native error to build stack trace.
         * </p>
         * 
         * @return
         */
        public String error() {
            return "boot.error()";
        }
    }

    /**
     * @version 2013/08/18 14:41:37
     */
    private static class TaskManager implements Runnable {

        /** The task id counter. */
        private static long id = 0;

        /** The thread pool. */
        private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        /** The scheduled tasks. */
        private final Map<Long, ScheduledFuture> scheduledTasks = new ConcurrentHashMap();

        private long add(NativeFunction runnable, long delay) {
            Task task = new Task(runnable, id++);
            ScheduledFuture future = executor.schedule(task, delay, TimeUnit.MILLISECONDS);

            scheduledTasks.put(task.id, future);

            return task.id;
        }

        private void remove(long id) {
            ScheduledFuture future = scheduledTasks.get(id);

            if (future != null) {
                future.cancel(true);
                scheduledTasks.remove(id);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void run() {

        }

        /**
         * @version 2013/08/18 14:45:14
         */
        private class Task implements Runnable {

            /** The actual task. */
            private final NativeFunction task;

            /** The task id. */
            private final long id;

            /**
             * @param task
             */
            private Task(NativeFunction task, long id) {
                this.task = task;
                this.id = id;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void run() {
                try {
                    task.apply(task, new Object[0]);
                } finally {
                    remove(id);
                }
            }
        }
    }
}
