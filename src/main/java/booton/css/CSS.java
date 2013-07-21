/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import js.util.Color;
import kiss.Extensible;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import kiss.model.Model;
import booton.Obfuscator;
import booton.Stylist;
import booton.css.property.AlignItems;
import booton.css.property.Background;
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
import booton.css.property.Overflow;
import booton.css.property.PointerEvents;
import booton.css.property.Position;
import booton.css.property.Text;
import booton.css.property.Transform;
import booton.css.property.Transition;
import booton.css.property.UserSelect;
import booton.css.property.Visibility;
import booton.css.value.BorderValue;
import booton.css.value.GradientValue;
import booton.util.Strings;

/**
 * @version 2013/07/21 16:27:27
 */
@Manageable(lifestyle = Singleton.class)
public abstract class CSS implements Extensible {

    /** The current processing css. */
    static CSS current;

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
     * The cursor CSS property specifies the mouse cursor displayed when the mouse pointer is over
     * an element.
     * </p>
     */
    public Cursor cursor;

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
    public BorderValue outline;

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
    public Line line;

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
    public BorderValue border;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public BorderValue borderLeft;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public BorderValue borderRight;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public BorderValue borderTop;

    /**
     * <p>
     * The border CSS property is a shorthand property for setting the individual border property
     * values in a single place in the style sheet. border can be used to set the values for one or
     * more of: border-width, border-style, border-color.
     * </p>
     */
    public BorderValue borderBottom;

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
    public Overflow overflow;

    /**
     * <p>
     * The overflow-x CSS property specifies whether to clip content, render a scroll bar or display
     * overflow content of a block-level element, when it overflows at the left and right edges.
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
    public Overflow overflowX;

    /**
     * <p>
     * The overflow-y CSS property specifies whether to clip content, render a scroll bar, or
     * display overflow content of a block-level element, when it overflows at the top and bottom
     * edges.
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
    public Overflow overflowY;

    /**
     * <p>
     * The visibility CSS property has two purposes:
     * </p>
     */
    public Visibility visibility;

    /**
     * <p>
     * Controls the appearance (only) of selection. This does not have any affect on actual
     * selection operation. This doesn't have any effect on content loaded as chrome, except in
     * textboxes. A similar property 'user-focus' was proposed in early drafts of a predecessor of
     * css3-ui but was rejected by the working group.
     * </p>
     */
    public UserSelect userSelect;

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
     * The :hover CSS pseudo-class matches when the user designates an element with a pointing
     * device, but does not necessarily activate it. This style may be overridden by any other
     * link-related pseudo-classes, that is :link, :visited, and :active, appearing in subsequent
     * rules. In order to style appropriately links, you need to put the :hover rule after the :link
     * and :visited rules but before the :active one, as defined by the LVHA-order: :link — :visited
     * — :hover — :active.
     * </p>
     * 
     * @return
     */
    public final boolean hover() {
        return rule(rules.selector + ":hover");
    }

    /**
     * <p>
     * The :hover CSS pseudo-class matches when the user designates an element with a pointing
     * device, but does not necessarily activate it. This style may be overridden by any other
     * link-related pseudo-classes, that is :link, :visited, and :active, appearing in subsequent
     * rules. In order to style appropriately links, you need to put the :hover rule after the :link
     * and :visited rules but before the :active one, as defined by the LVHA-order: :link — :visited
     * — :hover — :active.
     * </p>
     * 
     * @return
     */
    public final boolean active() {
        return rule(rules.selector + ":active");
    }

    /**
     * <p>
     * The :active CSS pseudo-class matches when an element is being activated by the user. It
     * allows the page to give a feedback that the activation has been detected by the browser. When
     * interacting with a mouse, this is typically the time between the user presses the mouse
     * button and releases it. The :active pseudo-class is also typically matched when using the
     * keyboard tab key. It is frequently used on <a> and <button> HTML elements, but may not be
     * limited to just those.
     * </p>
     * 
     * @return
     */
    public final boolean focus() {
        return rule(rules.selector + ":focus");
    }

    /**
     * <p>
     * The :first-child CSS pseudo-class represents any element that is the first child element of
     * its parent.
     * </p>
     * 
     * @return
     */
    public final boolean firstChild() {
        return rule(rules.selector + ":first-child");
    }

    /**
     * <p>
     * The :first-of-type CSS pseudo-class represents the first sibling of its type in the list of
     * children of its parent element.
     * </p>
     * 
     * @return
     */
    public final boolean firstOfType() {
        return rule(rules.selector + ":first-of-type");
    }

    /**
     * <p>
     * The :last-child CSS pseudo-class represents any element that is the last child element of its
     * parent.
     * </p>
     * 
     * @return
     */
    public final boolean lastChild() {
        return rule(rules.selector + ":last-child");
    }

