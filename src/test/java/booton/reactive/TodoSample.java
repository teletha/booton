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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @version 2014/08/21 13:31:48
 */
public class TodoSample extends Reactive {

    /** The data model. */
    public final ListProperty<Todo> todos = new SimpleListProperty();

    /** The input field. */
    Input input = new Input() {

        {
            placeholder("新しい要件を入力").validate(input.value.is(Empty), "要件を入力してください");
        }
    };

    /** The add button. */
    Button<Todo> add = new Button<Todo>().label("追加")
            .dependOn(input)
            .validate(todos.sizeProperty().greaterThan(9), "要件は10件まで")
            .click(() -> todos.add(new Todo(input.value.value())));

    Button addon = new Button() {

        {
            add.click.to(e -> todos.add(new Todo(input.value.value())));
            // add.run(this::add).onclick();
        }

        // @On(UIAction.Click)
        private void add() {
            todos.add(new Todo(input.value.value()));
        }
    };

    // private final Property<Predicate<Todo>> isCompleted = new SimpleObjectProperty();
    //
    // private final Property<Comparator<Todo>> order = new SimpleObjectProperty();

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
