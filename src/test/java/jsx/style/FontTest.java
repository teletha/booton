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

    /**
     * @version 2014/10/21 13:43:25
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style rgb = () -> {
            font.color(255, 0, 0);
        };
    }
}
