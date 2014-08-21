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

import js.dom.UIEvent;
import kiss.Event;

/**
 * @version 2014/08/21 17:09:43
 */
public class Button extends Piece {

    protected Event<Boolean> press;

    protected Event<UIEvent> click;

    public void enable(boolean enable) {

    }
}
