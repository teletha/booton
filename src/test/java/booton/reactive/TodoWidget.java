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

import static booton.reactive.FunctionHelper.*;

import java.util.function.Predicate;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.Events;
import kiss.I;
import booton.reactive.TodoWidgetStyle.CLEAR;
import booton.reactive.TodoWidgetStyle.FOOTER;
import booton.reactive.TodoWidgetStyle.LIST;
import booton.reactive.css.DynamicStyle;
import booton.virtual.VirtualStructure;

/**
 * @version 2014/09/01 15:14:06
 */
public class TodoWidget extends Widget {

    /** The data model. */
    public final ListProperty<Todo> todos = I.make(ListProperty.class);

    /** The filter model. */
    public final Property<Filter> filter = new SimpleObjectProperty(Filter.All);

    /** The completed tasks. */
    final IntegerBinding completedSize = Bindings.size(log(todos).filtered(item -> item.completed.get()));

    /** The incompleted tasks. */
    final NumberBinding incompletedSize = todos.sizeProperty().subtract(completedSize);

    /** The todo size state. */
    private final Events<Boolean> exceedSize = I.observe(todos.sizeProperty().greaterThan(10));

    /** The selected filter style. */
    private final DynamicStyle<Filter> selectedFileter = new DynamicStyle(filter) {

        {
            // font.bold();
        }
    };

    private static <T> T log(T value) {
        System.out.println(value);

        return value;
    }

    /** The input field. */
    final Input input = new Input()
            .disableIf(exceedSize)
            .shortcut(Key.ENTER, this::add)
            .placeholder(exceedSize.map(v -> v ? "新しい要件を入力" : "要件は10件まで"));

    /** The filter button. */
    final Button all = new Button().label("all").click(this::showAll).style(selectedFileter.is(Filter.All));

    /** The filter button. */
    final Button active = new Button().label("active").click(this::showActive).style(selectedFileter.is(Filter.Active));

    /** The filter button. */
    final Button completed = new Button()
            .label("completed")
            .click(this::showCompleted)
            .style(selectedFileter.is(Filter.Completed));

    /** The clear button. */
    final Button clear = new Button()
            .label("clear completed (", completedSize, ")")
            .showIf(completedSize.greaterThan(0))
            .click(this::removeCompleted);

    /**
     * Add todo task.
     */
    private void add() {
        String value = input.value.get();

        if (value != null && value.length() != 0) {
            todos.add(new Todo(value));

            input.clear();
        }
    }

    /**
     * Remove todo task.
     */
    private void remove(Todo todo) {
        todos.remove(todo);
    }

    /**
     * Make complete all tasks.
     */
    private void makeAllComplete() {
        for (Todo todo : todos) {
            todo.completed.set(true);
        }
    }

    /**
     * Remove all completed tasks.
     */
    private void removeCompleted() {
        for (Todo todo : todos) {
            if (todo.completed.get()) {
                remove(todo);
            }
        }
    }

    /**
     * Show all items.
     */
    private void showAll() {
        filter.setValue(Filter.All);
    }

    /**
     * Show all items.
     */
    private void showActive() {
        filter.setValue(Filter.Active);
    }

    /**
     * Show all items.
     */
    private void showCompleted() {
        filter.setValue(Filter.Completed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure box) {
        int imcompleted = incompletedSize.intValue();

        box.h(input);
        box.h(LIST.class, todos, ShowLine.class, filter);
        box.h(FOOTER.class, () -> {
            box.h(imcompleted, imcompleted == 1 ? " item" : "items", " left");
            box.h(all, active, completed);
            box.h(CLEAR.class, clear);
        });
    }

    /**
     * @version 2014/09/01 11:31:37
     */
    class ShowLine extends Widget<Todo> {

        Output text = new Output(context.contents);

        Button delete = new Button().label("×").showIf(text.hover).click($(TodoWidget.this::remove, context));

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure box) {
            box.h(text, delete);
        }
    }

    /**
     * @version 2014/08/22 9:46:49
     */
    static class Todo {

        public final BooleanProperty completed = new SimpleBooleanProperty();

        public final StringProperty contents = new SimpleStringProperty();

        /**
         * 
         */
        public Todo(String value) {
            contents.set(value);
        }
    }

    /**
     * @version 2014/09/01 16:44:22
     */
    static enum Filter implements Predicate<Todo> {

        /** Accept any. */
        All(v -> true),

        /** Accept incompleted. */
        Active(v -> v.completed.get() == false),

        /** Accept completed. */
        Completed(v -> v.completed.get() == true);

        /** The condition expression. */
        private final Predicate<Todo> predicate;

        /**
         * @param predicate
         */
        private Filter(Predicate<Todo> predicate) {
            this.predicate = predicate;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean test(Todo t) {
            return predicate.test(t);
        }
    }
}
