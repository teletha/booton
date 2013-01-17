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
public class JSConstructor<T> extends JSAnnotatedElement {

    /** The declared class. */
    private JSClass declared;

    /** The constructor function in runtime. */
    private final NativeFunction function;

    /**
     * @param function
     */
    JSConstructor(JSClass declared, String name, NativeFunction function, NativeArray<NativeArray> annotations) {
        super(name, annotations);

        this.declared = declared;
        this.function = function;
    }

    /**
     * <p>
     * Uses the constructor represented by this Constructor object to create and initialize a new
     * instance of the constructor's declaring class, with the specified initialization parameters.
     * Individual parameters are automatically unwrapped to match primitive formal parameters, and
     * both primitive and reference parameters are subject to method invocation conversions as
     * necessary.
     * </p>
     * 
     * @param parameters
     * @return
     */
    public T newInstance(Object... parameters) {
        return (T) function.apply(declared, parameters);
    }
}
