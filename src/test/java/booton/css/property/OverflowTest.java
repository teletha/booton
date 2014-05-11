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

import booton.css.MyCSS;

/**
 * @version 2013/07/24 13:46:07
 */
public class OverflowTest {

    @Test
    public void normal() throws Exception {
        MyCSS css = new MyCSS();
        css.overflow.hidden();

        assert css.has("overflow", "hidden");
        assert css.countProperty() == 1;
    }

    @Test
    public void x() throws Exception {
        MyCSS css = new MyCSS();
        css.overflow.x.scroll();

        assert css.has("overflow-x", "scroll");
        assert css.countProperty() == 1;
    }

    @Test
    public void y() throws Exception {
        MyCSS css = new MyCSS();
        css.overflow.y.visible();

        assert css.has("overflow-y", "visible");
        assert css.countProperty() == 1;
    }

    @Test
    public void xy() throws Exception {
        MyCSS css = new MyCSS();
        css.overflow.x.auto().y.hidden();

        assert css.has("overflow-x", "auto");
        assert css.has("overflow-y", "hidden");
        assert css.countProperty() == 2;
    }
}
