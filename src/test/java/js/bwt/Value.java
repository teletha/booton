/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2013/02/03 21:39:32
 */
public class Value<T> {

    /** The actual value. */
    private T value;

    /** The bindable object manager. */
    private final List<Bindable> bindables = new ArrayList();

    /**
     * <p>
     * Create reference value.
     * </p>
     * 
     * @param value A initial value.
     */
    public Value(T value) {
        this.value = value;
    }

    /**
     * <p>
     * Get bound value.
     * </p>
     * 
     * @return A bound value.
     */
    public T get() {
        return value;
    }

    /**
     * <p>
     * Set new value to bind.
     * </p>
     * 
     * @param value
     */
    public void set(T value) {
        this.value = value;

        for (Bindable bindable : bindables) {
            bindable.update(value);
        }
    }

    /**
     * <p>
     * Bind with the specified object.
     * </p>
     * 
     * @param bindable
     */
    public void bind(Bindable bindable) {
        if (bindable != null && !bindables.contains(bindable)) {
            bindables.add(bindable);
        }
    }

    /**
     * <p>
     * Unbind with the specified object.
     * </p>
     * 
     * @param bindable
     */
    public void unbind(Bindable bindable) {
        if (bindable != null) {
            bindables.remove(bindable);
        }
    }

    /**
     * <p>
     * Unwrap binding value.
     * </p>
     * 
     * @param value
     * @return
     */
    public static final <T> T convert(T value) {
        if (value instanceof Value) {
            return ((Value<T>) value).value;
        } else {
            return value;
        }
    }
}
