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

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/20 0:19:15
 */
@RunWith(ScriptRunner.class)
public class CollectionsTest {

    @Test
    public void reverseOrder() throws Exception {
        String[] array = {"b", "c", "a"};
        assert array[0].equals("b");
        assert array[1].equals("c");
        assert array[2].equals("a");

        Arrays.sort(array, new Natural());
        assert array[0].equals("a");
        assert array[1].equals("b");
        assert array[2].equals("c");

        Arrays.sort(array, Collections.reverseOrder(new Natural()));
        assert array[0].equals("c");
        assert array[1].equals("b");
        assert array[2].equals("a");
    }

    /**
     * @version 2013/08/18 5:36:49
     */
    private static class Natural implements Comparator<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
