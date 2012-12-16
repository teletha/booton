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
import java.util.Set;
import java.util.TreeSet;

import kiss.Extensible;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import booton.css.property.Background;
import booton.css.property.Box;
import booton.css.property.BoxLength;
import booton.css.property.Content;
import booton.css.property.Display;
import booton.css.property.Font;
import booton.css.property.ListStyle;
import booton.css.property.PointerEvents;
import booton.css.property.Position;
import booton.css.property.Text;
import booton.css.property.Transition;
import booton.css.property.Visibility;
import booton.css.value.Border;
import booton.css.value.Gradient;
import booton.css.value.Length;
import booton.translator.Javascript;
import booton.util.Color;
import booton.util.Strings;

/**
 * @version 2012/12/11 23:59:41
 */
@Manageable(lifestyle = Singleton.class)
public class CSS<T> implements Extensible {

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
     * The x-height of a font can be found in different ways. Some fonts contain reliable metrics
     * for the x-height. If reliable font metrics are not available, UAs may determine the x-height
     * from the height of a lowercase glyph. One possible heuristics is to look at how far the glyph
     * for the lowercase "o" extends below the baseline, and subtract that value from the top of its
     * bounding box. In the cases where it is impossible or impractical to determine the x-height, a
     * value of 0.5em should be used.
     * </p>
     */
    protected static final Unit s = new Unit("s");

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
    protected static final Unit ms = new Unit("ms");

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
     * The width, height and box-sizing property.
     * </p>
     */
    public Box box;

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
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public Border border;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public Border borderLeft;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public Border borderRight;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public Border borderTop;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public Border borderBottom;

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
     * The CSS property pointer-events allows authors to control under what circumstances (if any) a
     * particular graphic element can become the target of mouse events. When this property is
     * unspecified, the same characteristics of the visiblePainted value apply to SVG content.
     * </p>
     */
    public PointerEvents pointerEvents;

    /**
     * <p>
     * The content CSS property is used with the ::before and ::after pseudo-elements to generate
     * content in an element. Objects inserting using the content property are anonymous replaced
     * elements.
     * </p>
     */
    public Content content;

    /**
     * <p>
     * The CSS transition property is a shorthand property for transition-property,
     * transition-duration, transition-timing-function, and transition-delay. It allows to define
     * the transition between two states of an element.
     * </p>
     */
    public Transition transition;

    /**
     * <p>
     * The list-style CSS property is a shorthand property for setting list-style-type,
     * list-style-image and list-style-position.
     * </p>
     */
    public ListStyle listStyle;

    /** The text related style. */
    public Text text;

    /**
     * <p>
     * The visibility CSS property has two purposes:
     * </p>
     */
    public Visibility visibility;

    /** The current procesing rule set. */
    private RuleSet rules = new RuleSet(getClass());

    /**
     * Create user css.
     */
    protected CSS() {
        load(rules);
    }

    /**
     * <p>
     * Create sub rule set.
     * </p>
     * 
     * @param selector
     * @return
     */
    protected final boolean rule(String selector) {
        // dirty usage
        int id = new Error().getStackTrace()[1].getLineNumber();

        if (rules.id == id) {
            rules.id = -1;

            // restore parent rule set
            load(rules.parent);

            return false;
        } else {
            // create sub rule set
            load(new RuleSet(rules, selector));

            // update position info
            rules.id = id;

            return true;
        }
    }

