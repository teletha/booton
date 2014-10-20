/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import java.util.ArrayList;
import java.util.List;

import kiss.I;
import booton.css.CSSProperty;
import booton.css.StyleDeclarable;
import booton.css.Unit;
import booton.css.value.Color;
import booton.css.value.Numeric;
import booton.util.Strings;

/**
 * @version 2013/07/23 13:25:53
 */
public final class Font extends ColorableProperty<Font> {

    /**
     * <p>
     * The font-style CSS property allows italic or oblique faces to be selected within a
     * font-family.
     * </p>
     */
    public final Style style = new Style();

    /**
     * <p>
     * The font-variant CSS property selects a normal, or small-caps face from a font family.
     * Setting font-variant is also possible by using the font shorthand.
     * </p>
     */
    public final Variant variant = new Variant();

    /**
     * <p>
     * The font-weight CSS property specifies the weight or boldness of the font. However, some
     * fonts are not available in all weights; some are available only on normal and bold.
     * </p>
     */
    public final Weight weight = new Weight();

    /**
     * <p>
     * The font-size CSS property specifies the size of the font. Setting the font size may, in
     * turn, change the size of other items, since it is used to compute the value of em and ex
     * length units.
     * </p>
     */
    public final Size size = new Size();

    /**
     * <p>
     * The font-family CSS property allows for a prioritized list of font family names and/or
     * generic family names to be specified for the selected element. Unlike most other CSS
     * properties, values are separated by a comma to indicate that they are alternatives. The
     * browser will select the first font on the list that is installed on the computer, or that can
     * be downloaded using the information provided by a @font-face at-rule.
     * </p>
     */
    public final Family family = new Family();

    /**
     * <p>
     * The CSS color property sets the foreground color of an element's text content, and its
     * decorations. It doesn't affect any other characteristic of the element; it should really be
     * called text-color and would have been named so, save for historical reasons and its
     * appearance in CSS Level 1.
     * </p>
     */
    private Color color;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(StyleDeclarable writer) {
        super.write(writer);

        writer.property("color", color);
    }

    /**
     * <p>
     * The font-size CSS property specifies the size of the font. Setting the font size may, in
     * turn, change the size of other items, since it is used to compute the value of em and ex
     * length units.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Font size(double size, Unit unit) {
        return size(new Numeric(size, unit));
    }

    /**
     * <p>
     * The font-size CSS property specifies the size of the font. Setting the font size may, in
     * turn, change the size of other items, since it is used to compute the value of em and ex
     * length units.
     * </p>
     * 
     * @param value
     * @return
     */
    public Font size(Numeric value) {
        return this.size.set(value);
    }

    /**
     * <p>
     * The font-weight CSS property specifies the weight or boldness of the font. However, some
     * fonts are not available in all weights; some are available only on normal and bold.
     * </p>
     * <p>
     * Numeric font weights for fonts that provide more than just normal and bold. If the exact
     * weight given is unavailable, then 600-900 use the closest available darker weight (or, if
     * there is none, the closest available lighter weight), and 100-500 use the closest available
     * lighter weight (or, if there is none, the closest available darker weight). This means that
     * for fonts that provide only normal and bold, 100-500 are normal, and 600-900 are bold.
     * </p>
     * 
     * @param size
     * @return
     */
    public Font weight(int size) {
        return weight.number(size);
    }

    /**
     * <p>
     * The font-family CSS property allows for a prioritized list of font family names and/or
     * generic family names to be specified for the selected element. Unlike most other CSS
     * properties, values are separated by a comma to indicate that they are alternatives. The
     * browser will select the first font on the list that is installed on the computer, or that can
     * be downloaded using the information provided by a @font-face at-rule.
     * </p>
     * <p>
     * Web authors should always add at least one generic family in a font-family list, since
     * there's no guarantee that a specific font is intalled on the computer or can be downloaded
     * using a @font-face at-rule. The generic family lets the browser select an acceptable fallback
     * font when needed.
     * </p>
     * 
     * @param persons
     * @return
     */
    public Family family(String... fonts) {
        for (String font : fonts) {
            family.add(font);
        }
        return family;
    }

