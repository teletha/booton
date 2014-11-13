/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import jsx.style.Style;
import jsx.style.StyleDeclarationTestBase;
import jsx.style.StyleDescriptor;

import org.junit.Test;

/**
 * @version 2014/11/13 11:17:00
 */
public class CalcTest extends StyleDeclarationTestBase {

    @Test
    public void none() throws Exception {
        ValidatableStyleRule parsed = parse(MyStyle.none).rule();
        assert parsed.size("width") == 1;
        assert parsed.property("width", "1px");
    }

    @Test
    public void add() throws Exception {
        ValidatableStyleRule parsed = parse(MyStyle.add).rule();
        assert parsed.size("width") == 2;
        assert parsed.property("width", "-webkit-calc(1px + 2em)");
        assert parsed.property("width", "calc(1px + 2em)");
    }

    @Test
    public void inPrefixedProperty() throws Exception {
        ValidatableStyleRule parsed = parse(MyStyle.inPrefixedProperty).rule();
        assert parsed.size("-webkit-transform") == 1;
        assert parsed.property("-webkit-transform", "translateY(-webkit-calc(1px + 2em))");
        assert parsed.size("transform") == 1;
        assert parsed.property("transform", "translateY(calc(1px + 2em))");
    }

    @Test
    public void noneInPrefixedProperty() throws Exception {
        ValidatableStyleRule parsed = parse(MyStyle.noneInPrefixedProperty).rule();
        assert parsed.size("-webkit-transform") == 1;
        assert parsed.property("-webkit-transform", "translateY(1px)");
        assert parsed.size("transform") == 1;
        assert parsed.property("transform", "translateY(1px)");
    }

    /**
     * @version 2014/11/13 11:17:40
     */
    private static class MyStyle extends StyleDescriptor {

        private static final Numeric one = new Numeric(1, px);

        private static final Numeric two = new Numeric(2, em);

        private static Style none = () -> {
            box.width(one);
        };

        private static Style add = () -> {
            box.width(one.add(two));
        };

        private static Style inPrefixedProperty = () -> {
            transform.translateY(one.add(two));
        };

        private static Style noneInPrefixedProperty = () -> {
            transform.translateY(one);
        };
    }
}
