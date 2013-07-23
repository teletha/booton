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
import booton.css.Vendor;

/**
 * @version 2013/07/18 9:57:02
 */
public class FlexDirectionTest {

    @Test
    public void row() throws Exception {
        MyCSS css = new MyCSS();
        css.flexDirection.row();

        assert css.has("flex-direction", "row");
        assert css.has("-webkit-flex-direction", "row");
        assert css.has("-webkit-box-direction", "normal");
        assert css.has("-webkit-box-orient", "horizontal");
        assert css.has("-ms-flex-direction", "row");
        assert css.no(Vendor.Mozilla);
    }

    @Test
    public void rowReverse() throws Exception {
        MyCSS css = new MyCSS();
        css.flexDirection.rowReverse();

        assert css.has("flex-direction", "row-reverse");
        assert css.has("-webkit-flex-direction", "row-reverse");
        assert css.has("-webkit-box-direction", "reverse");
        assert css.has("-webkit-box-orient", "horizontal");
        assert css.has("-ms-flex-direction", "row-reverse");
        assert css.no(Vendor.Mozilla);
    }

    @Test
    public void colmun() throws Exception {
        MyCSS css = new MyCSS();
        css.flexDirection.column();

        assert css.has("flex-direction", "column");
        assert css.has("-webkit-flex-direction", "column");
        assert css.has("-webkit-box-direction", "normal");
        assert css.has("-webkit-box-orient", "vertical");
        assert css.has("-ms-flex-direction", "column");
        assert css.no(Vendor.Mozilla);
    }

    @Test
    public void colmunReverse() throws Exception {
        MyCSS css = new MyCSS();
        css.flexDirection.columnReverse();

        assert css.has("flex-direction", "column-reverse");
        assert css.has("-webkit-flex-direction", "column-reverse");
        assert css.has("-webkit-box-direction", "reverse");
        assert css.has("-webkit-box-orient", "vertical");
        assert css.has("-ms-flex-direction", "column-reverse");
        assert css.no(Vendor.Mozilla);
    }
}
