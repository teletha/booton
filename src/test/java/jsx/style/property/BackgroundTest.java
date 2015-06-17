/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import static jsx.style.value.Color.*;
import jsx.style.StyleTester;
import jsx.style.property.Background.BackgroundImage;
import jsx.style.value.LinearGradient;

import org.junit.Test;

/**
 * @version 2014/11/13 14:19:22
 */
public class BackgroundTest extends StyleTester {

    @Test
    public void color() {
        ValidatableStyle parsed = style(() -> {
            background.color(255, 0, 0);
        });
        assert parsed.property("background-color", "rgb(255,0,0)");
    }

    @Test
    public void origin() {
        ValidatableStyle parsed = style(() -> {
            background.contentBox();
        });
        assert parsed.property("background-origin", "content-box");

        parsed = style(() -> {
            background.paddingBox();
        });
        assert parsed.property("background-origin", "padding-box");

        parsed = style(() -> {
            background.borderBox();
        });
        assert parsed.property("background-origin", "border-box");
    }

    @Test
    public void imageSingle() {
        ValidatableStyle parsed = style(() -> {
            background.image("test").fixed().cover().repeatX();
        });
        assert parsed.property("background-image", "url(test)");
        assert parsed.property("background-attachment", "fixed");
        assert parsed.property("background-size", "cover");
        assert parsed.property("background-repeat", "repeat-x");
    }

    @Test
    public void image() {
        ValidatableStyle parsed = style(() -> {
            background.image(BackgroundImage.url("test").top().left().fixed().repeat().cover());
        });
        assert parsed.property("background-image", "url(test)");
        assert parsed.property("background-attachment", "fixed");
        assert parsed.property("background-size", "cover");
    }

    @Test
    public void images() {
        ValidatableStyle parsed = style(() -> {
            BackgroundImage one = BackgroundImage.url("one").bottom().right();
            BackgroundImage two = BackgroundImage.url("two")
                    .horizontal(1, em)
                    .vertical(2, percent)
                    .noRepeat()
                    .contain()
                    .local();

            background.image(one, two);
        });
        assert parsed.property("background-image", "url(one),url(two)");
        assert parsed.property("background-position", "100% 100%,1em 2%");
        assert parsed.property("background-attachment", "scroll,local");
        assert parsed.property("background-repeat", "repeat,no-repeat");
        assert parsed.property("background-size", "auto,contain");
    }

    @Test
    public void imageGradient() throws Exception {
        ValidatableStyle parsed = style(() -> {
            background.image(BackgroundImage.of(new LinearGradient().color(Black, White)));
        });
        assert parsed.property("background-image", "linear-gradient(black,white)", "-webkit-linear-gradient(black,white)");
    }

    @Test
    public void imageGradients() throws Exception {
        ValidatableStyle parsed = style(() -> {
            background.image(BackgroundImage.of(new LinearGradient().color(Black, White)), BackgroundImage.of(new LinearGradient().color(White, Black)));
        });
        assert parsed.property("background-image", "linear-gradient(black,white),linear-gradient(white,black)", "-webkit-linear-gradient(black,white),-webkit-linear-gradient(white,black)");
    }
}
