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

/**
 * @version 2014/10/21 16:48:37
 */
public class StyleRuleDeclaration extends StyleDeclaration {

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
    public final void link(Runnable sub) {
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
    public final void visited(Runnable sub) {
        sub("$:visited", sub);
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
    public final void hover(Runnable sub) {
        sub("$:hover", sub);
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
    public final void active(Runnable sub) {
        sub("$:active", sub);
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
    public final void focus(Runnable sub) {
        sub("$:focus", sub);
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
    public final void enabled(Runnable sub) {
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
    public final void disabled(Runnable sub) {
        sub("$:disabled", sub);
    }

    /**
     * <p>
     * The :checked CSS pseudo-class selector represents any radio (<input type="radio">), checkbox
     * (<input type="checkbox">) or option (<option> in a <select>) element that is checked or
     * toggled to an on state. The user can change this state by clicking on the element, or
     * selecting a different value, in which case the :checked pseudo-class no longer applies to
     * this element, but will to the relevant one.
     * </p>
     * 
     * @return
     */
    public final void checked(Runnable sub) {
        sub("$:checked", sub);
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
    public final void indeterminate(Runnable sub) {
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
    public final void required(Runnable sub) {
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
    public final void optional(Runnable sub) {
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
    public final void valid(Runnable sub) {
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
    public final void invalid(Runnable sub) {
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
    public final void firstChild(Runnable sub) {
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
    public final void firstOfType(Runnable sub) {
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
    public final void lastChild(Runnable sub) {
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
    public final void lastOfType(Runnable sub) {
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
    public final void onlyChild(Runnable sub) {
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
    public final void onlyOfType(Runnable sub) {
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
    public final void nthChild(String pattern, Runnable sub) {
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
    public final void nthLastChild(String pattern, Runnable sub) {
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
    public final void nthOfType(String pattern, Runnable sub) {
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
    public final void nthLastOfType(String pattern, Runnable sub) {
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
    public final void empty(Runnable sub) {
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
    public final void before(Runnable sub) {
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
    public final void after(Runnable sub) {
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
    public final void firstLetter(Runnable sub) {
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
    public final void firstLine(Runnable sub) {
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
    public final void selection(Runnable sub) {
        // Gecko is the only engine requiring the prefix. Due to the fact that the CSS parsing rules
        // require dropping the whole rule when encountering an invalid pseudo-element, two separate
        // rules must be written: ::-moz-selection, ::selection {...}. The rule would be dropped on
        // non-Gecko browsers as ::-moz-selection is invalid on them.
        sub("$::selection", sub);
        sub("$::-moz-selection", sub);
    }

    public final void children(Runnable sub) {
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
    public final void parentHover(Runnable sub) {
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
    public final void adjacentHover(Runnable sub) {
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
    public final void siblingHover(Runnable sub) {
        sub("*:hover~$", sub);
    }

    /**
     * <p>
     * Create sub rule set.
     * </p>
     * 
     * @param selector
     * @return
     */
    private final void sub(String selector, Runnable sub) {
        // store parent rule
        StyleDeclarable parent = PropertyDefinition.declarable;

        if (parent instanceof StyleRule) {
            StyleRule rules = (StyleRule) parent;

            // create child rule
            StyleRule child = new StyleRule(rules, selector);

            // swap context rule and execute it
            PropertyDefinition.declarable = child;
            sub.run();
            PropertyDefinition.declarable = parent;
        }
    }
}
