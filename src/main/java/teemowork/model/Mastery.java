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

/**
 * @version 2013/03/13 14:34:14
 */
public class Mastery {

    /** The mastery pool. */
    public static final Mastery[] VALUES = new Mastery[56];

    /** The tree type. */
    public static final int Offense = 0;

    /** The tree type. */
    public static final int Defense = 1;

    /** The tree type. */
    public static final int Utility = 2;

    /** Season3 Mastery */
    public static final Mastery SummonersWrath = new Mastery("Summoner's Wrath", 1, Offense, 0);

    /** Season3 Mastery */
    public static final Mastery Fury = new Mastery("Fury", 4, Offense, 0);

    /** Season3 Mastery */
    public static final Mastery Sorcery = new Mastery("Sorcery", 4, Offense, 0);

    /** Season3 Mastery */
    public static final Mastery Butcher = new Mastery("Butcher", 2, Offense, 0);

    /** Season3 Mastery */
    public static final Mastery Deadliness = new Mastery("Deadliness", 4, Offense, 1);

    /** Season3 Mastery */
    public static final Mastery Blast = new Mastery("Blast", 4, Offense, 1);

    /** Season3 Mastery */
    public static final Mastery Destruction = new Mastery("Destruction", 1, Offense, 1);

    /** Season3 Mastery */
    public static final Mastery Havoc = new Mastery("Havoc", 3, Offense, 2);

    /** Season3 Mastery */
    public static final Mastery WeaponExpertise = new Mastery("Weapon Expertise", 1, Offense, 2);

    /** Season3 Mastery */
    public static final Mastery ArcaneKnowledge = new Mastery("Arcane Knowledge", 1, Offense, 2);

    /** Season3 Mastery */
    public static final Mastery Lethality = new Mastery("Lethality", 2, Offense, 3);

    /** Season3 Mastery */
    public static final Mastery BruteForce = new Mastery("Brute Force", 2, Offense, 3);

    /** Season3 Mastery */
    public static final Mastery MentalForce = new Mastery("Mental Force", 3, Offense, 3);

    /** Season3 Mastery */
    public static final Mastery Spellsword = new Mastery("Spellsword", 1, Offense, 3);

    /** Season3 Mastery */
    public static final Mastery Frenzy = new Mastery("Frenzy", 1, Offense, 4);

    /** Season3 Mastery */
    public static final Mastery Sunder = new Mastery("Sunder", 3, Offense, 4);

    /** Season3 Mastery */
    public static final Mastery Archmage = new Mastery("Archmage", 4, Offense, 4);

    /** Season3 Mastery */
    public static final Mastery Executioner = new Mastery("Executioner", 1, Offense, 5);

    /** Season3 Mastery */
    public static final Mastery SummonersResolve = new Mastery("Summoner's Resolve", 1, Defense, 0);

    /** Season3 Mastery */
    public static final Mastery Perseverance = new Mastery("Perseverance", 3, Defense, 0);

    /** Season3 Mastery */
    public static final Mastery Durability = new Mastery("Durability", 4, Defense, 0);

    /** Season3 Mastery */
    public static final Mastery ToughSkin = new Mastery("Tough Skin", 2, Defense, 0);

    /** Season3 Mastery */
    public static final Mastery Hardiness = new Mastery("Hardiness", 3, Defense, 1);

    /** Season3 Mastery */
    public static final Mastery Resistance = new Mastery("Resistance", 3, Defense, 1);

    /** Season3 Mastery */
    public static final Mastery BladedArmor = new Mastery("Bladed Armor", 1, Defense, 1);

    /** Season3 Mastery */
    public static final Mastery Unyielding = new Mastery("Unyielding", 2, Defense, 2);

    /** Season3 Mastery */
    public static final Mastery Relentless = new Mastery("Relentless", 2, Defense, 2);

    /** Season3 Mastery */
    public static final Mastery VeteransScar = new Mastery("Veteran's Scars", 1, Defense, 2);

    /** Season3 Mastery */
    public static final Mastery Safeguard = new Mastery("Safeguard", 1, Defense, 2);

    /** Season3 Mastery */
    public static final Mastery Block = new Mastery("Block", 1, Defense, 3);

