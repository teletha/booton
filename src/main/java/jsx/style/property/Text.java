/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import static jsx.style.value.Unit.*;

import jsx.style.PropertyDefinition;
import jsx.style.value.Color;
import jsx.style.value.Numeric;
import jsx.style.value.Shadow;
import jsx.style.value.Unit;
import kiss.I;

/**
 * @version 2016/09/18 11:46:14
 */
public class Text extends PropertyDefinition<Text> {

    /**
     * <p>
     * The text-align CSS property describes how inline content like text is aligned in its parent
     * block element. text-align does not control the alignment of block elements itself, only their
     * inline content.
     * </p>
     */
    public final Align align = new Align();

    /**
     * <p>
     * The text-decoration CSS property is used to set the text formatting to underline, overline,
     * line-through or blink.
     * </p>
     */
    public final Decration decoration = new Decration();

    /**
     * <p>
     * The text-overflow CSS property determines how overflowed content that is not displayed is
     * signaled to the users. It can be clipped, display an ellipsis ('…', U+2026 Horizontal
     * Ellipsis) or a Web author-defined string.
     * </p>
     */
    public final Overflow overflow = new Overflow();

    /**
     * <p>
     * The vertical-align CSS property specifies the vertical alignment of an inline or table-cell
     * element.
     * </p>
     */
    public final VerticalAlign verticalAlign = new VerticalAlign();

    /**
     * <p>
     * The text-indent CSS property specifies how much horizontal space should be left before the
     * beginning of the first line of the text content of an element. Horizontal spacing is with
     * respect to the left (or right, for right-to-left layout) edge of the containing block
     * element's box.
     * </p>
     */
    public Text indent(double size, Unit unit) {
        return indent(new Numeric(size, unit));
    }

    /**
     * <p>
     * The text-indent CSS property specifies how much horizontal space should be left before the
     * beginning of the first line of the text content of an element. Horizontal spacing is with
     * respect to the left (or right, for right-to-left layout) edge of the containing block
     * element's box.
     * </p>
     */
    public Text indent(Numeric size) {
        return value("text-indent", size);
    }

    /**
     * <p>
     * The text-shadow CSS property adds shadows to text. It accepts a comma-separated list of
     * shadows to be applied to the text and text-decorations of the element.
     * </p>
     * 
     * @return
     */
    public Text shadow(Shadow... shadows) {
        value("text-shadow", join(shadows, v -> v.toString()));

        return this;
    }

    /**
     * <p>
     * Helper method to write one-point text shadow. This method is equivalent to the following
     * code:
     * </p>
     * <pre>
     * text.shadow(color, 1);
     * </pre>
     *
     * @return
     */
    public Text shadow(Color color) {
        return shadow(color, 1);
    }

    /**
     * <p>
     * Helper method to write one-point text shadow.
     * </p>
     *
     * @param transparency A transparency of shadow.
     * @return
     */
    public Text shadow(Color color, double transparency) {
        color = new Color(0, 0, color.lightness < 50 ? 100 : 0, transparency);
        Shadow shadow1 = new Shadow().offset(1, 0, px).color(color);
        Shadow shadow2 = new Shadow().offset(0, 1, px).color(color);

        return shadow(shadow1, shadow2);
    }

    /**
     * <p>
     * Helper method to write outlined text.
     * </p>
     *
     * @param transparency A transparency of shadow.
     * @return
     */
    public Text outline(Color color, double transparency) {
        color = new Color(0, 0, color.lightness < 50 ? 100 : 0, transparency);
        Shadow shadow1 = new Shadow().offset(1, 0, px).color(color);
        Shadow shadow2 = new Shadow().offset(0, 1, px).color(color);
        Shadow shadow3 = new Shadow().offset(-1, 0, px).color(color);
        Shadow shadow4 = new Shadow().offset(0, -1, px).color(color);

        return shadow(shadow1, shadow2, shadow3, shadow4);
    }

    /**
     * <p>
     * Helper method to make text unselectable.
     * </p>
     */
    public Text unselectable() {
        value("user-select", "none");
        value("-moz-user-select", "none");
        value("-ms-user-select", "none");
        value("-webkit-user-select", "none");

        I.make(BuiltinStyle.class).unselectable.style();

        return this;
    }

    /**
     * @version 2014/10/28 17:56:37
     */
    public class Align extends PropertyDefinition<Text> {

        /**
         * Hide.
         */
        private Align() {
            super("text-align", Text.this);
        }

        /**
         * <p>
         * The inline contents are aligned to the left edge of the line box.
         * </p>
         * 
         * @return
         */
        public Text left() {
            return value("left");
        }

        /**
         * <p>
         * The inline contents are aligned to the right edge of the line box.
         * </p>
         * 
         * @return
         */
        public Text right() {
            return value("right");
        }

        /**
         * <p>
         * The inline contents are centered within the line box.
         * </p>
         * 
         * @return
         */
        public Text center() {
            return value("center");
        }

        /**
         * <p>
         * The text is justified. Text should line up their left and right edges to the left and
         * right content edges of the paragraph.
         * </p>
         * 
         * @return
         */
        public Text justify() {
            return value("justify");
        }

