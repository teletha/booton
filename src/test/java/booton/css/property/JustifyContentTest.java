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
 * @version 2013/07/22 11:26:47
 */
public class JustifyContentTest {

    @Test
    public void start() throws Exception {
        MyCSS css = new MyCSS();
        css.justifyContent.start();

        assert css.has("justify-content", "flex-start");
        assert css.has("-webkit-justify-content", "flex-start");
        assert css.has("-webkit-box-pack", "start");
        assert css.has("-ms-flex-pack", "start");
        assert css.no(Mozilla);
    }

    @Test
    public void end() throws Exception {
        MyCSS css = new MyCSS();
        css.justifyContent.end();

        assert css.has("justify-content", "flex-end");
        assert css.has("-webkit-justify-content", "flex-end");
        assert css.has("-webkit-box-pack", "end");
        assert css.has("-ms-flex-pack", "end");
        assert css.no(Mozilla);
    }

    @Test
    public void center() throws Exception {
        MyCSS css = new MyCSS();
        css.justifyContent.center();

        assert css.has("justify-content", "center");
        assert css.has("-webkit-justify-content", "center");
        assert css.has("-webkit-box-pack", "center");
        assert css.has("-ms-flex-pack", "center");
        assert css.no(Mozilla);
    }

    @Test
    public void spaceAround() throws Exception {
        MyCSS css = new MyCSS();
        css.justifyContent.spaceAround();

        assert css.has("justify-content", "space-around");
        assert css.has("-webkit-justify-content", "space-around");
        assert css.has("-webkit-box-pack", "justify");
        assert css.has("-ms-flex-pack", "justify");
        assert css.no(Mozilla);
    }

    @Test
    public void spaceBetween() throws Exception {
        MyCSS css = new MyCSS();
        css.justifyContent.spaceBetween();

        assert css.has("justify-content", "space-between");
        assert css.has("-webkit-justify-content", "space-between");
        assert css.has("-webkit-box-pack", "justify");
        assert css.has("-ms-flex-pack", "justify");
        assert css.no(Mozilla);
    }
}
