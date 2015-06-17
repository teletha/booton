/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.builtin;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 2013/10/04 11:11:32
 */
class EmulateStorage extends Storage {

    /** The key storage. */
    private CopyOnWriteArrayList<String> keys = new CopyOnWriteArrayList();

    /** The actual storage. */
    private Map<String, String> map = new HashMap();

    /**
     * <p>
     * The length attribute must return the number of key/value pairs currently present in the list
     * associated with the object.
     * </p>
     * 
     * @return
     */
    @Override
    public int length() {
        return map.size();
    }

    /**
     * <p>
     * The key(n) method must return the name of the nth key in the list. The order of keys is
     * user-agent defined, but must be consistent within an object so long as the number of keys
     * doesn't change. (Thus, adding or removing a key may change the order of the keys, but merely
     * changing the value of an existing key must not.) If n is greater than or equal to the number
     * of key/value pairs in the object, then this method must return null.
     * </p>
     * 
     * @param index
     * @return
     */
    @Override
    public String key(int index) {
        return keys.get(index);
    }

    /**
     * <p>
     * The getItem(key) method must return the current value associated with the given key. If the
     * given key does not exist in the list associated with the object then this method must return
     * null.
     * </p>
     * 
     * @param key
     * @return
     */
    @Override
    public String getItem(String key) {
        return map.get(key);
    }

    /**
     * <p>
     * The setItem(key, value) method must first check if a key/value pair with the given key
     * already exists in the list associated with the object.
     * </p>
     * 
     * @param key
     * @param value
     */
    @Override
    public String setItem(String key, String value) {
        keys.addIfAbsent(key);
        return map.put(key, value);
    }

    /**
     * <p>
     * The removeItem(key) method must cause the key/value pair with the given key to be removed
     * from the list associated with the object, if it exists. If no item with that key exists, the
     * method must do nothing.
     * </p>
     * 
     * @param key
     */
    @Override
    public void removeItem(String key) {
        keys.remove(key);
        map.remove(key);
    }

    /**
     * <p>
     * The clear() method must atomically cause the list associated with the object to be emptied of
     * all key/value pairs, if there are any. If there are none, then the method must do nothing.
     * </p>
     */
    @Override
    public void clear() {
        keys.clear();
        map.clear();
    }
}
