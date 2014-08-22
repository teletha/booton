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

import static booton.reactive.EventHelper.*;

import java.util.Comparator;
import java.util.function.Predicate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.Event;
import kiss.I;

/**
 * @version 2014/08/21 13:31:48
 */
public class TodoSample extends Reactive {

    public final ListProperty<Todo> todos = new SimpleListProperty();

    /** The input field. */
    Input input = new Input().placeholder("新しい要件を入力").require();

    /** The add button. */
    Button<Todo> add = new Button().label("追加")
            .enable(Event.all(input.value.is(NotEmpty), I.observe(todos.sizeProperty()).map(n -> n.intValue() < 10)));

    /** The todo output. */
    Output<Todo> todoInList = new Output<Todo>() {

        {
            // todos.size().isLessThan(10);
            input.value.value();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void style() {
            super.style();
        }
    };

    /**
     * @version 2014/08/22 11:32:30
     */
    private class TodoLine extends Output<Todo> {

        private final Todo todo;

        /**
         * @param todo
         */
        private TodoLine(Todo todo) {
            this.todo = todo;

            // style(todo.completed, css -> css.font);
        }
    }

    /** The delete button. */
    Button<String> delete = new Button<String>() {

        {
            click.to(e -> todos.remove(e.context));
        }
    };

    private final Property<Predicate<Todo>> isCompleted = new SimpleObjectProperty();

    private final Property<Comparator<Todo>> order = new SimpleObjectProperty();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void template() {
        hbox(input, add);

        // list(todos).filter(isCompleted).sort(order).
        vbox(todos, todo -> {
            check(todo.completed);
            output(todo.contents);
            button("削除");

            // hbox(new Check(todo), new TodoLine(todo));
            // check(todo.completed).output(todo.contents).button("削除");
        });
    }

    /**
     * @version 2014/08/22 9:46:49
     */
    private static class Todo {

        public BooleanProperty completed = new SimpleBooleanProperty();

        public StringProperty contents = new SimpleStringProperty();

        /**
         * @param value
         */
        public Todo(String value) {
            contents.set(value);
        }
    }
}
