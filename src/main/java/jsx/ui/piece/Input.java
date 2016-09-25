/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static java.util.concurrent.TimeUnit.*;
import static js.dom.User.*;
import static jsx.ui.FunctionHelper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import js.dom.UIEvent;
import jsx.style.StyleDSL;
import jsx.ui.LowLevelWidget;
import jsx.ui.StructureDSL;
import jsx.ui.Widget;
import jsx.ui.Widget1;
import jsx.ui.Widget2;
import kiss.Events;
import kiss.I;

/**
 * @version 2016/09/15 8:42:32
 */
public class Input extends LowLevelWidget<PieceStyle, Input> {

    /** The current input value. */
    public final StringProperty value;

    /** The valid property. */
    public final Events<Boolean> valid;

    /** The invalid property. */
    public final Events<Boolean> invalid;

    /** The managed validation. */
    private List<Validation> validations;

    /** The placeholder value. */
    private Supplier<String> placeholder;

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    Input(StringProperty value) {
        this.value = value;
        this.valid = I.observe(value).map(input -> validate(input)).startWith(true);
        this.invalid = I.observe(value).map(input -> !validate(input)).startWith(false);

        // user input functionality
        when(KeyUp, Cut, Paste).at($.SingleLineFormBase).debounce(100, MILLISECONDS).map(UIEvent::value).diff().to(update(value::set));

        disableIf(invalid);
    }

    private boolean validate(String input) {
        if (validations == null) {
            return true;
        }

        for (Validation validation : validations) {
            if (validation.condition.test(input)) {
                return false;
            }
        }
        return true;
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
        return invalidIf(NotEmpty, "The input value is empty.");
    }

    /**
     * <p>
     * Declare the invalid condition and error message.
     * </p>
     * 
     * @param condition A necessary condition of the input value.
     * @param message A message when the input value doesn't fulfill.
     * @return Chainable API.
     */
    public Input invalidIf(Predicate<String> condition, String message) {
        return invalidIf(condition, value -> message);
    }

    /**
     * <p>
     * Declare the invalid condition and error message.
     * </p>
     * 
     * @param condition
     * @param message
     * @return
     */
    public Input invalidIf(Predicate<String> condition, Function<String, String> message) {
        return invalidWhen(condition, input -> Widget.of(InvalidMassage.class, input, message));
    }

    /**
     * <p>
     * Declare the invalid condition and error message.
     * </p>
     * 
     * @param condition
     * @param message
     * @return
     */
    public Input invalidIf(Predicate<String> condition, Class<? extends Widget1<StyleDSL, String>> message) {
        return invalidWhen(condition, input -> {
            return Widget.of(message, input);
        });
    }

    /**
     * <p>
     * Declare the invalid condition and error message.
     * </p>
     * 
     * @param condition
     * @param message
     * @return
     */
    private Input invalidWhen(Predicate<String> condition, Function<String, Widget> message) {
        if (validations == null) {
            validations = new ArrayList();
        }

        validations.add(new Validation(condition, message));

        // API definition
        return this;
    }

    /**
     * @version 2016/09/25 13:58:55
     */
    private class View extends StructureDSL {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            html("input", WidgetRoot, $.SingleLineFormBase, userStyle, attr("type", "text"), attr("value", value), attr("placeholder", placeholder));
        }
    }

    /**
     * @version 2015/10/21 15:00:43
     */
    private static class Validation {

        /** The condition. */
        private final Predicate<String> condition;

        /** The erro message. */
        private final Function<String, Widget> message;

        /**
         * @param condition
         * @param message
         */
        private Validation(Predicate<String> condition, Function<String, Widget> message) {
            this.condition = condition;
            this.message = message;
        }
    }

    /**
     * @version 2015/10/21 13:40:36
     */
    private static class InvalidMassage<C> extends Widget2<StyleDSL, String, Function<String, String>> {

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            /**
             * {@inheritDoc}
             */
            @Override
            protected void virtualize() {
                text(model2.apply(model1));
            }
        }
    }
}
