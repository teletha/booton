/*
 * Copyright (C) 2015 Nameless Production Committee
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
 * The CSS interface holds useful CSS-related methods. No object with this interface are
 * implemented: it contains only static methods and therefore is a utilitarian interface.
 * </p>
 * 
 * @version 2015/09/29 22:21:59
 */
public class CSS {

    /**
     * <p>
     * The CSS.supports() static methods returns a Boolean value indicating if the browser supports
     * a given CSS feature, or not.
     * </p>
     * 
     * @param name A DOMString containing the name of the CSS property to check.
     * @param value A DOMString containing the value of the CSS property to check.
     * @return
     */
    public static boolean supports(String name, String value) {
        return true;
    }

    /**
     * <p>
     * The CSS.supports() static methods returns a Boolean value indicating if the browser supports
     * a given CSS feature, or not.
     * </p>
     * 
     * @param condition A DOMString containing the condition to check.
     * @return
     */
    public static boolean supports(String condition) {
        return true;
    }

    /**
     * @version 2015/09/29 22:26:15
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<CSS> {

        /**
         * <p>
         * The CSS.supports() static methods returns a Boolean value indicating if the browser
         * supports a given CSS feature, or not.
         * </p>
         * 
         * @param name A DOMString containing the name of the CSS property to check.
         * @param value A DOMString containing the value of the CSS property to check.
         * @return
         */
        public String supports(String name, String value) {
            return "CSS.supports(" + param(0) + "," + param(1) + ")";
        }

        /**
         * <p>
         * The CSS.supports() static methods returns a Boolean value indicating if the browser
         * supports a given CSS feature, or not.
         * </p>
         * 
         * @param condition A DOMString containing the condition to check.
         * @return
         */
        public String supports(String condition) {
            return "CSS.supports(" + param(0) + ")";
        }
    }
}