    /**
     * Load all properties.
     * 
     * @param mode
     */
    private void load(RuleSet set) {
        try {
            // update current rule set
            rules = set;

            // load property and assign it to field
            for (CSSProperty property : set.rules) {
                CSS.class.getField(Strings.unhyphenate(property.name)).set(this, property);
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        rules.writeTo("", builder);

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
    protected static final Color rgba(int red, int green, int blue, double alpha) {
        return new Color(red, green, blue, alpha);
    }

    protected static final Color color(String hex) {
        return new Color(hex);
    }

    /**
     * <p>
     * The CSS linear-gradient() function creates an <image> which represents a linear gradient of
     * colors. The result of this function is an object of the CSS <gradient> data type. Like any
     * other gradient, a CSS linear gradient is not a CSS <color> but an image with no intrinsic
     * dimensions; that is, it has no natural or preferred size, nor ratio. Its concrete size will
     * match the one of the element it applies to.
     * </p>
     * 
     * @return
     */
    protected static final Gradient linear(String start, String end) {
        return linear(new Color(start), new Color(end));
    }

    /**
     * <p>
     * The CSS linear-gradient() function creates an <image> which represents a linear gradient of
     * colors. The result of this function is an object of the CSS <gradient> data type. Like any
     * other gradient, a CSS linear gradient is not a CSS <color> but an image with no intrinsic
     * dimensions; that is, it has no natural or preferred size, nor ratio. Its concrete size will
     * match the one of the element it applies to.
     * </p>
     * 
     * @return
     */
    protected static final Gradient linear(Color start, Color end) {
        return new Gradient(start, end);
    }

    /**
     * <p>
     * Apply bubble border box style.
     * </p>
     * 
     * @param boxWidth
     * @param borderWidth
     * @param bubbleWidth
     */
    protected void bubble(double boxWidth, double borderWidth, double bubbleWidth) {
        position.absolute().left(50, percent);
        box.width(boxWidth, px);
        margin.left(-boxWidth / 2, px);
        border.width(borderWidth, px).solid().color(5, 5, 5);

        while (rule(("::before"))) {
            display.block();
            box.width(0, px).height(0, px);
            content.text("");
            position.absolute()
                    .bottom(-bubbleWidth - borderWidth - bubbleWidth, px)
                    .left(boxWidth / 2 - borderWidth - bubbleWidth, px);
            border.width(bubbleWidth, px).solid().color.transparent();
            borderTop.color.black().width(bubbleWidth, px).solid();
        }
    }

    /**
     * @version 2012/12/13 10:02:01
     */
    private static class RuleSet {

        /** The parent rule set. */
        private final RuleSet parent;

        /** The selector. */
        private final String selector;

        /** The property store. */
        private final Set<CSSProperty> rules = new TreeSet(new PropertySorter());

        /** The flag whether this rule set process sub rule or not. */
        private int id = -1;

        /** The sub rule sets. */
        private final Set<RuleSet> subs = new LinkedHashSet();

        /**
         * <p>
         * Create top level rule set.
         * </p>
         */
        protected RuleSet(Class clazz) {
            this(null, "." + Javascript.computeClassName(clazz).substring(5));
        }

        /**
         * <p>
         * Create sub css rule.
         * </p>
         */
        private RuleSet(RuleSet parent, String selector) {
            this.parent = parent;
            this.selector = selector;

            // store as sub rule in parent rule
            if (parent != null) {
                parent.subs.add(this);
            }

            // create all properties
            try {
                for (Field field : CSS.class.getFields()) {
                    Object value;
                    Class type = field.getType();

                    try {
                        Constructor constructor = type.getDeclaredConstructor(String.class);
                        value = constructor.newInstance(Strings.hyphenate(field.getName()));
                    } catch (NoSuchMethodException e) {
                        value = type.newInstance();
                    }
                    rules.add((CSSProperty) value);
                }
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }

        /**
         * <p>
         * Write out properties.
         * </p>
         * 
         * @param prefix
         * @param builder
         */
        private void writeTo(String prefix, StringBuilder builder) {
            if (prefix.length() != 0 && !selector.startsWith(":")) {
                prefix = prefix + " ";
            }
            prefix = prefix + selector;

            builder.append(prefix).append(" {\r\n");

            for (CSSProperty property : rules) {
                if (property.used) {
                    builder.append("  ").append(property).append("\r\n");
                }
            }
            builder.append("}\r\n");

            for (RuleSet sub : subs) {
                sub.writeTo(prefix, builder);
            }
        }
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

    protected class POO {

    }
}
