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
 * @version 2013/03/31 21:25:43
 */
public class Arguments {

    /**
     * <p>
     * Normalize text input.
     * </p>
     * 
     * @param input A input text to normalize.
     * @param defaultText A default text.
     * @return A normalized text.
     */
    public static String normalize(String input, String defaultText) {
        if (input == null) {
            return defaultText;
        }

        input = input.trim();

        if (input.length() == 0) {
            return defaultText;
        }
        return input;
    }
}
