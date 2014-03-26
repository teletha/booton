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

    @Test
    public void construct() throws Exception {
        assert new BigNumber("0").toString().equals("0");
        assert new BigNumber("-2").toString().equals("-2");
        assert new BigNumber("123456789012345678901234567890").toString().equals("123456789012345678901234567890");
        assert new BigNumber("-1234567890123456789012345.67890123456789").toString()
                .equals("-1234567890123456789012345.67890123456789");
        assert new BigNumber("-0000").toString().equals("0");
    }
}
