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
 * @version 2014/10/29 13:36:41
 */
public class TransitionTest extends StyleDeclarationTestBase {

    @Test
    public void rotate() {
        ValidatableStyleRule parsed = parse(MyStyle.rotate).rule();
        assert parsed.property("transition-property", "width");
        assert parsed.property("transition-duration", "1s");
        assert parsed.property("transition-delay", "0");
        assert parsed.property("transition-timing-function", "ease");
    }

    /**
     * @version 2014/10/29 14:38:37
     */
    private static class MyStyle extends StyleRuleDescriptor {

        private static StyleClass rotate = () -> {
            box.width(10, px);

            transit().duration(1, s).whenHover(() -> {
                box.width(20, px);
            });
        };
    }
}
