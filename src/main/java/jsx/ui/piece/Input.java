/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static java.util.concurrent.TimeUnit.*;
import static js.dom.UIAction.*;
import static jsx.ui.FunctionHelper.*;

import java.util.function.Predicate;
import java.util.function.Supplier;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlySetProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import js.dom.UIEvent;
import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure.ContainerDescriptor;
import kiss.Events;
import kiss.I;

/**
 * @version 2014/10/10 8:42:34
 */
public class Input extends LowLevelWidget<Input> {

    /** The current input value. */
    public final StringProperty value;

    /** The input value validity. */
    public final ReadOnlySetProperty<String> invalid = I.make(SetProperty.class);

    /**
     * <p>
     * Create {@link Input} form field with empty value.
     * </p>
     */
    public Input() {
        this("");
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public Input(String value) {
        this(new SimpleStringProperty(value));
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public Input(StringProperty value) {
        this.value = value;

        // user input functionality
        Events<UIEvent> functionInput = event().observe(Paste, Cut);
        Events<UIEvent> keybordInput = event().observe(KeyUp);
        functionInput.merge(keybordInput).debounce(100, MILLISECONDS).map(UIEvent::value).diff().to(value::set);
    }

    /**
     * <p>
     * Clear the current input value.
     * </p>
     * 
     * @return The current input value.
     */
    public String clear() {
        String current = value.get();

        // clear value
        value.setValue("");

        System.out.println("clear input");

        // API definition
        return current;
    }

    /**
     * Configure placeholder string.
     * 
     * @param string
     */
    public Input placeholder(String string) {
        return this;
    }

    /**
     * Configure placeholder string.
     * 
     * @param string
     */
    public Input placeholder(Supplier<String> string) {
        return this;
    }

    public Input placeholder(StringExpression value) {
        return this;
    }

    /**
     * <p>
     * Validate that the input value must not be empty.
     * </p>
     * 
     * @return Chainable API.
     */
    public Input require() {
        return validate(NotEmpty, "The input value is empty.");
    }

    /**
     * <p>
     * Validate the input value.
     * </p>
     * 
     * @param prerequisite A necessary condition of the input value.
     * @param message A message when the input value doesn't fulfill.
     * @return Chainable API.
     */
    public Input validate(Predicate<String> prerequisite, String message) {
        disposeLater(I.observe(value).to(input -> {
            if (prerequisite.test(input)) {
                invalid.remove(message);
            } else {
                invalid.add(message);
            }
        }));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isValid(UIEvent e) {
        if (!invalid.isEmpty()) {
            return false;
        }
        return super.isValid(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String virtualizeName() {
        return "input";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeStructure(ContainerDescriptor $〡) {
        System.out.println("virtualize input " + value);
        $〡.〡ª("type", "text").〡ª("value", value.get());
    }
}
