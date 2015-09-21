/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import jsx.style.StyleDescriptor;
import jsx.ui.StructureDescriptor.Style;

/**
 * @version 2014/11/08 10:49:40
 */
class ScrollableListViewStyle extends StyleDescriptor {

    static Style ViewabletemView = () -> {
        display.block();
        position.relative();
        overflow.y.scroll();
        text.unselectable();
    };

    static Style RenderableItemView = () -> {
        display.block();
        overflow.hidden();
    };

    static Style Spacer = () -> {
        display.block();
    };

    static Style ItemColumnView = () -> {
        display.block();
    };
}
