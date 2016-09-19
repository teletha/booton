/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.value.Color;

/**
 * @version 2015/10/06 22:32:40
 */
public class Fill extends Colorable<Fill> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Fill color(Color color) {
        value("fill", color.toString());

        return this;
    }

    /**
     * <p>
     * Don't paint.
     * </p>
     * 
     * @return
     */
    public Fill none() {
        value("fill", "none");

        return this;
    }

    /**
     * <p>
     * The fill-opacity attribute specifies the opacity of the outline on the current object. Its
     * default value is 1.
     * </p>
     * 
     * @param opacity The opacity of the painting operation used to outline the current object, as a
     *            number. Any values outside the range 0.0 (fully transparent) to 1.0 (fully opaque)
     *            will be clamped to this range.
     */
    public Fill opacity(double opacity) {
        return value("fill-opacity", opacity);
    }
}
