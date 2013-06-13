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
 * @version 2013/06/08 2:22:03
 */
public class FlexWrap extends CSSProperty<FlexWrap> {

    /**
     * @param name
     */
    public FlexWrap() {
        super("flex-wrap");
    }

    /**
     * <p>
     * The flex items break into multiple lines. The cross-start is either equivalent to start or
     * before depending flex-direction value and the cross-end is the opposite of the specified
     * cross-start.
     * </p>
     * 
     * @return
     */
    public FlexWrap wrap() {
        return chain(nameWithPrefix("wrap"));
    }

    /**
     * <p>
     * The flex items are laid out in a single line which may cause the flex container to overflow.
     * The cross-start is either equivalent to start or before depending flex-direction value.
     * </p>
     * 
     * @return
     */
    public FlexWrap noWrap() {
        return chain(nameWithPrefix("nowrap").ie("none"));
    }

    /**
     * <p>
     * Behaves the same as wrap but cross-start and cross-end are permuted
     * </p>
     * 
     * @return
     */
    public FlexWrap wrapReverse() {
        return chain(nameWithPrefix("wrap-reverse"));
    }
}
