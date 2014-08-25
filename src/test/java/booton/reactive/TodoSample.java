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

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.I;

/**
 * @version 2014/08/21 13:31:48
 */
public class TodoSample extends Reactive {

    /** The data model. */
    public final ListProperty<Todo> todos = new SimpleListProperty();

    /** The input field. */
    Input input = new Input() {

        {
            Bindings.when(todos.sizeProperty().greaterThan(9)).then("新しい要件を入力").otherwise("要件は10件まで");

            placeholder(I.observe(todos.sizeProperty()).map(v -> v.intValue() < 10 ? "新しい要件を入力" : "要件は10件まで"));

            I.observe(todos.sizeProperty()).to(size -> {
                if (size.intValue() < 10) {
                    enable.set(true);
                    placeholder("新しい要件を入力");
                } else {
                    enable.set(false);
                    placeholder("要件は10件まで");
                }
            });
        }
    };

    /** The add button. */
    Button<Todo> add = new Button<Todo>().label("追加")
            .enableIf(input.enable)
            .validate(input.value.isEmpty(), "要件を入力してください")
            .validate(todos.sizeProperty().greaterThan(9), "要件は10件まで")
            .click(() -> todos.add(new Todo(input.value.get())));

    Button addon = new Button() {

        {
            add.click.to(e -> todos.add(new Todo(input.value.get())));
            // add.run(this::add).onclick();
        }

        // @On(UIAction.Click)
        private void add() {
            todos.add(new Todo(input.value.get()));
        }
    };

    javafx.scene.control.Button button = new javafx.scene.control.Button() {

        {
            disableProperty().bind(input.enable);
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
