/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import jsx.style.StyleClass;
import jsx.style.StyleRuleDescriptor;

/**
 * @version 2014/11/08 10:49:40
 */
class ScrollableListViewStyle extends StyleRuleDescriptor {

    static StyleClass ViewabletemView = () -> {
        display.block();
        position.relative();
        overflow.y.scroll();
        text.unselectable();
    };

    static StyleClass RenderableItemView = () -> {
        display.block();
        overflow.hidden();
    };

    static StyleClass Spacer = () -> {
        display.block();
    };

    static StyleClass ItemColumnView = () -> {
        display.block();
    };
}
