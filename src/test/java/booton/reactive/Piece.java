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

import booton.reactive.css.Font;

/**
 * @version 2014/08/21 17:16:06
 */
public abstract class Piece {

    protected final Font font = new Font();

    /**
     * Define style.
     */
    protected void style() {
    }

}
