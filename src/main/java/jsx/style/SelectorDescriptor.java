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
import java.util.Objects;
import java.util.function.BiConsumer;

import jsx.ui.Style;
import jsx.ui.flux.Location;

/**
 * @version 2016/09/17 16:18:29
 */
public class SelectorDescriptor {

    /** The root element. */
    private Element root = new Element();

    /** The current element. */
    private Element element = root;

    private BiConsumer<String, Style> process;

    /**
     * <p>
     * Create blank selector descriptor.
     * </p>
     */
    SelectorDescriptor() {
        this(PropertyDefinition::createSubRule);
    }

    /**
     * @param object
     */
    public SelectorDescriptor(BiConsumer<String, Style> process) {
        this.process = process;

        root.selectors.add("$");
    }

    public SelectorDescriptor at(Location location) {
        element.selectors.add("." + location.name());

        return this;
    }

    public AttributeSelector attribute(String name) {
        return new AttributeSelector(Objects.requireNonNull(name));
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
    public SelectorDescriptor ancestor() {
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
     * @return Chainable API.
     */
    public SelectorDescriptor descendant() {
        return combine(" ", true);
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
    public SelectorDescriptor parent() {
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
    public SelectorDescriptor child() {
        return combine(">", true);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public SelectorDescriptor prev() {
        return combine("+", false);
    }

    /**
     * <p>
     * This is referred to as an adjacent selector or next-sibling selector. It will select only the
     * specified element that immediately follows the former specified element.
     * </p>
     * 
     * @return Chainable API.
     */
    public SelectorDescriptor next() {
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
    public SelectorDescriptor prevs() {
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
    public SelectorDescriptor nexts() {
        return combine("~", true);
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
    private SelectorDescriptor combine(String type, boolean forward) {
        Element e = element;

        if (forward) {
            e.sub = element = new Element();
            e.combinator = type;
        } else {
            root = element = new Element();
            root.sub = e;
            root.combinator = type;
        }
        return this;
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
    public SelectorDescriptor checked() {
        return clazz("checked");
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
    public SelectorDescriptor hover() {
        return clazz("hover");
    }

    /**
     * <p>
     * Write pseudo class.
     * </p>
     * 
     * @param clazz A pseudo class name.
     * @return Chainable API.
     */
    private SelectorDescriptor clazz(String clazz) {
        element.pseudoClasses.add(clazz);
        return this;
    }

    public void style(Style sub) {
        process.accept(root.toString(), sub);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return root.toString();
    }

    /**
     * @version 2016/09/17 16:20:33
     */
    public class AttributeSelector {

        private final StringBuilder selector = new StringBuilder();

        /**
         * @param name
         */
        private AttributeSelector(String name) {
            selector.append("[").append(name);

            element.selectors.add(selector);
        }

        public SelectorDescriptor has() {
            selector.append("]");

            return SelectorDescriptor.this;
        }

        public SelectorDescriptor match(String value) {
            selector.append("=").append(value).append("]");

            return SelectorDescriptor.this;
        }

        public SelectorDescriptor matchWithSpace(String value) {
            selector.append("~=").append(value).append("]");

            return SelectorDescriptor.this;
        }

        public SelectorDescriptor matchWithHyphen(String value) {
            selector.append("|=").append(value).append("]");

            return SelectorDescriptor.this;
        }

        public SelectorDescriptor startsWith(String value) {
            selector.append("^=").append(value).append("]");

            return SelectorDescriptor.this;
        }

        public SelectorDescriptor endsWith(String value) {
            selector.append("$=").append(value).append("]");

            return SelectorDescriptor.this;
        }

        public SelectorDescriptor contains(String value) {
            selector.append("*=").append(value).append("]");

            return SelectorDescriptor.this;
        }
    }

    private static class Element {

        List<CharSequence> selectors = new ArrayList();

        String combinator;

        List<CharSequence> pseudoClasses = new ArrayList();

        Element sub;

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            for (CharSequence selector : selectors) {
                builder.append(selector);
            }

            for (CharSequence pseudo : pseudoClasses) {
                builder.append(":").append(pseudo);
            }

            if (combinator != null) {
                builder.append(combinator).append(sub);
            }
            return builder.toString();
        }
    }

    private static class Combinator {

    }

    private static class PseudoClass {

    }

    private static class PseudoElement {

    }
}
