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

import static booton.css.Vendor.*;

import org.junit.Test;

import booton.css.MyCSS;

/**
 * @version 2013/07/22 11:34:43
 */
public class FlexWrapTest {

    @Test
    public void noWrap() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().wrap.disable();

        assert css.has("flex-wrap", "nowrap");
        assert css.has("-webkit-flex-wrap", "nowrap");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void wrap() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().wrap.enable();

        assert css.has("flex-wrap", "wrap");
        assert css.has("-webkit-flex-wrap", "wrap");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void wrapReverse() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().wrap.reverse();

        assert css.has("flex-wrap", "wrap-reverse");
        assert css.has("-webkit-flex-wrap", "wrap-reverse");
        assert css.no(Mozilla, IE);
    }
}
