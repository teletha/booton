/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.field;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2016/09/15 9:28:46
 */
@RunWith(ScriptRunner.class)
public class InterfaceStaticFieldTest {

    @Test
    public void interfaceAccess() {
        assert InterFace.NAME != null;
        assert InterFace.NAME.equals("EST");
    }

    @Test
    @SuppressWarnings("static-access")
    public void instanceAccess() {
        Clazz clazz = new Clazz();
        assert clazz != null;
        assert clazz.NAME != null;
        assert clazz.NAME.equals("EST");
    }

    /**
     * @version 2016/09/15 9:29:09
     */
    private static interface InterFace {

        String NAME = "TEST".substring(1);
    }

    /**
     * @version 2016/09/15 9:31:56
     */
    private static class Clazz implements InterFace {
    }
}
