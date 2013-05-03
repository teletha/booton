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
import java.lang.reflect.Field;

import js.lang.Global;
import js.lang.NativeObject;
import js.ui.model.Property;

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

    public static <T> T restore2(Class<T> type, String json) {
        try {
            NativeObject object = Global.JSON.parse(json);
            Object instance = type.newInstance();

            restore2(instance, object);

            return (T) instance;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static void restore2(Object java, NativeObject js) {
        try {
            for (Field field : java.getClass().getFields()) {
                if (field.isAnnotationPresent(Property.class)) {
                    Class type = field.getType();
                    String name = field.getName();

                    if (type == int.class) {
                        field.set(java, js.getProperty(name));
                    } else if (type == String.class) {
                        field.set(java, js.getProperty(name));
                    } else {
                        Object instance = type.newInstance();

                        restore2(instance, js.getPropertyAs(NativeObject.class, name));

                        field.set(java, instance);
                    }
                }
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static String store2(Object model) {
        try {
            StringBuilder builder = new StringBuilder("{");

            for (Field field : model.getClass().getFields()) {
                if (field.isAnnotationPresent(Property.class)) {
                    Object value = field.get(model);

                    if (value == null) {
                        // ignore null value
                    } else {
                        Class type = field.getType();

                        // write key
                        builder.append("\"").append(field.getName()).append("\":");

                        if (type == String.class) {
                            // string
                            builder.append("\"").append(value).append("\"");
                        } else if (type == int.class) {
                            // number
                            builder.append(value);
                        } else if (type.isArray()) {
                            // array
                            System.out.println("array");
                        } else {
                            // object and array
                            builder.append(store2(value));
                        }
                        builder.append(",");
                    }
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("}");

            return builder.toString();
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
