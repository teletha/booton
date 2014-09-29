/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.samaple.todo;

import static booton.reactive.FunctionHelper.*;

import java.util.function.Predicate;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import jsx.ui.Button;
import jsx.ui.Input;
import jsx.ui.Key;
import jsx.ui.ModelModifier;
import jsx.ui.Output;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget1;
import jsx.ui.samaple.todo.TodoTasks.Task;
import jsx.ui.samaple.todo.TodoUIStyle.BUTTONS;
import jsx.ui.samaple.todo.TodoUIStyle.FOOTER;
import booton.reactive.css.DynamicStyle;

/**
 * @version 2014/09/01 15:14:06
 */
public class TodoUI extends Widget1<TodoTasks> {

    /** Reassign to meaningful name. */
    private final TodoTasks todos = model1;

    /** The filter model. */
    private final Property<Filter> filter = new SimpleObjectProperty(Filter.All);

    /** The completed tasks. */
    final IntegerBinding completedSize = Bindings.size(todos.list.filtered(Task::isCompleted));

    /** The incompleted tasks. */
    final IntegerBinding incompletedSize = Bindings.size(todos.list.filtered(not(Task::isCompleted)));

    /** The selected filter style. */
    private final DynamicStyle<Filter> selectedFileter = new DynamicStyle(filter) {

        {
            // font.bold();
        }
    };

    /** The input field. */
    final Input input = new Input()
            .disableIf(this::isValidTaskSize)
            .shortcut(Key.Enter, this::add)
            .click(() -> System.out.println("clicked"))
            .placeholder(() -> isValidTaskSize() ? "新しい要件" : "要件は10件まで");

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
            .click(todos::removeCompleted);

    /**
     * Add todo task.
     */
    private void add() {
        String value = input.value.get();

        if (value != null && value.length() != 0) {
            todos.list.add(new Task(value));

            input.clear();
        }
    }

    /**
     * @return
     */
    private boolean isValidTaskSize() {
        return todos.list.size() <= 10;
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
    protected void virtualize(VirtualStructure $〡) {
        int imcompleted = incompletedSize.get();

        $〡.asis.〡(input);
        $〡.vbox.〡(Item.class, todos.list);
        $〡.hbox.〡(FOOTER.class).〡(() -> {
            $〡.hbox.〡(imcompleted, imcompleted < 2 ? " item" : "items", " left");
            $〡.hbox.〡(BUTTONS.class).〡(all, active, completed);
            $〡.asis.〡(clear);
        });
    }

    /**
     * @version 2014/09/01 11:31:37
     */
    class Item extends Widget1<Task> {

        /** The edit mode. */
        private BooleanProperty editing = new SimpleBooleanProperty();

        /** The todo text. */
        Output text = new Output(model1.contents).hideIf(editing).dbclick(this::startEdit);

        /** The remove button. */
        Button delete = new Button().label("×").showIf(text.hover).click($(todos.list::remove, model1));

        /** The editable todo text. */
        Input edit = new Input(model1.contents).showIf(editing).shortcut(Key.Enter, this::finishEdit);

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.sbox.〡(text, delete);
            $〡.asis.〡(edit);
        }

        /**
         * 
         */
        @ModelModifier
        protected void startEdit() {
            editing.set(true);
        }

        /**
         * 
         */
        @ModelModifier
        protected void finishEdit() {
            editing.set(false);
            model1.contents.set(edit.value.get());
        }
    }

    /**
     * @version 2014/09/01 16:44:22
     */
    private static enum Filter implements Predicate<Task> {

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
