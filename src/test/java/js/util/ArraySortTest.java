/*
 * Copyright (C) 2016 Nameless Production Committee
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

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/18 5:35:02
 */
@RunWith(ScriptRunner.class)
public class ArraySortTest {

    @Test
    public void sort() throws Exception {
        String[] array = {"b", "c", "a"};
        assert array.length == 3;
        assert array[0].equals("b");
        assert array[1].equals("c");
        assert array[2].equals("a");

        Arrays.sort(array, new Natural());
        assert array.length == 3;
        assert array[0].equals("a");
        assert array[1].equals("b");
        assert array[2].equals("c");

        Arrays.sort(array, new Reverse());
        assert array.length == 3;
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

    /**
     * @version 2013/08/18 5:36:49
     */
    private static class Reverse implements Comparator<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