    /** Season3 Mastery */
    public static final Mastery Tenacious = new Mastery("Tenacious", 3, Defense, 3);

    /** Season3 Mastery */
    public static final Mastery Juggernaut = new Mastery("Juggernaut", 3, Defense, 3);

    /** Season3 Mastery */
    public static final Mastery Defender = new Mastery("Defender", 1, Defense, 4);

    /** Season3 Mastery */
    public static final Mastery LegendaryArmor = new Mastery("Legendary Armor", 1, Defense, 4);

    /** Season3 Mastery */
    public static final Mastery GoodHands = new Mastery("Good Hands   ", 1, Defense, 4);

    /** Season3 Mastery */
    public static final Mastery ReinforcedArmor = new Mastery("Reinforced Armor ", 1, Defense, 4);

    /** Season3 Mastery */
    public static final Mastery HonorGuard = new Mastery("Honor Guard", 1, Defense, 5);

    /** Season3 Mastery */
    public static final Mastery SummonersInsight = new Mastery("Summoner's Insight", 1, Utility, 0);

    /** Season3 Mastery */
    public static final Mastery Wanderer = new Mastery("Wanderer", 3, Utility, 0);

    /** Season3 Mastery */
    public static final Mastery Meditation = new Mastery("Meditation", 3, Utility, 0);

    /** Season3 Mastery */
    public static final Mastery ImprovedRecall = new Mastery("Improved Recall", 1, Utility, 0);

    /** Season3 Mastery */
    public static final Mastery Scout = new Mastery("Scout", 1, Utility, 1);

    /** Season3 Mastery */
    public static final Mastery Mastermind = new Mastery("Mastermind", 3, Utility, 1);

    /** Season3 Mastery */
    public static final Mastery ExpandedMind = new Mastery("Expanded Mind", 3, Utility, 1);

    /** Season3 Mastery */
    public static final Mastery Artificer = new Mastery("Artificer", 2, Utility, 1);

    /** Season3 Mastery */
    public static final Mastery Greed = new Mastery("Greed", 4, Utility, 2);

    /** Season3 Mastery */
    public static final Mastery RunicAffinity = new Mastery("Runic Affinity", 1, Utility, 2);

    /** Season3 Mastery */
    public static final Mastery Vampirism = new Mastery("Vampirism", 3, Utility, 2);

    /** Season3 Mastery */
    public static final Mastery Biscuiteer = new Mastery("Biscuiteer", 1, Utility, 2);

    /** Season3 Mastery */
    public static final Mastery Wealth = new Mastery("Wealth", 2, Utility, 3);

    /** Season3 Mastery */
    public static final Mastery Awareness = new Mastery("Awareness", 4, Utility, 3);

    /** Season3 Mastery */
    public static final Mastery StrengthOfSpirit = new Mastery("Strength of Spirit", 3, Utility, 3);

    /** Season3 Mastery */
    public static final Mastery Explorer = new Mastery("Explorer", 1, Utility, 3);

    /** Season3 Mastery */
    public static final Mastery Pickpocket = new Mastery("Pickpocket", 1, Utility, 4);

    /** Season3 Mastery */
    public static final Mastery Intelligence = new Mastery("Intelligence", 3, Utility, 4);

    /** Season3 Mastery */
    public static final Mastery Nimble = new Mastery("Nimble", 1, Utility, 5);

    /** The id counter. */
    private static int counter = 0;

    /** The identifier. */
    public final int id;

    /** The mastery name. */
    public final String name;

    /** The system name. */
    public final String system;

    /** The maximum level. */
    public final int level;

    /** The tree type. */
    public final int type;

    /** The rank. */
    public final int rank;

    /** The required point. */
    public final int requirement;

    /**
     * <p>
     * Define mastery.
     * </p>
     * 
     * @param name A mastery name.
     * @param level A max level.
     */
    Mastery(String name, int level, int type, int rank) {
        this.id = counter++;
        this.name = name;
        this.system = name.replaceAll("[\\s-,!':/]", "");
        this.level = level;
        this.type = type;
        this.rank = rank;
        this.requirement = rank * 4;

        VALUES[id] = this;
    }

    /**
     * <p>
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/mastery/s3/" + system + ".png";
    }
}
