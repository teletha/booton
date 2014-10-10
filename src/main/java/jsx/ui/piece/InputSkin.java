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

/**
 * @version 2014/10/10 11:22:07
 */
public class InputSkin extends Snazz<Input> {

    {
        when(widget).style(this::widget);
        when(widget.value).is(v -> v.length() < 5).style(this::invalid);
    }

    /**
     * Widget appearance.
     */
    public void widget() {
        font.color(rgb(240, 40, 0));

        hover(() -> {
            font.color(rgb(240, 240, 0));
        });
    }

    /**
     * Invalid input value warning.
     */
    public void invalid() {
        font.color(rgb(40, 40, 250));
    }
}
