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

import jsx.ui.Widget;
import kiss.Extensible;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2014/10/15 11:12:05
 */
@Manageable(lifestyle = Singleton.class)
public class Style<W extends Widget> implements Extensible {

    // /**
    // * <p>
    // * The display CSS property specifies the type of rendering box used for an element. In HTML,
    // * default display property values are taken from behaviors described in the HTML
    // specifications
    // * or from the browser/user default stylesheet. The default value in XML is inline.
    // * </p>
    // * <p>
    // * In addition to the many different display box types, the value none lets you turn off the
    // * display of an element; when you use none, all child elements also have their display turned
    // * off. The document is rendered as though the element doesn't exist in the document tree.
    // * </p>
    // */
    // public Display display;

}
