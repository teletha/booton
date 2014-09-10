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

import booton.reactive.UI;
import booton.reactive.layout.constant.Align;

/**
 * @version 2014/09/10 14:01:57
 */
public class Layout<T> {

    protected T w;

    protected final Align Top = new Align();

    protected final Align Tail = new Align();

    protected LayoutConstraint $(Object... values) {
        return new LayoutConstraint();
    }

    /**
     * 
     */
    protected void width1024() {

    }

    protected LayoutConstraint lay(UI item) {
        return new LayoutConstraint();
    }

    protected LayoutConstraint lay(LayoutConstraint item) {
        return new LayoutConstraint();
    }
}
