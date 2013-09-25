/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.ArrayDeque;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/25 17:10:43
 */
@RunWith(ScriptRunner.class)
public class ArrayDequeTest {

    @Test
    public void peekLast() throws Exception {
        ArrayDeque deque = create();
        assert deque.peekLast().equals("4");
    }

    /**
     * <p>
     * Helper method to create {@link ArrayDeque}.
     * </p>
     * 
     * @return
     */
    private ArrayDeque<String> create() {
        ArrayDeque deque = new ArrayDeque();

        deque.add("1");
        deque.add("2");
        deque.add("3");
        deque.add("4");

        return deque;
    }
}
