/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import org.junit.Test;

/**
 * @version 2015/09/12 23:19:08
 */
public class DSLTest {

    @Test
    public void test() throws Exception {
        DSL dsl = new DSL() {

            {
                e("div", title("Title"), () -> {
                    text("Text");
                });
            }
        };

        VirtualElement root = dsl.items.get(0);
        assert root.name.equals("div");
        assert root.attributes.get("title").get().equals("Title");

        VirtualNode child = root.items.get(0);
        assert child.toString().equals("Text");
    }
}
