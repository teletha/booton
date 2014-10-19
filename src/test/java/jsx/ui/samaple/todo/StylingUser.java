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

import jsx.ui.piece.Input;
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

    private void $(Object o, Object v, Runnable c) {

    }

    private TodoUI w;

    private void nestVersion(Input intput) {
        $(w.input, () -> {
            // STYLE
        });

        $(Item.class, w.todos.list, () -> {
            // STYLE
        });

        $(() -> {
            $(w.text, () -> {
                // STYLE
            });

            $(() -> {
                $(w.all, () -> {
                    // STYLE
                });

                $(w.active, () -> {
                    // STYLE
                });

                $(w.completed, () -> {
                    // STYLE
                });

                // STYLE
            });

            $(w.clear, () -> {
                // STYLE
            });
        });
    }

    private void $(Object... a) {

    }

    private void flatVersion(TodoUI w) {
        $(w.input);
        // STYLE
        // Invalid Style?
        // hover Style?
        // Invalid hover Style?
        // Focus Style?
        $(w.input.value.length().lessThan(10), () -> {

        });

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
