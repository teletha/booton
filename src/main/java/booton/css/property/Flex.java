/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/09/04 2:53:17
 */
public class Flex extends CSSProperty<Flex> {

    /**
     * @param name
     */
    public Flex() {
        super("flex");
    }

    public Flex def() {
        return chain("1 1");
    }
}
