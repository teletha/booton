/*
 * Copyright (C) 2009 Nameless Production Committee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package booton.css;

/**
 * @version 2009/08/26 8:44:09
 */
public class Color {

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
    public final float alpha;

    /** The hex expression. */
    public final String hex;

    /** The rgb expression. */
    public final String rgb;

    /** The rgba expression. */
    public final String rgba;

    /**
     * Create Color from hex expression.
     * 
     * @param color
     */
    public Color(int color) {
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
    public Color(int red, int green, int blue) {
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
    public Color(int red, int green, int blue, float alpha) {
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
    private float range(float value, int max) {
        return value < 0 ? 0 : max < value ? max : value;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return hex;
    }
}
