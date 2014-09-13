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

/**
 * @version 2014/09/13 2:05:34
 */
public class VirtualStructureDiffTest extends VirtualStructureDiffBase {

    @Test
    public void textChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.asis.〡("text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.asis.〡("change");

        assertDiff(prev〡, next〡, 1);
    }

    @Test
    public void textNoChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.asis.〡("text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.asis.〡("text");

        assertDiff(prev〡, next〡, 0);
    }

    @Test
    public void hboxTextChange() {
        VirtualStructure prev〡 = new VirtualStructure();
        prev〡.hbox(1).〡("text");

        VirtualStructure next〡 = new VirtualStructure();
        next〡.hbox(1).〡("change");

        assertDiff(prev〡, next〡, 1);
    }
}
