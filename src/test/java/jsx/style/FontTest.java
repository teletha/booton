/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/10/21 13:41:48
 */
public class FontTest extends StyleDeclarationTestBase {

    @Test
    public void rgb() {
        ValidatableStyleRule parsed = parse(MyStyle.rgb).rule();
        assert parsed.property("color", "rgb(255,0,0)");
    }

    @Test
    public void family() {
        ValidatableStyleRule parsed = parse(MyStyle.family).rule();
        assert parsed.property("font-family", "\"Source Sans Pro\",serif");
    }

    /**
     * @version 2014/10/21 13:43:25
     */
    private static class MyStyle extends StyleDescriptor {

        private static StyleClass rgb = () -> {
            font.color(255, 0, 0);
        };

        private static StyleClass family = () -> {
            font.family("http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600").serif();
        };
    }
}
