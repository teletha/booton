/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import jsx.style.value.Numeric;

import org.junit.Test;

/**
 * @version 2014/10/29 13:36:41
 */
public class TransformTest extends StyleTester {

    @Test
    public void rotate() {
        ValidatableStyle parsed = style(() -> {
            transform.rotate(10, deg);
        });
        assert parsed.property("-webkit-transform", "rotate(10deg)");
        assert parsed.property("transform", "rotate(10deg)");
    }

    @Test
    public void translate() {
        ValidatableStyle parsed = style(() -> {
            Numeric numeric = new Numeric(10, px).add(new Numeric(1, em));
            transform.translate(numeric);
        });
        assert parsed.property("-webkit-transform", "translate(-webkit-calc(10px + 1em))");
        assert parsed.property("transform", "translate(calc(10px + 1em))");
    }

    @Test
    public void multi() {
        ValidatableStyle parsed = style(() -> {
            transform.scale(1).skew(2, px);
        });
        assert parsed.property("-webkit-transform", "scale(1) skew(2px)");
        assert parsed.property("transform", "scale(1) skew(2px)");
    }
}