    /**
     * <p>
     * The font-family CSS property allows for a prioritized list of font family names and/or
     * generic family names to be specified for the selected element. Unlike most other CSS
     * properties, values are separated by a comma to indicate that they are alternatives. The
     * browser will select the first font on the list that is installed on the computer, or that can
     * be downloaded using the information provided by a @font-face at-rule.
     * </p>
     * <p>
     * Web authors should always add at least one generic family in a font-family list, since
     * there's no guarantee that a specific font is intalled on the computer or can be downloaded
     * using a @font-face at-rule. The generic family lets the browser select an acceptable fallback
     * font when needed.
     * </p>
     * 
     * @param fonts
     * @return
     */
    public Family family(booton.css.value.Font... fonts) {
        for (booton.css.value.Font font : fonts) {
            family.add(font.name);
        }
        return family;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color color() {
        return color == null ? Color.Black : color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font color(Color color) {
        this.color = color;

        return chain();
    }

    /**
     * @version 2012/12/12 10:53:02
     */
    public class Size extends CSSProperty<Font> {

        /**
         * 
         */
        private Size() {
            super("font-size", Font.this);
        }

        /**
         * <p>
         * Set numerical value.
         * </p>
         * 
         * @param value
         * @return
         */
        private Font set(Numeric value) {
            return chain(value.toString());
        }

        /**
         * <p>
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * </p>
         * 
         * @return
         */
        public Font xxsmall() {
            return chain("xx-small");
        }

        /**
         * <p>
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * </p>
         * 
         * @return
         */
        public Font xsmall() {
            return chain("x-small");
        }

        /**
         * <p>
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * </p>
         * 
         * @return
         */
        public Font small() {
            return chain("small");
        }

        /**
         * <p>
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * </p>
         * 
         * @return
         */
        public Font medium() {
            return chain("medium");
        }

        /**
         * <p>
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * </p>
         * 
         * @return
         */
        public Font large() {
            return chain("large");
        }

        /**
         * <p>
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * </p>
         * 
         * @return
         */
        public Font xlarge() {
            return chain("x-large");
        }

        /**
         * <p>
         * A set of absolute size keywords based on the user's default font size (which is medium).
         * Similar to presentational HTML's &lt;font size="1"&gt; through &lt;font size="7"&gt;
         * where the user's default font size is &lt;font size="3"&gt;.
         * </p>
         * 
         * @return
         */
        public Font xxlarge() {
            return chain("xx-large");
        }

        /**
         * <p>
         * Larger or smaller than the parent element's font size, by roughly the ratio used to
         * separate the absolute size keywords above.
         * </p>
         * 
         * @return
         */
        public Font larger() {
            return chain("larger");
        }

        /**
         * <p>
         * Larger or smaller than the parent element's font size, by roughly the ratio used to
         * separate the absolute size keywords above.
         * </p>
         * 
         * @return
         */
        public Font smaller() {
            return chain("smaller");
        }
    }

    /**
     * @version 2012/12/12 10:49:48
     */
    public class Style extends CSSProperty<Font> {

        /**
         * 
         */
        private Style() {
            super("font-style", Font.this);
        }

        /**
         * <p>
         * selects a font that is classified as normal within a font-family
         * </p>
         * 
         * @return
         */
        public Font normal() {
            return chain("normal");
        }

        /**
         * <p>
         * selects a font that is labeled italic, if that is not available, one labeled oblique
         * </p>
         * 
         * @return
         */
        public Font italic() {
            return chain("italic");
        }

        /**
         * <p>
         * selects a font that is labeled oblique
         * </p>
         * 
         * @return
         */
        public Font oblique() {
            return chain("oblique");
        }
    }

    /**
     * @version 2012/12/12 11:19:52
     */
    public class Weight extends CSSProperty<Font> {

        /**
         * 
         */
        private Weight() {
            super("font-weight", Font.this);
        }

        /**
         * <p>
         * Normal font weight. Same as 400.
         * </p>
         * 
         * @return
         */
        public Font normal() {
            return chain("normal");
        }

        /**
         * <p>
         * Bold font weight. Same as 700.
         * </p>
         * 
         * @return
         */
        public Font bold() {
            return chain("bold");
        }

        /**
         * <p>
         * One font weight lighter than the parent element (among the available weights of the
         * font).
         * </p>
         * 
         * @return
         */
        public Font lighter() {
            return chain("lighter");
        }

        /**
         * <p>
         * One font weight darker than the parent element (among the available weights of the font).
         * </p>
         * 
         * @return
         */
        public Font bolder() {
            return chain("bolder");
        }

        /**
         * <p>
         * The font-weight CSS property specifies the weight or boldness of the font. However, some
         * fonts are not available in all weights; some are available only on normal and bold.
         * </p>
         * <p>
         * Numeric font weights for fonts that provide more than just normal and bold. If the exact
         * weight given is unavailable, then 600-900 use the closest available darker weight (or, if
         * there is none, the closest available lighter weight), and 100-500 use the closest
         * available lighter weight (or, if there is none, the closest available darker weight).
         * This means that for fonts that provide only normal and bold, 100-500 are normal, and
         * 600-900 are bold.
         * </p>
         * 
         * @param size
         * @return
         */
        private Font number(int size) {
            return chain(String.valueOf(size));
        }
    }

    /**
     * @version 2012/12/12 10:40:16
     */
    public class Variant extends CSSProperty<Font> {

        /**
         * 
         */
        private Variant() {
            super("font-variant", Font.this);
        }

        /**
         * <p>
         * Specifies a font that is labeled as a small-caps font. If a small-caps font is not
         * available, Mozilla (Firefox) and other browsers will simulate a small-caps font, i.e. by
         * taking a normal font and replacing the lowercase letters by scaled uppercase characters.
         * </p>
         * 
         * @return
         */
        public Font smallCaps() {
            return chain("small-caps");
        }

        /**
         * <p>
         * Specifies a normal font face.
         * </p>
         * 
         * @return
         */
        public Font normal() {
            return chain("normal");
        }
    }

    /**
     * @version 2012/12/16 12:01:27
     */
    public class Family extends CSSProperty<Font> {

        /** The value list. */
        private final List<String> names = new ArrayList();

        /**
         * Hide constructor.
         */
        private Family() {
            super("font-family", Font.this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void write(StyleDeclarable writer) {
            writer.property(name, I.join(",", names));
        }

        /**
         * <p>
         * Glyphs have finishing strokes, flared or tapering ends, or have actual serifed endings.
         * E.g. Palatino, "Palatino Linotype", Palladio, "URW Palladio", serif
         * </p>
         * 
         * @return
         */
        public Font serif() {
            names.add("serif");

            return chain();
        }

        /**
         * <p>
         * Glyphs have stroke endings that are plain. E.g. 'Trebuchet MS', 'Liberation Sans',
         * 'Nimbus Sans L', sans-serif
         * </p>
         * 
         * @return
         */
        public Font sansSerif() {
            names.add("sans-serif");

            return chain();
        }

        /**
         * <p>
         * Glyphs in cursive fonts generally have either joining strokes or other cursive
         * characteristics beyond those of italic typefaces. The glyphs are partially or completely
         * connected, and the result looks more like handwritten pen or brush writing than printed
         * letterwork.
         * </p>
         * 
         * @return
         */
        public Font cursive() {
            names.add("cursive");

            return chain();
        }

        /**
         * <p>
         * Fantasy fonts are primarily decorative fonts that contain playful representations of
         * characters.
         * </p>
         * 
         * @return
         */
        public Font fantasy() {
            names.add("fantasy");

            return chain();
        }

        /**
         * <p>
         * All glyphs have the same fixed width. E.g. "DejaVu Sans Mono", Menlo, Consolas,
         * "Liberation Mono", Monaco, "Lucida Console", monospace
         * </p>
         * 
         * @return
         */
        public Font monospace() {
            names.add("monospace");

            return chain();
        }

        /**
         * <p>
         * Add font name.
         * </p>
         * 
         * @param name
         * @return
         */
        private Font add(String name) {
            if (Strings.hasSpace(name)) {
                names.add('"' + name + '"');
            } else {
                names.add(name);
            }
            return chain();
        }
    }
}