        /**
         * <p>
         * The same as left if direction is left-to-right and right if direction is right-to-left.
         * </p>
         * 
         * @return
         */
        public Text start() {
            return value("start");
        }

        /**
         * <p>
         * The same as right if direction is left-to-right and left if direction is right-to-left.
         * </p>
         * 
         * @return
         */
        public Text end() {
            return value("end");
        }
    }

    /**
     * @version 2014/10/28 17:56:46
     */
    public class VerticalAlign extends PropertyDefinition<Text> {

        /**
         * Hide.
         */
        private VerticalAlign() {
            super("vertical-align", Text.this);
        }

        /**
         * <p>
         * Aligns the baseline of the element with the baseline of its parent. The baseline of some
         * replaced elements, like <textarea> is not specified by the HTML specification, meaning
         * that their behavior with this keyword may change from one browser to the other.
         * </p>
         * 
         * @return
         */
        public Text baseline() {
            return value("baseline");
        }

        /**
         * <p>
         * Aligns the baseline of the element with the subscript-baseline of its parent.
         * </p>
         * 
         * @return
         */
        public Text sub() {
            return value("sub");
        }

        /**
         * <p>
         * Aligns the baseline of the element with the superscript-baseline of its parent.
         * </p>
         * 
         * @return
         */
        public Text sup() {
            return value("super");
        }

        /**
         * <p>
         * Aligns the top of the element with the top of the parent element's font.
         * </p>
         * 
         * @return
         */
        public Text textTop() {
            return value("text-top");
        }

        /**
         * <p>
         * Aligns the bottom of the element with the bottom of the parent element's font.
         * </p>
         * 
         * @return
         */
        public Text textBottom() {
            return value("text-bottom");
        }

        /**
         * <p>
         * Aligns the middle of the element with the middle of lowercase letters in the parent.
         * </p>
         * 
         * @return
         */
        public Text middle() {
            return value("middle");
        }

        /**
         * <p>
         * Align the top of the element and its descendants with the top of the entire line.
         * </p>
         * 
         * @return
         */
        public Text top() {
            return value("top");
        }

        /**
         * <p>
         * Align the bottom of the element and its descendants with the bottom of the entire line.
         * </p>
         * 
         * @return
         */
        public Text bottom() {
            return value("bottom");
        }
    }

    /**
     * @version 2014/10/28 17:57:00
     */
    public class Decration extends PropertyDefinition<Text> {

        /**
         * Hide.
         */
        private Decration() {
            super("text-decoration", Text.this);
        }

        /**
         * <p>
         * The text-decoration CSS property is used to set the text formatting to underline,
         * overline, line-through or blink.
         * </p>
         * <p>
         * Produces no text decoration.
         * </p>
         * 
         * @return
         */
        public Text none() {
            return value("none");
        }

        /**
         * <p>
         * The text-decoration CSS property is used to set the text formatting to underline,
         * overline, line-through or blink.
         * </p>
         * <p>
         * Each line of text is underlined.
         * </p>
         * 
         * @return
         */
        public Text underline() {
            return value("underline");
        }

        /**
         * <p>
         * The text-decoration CSS property is used to set the text formatting to underline,
         * overline, line-through or blink.
         * </p>
         * <p>
         * Each line of text has a line above it.
         * </p>
         * 
         * @return
         */
        public Text overline() {
            return value("overline");
        }

        /**
         * <p>
         * The text-decoration CSS property is used to set the text formatting to underline,
         * overline, line-through or blink.
         * </p>
         * <p>
         * Each line of text has a line through the middle.
         * </p>
         * 
         * @return
         */
        public Text lineThrough() {
            return value("line-through");
        }

        /**
         * <p>
         * Text blinks. Browsers may ignore this value (without making the declaration invalid), as
         * Internet Explorer and Safari does. Supported by Firefox (Gecko) and Opera. Note that not
         * blinking the text is one technique to satisfy checkpoint 3.3 of WAI-UAAG
         * </p>
         * 
         * @return
         */
        public Text blink() {
            return value("blink");
        }
    }

    /**
     * @version 2014/10/28 17:57:07
     */
    public class Overflow extends PropertyDefinition<Text> {

        /**
         * Hide.
         */
        private Overflow() {
            super("text-overflow", Text.this);
        }

        /**
         * <p>
         * This keyword value indicates to truncate the text at the limit of the content area,
         * therefore the truncation can happen in the middle of a character. To truncate at the
         * transition between two characters, the empty string value ('') must be used. The value
         * clip is the default for this property.
         * </p>
         * 
         * @return
         */
        public Text clip() {
            return value("clip");
        }

        /**
         * <p>
         * This keyword value indicates to display ellipses ('…', U+2026 Horizontal Ellipsis) to
         * represent clipped text. The ellipsis is displayed inside the content area, shortening
         * more the size of the displayed text. If there is not enough place to display ellipsis,
         * they are clipped.
         * 
         * @return
         */
        public Text ellipsis() {
            return value("ellipsis");
        }
    }
}
