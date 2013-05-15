/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import js.lang.Global;
import js.lang.NativeNumber;
import js.lang.NativeObject;
import js.ui.model.Property;

/**
 * @version 2013/05/05 17:55:10
 */
public class Boot {

    /**
     * <p>
     * </p>
     * 
     * @param model
     * @return
     */
    public static <T> T getInstance(Class<T> model) {
        Constructor instantiator = getMiniConstructor(model);
        instantiator.setAccessible(true);

        try {
            return (T) instantiator.newInstance();
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Helper method to find the constructor which has minimum parameters. If the given class is
     * interface, primitive types, array class or <code>void</code>, <code>null</code> will be
     * return.
     * </p>
     * 
     * @param <T> A class type.
     * @param clazz A target class.
     * @return A minimum constructor or <code>null</code>.
     */
    public static <T> Constructor<T> getMiniConstructor(Class<T> clazz) {
        // the candidate of minimum constructor
        Constructor mini = null;

        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            // test parameter size
            if (mini == null || constructor.getParameterTypes().length < mini.getParameterTypes().length) {
                mini = constructor;
            }
        }

        // API definition
        return mini;
    }

    /**
     * <p>
     * Read serialized object.
     * </p>
     * 
     * @param type
     * @param json
     * @return
     */
    public static <T> T read(Class<T> type, String json) {
        try {
            return read(getInstance(type), Global.JSON.parse(json));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    /**
     * <p>
     * Read property and write it.
     * </p>
     * 
     * @param java
     * @param js
     * @return
     */
    private static <T> T read(T java, NativeObject js) throws Exception {
        for (Field field : java.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Property.class)) {
                field.setAccessible(true);

                Class type = field.getType();
                Object value = js.getProperty(field.getName());

                if (type == int.class) {
                    field.setInt(java, ((NativeNumber) value).intValue());
                } else if (type == String.class) {
                    field.set(java, value);
                } else if (type.isArray()) {
                    int length = Array.getLength(value);
                    Object instance = Array.newInstance(type, length);

                    for (int i = 0; i < length; i++) {
                        Array.set(instance, i, Array.get(value, i));
                    }

                    field.set(java, instance);
                } else {

                    field.set(java, read(getInstance(type), (NativeObject) value));
                }
            }
        }
        return java;
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

            for (Field field : model.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Property.class)) {
                    field.setAccessible(true);

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
