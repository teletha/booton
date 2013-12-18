/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom.event;

import jsx.event.Key;
import jsx.event.KeyDetectable;

/**
 * @version 2013/12/18 15:00:50
 */
public class KeyPress extends AbstractUIEvent implements KeyDetectable {

    /**
     * {@inheritDoc}
     */
    @Override
    public Key getKey() {
        return Key.find(delegator.which);
    }
}
