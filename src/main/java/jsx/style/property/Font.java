/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringJoiner;

import jsx.style.PropertyDefinition;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import kiss.I;
import booton.translator.Translator;
import booton.util.Strings;

/**
 * @version 2014/10/28 22:38:23
 */
public class Font extends Colorable<Font> {

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
     * {@inheritDoc}
     */
    @Override
    public Font color(Color color) {
        value("color", color.toString());

        return this;
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
        for (int i = 0; i < fonts.length; i++) {
            if (fonts[i].startsWith("http")) {
                fonts[i] = FontInfo.parse(fonts[i]);
            }

            if (Strings.hasSpace(fonts[i])) {
                fonts[i] = "\"" + fonts[i] + "\"";
            }
        }
        return new Family(fonts);
    }

    /**
     * @version 2014/10/28 22:38:44
     */
    public class Size extends PropertyDefinition<Font> {

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
            return value(value.toString());
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
            return value("xx-small");
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
            return value("x-small");
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
            return value("small");
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
            return value("medium");
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
            return value("large");
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
            return value("x-large");
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
            return value("xx-large");
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
            return value("larger");
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
            return value("smaller");
        }
    }

    /**
     * @version 2014/10/28 22:39:08
     */
    public class Style extends PropertyDefinition<Font> {

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
            return value("normal");
        }

        /**
         * <p>
         * selects a font that is labeled italic, if that is not available, one labeled oblique
         * </p>
         * 
         * @return
         */
        public Font italic() {
            return value("italic");
        }

        /**
         * <p>
         * selects a font that is labeled oblique
         * </p>
         * 
         * @return
         */
        public Font oblique() {
            return value("oblique");
        }
    }

    /**
     * @version 2014/10/28 22:39:12
     */
    public class Weight extends PropertyDefinition<Font> {

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
            return value("normal");
        }

        /**
         * <p>
         * Bold font weight. Same as 700.
         * </p>
         * 
         * @return
         */
        public Font bold() {
            return value("bold");
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
            return value("lighter");
        }

        /**
         * <p>
         * One font weight darker than the parent element (among the available weights of the font).
         * </p>
         * 
         * @return
         */
        public Font bolder() {
            return value("bolder");
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
            return value(String.valueOf(size));
        }
    }

    /**
     * @version 2014/10/28 22:39:17
     */
    public class Variant extends PropertyDefinition<Font> {

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
            return value("small-caps");
        }

        /**
         * <p>
         * Specifies a normal font face.
         * </p>
         * 
         * @return
         */
        public Font normal() {
            return value("normal");
        }
    }

    /**
     * @version 2014/10/29 2:16:13
     */
    public class Family extends PropertyDefinition<Font> {

        /** The user specified. */
        private final String[] fonts;

        /**
         * Hide constructor.
         */
        private Family(String[] fonts) {
            super("font-family", Font.this);

            this.fonts = fonts;
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
            return value(join("serif"));
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
            return value(join("sans-serif"));
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
            return value(join("cursive"));
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
            return value(join("fantasy"));
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
            return value(join("monospace"));
        }

        private String join(String addition) {
            StringJoiner joiner = new StringJoiner(",");

            for (String font : fonts) {
                joiner.add(font);
            }
            joiner.add(addition);

            return joiner.toString();
        }
    }

    /**
     * @version 2014/10/29 0:40:24
     */
    private static class FontInfo {

        /**
         * <p>
         * Locate font.
         * </p>
         * 
         * @param uri
         * @return
         */
        static String parse(String uri) {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                URLConnection connection = new URL(uri).openConnection();
                connection.connect();
                I.copy(connection.getInputStream(), out, true);

                String contents = out.toString();
                int start = contents.indexOf("font-family");
                int end = contents.indexOf(";", start);

                String name = contents.substring(start + 11, end).trim();

                if (name.charAt(0) == ':') {
                    name = name.substring(1).trim();
                }

                if (name.charAt(0) == '\'') {
                    name = name.substring(1, name.length() - 1);
                }

                return name;
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }

        /**
         * @version 2014/10/13 17:55:12
         */
        @SuppressWarnings("unused")
        private static class Coder extends Translator<FontInfo> {

            /**
             * <p>
             * Locate font.
             * </p>
             * 
             * @param uri
             * @return
             */
            public String parse(String uri) {
                return "['" + uri + "','" + uri + "']";
            }
        }
    }
}
