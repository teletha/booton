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
import js.lang.NativeArray;
import js.lang.NativeObject;
import js.ui.model.Property;

/**
 * @version 2013/04/29 13:24:31
 */
public class Persister {

    public static <T> T read(Class<T> type, String json) {
        try {
            NativeObject object = Global.JSON.parse(json);
            Object instance = type.newInstance();

            read(instance, object);
            return (T) instance;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private static void read(Object java, NativeObject js) {
        try {
            for (Field field : java.getClass().getFields()) {
                if (field.isAnnotationPresent(Property.class)) {
                    Class type = field.getType();
                    String name = field.getName();

                    if (type == int.class) {
                        field.set(java, js.getProperty(name));
                    } else if (type == String.class) {
                        field.set(java, js.getProperty(name));
                    } else if (type.isArray()) {
                        NativeArray value = js.getPropertyAs(NativeArray.class, name);
                        int length = Array.getLength(value);
                        Object instance = Array.newInstance(type, length);

                        for (int i = 0; i < length; i++) {
                            Array.set(instance, i, Array.get(value, i));
                        }

                        field.set(java, instance);
                    } else {
                        Object instance = type.newInstance();

                        read(instance, js.getPropertyAs(NativeObject.class, name));

                        field.set(java, instance);
                    }
                }
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Write object.
     * </p>
     * 
     * @param model
     * @return
     */
    public static String write(Object model) {
        try {
            StringBuilder builder = new StringBuilder("{");

            for (Field field : model.getClass().getFields()) {
                if (field.isAnnotationPresent(Property.class)) {
                    builder.append("\"")
                            .append(field.getName())
                            .append("\":")
                            .append(write(field.getType(), field.get(model)))
                            .append(",");
                }
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append("}");

            return builder.toString();
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Write value.
     * </p>
     * 
     * @param type A value type.
     * @param value A value.
     * @return
     */
    private static String write(Class type, Object value) {
        if (value == null) {
            return "null";
        }

        if (type == String.class) {
            return "\"" + value + "\"";
        }

        if (type == int.class) {
            return String.valueOf(value);
        }

        if (type.isArray()) {
            int length = Array.getLength(value);
            Class itemType = type.getComponentType();

            StringBuilder builder = new StringBuilder("[");
            for (int i = 0; i < length; i++) {
                builder.append(write(itemType, Array.get(value, i)));

                if (i + 1 != length) {
                    builder.append(",");
                }
            }
            builder.append("]");

            return builder.toString();
        }
        return write(value);
    }
}
