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
import booton.css.Unit;
import booton.css.value.Numeric;

/**
 * @version 2014/09/04 1:48:48
 */
public class FlexBasis extends CSSProperty<FlexBasis> {

    /**
     * @param name
     */
    public FlexBasis() {
        super("flex-basis");
    }

    public FlexBasis size(int size, Unit unit) {
        return chain(new Numeric(size, unit));
    }
}
