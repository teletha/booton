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

import java.awt.Checkbox;
import java.util.Objects;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jsx.ui.Widget;
import kiss.I;

/**
 * @version 2015/03/06 14:08:04
 */
public class UI {

    /**
     * <p>
     * Create UI {@link Button}.
     * </p>
     * 
     * @return
     */
    public static final Button button() {
        return new Button();
    }

    /**
     * <p>
     * Create {@link Input} form field with empty value.
     * </p>
     */
    public static final Input input() {
        return input((StringProperty) null);
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public static final Input input(String value) {
        return input(new SimpleStringProperty(value));
    }

    /**
     * <p>
     * Create {@link Input} form field with the specified value.
     * </p>
     */
    public static final Input input(StringProperty value) {
        if (value == null) {
            value = new SimpleStringProperty();
        }
        return new Input(value);
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public static final Output output(String text) {
        return output(new SimpleStringProperty(text));
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public static final Output output(IntegerProperty value) {
        return new Output(value);
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public static final Output output(StringProperty text) {
        return new Output(text);
    }

    /**
     * <p>
     * Create {@link Checkbox} with the specified label.
     * </p>
     * 
     * @param label
     */
    public static final CheckBox checkbox(String label) {
        return checkbox(null, new SimpleStringProperty(label));
    }

    /**
     * <p>
     * Create {@link Checkbox} with the specified boolean value.
     * </p>
     * 
     * @param value
     */
    public static final CheckBox checkbox(BooleanProperty value) {
        return checkbox(value, null);
    }

    /**
     * <p>
     * Create {@link Checkbox} with the specified boolean value.
     * </p>
     * 
     * @param value
     */
    public static final CheckBox checkbox(BooleanProperty value, StringProperty label) {
        CheckBox box = new CheckBox(value, label);
        ((Widget) box).id = Objects.hash(value, label);

        return box;
    }

    /**
     * <p>
     * Create {@link Select} box with the specified values.
     * </p>
     * 
     * @param values
     */
    public static final <E extends Enum> Select<E> select(Class<E> enumClass) {
        ListProperty<E> items = I.make(ListProperty.class);

        for (Enum constant : enumClass.getEnumConstants()) {
            items.add((E) constant);
        }
        return select(items);
    }

    /**
     * <p>
     * Create {@link Select} box with the specified values.
     * </p>
     * 
     * @param values
     */
    public static final <M> Select<M> select(ListProperty<M> values) {
        return new Select(values);
    }
}
