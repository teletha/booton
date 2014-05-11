/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import booton.css.CSS;
import booton.css.value.Font;

/**
 * @version 2013/03/24 16:34:23
 */
public class TeemoworkTheme {

    /** The main font. */
    public static final Font Main = new Font("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600");

    /** The header font. */
    public static final Font Header = Main;

    /** The title/heading font. */
    public static final Font Title = new Font("http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz");

    class HTML extends CSS {

        {
            font.family(Main).sansSerif();
            padding.horizontal(10, percent).top(10, px);
        }
    }

    class Content extends CSS {

        {
            padding.top(20, px);
        }
    }
}
