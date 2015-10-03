/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import static jsx.style.StyleDescriptor.*;

import org.junit.Test;

import jsx.ui.Style;

/**
 * @version 2015/09/11 11:26:47
 */
@SuppressWarnings("deprecation")
public class StyleRuleTest {

    @Test
    public void single() {
        Style style = () -> {
            display.block();

        };

        StyleRule rule = StyleRule.create("$", style);
        assert rule.selector.equals("." + style.name());
        assert rule.properties.get("display").get().equals("block");
    }

    @Test
    public void nest() {
        Style style = () -> {
            display.block();

            hover(() -> {
                text.decoration.underline();
            });
        };

        StyleRule rule = StyleRule.create("$", style);
        assert rule.selector.equals("." + style.name());
        assert rule.properties.get("display").get().equals("block");
        assert rule.children.length() == 1;

        StyleRule child = rule.children.get(0);
        assert child.selector.equals("." + style.name() + ":hover");
        assert child.properties.get("text-decoration").get().equals("underline");
    }
}
