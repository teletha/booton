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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import kiss.Extensible;
import kiss.I;
import booton.translator.Javascript;
import booton.util.RGB;
import booton.util.Strings;

/**
 * @version 2012/12/11 23:59:41
 */
public class CSS implements Extensible {

    /**
     * <p>
     * The 'em' unit is equal to the computed value of the 'font-size' property of the element on
     * which it is used. The exception is when 'em' occurs in the value of the 'font-size' property
     * itself, in which case it refers to the font size of the parent element. It may be used for
     * vertical or horizontal measurement. (This unit is also sometimes called the quad-width in
     * typographic texts.)
     * </p>
     */
    protected static final Unit em = new Unit("em");

    /**
     * <p>
     * The 'ex' unit is defined by the element's first available font. The 'x-height' is so called
     * because it is often equal to the height of the lowercase "x". However, an 'ex' is defined
     * even for fonts that don't contain an "x".
     * </p>
     */
    protected static final Unit ex = new Unit("ex");

    /**
     * <p>
     * The x-height of a font can be found in different ways. Some fonts contain reliable metrics
     * for the x-height. If reliable font metrics are not available, UAs may determine the x-height
     * from the height of a lowercase glyph. One possible heuristics is to look at how far the glyph
     * for the lowercase "o" extends below the baseline, and subtract that value from the top of its
     * bounding box. In the cases where it is impossible or impractical to determine the x-height, a
     * value of 0.5em should be used.
     * </p>
     */
    protected static final Unit px = new Unit("px");

    /**
     * <p>
     * The x-height of a font can be found in different ways. Some fonts contain reliable metrics
     * for the x-height. If reliable font metrics are not available, UAs may determine the x-height
     * from the height of a lowercase glyph. One possible heuristics is to look at how far the glyph
     * for the lowercase "o" extends below the baseline, and subtract that value from the top of its
     * bounding box. In the cases where it is impossible or impractical to determine the x-height, a
     * value of 0.5em should be used.
     * </p>
     */
    protected static final Unit in = new Unit("in");

    /**
     * <p>
     * The format of a percentage value (denoted by <percentage> in this specification) is a
     * <number> immediately followed by '%'.
     * </p>
     * <p>
     * Percentage values are always relative to another value, for example a length. Each property
     * that allows percentages also defines the value to which the percentage refers. The value may
     * be that of another property for the same element, a property for an ancestor element, or a
     * value of the formatting context (e.g., the width of a containing block). When a percentage
     * value is set for a property of the root element and the percentage is defined as referring to
     * the inherited value of some property, the resultant value is the percentage times the initial
     * value of that property.
     * </p>
     */
    protected static final Unit percent = new Unit("%");

    /**
     * <p>
     * The display CSS property specifies the type of rendering box used for an element. In HTML,
     * default display property values are taken from behaviors described in the HTML specifications
     * or from the browser/user default stylesheet. The default value in XML is inline.
     * </p>
     * <p>
     * In addition to the many different display box types, the value none lets you turn off the
     * display of an element; when you use none, all child elements also have their display turned
     * off. The document is rendered as though the element doesn't exist in the document tree.
     * </p>
     */
    public Display display;

    /**
     * <p>
     * The width CSS property specifies the width of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-width and max-width properties override width.
     * </p>
     * 
     * @param size
     * @param unit
     */
    public Width width;

    /**
     * <p>
     * The height CSS property specifies the height of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-height and max-height properties override height.
     * </p>
     */
    public Length height;

    /**
     * <p>
     * The margin CSS property sets the margin for all four sides. It is a shorthand to avoid
     * setting each side separately with the other margin properties: margin-top, margin-right,
     * margin-bottom and margin-left. Negative value are also allowed.
     * </p>
     * <p>
     * One single value applies to all four sides.
     * </p>
     */
    public BoxLength margin;

    /**
     * <p>
     * The padding CSS property sets the required padding space on all sides of an element. The
     * padding area is the space between the content of the element and its border. Negative values
     * are not allowed.
     * </p>
     * <p>
     * The padding property is a shorthand to avoid setting each side separately (padding-top,
     * padding-right, padding-bottom, padding-left).
     * </p>
     */
    public BoxLength padding;

