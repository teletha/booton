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

import js.dom.UIEvent;
import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure.ContainerDescriptor;
import kiss.Events;
import kiss.I;

/**
 * @version 2014/08/21 17:09:35
 */
public class Input extends LowLevelWidget<Input> {

    /** The input value. */
    public final StringProperty value;

    /** The validation list. */
    private List<Validation> validations;

    /** The validation list. */
    private List<Events<String>> valids;

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

        // user input functionality
        Events<UIEvent> functionInput = event().observe(Paste, Cut);
        Events<UIEvent> keybordInput = event().observe(KeyUp);

        functionInput.merge(keybordInput).debounce(100, MILLISECONDS).map(UIEvent::value).diff().to(value::set);

        // validation functionality
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

    private <V> Function<V, Boolean> $(Predicate<V> predicate) {
        return v -> {
            return predicate.test(v);
        };
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
     * @param event
     * @param message
     * @return
     */
    public Input validate(Predicate<String> condition, String message) {
        if (valids == null) {
            valids = new ArrayList();
        }
        valids.add(I.observe(value).filter(condition).map(message));

        return this;
    }

    public Events<List<String>> invalid() {
        return Events.join(valids);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isValid(UIEvent e) {
        if (validations != null) {
            for (Validation validation : validations) {
                if (!validation.condition.test(value.get())) {
                    return false;
                }
            }
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
    protected void virtualizeStructure(ContainerDescriptor descriptor) {
        descriptor.〡ª("type", "text").〡ª("value", value.get());
    }

    /**
     * @version 2014/10/06 9:35:44
     */
    private static class Validation {

        /** The validation condition. */
        private final Predicate<String> condition;

        /** The validation message. */
        private final String message;

        /**
         * @param validation
         * @param message
         */
        private Validation(Predicate<String> validation, String message) {
            this.condition = validation;
            this.message = message;
        }
    }

    /**
     * @version 2014/10/09 16:17:26
     */
    public static class Builder {

    }
}
