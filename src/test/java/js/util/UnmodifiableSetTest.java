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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/05 9:49:16
 */
@RunWith(ScriptRunner.class)
public class UnmodifiableSetTest {

    @Test
    public void size() throws Exception {
        Set<String> set = new HashSet();
        Set<String> unmodifiable = Collections.unmodifiableSet(set);

        dasdas(set);
        assert unmodifiable.size() == 0;
    }

    private void dasdas(Set set) {
        System.out.println(set.size());
        assert set.size() == 1;
    }
}
