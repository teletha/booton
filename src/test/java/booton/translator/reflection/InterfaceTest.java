/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.reflection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/21 16:10:06
 */
@RunWith(ScriptRunner.class)
public class InterfaceTest {

    @Test
    public void parent() throws Exception {
        assert Parent.class.getMethods().length == 1;
        assert Parent.class.getDeclaredMethods().length == 1;
    }

    @Test
    @Ignore
    public void child() throws Exception {
        assert Child.class.getMethods().length == 2;
        assert Child.class.getDeclaredMethods().length == 1;
    }

    /**
     * @version 2013/08/21 16:10:47
     */
    private static interface Parent {

        void one();
    }

    /**
     * @version 2013/08/21 16:10:47
     */
    private static interface Child extends Parent {

        void two();
    }
}
