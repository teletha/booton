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

import booton.css.value.Numeric;

/**
 * @version 2013/07/23 17:38:16
 */
public class CalcTest {

    private Numeric one = new Numeric(1, px);

    private Numeric two = new Numeric(2, em);

    @Test
    public void none() throws Exception {
        MyCSS css = new MyCSS();
        css.box.width(one);

        assert css.has("width", "1px");
        assert css.no(IE, Mozilla, Webkit);
    }

    @Test
    public void add() throws Exception {
        MyCSS css = new MyCSS();
        css.box.width(one.add(two));

        assert css.has("width", "-webkit-calc(1px + 2em)");
        assert css.has("width", "calc(1px + 2em)");
        assert css.no(IE, Mozilla);
    }
}
