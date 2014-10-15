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

import jsx.ui.AppearanceDescriptor;

/**
 * @version 2014/10/10 15:45:31
 */
public class TodoUISkin extends AppearanceDescriptor<TodoUI> {

    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // protected void defineRuntimeCondition(TodoUI widget, StyleDescriptor $) {
    // $.apply(this::items).when(widget.todos.list.sizeProperty()).is(v -> v.intValue() == 0);
    // }

    public void items() {
    }

    public void footer() {
        // font.color(rgb(40, 40, 250));
    }

    public void buttons() {

    }
}
