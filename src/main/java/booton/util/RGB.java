/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.util;

/**
 * @version 2012/12/12 13:42:23
 */
public class RGB {

    /** The character list of number whihc base is 16. */
    private static final char[] chars = new char[16];

    // initialization
    static {
        int i = 0;

        for (char c = '0'; c <= '9'; c++, i++) {
            chars[i] = c;
        }

        for (char c = 'a'; c <= 'f'; c++, i++) {
            chars[i] = c;
        }
    }

    /** The red component in the range 0-255 in RGBA. */
    public final int red;

    /** The green component in the range 0-255 in RGBA. */
    public final int green;

    /** The blue component in the range 0-255 in RGBA. */
    public final int blue;

    /** The alpha component in the range 0-1 in RGBA. */
    public final double alpha;

    /** The hex expression. */
    public final String hex;

    /** The rgb expression. */
    public final String rgb;

    /** The rgba expression. */
    public final String rgba;

    /**
     * Create RGB from hex literal.
     * 
     * @param hex
     */
    public RGB(String hex) {
        if (hex.charAt(0) == '#') {
            hex = hex.substring(1);
        }

        if (hex.length() == 3) {
            StringBuilder builder = new StringBuilder();
            builder.append(hex.charAt(0)).append(hex.charAt(0));
            builder.append(hex.charAt(1)).append(hex.charAt(1));
            builder.append(hex.charAt(2)).append(hex.charAt(2));

            hex = builder.toString();
        }

        this.red = Integer.parseInt(hex.substring(0, 2), 16);
        this.green = Integer.parseInt(hex.substring(2, 4), 16);
        this.blue = Integer.parseInt(hex.substring(4, 6), 16);
        this.alpha = 1;
        this.hex = "#" + hex;

        // compute RGB expression
        StringBuilder builder = new StringBuilder();
        builder.append("rgb(")
                .append(this.red)
                .append(',')
                .append(this.green)
                .append(',')
                .append(this.blue)
                .append(')');

        this.rgb = builder.toString();

        // compute RGBA expression
        builder.setCharAt(builder.length() - 1, ',');
        builder.insert(3, 'a').append(this.alpha).append(')');

        this.rgba = builder.toString();
    }

    /**
     * Create Color from hex expression.
     * 
     * @param color
     */
    public RGB(int color) {
        this((color & 0xFF0000) >> 16, (color & 0x00FF00) >> 8, (color & 0x0000FF));
    }

    /**
     * Create Color without alpha channel.
     * 
     * @param red A red component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param green A green component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param blue A blue component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     */
    public RGB(int red, int green, int blue) {
        this(red, green, blue, 1);
    }

    /**
     * Create Color with alpha channel.
     * 
     * @param red A red component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param green A green component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param blue A blue component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     */
    public RGB(int red, int green, int blue, double alpha) {
        this.red = (int) range(red, 255);
        this.green = (int) range(green, 255);
        this.blue = (int) range(blue, 255);
        this.alpha = range(alpha, 1);

        // compute hex expression
        int index = 7;
        int number = this.red << 16 | this.green << 8 | this.blue;
        char[] value = {'#', '0', '0', '0', '0', '0', '0'};

        do {
            value[--index] = chars[number & 15];
            number >>>= 4;
        } while (number != 0);

        // minify
        if (value[1] == value[2] && value[3] == value[4] && value[5] == value[6]) {
            value = new char[] {value[0], value[1], value[3], value[5]};
        }

        this.hex = new String(value);

        // compute RGB expression
        StringBuilder builder = new StringBuilder();
        builder.append("rgb(")
                .append(this.red)
                .append(',')
                .append(this.green)
                .append(',')
                .append(this.blue)
                .append(')');

        this.rgb = builder.toString();

        // compute RGBA expression
        builder.setCharAt(builder.length() - 1, ',');
        builder.insert(3, 'a').append(this.alpha).append(')');

        this.rgba = builder.toString();
    }

    /**
     * Helper method to check range.
     * 
     * @param value
     * @return
     */
    private double range(double value, int max) {
        return value < 0 ? 0 : max < value ? max : value;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return rgba;
    }
}