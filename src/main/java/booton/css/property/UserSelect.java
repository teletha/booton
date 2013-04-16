/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import booton.css.CSSProperty;

/**
 * @version 2013/01/15 21:39:18
 */
public class UserSelect extends CSSProperty<UserSelect> {

    /**
     * Hide.
     */
    public UserSelect() {
        super("user-select", null, true);
    }

    /**
     * <p>
     * The text of the element and sub-elements will appear as if they cannot be selected. Any use
     * of Selection however will contain these elements.
     * </p>
     * 
     * @return
     */
    public UserSelect none() {
        return chain("none");
    }

    /**
     * <p>
     * The text can be selected by the user.
     * </p>
     * 
     * @return
     */
    public UserSelect text() {
        return chain("text");
    }

    /**
     * <p>
     * In an HTML editor, if a double-click or context-click occurred in sub-elements, the highest
     * ancestor with this value will be selected.
     * </p>
     * 
     * @return
     */
    public UserSelect all() {
        return chain("all");
    }

    /**
     * <p>
     * Supported in Firefox and Internet Explorer. Enables selection to start within the element;
     * however, the selection will be contained by the bounds of that element.
     * </p>
     * 
     * @return
     */
    public UserSelect element() {
        return chain("element");
    }
}
