/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Spliterator.OfInt;
import java.util.Spliterators;

import org.junit.Test;

/**
 * @version 2013/11/04 7:11:45
 */
public class SpliteratorsTest {

    @Test
    public void emptyIntSpliterator() throws Exception {
        OfInt empty = Spliterators.emptyIntSpliterator();
    }
}
