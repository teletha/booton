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

import jsx.style.property.Background.BackgroundImage;

import org.junit.Test;

/**
 * @version 2014/10/28 13:40:00
 */
public class BackgroundTest extends StyleDeclarationTestBase {

    @Test
    public void color() {
        ValidatableStyleRule parsed = parse(MyStyle.color).rule();
        assert parsed.property("background-color", "rgb(255,0,0)");
    }

    @Test
    public void origin() {
        ValidatableStyleRule parsed = parse(MyStyle.contentBox).rule();
        assert parsed.property("background-origin", "content-box");

        parsed = parse(MyStyle.paddingBox).rule();
        assert parsed.property("background-origin", "padding-box");

        parsed = parse(MyStyle.borderBox).rule();
        assert parsed.property("background-origin", "border-box");
    }

    @Test
    public void image() {
        ValidatableStyleRule parsed = parse(MyStyle.image).rule();
        assert parsed.property("background-image", "url(test)");
        assert parsed.property("background-position", "0% 0%");
        assert parsed.property("background-attachment", "fixed");
        assert parsed.property("background-repeat", "repeat");
        assert parsed.property("background-size", "cover");
    }

    @Test
    public void images() {
        ValidatableStyleRule parsed = parse(MyStyle.images).rule();
        assert parsed.property("background-image", "url(one),url(two)");
        assert parsed.property("background-position", "100% 100%,1em 2%");
        assert parsed.property("background-attachment", "scroll,local");
        assert parsed.property("background-repeat", "repeat,no-repeat");
        assert parsed.property("background-size", "auto,contain");
    }

    /**
     * @version 2014/10/28 13:39:57
     */
    private static class MyStyle extends StyleDescriptor {

        private static Style color = () -> {
            background.color(255, 0, 0);
        };

        private static Style contentBox = () -> {
            background.contentBox();
        };

        private static Style paddingBox = () -> {
            background.paddingBox();
        };

        private static Style borderBox = () -> {
            background.borderBox();
        };

        private static Style image = () -> {
            background.image(BackgroundImage.url("test").top().left().fixed().repeat().cover());
        };

        private static Style images = () -> {
            BackgroundImage one = BackgroundImage.url("one").bottom().right();
            BackgroundImage two = BackgroundImage
                    .url("two")
                    .horizontal(1, em)
                    .vertical(2, percent)
                    .noRepeat()
                    .contain()
                    .local();

            background.image(one, two);
        };
    }
}
