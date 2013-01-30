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

import teemowork.lol.Build.Computed;

/**
 * @version 2013/01/30 12:46:23
 */
public class BuildTest {

    @Test
    public void instance() throws Exception {
        Champion champion = new EmptyChampion();
        Build build = new Build(champion);
        assert build.champion == champion;
        assert build.get(AD).base == 0;
    }

    @Test
    public void chmpion() throws Exception {
        Champion champion = new EmptyChampion();
        champion.update(Version.P0000).set(AD, 20);

        Build build = new Build(champion);
        Computed valeu = build.get(AD);
        assert valeu.base == 20;
        assert valeu.increased == 0;
        assert valeu.value == 20;
    }

    @Test
    public void item() throws Exception {
        Champion champion = new EmptyChampion();

        Build build = new Build(champion);

        Computed valeu = build.get(AD);
        assert valeu.base == 20;
        assert valeu.increased == 0;
        assert valeu.value == 20;
    }

    /**
     * @version 2013/01/30 13:34:11
     */
    private static class EmptyChampion extends Champion {

        /**
         * 
         */
        private EmptyChampion() {
            super("Tester", null, null, null, null, null);

            update(Version.P0000);
        }
    }
}
