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
import booton.reactive.css.Font;

/**
 * @version 2014/08/21 17:16:06
 */
public abstract class Piece<T extends Piece<T>> {

    protected final Font font = new Font();

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

    public T enableIf(ObservableValue<Boolean> enable) {
        return null;
    }

}
