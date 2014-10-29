/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.PropertyDefinition;

/**
 * @version 2014/10/29 12:41:08
 */
public class ListStyle extends PropertyDefinition<ListStyle> {

    /**
     * <p>
     * The list-style-image CSS property sets the image that will be used as the list item marker.
     * It is often more convenient to use the shorthand list-style.
     * </p>
     * 
     * @param uri
     * @return
     */
    public ListStyle image(String uri) {
        return value("list-style-image", "url('" + uri + "')");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * A hollow circle
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle circle() {
        return value("list-style-type", "circle");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * A filled square
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle square() {
        return value("list-style-type", "square");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Decimal numbers Beginning with 1.
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle decimal() {
        return value("list-style-type", "decimal");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Decimal numbers Padded by initial zeros (e.g., 01, 02, 03, ... 98, 99)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle decimalLeadingZero() {
        return value("list-style-type", "decimal-leading-zero");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Lowercase roman numerals (i, ii, iii, iv, v, etc.)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle lowerRoman() {
        return value("list-style-type", "lower-roman");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Lowercase roman numerals (i, ii, iii, iv, v, etc.)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle upperRoman() {
        return value("list-style-type", "upper-roman");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Lowercase classical Greek alpha, beta, gamma, ... (α, β, γ, ...)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle lowerGreek() {
        return value("list-style-type", "lower-greek");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Lowercase ASCII letters (a, b, c, ... z)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle lowerAlpha() {
        return value("list-style-type", "lower-alpha");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Uppercase ASCII letters (A, B, C, ... Z)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle upperAlpha() {
        return value("list-style-type", "upper-alpha");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Traditional Armenian numbering (ayb/ayp, ben/pen, gim/keem, ...)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle armenian() {
        return value("list-style-type", "armenian");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Traditional Georgian numbering (an, ban, gan, ... he, tan, in ...)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle georgian() {
        return value("list-style-type", "georgian");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * a, i, u, e, o, ka, ki, ... (Japanese)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle hiragana() {
        return value("list-style-type", "hiragana");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * A, I, U, E, O, KA, KI, ... (Japanese)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle katakana() {
        return value("list-style-type", "katakana");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * Plain ideographic numbers (Chinese-Japanese-Korean)
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle cjkIdeographic() {
        return value("list-style-type", "cjk-ideographic");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * i, ro, ha, ni, ho, he, to, ...
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle hiraganaIroha() {
        return value("list-style-type", "hiragana-iroha");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * I, RO, HA, NI, HO, HE, TO, ...
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle katakanaIroha() {
        return value("list-style-type", "katakana-iroha");
    }

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     * <p>
     * No item marker is shown.
     * </p>
     * 
     * @return Chainable API.
     */
    public ListStyle none() {
        return value("list-style-type", "none");
    }

    /**
     * <p>
     * The list-style-position CSS property specifies the position of the marker box in the
     * principal block box. It is often more convenient to use the shortcut list-style.
     * </p>
     * <p>
     * The marker box is the first inline box in the principal block box, after which the element's
     * content flows.
     * </p>
     * 
     * @return
     */
    public ListStyle inside() {
        return value("list-style-position", "inside");
    }

    /**
     * <p>
     * The list-style-position CSS property specifies the position of the marker box in the
     * principal block box. It is often more convenient to use the shortcut list-style.
     * </p>
     * <p>
     * The marker box is outside the principal block box.
     * </p>
     * 
     * @return
     */
    public ListStyle outside() {
        return value("list-style-position", "outside");
    }
}
