/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.samaple.todo;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jsx.ui.BindingHelper;
import kiss.I;

/**
 * @version 2015/09/24 16:56:51
 */
public class TodoTasks {

    /** The data model. */
    public final ListProperty<Task> list = I.make(ListProperty.class);

    /**
     * 
     */
    public TodoTasks() {
        list.add(new Task("Test1"));
        list.add(new Task("Test2"));

        Task task = new Task("Test3");
        task.completed.set(true);
        list.add(task);
    }

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
     * <p>
     * Count a number of completed items.
     * </p>
     * 
     * @return
     */
    public long countCompleted() {
        int counter = 0;

        for (Task task : list) {
            if (task.completed.get()) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * <p>
     * Count a number of incompleted items.
     * </p>
     * 
     * @return
     */
    public long countIncompleted() {
        return list.size() - countCompleted();
    }

    /**
     * @version 2015/09/24 16:56:45
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
}
