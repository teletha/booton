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
import java.util.function.Predicate;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.SingleSelectionModel;

import kiss.I;

/**
 * @version 2014/08/21 13:31:25
 */
public abstract class Widget<V> {

    protected V context;

    protected void vbox(UI... pieces) {

    }

    protected UI hbox(Object... pieces) {
        return null;
    }

    protected UI hbox(Runnable children) {
        return null;
    }

    protected <T> UI hbox(ObservableList<T> list, Consumer<T> builder) {
        return null;
    }

    protected <T> UI vbox(ObservableList<T> list, Consumer<T> builder) {
        return null;
    }

    protected <T> void list(ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass) {
        for (T item : list) {
            Widget<T> child = I.make(childWidgetClass);
            child.context = item;

            child.template();
        }
    }

    protected <T> void list(ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass, SingleSelectionModel<Predicate<T>> filter) {
        list(list, childWidgetClass, filter.selectedItemProperty());
    }

    protected <T> void list(ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass, ObservableValue<Predicate<T>> filter) {
        for (T item : list) {
            Widget<T> child = I.make(childWidgetClass);
            child.context = item;

            child.template();
        }
    }

    protected abstract void template();
}
