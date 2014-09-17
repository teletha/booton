/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.virtual;

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
        StructureDSL prev〡 = new StructureDSL();
        prev〡.asis.〡("text");

        StructureDSL next〡 = new StructureDSL();
        next〡.asis.〡("change");

        assertDiff(prev〡, next〡, 1);
    }

    @Test
    public void textNoChange() {
        StructureDSL prev〡 = new StructureDSL();
        prev〡.asis.〡("text");

        StructureDSL next〡 = new StructureDSL();
        next〡.asis.〡("text");

        assertDiff(prev〡, next〡, 0);
    }

    @Test
    public void hboxTextChange() {
        StructureDSL prev〡 = new StructureDSL();
        prev〡.hbox(1).〡("text");

        StructureDSL next〡 = new StructureDSL();
        next〡.hbox(1).〡("change");

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
    private <T> StructureDSL change(boolean condition) {
        StructureDSL $〡 = new StructureDSL();
        if (condition) {
            $〡.vbox.〡("text");
        } else {
            $〡.hbox.〡("text");
        }
        return $〡;
    }
}
