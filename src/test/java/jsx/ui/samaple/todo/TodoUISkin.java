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

import jsx.style.StyleClass;
import jsx.style.StyleRuleDescriptor;

/**
 * @version 2014/10/27 9:49:27
 */
public class TodoUISkin extends StyleRuleDescriptor {

    static StyleClass FOTTER = () -> {

    };

    static StyleClass ITEMS = () -> {

    };

    static StyleClass BUTTONS = () -> {
        box.width(150, px);

        transit().duration(1, s).easeInOut().whenHover(() -> {
            box.width(300, px);
        });
    };

    static StyleClass CLEAR = () -> {

    };

    static StyleClass SELECTED_FILTER = () -> {

    };
}
