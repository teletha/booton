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
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.Events;
import kiss.I;
import booton.reactive.css.DynamicStyle;

/**
 * @version 2014/09/01 15:14:06
 */
public class TodoWidget extends Widget {

    /** The data model. */
    public final ListProperty<Todo> todos = new SimpleListProperty();

    /** The filter model. */
    public final Property<Filter> filter = new SimpleObjectProperty(Filter.All);

    /** The completed tasks. */
    private final IntegerBinding completedSize = Bindings.size(todos.filtered(item -> item.completed.get()));

    /** The incompleted tasks. */
    private final NumberBinding incompletedSize = todos.sizeProperty().subtract(completedSize);

    /** The todo size state. */
    private final Events<Boolean> exceedSize = I.observe(todos.sizeProperty().greaterThan(10));

    /** The selected filter style. */
    private final DynamicStyle<Filter> selectedFileter = new DynamicStyle(filter) {

        {
            // font.bold();
        }
    };

    /** The input field. */
    final Input input = new Input()
            .disableIf(exceedSize)
            .placeholder(exceedSize.map(v -> v ? "新しい要件を入力" : "要件は10件まで"))
            .shortcut(Key.ENTER, this::add);

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
    void add() {
        String value = input.value.get();

        if (value != null && value.length() != 0) {
            todos.add(new Todo(value));

            input.clear();
            System.out.println("invoked");
        }
    }

    /**
     * Remove todo task.
     */
    void remove(Todo todo) {
        todos.remove(todo);
    }

    /**
     * Make complete all tasks.
     */
    void makeAllComplete() {
        for (Todo todo : todos) {
            todo.completed.set(true);
        }
    }

    /**
     * Remove all completed tasks.
     */
    void removeCompleted() {
        for (Todo todo : todos) {
            if (todo.completed.get()) {
                remove(todo);
            }
        }
    }

    /**
     * Show all items.
     */
    void showAll() {
        filter.setValue(Filter.All);
    }

    /**
     * Show all items.
     */
    void showActive() {
        filter.setValue(Filter.Active);
    }

    /**
     * Show all items.
     */
    void showCompleted() {
        filter.setValue(Filter.Completed);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void template() {
        int imcompleted = incompletedSize.intValue();

        hbox(input);
        list(todos, ShowLine.class, filter);
        hbox(() -> {
            hbox(imcompleted, imcompleted == 1 ? " item" : "items", " left");
            hbox(all, active, completed);
            hbox(clear);
        });
    }

    /**
     * @version 2014/09/01 11:31:37
     */
    private class ShowLine extends Widget<Todo> {

        private Output text = new Output(context.contents);

        private Button delete = new Button().label("×").showIf(text.hover).click($(TodoWidget.this::remove, context));

        /**
         * {@inheritDoc}
         */
        @Override
        protected void template() {
            hbox(text, delete);
        }
    }

    /**
     * @version 2014/08/22 9:46:49
     */
    private static class Todo {

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
    private static enum Filter implements Predicate<Todo> {

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
