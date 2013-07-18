/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import org.junit.Test;

/**
 * @version 2013/07/18 16:09:15
 */
public class AlignItemsTest {

    @Test
    public void center() throws Exception {
        MyCSS css = new MyCSS();
        css.alignItems.center();

        assert css.has("align-items", "center");
        assert css.has("-webkit-align-items", "center");
        assert css.has("-moz-align-items", "center");
        assert css.has("-ms-flex-align", "center");
    }
}
