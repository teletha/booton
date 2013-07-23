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
import static booton.css.Vendor.*;

import org.junit.Test;

/**
 * @version 2013/07/23 0:47:54
 */
public class TransitionTest {

    @Test
    public void property() throws Exception {
        MyCSS css = new MyCSS();
        css.transition.property.all();

        assert css.has("transition-property", "all");
        assert css.has("-webkit-transition-property", "all");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void delay() throws Exception {
        MyCSS css = new MyCSS();
        css.transition.delay(10, s);

        assert css.has("transition-delay", "10s");
        assert css.has("-webkit-transition-delay", "10s");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void duration() throws Exception {
        MyCSS css = new MyCSS();
        css.transition.duration(10, s);

        assert css.has("transition-duration", "10s");
        assert css.has("-webkit-transition-duration", "10s");
        assert css.no(Mozilla, IE);
    }

    @Test
    public void timing() throws Exception {
        MyCSS css = new MyCSS();
        css.transition.timing.ease();

        assert css.has("transition-timing-function", "ease");
        assert css.has("-webkit-transition-timing-function", "ease");
        assert css.no(Mozilla, IE);
    }
}
