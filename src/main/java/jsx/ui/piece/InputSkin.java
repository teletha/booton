/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import booton.css.value.Color;

/**
 * @version 2014/10/10 11:22:07
 */
public class InputSkin extends Skin<Input> {

    protected void define() {
        when(widget.value).is(v -> v.length() < 5, css -> {
            css.font.color(Color.rgb(40, 40, 250));
        });

        when(widget).isHover().style(css -> {
            css.font.color(Color.rgb(240, 40, 0));
        });
    }
}