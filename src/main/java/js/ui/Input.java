/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import js.lang.NativeObject;
import js.lang.NativeObject.PropertyDescriptor;
import js.ui.FormUIStyle.InputForm;

/**
 * @version 2013/04/03 11:47:12
 */
public class Input extends FormUI {

    /**
     * 
     */
    public Input() {
        form.attr("type", "input").addClass(InputForm.class);
    }

    /**
     * 
     */
    public Input(String model) {
        form.attr("type", "input").addClass(InputForm.class);
    }

    /**
     * 
     */
    @SuppressWarnings("unused")
    private Input(Object model, String propertyName) {
        form.attr("type", "input").addClass(InputForm.class);

        Object descriptor = NativeObject.getOwnPropertyDescriptor(model, propertyName);

        if (descriptor == null) {
            NativeObject.defineProperty(model, propertyName, new PropertyDescriptor() {

                private Object value;

                /**
                 * {@inheritDoc}
                 */
                @Override
                public Object get() {
                    return value;
                }

                /**
                 * {@inheritDoc}
                 */
                @Override
                public void set(Object value) {
                    this.value = value;
                }
            });
        }

        System.out.println(model);
        System.out.println(propertyName);
        Binder.bind(model, propertyName);
    }
}
