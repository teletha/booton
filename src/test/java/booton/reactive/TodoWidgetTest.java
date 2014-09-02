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

import org.junit.Test;

import booton.reactive.TodoWidget.ShowLine;
import booton.reactive.TodoWidget.Todo;

/**
 * @version 2014/09/01 19:42:57
 */
public class TodoWidgetTest {

    @Test
    public void add() throws Exception {
        TodoWidget widget = new TodoWidget();
        assert widget.todos.size() == 0;
        assert widget.completedSize.get() == 0;
        assert widget.incompletedSize.getValue().intValue() == 0;

        User.input(widget.input, "text").willBe("text");
        User.input(widget.input, Key.ENTER).willBeEmpty();

        assert widget.todos.size() == 1;
        assert widget.completedSize.get() == 0;
        assert widget.incompletedSize.getValue().intValue() == 1;
        assert widget.todos.get(0).contents.get().equals("text");
    }

    @Test
    public void remove() throws Exception {
        Todo todo = new Todo("now");
        TodoWidget widget = new TodoWidget();
        widget.todos.add(todo);
        assert widget.todos.size() == 1;

        ShowLine line = Virtualizer.findFirst(widget, ShowLine.class);
        User.click(line.delete);
        assert widget.todos.size() == 0;
    }
}
