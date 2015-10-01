/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import jsx.style.StyleDescriptor;
import jsx.ui.Style;

/**
 * @version 2015/09/30 23:57:58
 */
class EnhancedFormStyle extends StyleDescriptor {

    static Style FormBox = () -> {
        display.inlineBlock();
        position.relative();
    };
}
