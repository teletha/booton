/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.PropertyDefinition;
import jsx.style.value.Numeric;
import booton.css.Unit;

/**
 * @version 2014/10/29 12:39:14
 */
public class Line extends PropertyDefinition<Line> {

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     * 
     * @param size
     * @return
     */
    public Line height(double size) {
        return value("line-height", size);
    }

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     * 
     * @param size
     * @return
     */
    public Line height(Numeric size) {
        return value("line-height", size);
    }

    /**
     * <p>
     * On inline elements, the line-height CSS property specifies the height that is used in the
     * calculation of the line box height. On block level elements, line-height specifies the
     * minimal height of line boxes within the element.
     * </p>
     * 
     * @param size
     * @return
     */
    public Line height(double size, Unit unit) {
        return height(new Numeric(size, unit));
    }
}
