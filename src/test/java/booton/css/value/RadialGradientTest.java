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
public class RadialGradientTest {

    private Color black = Color.Black;

    private Color white = Color.White;

    private Numeric one = new Numeric(10, px);

    private Numeric two = new Numeric(20, em);

    private Position pos = new Position(one, two);

    @Test
    public void base() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new RadialGradient().color(black, white));

        assert css.countProperty() == 2;
        assert css.has("background-image", "radial-gradient(black,white)");
        assert css.has("background-image", "-webkit-radial-gradient(black,white)");
    }

    @Test
    public void colors() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new RadialGradient().color(black, white, black));

        assert css.countProperty() == 2;
        assert css.has("background-image", "radial-gradient(black,white,black)");
        assert css.has("background-image", "-webkit-radial-gradient(black,white,black)");
    }

    @Test
    public void percentage() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new RadialGradient().color(black, 10).color(white, 90));

        assert css.countProperty() == 2;
        assert css.has("background-image", "radial-gradient(black 10%,white 90%)");
        assert css.has("background-image", "-webkit-radial-gradient(black 10%,white 90%)");
    }

    @Test
    public void length() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new RadialGradient().color(black, one).color(white, two));

        assert css.countProperty() == 2;
        assert css.has("background-image", "radial-gradient(black 10px,white 20em)");
        assert css.has("background-image", "-webkit-radial-gradient(black 10px,white 20em)");
    }

    @Test
    public void repeat() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new RadialGradient().repeat().color(black, white));

        assert css.countProperty() == 2;
        assert css.has("background-image", "repeating-radial-gradient(black,white)");
        assert css.has("background-image", "-webkit-repeating-radial-gradient(black,white)");
    }

    @Test
    public void position() throws Exception {
        MyCSS css = new MyCSS();
        css.background.image(new RadialGradient().position(pos).color(black, white));

        assert css.countProperty() == 2;
        assert css.has("background-image", "radial-gradient(at 10px 20em,black,white)");
        assert css.has("background-image", "-webkit-radial-gradient(10px 20em,black,white)");
    }
}
