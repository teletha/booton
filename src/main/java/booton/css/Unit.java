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
 * @version 2009/08/25 20:41:14
 */
public enum Unit {
    /**
     * This unit represents the calculated font-size of the element. If used on the font-size
     * property itself, it represents the inherited font-size of the element.
     */
    em,

    /**
     * This unit represents the x-height of the element's font. On fonts with the 'x' letter, this
     * is generally the height of lowercase letters in the font; 1ex ≈ 0.5em in many fonts.
     */
    ex,

    /**
     * This unit represents the width, or more precisely the advance measure, of the glyph '0'
     * (zero, the Unicode character U+0030) in the element's font.
     */
    ch,

    /**
     * This unit represents the font-size of the root element (e.g. the font-size of the <html>
     * element). When used on the font-size on this root element, it represents its initial value.
     */
    rem,

    /**
     * 1/100th of the height of the viewport.
     */
    vh,

    /**
     * 1/100th of the width of the viewport.
     */
    vw,

    /**
     * 1/100th of the minimum value between the height and the width of the viewport.
     */
    vmin,

    /**
     * 1/100th of the maximum value between the height and the width of the viewport.
     */
    vmax,

    /**
     * Relative to the viewing device. For screen display, typically one device pixel (dot) of the
     * display. For printers and very high resolution screens one CSS pixel implies multiple device
     * pixels, so that the number of pixel per inch stays around 96.
     */
    px,

    /**
     * One millimeter.
     */
    mm,

    /**
     * One centimeter (10 millimeters).
     */
    cm,

    /**
     * One inch (2.54 centimeters).
     */
    in,

    /**
     * One point (which is 1/72 of an inch).
     */
    pt,

    /**
     * One pica (which is 12 points).
     */
    pc,

    /**
     * The <percentage> CSS data types represent a percentage value. Many CSS properties can take
     * percentage values, often to define sizes in terms of parent objects. Percentages are formed
     * by a <number> immediately followed by the percentage sign %. Like for all unit in CSS, there
     * is no space between the '%' and the number.
     */
    Percentage("%"),

    /**
     * a time in seconds. E.g. 0s, 1.5s, -60s.
     */
    Second("s"),

    /**
     * a time in milliseconds. E.g. 0ms, 1500ms, -60000ms.
     */
    MillSecond("ms");

    /** The unit representaion. */
    private final String unit;

    /**
     * 
     */
    private Unit() {
        this(null);
    }

    /**
     * @param unit
     */
    private Unit(String unit) {
        if (unit == null) {
            unit = name().toLowerCase();
        }
        this.unit = unit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return unit;
    }
}
