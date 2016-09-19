/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import static jsx.ui.StructureDSL.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2015/10/05 0:39:28
 */
@RunWith(ScriptRunner.class)
public class DiffTest extends DiffTestBase {

    @Test
    public void textChange() {
        VirtualElement prev = make(() -> {
            text("text");
        });

        VirtualElement next = make(() -> {
            text("change");
        });

        assertDiff(prev, next, 1);
    }

    @Test
    public void textChangeSequentially() {
        VirtualElement fisrt = make(() -> {
            text("text1", "text2");
        });

        VirtualElement second = make(() -> {
            text("second", "text2");
        });

        assertDiff(fisrt, second, 1);

        VirtualElement third = make(() -> {
            text("third", "text2");
        });

        assertDiff(second, third, 1);

        VirtualElement last = make(() -> {
            text("third", "last");
        });

        assertDiff(third, last, 1);
    }

    @Test
    public void textsChange() {
        VirtualElement prev = make(() -> {
            text("text1", "text2", "text3");
        });

        VirtualElement next = make(() -> {
            text("text4", "text2", "text3");
        });

        assertDiff(prev, next, 1);
    }

    @Test
    public void textNoChange() {
        VirtualElement prev = make(() -> {
            text("text");
        });

        VirtualElement next = make(() -> {
            text("text");
        });

        assertDiff(prev, next, 0);
    }

    @Test
    public void styledTextChange() {
        VirtualElement prev = make(() -> {
            text(style, "text");
        });

        VirtualElement next = make(() -> {
            text(style, "change");
        });

        assertDiff(prev, next, 1);
    }

    @Test
    public void attributeValueChange() {
        VirtualElement prev = make(() -> {
            box(title("test"));
        });

        VirtualElement next = make(() -> {
            box(title("change"));
        });

        assertDiff(prev, next, 1);
    }

    @Test
    public void attributeAdd() {
        VirtualElement prev = make(() -> {
            box();
        });

        VirtualElement next = make(() -> {
            box(title("added"));
        });

        assertDiff(prev, next, 1);
    }

    @Test
    public void attributeRemove() {
        VirtualElement prev = make(() -> {
            box(title("willBeRemoved"));
        });

        VirtualElement next = make(() -> {
            box();
        });

        assertDiff(prev, next, 1);
    }
}
