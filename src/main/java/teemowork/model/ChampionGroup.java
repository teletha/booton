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

import static teemowork.model.Champion.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2013/02/16 13:44:47
 */
public class ChampionGroup {

    /** The built-in group. */
    public static final ChampionGroup RANGED = new ChampionGroup(new Champion[] {Ashe, Caitlyn, Corki, Draven, Ezreal,
            Graves, Jayce, Kennen, KogMaw, MissFortune, Quinn, Sivir, Teemo, Thresh, Tristana, TwistedFate, Twitch,
            Urgot, Varus, Vayne});

    /** The group members. */
    private final List<Champion> members = new ArrayList();

    /**
     * @param members
     */
    public ChampionGroup(Champion[] members) {
        for (Champion champion : members) {
            this.members.add(champion);
        }
    }

    /**
     * <p>
     * Detct member.
     * </p>
     * 
     * @param champion
     * @return
     */
    public boolean contains(Champion champion) {
        return members.contains(champion);
    }
}
