/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Status.*;

import org.junit.Test;

import teemowork.model.ChampionStatus;

/**
 * @version 2013/01/29 10:27:30
 */
public class ChampionStatusTest {

    @Test
    public void GetAndSet() throws Exception {
        ChampionStatus skill = new ChampionStatus(null);
        assert skill.get(Range) == 0;

        skill.set(Range, 100);
        assert skill.get(Range) == 100;
    }

    @Test
    public void Delegate() throws Exception {
        ChampionStatus previous = new ChampionStatus(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ChampionStatus skill = new ChampionStatus(previous);
        assert skill.get(Range) == 100;
    }

    @Test
    public void Override() throws Exception {
        ChampionStatus previous = new ChampionStatus(null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        ChampionStatus skill = new ChampionStatus(previous);
        skill.set(Range, 200);
        assert skill.get(Range) == 200;
        assert previous.get(Range) == 100;
    }

    @Test
    public void active() throws Exception {
        ChampionStatus skill = new ChampionStatus(null);
    }
}
