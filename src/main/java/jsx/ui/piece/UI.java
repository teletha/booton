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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jsx.ui.Widget;
import kiss.I;

/**
 * @version 2015/10/09 15:28:40
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
     * Create {@link Checkbox} with the specified value.
     * </p>
     * 
     * @param value
     */
    public static final <T> CheckBox checkbox(SetProperty<T> group, T value, String label) {
        CheckBox box = new CheckBox(group, value, label);
        ((Widget) box).id = Objects.hash(value);

        return box;
    }

    /**
     * <p>
     * Create {@link RadioBox} with the specified value.
     * </p>
     * 
     * @param value
     */
    public static final <T> RadioBox<T> radiobox(Property<T> group, T value, String label) {
        RadioBox box = new RadioBox(group, value, label);
        ((Widget) box).id = Objects.hashCode(value);

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
