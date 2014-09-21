/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.versionable;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.I;

import org.junit.Test;

/**
 * @version 2014/09/21 14:11:18
 */
public class ListPropertyTest {

    /** The data model. */
    public final ListProperty<Todo> todos = I.make(ListProperty.class);

    /** The completed tasks. */
    final IntegerBinding completedSize = Bindings.size(todos.filtered(item -> item.completed.get()));

    /** The incompleted tasks. */
    final NumberBinding incompletedSize = todos.sizeProperty().subtract(completedSize);

    @Test
    public void testname() {

        completedSize.addListener((observable, oldV, newV) -> {
            System.out.println("completedSize ChangeListener");
            System.out.println(observable);
            System.out.println(oldV);
            System.out.println(newV);
        });

        incompletedSize.addListener((observable, oldV, newV) -> {
            System.out.println("incompletedSize ChangeListener");
            System.out.println(observable);
            System.out.println(oldV);
            System.out.println(newV);
        });

        Todo todo = new Todo("aaaa");
        todos.add(todo);

        System.out.println(completedSize);

        todo.completed.set(true);
    }

    /**
     * @version 2014/08/22 9:46:49
     */
    static class Todo {

        /** The completion flag. */
        public final BooleanProperty completed = new SimpleBooleanProperty();

        /** The todo contents. */
        public final StringProperty contents = new SimpleStringProperty();

        /**
         * 
         */
        public Todo(String value) {
            contents.set(value);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "Todo [completed=" + completed + ", contents=" + contents + "]";
        }
    }

}