    /**
     * <p>
     * The :last-of-type CSS pseudo-class represents the last sibling of its type in the list of
     * children of its parent element.
     * </p>
     * 
     * @return
     */
    public final boolean lastOfType() {
        return rule(rules.selector + ":last-of-type");
    }

    /**
     * <p>
     * The :only-child CSS pseudo-class represents any element which is the only child of its
     * parent. This is the same as :first-child:last-child or :nth-child(1):nth-last-child(1), but
     * with a lower specificity.
     * </p>
     * 
     * @return
     */
    public final boolean onlyChild() {
        return rule(rules.selector + ":only-child");
    }

    /**
     * <p>
     * The :only-of-type CSS pseudo-class represents any element that has no siblings of the given
     * type.
     * </p>
     * 
     * @return
     */
    public final boolean onlyOfType() {
        return rule(rules.selector + ":only-of-type");
    }

    /**
     * <p>
     * The :nth-child CSS pseudo-class matches an element that has an+b-1 siblings before it in the
     * document tree, for a given positive or zero value for n, and has a parent element.
     * </p>
     * 
     * @return
     */
    public final boolean nthChild(String pattern) {
        return rule(rules.selector + ":nth-child");
    }

    /**
     * <p>
     * The :nth-last-child CSS pseudo-class matches an element that has an+b-1 siblings after it in
     * the document tree, for a given positive or zero value for n, and has a parent element. See
     * :nth-child for a more thorough description of the syntax of its argument.
     * </p>
     * 
     * @return
     */
    public final boolean nthLastChild(String pattern) {
        return rule(rules.selector + ":nth-child");
    }

    /**
     * <p>
     * The :nth-of-type CSS pseudo-class matches an element that has an+b-1 siblings with the same
     * element name before it in the document tree, for a given positive or zero value for n, and
     * has a parent element. See :nth-child for a more thorough description of the syntax of its
     * argument. This is a more flexible and useful pseudo selector if you want to ensure you're
     * selecting the same type of tag no matter where it is inside the parent element, or what other
     * different tags appear before it.
     * </p>
     * 
     * @return
     */
    public final boolean nthOfType(String pattern) {
        return rule(rules.selector + ":nth-of-type");
    }

    /**
     * <p>
     * The :nth-last-of-type CSS pseudo-class matches an element that has an+b-1 siblings with the
     * same element name after it in the document tree, for a given positive or zero value for n,
     * and has a parent element. See :nth-child for a more thorough description of the syntax of its
     * argument.
     * </p>
     * 
     * @return
     */
    public final boolean nthLastOfType(String pattern) {
        return rule(rules.selector + ":nth-last-of-type");
    }

    /**
     * <p>
     * :before creates a pseudo-element that is the first child of the element matched. Often used
     * to add cosmetic content to an element, by using the content property. This element is inline
     * by default.
     * </p>
     * 
     * @return
     */
    public final boolean before() {
        return rule(rules.selector + ":before");
    }

    /**
     * <p>
     * The CSS :after pseudo-element matches a virtual last child of the selected element. Typically
     * used to add cosmetic content to an element, by using the content CSS property. This element
     * is inline by default.
     * </p>
     * 
     * @return
     */
    public final boolean after() {
        return rule(rules.selector + ":after");
    }

    /**
     * <p>
     * The ::selection CSS pseudo-element applies rules to the portion of a document that has been
     * highlighted (e.g., selected with the mouse or another pointing device) by the user.
     * </p>
     * <p>
     * Only a small subset of CSS properties can be used in a rule using ::selection in its
     * selector: color, background, background-color and text-shadow. Note that, in particular,
     * background-image is ignored, like any other property.
     * </p>
     * 
     * @return
     */
    public final boolean selection() {
        return rule(rules.selector + ":selection");
    }

    public final boolean children() {
        return rule(rules.selector + ">*");
    }

    /**
     * <p>
     * The CSS :after pseudo-element matches a virtual last child of the selected element. Typically
     * used to add cosmetic content to an element, by using the content CSS property. This element
     * is inline by default.
     * </p>
     * 
     * @return
     */
    public final boolean inBackOf(Class<? extends CSS> clazz) {
        return rule("." + Obfuscator.computeCSSName(clazz) + "+" + rules.selector);
    }

    /**
     * <p>
     * The CSS :after pseudo-element matches a virtual last child of the selected element. Typically
     * used to add cosmetic content to an element, by using the content CSS property. This element
     * is inline by default.
     * </p>
     * 
     * @return
     */
    public final boolean insideOf(Class<? extends CSS> clazz) {
        return rule("." + Obfuscator.computeCSSName(clazz) + " " + rules.selector);
    }

    /**
     * <p>
     * The CSS :after pseudo-element matches a virtual last child of the selected element. Typically
     * used to add cosmetic content to an element, by using the content CSS property. This element
     * is inline by default.
     * </p>
     * 
     * @return
     */
    public final boolean with(Class<? extends CSS> clazz) {
        return rule("." + Obfuscator.computeCSSName(clazz) + rules.selector);
    }

