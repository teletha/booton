/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import org.junit.Test;

/**
 * @version 2014/11/15 12:58:36
 */
public class PseudoClassTest extends StyleTester {

    @Test
    public void interaction() {
        ValidatableStyle parsed = writeStyle(() -> {
            hover(() -> {
                font.size(1, px);
            });

            focus(() -> {
                font.size(2, px);
            });

            active(() -> {
                font.size(3, px);
            });
        });
        assert parsed.sub("hover").property("font-size", "1px");
        assert parsed.sub("focus").property("font-size", "2px");
        assert parsed.sub("active").property("font-size", "3px");
    }

    @Test
    public void Link() {
        ValidatableStyle parsed = writeStyle(() -> {
            link(() -> {
                font.size(1, px);
            });

            visited(() -> {
                font.size(2, px);
            });
        });
        assert parsed.sub("link").property("font-size", "1px");
        assert parsed.sub("visited").property("font-size", "2px");
    }

    @Test
    public void form() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            enabled(() -> {
                font.size(1, px);
            });

            disabled(() -> {
                font.size(2, px);
            });

            checked(() -> {
                font.size(3, px);
            });

            indeterminate(() -> {
                font.size(4, px);
            });

            optional(() -> {
                font.size(5, px);
            });

            required(() -> {
                font.size(6, px);
            });

            valid(() -> {
                font.size(7, px);
            });

            invalid(() -> {
                font.size(8, px);
            });
        });

        assert parsed.sub("enabled").property("font-size", "1px");
        assert parsed.sub("disabled").property("font-size", "2px");
        assert parsed.sub("checked").property("font-size", "3px");
        assert parsed.sub("indeterminate").property("font-size", "4px");
        assert parsed.sub("optional").property("font-size", "5px");
        assert parsed.sub("required").property("font-size", "6px");
        assert parsed.sub("valid").property("font-size", "7px");
        assert parsed.sub("invalid").property("font-size", "8px");
    }

    @Test
    public void FirstChild() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            firstChild(() -> {
                font.size(1, px);
            });
        });
        assert parsed.sub("first-child").property("font-size", "1px");
    }

    @Test
    public void LastChild() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            lastChild(() -> {
                font.size(1, px);
            });
        });
        assert parsed.sub("last-child").property("font-size", "1px");
    }

    @Test
    public void nthChild() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            nthChild("1", () -> {
                font.size(1, px);
            });

            nthChild("2n", () -> {
                font.size(1, px);
            });

            nthChild("odd", () -> {
                font.size(1, px);
            });
        });

        assert parsed.sub("nth-child(1)").property("font-size", "1px");
        assert parsed.sub("nth-child(2n)").property("font-size", "1px");
        assert parsed.sub("nth-child(odd)").property("font-size", "1px");
    }

    @Test
    public void nthLastChild() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            nthLastChild("1", () -> {
                font.size(1, px);
            });

            nthLastChild("2n", () -> {
                font.size(1, px);
            });

            nthLastChild("odd", () -> {
                font.size(1, px);
            });
        });

        assert parsed.sub("nth-last-child(1)").property("font-size", "1px");
        assert parsed.sub("nth-last-child(2n)").property("font-size", "1px");
        assert parsed.sub("nth-last-child(odd)").property("font-size", "1px");
    }

    @Test
    public void FirstType() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            firstOfType(() -> {
                font.size(1, px);
            });
        });

        assert parsed.sub("first-of-type").property("font-size", "1px");
    }

    @Test
    public void LastType() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            lastType(() -> {
                font.size(1, px);
            });
        });

        assert parsed.sub("last-of-type").property("font-size", "1px");
    }

    @Test
    public void nthType() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            nthType("1", () -> {
                font.size(1, px);
            });

            nthType("2n", () -> {
                font.size(1, px);
            });

            nthType("odd", () -> {
                font.size(1, px);
            });
        });

        assert parsed.sub("nth-of-type(1)").property("font-size", "1px");
        assert parsed.sub("nth-of-type(2n)").property("font-size", "1px");
        assert parsed.sub("nth-of-type(odd)").property("font-size", "1px");
    }

    @Test
    public void nthLastType() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            nthLastType("1", () -> {
                font.size(1, px);
            });

            nthLastType("2n", () -> {
                font.size(1, px);
            });

            nthLastType("odd", () -> {
                font.size(1, px);
            });
        });

        assert parsed.sub("nth-last-of-type(1)").property("font-size", "1px");
        assert parsed.sub("nth-last-of-type(2n)").property("font-size", "1px");
        assert parsed.sub("nth-last-of-type(odd)").property("font-size", "1px");
    }

    @Test
    public void OnlyChild() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            onlyChild(() -> {
                font.size(1, px);
            });
        });
        assert parsed.sub("only-child").property("font-size", "1px");
    }

    @Test
    public void OnlyType() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            onlyType(() -> {
                font.size(1, px);
            });
        });
        assert parsed.sub("only-of-type").property("font-size", "1px");
    }

    @Test
    public void Empty() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            empty(() -> {
                font.size(1, px);
            });
        });
        assert parsed.sub("empty").property("font-size", "1px");
    }

    private static Style E = () -> {
    };

    @Test
    public void not() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            not(E, () -> {
                font.size(1, px);
            });
        });
        assert parsed.sub("not(." + E.name() + ")").property("font-size", "1px");
    }

    @Test
    public void nest() throws Exception {
        ValidatableStyle parsed = writeStyle(() -> {
            active(() -> {
                invalid(() -> {
                    font.size(1, px);
                });
            });
        });
        assert parsed.sub("active:invalid").property("font-size", "1px");
    }
}
