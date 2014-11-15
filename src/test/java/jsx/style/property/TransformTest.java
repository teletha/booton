/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.StyleTester;
import jsx.style.value.Numeric;

import org.junit.Test;

/**
 * @version 2014/11/15 10:44:14
 */
public class TransformTest extends StyleTester {

    @Test
    public void rotate() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.rotate(10, deg);
        });

        assert style.property("-webkit-transform", "rotate(10deg)");
        assert style.property("transform", "rotate(10deg)");
    }

    @Test
    public void rotateX() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.rotateX(10, deg);
        });

        assert style.property("-webkit-transform", "rotateX(10deg)");
        assert style.property("transform", "rotateX(10deg)");
    }

    @Test
    public void rotateY() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.rotateY(10, deg);
        });

        assert style.property("-webkit-transform", "rotateY(10deg)");
        assert style.property("transform", "rotateY(10deg)");
    }

    @Test
    public void rotateZ() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.rotateZ(10, deg);
        });

        assert style.property("-webkit-transform", "rotateZ(10deg)");
        assert style.property("transform", "rotateZ(10deg)");
    }

    @Test
    public void translate() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.translate(10, px);
        });

        assert style.property("-webkit-transform", "translate(10px)");
        assert style.property("transform", "translate(10px)");
    }

    @Test
    public void translateX() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.translateX(10, px);
        });

        assert style.property("-webkit-transform", "translateX(10px)");
        assert style.property("transform", "translateX(10px)");
    }

    @Test
    public void translateY() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.translateY(10, px);
        });

        assert style.property("-webkit-transform", "translateY(10px)");
        assert style.property("transform", "translateY(10px)");
    }

    @Test
    public void translateZ() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.translateZ(10, px);
        });

        assert style.property("-webkit-transform", "translateZ(10px)");
        assert style.property("transform", "translateZ(10px)");
    }

    @Test
    public void scale1() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.scale(10);
        });

        assert style.property("-webkit-transform", "scale(10)");
        assert style.property("transform", "scale(10)");
    }

    @Test
    public void scale2() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.scale(10, 5);
        });

        assert style.property("-webkit-transform", "scale(10,5)");
        assert style.property("transform", "scale(10,5)");
    }

    @Test
    public void scaleX() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.scaleX(10);
        });

        assert style.property("-webkit-transform", "scaleX(10)");
        assert style.property("transform", "scaleX(10)");
    }

    @Test
    public void scaleY() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.scaleY(10);
        });

        assert style.property("-webkit-transform", "scaleY(10)");
        assert style.property("transform", "scaleY(10)");
    }

    @Test
    public void scaleZ() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.scaleZ(10);
        });

        assert style.property("-webkit-transform", "scaleZ(10)");
        assert style.property("transform", "scaleZ(10)");
    }

    @Test
    public void skew() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.skew(10, deg);
        });

        assert style.property("-webkit-transform", "skew(10deg)");
        assert style.property("transform", "skew(10deg)");
    }

    @Test
    public void skewX() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.skewX(10, deg);
        });

        assert style.property("-webkit-transform", "skewX(10deg)");
        assert style.property("transform", "skewX(10deg)");
    }

    @Test
    public void skewY() throws Exception {
        ValidatableStyle style = style(() -> {
            transform.skewY(10, deg);
        });

        assert style.property("-webkit-transform", "skewY(10deg)");
        assert style.property("transform", "skewY(10deg)");
    }

    @Test
    public void multi() {
        ValidatableStyle parsed = style(() -> {
            transform.scale(1).skew(2, px);
        });
        assert parsed.property("-webkit-transform", "scale(1) skew(2px)");
        assert parsed.property("transform", "scale(1) skew(2px)");
    }

    @Test
    public void calc() {
        ValidatableStyle style = style(() -> {
            transform.translate(new Numeric(1, px).add(new Numeric(2, em)));
        });

        assert style.property("-webkit-transform", "translate(-webkit-calc(1px + 2em))");
        assert style.property("transform", "translate(calc(1px + 2em))");
    }
}
