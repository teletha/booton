/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.layout;

import booton.reactive.layout.constant.Align;

/**
 * @version 2014/09/10 14:16:56
 */
public class LayoutConstraint {

    public LayoutConstraint minWidth(int percentage) {
        return this;
    }

    public LayoutConstraint align(Align align) {
        return this;
    }

    public LayoutConstraint align(Align align, Align horizontal) {
        return this;
    }
}
