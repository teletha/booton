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

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/09 14:58:41
 */
@SuppressWarnings("unused")
public class HashSetTest extends ScriptTester {

    @Test
    public void add() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet();
                assert set.size() == 0;

                set.add("1");
                assert set.size() == 1;

                return set.size();
            }
        });
    }

    @Test
    public void addMultiple() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet();
                assert set.size() == 0;

                assert set.add("1");
                assert set.add("2");
                assert set.size() == 2;

                return set.size();
            }
        });
    }

    @Test
    public void addSameValue() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet();
                assert set.add("1");
                assert !set.add("1");
                assert set.size() == 1;

                return set.size();
            }
        });
    }

    @Test
    public void remove() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet();
                set.add("1");
                set.add("2");
                assert set.size() == 2;

                assert set.remove("1");
                assert set.size() == 1;
                assert !set.remove("1");

                assert set.remove("2");
                assert set.size() == 0;

                return set.size();
            }
        });
    }

    @Test
    public void contains() throws Exception {
        test(new Scriptable() {

            boolean act() {
                Set<String> set = new HashSet();
                assert !set.contains("1");

                set.add("1");
                assert set.contains("1");

                return set.contains("1");
            }
        });
    }

    @Test
    public void isEmpty() throws Exception {
        test(new Scriptable() {

            boolean act() {
                Set<String> set = new HashSet();
                assert set.isEmpty();

                set.add("1");
                assert !set.isEmpty();

                return set.isEmpty();
            }
        });
    }

    @Test
    public void addAll() throws Exception {
        test(new Scriptable() {

            boolean act() {
                Set<String> set = new HashSet();
                set.add("1");
                assert set.size() == 1;

                Set<String> addition = new HashSet();
                addition.add("1");
                addition.add("2");
                addition.add("3");
                boolean modified = set.addAll(addition);
                assert set.size() == 3;
                assert modified;

                return modified;
            }
        });
    }

    @Test
    public void iterator() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet();
                set.add("1");
                set.add("2");

                int size = 0;

                for (String string : set) {
                    size++;
                }
                assert size == 2;

                return size;
            }
        });
    }

    @Test
    public void iteratorRemove() throws Exception {
        test(new Scriptable() {

            int act() {
                Set<String> set = new HashSet();
                set.add("1");
                set.add("2");

                Iterator<String> iterator = set.iterator();

                while (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }
                assert set.size() == 0;

                return set.size();
            }
        });
    }
}
