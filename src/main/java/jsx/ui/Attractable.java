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

import javafx.beans.value.ObservableValue;

import kiss.I;

/**
 * @version 2014/10/12 15:31:15
 */
public interface Attractable<T> {

    default T apply(Runnable style) {
        return apply(style, null);
    }

    default T apply(Runnable onStyle, ObservableValue<Boolean> condition) {
        return apply(onStyle, null, condition);
    }

    default T apply(Runnable onStyle, Runnable offStyle, ObservableValue<Boolean> condition) {
        I.observe(condition).to(v -> {
            if (v) {

            }
        });

        return (T) this;
    }
}
