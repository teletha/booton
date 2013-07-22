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
 * @version 2013/07/22 23:36:22
 */
public class ColorTest {

    @Test
    public void white() throws Exception {
        MyCSS css = new MyCSS();
        css.font.color(255, 255, 255);

        assert css.has("color", "white");
    }

    @Test
    public void black() throws Exception {
        MyCSS css = new MyCSS();
        css.font.color(0, 0, 0);

        assert css.has("color", "black");
    }

    @Test
    public void hsl() throws Exception {
        MyCSS css = new MyCSS();
        css.font.color(255, 0, 0);

        assert css.has("color", "hsl(0,100%,50%)");
    }

    @Test
    public void hsla() throws Exception {
        MyCSS css = new MyCSS();
        css.font.color(255, 255, 255, 0.9);

        assert css.has("color", "hsla(0,0%,100%,0.9)");
    }

    @Test
    public void zeroAlpha() throws Exception {
        MyCSS css = new MyCSS();
        css.font.color(255, 255, 255, 0);

        assert css.has("color", "hsla(0,0%,100%,0)");
    }
}
