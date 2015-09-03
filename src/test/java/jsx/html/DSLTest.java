/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.html;

import org.junit.Test;

/**
 * @version 2014/12/02 13:51:39
 */
public class DSLTest {

    @Test
    public void test() throws Exception {
        DSL dsl = new DSL() {

            {
                div(title("Title"), () -> {
                    text("Text");
                });
            }
        };
    }
}
