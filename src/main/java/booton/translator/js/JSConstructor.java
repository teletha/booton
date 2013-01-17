/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;

/**
 * @version 2013/01/17 20:45:34
 */
public class JSConstructor extends JSAnnotatedElement {

    /** The constructor function in runtime. */
    private final NativeObject function;

    /**
     * @param function
     */
    JSConstructor(String name, NativeObject function, NativeObject annotations) {
        super(name, annotations, name);

        this.function = function;
    }
}
