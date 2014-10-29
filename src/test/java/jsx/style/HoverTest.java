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
 * @version 2014/10/21 14:44:20
 */
public class HoverTest extends StyleDeclarationTestBase {

    @Test
    public void hover() {
        ValidatableStyleRule parsed = parse(MyStyle.hovers).rule();
        assert parsed.property("color", "rgb(255,0,0)");

        ValidatableStyleRule hover = parsed.sub("hover");
        assert hover.property("color", "rgb(0,255,0)");
    }

    /**
     * @version 2014/10/21 13:43:25
     */
    private static class MyStyle extends StyleRuleDescriptor {

        private static Style hovers = () -> {
            font.color(255, 0, 0);

            hover(() -> {
                font.color(0, 255, 0);
            });
        };
    }
}
