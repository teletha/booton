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

import booton.reactive.layout.Layout;

/**
 * @version 2014/09/10 14:02:07
 */
public class TodoLayout extends Layout<TodoWidget> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void width1024() {
        int imcompleted = w.incompletedSize.intValue();

        lay(w.input);
        lay($(imcompleted, imcompleted < 2 ? " item" : "items", " left"), $(w.all, w.active, w.completed));
    }
}
