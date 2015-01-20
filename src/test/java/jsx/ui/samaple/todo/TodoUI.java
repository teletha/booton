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

import static jsx.ui.FunctionHelper.*;
import static jsx.ui.samaple.todo.TodoUISkin.*;

import java.util.function.Predicate;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import jsx.ui.BindingHelper;
import jsx.ui.Key;
import jsx.ui.VirtualStructure;
import jsx.ui.Widget1;
import jsx.ui.piece.Button;
import jsx.ui.piece.CheckBox;
import jsx.ui.piece.Input;
import jsx.ui.piece.Output;
import jsx.ui.piece.UI;
import jsx.ui.samaple.todo.TodoTasks.Task;
import booton.reactive.css.DynamicStyle;

/**
 * @version 2014/09/01 15:14:06
 */
public class TodoUI extends Widget1<TodoTasks> {

    /** Reassign to meaningful name. */
    final TodoTasks todos = model1;

    /** The filter model. */
    final ObjectProperty<Filter> filter = new SimpleObjectProperty(Filter.All);

    /** The completed tasks. */
    final IntegerExpression completedSize = BindingHelper.filter(todos.list, Task::isCompleted).sizeProperty();

    /** The incompleted tasks. */
    final IntegerExpression incompletedSize = BindingHelper.filter(todos.list, not(Task::isCompleted)).sizeProperty();

    /** The selected filter style. */
    private final DynamicStyle<Filter> selectedFileter = new DynamicStyle(filter) {

        {
            // font.bold();
        }
    };

    /** The input field. */
    final Input input = UI.input()
            .disableIf(this::isValidTaskSize)
            .shortcut(Key.Enter, this::add)
            .require()
            .validate(v -> v.length() <= 15, "15文字以内でお願いします")
            .placeholder(() -> isValidTaskSize() ? "新しい要件" : "要件は10件まで");

    /** The filter button. */
    final Button all = UI.button()
            .label("all")
            .click(this::showAll)
            .styleIf(filter.isEqualTo(Filter.All), TodoUISkin.SELECTED_FILTER)
            .style(selectedFileter.is(Filter.All));

    /** The filter button. */
    final Button active = UI.button()
            .label("active")
            .click(this::showActive)
            .styleIf(filter.isEqualTo(Filter.Active), SELECTED_FILTER)
            .style(selectedFileter.is(Filter.Active));

    /** The filter button. */
    final Button completed = UI.button()
            .label("completed")
            .click(this::showCompleted)
            .styleIf(filter.isEqualTo(Filter.Completed), SELECTED_FILTER)
            .style(selectedFileter.is(Filter.Completed));

    /** The clear button. */
    final Button clear = UI.button()
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
    protected void virtualize(VirtualStructure 〡) {
        int size = incompletedSize.get();

        〡.〡(input);
        〡.vbox.〡(ITEMS, Item.class, todos.list);
        〡.hbox.〡(FOTTER, () -> {
            〡.〡(size + " " + (size < 2 ? "item" : "items") + " left");
            〡.hbox.〡(BUTTONS, all, active, completed);
            〡.〡(clear);
        });
    }

    /**
     * @version 2014/09/01 11:31:37
     */
    class Item extends Widget1<Task> {

        /** The edit mode. */
        final BooleanProperty editing = new SimpleBooleanProperty();

        /** The completion box. */
        final CheckBox complete = new CheckBox(model1.completed);

        /** The todo text. */
        final Output text = UI.output(model1.contents).dbclick(this::startEdit);

        /** The remove button. */
        final Button delete = UI.button().label("×").click($(todos.list::remove, model1));

        /** The editable todo text. */
        final Input edit = UI.input(model1.contents.get()).shortcut(Key.Enter, this::finishEdit);

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            if (filter.getValue().test(model1)) {
                if (editing.get()) {
                    $〡.〡(edit);
                } else {
                    $〡.hbox.〡(null, complete, text, delete);
                }
            }
        }

        /**
         * 
         */
        protected void startEdit() {
            System.out.println("start edit");
            editing.set(true);

            // ideal code
            // FadeTransition out = new FadeTransition(1sec);
            // out.setFromValue(1);
            // out.setToValue(0);
            // FadeTransition in = new FadeTransition(1sec);
            // in.setFromValue(0);
            // in.setToValue(1);
            // ParallelTransition pt = new ParallelTransition(rect, in, out);
            // pt.play();
        }

        /**
         * 
         */
        protected void finishEdit() {
            System.out.println("end edit");
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
        Active(not(Task::isCompleted)),

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
