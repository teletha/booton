/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2012/12/12 14:07:44
 */
public class TextAlign extends CSSProperty<TextAlign> {

    /**
     * <p>
     * The inline contents are aligned to the left edge of the line box.
     * </p>
     * 
     * @return
     */
    public TextAlign left() {
        return chain("left");
    }

    /**
     * <p>
     * The inline contents are aligned to the right edge of the line box.
     * </p>
     * 
     * @return
     */
    public TextAlign right() {
        return chain("right");
    }

    /**
     * <p>
     * The inline contents are centered within the line box.
     * </p>
     * 
     * @return
     */
    public TextAlign center() {
        return chain("center");
    }

    /**
     * <p>
     * The text is justified. Text should line up their left and right edges to the left and right
     * content edges of the paragraph.
     * </p>
     * 
     * @return
     */
    public TextAlign justify() {
        return chain("justify");
    }

    /**
     * <p>
     * The same as left if direction is left-to-right and right if direction is right-to-left.
     * </p>
     * 
     * @return
     */
    public TextAlign start() {
        return chain("start");
    }

    /**
     * <p>
     * The same as right if direction is left-to-right and left if direction is right-to-left.
     * </p>
     * 
     * @return
     */
    public TextAlign end() {
        return chain("end");
    }
}
