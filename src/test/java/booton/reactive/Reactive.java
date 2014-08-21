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

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

import booton.reactive.css.Font;

/**
 * @version 2014/08/21 13:31:25
 */
public abstract class Reactive {

    protected void hbox(Piece... pieces) {

    }

    protected void text(Object... texts) {
        if (texts == null) {
            return;
        }

        for (Object text : texts) {
            if (text instanceof ObservableValue) {

            }
        }
    }

    protected abstract void template();

    /**
     * @version 2014/08/21 13:36:52
     */
    public static class Variable<T> extends SimpleObjectProperty<T> {

        protected final Font font = new Font();

        /**
         * Define style.
         */
        protected void style() {
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return String.valueOf(get());
        }
    }
}
