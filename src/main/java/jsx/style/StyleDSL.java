/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import static jsx.style.value.Color.*;

import jsx.style.property.Animation;
import jsx.style.property.Appearance;
import jsx.style.property.Background;
import jsx.style.property.Borders;
import jsx.style.property.BoxLength;
import jsx.style.property.Content;
import jsx.style.property.Cursor;
import jsx.style.property.Display;
import jsx.style.property.Fill;
import jsx.style.property.FlexItem;
import jsx.style.property.Font;
import jsx.style.property.Line;
import jsx.style.property.ListStyle;
import jsx.style.property.Outline;
import jsx.style.property.Overflows;
import jsx.style.property.PointerEvents;
import jsx.style.property.Position;
import jsx.style.property.Stroke;
import jsx.style.property.Text;
import jsx.style.property.Transform;
import jsx.style.property.Transition;
import jsx.style.property.Visibility;
import jsx.style.value.Color;
import jsx.style.value.LinearGradient;
import jsx.style.value.Numeric;
import jsx.style.value.RadialGradient;
import jsx.style.value.Shadow;
import jsx.style.value.Unit;
import kiss.Managed;
import kiss.Singleton;

@Managed(Singleton.class)
public class StyleDSL extends SelectorDSL {

    /**
     * <p>
     * This unit represents the font-size of the root element (e.g. the font-size of the <html>
     * element). When used on the font-size on this root element, it represents its initial value.
     * </p>
     */
    public static final Unit rem = Unit.rem;

    /**
     * <p>
     * The 'em' unit is equal to the computed value of the 'font-size' property of the element on
     * which it is used. The exception is when 'em' occurs in the value of the 'font-size' property
     * itself, in which case it refers to the font size of the parent element. It may be used for
     * vertical or horizontal measurement. (This unit is also sometimes called the quad-width in
     * typographic texts.)
     * </p>
     */
    public static final Unit em = Unit.em;

    /**
     * <p>
     * The 'ex' unit is defined by the element's first available font. The 'x-height' is so called
     * because it is often equal to the height of the lowercase "x". However, an 'ex' is defined
     * even for fonts that don't contain an "x".
     * </p>
     */
    public static final Unit ex = Unit.ex;

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
    public static final Unit px = Unit.px;

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
    public static final Unit in = Unit.in;

    /**
     * 1/100th of the width of the viewport.
     */
    public static final Unit vh = Unit.vh;

    /**
     * 1/100th of the width of the viewport.
     */
    public static final Unit vw = Unit.vw;

    /**
     * 1/100th of the minimum value between the height and the width of the viewport.
     */
    public static final Unit vmin = Unit.vmin;

    /**
     * 1/100th of the maximum value between the height and the width of the viewport.
     */
    public static final Unit vmax = Unit.vmax;

    /**
     * deg which represents an angle in degrees. One full circle is 360deg. E.g. 0deg, 90deg,
     * 360deg.
     */
    public static final Unit deg = Unit.deg;

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
    public static final Unit s = Unit.s;

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
    public static final Unit ms = Unit.ms;

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
    public static final Unit percent = Unit.percent;

    public static final Animation animation = new Animation();

    /**
     * <p>
     * The appearance CSS property is used in Gecko (Firefox) to display an element using a
     * platform-native styling based on the operating system's theme.
     * </p>
     */
    public static final Appearance appearance = new Appearance();

    /**
     * <p>
     * The cursor CSS property specifies the mouse cursor displayed when the mouse pointer is over
     * an element.
     * </p>
     */
    public static final Cursor cursor = new Cursor();

    /**
     * <p>
     * The background CSS property is a shorthand for setting the individual background values in a
     * single place in the style sheet. background can be used to set the values for one or more of:
     * background-color, background-image, background-position, background-repeat, background-size,
     * </p>
     */
    public static final Background background = new Background();

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public static final Borders border = new Borders();

    /**
     * <p>
     * The content CSS property is used with the ::before and ::after pseudo-elements to generate
     * content in an element. Objects inserting using the content property are anonymous replaced
     * elements.
     * </p>
     */
    public static final Content content = new Content();

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
    public static final Display display = new Display();

    /** The SVG property. */
    public static final Fill fill = new Fill();

    /**
     * <p>
     * The flex CSS property is a shorthand property specifying the ability of a flex item to alter
     * its dimensions to fill available space. Flex items can be stretched to use available space
     * proportional to their flex grow factor or their flex shrink factor to prevent overflow.
     * </p>
     */
    public static final FlexItem flexItem = new FlexItem();

    /**
     * <p>
     * The font CSS property is either a shorthand property for setting font-style, font-variant,
     * font-weight, font-size, line-height and font-family, or a way to set the element's font to a
     * system font, using specific keywords.
     * </p>
     */
    public static final Font font = new Font();

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     */
    public static final Line line = new Line();

