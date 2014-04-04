/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import kiss.I;
import booton.translator.UnsafeWordCalculator;

/**
 * @version 2013/01/21 0:40:53
 */
public class Obfuscator {

    /** The configuration. */
    private static final BootonConfiguration config = I.make(BootonConfiguration.class);

    /**
     * The sorterd hash of unsafe words in ECMA Script. These values are calculated and hard-coded
     * to reduce footprint size and process time at runtime. See {@link UnsafeWordCalculator} for
     * more detail.
     */
    private static final int[] unsafe = {62, 133, 141, 8379, 48854, 53444, 363787};

    /** The character list of number which base is 16. */
    private static final char[] base16 = new char[16];

    /** The character list of number which base is 32. */
    private static final char[] base32 = new char[32];

    /** The character list of number which base is 52. */
    private static final char[] base52 = new char[52];

    // initialization
    static {
        // Allocate characters
        for (int i = 0; i < 26; i++) {
            base52[i] = (char) (i + 97);
            base52[i + 26] = (char) (i + 65);
        }

        System.arraycopy(base52, 0, base16, 0, 16);

        System.arraycopy(base52, 26, base32, 0, 26);
        System.arraycopy(base52, 20, base32, 26, 6);
    }

    /** The class id for css. */
    private static final Map<Class, String> css = new HashMap();

    /**
     * <p>
     * Compute the identified qualified class name for CSS.
     * </p>
     * 
     * @param clazz A class with fully qualified class name(e.g. java.lang.String).
     * @return An identified class name for ECMAScript.
     */
    public static final String computeCSSName(Class style) {
        String name = css.get(style);

        if (name == null) {
            name = mung52(css.size());
            css.put(style, name);
        }
        return name;
    }

    /**
     * <p>
     * Convert the specified number to an munged alphabetical hex number expression ('a' to 'p').
     * </p>
     * 
     * @param number A number to mung.
     * @param lower A character patter. <code>true</code> use lower case, otherwise upper case.
     * @return A munged letters.
     */
    public static final String mung16(int number) {
        int i = Arrays.binarySearch(unsafe, number);

        if (i < 0) {
            // Calculate insert index
            i = (i + 1) * -1;

            // Increase the amount of unsafe numbers which are lower than the specified number.
            number += i;

            // If the previous increment exceeds the next unsafe number, we must increse one more.
            if (i != unsafe.length && unsafe[i] <= number) {
                number++;
            }
        } else {
            // It is assured that this increment doesn't exceeds the next unsafe number because the
            // sequence of unsafe numbers has enough distance on each elements.
            number += i + 1;
        }

        int index = 8;
        char[] buffer = new char[8];

        do {
            buffer[--index] = base16[number & 15];
            number >>>= 4;
        } while (number != 0);

        // build muged value
        return new String(buffer, index, (8 - index));
    }

    /**
     * <p>
     * Convert the specified number to an munged alphabetical hex number expression ('a' to 'p').
     * </p>
     * 
     * @param number A number to mung.
     * @param lower A character patter. <code>true</code> use lower case, otherwise upper case.
     * @return A munged letters.
     */
    public static final String mung32(int number) {
        int i = Arrays.binarySearch(unsafe, number);

        if (i < 0) {
            // Calculate insert index
            i = (i + 1) * -1;

            // Increase the amount of unsafe numbers which are lower than the specified number.
            number += i;

            // If the previous increment exceeds the next unsafe number, we must increse one more.
            if (i != unsafe.length && unsafe[i] <= number) {
                number++;
            }
        } else {
            // It is assured that this increment doesn't exceeds the next unsafe number because the
            // sequence of unsafe numbers has enough distance on each elements.
            number += i + 1;
        }

        int index = 8;
        char[] buffer = new char[8];

        do {
            buffer[--index] = base32[number & 31];
            number >>>= 5;
        } while (number != 0);

        // build muged value
        return new String(buffer, index, (8 - index));
    }

    /**
     * <p>
     * Convert the specified number to an munged alphabetical number expression ('a' to 'Z').
     * </p>
     * 
     * @param number A number to mung.
     * @return A munged letters.
     */
    public static final String mung52(int number) {
        int index = 8;
        char[] buffer = new char[index + 1];

        while (52 <= number) {
            buffer[index--] = base52[(number % 52)];
            number = number / 52;
        }
        buffer[index] = base52[number];

        return new String(buffer, index, (buffer.length - index));
    }
}
