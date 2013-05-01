/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.persistence;

import java.lang.reflect.Array;

import js.lang.Global;
import js.lang.NativeObject;

/**
 * @version 2013/04/29 13:24:31
 */
public class Persister {

    public static <T> T restore(Class<T> type, String json) {
        try {
            NativeObject object = Global.JSON.parse(json);
            NativeObject instance = (NativeObject) (Object) type.newInstance();

            restore(instance, object);

            return (T) instance;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static void restore(NativeObject java, NativeObject js) {
        try {
            for (String key : js.keys()) {
                if (!key.startsWith("$")) {
                    Object value = js.getProperty(key);

                    if (value instanceof Object) {
                        String className = js.getPropertyAs(String.class, "$" + key);

                        if (className.startsWith("[")) {
                            className = className.substring(1);
                            Class clazz = Class.forName(className);

                            Object array = Array.newInstance(clazz, 0);
                            restore((NativeObject) array, (NativeObject) value);
                            java.setProperty(key, array);
                        } else {
                            Class clazz = Class.forName(className);
                            Object instance = clazz.newInstance();

                            restore((NativeObject) instance, (NativeObject) value);

                            java.setProperty(key, instance);
                        }
                    } else {
                        java.setProperty(key, value);
                    }
                }
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static String store(Object model) {
        StringBuilder builder = new StringBuilder("{");
        NativeObject js = (NativeObject) model;

        for (String key : js.keys()) {
            if (!key.startsWith("$")) {
                Object value = js.getProperty(key);

                if (value == null) {
                    // ignore null value
                } else {
                    // write key
                    builder.append("\"").append(key).append("\":");

                    if (value instanceof String) {
                        // string
                        builder.append("\"").append(value).append("\"");
                    } else if (value instanceof Object) {
                        // object and array
                        builder.append(store(value))
                                .append(",\"$")
                                .append(key)
                                .append("\":\"")
                                .append(value.getClass().getSimpleName())
                                .append("\"");
                    } else {
                        // number
                        builder.append(value);
                    }
                    builder.append(",");
                }
            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");

        return builder.toString();
    }
}
