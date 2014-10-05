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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import js.dom.UIEvent;
import jsx.ui.LowLevelElement;
import jsx.ui.VirtualStructure;
import kiss.Events;
import kiss.I;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends LowLevelElement<Input> {

    /** The input value. */
    public final StringProperty value;

    /** The validation list. */
    private List<Validation> valids;

    /**
     * <p>
     * Create {@link Input} form field with empty value.
     * </p>
     */
    public Input() {
        this(new SimpleStringProperty(""));
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public Input(StringProperty value) {
        this.value = value;

        Events<UIEvent> functionInput = event().observe(Paste, Cut).debounce(50, MILLISECONDS);
        Events<UIEvent> keybordInput = event().observe(KeyUp);

        functionInput.merge(keybordInput).map(UIEvent::value).diff().to(value::set);
    }

    /**
     * 
     */
    public String clear() {
        String current = value.get();

        // clear value
        value.setValue("");

        // API definition
        return current;
    }

    /**
     * @param event
     * @param string
     * @return
     */
    public Input validate(Predicate<String> condition, String string) {
        validate(I.observe(value).map($(condition)), string);

        return this;
    }

    private <V> Function<V, Boolean> $(Predicate<V> predicate) {
        return v -> {
            return predicate.test(v);
        };
    }

    /**
     * @param event
     * @param message
     * @return
     */
    public Input validate(Events<Boolean> condition, String message) {
        if (valids == null) {
            valids = new ArrayList();
        }
        valids.add(new Validation(condition, message));

        return this;
    }

    /**
     * @param greaterThan
     * @param string
     * @return
     */
    public Input validate(ObservableValue<Boolean> event, String string) {
        return this;
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
     * Configure requirement.
     * 
     * @return
     */
    public Input require() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure $) {
        $.e("input", hashCode()).〡ª("type", "text").〡ª("value", value.get()).with(event());
    }
}