    /**
     * <p>
     * The CSS outline property is a shorthand property for setting one or more of the individual
     * outline properties outline-style, outline-width and outline-color in a single rule. In most
     * cases the use of this shortcut is preferable and more convenient.
     * </p>
     * <p>
     * Outlines differ from borders in the following ways:
     * </p>
     * <ul>
     * <li>Outlines do not take up space, they are drawn above the content.</li>
     * <li>Outlines may be non-rectangular. They are rectangular in Gecko/Firefox. But e.g. Opera
     * draws a non-rectangular shape around a construct like this:</li>
     * </ul>
     */
    public Border outline;

    /**
     * <p>
     * The background CSS property is a shorthand for setting the individual background values in a
     * single place in the style sheet. background can be used to set the values for one or more of:
     * background-color, background-image, background-position, background-repeat, background-size,
     * </p>
     */
    public Background background;

    /**
     * <p>
     * The position CSS property chooses alternative rules for positioning elements, designed to be
     * useful for scripted animation effects.
     * </p>
     */
    public Position position;

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     */
    public Length lineHeight;

    /**
     * <p>
     * The font CSS property is either a shorthand property for setting font-style, font-variant,
     * font-weight, font-size, line-height and font-family, or a way to set the element's font to a
     * system font, using specific keywords.
     * </p>
     */
    public Font font;

    /**
     * <p>
     * The CSS color property sets the foreground color of an element's text content, and its
     * decorations. It doesn't affect any other characteristic of the element; it should really be
     * called text-color and would have been named so, save for historical reasons and its
     * appearance in CSS Level 1.
     * </p>
     */
    public Color color;

    /**
     * <p>
     * The text-shadow CSS property adds shadows to text. It accepts a comma-separated list of
     * shadows to be applied to the text and text-decorations of the element.
     * </p>
     * <p>
     * Each shadow is specified as an offset from the text, along with optional color and blur
     * radius values.
     * </p>
     * <p>
     * Multiple shadows are applied front-to-back, with the first-specified shadow on top.
     * </p>
     */
    public TextShadow textShadow;

    /**
     * <p>
     * The text-align CSS property describes how inline content like text is aligned in its parent
     * block element. text-align does not control the alignment of block elements itself, only their
     * inline content.
     * </p>
     */
    public TextAlign textAlign;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public Border border;

    /**
     * <p>
     * The text-indent CSS property specifies how much horizontal space should be left before the
     * beginning of the first line of the text content of an element. Horizontal spacing is with
     * respect to the left (or right, for right-to-left layout) edge of the containing block
     * element's box.
     * </p>
     */
    public Length textIndent;

    /**
     * <p>
     * The border-radius CSS property allows Web authors to define how rounded border corners are.
     * The curve of each corner is defined using one or two radii, defining its shape: circle or
     * ellipse.
     * </p>
     */
    public Length borderRadius;

    /**
     * <p>
     * The CSS property pointer-events allows authors to control under what circumstances (if any) a
     * particular graphic element can become the target of mouse events. When this property is
     * unspecified, the same characteristics of the visiblePainted value apply to SVG content.
     * </p>
     */
    public PointerEvents pointerEvents;

    /**
     * <p>
     * The box-shadow CSS property describes one or more shadow effects as a comma-separated list.
     * It allows casting a drop shadow from the frame of almost any element. If a border-radius is
     * specified on the element with a box shadow, the box shadow takes on the same rounded corners.
     * The z-ordering of multiple box shadows is the same as multiple text shadows (the first
     * specified shadow is on top).
     * </p>
     */
    public BoxShadow boxShadow;

    /**
     * <p>
     * The top CSS property specifies part of the position of positioned elements. It has no effect
     * on non-positioned elements. For absolutely positioned elements (those with position: absolute
     * or position: fixed), it specifies the distance between the top margin edge of the element and
     * the top edge of its containing block. For relatively positioned elements (those with
     * position: relative), it specifies the amount the element is moved below its normal position.
     * When both top and bottom are specified, the element position is over-constrained and the top
     * property has precedence: the computed value of bottom is set to -top, while its specified
     * value is ignored.
     * </p>
     */
    public Length top;

