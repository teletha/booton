/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/26 13:21:20
 */
@RunWith(ScriptRunner.class)
public class BigNumberTest {

    private static final BigNumber ZERO = new BigNumber("0");

    private static final BigNumber ONE = new BigNumber("1.1");

    private static final BigNumber NEG_ONE = new BigNumber("-1.1");

    private static final BigNumber BIG = new BigNumber("246824682468246824682468.24682468");

    private static final BigNumber NEG_BIG = new BigNumber("-246824682468246824682468.24682468");

    private static final BigNumber INTEGER = new BigNumber("1230");

    private static final BigNumber DECIMAL = new BigNumber("0.045");

    private static final BigNumber DECIMA2L = new BigNumber("10.45454545");

    @Test
    public void construct() throws Exception {
        assert ZERO.toString().equals("0");
        assert new BigNumber("-2").toString().equals("-2");
        assert new BigNumber("123456789012345678901234567890").toString().equals("123456789012345678901234567890");
        assert new BigNumber("-1234567890123456789012345.67890123456789").toString()
                .equals("-1234567890123456789012345.67890123456789");
        assert new BigNumber("-0000").toString().equals("0");
        assert BIG.toString().equals("246824682468246824682468.24682468");
    }

    @Test
    public void negete() throws Exception {
        assert ONE.negate().toString().equals("-1.1");
        assert NEG_ONE.negate().toString().equals("1.1");
        assert ZERO.negate().toString().equals("0");
        assert BIG.negate().toString().equals("-246824682468246824682468.24682468");
    }

    @Test
    public void add() throws Exception {
        // normal
        assert ONE.add(ONE).toString().equals("2.2");

        // carry over
        assert ONE.add(new BigNumber(9)).toString().equals("10.1");

        // integer + decimal
        assert INTEGER.add(DECIMAL).toString().equals("1230.045");

        assert BIG.add(ONE).toString().equals("246824682468246824682469.34682468");
        // assert NEG_BIG.add(ONE).toString().equals("-246824682468246824682467.14682468");

        // zero
        assert ZERO.add(ONE) == ONE;
        assert ONE.add(ZERO) == ONE;
    }

    @Test
    public void subtract() throws Exception {
        assert ZERO.subtract(ONE).toString().equals("-1.1");
        assert BIG.subtract(ONE).toString().equals("246824682468246824682467.14682468");
    }
}
