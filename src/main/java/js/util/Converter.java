/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

/**
 * @version 2013/04/12 16:12:29
 */
public class Converter {

    /**
     * <p>
     * Converte the given data to the specified type.
     * </p>
     * 
     * @param value A data to convert.
     * @param type A destination type.
     */
    public static <T> T convert(String value, Class<T> type) {
        if (type == String.class) {
            return (T) value;
        }

        if (type == Integer.class || type == int.class) {
            return (T) (Object) Integer.parseInt(value);
        }

        throw new IllegalArgumentException("The value [" + value + "] is not converted.");
    }
}
