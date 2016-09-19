/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.beans;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:47:20
 */
@JavaAPIProvider(java.beans.Introspector.class)
class Introspector {

    /**
     * Utility method to take a string and convert it to normal Java variable name capitalization.
     * This normally means converting the first character from upper case to lower case, but in the
     * (unusual) special case when there is more than one character and both the first and second
     * characters are upper case, we leave it alone.
     * <p>
     * Thus "FooBah" becomes "fooBah" and "X" becomes "x", but "URL" stays as "URL".
     * 
     * @param name The string to be decapitalized.
     * @return The decapitalized version of the string.
     */
    public static String decapitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }

        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) && Character.isUpperCase(name.charAt(0))) {
            return name;
        }
        char chars[] = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }
}
