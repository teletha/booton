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

import java.util.function.Consumer;
import java.util.function.Predicate;

import javafx.beans.value.ObservableValue;

import jsx.ui.LowLevelWidget;
import booton.css.CSS;

/**
 * @version 2014/10/10 11:23:34
 */
public class Skin<W> {

    /** The target widget. */
    protected final W widget;

    /**
     * @param widget
     */
    protected Skin() {
        this.widget = null;
    }

    protected <T> ValueCondition<T> when(ObservableValue<T> value) {
        return new ValueCondition(value);
    }

    protected <T extends LowLevelWidget> WidgetCondition<T> when(LowLevelWidget widget) {
        return new WidgetCondition(widget);
    }

    /**
     * @version 2014/10/10 12:56:10
     */
    protected static class WidgetCondition<W extends LowLevelWidget> {

        /** The target widget. */
        private final W widget;

        /**
         * @param widget
         */
        private WidgetCondition(W widget) {
            this.widget = widget;
        }

        protected WidgetCondition<W> isHover() {
            return this;
        }

        protected void style(Consumer<CSS> definition) {

        }
    }

    /**
     * @version 2014/10/10 12:34:28
     */
    protected static class ValueCondition<T> {

        /** The target value. */
        private final ObservableValue<T> value;

        /**
         * @param value
         */
        private ValueCondition(ObservableValue<T> value) {
            this.value = value;
        }

        protected void is(Predicate<T> condition, Consumer<CSS> definition) {

        }
    }
}
