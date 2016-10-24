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

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import js.lang.NativeObject;

/**
 * <p>
 * The JSON object contains methods for converting values to JavaScript Object Notation (JSON) and
 * for converting JSON to values.
 * </p>
 * 
 * @version 2015/01/13 10:04:00
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "JSON")
public class JSON implements JavascriptNative {

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
    public native NativeObject parse(String text);

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
}
