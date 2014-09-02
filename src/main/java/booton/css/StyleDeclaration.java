/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import kiss.I;
import booton.css.property.AlignContent;
import booton.css.property.AlignItems;
import booton.css.property.Background;
import booton.css.property.Borders;
import booton.css.property.Box;
import booton.css.property.BoxLength;
import booton.css.property.Content;
import booton.css.property.Cursor;
import booton.css.property.Display;
import booton.css.property.FlexDirection;
import booton.css.property.FlexWrap;
import booton.css.property.Font;
import booton.css.property.JustifyContent;
import booton.css.property.Line;
import booton.css.property.ListStyle;
import booton.css.property.Overflows;
import booton.css.property.PointerEvents;
import booton.css.property.Position;
import booton.css.property.Text;
import booton.css.property.Transform;
import booton.css.property.Transition;
import booton.css.property.UserSelect;
import booton.css.property.Visibility;
import booton.css.value.Color;
import booton.css.value.LinearGradient;
import booton.css.value.RadialGradient;
import booton.util.Strings;

/**
 * @version 2014/09/02 15:51:03
 */
public class StyleDeclaration {

    /**
     * <p>
     * The 'em' unit is equal to the computed value of the 'font-size' property of the element on
     * which it is used. The exception is when 'em' occurs in the value of the 'font-size' property
     * itself, in which case it refers to the font size of the parent element. It may be used for
     * vertical or horizontal measurement. (This unit is also sometimes called the quad-width in
     * typographic texts.)
     * </p>
     */
    protected static final Unit em = Unit.em;

    /**
     * <p>
     * The 'ex' unit is defined by the element's first available font. The 'x-height' is so called
     * because it is often equal to the height of the lowercase "x". However, an 'ex' is defined
     * even for fonts that don't contain an "x".
     * </p>
     */
    protected static final Unit ex = Unit.ex;

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
    protected static final Unit px = Unit.px;

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
    protected static final Unit in = Unit.in;

    /**
     * 1/100th of the width of the viewport.
     */
    protected static final Unit vh = Unit.vh;

    /**
     * 1/100th of the width of the viewport.
     */
    protected static final Unit vw = Unit.vw;

    /**
     * 1/100th of the minimum value between the height and the width of the viewport.
     */
    protected static final Unit vmin = Unit.vmin;

    /**
     * 1/100th of the maximum value between the height and the width of the viewport.
     */
    protected static final Unit vmax = Unit.vmax;

    /**
     * deg which represents an angle in degrees. One full circle is 360deg. E.g. 0deg, 90deg,
     * 360deg.
     */
    protected static final Unit deg = Unit.deg;

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
    protected static final Unit s = Unit.s;

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
    protected static final Unit ms = Unit.ms;

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
    protected static final Unit percent = Unit.percent;

    /**
     * <p>
     * The CSS align-items property aligns flex items of the current flex line the same way as
     * justify-content but in the perpendicular direction.
     * </p>
     */
    public AlignItems alignItems;

    /**
     * <p>
     * The CSS align-content property aligns a flex container's lines within the flex container when
     * there is extra space on the cross-axis. This property has no effect on single line flexible
     * boxes.
     * </p>
     */
    public AlignContent alignContent;

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
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public Borders border;

    /**
     * <p>
     * The width, height and box-sizing property.
     * </p>
     */
    public Box box;

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
     * The cursor CSS property specifies the mouse cursor displayed when the mouse pointer is over
     * an element.
     * </p>
     */
    public Cursor cursor;

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
     * The CSS flex-direction property specifies how flex items are placed in the flex container
     * defining the main axis and the direction (normal or reversed).
     * </p>
     */
    public FlexDirection flexDirection;

    /**
     * <p>
     * The CSS flex-wrap property specifies whether the children are forced into a single line or if
     * the items can be flowed on multiple lines.
     * </p>
     */
    public FlexWrap flexWrap;

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
     * The CSS justify-content property defines how a browser distributes available space between
     * and around elements when aligning flex items in the main-axis of the current line. The
     * alignment is done after the lengths and auto margins are applied, meaning that, if there is
     * at least one flexible element, with flex-grow different than 0, it will have no effect as
     * there won't be any available space.
     * </p>
     */
    public JustifyContent justifyContent;

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     */
    public Line line;

    /**
     * <p>
     * The list-style CSS property is a shorthand property for setting list-style-type,
     * list-style-image and list-style-position.
     * </p>
     */
    public ListStyle listStyle;

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
    public Borders outline;

