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
 * @version 2013/11/27 16:09:11
 */
public class ContinueBreakTest {

    @Test
    public void base() throws Exception {
    }

    /**
     * @version 2013/11/27 16:10:01
     */
    private static class Continue {

        private void continue1() {
            for (int i = 0; i < 10; i++) {
                if (i % 2 == 0) {
                    continue;
                }
                i += 3;
            }
        }
    }
}
