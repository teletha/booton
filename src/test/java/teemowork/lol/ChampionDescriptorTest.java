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
 * @version 2013/01/29 10:27:30
 */
public class ChampionDescriptorTest {

    @Test
    public void GetAndSet() throws Exception {
        ChampionDescriptor skill = new ChampionDescriptor(null);
        assert skill.get(Range) == 0;

        skill.set(Range, 100);
        assert skill.get(Range) == 100;
    }

    @Test
    public void Delegate() throws Exception {
        ChampionDescriptor previous = new ChampionDescriptor(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ChampionDescriptor skill = new ChampionDescriptor(previous);
        assert skill.get(Range) == 100;
    }

    @Test
    public void Override() throws Exception {
        ChampionDescriptor previous = new ChampionDescriptor(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ChampionDescriptor skill = new ChampionDescriptor(previous);
        skill.set(Range, 200);
        assert skill.get(Range) == 200;
        assert previous.get(Range) == 100;
    }

    @Test
    public void active() throws Exception {
        ChampionDescriptor skill = new ChampionDescriptor(null);
    }
}
