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

import jsx.ui.TodoWidget.Item;
import jsx.ui.TodoWidget.Todo;

import org.junit.Test;

/**
 * @version 2014/09/01 19:42:57
 */
public class TodoWidgetTest {

    @Test
    public void add() throws Exception {
        TodoWidget w = new TodoWidget();
        assert w.todos.size() == 0;
        assert w.completedSize.get() == 0;
        assert w.incompletedSize.getValue().intValue() == 0;

        User.input(w.input, "text").willBe("text");
        User.input(w.input, Key.ENTER).willBeEmpty();

        assert w.todos.size() == 1;
        assert w.completedSize.get() == 0;
        assert w.incompletedSize.getValue().intValue() == 1;
        assert w.todos.get(0).contents.get().equals("text");
    }

    @Test
    public void remove() throws Exception {
        Todo todo = new Todo("now");
        TodoWidget w = new TodoWidget();
        w.todos.add(todo);
        assert w.todos.size() == 1;

        Item item = WidgetQuery.findFirst(w, Item.class);
        User.click(item.delete);
        assert w.todos.size() == 0;
    }
}
