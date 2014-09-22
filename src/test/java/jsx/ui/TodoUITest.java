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

import jsx.ui.TodoUI.Item;
import jsx.ui.TodoUI.Todo;
import kiss.I;

import org.junit.Test;

/**
 * @version 2014/09/01 19:42:57
 */
public class TodoUITest {

    @Test
    public void add() throws Exception {
        TodoUI w = I.make(TodoUI.class);
        assert w.todos.size() == 0;
        assert w.completedSize.get() == 0;
        assert w.incompletedSize.get() == 0;

        User.input(w.input, "text", Key.ENTER).willBeEmpty();

        assert w.todos.size() == 1;
        assert w.completedSize.get() == 0;
        assert w.incompletedSize.get() == 1;
        assert w.todos.get(0).contents.get().equals("text");
    }

    @Test
    public void remove() throws Exception {
        TodoUI w = new TodoUI();
        w.todos.add(new Todo("now"));

        Item item = UIQuery.findFirst(w, Item.class);
        User.click(item.delete);
        assert w.todos.size() == 0;
    }
}
