/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import booton.translator.Translator;

/**
 * @version 2014/10/15 11:30:35
 */
public class NativeCSSRule {

    /** The css representation. */
    private String css;

    /**
     * <p>
     * The actual text of the style rule.
     * </p>
     * 
     * @return Represents the textual representation of the rule, e.g. "h1,h2 { font-size: 16pt }"
     */
    public String getCSSText() {
        return css;
    }

    /**
     * <p>
     * The actual text of the style rule.
     * </p>
     * <p>
     * Represents the textual representation of the rule, e.g. "h1,h2 { font-size: 16pt }"
     * </p>
     * 
     * @param css Represents the textual representation of the rule, e.g.
     *            "h1,h2 { font-size: 16pt }"
     */
    public void setCSSText(String css) {
        this.css = css;
    }

    /**
     * @version 2014/10/15 11:39:03
     */
    @SuppressWarnings("unused")
    private static class Corder extends Translator<NativeCSSRule> {

        /** The css representation. */
        private String css;

        /**
         * <p>
         * The actual text of the style rule.
         * </p>
         * 
         * @return Represents the textual representation of the rule, e.g.
         *         "h1,h2 { font-size: 16pt }"
         */
        public String getCSSText() {
            return that + ".cssText";
        }

        /**
         * <p>
         * The actual text of the style rule.
         * </p>
         * <p>
         * Represents the textual representation of the rule, e.g. "h1,h2 { font-size: 16pt }"
         * </p>
         * 
         * @param css Represents the textual representation of the rule, e.g.
         *            "h1,h2 { font-size: 16pt }"
         */
        public String setCSSText(String css) {
            return that + ".cssText=" + param(0);
        }
    }
}
