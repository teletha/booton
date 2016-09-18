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

import static jsx.ui.FunctionHelper.*;
import static jsx.ui.StructureDescriptor.*;

import java.util.function.Predicate;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

import booton.Necessary;
import jsx.style.StyleDescriptor;
import jsx.style.ValueStyle;
import jsx.ui.Key;
import jsx.ui.Style;
import jsx.ui.Widget1;
import jsx.ui.i18n.TextLocalizer;
import jsx.ui.piece.Button;
import jsx.ui.piece.CheckBox;
import jsx.ui.piece.Input;
import jsx.ui.piece.Output;
import jsx.ui.piece.UI;
import jsx.ui.samaple.todo.TodoTasks.Task;
import jsx.ui.samaple.todo.TodoUI.Styles;
import kiss.Extensible;
import kiss.I;

/**
 * @version 2015/10/05 2:01:04
 */
public class TodoUI extends Widget1<Styles, TodoTasks> {

    /** The localization. */
    final Text text = I.i18n(Text.class);

    /** Reassign to meaningful name. */
    final TodoTasks todos = model1;

    /** The filter model. */
    final ObjectProperty<Filter> filter = new SimpleObjectProperty(Filter.All);

    /** The input field. */
    final Input input = UI.input()
            .disableIf(this::isValidTaskSize)
            .shortcut(Key.Enter, this::add)
            .require()
            .invalidIf(input -> 15 < input.length(), "15文字以内でお願いします")
            .invalidIf(input -> isValidTaskSize(), "要件は10件まで")
            .placeholder(() -> isValidTaskSize() ? "新しい要件" : "要件は10件まで");

    /** The filter button. */
    final Button all = UI.button().label(text.selectAll()).click(this::showAll).styleIf(filter.isEqualTo(Filter.All), $.SELECTED_FILTER);

    /** The filter button. */
    final Button active = UI.button()
            .label(text.selectIncompleted())
            .click(this::showActive)
            .styleIf(filter.isEqualTo(Filter.Active), $.SELECTED_FILTER);

    /** The filter button. */
    final Button completed = UI.button()
            .label(text.selectCompleted())
            .click(this::showCompleted)
            .styleIf(filter.isEqualTo(Filter.Completed), $.SELECTED_FILTER);

    /** The clear button. */
    final Button clear = UI.button()
            .label(text.clearCompleted(todos.countCompleted()))
            // .showIf(todos.completedSize.greaterThan(0))
            .click(todos::removeCompleted);

    /**
     * Add todo task.
     */
    private void add() {
        String value = input.clear();

        if (value != null && value.length() != 0) {
            todos.list.add(new Task(value));
        }
    }

    /**
     * @return
     */
    private boolean isValidTaskSize() {
        return todos.list.size() <= 4;
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
    protected void virtualize() {
        widget(input);
        box($.ITEMS, contents(Item.class, todos.list));
        box($.FOTTER, () -> {
            text(text.leftTaskIs(todos.countIncompleted()));
            box($.BUTTONS, all, active, completed);
            widget(clear);
        });
    }

    /**
     * @version 2014/09/01 11:31:37
     */
    class Item extends Widget1<Styles, Task> {

        /** The edit mode. */
        final BooleanProperty editing = new SimpleBooleanProperty();

        /** The todo text. */
        final Output text = UI.output(model1.contents).dbclick(this::startEdit);

        /** The completion box. */
        final CheckBox complete = UI.checkbox(model1.completed, model1, model1.contents.get());

        /** The remove button. */
        final Button delete = UI.button().label("×").click($(todos.list::remove, model1));

        /** The editable todo text. */
        final Input edit = UI.input(model1.contents).shortcut(Key.Enter, this::finishEdit);

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            if (filter.getValue().test(model1)) {
                if (editing.get()) {
                    widget(edit);
                } else {
                    box($.HBox, () -> {
                        widget(complete);
                        widget(delete);
                    });
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
    static enum Filter implements Predicate<Task> {

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

    /**
     * @version 2015/06/10 10:08:11
     */
    @Necessary
    public static class Text extends TextLocalizer implements Extensible {

        /**
         * <p>
         * Label of the button which selects all items.
         * </p>
         * 
         * @return
         */
        public String selectAll() {
            return "All";
        }

        /**
         * <p>
         * Label of the button which selects all completed items.
         * </p>
         * 
         * @return
         */
        public String selectCompleted() {
            return "Complete";
        }

        /**
         * <p>
         * Label of the button which selects all completed items.
         * </p>
         * 
         * @return
         */
        public String selectIncompleted() {
            return "Active";
        }

        /**
         * @param size
         * @return
         */
        public String leftTaskIs(long size) {
            return $(size, " ", size < 2 ? "item" : "items", " left");
        }

        /**
         * <p>
         * LAbel of the button which clear all completed items.
         * </p>
         * 
         * @param size A number of completed items.
         * @return
         */
        public String clearCompleted(long size) {
            return $("Clear completed (", size, ")");
        }

        /**
         * @version 2015/06/09 12:11:53
         */
        @SuppressWarnings("unused")
        private static class Text_ja extends Text {

            /**
             * {@inheritDoc}
             */
            @Override
            public String selectAll() {
                return "全て";
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public String selectCompleted() {
                return "完了済み";
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public String selectIncompleted() {
                return "やるべきこと";
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public String leftTaskIs(long size) {
                return $("残りのタスク ", size);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public String clearCompleted(long size) {
                return $("完了済みタスク(", size, ")を消去");
            }
        }
    }

    /**
     * @version 2015/09/15 16:07:02
     */
    static class Styles extends StyleDescriptor {

        Style FOTTER = () -> {
            display.flex();
        };

        Style ITEMS = () -> {
            display.verticalBox();
        };

        Style BUTTONS = () -> {
            display.flex();
        };

        Style CLEAR = () -> {

        };

        Style SELECTED_FILTER = () -> {
            font.weight.bold();
        };

        ValueStyle<Filter> FILTER = filter -> {

        };
    }

}
