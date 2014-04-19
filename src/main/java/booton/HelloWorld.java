/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.util.LinkedHashSet;

/**
 * @version 2014/03/08 11:13:39
 */
public class HelloWorld {

    /**
     * <p>
     * Entry point.
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        for (String string : create()) {
            System.out.println(string);
        }
    }

    /**
     * <p>
     * Create new set.
     * </p>
     * 
     * @return
     */
    private static LinkedHashSet<String> create() {
        LinkedHashSet<String> set = new LinkedHashSet();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");

        return set;
    }
}
