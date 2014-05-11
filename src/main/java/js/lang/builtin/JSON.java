/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.builtin;

import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import js.lang.NativeArray;
import js.lang.NativeNumber;
import js.lang.NativeObject;
import kiss.model.Model;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.Translator;

/**
 * <p>
 * The JSON object contains methods for converting values to JavaScript Object Notation (JSON) and
 * for converting JSON to values.
 * </p>
 * 
 * @version 2013/04/24 9:54:05
 */
@JavascriptAPIProvider
public class JSON implements JavascriptNative {

    /** The javascript engine for reuse. */
    private static final ScriptEngine script;

    static {
        // configure javascript engine
        script = new ScriptEngineManager(Thread.currentThread().getContextClassLoader()).getEngineByName("js");
    }

    /**
     * <p>
     * Parse a string as JSON, optionally transforming the value produced by parsing.
     * </p>
     * 
     * @param text The string to parse as JSON. See the JSON object for a description of JSON
     *            syntax.
     * @return
     */
    @JavascriptNativeProperty
    public NativeObject parse(String text) {
        try {
            return parse(new NativeObject(), script.eval("a=" + text));
        } catch (ScriptException e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Helper method to traverse json structure using Java Object {@link Model}.
     * </p>
     * 
     * @param <M> A current model type.
     * @param model A java object model.
     * @param java A java value.
     * @param js A javascript value.
     * @return A restored java object.
     */
    private NativeObject parse(NativeObject java, Object js) {
        if (js instanceof Map) {
            Map<String, Object> object = (Map) js;

            for (String id : object.keySet()) {
                String key = id.toString();
                Object value = object.get(id);

                if (value instanceof List) {
                    java.setProperty(key, parse(new NativeArray(), value));
                } else if (value instanceof Map) {
                    java.setProperty(key, parse(new NativeObject(), value));
                } else if (value instanceof Double) {
                    java.setProperty(key, new NativeNumber((double) value));
                } else {
                    java.setProperty(key, value.toString());
                }
            }
        }

        // API definition
        return java;
    }

    /**
     * <p>
     * Convert a value to JSON, optionally replacing values if a replacer function is specified, or
     * optionally including only the specified properties if a replacer array is specified.
     * </p>
     * 
     * @param value The value to convert to a JSON string.
     * @return
     */
    @JavascriptNativeProperty
    public native String stringify(Object value);

    /**
     * @version 2013/04/26 11:04:31
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<JSON> {

        /**
         * <p>
         * Parse a string as JSON, optionally transforming the value produced by parsing.
         * </p>
         * 
         * @param text The string to parse as JSON. See the JSON object for a description of JSON
         *            syntax.
         * @return
         */
        public String parse(String text) {
            return "JSON.parse(" + param(0) + ")";
        }

        /**
         * <p>
         * Convert a value to JSON, optionally replacing values if a replacer function is specified,
         * or optionally including only the specified properties if a replacer array is specified.
         * </p>
         * 
         * @param value The value to convert to a JSON string.
         * @return
         */
        public String stringify(Object value) {
            return "JSON.stringify(" + param(0) + ")";
        }
    }
}
