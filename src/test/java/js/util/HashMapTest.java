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

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/09 21:58:41
 */
@SuppressWarnings("unused")
public class HashMapTest extends ScriptTester {

    @Test
    public void put() throws Exception {
        test(new Scriptable() {

            public int act() {
                String key1 = "key1";
                String value1 = "value1";

                HashMap<String, String> map = new HashMap();
                assert map.size() == 0;

                assert map.put(key1, value1) == null;
                assert map.size() == 1;

                return map.size();
            }
        });
    }

    @Test
    public void putMultiple() throws Exception {
        test(new Scriptable() {

            public int act() {
                String key1 = "key1";
                String key2 = "key2";
                String value1 = "value1";
                String value2 = "value2";

                HashMap<String, String> map = new HashMap();
                assert map.size() == 0;

                assert map.put(key1, value1) == null;
                assert map.put(key2, value2) == null;
                assert map.size() == 2;

                return map.size();
            }
        });
    }

    @Test
    public void putSame() throws Exception {
        test(new Scriptable() {

            public String act() {
                String key1 = "key1";
                String value1 = "value1";
                String value2 = "value2";

                HashMap<String, String> map = new HashMap();
                map.put(key1, value1);

                String got = map.get(key1);
                assert value1.equals(got);

                map.put(key1, value2);
                got = map.get(key1);
                assert value2.equals(got);

                return got;
            }
        });
    }

    @Test
    public void get() throws Exception {
        test(new Scriptable() {

            public String act() {
                String key1 = "key1";
                String value1 = "value1";

                HashMap<String, String> map = new HashMap();
                assert map.get(key1) == null;

                map.put(key1, value1);
                assert map.size() == 1;

                String got = map.get(key1);
                assert value1.equals(got);

                return got;
            }
        });
    }

    @Test
    public void containsKey() throws Exception {
        test(new Scriptable() {

            public boolean act() {
                String key1 = "key1";
                String value1 = "value1";

                HashMap<String, String> map = new HashMap();
                assert !map.containsKey(key1);

                map.put(key1, value1);
                assert map.containsKey(key1);

                return map.containsKey(key1);
            }
        });
    }

    @Test
    public void containsValue() throws Exception {
        test(new Scriptable() {

            public boolean act() {
                String key1 = "key1";
                String value1 = "value1";

                HashMap<String, String> map = new HashMap();
                assert !map.containsValue(value1);

                map.put(key1, value1);
                assert map.containsValue(value1);

                return map.containsValue(value1);
            }
        });
    }

    @Test
    public void remove() throws Exception {
        test(new Scriptable() {

            public String act() {
                String key1 = "key1";
                String value1 = "value1";

                HashMap<String, String> map = new HashMap();
                assert map.remove(key1) == null;

                map.put(key1, value1);
                assert map.containsKey(key1);

                String removed = map.remove(key1);

                assert removed == value1;
                assert !map.containsKey(key1);

                return removed;
            }
        });
    }

    @Test
    public void entrySet() throws Exception {
        test(new Scriptable() {

            public int act() {
                String key1 = "key1";
                String key2 = "key2";
                String value1 = "value1";
                String value2 = "value2";

                HashMap<String, String> map = new HashMap();
                map.put(key1, value1);
                map.put(key2, value2);

                Set<Entry<String, String>> set = map.entrySet();
                Iterator<Entry<String, String>> iterator = set.iterator();
                int size = 0;

                while (iterator.hasNext()) {
                    size++;
                    Entry<String, String> entry = iterator.next();
                    assert map.containsKey(entry.getKey());
                    assert map.containsValue(entry.getValue());
                    iterator.remove();
                    assert !map.containsKey(entry.getKey());
                    assert !map.containsValue(entry.getValue());
                }
                assert size == 2;
                assert map.size() == 0;

                return size;
            }
        });
    }

    @Test
    public void keySet() throws Exception {
        test(new Scriptable() {

            public int act() {
                String key1 = "key1";
                String key2 = "key2";
                String value1 = "value1";
                String value2 = "value2";

                HashMap<String, String> map = new HashMap();
                map.put(key1, value1);
                map.put(key2, value2);

                Set<String> set = map.keySet();
                Iterator<String> iterator = set.iterator();
                int size = 0;

                while (iterator.hasNext()) {
                    size++;
                    String entry = iterator.next();
                    assert map.containsKey(entry);
                    iterator.remove();
                    assert !map.containsKey(entry);
                }
                assert size == 2;
                assert map.size() == 0;

                return size;
            }
        });
    }

    @Test
    public void values() throws Exception {
        test(new Scriptable() {

            public int act() {
                String key1 = "key1";
                String key2 = "key2";
                String value1 = "value1";
                String value2 = "value2";

                HashMap<String, String> map = new HashMap();
                map.put(key1, value1);
                map.put(key2, value2);

                Collection<String> set = map.values();
                Iterator<String> iterator = set.iterator();
                int size = 0;

                while (iterator.hasNext()) {
                    size++;
                    String entry = iterator.next();
                    assert map.containsValue(entry);
                    iterator.remove();
                    assert !map.containsValue(entry);
                }
                assert size == 2;
                assert map.size() == 0;

                return size;
            }
        });
    }

    @Test
    public void primitiveWrapperKey() throws Exception {
        test(new Scriptable() {

            public int act() {
                int key1 = 1;
                String value1 = "value1";

                HashMap<Integer, String> map = new HashMap();
                assert map.size() == 0;

                assert map.put(key1, value1) == null;
                assert map.size() == 1;
                assert map.get(key1) == value1;

                return map.size();
            }
        });
    }
}
