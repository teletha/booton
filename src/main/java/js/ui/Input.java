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

import java.util.List;

import js.lang.NativeObject;
import js.lang.NativeObject.PropertyDescriptor;
import js.ui.FormUIStyle.InputForm;
import js.ui.validator.Validator;
import js.util.ArrayList;

/**
 * @version 2013/04/03 11:47:12
 */
public class Input<T> extends FormUI {

    /** The associated model. */
    private Property<T> model;

    /**
     * <p>
     * Bindable {@link Input} form.
     * </p>
     */
    public Input(int model) {
    }

    /**
     * <p>
     * Bindable {@link Input} form.
     * </p>
     */
    public Input(String model) {
    }

    /**
     * <p>
     * Actual bindable {@link Input} form for all types.
     * </p>
     */
    @SuppressWarnings("unused")
    private Input(Object model, String name) {
        this.model = new Property((NativeObject) model, name);

        form.attr("type", "input").addClass(InputForm.class);
        form.bind(this);
    }

    @Listen(UIAction.KeyUp)
    private void validateInput() {
        String value = form.val();

        try {
            model.set(decode(value));
        } catch (Error e) {
            System.out.println("Error catch");
            System.out.println(e);
        }

    }

    /**
     * <p>
     * Decode value.
     * </p>
     * 
     * @param text
     * @return
     */
    protected T decode(String text) {
        return (T) text;
    }

    /**
     * <p>
     * Encode value.
     * </p>
     * 
     * @param value
     * @return
     */
    protected String encode(T value) {
        return value.toString();
    }

    protected boolean validate() {
        return true;
    }

    /**
     * @version 2013/04/09 15:49:55
     */
    private class Property<S> implements PropertyChangeListener<S>, PropertyDescriptor<S> {

        /** The associated model. */
        private final NativeObject model;

        /** The property name. */
        private final String name;

        /** The property validators. */
        private List<Validator> validators;

        /** The update flag. */
        private boolean whileUpdate = false;

        /**
         * @param model
         * @param name
         */
        private Property(NativeObject model, String name) {
            this.model = model;
            this.name = name;

            // define getter and setter method
            NativeObject descriptor = NativeObject.getOwnPropertyDescriptor(model, name);

            if (descriptor == null || descriptor.hasProperty("value")) {
                // store initial value
                model.setProperty("$" + name, model.getProperty(name));

                // create property listeners
                NativeObject.defineProperty(model, name, this);
            }

            // define property listeners holder
            List<PropertyChangeListener> listeners = model.getPropertyAs(List.class, "$$" + name);

            if (listeners == null) {
                listeners = new ArrayList();
                model.setProperty("$$" + name, listeners);
            }
            listeners.add(this);

            // initial binding
            change(model, name, null, get());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public S get() {
            return (S) model.getProperty("$" + name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void set(S value) {
            try {
                if (!whileUpdate) {
                    whileUpdate = true;

                    // restore old value
                    S old = get();
                    if ("aa".equals(value)) {
                        throw new Error("error desu");
                    }

                    if (old != value) {
                        // store new value
                        model.setProperty("$" + name, value);

                        // notify change event
                        List<PropertyChangeListener> listeners = model.getPropertyAs(List.class, "$$" + name);

                        for (PropertyChangeListener listener : listeners) {
                            listener.change(model, name, old, value);
                        }
                    }
                }
            } finally {
                whileUpdate = false;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void change(Object object, String propertyName, S oldValue, S newValue) {
            form.val(newValue);
        }
    }
}
