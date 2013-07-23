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

import booton.css.MyCSS;

/**
 * @version 2013/07/23 10:52:36
 */
public class OutlineTest {

    @Test
    public void width() throws Exception {
        MyCSS css = new MyCSS();
        css.outline.width(2, em);

        assert css.outline.top.width().equals("2em");
        assert css.outline.right.width().equals("2em");
        assert css.outline.bottom.width().equals("2em");
        assert css.outline.left.width().equals("2em");
        assert css.has("outline-width", "2em");
    }

    @Test
    public void style() throws Exception {
        MyCSS css = new MyCSS();
        css.outline.solid();

        assert css.outline.top.style() == Solid;
        assert css.outline.left.style() == Solid;
        assert css.outline.bottom.style() == Solid;
        assert css.outline.right.style() == Solid;
        assert css.has("outline-style", "solid");
    }

    @Test
    public void color() throws Exception {
        MyCSS css = new MyCSS();
        css.outline.color(White);

        assert css.outline.top.color() == White;
        assert css.outline.left.color() == White;
        assert css.outline.bottom.color() == White;
        assert css.outline.right.color() == White;
        assert css.has("outline-color", "white");
    }

    @Test
    public void chain() throws Exception {
        MyCSS css = new MyCSS();
        css.outline.solid().width(2, em).color(Black);

        assert css.has("outline", "2em solid black");
    }

    @Test
    public void top() throws Exception {
        MyCSS css = new MyCSS();
        css.outline.top.solid().width(1, px).color(Black);

        assert css.outline.top.color() == Black;
        assert css.outline.top.style() == Solid;
        assert css.outline.top.width().equals("1px");
        assert css.has("outline-top", "1px solid black");
    }

    @Test
    public void topColor() throws Exception {
        MyCSS css = new MyCSS();
        css.outline.top.color(Black);

        assert css.outline.top.color() == Black;
        assert css.has("outline-top-color", "black");
    }
}
