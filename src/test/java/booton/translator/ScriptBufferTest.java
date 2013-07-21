/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import org.junit.Test;

/**
 * @version 2013/01/21 15:36:41
 */
public class ScriptBufferTest {

    @Test
    public void optimize() throws Exception {
        ScriptWriter buffer = new ScriptWriter();
        buffer.append(",");
        assert buffer.toString().length() == 1;

        buffer.optimize();
        assert buffer.toString().length() == 0;
    }

    @Test
    public void optimizeReturn() throws Exception {
        ScriptWriter buffer = new ScriptWriter();
        buffer.append("return;");
        assert buffer.toString().length() == 9;

        buffer.optimize();
        assert buffer.toString().length() == 0;
    }
}
