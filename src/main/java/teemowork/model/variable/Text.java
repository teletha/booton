/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model.variable;

import java.util.ArrayList;
import java.util.List;

import jsx.jQuery;

/**
 * @version 2013/03/05 14:15:36
 */
public class Text implements HTMLizable {

    /** The token list. */
    private final List tokens = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    public void toDOM(jQuery root) {

    }
}
