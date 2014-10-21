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
public class FlexboxTest extends StyleDeclarationTestBase {

    /** The style definition. */
    private static final Style style = new Style();

    @Test
    public void rgb() {
        ParsedStyle parsed = parse(style::standard);
        assert parsed.property("display", "flex");
        assert parsed.property("flex-direction", "row");
        assert parsed.property("align-content", "center");
    }

    /**
     * @version 2014/10/21 13:43:25
     */
    private static class Style extends StyleDeclaration {

        private void standard() {
            display.flex().direction.row().alignContent.center();
        }
    }
}
