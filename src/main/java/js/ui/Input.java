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
import java.util.Map;

import js.lang.NativeObject;
import js.lang.NativeObject.PropertyDescriptor;
import js.ui.FormUIStyle.BorderedUI;
import js.ui.FormUIStyle.Focus;
import js.ui.FormUIStyle.InputForm;
import js.ui.FormUIStyle.InvalidInputForm;
import js.ui.validator.IntegerValidator;
import js.ui.validator.Invalid;
import js.ui.validator.Validator;
import js.util.ArrayList;
import js.util.Converter;
import js.util.HashMap;

/**
 * @version 2013/04/03 11:47:12
 */
public class Input<T> extends FormUI {

    /** The built-in validators. */
    private static final Map<Class, Validator> builtins = new HashMap();

    static {
        builtins.put(Integer.class, new IntegerValidator());
    }

    /** The value type. */
    private Class<T> type;

    /** The associated model. */
    private Property<T> model;

    /** The validators. */
    private List<Validator> validators;

    /** The condition flag. */
    private boolean required = false;

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
    private Input(Class type, Object model, String name) {
        this.type = type;
        this.validators = new ArrayList();
        this.model = new Property((NativeObject) model, name);

        add(builtins.get(type));

        // create UI
        form.attr("type", "input").add(InputForm.class, BorderedUI.class);
        form.bind(this);

        // initial binding
        this.model.change(model, name, null, this.model.get());
    }



    /**
     * <p>
     * Validate the input value by user or API.
     * </p>
     */
    @Listen(UIAction.KeyUp)
    private void validateInput() {
        String input = form.val();

        if (input.length() == 0) {
            if (required) {
                form.add(InvalidInputForm.class);
            }
            return;
        }

        try {
            T value = Converter.convert(input, type);

            // validation
            for (Validator validator : validators) {
                validator.validate(value);
            }
            model.set(value);

            form.remove(InvalidInputForm.class);
        } catch (Invalid e) {
            form.add(InvalidInputForm.class);
        }
    }

    /**
     * <p>
     * Add value validator.
     * </p>
     * 
     * @param validator A value validator to use.
     */
    public void add(Validator<T> validator) {
        if (validator != null) {
            validators.add(validator);

            validateInput();
        }
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

            validateInput();
        }
    }
}
