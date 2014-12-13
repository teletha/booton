/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.style;

import js.dom.Element;

/**
 * @version 2014/12/13 15:06:51
 */
public interface RuntimeStyle {

    /**
     * <p>
     * Apply this style to the specified element.
     * </p>
     * 
     * @param dom A element to apply this style.
     */
    void apply(Element dom);
}
