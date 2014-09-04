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
 * @version 2013/07/22 11:49:05
 */
public class FlexAlignContentTest {

    @Test
    public void start() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().alignContent.start();

        assert css.has("align-content", "flex-start");
        assert css.has("-webkit-align-content", "flex-start");
        assert css.has("-ms-flex-line-pack", "start");
        assert css.no(Mozilla);
    }

    @Test
    public void end() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().alignContent.end();

        assert css.has("align-content", "flex-end");
        assert css.has("-webkit-align-content", "flex-end");
        assert css.has("-ms-flex-line-pack", "end");
        assert css.no(Mozilla);
    }

    @Test
    public void center() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().alignContent.center();

        assert css.has("align-content", "center");
        assert css.has("-webkit-align-content", "center");
        assert css.has("-ms-flex-line-pack", "center");
        assert css.no(Mozilla);
    }

    @Test
    public void spaceAround() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().alignContent.spaceAround();

        assert css.has("align-content", "space-around");
        assert css.has("-webkit-align-content", "space-around");
        assert css.has("-ms-flex-line-pack", "distribute");
        assert css.no(Mozilla);
    }

    @Test
    public void spaceBetween() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().alignContent.spaceBetween();

        assert css.has("align-content", "space-between");
        assert css.has("-webkit-align-content", "space-between");
        assert css.has("-ms-flex-line-pack", "justify");
        assert css.no(Mozilla);
    }

    @Test
    public void stretch() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex().alignContent.stretch();

        assert css.has("align-content", "stretch");
        assert css.has("-webkit-align-content", "stretch");
        assert css.has("-ms-flex-line-pack", "stretch");
        assert css.no(Mozilla);
    }
}
