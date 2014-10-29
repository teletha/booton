/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import jsx.style.property.Transition;

/**
 * @version 2014/10/21 16:48:37
 */
public class StyleRuleDescriptor extends StyleDescriptor {

    /**
     * <p>
     * The :active CSS pseudo-class matches when an element is being activated by the user. It
     * allows the page to give a feedback that the activation has been detected by the browser. When
     * interacting with a mouse, this is typically the time between the user presses the mouse
     * button and releases it. The :active pseudo-class is also typically matched when using the
     * keyboard tab key. It is frequently used on <a> and <button> HTML elements, but may not be
     * limited to just those.
     * </p>
     * <p>
     * This style may be overridden by any other link-related pseudo-classes, that is :link, :hover,
     * and :visited, appearing in subsequent rules. In order to style appropriately links, you need
     * to put the :active rule after all the other link-related rules, as defined by the LVHA-order:
     * :link — :visited — :hover — :active.
     * </p>
     */
    protected static final void active(Style sub) {
        sub("$:active", sub);
    }

    /**
     * <p>
     * The :checked CSS pseudo-class selector represents any radio (<input type="radio">), checkbox
     * (<input type="checkbox">) or option (<option> in a <select>) element that is checked or
     * toggled to an on state. The user can change this state by clicking on the element, or
     * selecting a different value, in which case the :checked pseudo-class no longer applies to
     * this element, but will to the relevant one.
     * </p>
     */
    protected static final void checked(Style sub) {
        sub("$:checked", sub);
    }

