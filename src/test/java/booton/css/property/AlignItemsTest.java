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
 * @version 2013/07/22 11:27:19
 */
public class AlignItemsTest {

    @Test
    public void start() throws Exception {
        MyCSS css = new MyCSS();
        css.alignItems.start();

        assert css.has("align-items", "flex-start");
        assert css.has("-webkit-align-items", "flex-start");
        assert css.has("-webkit-box-align", "start");
        assert css.has("-ms-flex-align", "start");
        assert css.no(Mozilla);
    }

    @Test
    public void end() throws Exception {
        MyCSS css = new MyCSS();
        css.alignItems.end();

        assert css.has("align-items", "flex-end");
        assert css.has("-webkit-align-items", "flex-end");
        assert css.has("-webkit-box-align", "end");
        assert css.has("-ms-flex-align", "end");
        assert css.no(Mozilla);
    }

    @Test
    public void center() throws Exception {
        MyCSS css = new MyCSS();
        css.alignItems.center();

        assert css.has("align-items", "center");
        assert css.has("-webkit-align-items", "center");
        assert css.has("-webkit-box-align", "center");
        assert css.has("-ms-flex-align", "center");
        assert css.no(Mozilla);
    }

    @Test
    public void baseline() throws Exception {
        MyCSS css = new MyCSS();
        css.alignItems.baseline();

        assert css.has("align-items", "baseline");
        assert css.has("-webkit-align-items", "baseline");
        assert css.has("-webkit-box-align", "baseline");
        assert css.has("-ms-flex-align", "baseline");
        assert css.no(Mozilla);
    }

    @Test
    public void stretch() throws Exception {
        MyCSS css = new MyCSS();
        css.alignItems.stretch();

        assert css.has("align-items", "stretch");
        assert css.has("-webkit-align-items", "stretch");
        assert css.has("-webkit-box-align", "stretch");
        assert css.has("-ms-flex-align", "stretch");
        assert css.no(Mozilla);
    }
}
