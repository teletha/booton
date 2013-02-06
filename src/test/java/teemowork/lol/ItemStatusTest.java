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

import static teemowork.lol.ItemAbility.*;
import static teemowork.lol.Status.*;

import org.junit.Test;

/**
 * @version 2013/01/27 20:34:23
 */
public class ItemStatusTest {

    @Test
    public void GetAndSet() throws Exception {
        ItemStatus item = new ItemStatus(null);
        assert item.get(Range) == 0;

        item.set(Range, 100);
        assert item.get(Range) == 100;
    }

    @Test
    public void Delegate() throws Exception {
        ItemStatus previous = new ItemStatus(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ItemStatus item = new ItemStatus(previous);
        assert item.get(Range) == 100;
    }

    @Test
    public void Override() throws Exception {
        ItemStatus previous = new ItemStatus(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ItemStatus item = new ItemStatus(previous);
        item.set(Range, 200);
        assert item.get(Range) == 200;
        assert previous.get(Range) == 100;
    }

    @Test
    public void ability() throws Exception {
        ItemStatus item = new ItemStatus(null);
        assert item.abilities.length == 0;

        item.ability(AbyssalAura);
        assert item.abilities.length == 1;
    }
}
