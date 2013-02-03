/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.awt;

import booton.css.CSS;

/**
 * @version 2013/02/03 14:55:32
 */
public class Widget {

    public Text text(Class<? extends CSS> style) {
        return text(style, "");
    }

    public Text text(String text) {
        return text(null, text);
    }

    public Text text(Class<? extends CSS> style, String text) {
        return null;
    }
}