    /**
     * <p>
     * The :focus CSS pseudo-class is applied when a element has received focus, either from the
     * user selecting it with the use of a keyboard or by activating with the mouse (e.g. a form
     * input).
     * </p>
     */
    protected static final void focus(Style sub) {
        sub("$:focus", sub);
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
     */
    protected static final void hover(Style sub) {
        sub("$:hover", sub);
    }

    /**
     * <p>
     * The :link CSS pseudo-class lets you select links inside elements. This will select any link,
     * even those already styled using selector with other link-related pseudo-classes like :hover,
     * :active or :visited. In order to style only non-visited links, you need to put the :link rule
     * before the other ones, as defined by the LVHA-order: :link — :visited — :hover — :active. The
     * :focus pseudo-class is usually placed right before or right after :hover, depending of the
     * expected effect.
     * </p>
     * 
     * @return
     */
    protected static final void link(Style sub) {
        sub("$:link", sub);
    }

    /**
     * <p>
     * The :visited CSS pseudo-class lets you select only links that have been visited. This style
     * may be overridden by any other link-related pseudo-classes, that is :link, :hover, and
     * :active, appearing in subsequent rules. In order to style appropriately links, you need to
     * put the :visited rule after the :link rule but before the other ones, defined in the
     * LVHA-order: :link — :visited — :hover — :active.
     * </p>
     * 
     * @return
     */
    protected static final void visited(Style sub) {
        sub("$:visited", sub);
    }

    /**
     * <p>
     * The :enabled CSS pseudo-class represents any enabled element. An element is enabled if it can
     * be activated (e.g. selected, clicked on or accept text input) or accept focus. The element
     * also has an disabled state, in which it can't be activated or accept focus.
     * </p>
     * 
     * @return
     */
    protected static final void enabled(Style sub) {
        sub("$:enabled", sub);
    }

    /**
     * <p>
     * The :disabled CSS pseudo-class represents any disabled element. An element is disabled if it
     * can't be activated (e.g. selected, clicked on or accept text input) or accept focus. The
     * element also has an enabled state, in which it can be activated or accept focus.
     * </p>
     * 
     * @return
     */
    protected static final void disabled(Style sub) {
        sub("$:disabled", sub);
    }

    /**
     * <p>
     * The :indeterminate CSS pseudo-class represents any <input type="checkbox"> element whose
     * indeterminate DOM property is set to true by JavaScript. In addition, in some browsers, it
     * can be used to match to <progress> elements in an indeterminate state.
     * </p>
     * 
     * @return
     */
    protected static final void indeterminate(Style sub) {
        sub("$:indeterminate", sub);
    }

    /**
     * <p>
     * The :required CSS pseudo-class represents any <input> element that has the required attribute
     * set on it. This allows forms to easily indicate which fields must have valid data before the
     * form can be submitted.
     * </p>
     * 
     * @return
     */
    protected static final void required(Style sub) {
        sub("$:required", sub);
    }

    /**
     * <p>
     * The :optional CSS pseudo-class represents any <input> element that does not have the required
     * attribute set on it. This allows forms to easily indicate optional fields, and to style them
     * accordingly.
     * </p>
     * 
     * @return
     */
    protected static final void optional(Style sub) {
        sub("$:optional", sub);
    }

    /**
     * <p>
     * The :valid CSS pseudo-class represents any <input> element whose content validates correctly
     * according to the input's type setting. This allows to easily make valid fields adopt an
     * appearance that helps the user confirm that their data is formatted properly.
     * </p>
     * 
     * @return
     */
    protected static final void valid(Style sub) {
        sub("$:valid", sub);
    }

    /**
     * <p>
     * The :invalid CSS pseudo-class represents any <input> or <form> element whose content fails to
     * validate according to the input's type setting. This allows you to easily have invalid fields
     * adopt an appearance that helps the user identify and correct errors.
     * </p>
     * 
     * @return
     */
    protected static final void invalid(Style sub) {
        sub("$:invalid", sub);
    }

    /**
     * <p>
     * The :first-child CSS pseudo-class represents any element that is the first child element of
     * its parent.
     * </p>
     * 
     * @return
     */
    protected static final void firstChild(Style sub) {
        sub("$:first-child", sub);
    }

    /**
     * <p>
     * The :first-of-type CSS pseudo-class represents the first sibling of its type in the list of
     * children of its parent element.
     * </p>
     * 
     * @return
     */
    protected static final void firstOfType(Style sub) {
        sub("$:first-of-type", sub);
    }

    /**
     * <p>
     * The :last-child CSS pseudo-class represents any element that is the last child element of its
     * parent.
     * </p>
     * 
     * @return
     */
    protected static final void lastChild(Style sub) {
        sub("$:last-child", sub);
    }

    /**
     * <p>
     * The :last-of-type CSS pseudo-class represents the last sibling of its type in the list of
     * children of its parent element.
     * </p>
     * 
     * @return
     */
    protected static final void lastOfType(Style sub) {
        sub("$:last-of-type", sub);
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
    protected static final void onlyChild(Style sub) {
        sub("$:only-child", sub);
    }

    /**
     * <p>
     * The :only-of-type CSS pseudo-class represents any element that has no siblings of the given
     * type.
     * </p>
     * 
     * @return
     */
    protected static final void onlyOfType(Style sub) {
        sub("$:only-of-type", sub);
    }

    /**
     * <p>
     * The :nth-child CSS pseudo-class matches an element that has an+b-1 siblings before it in the
     * document tree, for a given positive or zero value for n, and has a parent element.
     * </p>
     * 
     * @return
     */
    protected static final void nthChild(String pattern, Style sub) {
        sub("$:nth-child(" + pattern + ")", sub);
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
    protected static final void nthLastChild(String pattern, Style sub) {
        sub("$:nth-last-child(" + pattern + ")", sub);
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
    protected static final void nthOfType(String pattern, Style sub) {
        sub("$:nth-of-type(" + pattern + ")", sub);
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
    protected static final void nthLastOfType(String pattern, Style sub) {
        sub("$:nth-last-of-type(" + pattern + ")", sub);
    }

    /**
     * <p>
     * The :empty pseudo-class represents any element that has no children at all. Only element
     * nodes and text (including whitespace) are considered. Comments or processing instructions do
     * not affect whether an element is considered empty or not.
     * </p>
     * 
     * @return
     */
    protected static final void empty(Style sub) {
        sub("$:empty", sub);
    }

    /**
     * <p>
     * The negation CSS pseudo-class, :not(X), is a functional notation taking a simple selector X
     * as an argument. It matches an element that is not represented by the argument. X must not
     * contain another negation selector, or any pseudo-elements.
     * </p>
     * 
     * @return
     */
    protected static final void before(Style sub) {
        sub("$::before", sub);
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
    protected static final void after(Style sub) {
        sub("$::after", sub);
    }

    /**
     * <p>
     * The ::first-letter CSS pseudo-element selects the first letter of the first line of a block,
     * if it is not preceded by any other content (such as images or inline tables) on its line.
     * </p>
     * 
     * @return
     */
    protected static final void firstLetter(Style sub) {
        sub("$::first-letter", sub);
    }

    /**
     * <p>
     * The ::first-line CSS pseudo-element applies styles only to the first line of an element. The
     * amount of the text on the first line depends of numerous factors, like the width of the
     * elements or of the document, but also of the font size of the text. As all pseudo-elements,
     * the selectors containing ::first-line does not match any real HTML element.
     * </p>
     * 
     * @return
     */
    protected static final void firstLine(Style sub) {
        sub("$::first-line", sub);
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
    protected static final void selection(Style sub) {
        // Gecko is the only engine requiring the prefix. Due to the fact that the CSS parsing rules
        // require dropping the whole rule when encountering an invalid pseudo-element, two separate
        // rules must be written: ::-moz-selection, ::selection {...}. The rule would be dropped on
        // non-Gecko browsers as ::-moz-selection is invalid on them.
        sub("$::selection", sub);
        sub("$::-moz-selection", sub);
    }

    protected static final void children(Style sub) {
        sub("$>*", sub);
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
    protected static final void parentHover(Style sub) {
        sub("*:hover>$", sub);
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
    protected static final void adjacentHover(Style sub) {
        sub("*:hover+$", sub);
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
    protected static final void siblingHover(Style sub) {
        sub("*:hover~$", sub);
    }

    /**
     * <p>
     * The :empty pseudo-class represents any element that has no children at all. Only element
     * nodes and text (including whitespace) are considered. Comments or processing instructions do
     * not affect whether an element is considered empty or not.
     * </p>
     * 
     * @return
     */
    protected static final void not(Style style, Style sub) {
        sub("$:not(." + style + ")", sub);
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
    protected static final void inBackOf(Style style, Style sub) {
        sub("." + style + "+$", sub);
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
    protected static final void insideOf(Style style, Style sub) {
        sub("." + style + " $", sub);
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
    protected static final void with(Style style, Style sub) {
        sub("." + style + "$", sub);
    }

    protected static final Transition transit() {
        return new Transition();
    }

    /**
     * <p>
     * Create sub rule set.
     * </p>
     * 
     * @param selector
     * @return
     */
    static final void sub(String selector, Style sub) {
        StyleRule parent = PropertyDefinition.declarable;

        parent.sheet.createRuleFrom(selector.replace("$", parent.name), sub);
    }
}
