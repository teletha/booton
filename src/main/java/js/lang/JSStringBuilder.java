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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/31 23:28:04
 */
@JavaAPIProvider(StringBuilder.class)
class JSStringBuilder extends AbstractStringBuilder<StringBuilder> {

    /**
     * 
     */
    public JSStringBuilder() {
        super();
    }

    /**
     * @param sequence
     */
    public JSStringBuilder(CharSequence sequence) {
        super(sequence);
    }

    /**
     * @param capacity
     */
    public JSStringBuilder(int capacity) {
        super(capacity);
    }

    /**
     * @param value
     */
    public JSStringBuilder(String value) {
        super(value);
    }
}
