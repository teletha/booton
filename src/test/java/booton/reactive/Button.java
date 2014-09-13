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

import jsx.ui.virtual.VirtualStructure;

/**
 * @version 2014/08/21 17:09:43
 */
public class Button extends UI<Button> {

    /**
     * @param string
     * @return
     */
    public Button label(Object... texts) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure box) {
    }
}
