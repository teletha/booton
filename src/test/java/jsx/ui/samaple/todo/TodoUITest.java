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

import jsx.ui.Key;
import jsx.ui.User;
import jsx.ui.Widget;
import jsx.ui.WidgetQuery;
import jsx.ui.samaple.todo.TodoTasks.Task;
import jsx.ui.samaple.todo.TodoUI.Item;

import org.junit.Test;

/**
 * @version 2014/09/01 19:42:57
 */
public class TodoUITest {

    @Test
    public void add() throws Exception {
        TodoTasks todos = new TodoTasks();

        TodoUI w = Widget.of(TodoUI.class, todos);
        assert todos.list.size() == 0;
        assert w.completedSize.get() == 0;
        assert w.incompletedSize.get() == 0;

        User.input(w.input, "text", Key.ENTER).willBeEmpty();

        assert todos.list.size() == 1;
        assert w.completedSize.get() == 0;
        assert w.incompletedSize.get() == 1;
        assert todos.list.get(0).contents.get().equals("text");
    }

    @Test
    public void remove() throws Exception {
        TodoTasks todos = new TodoTasks();
        todos.list.add(new Task("now"));

        TodoUI w = Widget.of(TodoUI.class, todos);
        Item item = WidgetQuery.findFirst(w, Item.class);

        User.click(item.delete);
        assert todos.list.size() == 0;
    }
}
