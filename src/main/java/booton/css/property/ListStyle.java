/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import booton.css.CSSProperty;
import booton.css.StyleDeclarable;

/**
 * @version 2012/12/14 23:53:43
 */
public class ListStyle extends CSSProperty<ListStyle> {

    /**
     * <p>
     * The list-style-type CSS property specifies appearance of a list item element. As it is the
     * only one who defaults to display:list-item, this is usually a lielement, but can be any
     * element with this display value.
     * </p>
     */
    private String type;

    /**
     * <p>
     * The list-style-position CSS property specifies the position of the marker box in the
     * principal block box. It is often more convenient to use the shortcut list-style.
     * </p>
     */
    private String position;

    /** The image uri. */
    private String image;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(StyleDeclarable writer) {
        writer.property("list-style", image, type, position);
    }

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
        image = "url(\"" + uri + "\")";

        return chain();
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
        type = "circle";

        return chain();
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
        type = "square";

        return chain();
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
        type = "decimal";

        return chain();
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
        type = "decimal-leading-zero";

        return chain();
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
        type = "lower-roman";

        return chain();
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
        type = "upper-roman";

        return chain();
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
        type = "lower-greek";

        return chain();
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
        type = "lower-alpha";

        return chain();
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
        type = "upper-alpha ";

        return chain();
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
        type = "armenian";

        return chain();
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
        type = "georgian";

        return chain();
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
        type = "hiragana";

        return chain();
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
        type = "katakana";

        return chain();
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
        type = "cjk-ideographic";

        return chain();
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
        type = "hiragana-iroha";

        return chain();
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
        type = "katakana-iroha";

        return chain();
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
        type = "none";

        return chain();
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
        position = "inside";

        return chain();
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
        position = "outside";

        return chain();
    }

}
