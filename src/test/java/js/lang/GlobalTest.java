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

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/18 14:18:38
 */
@RunWith(ScriptRunner.class)
public class GlobalTest {

    int value = 10;

    @Test
    public void setTimeout() throws Exception {
        Global.setTimeout(new Runnable() {

            @Override
            public void run() {
                assert value == 10;
            }
        }, 0);
    }
}
