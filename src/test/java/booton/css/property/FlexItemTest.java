/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import static booton.css.Unit.*;
import static booton.css.Vendor.*;

import org.junit.Test;

import booton.css.MyCSS;

/**
 * @version 2014/09/04 10:23:36
 */
public class FlexItemTest {

    @Test
    public void basis() throws Exception {
        MyCSS css = new MyCSS();
        css.flexItem.basis(10, px);

        assert css.has("flex-basis", "10px");
        assert css.has("-webkit-flex-basis", "10px");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void grow() throws Exception {
        MyCSS css = new MyCSS();
        css.flexItem.grow(2);

        assert css.has("flex-grow", "2");
        assert css.has("-webkit-flex-grow", "2");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void shrink() throws Exception {
        MyCSS css = new MyCSS();
        css.flexItem.shrink(2);

        assert css.has("flex-shrink", "2");
        assert css.has("-webkit-flex-shrink", "2");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void order() throws Exception {
        MyCSS css = new MyCSS();
        css.flexItem.order(2);

        assert css.has("order", "2");
        assert css.has("-webkit-order", "2");
        assert css.no(Mozilla, IE);
    }
}
