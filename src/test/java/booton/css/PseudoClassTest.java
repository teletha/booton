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
public class PseudoClassTest {

    @Test
    public void interaction() throws Exception {
        MyCSS css = I.make(Interaction.class);
        assert css.countSelector() == 3;
        assert css.hasSelector(Interaction.class, ":hover");
        assert css.hasSelector(Interaction.class, ":focus");
        assert css.hasSelector(Interaction.class, ":active");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Interaction extends MyCSS {

        {
            while (hover()) {
                display.inline();
            }

            while (focus()) {
                display.inline();
            }

            while (active()) {
                display.inline();
            }
        }
    }

    @Test
    public void link() throws Exception {
        MyCSS css = I.make(Link.class);
        assert css.countSelector() == 2;
        assert css.hasSelector(Link.class, ":link");
        assert css.hasSelector(Link.class, ":visited");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Link extends MyCSS {

        {
            while (link()) {
                display.inline();
            }

            while (visited()) {
                display.inline();
            }
        }
    }

    @Test
    public void form() throws Exception {
        MyCSS css = I.make(Form.class);
        assert css.hasSelector(Form.class, ":enabled");
        assert css.hasSelector(Form.class, ":disabled");
        assert css.hasSelector(Form.class, ":checked");
        assert css.hasSelector(Form.class, ":indeterminate");
        assert css.hasSelector(Form.class, ":optional");
        assert css.hasSelector(Form.class, ":required");
        assert css.hasSelector(Form.class, ":valid");
        assert css.hasSelector(Form.class, ":invalid");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Form extends MyCSS {

        {
            while (enabled()) {
                display.inline();
            }

            while (disabled()) {
                display.inline();
            }

            while (checked()) {
                display.inline();
            }

            while (indeterminate()) {
                display.inline();
            }

            while (optional()) {
                display.inline();
            }

            while (required()) {
                display.inline();
            }

            while (valid()) {
                display.inline();
            }

            while (invalid()) {
                display.inline();
            }
        }
    }

    @Test
    public void firstChild() throws Exception {
        MyCSS css = I.make(FirstChild.class);
        assert css.countSelector() == 1;
        assert css.hasSelector(FirstChild.class, ":first-child");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class FirstChild extends MyCSS {

        {
            while (firstChild()) {
                display.inline();
            }
        }
    }

    @Test
    public void lastChild() throws Exception {
        MyCSS css = I.make(LastChild.class);
        assert css.countSelector() == 1;
        assert css.hasSelector(LastChild.class, ":last-child");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class LastChild extends MyCSS {

        {
            while (lastChild()) {
                display.inline();
            }
        }
    }

    @Test
    public void nthChild() throws Exception {
        MyCSS css = I.make(NthChild.class);
        assert css.countSelector() == 3;
        assert css.hasSelector(NthChild.class, ":nth-child(1)");
        assert css.hasSelector(NthChild.class, ":nth-child(2n)");
        assert css.hasSelector(NthChild.class, ":nth-child(odd)");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class NthChild extends MyCSS {

        {
            while (nthChild("1")) {
                display.inline();
            }

            while (nthChild("2n")) {
                display.inline();
            }

            while (nthChild("odd")) {
                display.inline();
            }
        }
    }

    @Test
    public void nthLastChild() throws Exception {
        MyCSS css = I.make(NthLastChild.class);
        assert css.countSelector() == 3;
        assert css.hasSelector(NthLastChild.class, ":nth-last-child(1)");
        assert css.hasSelector(NthLastChild.class, ":nth-last-child(2n)");
        assert css.hasSelector(NthLastChild.class, ":nth-last-child(odd)");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class NthLastChild extends MyCSS {

        {
            while (nthLastChild("1")) {
                display.inline();
            }

            while (nthLastChild("2n")) {
                display.inline();
            }

            while (nthLastChild("odd")) {
                display.inline();
            }
        }
    }

    @Test
    public void firstType() throws Exception {
        MyCSS css = I.make(FirstType.class);
        assert css.countSelector() == 1;
        assert css.hasSelector(FirstType.class, ":first-of-type");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class FirstType extends MyCSS {

        {
            while (firstOfType()) {
                display.inline();
            }
        }
    }

    @Test
    public void lastType() throws Exception {
        MyCSS css = I.make(LastType.class);
        assert css.countSelector() == 1;
        assert css.hasSelector(LastType.class, ":last-of-type");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class LastType extends MyCSS {

        {
            while (lastOfType()) {
                display.inline();
            }
        }
    }

    @Test
    public void nthType() throws Exception {
        MyCSS css = I.make(NthType.class);
        assert css.countSelector() == 3;
        assert css.hasSelector(NthType.class, ":nth-of-type(1)");
        assert css.hasSelector(NthType.class, ":nth-of-type(2n)");
        assert css.hasSelector(NthType.class, ":nth-of-type(odd)");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class NthType extends MyCSS {

        {
            while (nthOfType("1")) {
                display.inline();
            }

            while (nthOfType("2n")) {
                display.inline();
            }

            while (nthOfType("odd")) {
                display.inline();
            }
        }
    }

    @Test
    public void nthLastType() throws Exception {
        MyCSS css = I.make(NthLastType.class);
        assert css.countSelector() == 3;
        assert css.hasSelector(NthLastType.class, ":nth-last-of-type(1)");
        assert css.hasSelector(NthLastType.class, ":nth-last-of-type(2n)");
        assert css.hasSelector(NthLastType.class, ":nth-last-of-type(odd)");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class NthLastType extends MyCSS {

        {
            while (nthLastOfType("1")) {
                display.inline();
            }

            while (nthLastOfType("2n")) {
                display.inline();
            }

            while (nthLastOfType("odd")) {
                display.inline();
            }
        }
    }

    @Test
    public void onlyChild() throws Exception {
        MyCSS css = I.make(OnlyChild.class);
        assert css.countSelector() == 1;
        assert css.hasSelector(OnlyChild.class, ":only-child");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class OnlyChild extends MyCSS {

        {
            while (onlyChild()) {
                display.inline();
            }
        }
    }

    @Test
    public void onlyType() throws Exception {
        MyCSS css = I.make(OnlyType.class);
        assert css.countSelector() == 1;
        assert css.hasSelector(OnlyType.class, ":only-of-type");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class OnlyType extends MyCSS {

        {
            while (onlyOfType()) {
                display.inline();
            }
        }
    }

    @Test
    public void empty() throws Exception {
        MyCSS css = I.make(Empty.class);
        assert css.countSelector() == 1;
        assert css.hasSelector(Empty.class, ":empty");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Empty extends MyCSS {

        {
            while (empty()) {
                display.inline();
            }
        }
    }

    @Test
    public void not() throws Exception {
        MyCSS css = I.make(Not.class);
        assert css.hasSelector(Not.class, ":not(", Empty.class, ")");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Not extends MyCSS {

        {
            while (not(Empty.class)) {
                display.inline();
            }
        }
    }

    @Test
    public void nest() throws Exception {
        MyCSS css = I.make(Nest.class);
        assert css.hasSelector(Nest.class, ":active:invalid");
    }

    /**
     * @version 2013/07/24 9:08:22
     */
    private static class Nest extends MyCSS {

        {
            while (active()) {
                while (invalid()) {
                    display.none();
                }
            }
        }
    }
}
