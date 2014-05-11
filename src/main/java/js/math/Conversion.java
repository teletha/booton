/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

/**
 * @version 2013/10/25 2:00:57
 */
class Conversion {

    /**
     * bigRadices values are precomputed maximal powers of radices (integer numbers from 2 to 36)
     * that fit into unsigned int (32 bits). bigRadices[0] = 2 ^ 31, bigRadices[8] = 10 ^ 9, etc.
     */

    static final int bigRadices[] = {-2147483648, 1162261467, 1073741824, 1220703125, 362797056, 1977326743,
            1073741824, 387420489, 1000000000, 214358881, 429981696, 815730721, 1475789056, 170859375, 268435456,
            410338673, 612220032, 893871739, 1280000000, 1801088541, 113379904, 148035889, 191102976, 244140625,
            308915776, 387420489, 481890304, 594823321, 729000000, 887503681, 1073741824, 1291467969, 1544804416,
            1838265625, 60466176};

    /**
     * Holds the maximal exponent for each radix, so that radix<sup>digitFitInInt[radix]</sup> fit
     * in an {@code int} (32 bits).
     */
    static final int[] digitFitInInt = {-1, -1, 31, 19, 15, 13, 11, 11, 10, 9, 9, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 6,
            6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 5};

}
