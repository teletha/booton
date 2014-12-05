/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/09/13 2:05:34
 */
// @RunWith(ScriptRunner.class)
public class VirtualStructureDiffTest extends DiffTestBase2 {

    @Test
    public void textChange() {
        VirtualStructure2 prev = new VirtualStructure2();
        prev.e("text");

        VirtualStructure2 next = new VirtualStructure2();
        next.e("change");

        assertDiff(prev, next, 1);
    }

    @Test
    public void textChangeSequentially() {
        VirtualStructure2 fisrt = new VirtualStructure2();
        fisrt.asis("text1", "text2");

        VirtualStructure2 second = new VirtualStructure2();
        second.asis("second", "text2");

        assertDiff(fisrt, second, 1);

        VirtualStructure2 third = new VirtualStructure2();
        third.asis("third", "text2");

        assertDiff(second, third, 1);

        VirtualStructure2 last = new VirtualStructure2();
        last.asis("third", "last");

        assertDiff(third, last, 1);
    }

    @Test
    public void textsChange() {
        VirtualStructure2 prev = new VirtualStructure2();
        prev.asis("text1", "text2", "text3");

        VirtualStructure2 next = new VirtualStructure2();
        next.asis("text4", "text2", "text3");

        assertDiff(prev, next, 1);
    }

    @Test
    public void textNoChange() {
        VirtualStructure2 prev = new VirtualStructure2();
        prev.e("text");

        VirtualStructure2 next = new VirtualStructure2();
        next.e("text");

        assertDiff(prev, next, 0);
    }

    @Test
    public void hboxTextChange() {
        VirtualStructure2 prev = new VirtualStructure2();
        prev.element(1, "div", VirtualStructureStyle.HBOX, "text");

        VirtualStructure2 next = new VirtualStructure2();
        next.element(1, "div", VirtualStructureStyle.HBOX, "change");

        assertDiff(prev, next, 1);
    }
}
