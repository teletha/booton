/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.samaple.todo;

import org.junit.Ignore;
import org.junit.Test;

import jsx.ui.Key;
import jsx.ui.UserBot;
import jsx.ui.WidgetQuery;
import jsx.ui.samaple.todo.TodoTasks.Task;
import jsx.ui.samaple.todo.TodoUI.Item;

/**
 * @version 2015/10/05 2:01:14
 */
public class TodoUITest {

    @Test
    @Ignore
    public void add() throws Exception {
        TodoTasks todos = new TodoTasks();

        TodoUI w = new TodoUI(todos);
        assert todos.list.size() == 0;
        assert w.todos.countCompleted() == 0;
        assert w.todos.countIncompleted() == 0;

        UserBot.input(w.input, "text", Key.Enter).willBeEmpty();

        assert todos.list.size() == 1;
        assert w.todos.countCompleted() == 0;
        assert w.todos.countIncompleted() == 1;
        assert todos.list.get(0).contents.get().equals("text");
    }

    @Test
    @Ignore
    public void remove() throws Exception {
        TodoTasks todos = new TodoTasks();
        todos.list.add(new Task("now"));

        TodoUI w = new TodoUI(todos);
        Item item = WidgetQuery.findFirst(w, Item.class);

        UserBot.click(item.delete);
        assert todos.list.size() == 0;

        UserBot.click(w.input);
    }
}
