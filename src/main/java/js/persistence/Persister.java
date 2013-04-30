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

import js.lang.Global;
import js.lang.NativeObject;
import js.util.jQuery;

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
                        Class clazz = Class.forName(className);
                        Object instance = clazz.newInstance();

                        restore((NativeObject) instance, (NativeObject) value);

                        java.setProperty(key, instance);
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
        NativeObject instance = (NativeObject) model;

        for (String key : instance.keys()) {
            if (!key.startsWith("$")) {
                Object value = instance.getProperty(key);

                if (value == null) {
                    // ignore
                } else if (value instanceof Object) {
                    builder.append("\"").append(key).append("\":").append(store(value));
                    builder.append(",");
                    builder.append("\"$")
                            .append(key)
                            .append("\":\"")
                            .append(value.getClass().getSimpleName())
                            .append("\"");
                    builder.append(",");
                } else if (value instanceof String) {
                    builder.append("\"").append(key).append("\":\"").append(value).append("\"");
                    builder.append(",");
                } else if (jQuery.isArray(value)) {
                    System.out.println("Arrayyyyyyy");
                } else {
                    builder.append("\"").append(key).append("\":").append(value);
                    builder.append(",");
                }

            }
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("}");

        return builder.toString();
    }
}
