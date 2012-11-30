/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @version 2012/11/30 15:33:04
 */
public class JavascriptTest {

    @Test
    public void mung() {
        assertEquals("a", Javascript.mung(0, true));
        assertEquals("b", Javascript.mung(1, true));
        assertEquals("c", Javascript.mung(2, true));
        assertEquals("p", Javascript.mung(15, true));
        assertEquals("ba", Javascript.mung(16, true));
        assertEquals("bb", Javascript.mung(17, true));
        assertEquals("ca", Javascript.mung(32, true));
        assertEquals("da", Javascript.mung(48, true));
        assertEquals("db", Javascript.mung(49, true));
        assertEquals("dp", Javascript.mung(62, true));
        assertEquals("ea", Javascript.mung(63, true));
        assertEquals("ie", Javascript.mung(131, true));
        assertEquals("ig", Javascript.mung(132, true));
        assertEquals("ih", Javascript.mung(133, true));
        assertEquals("im", Javascript.mung(138, true));
        assertEquals("io", Javascript.mung(139, true));
        assertEquals("ip", Javascript.mung(140, true));
        assertEquals("ja", Javascript.mung(141, true));
    }

}
