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

import org.junit.Test;

/**
 * @version 2013/07/22 12:51:59
 */
public class BordersTest {

    @Test
    public void width() throws Exception {
        MyCSS css = new MyCSS();
        css.borders.width(2, em);

        assert css.borders.top.width().equals("2em");
        assert css.borders.right.width().equals("2em");
        assert css.borders.bottom.width().equals("2em");
        assert css.borders.left.width().equals("2em");
    }

    @Test
    public void style() throws Exception {
        MyCSS css = new MyCSS();
        css.borders.solid();

        assert css.borders.top.style() == Solid;
        assert css.borders.left.style() == Solid;
        assert css.borders.bottom.style() == Solid;
        assert css.borders.right.style() == Solid;
    }

    @Test
    public void chain() throws Exception {
        MyCSS css = new MyCSS();
        css.borders.solid().width(2, em).color.black();

        assert css.borders.top.style() == Solid;
        assert css.borders.left.style() == Solid;
        assert css.borders.bottom.style() == Solid;
        assert css.borders.right.style() == Solid;
        assert css.borders.top.width().equals("2em");
        assert css.borders.right.width().equals("2em");
        assert css.borders.bottom.width().equals("2em");
        assert css.borders.left.width().equals("2em");
    }

    //
    // @Test
    // public void width2Sides() throws Exception {
    // MyCSS css = new MyCSS();
    // css.borders.width(2, em, 1, em);
    //
    // assert css.borders.top.width().equals("2em");
    // assert css.borders.right.width().equals("1em");
    // assert css.borders.bottom.width().equals("2em");
    // assert css.borders.left.width().equals("1em");
    // }
    //
    // @Test
    // public void width3Sides() throws Exception {
    // MyCSS css = new MyCSS();
    // css.borders.width(2, em, 1, em, 4, em);
    //
    // assert css.borders.top.width().equals("2em");
    // assert css.borders.right.width().equals("1em");
    // assert css.borders.bottom.width().equals("4em");
    // assert css.borders.left.width().equals("1em");
    // }
    //
    // @Test
    // public void width4Sides() throws Exception {
    // MyCSS css = new MyCSS();
    // css.borders.width(2, em, 1, em, 4, em, 3, em);
    //
    // assert css.borders.top.width().equals("2em");
    // assert css.borders.right.width().equals("1em");
    // assert css.borders.bottom.width().equals("4em");
    // assert css.borders.left.width().equals("3em");
    // }
}
