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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/01 16:32:43
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

    @Test
    public void sort() throws Exception {
        List<String> list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        assert list.get(0).equals("one");
        assert list.get(1).equals("two");
        assert list.get(2).equals("three");
        assert list.get(3).equals("four");

        Collections.sort(list);
        assert list.get(0).equals("four");
        assert list.get(1).equals("one");
        assert list.get(2).equals("three");
        assert list.get(3).equals("two");
    }
}
