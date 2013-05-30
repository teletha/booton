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

import jsx.model.validator.Invalid;

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
        try {
            if (type == Integer.class) {
                return (T) Integer.valueOf(value);
            }

            if (type == String.class) {
                return (T) value;
            }
        } catch (NumberFormatException e) {
            // do nothing
        }
        throw new Invalid("The value [" + value + "] is not converted.");
    }
}
