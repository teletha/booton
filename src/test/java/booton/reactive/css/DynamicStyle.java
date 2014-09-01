/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.css;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.SingleSelectionModel;

/**
 * @version 2014/09/01 15:45:43
 */
public class DynamicStyle<T> {

    /**
     * @param filterType
     */
    public DynamicStyle(SingleSelectionModel<T> type) {
        this(type.selectedItemProperty());
    }

    /**
     * @param filterType
     */
    public DynamicStyle(ObservableValue<T> type) {
    }

    public ObservableValue<StyleDefinition> is(T value) {
        return null;
    }
}
