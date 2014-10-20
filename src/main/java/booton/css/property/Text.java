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

import static booton.css.Unit.*;
import static booton.css.value.Color.*;

import java.util.ArrayList;
import java.util.List;

import kiss.I;
import booton.css.CSS;
import booton.css.CSSProperty;
import booton.css.StyleDeclarable;
import booton.css.Unit;
import booton.css.value.Color;
import booton.css.value.Numeric;

/**
 * @version 2012/12/16 15:39:53
 */
public class Text extends CSSProperty<Text> {

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

    /** The shadows. */
    private final List<ShadowValue> shadows = new ArrayList();

    /** The text-indent property. */
    private Numeric indent;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(StyleDeclarable writer) {
        super.write(writer);

        writer.property("text-indent", indent);
        writer.property("text-shadow", I.join(",", shadows));
    }

    /**
     * <p>
     * The text-indent CSS property specifies how much horizontal space should be left before the
     * beginning of the first line of the text content of an element. Horizontal spacing is with
     * respect to the left (or right, for right-to-left layout) edge of the containing block
     * element's box.
     * </p>
     */
    public Text indent(double size, Unit unit) {
        this.indent = new Numeric(size, unit);

        return chain();
    }

    /**
     * <p>
     * Helper method to write one-point text shadow. This method is equivalent to the following
     * code:
     * </p>
     * 
     * <pre>
     * text.shadow(1);
     * </pre>
     * 
     * @return
     */
    public Text shadow() {
        return shadow(1);
    }

    /**
     * <p>
     * Helper method to write one-point text shadow.
     * </p>
     * 
     * @param transparency A transparency of shadow.
     * @return
     */
    public Text shadow(double transparency) {
        Color color = new Color(0, 0, css.font.color().lightness < 50 ? 100 : 0, transparency);
        shadow(1, px, 0, px, 0, px, color);
        shadow(0, px, 1, px, 0, px, color);

        return this;
    }

    /**
     * <p>
     * Helper method to write outlined text.
     * </p>
     * 
     * @param transparency A transparency of shadow.
     * @return
     */
    public Text outline(double transparency) {
        Color color = new Color(0, 0, css.font.color().lightness < 50 ? 100 : 0, transparency);
        shadow(1, px, 0, px, 0, px, color);
        shadow(0, px, 1, px, 0, px, color);
        shadow(-1, px, 0, px, 0, px, color);
        shadow(0, px, -1, px, 0, px, color);

        return this;
    }

    /**
     * <p>
     * The text-shadow CSS property adds shadows to text. It accepts a comma-separated list of
     * shadows to be applied to the text and text-decorations of the element.
     * </p>
     * 
     * @param offsetX
     * @param unitX
     * @param offsetY
     * @param unitY
     * @param color
     * @return
     */
    public Text shadow(double offsetX, Unit unitX, double offsetY, Unit unitY, Color color) {
        ShadowValue shadow = new ShadowValue();
        shadow.offsetX = new Numeric(offsetX, unitX);
        shadow.offsetY = new Numeric(offsetY, unitY);
        shadow.color = color;
        shadows.add(shadow);

        return chain();
    }

    /**
     * <p>
     * The text-shadow CSS property adds shadows to text. It accepts a comma-separated list of
     * shadows to be applied to the text and text-decorations of the element.
     * </p>
     * 
     * @param offsetX
     * @param unitX
     * @param offsetY
     * @param unitY
     * @param blur
     * @param unitBlur
     * @return
     */
    public Text shadow(double offsetX, Unit unitX, double offsetY, Unit unitY, double blur, Unit unitBlur, Color color) {
        ShadowValue shadow = new ShadowValue();
        shadow.offsetX = new Numeric(offsetX, unitX);
        shadow.offsetY = new Numeric(offsetY, unitY);
        shadow.blur = new Numeric(blur, unitBlur);
        shadow.color = color;
        shadows.add(shadow);

        return chain();
    }

    /**
     * <p>
     * Helper method to make text unselectable.
     * </p>
     */
    public Text unselectable() {
        css.require(Unselectable.class);

        return chain();
    }

    /**
     * @version 2012/12/12 14:07:44
     */
    public class Align extends CSSProperty<Text> {

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
            return chain("left");
        }

        /**
         * <p>
         * The inline contents are aligned to the right edge of the line box.
         * </p>
         * 
         * @return
         */
        public Text right() {
            return chain("right");
        }

        /**
         * <p>
         * The inline contents are centered within the line box.
         * </p>
         * 
         * @return
         */
        public Text center() {
            return chain("center");
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
            return chain("justify");
        }

        /**
         * <p>
         * The same as left if direction is left-to-right and right if direction is right-to-left.
         * </p>
         * 
         * @return
         */
        public Text start() {
            return chain("start");
        }

        /**
         * <p>
         * The same as right if direction is left-to-right and left if direction is right-to-left.
         * </p>
         * 
         * @return
         */
        public Text end() {
            return chain("end");
        }
    }

    /**
     * @version 2012/12/12 14:07:44
     */
    public class VerticalAlign extends CSSProperty<Text> {

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
            return chain("baseline");
        }

        /**
         * <p>
         * Aligns the baseline of the element with the subscript-baseline of its parent.
         * </p>
         * 
         * @return
         */
        public Text sub() {
            return chain("sub");
        }

        /**
         * <p>
         * Aligns the baseline of the element with the superscript-baseline of its parent.
         * </p>
         * 
         * @return
         */
        public Text sup() {
            return chain("super");
        }

        /**
         * <p>
         * Aligns the top of the element with the top of the parent element's font.
         * </p>
         * 
         * @return
         */
        public Text textTop() {
            return chain("text-top");
        }

        /**
         * <p>
         * Aligns the bottom of the element with the bottom of the parent element's font.
         * </p>
         * 
         * @return
         */
        public Text textBottom() {
            return chain("text-bottom");
        }

        /**
         * <p>
         * Aligns the middle of the element with the middle of lowercase letters in the parent.
         * </p>
         * 
         * @return
         */
        public Text middle() {
            return chain("middle");
        }

        /**
         * <p>
         * Align the top of the element and its descendants with the top of the entire line.
         * </p>
         * 
         * @return
         */
        public Text top() {
            return chain("top");
        }

        /**
         * <p>
         * Align the bottom of the element and its descendants with the bottom of the entire line.
         * </p>
         * 
         * @return
         */
        public Text bottom() {
            return chain("bottom");
        }
    }

    /**
     * @version 2012/12/15 1:12:52
     */
    public class Decration extends CSSProperty<Text> {

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
            return chain("none");
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
            return chain("underline");
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
            return chain("overline");
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
            return chain("line-through");
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
            return chain("blink");
        }
    }

    /**
     * @version 2013/04/02 11:22:24
     */
    public class Overflow extends CSSProperty<Text> {

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
            return chain("clip");
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
            return chain("ellipsis");
        }
    }

    /**
     * @version 2013/07/25 11:39:57
     */
    private static class Unselectable extends CSS {

        {
            userSelect.none();
            cursor.defaults();

            selection(() -> {
                background.color(Transparent);
            });
        }
    }
}
