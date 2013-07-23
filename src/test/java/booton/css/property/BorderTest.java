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

import static booton.css.Unit.*;
import static booton.css.property.BorderStyle.*;
import static booton.css.value.Color.*;

import org.junit.Test;

/**
 * @version 2013/07/22 12:51:59
 */
public class BorderTest {

    @Test
    public void width() throws Exception {
        MyCSS css = new MyCSS();
        css.border.width(2, em);

        assert css.border.top.width().equals("2em");
        assert css.border.right.width().equals("2em");
        assert css.border.bottom.width().equals("2em");
        assert css.border.left.width().equals("2em");
        assert css.has("border", "2em");
    }

    @Test
    public void style() throws Exception {
        MyCSS css = new MyCSS();
        css.border.solid();

        assert css.border.top.style() == Solid;
        assert css.border.left.style() == Solid;
        assert css.border.bottom.style() == Solid;
        assert css.border.right.style() == Solid;
        assert css.has("border", "solid");
    }

    @Test
    public void color() throws Exception {
        MyCSS css = new MyCSS();
        css.border.color(White);

        assert css.border.top.color() == White;
        assert css.border.left.color() == White;
        assert css.border.bottom.color() == White;
        assert css.border.right.color() == White;
        assert css.has("border", "white");
    }

    @Test
    public void chain() throws Exception {
        MyCSS css = new MyCSS();
        css.border.solid().width(2, em).color(Black);

        assert css.has("border", "2em solid black");
    }

    @Test
    public void top() throws Exception {
        MyCSS css = new MyCSS();
        css.border.top.solid().width(1, px).color(Black);

        assert css.border.top.color() == Black;
        assert css.border.top.style() == Solid;
        assert css.border.top.width().equals("1px");
        assert css.has("border-top", "1px solid black");
    }

    @Test
    public void radius() throws Exception {
        MyCSS css = new MyCSS();
        css.border.radius(5, px);

        assert css.has("border-radius", "5px");
    }

    @Test
    public void radiusTop() throws Exception {
        MyCSS css = new MyCSS();
        css.border.top.radius(5, px);

        assert css.has("border-top-left-radius", "5px");
        assert css.has("border-top-right-radius", "5px");
    }
}
