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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import jsx.ui.Style;
import jsx.ui.flux.Location;

/**
 * @version 2016/09/18 19:02:07
 */
public abstract class SelectorDSL {

    // ===============================================================
    // Basic Selectors
    // ===============================================================

    /**
     * <p>
     * Attribute selectors select an element using the presence of a given attribute or attribute
     * value.
     * </p>
     * 
     * @param name An attribute name.
     * @return Chainable API.
     */
    public final Attribute attr(String name) {
        return new Attribute(name);
    }

    /**
     * Write attribute selector pattern.
     * 
     * @param name An attribute name.
     * @param operator A operator.
     * @param value An attribute value.
     * @param caseSensitive A flag for case sensitive.
     * @return Chainable API.
     */
    private SelectorDSL attr(String name, String operator, String value, boolean caseSensitive) {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(name);

        if (operator != null) {
            builder.append(operator).append("=\"").append(value).append('"');
        }

        if (!caseSensitive) {
            builder.append(" i");
        }
        builder.append("]");

        return basic(builder.toString());
    }

    /**
     * <p>
     * In an HTML document, CSS class selectors match an element based on the contents of the
     * element's class attribute.
     * </p>
     * 
     * @param location A class location.
     * @return Chainable API.
     */
    public final SelectorDSL with(Location location) {
        return basic("." + location.name());
    }

    /**
     * <p>
     * In an HTML document, CSS class selectors match an element based on the contents of the
     * element's class attribute.
     * </p>
     * 
     * @param location A class location.
     */
    public final void with(Location location, Style sub) {
        with(location).style(sub);
    }

    /**
     * <p>
     * Write basic selector.
     * </p>
     * 
     * @param selector A selector expression.
     * @return Chainable API.
     */
    abstract SelectorDSL basic(String selector);

    // ===============================================================
    // Combinators
    // ===============================================================

    /**
     * <p>
     * A descendant combinator — typically represented by a single space ( ) character in the form
     * of selector₁ selector₂ — combines two selectors such that elements matched by the second
     * selector (selector₂) are selected if they have an ancestor element matching the first
     * selector (selector₁). Selectors that utilize a descendant combinator are called descendant
     * selectors.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL ancestor() {
        return combine(" ", false);
    }

    /**
     * <p>
     * A descendant combinator — typically represented by a single space ( ) character in the form
     * of selector₁ selector₂ — combines two selectors such that elements matched by the second
     * selector (selector₂) are selected if they have an ancestor element matching the first
     * selector (selector₁). Selectors that utilize a descendant combinator are called descendant
     * selectors.
     * </p>
     * 
     * @param A sub style rule.
     */
    public final void ancestor(Style sub) {
        ancestor().style(sub);
    }

    /**
     * <p>
     * A descendant combinator — typically represented by a single space ( ) character in the form
     * of selector₁ selector₂ — combines two selectors such that elements matched by the second
     * selector (selector₂) are selected if they have an ancestor element matching the first
     * selector (selector₁). Selectors that utilize a descendant combinator are called descendant
     * selectors.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL descendant() {
        return combine(" ", true);
    }

    /**
     * <p>
     * A descendant combinator — typically represented by a single space ( ) character in the form
     * of selector₁ selector₂ — combines two selectors such that elements matched by the second
     * selector (selector₂) are selected if they have an ancestor element matching the first
     * selector (selector₁). Selectors that utilize a descendant combinator are called descendant
     * selectors.
     * </p>
     * 
     * @return Chainable API.
     */
    public final void descendant(Style sub) {
        descendant().style(sub);
    }

