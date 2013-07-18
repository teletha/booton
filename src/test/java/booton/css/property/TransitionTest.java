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

/**
 * @version 2013/07/18 16:42:45
 */
public class TransitionTest {

    @Test
    public void center() throws Exception {
        MyCSS css = new MyCSS();
        css.transition.delay(10, Second);

        assert css.has("transition-delay", "10s");
        assert css.has("-webkit-transition-delay");
        assert css.omit("-moz-transition-delay");
        assert css.omit("-ms-transition-delay");
    }
}
