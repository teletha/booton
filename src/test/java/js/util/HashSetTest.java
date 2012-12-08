/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Set;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/09 0:39:57
 */
public class HashSetTest extends ScriptTester {

    @Test
    public void add() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet2();
                set.add("1");

                return set.size();
            }
        });
    }

    @Test
    public void addMultiple() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet2();
                set.add("1");
                set.add("1");

                return set.size();
            }
        });
    }

    @Test
    public void addSameValue() throws Exception {
        test(new Scriptable() {

            int act() {
                String value = "1";

                Set<String> set = new HashSet2();
                set.add(value);
                set.add(value);

                return set.size();
            }
        });
    }
}
