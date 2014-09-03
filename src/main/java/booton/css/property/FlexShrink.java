/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import booton.css.CSSProperty;

/**
 * @version 2014/09/03 23:48:27
 */
public class FlexShrink extends CSSProperty<FlexShrink> {

    /**
     * @param name
     */
    public FlexShrink() {
        super("flex-shrink");
    }

    public FlexShrink size(int size) {
        return chain(size);
    }
}