    /**
     * <p>
     * The :hover CSS pseudo-class matches when the user designates an element with a pointing
     * device, but does not necessarily activate it. This style may be overridden by any other
     * link-related pseudo-classes, that is :link, :visited, and :active, appearing in subsequent
     * rules. In order to style appropriately links, you need to put the :hover rule after the :link
     * and :visited rules but before the :active one, as defined by the LVHA-order: :link — :visited
     * — :hover — :active.
     * </p>
     * 
     * @return
     */
    public final boolean parentHover() {
        String current = rules.selector;

        if (current.endsWith(":after")) {
            return rule(current.substring(0, current.length() - 6) + ":hover:after");
        } else {
            return rule("*:hover>" + current);
        }
    }

    /**
     * <p>
     * The :hover CSS pseudo-class matches when the user designates an element with a pointing
     * device, but does not necessarily activate it. This style may be overridden by any other
     * link-related pseudo-classes, that is :link, :visited, and :active, appearing in subsequent
     * rules. In order to style appropriately links, you need to put the :hover rule after the :link
     * and :visited rules but before the :active one, as defined by the LVHA-order: :link — :visited
     * — :hover — :active.
     * </p>
     * 
     * @return
     */
    public final boolean adjacentHover() {
        return rule("*:hover+" + rules.selector);
    }

    /**
     * <p>
     * The :hover CSS pseudo-class matches when the user designates an element with a pointing
     * device, but does not necessarily activate it. This style may be overridden by any other
     * link-related pseudo-classes, that is :link, :visited, and :active, appearing in subsequent
     * rules. In order to style appropriately links, you need to put the :hover rule after the :link
     * and :visited rules but before the :active one, as defined by the LVHA-order: :link — :visited
     * — :hover — :active.
     * </p>
     * 
     * @return
     */
    public final boolean siblingHover() {
        return rule("*:hover~" + rules.selector);
    }

    /**
     * <p>
     * Create sub rule set.
     * </p>
     * 
     * @param selector
     * @return
     */
    private final boolean rule(String selector) {
        // dirty usage
        int id = new Error().getStackTrace()[2].getLineNumber();

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
            // update current processing css
            current = this;

            // update current rule set
            rules = set;

            // load property and assign it to field
            for (CSSProperty property : set.rules) {
                property.css = this;
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
        return rules.toString();
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
    protected static final Color rgb(int red, int green, int blue) {
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
    protected static final Color rgba(int red, int green, int blue, double alpha) {
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
    protected static final Color hsl(int hue, int saturation, int lightness) {
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
    protected static final Color hsla(int hue, int saturation, int lightness, double alpha) {
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
     * @return
     */
    protected static final GradientValue linear(Color start, Color end) {
        return new GradientValue(start, end);
    }

    /**
     * <p>
     * Import styles.
     * </p>
     * 
     * @param classes
     */
    protected static final void require(Class<? extends CSS>... classes) {
        Stylist stylist = I.make(Stylist.class);

        // store the processing css
        CSS css = current;

        try {
            for (Class<? extends CSS> clazz : classes) {
                CSS style = I.make(clazz);
                style.rules.selectors.add(css.rules.selector);

                stylist.register(clazz);
            }
        } finally {
            // restore the processing css
            current = css;
        }
    }

    /**
     * @version 2013/07/21 16:27:34
     */
    private static class RuleSet {

        /** The parent rule set. */
        private final RuleSet parent;

        /** The selector. */
        private final String selector;

        /** The required selectors. */
        private final List<String> selectors = new ArrayList();

        /** The property store. */
        private final List<CSSProperty> rules = new ArrayList();

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
            this(null, "." + Obfuscator.computeCSSName(Model.load(clazz).type));
        }

        /**
         * <p>
         * Create sub css rule.
         * </p>
         */
        private RuleSet(RuleSet parent, String selector) {
            this.parent = parent;
            this.selector = selector;
            this.selectors.add(selector);

            if (selector.endsWith(":selection")) {
                this.selectors.add(selector.replace(":selection", "::-moz-selection"));
            }

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
                        constructor.setAccessible(true);
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
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            // count requested properties
            int counter = 0;

            // write requested properties only.
            CSSWriter writer = new CSSWriter();
            writer.write(I.join(selectors, ","), "{");

            for (CSSProperty property : rules) {
                if (property.used) {
                    counter++;
                    writer.write(property.toString());
                }
            }
            writer.write("}");

            if (counter == 0) {
                // this class has no properties, so we can remove it
                writer = new CSSWriter();
            }

            for (RuleSet sub : subs) {
                writer.write(sub.toString());
            }
            return writer.toString();
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
}