    /**
     * <p>
     * The > combinator separates two selectors and matches only those elements matched by the
     * second selector that are direct children of elements matched by the first. By contrast, when
     * two selectors are combined with the descendant selector, the combined selector expression
     * matches those elements matched by the second selector for which there exists an ancestor
     * element matched by the first selector, regardless of the number of "hops" up the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL parent() {
        return combine(">", false);
    }

    /**
     * <p>
     * The > combinator separates two selectors and matches only those elements matched by the
     * second selector that are direct children of elements matched by the first. By contrast, when
     * two selectors are combined with the descendant selector, the combined selector expression
     * matches those elements matched by the second selector for which there exists an ancestor
     * element matched by the first selector, regardless of the number of "hops" up the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public final void parent(Style sub) {
        parent().style(sub);
    }

    /**
     * <p>
     * The > combinator separates two selectors and matches only those elements matched by the
     * second selector that are direct children of elements matched by the first. By contrast, when
     * two selectors are combined with the descendant selector, the combined selector expression
     * matches those elements matched by the second selector for which there exists an ancestor
     * element matched by the first selector, regardless of the number of "hops" up the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL child() {
        return combine(">", true);
    }

    /**
     * <p>
     * The > combinator separates two selectors and matches only those elements matched by the
     * second selector that are direct children of elements matched by the first. By contrast, when
     * two selectors are combined with the descendant selector, the combined selector expression
     * matches those elements matched by the second selector for which there exists an ancestor
     * element matched by the first selector, regardless of the number of "hops" up the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public final void child(Style sub) {
        child().style(sub);
    }

    /**
     * <p>
     * The > combinator separates two selectors and matches only those elements matched by the
     * second selector that are direct children of elements matched by the first. By contrast, when
     * two selectors are combined with the descendant selector, the combined selector expression
     * matches those elements matched by the second selector for which there exists an ancestor
     * element matched by the first selector, regardless of the number of "hops" up the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL children() {
        return combine(">*", true);
    }

    /**
     * <p>
     * The > combinator separates two selectors and matches only those elements matched by the
     * second selector that are direct children of elements matched by the first. By contrast, when
     * two selectors are combined with the descendant selector, the combined selector expression
     * matches those elements matched by the second selector for which there exists an ancestor
     * element matched by the first selector, regardless of the number of "hops" up the DOM.
     * </p>
     * 
     * @return Chainable API.
     */
    public final void children(Style sub) {
        children().style(sub);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL prev() {
        return combine("+", false);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void prev(Style sub) {
        prev().style(sub);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL next() {
        return combine("+", true);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final void next(Style sub) {
        next().style(sub);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL prevs() {
        return combine("~", false);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final void prevs(Style sub) {
        prevs().style(sub);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL nexts() {
        return combine("~", true);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final void nexts(Style sub) {
        nexts().style(sub);
    }

    /**
     * <p>
     * Write combinator.
     * </p>
     * 
     * @param type A combinator type.
     * @param forward A direction.
     * @return
     */
    abstract SelectorDSL combine(String type, boolean forward);

    // ===============================================================
    // Pseudo Elements
    // ===============================================================

    /**
     * <p>
     * The CSS :after pseudo-element matches a virtual last child of the selected element. Typically
     * used to add cosmetic content to an element, by using the content CSS property. This element
     * is inline by default.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void after(Style sub) {
        pseudo(true, "after").style(sub);
    }

    /**
     * <p>
     * The CSS ::before creates a pseudo-element that is the first child of the element matched. It
     * is often used to add cosmetic content to an element by using the content property. This
     * element is inline by default.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void before(Style sub) {
        pseudo(true, "before").style(sub);
    }

    /**
     * <p>
     * The ::first-letter CSS pseudo-element selects the first letter of the first line of a block,
     * if it is not preceded by any other content (such as images or inline tables) on its line.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void firstLetter(Style sub) {
        pseudo(true, "first-letter").style(sub);
    }

    /**
     * <p>
     * The ::first-line CSS pseudo-element applies styles only to the first line of an element. The
     * amount of the text on the first line depends of numerous factors, like the width of the
     * elements or of the document, but also of the font size of the text. As all pseudo-elements,
     * the selectors containing ::first-line does not match any real HTML element.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void firstLine(Style sub) {
        pseudo(true, "first-line").style(sub);
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
     * @param sub A sub style.
     */
    public final void selection(Style sub) {
        // Gecko is the only engine requiring the prefix. Due to the fact that the CSS parsing rules
        // require dropping the whole rule when encountering an invalid pseudo-element, two separate
        // rules must be written: ::-moz-selection, ::selection {...}. The rule would be dropped on
        // non-Gecko browsers as ::-moz-selection is invalid on them.
        pseudo(true, Vendor.isMozilla ? "-moz-selection" : "selection").style(sub);
    }

    // ===============================================================
    // Pseudo Classes
    // ===============================================================

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
     * @return Chainable API.
     */
    public final SelectorDSL active() {
        return pseudo(false, "active");
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
     * @param sub A sub style.
     */
    public final void active(Style sub) {
        active().style(sub);
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
     * @return Chainable API.
     */
    public final SelectorDSL checked() {
        return pseudo(false, "checked");
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
     * @param sub A sub style.
     */
    public final void checked(Style sub) {
        checked().style(sub);
    }

    /**
     * <p>
     * The :public final CSS pseudo-class represents any user interface element that is the public
     * final among a group of similar elements.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL defaults() {
        return pseudo(false, "default");
    }

    /**
     * <p>
     * The :disabled CSS pseudo-class represents any disabled element. An element is disabled if it
     * can't be activated (e.g. selected, clicked on or accept text input) or accept focus. The
     * element also has an enabled state, in which it can be activated or accept focus.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL disabled() {
        return pseudo(false, "disabled");
    }

    /**
     * <p>
     * The :disabled CSS pseudo-class represents any disabled element. An element is disabled if it
     * can't be activated (e.g. selected, clicked on or accept text input) or accept focus. The
     * element also has an enabled state, in which it can be activated or accept focus.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void disabled(Style sub) {
        disabled().style(sub);
    }

    /**
     * <p>
     * The :empty pseudo-class represents any element that has no children at all. Only element
     * nodes and text (including whitespace) are considered. Comments or processing instructions do
     * not affect whether an element is considered empty or not.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL empty() {
        return pseudo(false, "empty");
    }

    /**
     * <p>
     * The :empty pseudo-class represents any element that has no children at all. Only element
     * nodes and text (including whitespace) are considered. Comments or processing instructions do
     * not affect whether an element is considered empty or not.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void empty(Style sub) {
        empty().style(sub);
    }

    /**
     * <p>
     * The :enabled CSS pseudo-class represents any enabled element. An element is enabled if it can
     * be activated (e.g. selected, clicked on or accept text input) or accept focus. The element
     * also has an disabled state, in which it can't be activated or accept focus.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL enabled() {
        return pseudo(false, "enabled");
    }

    /**
     * <p>
     * The :enabled CSS pseudo-class represents any enabled element. An element is enabled if it can
     * be activated (e.g. selected, clicked on or accept text input) or accept focus. The element
     * also has an disabled state, in which it can't be activated or accept focus.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void enabled(Style sub) {
        enabled().style(sub);
    }

    /**
     * <p>
     * The :first-child CSS pseudo-class represents any element that is the first child element of
     * its parent.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL firstChild() {
        return pseudo(false, "first-child");
    }

    /**
     * <p>
     * The :first-child CSS pseudo-class represents any element that is the first child element of
     * its parent.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void firstChild(Style sub) {
        firstChild().style(sub);
    }

    /**
     * <p>
     * The :first-of-type CSS pseudo-class represents the first sibling of its type in the list of
     * children of its parent element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL firstType() {
        return pseudo(false, "first-of-type");
    }

    /**
     * <p>
     * The :first-of-type CSS pseudo-class represents the first sibling of its type in the list of
     * children of its parent element.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void firstOfType(Style sub) {
        firstType().style(sub);
    }

    /**
     * <p>
     * The :focus CSS pseudo-class is applied when an element has received focus, either from the
     * user selecting it with the use of a keyboard or by activating with the mouse (e.g. a form
     * input).
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL focus() {
        return pseudo(false, "focus");
    }

    /**
     * <p>
     * The :focus CSS pseudo-class is applied when an element has received focus, either from the
     * user selecting it with the use of a keyboard or by activating with the mouse (e.g. a form
     * input).
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void focus(Style sub) {
        focus().style(sub);
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
     * @return Chainable API.
     */
    public final SelectorDSL hover() {
        return pseudo(false, "hover");
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
     * @param sub A sub style.
     */
    public final void hover(Style sub) {
        hover().style(sub);
    }

    /**
     * <p>
     * The :indeterminate CSS pseudo-class represents:
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL indeterminate() {
        return pseudo(false, "indeterminate");
    }

    /**
     * <p>
     * The :indeterminate CSS pseudo-class represents:
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void indeterminate(Style sub) {
        indeterminate().style(sub);
    }

    /**
     * <p>
     * The :invalid CSS pseudo-class represents any <input> or <form> element whose content fails to
     * validate according to the input's type setting. This allows you to easily have invalid fields
     * adopt an appearance that helps the user identify and correct errors.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL invalid() {
        return pseudo(false, "invalid");
    }

    /**
     * <p>
     * The :invalid CSS pseudo-class represents any <input> or <form> element whose content fails to
     * validate according to the input's type setting. This allows you to easily have invalid fields
     * adopt an appearance that helps the user identify and correct errors.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void invalid(Style sub) {
        invalid().style(sub);
    }

    /**
     * <p>
     * The :last-child CSS pseudo-class represents any element that is the last child element of its
     * parent.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL lastChild() {
        return pseudo(false, "last-child");
    }

    /**
     * <p>
     * The :last-child CSS pseudo-class represents any element that is the last child element of its
     * parent.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void lastChild(Style sub) {
        lastChild().style(sub);
    }

    /**
     * <p>
     * The :last-of-type CSS pseudo-class represents the last sibling with the given element name in
     * the list of children of its parent element.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL lastType() {
        return pseudo(false, "last-of-type");
    }

    /**
     * <p>
     * The :last-of-type CSS pseudo-class represents the last sibling of its type in the list of
     * children of its parent element.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void lastOfType(Style sub) {
        lastType().style(sub);
    }

    /**
     * <p>
     * The :link CSS pseudo-class lets you select links inside elements. This will select any link
     * which has not yet been visited, even those already styled using selector with other
     * link-related pseudo-classes like :hover, :active or :visited. In order to appropriately style
     * links, you need to put the :link rule before the other ones, as defined by the LVHA-order:
     * :link — :visited — :hover — :active. The :focus pseudo-class is usually placed right before
     * or right after :hover, depending on the expected effect.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL link() {
        return pseudo(false, "link");
    }

    /**
     * <p>
     * The :link CSS pseudo-class lets you select links inside elements. This will select any link
     * which has not yet been visited, even those already styled using selector with other
     * link-related pseudo-classes like :hover, :active or :visited. In order to appropriately style
     * links, you need to put the :link rule before the other ones, as defined by the LVHA-order:
     * :link — :visited — :hover — :active. The :focus pseudo-class is usually placed right before
     * or right after :hover, depending on the expected effect.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void link(Style sub) {
        link().style(sub);
    }

    /**
     * <p>
     * The negation CSS pseudo-class, :not(X), is a functional notation taking a simple selector X
     * as an argument. It matches an element that is not represented by the argument. X must not
     * contain another negation selector.
     * </p>
     * 
     * @return
     */
    public final SelectorDSL not(SelectorDSL selector) {
        // not-pseudo-class accepts simple selector only
        return pseudo(false, "not(" + selector.toString().replaceAll("\\$", "") + ")");
    }

    /**
     * <p>
     * The negation CSS pseudo-class, :not(X), is a functional notation taking a simple selector X
     * as an argument. It matches an element that is not represented by the argument. X must not
     * contain another negation selector.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void not(SelectorDSL selector, Style sub) {
        not(selector).style(sub);
    }

    /**
     * <p>
     * The negation CSS pseudo-class, :not(X), is a functional notation taking a simple selector X
     * as an argument. It matches an element that is not represented by the argument. X must not
     * contain another negation selector.
     * </p>
     * 
     * @return
     */
    public final SelectorDSL not(Style selector) {
        // not-pseudo-class accepts simple selector only
        return pseudo(false, "not(." + selector.name() + ")");
    }

    /**
     * <p>
     * The negation CSS pseudo-class, :not(X), is a functional notation taking a simple selector X
     * as an argument. It matches an element that is not represented by the argument. X must not
     * contain another negation selector.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void not(Style selector, Style sub) {
        not(selector).style(sub);
    }

    /**
     * <p>
     * The :nth-child CSS pseudo-class matches an element that has an+b-1 siblings before it in the
     * document tree, for a given positive or zero value for n, and has a parent element.
     * </p>
     * 
     * @return
     */
    public final SelectorDSL nthChild(String pattern) {
        return pseudo(false, "nth-child(" + pattern + ")");
    }

    /**
     * <p>
     * The :nth-child CSS pseudo-class matches an element that has an+b-1 siblings before it in the
     * document tree, for a given positive or zero value for n, and has a parent element.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void nthChild(String pattern, Style sub) {
        nthChild(pattern).style(sub);
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
    public final SelectorDSL nthLastChild(String pattern) {
        return pseudo(false, "nth-last-child(" + pattern + ")");
    }

    /**
     * <p>
     * The :nth-last-child CSS pseudo-class matches an element that has an+b-1 siblings after it in
     * the document tree, for a given positive or zero value for n, and has a parent element. See
     * :nth-child for a more thorough description of the syntax of its argument.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void nthLastChild(String pattern, Style sub) {
        nthLastChild(pattern).style(sub);
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
    public final SelectorDSL nthOfType(String pattern) {
        return pseudo(false, "nth-of-type(" + pattern + ")");
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
     * @param sub A sub style.
     */
    public final void nthOfType(String pattern, Style sub) {
        nthOfType(pattern).style(sub);
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
    public final SelectorDSL nthLastOfType(String pattern) {
        return pseudo(false, "nth-last-of-type(" + pattern + ")");
    }

    /**
     * <p>
     * The :nth-last-of-type CSS pseudo-class matches an element that has an+b-1 siblings with the
     * same element name after it in the document tree, for a given positive or zero value for n,
     * and has a parent element. See :nth-child for a more thorough description of the syntax of its
     * argument.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void nthLastOfType(String pattern, Style sub) {
        nthLastOfType(pattern).style(sub);
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
    public final SelectorDSL onlyChild() {
        return pseudo(false, "only-child");
    }

    /**
     * <p>
     * The :only-child CSS pseudo-class represents any element which is the only child of its
     * parent. This is the same as :first-child:last-child or :nth-child(1):nth-last-child(1), but
     * with a lower specificity.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void onlyChild(Style sub) {
        onlyChild().style(sub);
    }

    /**
     * <p>
     * The :only-of-type CSS pseudo-class represents any element that has no siblings of the given
     * type.
     * </p>
     * 
     * @return
     */
    public final SelectorDSL onlyOfType() {
        return pseudo(false, "only-of-type");
    }

    /**
     * <p>
     * The :only-of-type CSS pseudo-class represents any element that has no siblings of the given
     * type.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void onlyOfType(Style sub) {
        onlyOfType().style(sub);
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
    public final SelectorDSL optional() {
        return pseudo(false, "optional");
    }

    /**
     * <p>
     * The :optional CSS pseudo-class represents any <input> element that does not have the required
     * attribute set on it. This allows forms to easily indicate optional fields, and to style them
     * accordingly.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void optional(Style sub) {
        optional().style(sub);
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
    public final SelectorDSL required() {
        return pseudo(false, "required");
    }

    /**
     * <p>
     * The :required CSS pseudo-class represents any <input> element that has the required attribute
     * set on it. This allows forms to easily indicate which fields must have valid data before the
     * form can be submitted.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void required(Style sub) {
        required().style(sub);
    }

    /**
     * <p>
     * The :valid CSS pseudo-class represents any <input> or <form> element whose content validates
     * correctly according to the input's type setting. This allows to easily make valid fields
     * adopt an appearance that helps the user confirm that their data is formatted properly.
     * </p>
     * 
     * @return Chainable API.
     */
    public final SelectorDSL valid() {
        return pseudo(false, "valid");
    }

    /**
     * <p>
     * The :valid CSS pseudo-class represents any <input> or <form> element whose content validates
     * correctly according to the input's type setting. This allows to easily make valid fields
     * adopt an appearance that helps the user confirm that their data is formatted properly.
     * </p>
     * 
     * @param sub A sub style.
     */
    public final void valid(Style sub) {
        valid().style(sub);
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
    public final SelectorDSL visited() {
        return pseudo(false, "visited");
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
     * @param sub A sub style.
     */
    public final void visited(Style sub) {
        visited().style(sub);
    }

    /**
     * <p>
     * Write pseudo class.
     * </p>
     * 
     * @param element A pseudo type.
     * @param name A pseudo name.
     * @return Chainable API.
     */
    abstract SelectorDSL pseudo(boolean element, String name);

    void style(Style sub) {

    }

    /**
     * <p>
     * Create new selector builder.
     * </p>
     * 
     * @param processor A style creation process.
     * @return A created selector builder.
     */
    public static final SelectorDSL create(Consumer<StyleRule> processor) {
        return new Selector(processor).basic("$");
    }

    /**
     * @version 2016/09/18 19:22:49
     */
    public final class Attribute {

        /** An attribute name. */
        private final String name;

        /**
         * <p>
         * Create attribute selector builder.
         * </p>
         * 
         * @return Chainable API.
         */
        private Attribute(String name) {
            if (name == null || name.equals("")) {
                throw new IllegalArgumentException("Specify attribute name.");
            }
            this.name = name;
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name.
         * </p>
         * 
         * @return Chainable API.
         */
        public SelectorDSL exist() {
            return attr(name, null, null, true);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name.
         * </p>
         * 
         * @param sub A sub style.
         */
        public void exist(Style sub) {
            exist().style(sub);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name.
         * </p>
         * 
         * @param value An attribute value.
         * @return Chainable API.
         */
        public SelectorDSL is(String value) {
            return attr(name, "", value, true);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name.
         * </p>
         * 
         * @param value An attribute value.
         * @param sub A sub style.
         */
        public void is(String value, Style sub) {
            is(value).style(sub);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr whose value is a
         * whitespace-separated list of words, one of which is exactly "value".
         * </p>
         * 
         * @param value An attribute value.
         * @return Chainable API.
         */
        public SelectorDSL isSpace(String value) {
            return attr(name, "~", value, true);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr whose value is a
         * whitespace-separated list of words, one of which is exactly "value".
         * </p>
         * 
         * @param value An attribute value.
         * @param sub A sub style.
         */
        public void isSpace(String value, Style sub) {
            isSpace(value).style(sub);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr. Its value can be exactly “value” or
         * can begin with “value” immediately followed by “-” (U+002D). It can be used for language
         * subcode matches.
         * </p>
         * 
         * @param value An attribute value.
         * @return Chainable API.
         */
        public SelectorDSL isHyphen(String value) {
            return attr(name, "|", value, true);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr. Its value can be exactly “value” or
         * can begin with “value” immediately followed by “-” (U+002D). It can be used for language
         * subcode matches.
         * </p>
         * 
         * @param value An attribute value.
         * @param sub A sub style.
         */
        public void isHyphen(String value, Style sub) {
            isHyphen(value).style(sub);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr and whose first value is prefixed by
         * "value".
         * </p>
         * 
         * @param value An attribute value.
         * @return Chainable API.
         */
        public SelectorDSL startsWith(String value) {
            return attr(name, "^", value, true);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr and whose first value is prefixed by
         * "value".
         * </p>
         * 
         * @param value An attribute value.
         * @param sub A sub style.
         */
        public void startsWith(String value, Style sub) {
            startsWith(value).style(sub);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr and whose last value is suffixed by
         * "value".
         * </p>
         * 
         * @param value An attribute value.
         * @return Chainable API.
         */
        public SelectorDSL endsWith(String value) {
            return attr(name, "$", value, true);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr and whose last value is suffixed by
         * "value".
         * </p>
         * 
         * @param value An attribute value.
         * @param sub A sub style.
         */
        public void endsWith(String value, Style sub) {
            endsWith(value).style(sub);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr and whose value contains at least
         * one occurrence of string "value" as substring.
         * </p>
         * 
         * @param value An attribute value.
         * @return Chainable API.
         */
        public SelectorDSL contains(String value) {
            return attr(name, "*", value, true);
        }

        /**
         * <p>
         * Attribute selectors select an element using the presence of a given attribute or
         * attribute value.
         * </p>
         * <p>
         * Represents an element with an attribute name of attr and whose value contains at least
         * one occurrence of string "value" as substring.
         * </p>
         * 
         * @param value An attribute value.
         * @param sub A sub style.
         */
        public void contains(String value, Style sub) {
            contains(value).style(sub);
        }
    }

    /**
     * @version 2016/09/18 18:59:10
     */
    private static class Selector extends SelectorDSL {

        /** The root selector. */
        private Selector root = this;

        /** The child selector. */
        private Selector child;

        /** The style creation processor. */
        private final Consumer<StyleRule> processor;

        /** The simple selector list. */
        private List<CharSequence> selectors = new ArrayList();

        /** The combinator. */
        private String combinator;

        /** The pseudo element. */
        private String pseudoElement;

        /** The pseudo class list. */
        private List<CharSequence> pseudoClasses = new ArrayList();

        /**
         * <p>
         * Create new selector.
         * </p>
         * 
         * @param processor
         */
        private Selector(Consumer<StyleRule> processor) {
            this.processor = processor;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        final SelectorDSL basic(String selector) {
            selectors.add(selector);

            return this;
        }

        /**
         * <p>
         * Write combinator.
         * </p>
         * 
         * @param type A combinator type.
         * @param forward A direction.
         * @return
         */
        @Override
        final SelectorDSL combine(String type, boolean forward) {
            Selector created = new Selector(processor);

            if (forward) {
                child = created;
                combinator = type;
                created.root = root;
            } else {
                created.child = this;
                created.combinator = type;
            }
            return created;
        }

        /**
         * <p>
         * Write pseudo class.
         * </p>
         * 
         * @param name A pseudo class name.
         * @return Chainable API.
         */
        @Override
        final SelectorDSL pseudo(boolean isElement, String name) {
            if (isElement) {
                pseudoElement = name;
            } else {
                pseudoClasses.add(name);
            }
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        final void style(Style sub) {
            StyleRule rule = PropertyDefinition.createSubRule(root.write(), sub);

            if (root.processor != null) {
                root.processor.accept(rule);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return root.write();
        }

        /**
         * <p>
         * Write down this selector.
         * </p>
         * 
         * @return A selector expression.
         */
        private String write() {
            StringBuilder builder = new StringBuilder();

            for (CharSequence selector : selectors) {
                builder.append(selector);
            }

            for (CharSequence pseudo : pseudoClasses) {
                builder.append(":").append(pseudo);
            }

            if (pseudoElement != null) {
                builder.append("::").append(pseudoElement);
            }

            if (combinator != null) {
                builder.append(combinator).append(child);
            }
            return builder.toString();
        }
    }
}
