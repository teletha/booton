/*
 * Copyright (C) 2015 Nameless Production Committee
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
import static jsx.ui.piece.PieceStyle.*;

import java.util.function.Predicate;
import java.util.function.Supplier;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.ReadOnlySetProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import js.dom.UIEvent;
import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure;
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

    /** The placeholder value. */
    private Supplier<String> placeholder;

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    Input(StringProperty value) {
        this.value = value;

        // user input functionality
        Events<UIEvent> functionInput = on(Paste, Cut);
        Events<UIEvent> keybordInput = on(KeyUp);
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

        // API definition
        return current;
    }

    /**
     * Configure placeholder message.
     * 
     * @param message
     */
    public Input placeholder(String message) {
        return placeholder(new SimpleStringProperty(message));
    }

    /**
     * Configure placeholder message.
     * 
     * @param message
     */
    public Input placeholder(StringExpression message) {
        return placeholder(() -> message.get());
    }

    /**
     * Configure placeholder message.
     * 
     * @param message
     */
    public Input placeholder(Supplier<String> message) {
        this.placeholder = message;

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
    protected void virtualize(VirtualStructure 〡) {
        〡.e("input", InputForm, type -> "text", value -> value, placeholder -> placeholder);
    }
}
