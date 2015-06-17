/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.html;

import jsx.style.Style;

/**
 * @version 2014/12/02 13:56:56
 */
public class DSLElement {

    public DSLElement clazz(Style style, Runnable sub) {
        return this;
    }
}
