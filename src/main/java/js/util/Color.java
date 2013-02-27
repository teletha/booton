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
 * @version 2013/02/27 21:50:53
 */
public class Color {

    /**
     * The attribute of a visual sensation according to which an area appears to be similar to one
     * of the perceived colors: red, yellow, green, and blue, or to a combination of two of them .
     */
    public final int hue;

    /**
     * The colorfulness of a stimulus relative to its own brightness.
     */
    public final int saturation;

    /**
     * The brightness relative to the brightness of a similarly illuminated white.
     */
    public final int lightness;

    /**
     * Thetransparency.
     */
    public final float alpha;

    /**
     * <p>
     * Create new color.
     * </p>
     * 
     * @param hue
     * @param saturation
     * @param lightness
     */
    public Color(int hue, int saturation, int lightness, float alpha) {
        this.hue = (int) range(hue, 360);
        this.saturation = (int) range(saturation, 100);
        this.lightness = (int) range(lightness, 100);
        this.alpha = range(alpha * 100, 100) / 100;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "hsla(" + hue + "," + saturation + "%," + lightness + "%," + alpha + ")";
    }

    /**
     * <p>
     * Create Color without alpha channel.
     * </p>
     * 
     * @param red A red component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param green A green component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param blue A blue component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @return A new color.
     */
    public static Color rgb(int red, int green, int blue) {
        return rgba(red, green, blue, 1);
    }

    /**
     * <p>
     * Create Color with alpha channel.
     * </p>
     * 
     * @param red A red component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param green A green component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param blue A blue component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @return A new color.
     */
    public static Color rgba(int red, int green, int blue, float alpha) {
        return color(range(red, 255), range(green, 255), range(blue, 255), range(alpha, 1));
    }

    /**
     * <p>
     * Create Color with alpha channel.
     * </p>
     * 
     * @param red A red component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param green A green component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @param blue A blue component in the range 0-255. If the specified value is out of range, it
     *            will be round up to 0 or 255.
     * @return A new color.
     */
    private static Color color(float red, float green, float blue, float alpha) {
        red = red / 255;
        green = green / 255;
        blue = blue / 255;

        float max = Math.max(Math.max(red, green), blue);
        float min = Math.min(Math.min(red, green), blue);
        float diff = max - min;
        float sum = max + min;

        float hue = 0;
        float satuation = 0;
        float lightness = (max + min) / 2;

        if (max == red) {
            hue = 60 * (green - blue) / diff;
        } else if (max == green) {
            hue = 60 * (blue - red) / diff + 120;
        } else if (max == blue) {
            hue = 60 * (red - green) / diff + 240;
        }

        if (hue < 0) {
            hue += 360;
        }

        if (diff != 0) {
            satuation = lightness < 0.5 ? diff / sum : diff / (2 - sum);
        }
        return new Color(Math.round(hue), Math.round(satuation * 100), Math.round(lightness * 100), alpha);
    }

    /**
     * Helper method to check range.
     * 
     * @param value
     * @return
     */
    private static float range(float value, float max) {
        return value < 0 ? 0 : max < value ? max : value;
    }
}
