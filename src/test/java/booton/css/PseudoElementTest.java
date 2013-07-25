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

import kiss.I;

import org.junit.Test;

/**
 * @version 2013/07/24 8:53:36
 */
public class PseudoElementTest {

    @Test
    public void content() throws Exception {
        MyCSS css = I.make(Content.class);
        assert css.hasSelector(Content.class, "::before");
        assert css.hasSelector(Content.class, "::after");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Content extends MyCSS {

        {
            while (before()) {
                display.inline();
            }

            while (after()) {
                display.inline();
            }
        }
    }

    @Test
    public void text() throws Exception {
        MyCSS css = I.make(Text.class);
        assert css.hasSelector(Text.class, "::first-letter");
        assert css.hasSelector(Text.class, "::first-line");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Text extends MyCSS {

        {
            while (firstLetter()) {
                display.inline();
            }

            while (firstLine()) {
                display.inline();
            }
        }
    }

    @Test
    public void select() throws Exception {
        MyCSS css = I.make(Select.class);
        assert css.countSelector() == 2;
        assert css.countProperty() == 2;
        assert css.countRule() == 2;
        assert css.hasSelector(Select.class, "::selection");
        assert css.hasSelector(Select.class, "::-moz-selection");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Select extends MyCSS {

        {
            while (selection()) {
                display.inline();
            }
        }
    }
}