    /**
     * <p>
     * The overflow CSS property specifies whether to clip content, render scroll bars or display
     * overflow content of a block-level element.
     * </p>
     * <p>
     * Using the overflow property with a value different than visible, its default, will create a
     * new block formatting context. This is technically necessary as if a float would intersect
     * with the scrolling element it would force to rewrap the content of the scrollable element
     * around intruding floats. The rewrap would happen after each scroll step and would be lead to
     * a far too slow scrolling experience. Note that, by programmatically setting scrollTop to the
     * relevant HTML element, even when overflow has the hidden value an element may need to scroll.
     * </p>
     */
    public Overflows overflow;

    /**
     * <p>
     * The position CSS property chooses alternative rules for positioning elements, designed to be
     * useful for scripted animation effects.
     * </p>
     */
    public Position position;

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
     * The CSS transform property lets you modify the coordinate space of the CSS visual formatting
     * model. Using it, elements can be translated, rotated, scaled, and skewed according to the
     * values set.
     * </p>
     * <p>
     * If the property has a value different than none, a stacking context will be created. In that
     * case the object will act as a containing block for position: fixed elements that it contains.
     * </p>
     */
    public Transform transform;

    /**
     * <p>
     * The CSS transition property is a shorthand property for transition-property,
     * transition-duration, transition-timing-function, and transition-delay. It allows to define
     * the transition between two states of an element.
     * </p>
     */
    public Transition transition;

    /** The text related style. */
    public Text text;

    /**
     * <p>
     * Controls the appearance (only) of selection. This does not have any affect on actual
     * selection operation. This doesn't have any effect on content loaded as chrome, except in
     * textboxes. A similar property 'user-focus' was proposed in early drafts of a predecessor of
     * css3-ui but was rejected by the working group.
     * </p>
     */
    public UserSelect userSelect;

    /**
     * <p>
     * The visibility CSS property has two purposes:
     * </p>
     */
    public Visibility visibility;

    /** The current procesing rule set. */
    RuleSet rules = new RuleSet(getClass());

    /**
     * Create user css.
     */
    protected StyleDeclaration() {
        load(rules);
    }

    /**
     * Load all properties.
     * 
     * @param mode
     */
    protected void load(RuleSet set) {
        try {
            // update current rule set
            rules = set;

            // load property and assign it to field
            for (CSSProperty property : set.properties) {
                property.css = this;
                StyleDeclaration.class.getField(Strings.unhyphenate(property.name)).set(this, property);
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    // ====================================================
    // Color Methods
    // ====================================================
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
    public static final Color rgb(int red, int green, int blue) {
        return Color.rgb(red, green, blue);
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
    public static final Color rgba(int red, int green, int blue, double alpha) {
        return Color.rgba(red, green, blue, alpha);
    }

    /**
     * <p>
     * Create Color without alpha channel.
     * </p>
     * 
     * @param hue The attribute of a visual sensation according to which an area appears to be
     *            similar to one of the perceived colors: red, yellow, green, and blue, or to a
     *            combination of two of them .
     * @param saturation The colorfulness of a stimulus relative to its own brightness.
     * @param lightness The brightness relative to the brightness of a similarly illuminated white.
     * @return A new color.
     */
    public static final Color hsl(int hue, int saturation, int lightness) {
        return hsla(hue, saturation, lightness, 1);
    }

    /**
     * <p>
     * Create Color without alpha channel.
     * </p>
     * 
     * @param hue The attribute of a visual sensation according to which an area appears to be
     *            similar to one of the perceived colors: red, yellow, green, and blue, or to a
     *            combination of two of them .
     * @param saturation The colorfulness of a stimulus relative to its own brightness.
     * @param lightness The brightness relative to the brightness of a similarly illuminated white.
     * @param alpha The transparency.
     * @return A new color.
     */
    public static final Color hsla(int hue, int saturation, int lightness, double alpha) {
        return new Color(hue, saturation, lightness, alpha);
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
     * @return A new linear gradient image.
     */
    public static final LinearGradient linear() {
        return new LinearGradient();
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
     * @return A new linear gradient image.
     */
    public static final LinearGradient linear(Color start, Color end) {
        return new LinearGradient().color(start, end);
    }

    /**
     * <p>
     * The CSS radial-gradient() function creates an <image> which represents a gradient of colors
     * radiating from an origin, the center of the gradient. The result of this function is an
     * object of the CSS <gradient> data type.
     * </p>
     * 
     * @return A new linear gradient image.
     */
    public static final RadialGradient radial() {
        return new RadialGradient();
    }

    /**
     * <p>
     * The CSS radial-gradient() function creates an <image> which represents a gradient of colors
     * radiating from an origin, the center of the gradient. The result of this function is an
     * object of the CSS <gradient> data type.
     * </p>
     * 
     * @return A new linear gradient image.
     */
    public static final RadialGradient radial(Color start, Color end) {
        return new RadialGradient().color(start, end);
    }
}
