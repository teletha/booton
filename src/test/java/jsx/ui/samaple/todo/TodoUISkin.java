/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.samaple.todo;

import jsx.style.Style;
import jsx.style.StyleRuleDescriptor;
import jsx.style.ValueStyle;
import jsx.ui.samaple.todo.TodoUI.Filter;

/**
 * @version 2014/10/27 9:49:27
 */
public class TodoUISkin extends StyleRuleDescriptor {

    static Style FOTTER = () -> {
        display.flex();
    };

    static Style ITEMS = () -> {
        display.verticalBox();
    };

    static Style BUTTONS = () -> {
        display.flex();
    };

    static Style CLEAR = () -> {

    };

    public static Style SELECTED_FILTER = () -> {
        font.weight.bold();
    };

    static ValueStyle<Filter> FILTER = filter -> {

    };
}
