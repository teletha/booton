/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.function.Consumer;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

import kiss.Events;
import booton.reactive.css.StyleDefinition;

/**
 * @version 2014/08/21 17:16:06
 */
public abstract class UI<T extends UI<T>> {

    protected static final <V> Events<V> If(Events<Boolean> condition, V trueValue, V falseValue) {
        return null;
    }

    protected BooleanProperty click;

    protected BooleanProperty hover;

    protected final BooleanProperty enable = new SimpleBooleanProperty();

    /**
     * Define style.
     */
    protected void style() {
    }

    public T click(Consumer<Events<UIEvent>> events) {
        return (T) this;
    }

    /**
     * @return
     */
    public T click(Runnable action) {
        return (T) this;
    }

    public T key(Consumer<Events<UIEvent>> events) {
        return (T) this;
    }

    public T key(Runnable action) {
        return (T) this;
    }

    public T shortcut(Key key, Runnable action) {
        return (T) this;
    }

    /**
     * @param event
     * @param string
     * @return
     */
    public T validate(Events<Boolean> event, String string) {
        return null;
    }

    /**
     * @param greaterThan
     * @param string
     * @return
     */
    public T validate(ObservableValue<Boolean> event, String string) {
        return null;
    }

    public T enableIf(ObservableValue<Boolean> condition) {
        return null;
    }

    public T enableIf(Events<Boolean> condition) {
        return null;
    }

    public T disableIf(ObservableValue<Boolean> condition) {
        return null;
    }

    public T disableIf(Events<Boolean> condition) {
        return null;
    }

    public T showIf(ObservableValue<Boolean> condition) {
        return null;
    }

    public T showIf(Events<Boolean> condition) {
        return null;
    }

    public T hideIf(ObservableValue<Boolean> condition) {
        return null;
    }

    public T hideIf(Events<Boolean> condition) {
        return null;
    }

    public T style(ObservableValue<StyleDefinition> style) {
        return (T) this;
    }
}
