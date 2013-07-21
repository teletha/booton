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

import booton.css.value.Color;
import booton.css.value.Value;

/**
 * @version 2012/12/16 15:36:06
 */
class ShadowValue {

    /** The shadow property. */
    boolean inset = false;

    /** The shadow property. */
    Value offsetX;

    /** The shadow property. */
    Value offsetY;

    /** The shadow property. */
    Value blur;

    /** The shadow property. */
    Value spread;

    /** The color property. */
    Color color;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (inset) builder.append("inset ");
        if (offsetX != null) builder.append(offsetX).append(" ");
        if (offsetY != null) builder.append(offsetY).append(" ");
        if (blur != null) builder.append(blur).append(" ");
        if (spread != null) builder.append(spread).append(" ");
        if (color != null) builder.append(color);

        return builder.toString();
    }
}
