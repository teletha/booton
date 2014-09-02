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
 * @version 2014/09/02 11:20:28
 */
public class VirtualStructureLanguage {

    public void vbox(UI... pieces) {

    }

    public UI h(Object... pieces) {
        return null;
    }

    public UI h(Runnable children) {
        return null;
    }

    public <T> UI hbox(ObservableList<T> list, Consumer<T> builder) {
        return null;
    }

    public <T> UI vbox(ObservableList<T> list, Consumer<T> builder) {
        return null;
    }

    public <T> void list(ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass) {
        for (T item : list) {
            Widget<T> child = I.make(childWidgetClass);
            child.context = item;

            child.virtualize(this);
        }
    }

    public <T> void list(ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass, SingleSelectionModel<Predicate<T>> filter) {
        v(list, childWidgetClass, filter.selectedItemProperty());
    }

    public <T> void v(ObservableList<T> list, Class<? extends Widget<T>> childWidgetClass, ObservableValue<? extends Predicate<T>> filter) {
        for (T item : list) {
            Widget<T> child = I.make(childWidgetClass);
            child.context = item;

            child.virtualize(this);
        }
    }
}
