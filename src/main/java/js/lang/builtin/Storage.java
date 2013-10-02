/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.builtin;

import kiss.I;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;

/**
 * <p>
 * The DOM Storage mechanism is a means through which string key/value pairs can be securely stored
 * and later retrieved for use. The goal of this addition is to provide a comprehensive means
 * through which interactive applications can be built (including advanced abilities, such as being
 * able to work "offline" for extended periods of time).
 * </p>
 * 
 * @version 2013/04/23 19:35:55
 */
@JavascriptAPIProvider
public abstract class Storage implements JavascriptNative {

    /**
     * <p>
     * The length attribute must return the number of key/value pairs currently present in the list
     * associated with the object.
     * </p>
     * 
     * @return
     */
    public native long length();

    /**
     * <p>
     * The key(n) method must return the name of the nth key in the list. The order of keys is
     * user-agent defined, but must be consistent within an object so long as the number of keys
     * doesn't change. (Thus, adding or removing a key may change the order of the keys, but merely
     * changing the value of an existing key must not.) If n is greater than or equal to the number
     * of key/value pairs in the object, then this method must return null.
     * </p>
     * 
     * @param inde
     * @return
     */
    public native String key(int inde);

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
    public native String getItem(String key);

    /**
     * <p>
     * The setItem(key, value) method must first check if a key/value pair with the given key
     * already exists in the list associated with the object.
     * </p>
     * 
     * @param key
     * @param value
     */
    public native void setItem(String key, String value);

    /**
     * <p>
     * The removeItem(key) method must cause the key/value pair with the given key to be removed
     * from the list associated with the object, if it exists. If no item with that key exists, the
     * method must do nothing.
     * </p>
     * 
     * @param key
     */
    public native void removeItem(String key);

    /**
     * <p>
     * The clear() method must atomically cause the list associated with the object to be emptied of
     * all key/value pairs, if there are any. If there are none, then the method must do nothing.
     * </p>
     */
    public native void clear();

    /**
     * <p>
     * Retrieve the model instance of the specified class.
     * </p>
     * 
     * @param modelClass
     * @return
     */
    public <T> T get(Class<T> modelClass) {
        if (modelClass == null) {
            return null;
        }

        String text = getItem(modelClass.getName());

        if (text == null) {
            return null;
        }

        try {
            return I.read(text, I.make(modelClass));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Retrieve the model instance of the specified class.
     * </p>
     * 
     * @param modelClass
     * @return
     */
    public void set(Object model) {
        if (model != null) {
            StringBuilder builder = new StringBuilder();
            I.write(model, builder, true);;

            setItem(model.getClass().getName(), builder.toString());
        }
    }
}
