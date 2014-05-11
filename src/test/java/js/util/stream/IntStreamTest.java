/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.stream;

import java.util.stream.IntStream;

/**
 * @version 2013/10/30 16:05:25
 */
public class IntStreamTest {

    // @Test
    public void count() throws Exception {
        assert IntStream.range(1, 5).count() == 4;
    }
}
