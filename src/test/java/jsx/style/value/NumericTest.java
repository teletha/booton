/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import static booton.css.Unit.*;

import org.junit.Test;

/**
 * @version 2014/11/13 10:58:15
 */
public class NumericTest {

    @Test
    public void degUnderflow() throws Exception {
        Numeric numeric = new Numeric(-100, deg);

        assert numeric.size == 260;
    }

    @Test
    public void degOverflow() throws Exception {
        Numeric numeric = new Numeric(400, deg);

        assert numeric.size == 40;
    }
}
