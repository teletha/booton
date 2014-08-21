/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import org.junit.Test;

/**
 * @version 2014/08/22 7:42:04
 */
public class UseCaseTest {

    @Test
    public void testname() throws Exception {
        UseCase use = new UseCase();
        assert use.todos.size() == 0;
        assert use.getVirtualElement() != null;

        User.input("test", use.input);
    }
}