    /**
     * <p>
     * The list-style CSS property is a shorthand property for setting list-style-type,
     * list-style-image and list-style-position.
     * </p>
     */
    public static final ListStyle listStyle = new ListStyle();

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
    public static final BoxLength margin = new BoxLength("margin");

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
    public static final Outline outline = new Outline();

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
    public static final Overflows overflow = new Overflows();

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
    public static final BoxLength padding = new BoxLength("padding");

    /**
     * <p>
     * The CSS property pointer-events allows authors to control under what circumstances (if any) a
     * particular graphic element can become the target of mouse events. When this property is
     * unspecified, the same characteristics of the visiblePainted value apply to SVG content.
     * </p>
     */
    public static final PointerEvents pointerEvents = new PointerEvents();

    /**
     * <p>
     * The position CSS property chooses alternative rules for positioning elements, designed to be
     * useful for scripted animation effects.
     * </p>
     */
    public static final Position position = new Position();

    /** The SVG property. */
    public static final Stroke stroke = new Stroke();

    /** The text related style. */
    public static final Text text = new Text();

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
    public static final Transform transform = new Transform();

    /**
     * <p>
     * The visibility CSS property has two purposes:
     * </p>
     */
    public static final Visibility visibility = new Visibility();

    /** The built-in style. */
    public final Style NBox = () -> {
    };

    /** The built-in style. */
    public final Style HBox = () -> {
        display.flex();
    };

    /** The built-in style. */
    public final Style VBox = () -> {
        display.flex().direction.column();
    };

    /** The built-in style. */
    public final Style SBox = () -> {
        position.relative();

        child(() -> {
            position.absolute();
        });
    };

    /** The built-in style. */
    public final Style Hide = () -> {
        display.none();
    };

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

    /**
     * <p>
     * The CSS shadow function creates an generic shadow representation.
     * </p>
     * 
     * @return A new shadow.
     */
    public static final Shadow shadow() {
        return new Shadow();
    }

    /**
     * <p>
     * Create transitable style rule.
     * </p>
     * 
     * @return
     */
    public static final Transition transit() {
        return new Transition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final SelectorDSL combine(String type, boolean forward) {
        return SelectorDSL.create(null).combine(type, forward);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final SelectorDSL basic(String selector) {
        return SelectorDSL.create(null).basic(selector);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final SelectorDSL pseudo(boolean isElement, String name) {
        return SelectorDSL.create(null).pseudo(isElement, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final void declare(Style style) {
        SelectorDSL.create(null).declare(style);
    }

    /**
     * <p>
     * Apply bubble border box style.
     * </p>
     * 
     * @param bubbleHeight
     */
    protected final void createBottomBubble(int bubbleHeight, Numeric borderWidth, Color borderColor, Color boxBackColor) {
        if (!position.isAbsolute() && !position.isRelative()) {
            position.relative();
        }

        Numeric width = borderWidth.add(bubbleHeight);

        // write bubble border color
        before(() -> {
            display.block().size(0, px);
            content.text("");
            position.absolute().left(50, percent).top(100, percent);
            margin.left(width.opposite());
            border.solid().color(Transparent).width(width);
            border.top.color(borderColor);
        });

        // write bubble background color
        if (borderWidth.size != 0) {
            Numeric width2 = width.subtract(borderWidth.multiply(1.5));

            after(() -> {
                display.block().size(0, px);
                content.text("");
                position.absolute().left(50, percent).top(100, percent);
                margin.left(width2.opposite());
                border.solid().color(Transparent).width(width2);
                border.top.color(boxBackColor.opacify(1));
            });
        }
    }

    /**
     * <p>
     * Apply bubble border box style.
     * </p>
     * 
     * @param bubbleHeight
     */
    protected final void createTopBubble(int bubbleHeight, Numeric borderWidth, Color borderColor, Color boxBackColor) {
        if (!position.isAbsolute() && !position.isRelative()) {
            position.relative();
        }

        Numeric width = borderWidth.add(bubbleHeight);

        // write bubble border color
        before(() -> {
            display.block().size(0, px);
            content.text("");
            position.absolute().left(50, percent).bottom(100, percent);
            margin.left(width.opposite());
            border.solid().color(Transparent).width(width);
            border.bottom.color(borderColor);
        });

        // write bubble background color
        if (borderWidth.size != 0) {
            Numeric borderWitdh = width.subtract(borderWidth.multiply(1.5));

            after(() -> {
                display.block().size(0, px);
                content.text("");
                position.absolute().left(50, percent).bottom(100, percent);
                margin.left(borderWitdh.opposite());
                border.solid().color(Transparent).width(borderWitdh);
                border.bottom.color(boxBackColor.opacify(1));
            });
        }
    }
}
