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

import jsx.ui.samaple.todo.TodoUI.Item;

/**
 * @version 2014/10/19 9:54:28
 */
public class StylingUser {

    private TodoUISkin skin;

    private void aa() {
        Styling input = skin.input;
    }

    private void $(Runnable c) {

    }

    private void $(Object o, Runnable c) {

    }

    private void $(Object... a) {

    }

    private void defineConditionalStyle(TodoUI w) {
        $(w.input.value.length().lessThan(10), () -> {
            // STYLE
        });
    }

    private void layout(TodoUI w) {
        $(w.input);
        // STYLE
        // Invalid Style?
        // hover Style?
        // Invalid hover Style?
        // Focus Style?

        $(Item.class, w.todos.list);
        // STYLE

        $(() -> {
            // STYLE

            $(w.text);
            // STYLE

            $(() -> {
                // STYLE

                $(w.all);
                // STYLE

                $(w.active);
                // STYLE

                $(w.completed);
                // STYLE
            });

            $(w.clear);
            // STYLE
        });
    }
}
