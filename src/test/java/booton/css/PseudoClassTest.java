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
            hover(() -> {
                display.inline();
            });

            focus(() -> {
                display.inline();
            });

            active(() -> {
                display.inline();
            });
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
            link(() -> {
                display.inline();
            });

            visited(() -> {
                display.inline();
            });
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
            enabled(() -> {
                display.inline();
            });

            disabled(() -> {
                display.inline();
            });

            checked(() -> {
                display.inline();
            });

            indeterminate(() -> {
                display.inline();
            });

            optional(() -> {
                display.inline();
            });

            required(() -> {
                display.inline();
            });

            valid(() -> {
                display.inline();
            });

            invalid(() -> {
                display.inline();
            });
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
            firstChild(() -> {
                display.inline();
            });
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
            lastChild(() -> {
                display.inline();
            });
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
            nthChild("1", () -> {
                display.inline();
            });

            nthChild("2n", () -> {
                display.inline();
            });

            nthChild("odd", () -> {
                display.inline();
            });
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
            nthLastChild("1", () -> {
                display.inline();
            });

            nthLastChild("2n", () -> {
                display.inline();
            });

            nthLastChild("odd", () -> {
                display.inline();
            });
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
            firstOfType(() -> {
                display.inline();
            });
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
            lastOfType(() -> {
                display.inline();
            });
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
            nthOfType("1", () -> {
                display.inline();
            });

            nthOfType("2n", () -> {
                display.inline();
            });

            nthOfType("odd", () -> {
                display.inline();
            });
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
            nthLastOfType("1", () -> {
                display.inline();
            });

            nthLastOfType("2n", () -> {
                display.inline();
            });

            nthLastOfType("odd", () -> {
                display.inline();
            });
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
            onlyChild(() -> {
                display.inline();
            });
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
            onlyOfType(() -> {
                display.inline();
            });
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
            empty(() -> {
                display.inline();
            });
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
            not(Empty.class, () -> {
                display.inline();
            });
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
            active(() -> {
                invalid(() -> {
                    display.none();
                });
            });
        }
    }
}
