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
 * @version 2012/12/15 1:07:56
 */
public class Text extends CSSProperty<Text> {

    /**
     * <p>
     * The text-decoration CSS property is used to set the text formatting to underline, overline,
     * line-through or blink.
     * </p>
     */
    public final Decration decoration = new Decration();

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return decoration.toString();
    }

    /**
     * @version 2012/12/15 1:12:52
     */
    public class Decration extends CSSProperty<Text> {

        /**
         * @param name
         * @param context
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
}
