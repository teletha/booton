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
import booton.translator.JavascriptNativePrimitiveNumber;

/**
 * <p>
 * {@link Character} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/04/12 12:58:25
 */
@JavaAPIProvider(Character.class)
class JSChar implements JavascriptNativePrimitiveNumber {

    /** The actual character. */
    private final NativeString character;

    /**
     * @param character
     */
    private JSChar(NativeString character) {
        this.character = character;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NativeNumber valueOf() {
        return new NativeNumber(character.charCodeAt(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return character.toString();
    }
}
