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
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/09/13 2:05:34
 */
@RunWith(ScriptRunner.class)
public class VirtualStructureDiffTest extends DiffTestBase {

    @Test
    public void textChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.〡("text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.〡("change");

        assertDiff(prev〡, next〡, 1);
    }

    @Test
    public void textChangeSequentially() {
        VirtualStructure fisrt〡 = new VirtualStructure();
        fisrt〡.〡("text1", "text2");

        VirtualStructure second〡 = new VirtualStructure();
        second〡.〡("second", "text2");

        assertDiff(fisrt〡, second〡, 1);

        VirtualStructure third〡 = new VirtualStructure();
        third〡.〡("third", "text2");

        assertDiff(second〡, third〡, 1);

        VirtualStructure last〡 = new VirtualStructure();
        last〡.〡("third", "last");

        assertDiff(third〡, last〡, 1);
    }

    @Test
    public void textsChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.〡("text1", "text2", "text3");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.〡("text4", "text2", "text3");

        assertDiff(prev〡, next〡, 1);
    }

    @Test
    public void textNoChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.〡("text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.〡("text");

        assertDiff(prev〡, next〡, 0);
    }

    @Test
    public void hboxTextChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.hbox.〡(null, "text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.hbox.〡(null, "change");

        assertDiff(prev〡, next〡, 1);
    }

    @Test
    public void boxTypeChange() {
        assertDiff(change(true), change(false), 1);
    }

    /**
     * <p>
     * Create structure for multi box list.
     * </p>
     * 
     * @param items A list items.
     * @return A created structure.
     */
    private <T> VirtualStructure change(boolean condition) {
        VirtualStructure $〡 = new VirtualStructure();
        if (condition) {
            $〡.vbox.〡(null, "text");
        } else {
            $〡.hbox.〡(null, "text");
        }
        return $〡;
    }
}
