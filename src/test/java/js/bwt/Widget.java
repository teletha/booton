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

import booton.css.CSS;

/**
 * Bindable Widget Toolkit.
 * 
 * @version 2013/02/03 14:55:32
 */
public abstract class Widget<T> implements Bindable<T> {

    public Text text(Class<? extends CSS> style) {
        return text(style, "");
    }

    public Text text(String text) {
        return text(null, text);
    }

    public Text text(Class<? extends CSS> style, String text) {
        Text box = new Text();
        box.text(text);

        return box;
    }

    /** The current binding. */
    private Value current;

    /**
     * <p>
     * Unwrap binding value.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final void bind(T value) {
        if (current != null) {
            current.unbind(this);
        }

        if (value instanceof Value) {
            Value<T> reference = (Value) value;
            reference.bind(this);

            update(reference.get());

            current = reference;
        } else {
            // normal value
            update(value);

            current = null;
        }
    }
}
