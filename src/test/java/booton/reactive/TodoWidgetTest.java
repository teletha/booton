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

/**
 * @version 2014/09/01 19:42:57
 */
public class TodoWidgetTest {

    @Test
    public void testname() throws Exception {
        TodoWidget widget = new TodoWidget();
        assert widget.todos.size() == 0;

        User.type(widget.input, "text");
        assert widget.input.value.get().equals("text");
        User.type(widget.input, Key.ENTER);
        assert widget.input.value.get().equals("");
    }
}