    /**
     * <p>
     * The bottom CSS property participates in specifying the position of positioned elements. For
     * absolutely positioned elements, that is those with position: absolute or position: fixed, it
     * specifies the distance between the bottom margin edge of the element and the bottom edge of
     * its containing block. For relatively positioned elements, that is those with position:
     * relative, it specifies the distance the element is moved above its normal position. However,
     * the top property overrides the bottom property, so if top is not auto, the computed value of
     * bottom is the negative of the computed value of top.
     * </p>
     */
    public Length bottom;

    /**
     * <p>
     * The left CSS property specifies part of the position of positioned elements.
     * </p>
     * <p>
     * For absolutely positioned elements (those with position: absolute or position: fixed), it
     * specifies the distance between the left margin edge of the element and the left edge of its
     * containing block.
     * </p>
     */
    public Length left;

    /**
     * <p>
     * The right CSS property specifies part of the position of positioned elements. For absolutely
     * positioned elements (those with position: absolute or position: fixed), it specifies the
     * distance between the right margin edge of the element and the right edge of its containing
     * block. The right property has no effect on non-positioned elements. When both the right CSS
     * property and the left CSS property are defined, the position of the element is overspecified.
     * In that case, the left value has precedence when the container is left-to-right (that is that
     * the right computed value is set to -left), and the right value has precedence when the
     * container is right-to-left (that is that the left computed value is set to -right).
     * </p>
     */
    public Length right;

    /**
     * <p>
     * The opacity CSS property specifies the transparency of an element, that is, the degree to
     * which the background behind the element is overlaid. Using this property with a value
     * different than 1 places the element in a new stacking context.
     * </p>
     */
    public Alpha opacity;

    /** The rule set store. */
    private final Map<String, Set<CSSProperty>> rules = new TreeMap();

    /** The selector. */
    private String selector;

    /**
     * <p>
     * Create css rule writer.
     * </p>
     */
    protected CSS() {
        load("");

        selector = Javascript.computeClassName(getClass()).substring(5);
    }

    /**
     * Load rule set for the specified mode.
     * 
     * @param mode
     */
    private void load(String mode) {
        try {
            Set<CSSProperty> rule = rules.get(mode);

            if (rule == null) {
                // create new mode
                rule = new TreeSet(new PropertySorter());

                for (Field field : CSS.class.getFields()) {
                    Object value;
                    Class type = field.getType();

                    try {
                        Constructor constructor = type.getDeclaredConstructor(String.class);
                        value = constructor.newInstance(Strings.hyphenate(field.getName()));
                    } catch (NoSuchMethodException e) {
                        value = type.newInstance();
                    }
                    rule.add((CSSProperty) value);
                }
                rules.put(mode, rule);
            }

            // load and assign
            for (CSSProperty property : rule) {
                CSS.class.getField(Strings.unhyphenate(property.name)).set(this, property);
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    private final Set<CSS> subs = new LinkedHashSet();

    /**
     * <p>
     * Create sub rule set.
     * </p>
     * 
     * @param selector
     * @return
     */
    protected final CSS sub(String selector) {
        CSS sub = new CSS();
        sub.selector = this.selector + " " + selector;
        subs.add(sub);

        return sub;
    }

    private boolean hovered = false;

    protected final boolean hover() {
        if (hovered) {
            load("");
            return hovered = false;
        } else {
            load(":hover");
            return hovered = true;
        }
    }

    private void writeTo(StringBuilder builder) {
        for (Entry<String, Set<CSSProperty>> entry : rules.entrySet()) {
            builder.append('.').append(selector).append(entry.getKey()).append(" {\r\n");

            for (CSSProperty property : entry.getValue()) {
                if (property.used) {
                    builder.append("  ").append(property).append("\r\n");
                }
            }
            builder.append("}\r\n");

            for (CSS sub : subs) {

            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        writeTo(builder);

        for (CSS sub : subs) {
            sub.writeTo(builder);
        }
        return builder.toString();
    }

    /**
     * <p>
     * Helper method to create RGB color code.
     * </p>
     * 
     * @param red
     * @param green
     * @param blue
     * @param alpha
     * @return
     */
    protected static final RGB rgba(int red, int green, int blue, double alpha) {
        return new RGB(red, green, blue, alpha);
    }

    /**
     * @version 2012/12/13 1:39:08
     */
    private static class PropertySorter implements Comparator<CSSProperty> {

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(CSSProperty o1, CSSProperty o2) {
            return o1.name.compareTo(o2.name);
        }
    }
}
