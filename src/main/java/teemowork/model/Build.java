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

import js.bind.Observable;

/**
 * @version 2013/01/16 9:18:22
 */
public class Build {

    /** The selected champion. */
    private Champion champion;

    /** The current champion status. */
    private ChampionStatus status;

    /** The level. */
    @Observable
    private int level;

    /** The item list. */
    private Item[] items = new Item[6];

    /** The skill order. */
    private int[] skills = new int[18];

    /** The mastery. */
    private MasterySet mastery;

    /** The rune. */
    private RuneSet rune;

    /**
     * <p>
     * Compute current mana.
     * </p>
     * 
     * @return
     */
    @Observable
    public double getMana() {
        return status.getManaInitial() + status.getManaPerLvel() * level;
    }
}
