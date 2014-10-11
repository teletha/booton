/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.function.Predicate;

import javafx.beans.value.ObservableValue;

import kiss.Extensible;
import booton.css.CSS;

/**
 * @version 2014/10/10 22:40:50
 */
public class AppearanceDescriptor<W extends Widget> extends CSS implements Extensible {

    /** The target widget. */
    protected W widget;

    protected void defineRuntimeCondition(W widget, StyleDescriptor $) {
        // do nothing
    }

    /**
     * @version 2014/10/11 10:21:27
     */
    private static class StyleApply {

        /** The target. */
        private Widget target;

        /** The on style. */
        private Runnable on;

        /** The off style. */
        private Runnable off;
    }

    /**
     * @version 2014/10/11 10:10:00
     */
    public static class StyleDescriptor {

        /** The style definition. */
        private final StyleApply style;

        /**
         * @param style
         */
        private StyleDescriptor(StyleApply style) {
            this.style = style;
        }

        /**
         * @param onStyle
         * @return
         */
        public ConditionDescriptor apply(Runnable onStyle) {
            return apply(onStyle, null);
        }

        /**
         * @param onStyle
         * @param offStyle
         * @return
         */
        public ConditionDescriptor apply(Runnable onStyle, Runnable offStyle) {
            style.on = onStyle;
            style.off = offStyle;
            return new ConditionDescriptor(style);
        }

        /**
         * @param target
         * @param onStyle
         * @param offStyle
         * @return
         */
        public ConditionDescriptor apply(Widget target, Runnable onStyle, Runnable offStyle) {
            style.target = target;
            style.on = onStyle;
            style.off = offStyle;
            return new ConditionDescriptor(style);
        }
    }

    /**
     * @version 2014/10/11 10:11:05
     */
    public static class ConditionDescriptor {

        /** The style definition. */
        private final StyleApply style;

        /**
         * @param style
         */
        private ConditionDescriptor(StyleApply style) {
            this.style = style;
        }

        public <T> ValueCondition<T> when(ObservableValue<T> value) {
            return new ValueCondition();
        }
    }

    /**
     * @version 2014/10/11 10:14:56
     */
    public static class ValueCondition<T> {

        public void is(Predicate<T> condition) {

        }
    }
}
