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
 * @version 2014/10/28 16:18:03
 */
public class CursorTest extends StyleDeclarationTestBase {

    @Test
    public void rgb() {
        ValidatableStyleRule parsed = parse(MyStyle.help).rule();
        assert parsed.property("cursor", "help");

        parsed = parse(MyStyle.alias).rule();
        assert parsed.property("cursor", "alias");

        parsed = parse(MyStyle.copy).rule();
        assert parsed.property("cursor", "copy");
    }

    /**
     * @version 2014/10/28 16:18:06
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style help = () -> {
            cursor.help();
        };

        private static Style alias = () -> {
            cursor.alias();
        };

        private static Style copy = () -> {
            cursor.copy();
        };
    }
}
