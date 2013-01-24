/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

/**
 * @version 2012/12/11 11:50:04
 */
public class ChampionStatus extends AbstractStatus<ChampionStatus> {

    /** The history version. */
    private final Patch patch;

    /** The history chain. */
    private final ChampionStatus previous;

    /**
     * @param patch
     */
    ChampionStatus(Patch patch, ChampionStatus previous) {
        this.patch = patch;
        this.previous = previous;
    }
}
