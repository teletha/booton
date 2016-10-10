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
 * @version 2016/10/09 11:59:47
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

    @Test
    public void integers() throws Exception {
        int[] array = {2, 3, 1};
        Arrays.sort(array);

        assert array[0] == 1;
        assert array[1] == 2;
        assert array[2] == 3;
    }

    @Test
    public void doubles() throws Exception {
        double[] array = {2d, 3d, 1d};
        Arrays.sort(array);

        assert array[0] == 1d;
        assert array[1] == 2d;
        assert array[2] == 3d;
    }

    @Test
    public void doublesRange() throws Exception {
        double[] array = {2d, 3d, 1d};
        Arrays.sort(array, 1, 3);

        assert array[0] == 2d;
        assert array[1] == 1d;
        assert array[2] == 3d;
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
