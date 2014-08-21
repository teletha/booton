/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.css;

/**
 * @version 2013/07/21 17:18:00
 */
public class Color {

    /** The frequently used color. */
    public static final Color White = new Color(0, 0, 100);

    /** The frequently used color. */
    public static final Color Whity = new Color(0, 0, 97);

    /** The frequently used color. */
    public static final Color WhiteGray = new Color(0, 0, 93);

    /** The frequently used color. */
    public static final Color Black = new Color(0, 0, 0);

    /** The frequently used color. */
    public static final Color Transparent = new Color(0, 0, 0, 0);

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
     * The transparency.
     */
    public final float alpha;

    /**
     * <p>
     * Create new color.
     * </p>
     * 
     * @param hue The attribute of a visual sensation according to which an area appears to be
     *            similar to one of the perceived colors: red, yellow, green, and blue, or to a
     *            combination of two of them .
     * @param saturation The colorfulness of a stimulus relative to its own brightness.
     * @param lightness The brightness relative to the brightness of a similarly illuminated white.
     */
    public Color(int hue, int saturation, int lightness) {
        this(hue, saturation, lightness, 1);
    }

    /**
     * <p>
     * Create new color.
     * </p>
     * 
     * @param hue The attribute of a visual sensation according to which an area appears to be
     *            similar to one of the perceived colors: red, yellow, green, and blue, or to a
     *            combination of two of them .
     * @param saturation The colorfulness of a stimulus relative to its own brightness.
     * @param lightness The brightness relative to the brightness of a similarly illuminated white.
     * @param alpha The transparency.
     */
    public Color(int hue, int saturation, int lightness, double alpha) {
        this.hue = hue % 360;
        this.saturation = (int) range(saturation, 100);
        this.lightness = (int) range(lightness, 100);
        this.alpha = range((float) alpha, 1);
    }

    /**
     * <p>
     * Changes the hue of a color while retaining the lightness and saturation.
     * </p>
     * 
     * @param amount An amount of hue.
     * @return A new color.
     */
    public Color adjustHue(int amount) {
        return new Color(hue + amount, saturation, lightness, alpha);
    }

    /**
     * <p>
     * Makes a color more saturated.
     * </p>
     * 
     * @param amount An amount of saturation.
     * @return A new color.
     */
    public Color saturate(int amount) {
        return new Color(hue, saturation + amount, lightness, alpha);
    }

    /**
     * <p>
     * Makes a color lighter or darker. Positive value makes this color lighter, negative value
     * makes this color darker.
     * </p>
     * 
     * @param amount An amount of lightness.
     * @return A new color.
     */
    public Color lighten(int amount) {
        return new Color(hue, saturation, lightness + amount, alpha);
    }

    /**
     * <p>
     * Makes a color more opaque.
     * </p>
     * 
     * @param amount An amount of transparency.
     * @return A new color.
     */
    public Color opacify(double amount) {
        return new Color(hue, saturation, lightness, alpha + amount);
    }

    /**
     * <p>
     * Converts a color to grayscale. This is qeuivalent to the following method call:
     * </p>
     * 
     * <pre>
     * color.saturate(-100);
     * </pre>
     * 
     * @return A grascaled color.
     */
    public Color grayscale() {
        return saturate(-100);
    }

    /**
     * <p>
     * Returns the complement of a color. This is qeuivalent to the following method call:
     * </p>
     * 
     * <pre>
     * color.adjustHue(180);
     * </pre>
     * 
     * @return A grascaled color.
     */
    public Color complement() {
        return adjustHue(180);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (alpha == 1) {
            if (hue == 0 && saturation == 0) {
                if (lightness == 0) {
                    return "black";
                } else if (lightness == 100) {
                    return "white";
                }
            }
            return "hsl(" + hue + "," + saturation + "%," + lightness + "%)";
        } else {
            return "hsla(" + hue + "," + saturation + "%," + lightness + "%," + (alpha == 0 ? "0" : alpha) + ")";
        }
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
    public static Color rgba(int red, int green, int blue, double alpha) {
        return color(range(red, 255), range(green, 255), range(blue, 255), range((float) alpha, 1));
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
