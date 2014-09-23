/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.function.Predicate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.I;

/**
 * @version 2014/09/22 13:49:09
 */
public class TodoTasks {

    /** The data model. */
    public final ListProperty<Task> list = I.make(ListProperty.class);

    /** The filter model. */
    public final Property<Filter> filter = new SimpleObjectProperty(Filter.All);

    /**
     * Make complete all tasks.
     */
    public void makeAllComplete() {
        for (Task todo : list) {
            todo.completed.set(true);
        }
    }

    /**
     * Remove all completed tasks.
     */
    public void removeCompleted() {
        list.removeIf(Task::isCompleted);
    }

    /**
     * Show all items.
     */
    public void showAll() {
        filter.setValue(Filter.All);
    }

    /**
     * Show all items.
     */
    public void showActive() {
        filter.setValue(Filter.Active);
    }

    /**
     * Show all items.
     */
    public void showCompleted() {
        filter.setValue(Filter.Completed);
    }

    /**
     * @version 2014/08/22 9:46:49
     */
    public static class Task {

        /** The completion flag. */
        public final BooleanProperty completed = new SimpleBooleanProperty();

        /** The todo contents. */
        public final StringProperty contents = new SimpleStringProperty();

        /**
         * 
         */
        public Task(String value) {
            contents.set(value);
        }

        /**
         * @param todo
         * @return
         */
        public static boolean isCompleted(Task todo) {
            return todo.completed.get();
        }
    }

    /**
     * @version 2014/09/01 16:44:22
     */
    public static enum Filter implements Predicate<Task> {

        /** Accept any. */
        All(v -> true),

        /** Accept incompleted. */
        Active(Task::isCompleted),

        /** Accept completed. */
        Completed(Task::isCompleted);

        /** The condition expression. */
        private final Predicate<Task> predicate;

        /**
         * @param predicate
         */
        private Filter(Predicate<Task> predicate) {
            this.predicate = predicate;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean test(Task t) {
            return predicate.test(t);
        }
    }
}