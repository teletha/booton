/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import static js.lang.Global.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/18 14:18:38
 */
@RunWith(ScriptRunner.class)
public class GlobalTest {

    int value = 10;

    @Test
    public void SetTimeout() throws Exception {
        Global.setTimeout(new Runnable() {

            @Override
            public void run() {
                assert value == 10;
            }
        }, 0);
    }

    @Test
    public void ParseInt() throws Exception {
        assert parseInt("10") == 10;
        assert parseInt("-3") == -3;
        assert parseInt("+5") == 5;
        assert parseInt("1.0") == 1;
        assert parseInt("1.4") == 1;
        assert parseInt("2.9") == 2;
        assert parseInt("-0.3") == 0;
        assert parseInt("-1.9") == -1;
    }

    @Test
    public void ParseFloat() throws Exception {
        assert parseFloat("10") == 10f;
        assert parseFloat("-3") == -3f;
        assert parseFloat("+5") == 5f;
        assert parseFloat("1.0") == 1.0f;
        assert parseFloat("1.4") == 1.4f;
        assert parseFloat("2.9") == 2.9f;
        assert parseFloat("-0.3") == -0.3f;
        assert parseFloat("-1.9") == -1.9f;

        assert Float.isNaN(parseFloat(null));
        assert Float.isNaN(parseFloat(""));
        assert Float.isNaN(parseFloat("#"));
        assert Float.isNaN(parseFloat("-+0"));
    }

    @Test
    public void IsNaN() throws Exception {
        assert !isNaN(10);
        assert !isNaN(10L);
        assert !isNaN(10F);
        assert !isNaN(10D);
        assert isNaN(0.0 / 0.0);
    }
}
