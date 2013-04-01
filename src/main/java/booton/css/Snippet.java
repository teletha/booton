/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import static booton.css.CSS.*;
import js.util.Color;
import booton.util.Font;

/**
 * @version 2013/03/24 16:07:10
 */
public class Snippet {

    private static final Font Icons = new Font("icon.css");

    /**
     * <p>
     * Apply bubble border box style.
     * </p>
     * 
     * @param bubbleHeight
     */
    public static final void createBottomBubble(int bubbleHeight) {
        CSS css = CSS.current;

        Value borderWidth = css.border.width();
        Color borderColor = css.border.color();
        Color boxBackColor = css.background.color();

        if (!css.position.isAbsolute() && !css.position.isRelative()) {
            css.position.relative();
        }

        Value width = borderWidth.add(bubbleHeight);

        // write bubble border color
        while (css.before()) {
            css.display.block();
            css.box.size(0, px);
            css.content.text("");
            css.position.absolute().left(50, percent).top(100, percent);
            css.margin.left(width.opposite());
            css.border.solid().color.transparent().width(width);
            css.borderTop.color(borderColor);
        }

        // write bubble background color
        if (borderWidth.size != 0) {
            width = width.subtract(borderWidth.multiply(1.5));

            while (css.after()) {
                css.display.block();
                css.box.size(0, px);
                css.content.text("");
                css.position.absolute().left(50, percent).top(100, percent);
                css.margin.left(width.opposite());
                css.border.solid().color.transparent().width(width);
                css.borderTop.color(boxBackColor.opacify(1));
            }
        }
    }

    /**
     * <p>
     * Write icon in before pseudo element.
     * </p>
     * 
     * @param icon
     */
    public static final void write(Icon icon) {
        CSS css = CSS.current;

        Color color = css.border.color();

        while (css.before()) {
            css.font.color(color.lighten(-40)).family(Icons);
            css.content.text(icon.code);
        }
    }

    /**
     * @version 2013/04/01 20:01:08
     */
    public static enum Icon {

        /** The icon. */
        BottomArrow("e75c");

        /** The unicode. */
        public final String code;

        /**
         * <p>
         * Specify character code for icon.
         * </p>
         * 
         * @param unicode
         */
        private Icon(String unicode) {
            this.code = "\\" + unicode;
        }
    }
}
