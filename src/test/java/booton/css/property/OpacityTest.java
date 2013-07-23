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

import org.junit.Test;

import booton.css.MyCSS;

/**
 * @version 2013/07/22 11:53:16
 */
public class OpacityTest {

    @Test
    public void point() throws Exception {
        MyCSS css = new MyCSS();
        css.box.opacity(0.5);

        assert css.has("opacity", "0.5");
    }

    @Test
    public void one() throws Exception {
        MyCSS css = new MyCSS();
        css.box.opacity(1);

        assert css.has("opacity", "1");
    }

    @Test
    public void zero() throws Exception {
        MyCSS css = new MyCSS();
        css.box.opacity(0);

        assert css.has("opacity", "0");
    }
}
