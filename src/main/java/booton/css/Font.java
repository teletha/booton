/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import booton.util.Strings;

/**
 * @version 2012/12/12 10:34:10
 */
public class Font extends CSSProperty<Font> {

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

    /** The font family. */
    private String family;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return property("font-family", family) + style + variant + size + weight;
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
        return this.size.size(size, unit);
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
        return weight.chain(String.valueOf(size));
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
     * @param names
     * @return
     */
    public Font family(String... names) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            boolean space = Strings.hasSpace(names[i]);

            if (space) builder.append('"');
            builder.append(names[i]);
            if (space) builder.append('"');

            if (i != names.length - 1) {
                builder.append(' ');
            }
        }
        family = builder.toString();

        return chain();
    }

    /**
     * @version 2012/12/12 10:53:02
     */
    public class Size extends Length<Font> {

        /**
         * 
         */
        private Size() {
            super("font-size", Font.this);
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
    public class Style extends AbstractInheritable<Font> {

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
            return chain("normal");
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
            return chain("normal");
        }

        /**
         * <p>
         * One font weight darker than the parent element (among the available weights of the font).
         * </p>
         * 
         * @return
         */
        public Font bolder() {
            return chain("normal");
        }
    }

    /**
     * @version 2012/12/12 10:40:16
     */
    public class Variant extends AbstractInheritable<Font> {

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
}
