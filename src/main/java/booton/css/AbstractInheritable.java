/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2012/12/12 10:14:26
 */
public class AbstractInheritable<T extends CSSProperty> extends CSSProperty<T> {

    /**
     * 
     */
    protected AbstractInheritable() {
        this(null);
    }

    /**
     * 
     */
    protected AbstractInheritable(String name, T context) {
        super(name, context);
    }

    /**
     * @param name
     */
    public AbstractInheritable(String name) {
        super(name);
    }

    /**
     * <p>
     * Inherit parent property.
     * </p>
     * 
     * @return
     */
    public T inherit() {
        return chain("inherit");
    }
}
