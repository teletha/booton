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
 * @version 2013/07/18 9:57:02
 */
public class FlexDirectionTest {

    @Test
    public void flexDirection() throws Exception {
        MyCSS css = new MyCSS();
        css.flexDirection.column();

        assert css.has("flex-direction", "column");
        assert css.has("-webkit-flex-direction", "column");
        assert css.has("-ms-flex-direction", "column");
        assert css.omit("-moz-flex-direction");
    }
}
