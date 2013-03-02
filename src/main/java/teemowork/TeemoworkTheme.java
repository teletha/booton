/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import booton.css.CSS;
import booton.util.Font;

/**
 * @version 2012/12/15 22:13:17
 */
public class TeemoworkTheme {

    /** The main font. */
    Font Sans = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

    class HTML extends CSS {

        {
            font.family(Sans);
            padding.horizontal(10, percent).top(10, px);
        }
    }

    class Content extends CSS {

        {
            padding.top(20, px);
        }
    }
}
