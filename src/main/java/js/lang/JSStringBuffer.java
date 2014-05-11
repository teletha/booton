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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/01 0:15:47
 */
@JavaAPIProvider(StringBuffer.class)
class JSStringBuffer extends AbstractStringBuilder<StringBuffer> {

    /**
     * 
     */
    public JSStringBuffer() {
        super();
    }

    /**
     * @param sequence
     */
    public JSStringBuffer(CharSequence sequence) {
        super(sequence);
    }

    /**
     * @param capacity
     */
    public JSStringBuffer(int capacity) {
        super(capacity);
    }

    /**
     * @param value
     */
    public JSStringBuffer(String value) {
        super(value);
    }
}
