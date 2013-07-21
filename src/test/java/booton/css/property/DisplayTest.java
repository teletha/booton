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
 * @version 2013/07/16 14:10:31
 */
public class DisplayTest {

    @Test
    public void block() throws Exception {
        MyCSS css = new MyCSS();
        css.display.block();

        assert css.has("display", "block");
    }

    @Test
    public void inline() throws Exception {
        MyCSS css = new MyCSS();
        css.display.inline();

        assert css.has("display", "inline");
    }

    @Test
    public void inlineBlock() throws Exception {
        MyCSS css = new MyCSS();
        css.display.inlineBlock();

        assert css.has("display", "inline-block");
    }

    @Test
    public void flex() throws Exception {
        MyCSS css = new MyCSS();
        css.display.flex();

        assert css.has("display", "flex");
        assert css.omit("display", "-moz-flex");
        assert css.has("display", "-webkit-flex");
        assert css.has("display", "-webkit-box");
        assert css.has("display", "-ms-flexbox");
    }

    @Test
    public void inlineFlex() throws Exception {
        MyCSS css = new MyCSS();
        css.display.inlineFlex();

        assert css.has("display", "inline-flex");
        assert css.omit("display", "-moz-inline-flex");
        assert css.has("display", "-webkit-inline-flex");
        assert css.has("display", "-webkit-box");
        assert css.has("display", "-ms-inline-flexbox");
    }
}
