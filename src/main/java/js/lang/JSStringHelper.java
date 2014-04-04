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

import booton.translator.Translator;

/**
 * @version 2013/08/15 14:07:10
 */
class JSStringHelper {

    /** The accessor to bypass. */
    static NativeString that;

    /**
     * @version 2013/08/15 14:08:34
     */
    @SuppressWarnings("unused")
    private static class Corder extends Translator<JSStringHelper> {

        /** The accessor to bypass. */
        public String that = "this";
    }
}