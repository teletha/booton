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

import org.junit.Test;

import booton.css.MyCSS;

/**
 * @version 2013/07/23 0:47:54
 */
public class TransformTest {

    @Test
    public void rotate() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.rotate(10, deg);

        assert css.has("-webkit-transform", "rotate(10deg)");
        assert css.has("transform", "rotate(10deg)");
        assert css.countProperty() == 2;
    }

    @Test
    public void rotateX() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.rotateX(10, deg);

        assert css.has("-webkit-transform", "rotateX(10deg)");
        assert css.has("transform", "rotateX(10deg)");
        assert css.countProperty() == 2;
    }

    @Test
    public void rotateY() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.rotateY(10, deg);

        assert css.has("-webkit-transform", "rotateY(10deg)");
        assert css.has("transform", "rotateY(10deg)");
        assert css.countProperty() == 2;
    }

    @Test
    public void rotateZ() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.rotateZ(10, deg);

        assert css.has("-webkit-transform", "rotateZ(10deg)");
        assert css.has("transform", "rotateZ(10deg)");
        assert css.countProperty() == 2;
    }

    @Test
    public void translate() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.translate(10, px);

        assert css.has("-webkit-transform", "translate(10px)");
        assert css.has("transform", "translate(10px)");
        assert css.countProperty() == 2;
    }

    @Test
    public void translateX() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.translateX(10, px);

        assert css.has("-webkit-transform", "translateX(10px)");
        assert css.has("transform", "translateX(10px)");
        assert css.countProperty() == 2;
    }

    @Test
    public void translateY() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.translateY(10, px);

        assert css.has("-webkit-transform", "translateY(10px)");
        assert css.has("transform", "translateY(10px)");
        assert css.countProperty() == 2;
    }

    @Test
    public void translateZ() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.translateZ(10, px);

        assert css.has("-webkit-transform", "translateZ(10px)");
        assert css.has("transform", "translateZ(10px)");
        assert css.countProperty() == 2;
    }

    @Test
    public void scale1() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.scale(10);

        assert css.has("-webkit-transform", "scale(10)");
        assert css.has("transform", "scale(10)");
        assert css.countProperty() == 2;
    }

    @Test
    public void scale2() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.scale(10, 5);

        assert css.has("-webkit-transform", "scale(10,5)");
        assert css.has("transform", "scale(10,5)");
        assert css.countProperty() == 2;
    }

    @Test
    public void scaleX() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.scaleX(10);

        assert css.has("-webkit-transform", "scaleX(10)");
        assert css.has("transform", "scaleX(10)");
        assert css.countProperty() == 2;
    }

    @Test
    public void scaleY() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.scaleY(10);

        assert css.has("-webkit-transform", "scaleY(10)");
        assert css.has("transform", "scaleY(10)");
        assert css.countProperty() == 2;
    }

    @Test
    public void scaleZ() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.scaleZ(10);

        assert css.has("-webkit-transform", "scaleZ(10)");
        assert css.has("transform", "scaleZ(10)");
        assert css.countProperty() == 2;
    }

    @Test
    public void skew() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.skew(10, deg);

        assert css.has("-webkit-transform", "skew(10deg)");
        assert css.has("transform", "skew(10deg)");
        assert css.countProperty() == 2;
    }

    @Test
    public void skewX() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.skewX(10, deg);

        assert css.has("-webkit-transform", "skewX(10deg)");
        assert css.has("transform", "skewX(10deg)");
        assert css.countProperty() == 2;
    }

    @Test
    public void skewY() throws Exception {
        MyCSS css = new MyCSS();
        css.transform.skewY(10, deg);

        assert css.has("-webkit-transform", "skewY(10deg)");
        assert css.has("transform", "skewY(10deg)");
        assert css.countProperty() == 2;
    }
}
