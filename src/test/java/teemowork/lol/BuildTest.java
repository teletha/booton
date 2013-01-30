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
        assertStatus(build, AD, 20, 0);
    }

    @Test
    public void item() throws Exception {
        Champion champion = new EmptyChampion();
        Build build = new Build(champion);
        assertStatus(build, AD, 0, 0);

        build.setItem(0, createItem(AD, 10));
        assertStatus(build, AD, 0, 10);
    }

    @Test
    public void items() throws Exception {
        Champion champion = new EmptyChampion();
        Build build = new Build(champion);
        assertStatus(build, AD, 0, 0);

        build.setItem(0, createItem(AD, 10));
        build.setItem(1, createItem(AD, 10));
        assertStatus(build, AD, 0, 20);
    }

    @Test
    public void ability() throws Exception {
        Champion champion = new EmptyChampion();
        Build build = new Build(champion);
        assertStatus(build, AD, 0, 0);

        build.setItem(0, createItem(AD, 10));
        build.setItem(1, createItem(AD, 10));
        assertStatus(build, AD, 0, 20);
    }

    /**
     * <p>
     * Helper method to create new item.
     * </p>
     * 
     * @param status
     * @param value
     * @return
     */
    private Item createItem(Status status, double value) {
        Item item = new EmptyItem();
        item.update(Version.P0000).set(status, value);

        return item;
    }

    /**
     * <p>
     * Assert status value.
     * </p>
     * 
     * @param status
     * @param base
     * @param increased
     */
    private void assertStatus(Build build, Status status, double base, double increased) {
        Computed valeu = build.get(status);
        assert valeu.base == base;
        assert valeu.increased == increased;
        assert valeu.value == base + increased;
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

    /**
     * @version 2013/01/30 13:34:11
     */
    private static class EmptyItem extends Item {

        /**
         * 
         */
        private EmptyItem() {
            super(0, "Test Item");

            update(Version.P0000);
        }
    }
}
