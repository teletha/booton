/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.value;

import static booton.css.Unit.*;

import org.junit.Test;

import booton.css.MyCSS;

/**
 * @version 2013/07/24 16:17:31
 */
public class LinearGradientTest {

    private Color black = Color.Black;

    private Color white = Color.White;

    private Numeric one = new Numeric(10, px);

    private Numeric two = new Numeric(20, em);

    @Test
    public void base() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new LinearGradient().color(black, white));

        assert css.countProperty() == 2;
        assert css.has("background-image", "linear-gradient(black,white)");
        assert css.has("background-image", "-webkit-linear-gradient(black,white)");
    }

    @Test
    public void angle() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new LinearGradient().angle(10, deg).color(black, white));

        assert css.countProperty() == 2;
        assert css.has("background-image", "linear-gradient(10deg,black,white)");
        assert css.has("background-image", "-webkit-linear-gradient(280deg,black,white)");
    }

    @Test
    public void colors() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new LinearGradient().color(black, white, black));

        assert css.countProperty() == 2;
        assert css.has("background-image", "linear-gradient(black,white,black)");
        assert css.has("background-image", "-webkit-linear-gradient(black,white,black)");
    }

    @Test
    public void percentage() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new LinearGradient().color(black, 10).color(white, 90));

        assert css.countProperty() == 2;
        assert css.has("background-image", "linear-gradient(black 10%,white 90%)");
        assert css.has("background-image", "-webkit-linear-gradient(black 10%,white 90%)");
    }

    @Test
    public void length() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new LinearGradient().color(black, one).color(white, two));

        assert css.countProperty() == 2;
        assert css.has("background-image", "linear-gradient(black 10px,white 20em)");
        assert css.has("background-image", "-webkit-linear-gradient(black 10px,white 20em)");
    }

    @Test
    public void repeat() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new LinearGradient().repeat().color(black, white));

        assert css.countProperty() == 2;
        assert css.has("background-image", "repeating-linear-gradient(black,white)");
        assert css.has("background-image", "-webkit-repeating-linear-gradient(black,white)");
    }
}
