/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import static teemowork.lol.Status.*;

import org.junit.Test;

/**
 * @version 2013/01/27 20:34:23
 */
public class ItemDescriptorTest {

    @Test
    public void GetAndSet() throws Exception {
        ItemDescriptor item = new ItemDescriptor(null);
        assert item.get(Range) == 0;

        item.set(Range, 100);
        assert item.get(Range) == 100;
    }

    @Test
    public void Delegate() throws Exception {
        ItemDescriptor previous = new ItemDescriptor(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ItemDescriptor item = new ItemDescriptor(previous);
        assert item.get(Range) == 100;
    }

    @Test
    public void Override() throws Exception {
        ItemDescriptor previous = new ItemDescriptor(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ItemDescriptor item = new ItemDescriptor(previous);
        item.set(Range, 200);
        assert item.get(Range) == 200;
        assert previous.get(Range) == 100;
    }

    @Test
    public void active() throws Exception {
        ItemDescriptor item = new ItemDescriptor(null);
        item.aura("test").set(MRReduction, 20).unique();
    }
}
