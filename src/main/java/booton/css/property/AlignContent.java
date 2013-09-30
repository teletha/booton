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

import static booton.css.Vendor.*;
import booton.css.CSSProperty;

/**
 * @version 2013/07/22 11:33:09
 */
public class AlignContent extends CSSProperty<AlignContent> {

    /**
     * <p>
     * Lines are packed starting from the cross-start. Cross-start edge of the first line and
     * cross-start edge of the flex container are flushed together. Each following line is flush
     * with the preceding.
     * </p>
     * 
     * @return
     */
    public AlignContent start() {
        return chain(prefixName("flex-start").ie("flex-line-pack", "start").omit(Mozilla));
    }

    /**
     * <p>
     * Lines are packed starting from the cross-end. Cross-end of the last line and cross-end of the
     * flex container are flushed together. Each preceding line is flushed with the following line.
     * </p>
     * 
     * @return
     */
    public AlignContent end() {
        return chain(prefixName("flex-end").ie("flex-line-pack", "end").omit(Mozilla));
    }

    /**
     * <p>
     * Lines are packed toward the center of the flex container. The lines are flushed with each
     * other and aligned in the center of the flex container. Space between the cross-start edge of
     * the flex container and first line and between cross-end of the flex container and the last
     * line is the same.
     * </p>
     * 
     * @return
     */
    public AlignContent center() {
        return chain(prefixName("center").ie("flex-line-pack", "center").omit(Mozilla));
    }

    /**
     * <p>
     * Lines are evenly distributed in the flex container. The spacing is done such as the space
     * between two adjacent items is the same. Cross-start edge and cross-end edge of the flex
     * container are flushed with respectively first and last line edges.
     * </p>
     * 
     * @return
     */
    public AlignContent spaceBetween() {
        return chain(prefixName("space-between").ie("flex-line-pack", "justify").omit(Mozilla));
    }

    /**
     * <p>
     * Lines are evenly distributed so that the space between two adjacent lines is the same. The
     * empty space before the first and after the last lines equals half of the space between two
     * adjacent lines.
     * </p>
     * 
     * @return
     */
    public AlignContent spaceAround() {
        return chain(prefixName("space-around").ie("flex-line-pack", "distribute").omit(Mozilla));
    }

    /**
     * <p>
     * Lines stretch to use the remaining space. The free-space is split equally between all the
     * lines.
     * </p>
     * 
     * @return
     */
    public AlignContent stretch() {
        return chain(prefixName("stretch").ie("flex-line-pack", "stretch").omit(Mozilla));
    }
}
