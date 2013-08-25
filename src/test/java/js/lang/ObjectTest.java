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
 * @version 2013/08/25 15:24:28
 */
@RunWith(ScriptRunner.class)
public class ObjectTest {

    @Test
    public void callFinalize() throws Throwable {
        new Exposer().callFinalize();
    }

    @Test(expected = CloneNotSupportedException.class)
    public void callClone() throws CloneNotSupportedException {
        new Exposer().callClone();
    }

    /**
     * @version 2013/08/25 15:28:54
     */
    private static class Exposer {

        private void callFinalize() throws Throwable {
            super.finalize();
        }

        private void callClone() throws CloneNotSupportedException {
            super.clone();
        }
    }
}
