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
import teemowork.model.variable.VariableResolver.Fixed;

/**
 * @version 2013/03/13 14:34:14
 */
public class MasterySeason3 extends Mastery {

    static final Mastery[] Masteries = new Mastery[56];

    /** The tree type. */
    public static final int Offense = 0;

    /** The tree type. */
    public static final int Defense = 1;

    /** The tree type. */
    public static final int Utility = 2;

    /** Season3 Mastery */
    public static final MasterySeason3 SummonersWrath = new MasterySeason3("Summoner's Wrath", 1, Offense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Fury = new MasterySeason3("Fury", 4, Offense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Sorcery = new MasterySeason3("Sorcery", 4, Offense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Butcher = new MasterySeason3("Butcher", 2, Offense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Deadliness = new MasterySeason3("Deadliness", 4, Offense, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Blast = new MasterySeason3("Blast", 4, Offense, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Destruction = new MasterySeason3("Destruction", 1, Offense, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Havoc = new MasterySeason3("Havoc", 3, Offense, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 WeaponExpertise = new MasterySeason3("Weapon Expertise", 1, Offense, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 ArcaneKnowledge = new MasterySeason3("Arcane Knowledge", 1, Offense, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 Lethality = new MasterySeason3("Lethality", 2, Offense, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 BruteForce = new MasterySeason3("Brute Force", 2, Offense, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 MentalForce = new MasterySeason3("Mental Force", 3, Offense, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Spellsword = new MasterySeason3("Spellsword", 1, Offense, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Frenzy = new MasterySeason3("Frenzy", 1, Offense, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 Sunder = new MasterySeason3("Sunder", 3, Offense, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 Archmage = new MasterySeason3("Archmage", 4, Offense, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 Executioner = new MasterySeason3("Executioner", 1, Offense, 5);

    /** Season3 Mastery */
    public static final MasterySeason3 SummonersResolve = new MasterySeason3("Summoner's Resolve", 1, Defense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Perseverance = new MasterySeason3("Perseverance", 3, Defense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Durability = new MasterySeason3("Durability", 4, Defense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 ToughSkin = new MasterySeason3("Tough Skin", 2, Defense, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Hardiness = new MasterySeason3("Hardiness", 3, Defense, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Resistance = new MasterySeason3("Resistance", 3, Defense, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 BladedArmor = new MasterySeason3("Bladed Armor", 1, Defense, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Unyielding = new MasterySeason3("Unyielding", 2, Defense, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 Relentless = new MasterySeason3("Relentless", 2, Defense, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 VeteransScar = new MasterySeason3("Veteran's Scars", 1, Defense, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 Safeguard = new MasterySeason3("Safeguard", 1, Defense, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 Block = new MasterySeason3("Block", 1, Defense, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Tenacious = new MasterySeason3("Tenacious", 3, Defense, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Juggernaut = new MasterySeason3("Juggernaut", 3, Defense, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Defender = new MasterySeason3("Defender", 1, Defense, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 LegendaryArmor = new MasterySeason3("Legendary Armor", 3, Defense, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 GoodHands = new MasterySeason3("Good Hands   ", 1, Defense, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 ReinforcedArmor = new MasterySeason3("Reinforced Armor ", 1, Defense, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 HonorGuard = new MasterySeason3("Honor Guard", 1, Defense, 5);

    /** Season3 Mastery */
    public static final MasterySeason3 SummonersInsight = new MasterySeason3("Summoner's Insight", 1, Utility, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Wanderer = new MasterySeason3("Wanderer", 3, Utility, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Meditation = new MasterySeason3("Meditation", 3, Utility, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 ImprovedRecall = new MasterySeason3("Improved Recall", 1, Utility, 0);

    /** Season3 Mastery */
    public static final MasterySeason3 Scout = new MasterySeason3("Scout", 1, Utility, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Mastermind = new MasterySeason3("Mastermind", 3, Utility, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 ExpandedMind = new MasterySeason3("Expanded Mind", 3, Utility, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Artificer = new MasterySeason3("Artificer", 2, Utility, 1);

    /** Season3 Mastery */
    public static final MasterySeason3 Greed = new MasterySeason3("Greed", 4, Utility, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 RunicAffinity = new MasterySeason3("Runic Affinity", 1, Utility, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 Vampirism = new MasterySeason3("Vampirism", 3, Utility, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 Biscuiteer = new MasterySeason3("Biscuiteer", 1, Utility, 2);

    /** Season3 Mastery */
    public static final MasterySeason3 Wealth = new MasterySeason3("Wealth", 2, Utility, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Awareness = new MasterySeason3("Awareness", 4, Utility, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 StrengthOfSpirit = new MasterySeason3("Strength of Spirit", 3, Utility, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Explorer = new MasterySeason3("Explorer", 1, Utility, 3);

    /** Season3 Mastery */
    public static final MasterySeason3 Pickpocket = new MasterySeason3("Pickpocket", 1, Utility, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 Intelligence = new MasterySeason3("Intelligence", 3, Utility, 4);

    /** Season3 Mastery */
    public static final MasterySeason3 Nimble = new MasterySeason3("Nimble", 1, Utility, 5);

    /**
     * A mastery tree definition.
     */
    static final Mastery[][][] Trees = {
            // ============ Offense ============ //
            { {SummonersWrath, Fury, Sorcery, Butcher}, {null, Deadliness, Blast, Destruction},
                    {Havoc, WeaponExpertise, ArcaneKnowledge, null}, {Lethality, BruteForce, MentalForce, Spellsword},
                    {Frenzy, Sunder, Archmage, null}, {null, Executioner, null, null}},

            // ============ Defense ============ //
            { {SummonersResolve, Perseverance, Durability, ToughSkin}, {Hardiness, Resistance, null, BladedArmor},
                    {Unyielding, Relentless, VeteransScar, Safeguard}, {Block, Tenacious, Juggernaut, null},
                    {Defender, LegendaryArmor, GoodHands, ReinforcedArmor}, {null, HonorGuard, null, null}},

            // ============ Utility ============ //
            { {SummonersInsight, Wanderer, Meditation, ImprovedRecall}, {Scout, Mastermind, ExpandedMind, Artificer},
                    {Greed, RunicAffinity, Vampirism, Biscuiteer}, {Wealth, Awareness, StrengthOfSpirit, Explorer},
                    {Pickpocket, Intelligence, null, null}, {null, Nimble, null, null}}};

    /** The id counter. */
    private static int counter = 0;

    /**
     * <p>
     * Define mastery.
     * </p>
     * 
     * @param name A mastery name.
     * @param level A max level.
     */
    MasterySeason3(String name, int level, int type, int rank) {
        super(name, level, type, rank, counter++);

        Masteries[id] = this;
    }

    /**
     * <p>
     * Compute full path to icon image.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/mastery/s3/" + system + ".png";
    }

    /**
     * <p>
     * Compute full path to icon image.
     * </p>
     * 
     * @return
     */
    public String getSpriteImage() {
        return "src/main/resources/teemowork/masteryS3.jpg";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected MasteryDescriptor createDescriptor(Version version, MasteryDescriptor previous) {
        return new MasteryDescriptor(this, previous, version);
    }

    static {
        SummonersWrath.update()
                .passive("Exhaustに{1}と{2}を付与する。<br/>IgniteがCDの間{3}と{4}を得る。")
                .variable(1, ARReduction, 10)
                .variable(2, MRReduction, 10)
                .variable(-3, AD, 5)
                .variable(-4, AP, 5);
        Fury.update().passive("{1}する。").variable(1, ASRatio, 1, 1);
        Sorcery.update().passive("{1}を得る。").variable(1, CDR, 1, 1);
        Butcher.update().passive("ミニオンや中立モンスターへの{1}する。").variable(1, AttackDamage, 2, 2);
        Deadliness.update()
                .passive("{1}を得る。")
                .variable(1, AD, 0, 0, amplify(Lv, new Fixed(new double[] {0.17, 0.33, 0.5, 0.67})));
        Blast.update().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 0.25, 0.25));
        Destruction.update().passive("タワーに与えるダメージが5%上昇する。");
        Havoc.update().passive("{1}する。").variable(1, DamageRatio, new Fixed(new double[] {0.67, 1.33, 2}));
        WeaponExpertise.update().passive("{1}を得る。").variable(1, ARPenRatio, 8);
        ArcaneKnowledge.update().passive("{1}を得る。").variable(1, MRPenRatio, 8);
        Lethality.update()
                .passive("Meleeは{1}する。Rangedは{2}する。")
                .variable(1, CriticalDamageRatio, 5, 5)
                .variable(2, CriticalDamageRatio, 2.5, 2.5);
        BruteForce.update().passive("{1}を得る。").variable(1, AD, 1.5, 1.5);
        MentalForce.update().passive("{1}を得る。").variable(1, AP, 2, 2);
        Spellsword.update().passive("通常攻撃に追加の{1}を付与する。").variable(1, MagicDamage, 0, 0, ap(0.05));
        Frenzy.update().passive("クリティカルヒット時に2秒間{1}する。").variable(-1, ASRatio, 10);
        Sunder.update().passive("{1}を得る。").variable(1, ARPen, 2, 1.5);
        Archmage.update().passive("{1}する。").variable(1, APRatio, 1.25, 1.25);
        Executioner.update().passive("対象のHealthが50%以下の時、{1}する。").variable(1, DamageRatio, 5);

        Perseverance.update().passive("{1}を得る。").variable(1, Hreg, 0, 0, amplify(MissingHealthPercentage, 0.02, 0.02));
        Durability.update().passive("{1}を得る。").variable(1, HealthPerLv, 1.5, 1.5);
        ToughSkin.update().passive("中立モンスターから受ける{1}する。").variable(1, DamageReduction, 1, 1);
        Hardiness.update().passive("{1}を得る。").variable(1, AR, 2, 1.5);
        Resistance.update().passive("{1}を得る。").variable(1, MR, 2, 1.5);
        BladedArmor.update().passive("攻撃してきたミニオンと中立モンスターに{1}を与える。").variable(1, TrueDamage, 6);
        Unyielding.update().passive("敵Championから受ける{1}する。").variable(1, DamageReduction, 1, 1);
        Relentless.update().passive("{1}する。").variable(1, MSSlowReductionRatio, 7.5, 7.5);
        VeteransScar.update().passive("{1}を得る。").variable(1, Health, 30);
        Safeguard.update().passive("タワーから受ける{1}する。").variable(1, DamageReductionRatio, 5);
        Block.update().passive("敵Championから受ける{1}する。").variable(1, AttackDamageReduction, 3);
        Tenacious.update().passive("{1}を得る。").variable(1, Tenacity, 5, 5);
        Juggernaut.update().passive("{1}する。").variable(1, HealthRatio, 1.5, 1.25);
        Defender.update()
                .passive("{1}と{2}を得る。")
                .variable(1, AR, 0, 0, amplify(EnemyChampion, 1))
                .variable(2, MR, 0, 0, amplify(EnemyChampion, 1));
        LegendaryArmor.update().passive("{1}し{2}する。").variable(1, ARRatio, 2, 1.5).variable(2, MRRatio, 2, 1.5);
        GoodHands.update().passive("{1}する。").variable(1, RespawnTimeReductionRatio, 10);
        ReinforcedArmor.update().passive("クリティカルヒットから受ける{1}する。").variable(1, DamageReductionRatio, 10);
        HonorGuard.update().passive("{1}する。").variable(1, DamageReductionRatio, 3);

        Wanderer.update()
                .passive("５秒間戦闘状態にならなければ{1}する。")
                .variable(-1, MSRatio, new Fixed(new double[] {0.66, 1.33, 2}));
        Meditation.update().passive("{1}を得る。").variable(1, Mreg, 1, 1);
        ImprovedRecall.update().passive("Recallの詠唱時間が1秒短くなる。");
        Scout.update().passive("Wardの視界が設置してから5秒間25%拡大する。");
        Mastermind.update().passive("{全てのSummoner SpellのCDが{1}減少する。").variable(1, Percentage, 4, 3);
        ExpandedMind.update().passive("{1}を得る。").variable(1, Mana, 0, 0, amplify(Lv, 4, 3));
        Artificer.update().passive("アイテムのActiveのCDが{1}減少する。").variable(1, Percentage, 7.5, 7.5);
        Greed.update().passive("{1}を得る。").variable(1, GoldPer10Sec, 0.5, 0.5);
        RunicAffinity.update().passive("BaronBuff以外のBuffの効果時間が20%延長される。");
        Vampirism.update().passive("{1}と{2}を得る。").variable(1, LS, 1, 1).variable(2, SV, 1, 1);
        Biscuiteer.update().passive("ゲーム開始時に10秒かけて80Healthと50Manaを回復するアイテムを1個得る。");
        Wealth.update().passive("ゲーム開始時に{1}を得る。").variable(1, Gold, 25, 25);
        Awareness.update().passive("獲得する{1}する。").variable(1, ExperimentRatio, 1.25, 1.25);
        StrengthOfSpirit.update().passive("{1}を得る。").variable(1, Hreg, 0, 0, amplify(Mana, 0.0025, 0.0025));
        Explorer.update().passive("ゲーム開始時に効果時間が60秒のSight Wardを1個得る。");
        Pickpocket.update()
                .passive("敵Championに通常攻撃でダメージを与える毎に{1}を得る。Rangedの場合は{2}を得る。CDは5秒。")
                .variable(1, Gold, 5)
                .variable(2, Gold, 3);
        Intelligence.update().passive("{1}を得る。").variable(1, CDR, 2, 2);
        Nimble.update().passive("{1}する。").variable(1, MSRatio, 3);
    }
}
