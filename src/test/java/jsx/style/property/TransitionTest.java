/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import org.junit.Test;

import jsx.style.StyleTester;

/**
 * @version 2014/11/13 15:24:12
 */
public class TransitionTest extends StyleTester {

    @Test
    public void transition() {
        ValidatableStyle parsed = writeStyle(() -> {
            display.width(10, px);

            transit().duration(1, s).when().hover(() -> {
                display.width(20, px);
            });
        });
        assert parsed.property("transition-property", "width");
        assert parsed.property("transition-duration", "1s");
        assert parsed.property("transition-delay", "0");
        assert parsed.property("transition-timing-function", "ease");
    }
}
