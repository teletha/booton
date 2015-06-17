/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.function.Predicate;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.transformation.FilteredList;

/**
 * @version 2014/10/02 12:40:07
 */
public class BindingHelper {

    /**
     * @param list
     * @param object
     * @return
     */
    public static <T> ListProperty<T> filter(ListProperty<T> list, Predicate<T> filter) {
        FilteredList<T> filtered = list.filtered(filter);
        ModelInspector<T> inspector = new ModelInspector(filtered);

        list.addListener(inspector);

        for (T item : list) {
            inspector.inspect(item);
        }
        return new SimpleListProperty(filtered);
    }
}
