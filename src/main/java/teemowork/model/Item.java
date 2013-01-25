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
 * @version 2012/12/07 10:00:23
 */
public enum Item {

    AbyssalScepter("Abyssal Scepter"), //
    AegisOfTheLegion("Aegis of the Legion"), //
    AmplifyingTome("Amplifying Tome"), //
    ArchangelsStaff("Archangel's Staff"), //
    AthenesUnholyGrail("Athene's Unholy Grail"), //
    AtmasImpaler("Atma's Impaler"), //
    AugmentDeath("Augment: Death"), //
    AugmentGravity("Augment: Gravity"), //
    AugmentPower("Augment: Power"), //
    AvariceBlade("Avarice Blade"), //

    BlastingWand("Blasting Wand"),

    RubyCrystal("Ruby Crystal"),

    ShardOfTrueIce("Shard of True Ice"),

    LiandrysTorment("Liandry's Torment"),

    HauntingGuise("Haunting Guise");

    /** The name. */
    public final String name;

    /** The status. */
    Improvement improvement;

    /**
     * @param name
     */
    private Item(String name) {
        this.name = name;
    }
}
