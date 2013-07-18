/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import org.junit.Test;

/**
 * @version 2013/07/18 9:56:39
 */
public class JustifyContentTest {

    @Test
    public void justifyContentStart() throws Exception {
        MyCSS css = new MyCSS();
        css.justifyContent.start();

        assert css.has("justify-content", "flex-start");
        assert css.has("-webkit-justify-content", "flex-start");
        assert css.has("-ms-flex-pack", "start");
    }

    @Test
    public void justifyContentEnd() throws Exception {
        MyCSS css = new MyCSS();
        css.justifyContent.end();

        assert css.has("justify-content", "flex-end");
        assert css.has("-webkit-justify-content", "flex-end");
        assert css.has("-ms-flex-pack", "end");
    }
}
