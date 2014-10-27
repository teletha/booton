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

import jsx.style.property.Display;
import jsx.style.property.Font;
import jsx.style.property.Position;

/**
 * @version 2014/10/25 11:22:51
 */
public class StyleDescriptor {

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
    protected static final Display display = new Display();

    /**
     * <p>
     * The font CSS property is either a shorthand property for setting font-style, font-variant,
     * font-weight, font-size, line-height and font-family, or a way to set the element's font to a
     * system font, using specific keywords.
     * </p>
     */
    protected static final Font font = new Font();

    /**
     * <p>
     * The position CSS property chooses alternative rules for positioning elements, designed to be
     * useful for scripted animation effects.
     * </p>
     */
    protected static final Position position = new Position();

    // The "require" functionality is useless. Use normal method call and post processor instead.
    //
    // "require" method make:
    // a{} a:hover{} b{require(a)} >>> a,b{} a:hover,b:hover{}
    //
    // post processor make:
    // a{} a:hover{} b{} b:hover{} >>> a,b{} a:hover,b:hover{}
    //
    // /**
    // * <p>
    // * Import other styles.
    // * </p>
    // *
    // * @param styles Styles to import.
    // */
    // protected final void require(Style... styles) {
    // }
}
