/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import kiss.I;

import org.junit.Test;

/**
 * @version 2013/07/25 14:57:15
 */
public class RequireWithPseudoTest {

    @Test
    public void require() throws Exception {
        Base base = I.make(Base.class);
        assert base.countSelector() == 1;

        Pseudo pseudo = I.make(Pseudo.class);
        assert pseudo.countSelector() == 6;
        assert pseudo.hasSelector(Pseudo.class, "::before");
        assert pseudo.hasSelector(Base.class, "::before");
        assert pseudo.hasSelector(Pseudo.class, ":hover::after");
        assert pseudo.hasSelector(Base.class, ":hover::after");
    }

    /**
     * @version 2013/07/25 14:57:08
     */
    private static class Pseudo extends MyCSS {

        {
            display.block();

            while (before()) {
                display.inline();
            }

            while (hover()) {
                while (after()) {
                    display.none();
                }
            }
        }
    }

    /**
     * @version 2013/07/25 14:57:12
     */
    private static class Base extends MyCSS {

        {
            require(Pseudo.class);
            display.block();
        }
    }
}
