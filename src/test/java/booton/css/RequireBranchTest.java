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
 * @version 2013/07/24 8:53:36
 */
public class RequireBranchTest {

    @Test
    public void require() throws Exception {
        Child1 child1 = I.make(Child1.class);
        assert child1.countSelector() == 1;

        Base base = I.make(Base.class);
        assert base.countSelector() == 2;

        Parent parent = I.make(Parent.class);
        assert parent.countSelector() == 3;

        Child2 child2 = I.make(Child2.class);
        assert child2.countSelector() == 1;
        assert base.countSelector() == 3;
        assert parent.countSelector() == 4;
    }

    /**
     * @version 2013/07/24 0:36:45
     */
    private static class Parent extends MyCSS {

        {
            display.block();
        }
    }

    /**
     * @version 2013/07/24 0:36:45
     */
    private static class Base extends MyCSS {

        {
            require(Parent.class);
            display.block();
        }
    }

    /**
     * @version 2013/07/24 0:36:45
     */
    private static class Child1 extends MyCSS {

        {
            require(Base.class);
            display.block();
        }
    }

    /**
     * @version 2013/07/24 8:55:19
     */
    private static class Child2 extends MyCSS {

        {
            require(Base.class);
            display.block();
        }
    }
}
