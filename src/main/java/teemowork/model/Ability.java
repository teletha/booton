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

/**
 * @version 2013/01/29 1:55:25
 */
public class Ability extends Describable<AbilityDescriptor> {

    /** The ability. */
    public static final Ability AbyssalAura = new Ability();

    /** The ability. */
    public static final Ability AegisLegion = new Ability("Legion");

    /** The ability. */
    public static final Ability ArchangelInsight = new Ability("Insight");

    /** The ability. */
    public static final Ability TearManaCharge = new Ability("Mana Charge");

    /** The ability. */
    public static final Ability AtheneRestore = new Ability();

    /** The ability. */
    public static final Ability ManaFont = new Ability("Mana Font");

    /** The ability. */
    public static final Ability AtamDamage = new Ability();

    /** The ability. */
    public static final Ability HexCorePower = new Ability();

    /** The ability. */
    public static final Ability HexCoreDeath = new Ability();

    /** The ability. */
    public static final Ability HexCoreGravity = new Ability();

    /** The ability. */
    public static final Ability HexCoreTransfer = new Ability();

    /** The ability. */
    public static final Ability Avarice = new Ability("Avarice");

    /** The ability. */
    public static final Ability Greed = new Ability("Greed");

    /** The ability. */
    public static final Ability AegisValor = new Ability("Valor");

    /** The ability. */
    public static final Ability Promote = new Ability("Promote");

    /** The ability. */
    public static final Ability Banshee = new Ability();

    /** The ability. */
    public static final Ability EnhancedMovement1 = new Ability("Enhanced Movement");

    /** The ability. */
    public static final Ability EnhancedMovement2 = new Ability("Enhanced Movement");

    /** The ability. */
    public static final Ability EnhancedMovement3 = new Ability("Enhanced Movement");

    /** The ability. */
    public static final Ability EnhancedMovement5 = new Ability("Enhanced Movement");

    /** The ability. */
    public static final Ability Bilgewater = new Ability();

    /** The ability. */
    public static final Ability BotRKPassive = new Ability();

    /** The ability. */
    public static final Ability BotRKActive = new Ability();

    /** The ability. */
    public static final Ability BonetoothNecklaceDamage = new Ability();

    /** The ability. */
    public static final Ability BonetoothNecklaceSpecial = new Ability();

    /** The ability. */
    public static final Ability SlowResist = new Ability("Slow Resist");

    /** The ability. */
    public static final Ability ValorsReward = new Ability("Valor's Reward");

    /** The ability. */
    public static final Ability CrystallineFlaskActive = new Ability();

    /** The ability. */
    public static final Ability CrystallineFlaskCharge = new Ability();

    /** The ability. */
    public static final Ability DeathfireGraspActive = new Ability();

    /** The ability. */
    public static final Ability DransBladePassive = new Ability();

    /** The ability. */
    public static final Ability DransRingPassive = new Ability();

    /** The ability. */
    public static final Ability DransShieldPassive = new Ability();

    /** The ability. */
    public static final Ability Aid = new Ability("Aid");

    /** The ability. */
    public static final Ability EleisasBlessing = new Ability("Eleisa's Blessing");

    /** The ability. */
    public static final Ability ElixirOfBrillianceActive = new Ability();

    /** The ability. */
    public static final Ability ElixirOfFortitudeActive = new Ability();

    /** The ability. */
    public static final Ability Valor = new Ability("Valor");

    /** The ability. */
    public static final Ability ExecutionersCallingPassive = new Ability();

    /** The ability. */
    public static final Ability FiendishCodexPassive = new Ability();

    /** The ability. */
    public static final Ability FrozenHeartPassive = new Ability();

    /** The ability. */
    public static final Ability Icy = new Ability("Icy");

    /** The ability. */
    public static final Ability GlacialShroudPassive = new Ability();

    /** The ability. */
    public static final Ability GuardianAngelPassive = new Ability();

    /** The ability. */
    public static final Ability GuinsooPassive = new Ability();

    /** The ability. */
    public static final Ability GuinsooUniquePassive = new Ability();

    /** The ability. */
    public static final Ability EyesOfPain = new Ability("Eyes of Pain");

    /** The ability. */
    public static final Ability PortionHealth = new Ability();

    /** The ability. */
    public static final Ability PortionMana = new Ability();

    /** The ability. */
    public static final Ability Lifeline1 = new Ability("Lifeline");

    /** The ability. */
    public static final Ability GunbladePassive = new Ability();

    /** The ability. */
    public static final Ability Reload = new Ability("Reload");

    /** The ability. */
    public static final Ability GunbladeActive = new Ability();

    /** The ability. */
    public static final Ability HextechRevolverPassive = new Ability();

    /** The ability. */
    public static final Ability Butcher1 = new Ability("Butcher");

    /** The ability. */
    public static final Ability Rend = new Ability("Rend");

    /** The ability. */
    public static final Ability Spellblade = new Ability("Spellblade");

    /** The ability. */
    public static final Ability InfinityEdgePassive = new Ability();

    /** The ability. */
    public static final Ability IonianCDR = new Ability();

    /** The ability. */
    public static final Ability LuckyShadow = new Ability("Lucky Shadow");

    /** The ability. */
    public static final Ability KindlegemPassive = new Ability();

    /** The ability. */
    public static final Ability LastWhisperPassive = new Ability();

    /** The ability. */
    public static final Ability LiandrysTormentPassive = new Ability();

    /** The ability. */
    public static final Ability LichSpellblade = new Ability("Spellblade");

    /** The ability. */
    public static final Ability Maim1 = new Ability("Maim");

    /** The ability. */
    public static final Ability SolariActive = new Ability();

    /** The ability. */
    public static final Ability MaladyPassive = new Ability();

    /** The ability. */
    public static final Ability ManaWarp = new Ability("Mana Warp");

    /** The ability. */
    public static final Ability Awe = new Ability("Awe");

    /** The ability. */
    public static final Ability ManamuneManaCharge = new Ability("Mana Charge");

    /** The ability. */
    public static final Ability ManaPotion = new Ability();

    /** The ability. */
    public static final Ability MawOfMalmortiusPassive = new Ability();

    /** The ability. */
    public static final Ability Lifeline2 = new Ability("Lifeline");

    /** The ability. */
    public static final Ability MejaisSoulstealerPassive = new Ability();

    /** The ability. */
    public static final Ability Quicksilver2 = new Ability("Quicksilver");

    /** The ability. */
    public static final Ability TenacityPassive = new Ability("Tenacity");

    /** The ability. */
    public static final Ability MikaelsCrucibleActive = new Ability();

    /** The ability. */
    public static final Ability MorellonomiconPassive = new Ability();

    /** The ability. */
    public static final Ability MuramanaToggle = new Ability();

    /** The ability. */
    public static final Ability NashorsTooth = new Ability();

    /** The ability. */
    public static final Ability NinjaTabi = new Ability();

    /** The ability. */
    public static final Ability Ohmwrecker = new Ability();

    /** The ability. */
    public static final Ability OraclesElixir = new Ability();

    /** The ability. */
    public static final Ability Icy1 = new Ability("Icy");

    /** The ability. */
    public static final Ability PhantomDancer = new Ability();

    /** The ability. */
    public static final Ability Transmute = new Ability("Transmute");

    /** The ability. */
    public static final Ability Quicksilver = new Ability("Quicksilver");

    /** The ability. */
    public static final Ability RabadonsDeathcap = new Ability();

    /** The ability. */
    public static final Ability ColdSteel2 = new Ability("Cold Steel");

    /** The ability. */
    public static final Ability RanduinsOmen = new Ability();

    /** The ability. */
    public static final Ability RavenousHydra = new Ability();

    /** The ability. */
    public static final Ability Cleave = new Ability("Cleave");

    /** The ability. */
    public static final Ability Crescent = new Ability("Crescent");

    /** The ability. */
    public static final Ability RodOfAges = new Ability();

    /** The ability. */
    public static final Ability WardRefresh1 = new Ability("Ward Refresh");

    /** The ability. */
    public static final Ability GhostWard1 = new Ability("Ghost Ward");

    /** The ability. */
    public static final Ability RunaansHurricane = new Ability();

    /** The ability. */
    public static final Ability Legion = new Ability("Legion");

    /** The ability. */
    public static final Ability RylaisCrystalScepter = new Ability();

    /** The ability. */
    public static final Ability SeekersArmguard = new Ability();

    /** The ability. */
    public static final Ability Insight = new Ability("Insight");

    /** The ability. */
    public static final Ability ManaShield = new Ability("Mana Shield");

    /** The ability. */
    public static final Ability ShardOfTrueIce = new Ability();

    /** The ability. */
    public static final Ability SheenSpellblade = new Ability("Spellblade");

    /** The ability. */
    public static final Ability ShurelyasReverie = new Ability();

    /** The ability. */
    public static final Ability WardRefresh2 = new Ability("Ward Refresh");

    /** The ability. */
    public static final Ability GhostWard2 = new Ability("Ghost Ward");

    /** The ability. */
    public static final Ability SightWard = new Ability();

    /** The ability. */
    public static final Ability EnhancedMovement = new Ability("Enhanced Movement");

    /** The ability. */
    public static final Ability Butcher3 = new Ability("Butcher");

    /** The ability. */
    public static final Ability Incinerate = new Ability("Incinerate");

    /** The ability. */
    public static final Ability SpiritOftheSpectralWraithSV = new Ability();

    /** The ability. */
    public static final Ability SpiritOftheSpectralWraithSmite = new Ability();

    /** The ability. */
    public static final Ability Butcher2 = new Ability("Butcher");

    /** The ability. */
    public static final Ability SpiritVisage = new Ability();

    /** The ability. */
    public static final Ability StatikkShiv = new Ability();

    /** The ability. */
    public static final Ability Stinger = new Ability();

    /** The ability. */
    public static final Ability SunfireCape = new Ability();

    /** The ability. */
    public static final Ability SwordOftheDivinePassive = new Ability();

    /** The ability. */
    public static final Ability SwordOftheDivineActive = new Ability();

    /** The ability. */
    public static final Ability SwordOftheOccult = new Ability();

    /** The ability. */
    public static final Ability ManaCharge = new Ability("Mana Charge");

    /** The ability. */
    public static final Ability TheBlackCleaverPassive = new Ability();

    /** The ability. */
    public static final Ability TheBlackCleaverUniquePassive = new Ability();

    /** The ability. */
    public static final Ability TheBloodthirster = new Ability();

    /** The ability. */
    public static final Ability TheBrutalizer = new Ability();

    /** The ability. */
    public static final Ability TheHexCore = new Ability();

    /** The ability. */
    public static final Ability Thornmail = new Ability();

    /** The ability. */
    public static final Ability TrinitySpellblade = new Ability("Spellblade");

    /** The ability. */
    public static final Ability Hunt = new Ability("Hunt");

    /** The ability. */
    public static final Ability VisionWard = new Ability();

    /** The ability. */
    public static final Ability VoidStaff = new Ability();

    /** The ability. */
    public static final Ability ColdSteel1 = new Ability("Cold Steel");

    /** The ability. */
    public static final Ability WarmogsArmor = new Ability();

    /** The ability. */
    public static final Ability WillOftheAncients = new Ability();

    /** The ability. */
    public static final Ability WitsEnd = new Ability();

    /** The ability. */
    public static final Ability Maim2 = new Ability("Maim");

    /** The ability. */
    public static final Ability WrigglesLantern = new Ability();

    /** The ability. */
    public static final Ability YoumuusGhostbladePassive = new Ability();

    /** The ability. */
    public static final Ability YoumuusGhostbladeActive = new Ability();

    /** The ability. */
    public static final Ability ZekesHerald = new Ability();

    /** The ability. */
    public static final Ability Stasis = new Ability("Stasis");

    /** The ability name. */
    public final String name;

    /** The visible name. */
    public final boolean visible;

    /**
     * Create new ability with invisible name.
     */
    Ability() {
        this("");
    }

    /**
     * Create new ability with visible name.
     */
    Ability(String name) {
        this.name = name;
        this.visible = name.length() != 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbilityDescriptor createDescriptor(AbilityDescriptor previous) {
        return new AbilityDescriptor(this, previous);
    }

    static {
        AbyssalAura.update().passive("{1}の敵ユニットに{2}を与える。").aura().variable(1, Radius, 700).variable(2, MRReduction, 20);
        AegisLegion.update()
                .aura()
                .passive("{1}の味方ユニットは{2}、{3}、{4}を得る。味方ミニオンに対しては効果が1.5倍になる。")
                .variable(1, Radius, 1100)
                .variable(2, AR, 10)
                .variable(3, MR, 15)
                .variable(4, Hreg, 10);
        ArchangelInsight.update().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Mana, 0.03));
        ManaCharge.update().passive("スキル使用時及びマナ消費時に最大Manaが６増加する(最大増加量は750)。{1}。").variable(1, ItemCD, 3);
        AtheneRestore.update().passive("キルまたはアシスト時に{1}する。").variable(1, RestoreMana, 0, 0, amplify(Mana, 0.12));
        ManaFont.update().passive("{1}する。").variable(1, MregRatio, 0, 0, amplify(MissingManaPercentage, 0.01));
        AtamDamage.update().passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Health, 0.015));
        HexCorePower.update().ununique().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 3));
        HexCoreDeath.update().ununique().passive("Death Rayにダメージ30%分の魔法ダメージが追加される。このダメージは4秒間かけて与えられる。");
        HexCoreGravity.update().ununique().passive("Gravity Fieldの射程が30%増加する。");
        HexCoreTransfer.update().ununique().passive("Power Transfe使用・命中時に3秒間{1}する。").variable(1, MSRatio, 30);
        Avarice.update().passive("{1}を得る。").variable(1, GoldPer10Sec, 3);
        Greed.update().passive("キルを取る毎に{1}を得る。").variable(1, Gold, 2);
        AegisValor.update()
                .passive("{1}の味方ユニットは{2}を得る。味方ミニオンは与えるダメージが15%増加する。")
                .aura()
                .variable(1, Radius)
                .variable(2, Hreg, 10);
        Promote.update()
                .active("近くのSiege MinionをAnti-Turret-Minionに変身させる。Anti-Turret-Minionが敵ユニットを倒した場合、そのゴールドが得られる。またAnti-Turret Minionはタワーを最優先で攻撃する。{1}。")
                .variable(1, ItemCD, 180);
        Banshee.update().passive("敵Championからのスキルを無効化するシールドを張る。シールドはスキルを無効化すると消費され、25秒間敵Championからダメージを受けないと再生する。");
        EnhancedMovement1.update().passive("{1}する。").variable(1, MS, 25);
        EnhancedMovement2.update().passive("{1}する。").variable(1, MS, 45);
        EnhancedMovement3.update().passive("{1}する。").variable(1, MS, 60);
        EnhancedMovement5.update().passive("{1}する。5秒間戦闘をしなければ、{2}する。").variable(1, MS, 45).variable(2, MS, 105);
        Bilgewater.update()
                .active("対象の敵Champion({0})に{1}と2秒間{2}与える。{3}。")
                .variable(0, Radius, 500)
                .variable(1, MagicDamage, 100)
                .variable(2, MSSlowRatio, 25)
                .variable(3, ItemCD, 90);
        BotRKPassive.update()
                .passive("通常攻撃に{1}(Minionに対しては60が上限)を付与する。")
                .variable(1, PhysicalDamage, 0, 0, amplify(TargetCurrentHealthRatio, 5));
        BotRKActive.update()
                .active("対象の敵Champion({1})に{2}(下限100)を与え、{3}する。また4秒間{4}を与え、自身の移動速度がその分だけ増加する。")
                .variable(1, Radius, 500)
                .variable(2, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 15))
                .variable(3, RestoreHealth, 0, 0, amplify(DealtDamage, 1))
                .variable(4, MSSlowRatio, 30);
        BonetoothNecklaceDamage.update().passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Lv, 2));
        BonetoothNecklaceSpecial.update()
                .passive("キルまたはアシスト時に1 trophyを得て、死亡時に1 trophyを失う（最大値は14）。その数に応じて追加効果を得る。<br>3 : {1}と{2}を得る。<br>6 : {3}を得る。<br>9 : Unseen Predatorの射程が150増加する。<br>14 : Ultの効果時間が3秒増加する。またUltを使用した次にスキルを使用する際に1 Ferocityを追加で得る。")
                .variable(1, ARPen, 10)
                .variable(2, CDR, 5)
                .variable(3, MS, 25);
        SlowResist.update().passive("{1}を得る。").variable(1, Status.MSSlowReductionRatio, 25);
        ValorsReward.update()
                .passive("レベルアップ時に8秒かけて{1}し、{2}する。")
                .variable(1, RestoreHealth, 150)
                .variable(2, RestoreMana, 200);
        CrystallineFlaskActive.update()
                .active("チャージを一つ消費して12秒かけて{1}し、{2}する。")
                .variable(1, Status.RestoreHealth, 120)
                .variable(2, RestoreMana, 60);
        CrystallineFlaskCharge.update().passive("購入時及びショップを訪れる度に3つのチャージを得る。");
        DeathfireGraspActive.update()
                .active("対象の敵Champion({1})に{2}を与え、4秒間被魔法DMが20%増加するdebuffを与える。{3}。")
                .variable(1, Radius, 750)
                .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 15))
                .variable(3, ItemCD, 60);
        DransBladePassive.update().ununique().passive("敵ユニットに対して通常攻撃をする毎に{1}する。").variable(1, RestoreHealth, 5);
        DransRingPassive.update().ununique().passive("敵ユニットを倒すと{1}する。").variable(1, Status.RestoreMana, 5);
        DransShieldPassive.update().passive("敵Championからの{1}する。").variable(1, AttackDamageReduction, 6);
        Aid.update().passive("サモナースペルのHeal, Clairvoyance, ClarityのCDを30%減少させる。");
        EleisasBlessing.update().passive("このアイテムを所持した状態でレベルを3上げるとこのアイテムは消費されるが、アイテムの効果はその後もそのまま得られるようになる。");
        ElixirOfFortitudeActive.update()
                .ununique()
                .active("このアイテムを消費して180秒間、{1}と{2}を得る。")
                .variable(1, Health, 113, 0, amplify(Lv, 6.7))
                .variable(2, AD, 15);
        ElixirOfBrillianceActive.update()
                .ununique()
                .active("このアイテムを消費して180秒間、{1} と{2}を得る。")
                .variable(1, AP, 24, 0, amplify(Lv, 0.9))
                .variable(2, CDR, 10);
        Valor.update().passive("{1}の味方ユニットは{2}を得る。").aura().variable(1, Radius).variable(2, Hreg, 7);
        ExecutionersCallingPassive.update().passive("敵Championに対する通常攻撃に{1}を付与する。").variable(1, Wounds, 1.5);
        FiendishCodexPassive.update().passive("{1}を得る。").variable(1, CDR, 10);
        FrozenHeartPassive.update()
                .passive("{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 700)
                .variable(2, ASSlowRatio, 20)
                .aura();
        Icy.update()
                .passive("通常攻撃に1.5秒間{1}(Rangedは{2})を付与する。")
                .variable(1, MSSlowRatio, 40)
                .variable(2, MSSlowRatio, 30);
        GlacialShroudPassive.update().passive("{1}を得る。").variable(1, CDR, 10);
        GuardianAngelPassive.update()
                .passive("Healthが0になった際、4秒後に{1}と{2}を得て復活する。{3}。")
                .variable(1, Health, 0, 0, amplify(Health, 0.3))
                .variable(2, Mana, 0, 0, amplify(Mana, 0.3))
                .variable(3, ItemCD, 300);
        GuinsooPassive.update()
                .ununique()
                .passive("通常攻撃またはスキル使用時にスタックが1増加する。1スタックにつき{1}し{2}を得る。スタックは8秒持続し、最大8スタックまで増加する。")
                .variable(1, ASRatio, 4)
                .variable(2, AP, 4);
        GuinsooUniquePassive.update()
                .passive("自身のHealthが50%以下になった際に、戦闘状態が終わるまでの間{1}し{2}と{3}を得る。8秒間戦闘を行わないと解除される。{4}。")
                .variable(1, ASRatio, 20)
                .variable(2, LS, 10)
                .variable(3, SV, 10)
                .variable(4, ItemCD, 30);
        EyesOfPain.update().passive("{1}を得る。").variable(1, MRPen, 15);
        PortionHealth.update().ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreHealth, 150);
        PortionMana.update().ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreMana, 100);
        Lifeline1.update()
                .passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。{2}。")
                .variable(1, MagicShield, 250)
                .variable(2, ItemCD, 90);
        Lifeline2.update()
                .passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。{2}。")
                .variable(1, MagicShield, 400)
                .variable(2, ItemCD, 90);
        GunbladePassive.update().passive("{1}を得る。").variable(1, SV, 20);
        Reload.update()
                .passive("敵Championに通常攻撃でダメージを与えるか、単体対象かつDoTではないダメージスキルを使用するたびに、このアイテムのUNIQUE ActiveのCDが3秒解消する。");
        GunbladeActive.update()
                .active("対象の敵Champion({1})に{2}と2秒間{3}を与える。{4}。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 150, 0, ap(0.4))
                .variable(3, MSSlowRatio, 40)
                .variable(4, ItemCD, 60);
        HextechRevolverPassive.update().passive("{1}を得る。").variable(1, SV, 12);
        Butcher1.update().passive("中立モンスターに対するダメージが10%上昇する。");
        Butcher2.update().passive("中立モンスターに対するダメージが20%上昇する。");
        Butcher3.update().passive("中立モンスターに対するダメージが30%上昇する。");
        Rend.update().passive("中立モンスターに対する通常攻撃に{1}を付与する。").variable(1, TrueDamage, 10);
        Spellblade.update()
                .passive("スキル使用後の通常攻撃に、周囲の敵ユニットに{1}を与える効果を付与し、範囲内の敵ユニットに{2}を与える円形のフィールド（Melee{3} Ranged{4}）を2秒間形成する。{5}。")
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 1.25))
                .variable(2, MSSlowRatio, 30)
                .variable(3, Radius, 285)
                .variable(4, Radius, 210)
                .variable(5, ItemCD, 2);
        InfinityEdgePassive.update().passive("{1}する。").variable(1, CriticalDamageRatio, 50);
        IonianCDR.update().passive("{1}を得る。").variable(1, CDR, 15);
        LuckyShadow.update().passive("{1}を得る。").variable(1, Status.GoldPer10Sec, 4);
        KindlegemPassive.update().passive("{1}を得る。").variable(1, CDR, 15);
        LastWhisperPassive.update().passive("{1}を得る。").variable(1, ARPenRatio, 35);
        LiandrysTormentPassive.update()
                .passive("敵ユニットにスキルでダメージを与えた際に3秒かけて{1}を与える(ミニオンやモンスターに対しては上限300)。対象が移動阻害効果を受けている場合、ダメージは2倍になる。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetCurrentHealthRatio, 6));
        LichSpellblade.update()
                .passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。")
                .variable(1, MagicDamage, 50, 0, ap(0.75))
                .variable(2, ItemCD, 2);
        SolariActive.update()
                .active("自身と{1}の味方Championは5秒間{2}を得る。{3}。")
                .variable(1, Radius, 600)
                .variable(2, Shield, 50, 0, amplify(Lv, 10))
                .variable(3, ItemCD, 60);
        Maim1.update().passive("Minionまたは中立モンスターに対して通常攻撃をした際、25%の確率で{1}を与える。").variable(1, MagicDamage, 300);
        MaladyPassive.update()
                .passive("通常攻撃に{1}と{2}を与える。MR減少は7回までスタックし、8秒間持続する。")
                .variable(1, MagicDamage, 15, 0, ap(0.1))
                .variable(2, MRReduction, 4);
        ManaWarp.update().passive("{1}の味方Championは{2}を得る。").variable(1, Radius, 1100).variable(2, Hreg, 5).aura();
        Awe.update().passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Mana, 0.02));
        ManamuneManaCharge.update().passive("通常攻撃時、スキル使用時及びマナ消費時に最大Manaが4増加する(最大増加量は750)。{1}。").variable(1, ItemCD, 3);
        ManaPotion.update().ununique().active("15秒かけてManaを100回復する");
        MawOfMalmortiusPassive.update().passive("{1}を得る。").variable(1, AD, 0, 0, amplify(MissingHealthPercentage, 0.4));
        MejaisSoulstealerPassive.update()
                .passive("キル時2スタック、アシスト時1スタックを得て、死亡時に3割を失う（最大20スタック）。{1}を得て、20スタック時は{2}を得る。")
                .variable(1, AP, 0, 0, amplify(Stack, 8))
                .variable(2, CDR, 15);
        Quicksilver2.update()
                .active("自身のDebuffをすべて除去する。通常攻撃がMeleeのChampionが使用した場合、1秒間{1}する。{2}。")
                .variable(1, MSRatio, 50)
                .variable(2, ItemCD, 90);
        TenacityPassive.update().passive("{1} を得る。").variable(1, Status.Tenacity, 35);
        MikaelsCrucibleActive.update()
                .active("対象の味方Champion({1})のStun, Snare, Taunt, Fear, Silence, Slowを全て解除し、{2}する。{3}")
                .variable(1, Radius, 800)
                .variable(2, RestoreHealth, 150, 0, amplify(TargetMissingHealthRatio, 10))
                .variable(3, ItemCD, 180);
        MorellonomiconPassive.update().passive("HPが40%以下の敵Championに魔法DMを与えると{1}を与える。").variable(1, Wounds, 4);
        MuramanaToggle.update()
                .ununique()
                .passive("現在のManaの3%を消費して、通常攻撃または単体対象かつDoTではないダメージスキルに{1}を付与する。")
                .variable(1, PhysicalDamage, 0, 0, amplify(Status.CurrentManaRatio, 6));
        NashorsTooth.update().passive("{1}を得る。").variable(1, CDR, 20);
        NinjaTabi.update().passive("タワー以外の通常攻撃の被ダメージを10%低減");
        EnhancedMovement.update().passive("");
        Ohmwrecker.update().active("一番近くのTowerからの攻撃を2.5秒間防ぐ。この効果は同一のTowerに対して7.5秒に一度しか使えない。CD: 120s");
        OraclesElixir.update().ununique().active("近くのStealth状態の敵が味方に見えるようになる(Range:750)5分経つか、死亡すると効果が切れる");
        Icy1.update().passive("25%の確率で通常攻撃にスロー(Meleeは30%, Rangedは20%, 2s)を付与する");
        PhantomDancer.update().passive("ユニットをすり抜けるようになる。");
        Transmute.update().passive("10秒毎に5Goldを得る。");
        Quicksilver.update().active("自身のDebuffをすべて除去する。CD: 90s");
        RabadonsDeathcap.update().passive("自身のAbility Powerが30％増加する");
        ColdSteel2.update().passive("通常攻撃を受けた際に対象に1.5秒の間攻撃速度低下(15%)とスロー(10%)を与える。");
        RanduinsOmen.update()
                .active("周囲の敵ユニットに2秒間スロー(35%)を与える。この効果時間は、自身のArmor+Magic Resistの値100につき1s増加する。Range: 525 CD: 60s");
        RavenousHydra.update().ununique().passive("このアイテムによって与えられたダメージはLife Stealの効果を受ける。");
        Cleave.update()
                .passive("通常攻撃時に周囲のユニットに[攻撃力 × 60%]のダメージを与える。ダメージは攻撃対象から離れるにつれて減少し、最小で[攻撃力 × 20%]になる。Range: 385");
        Crescent.update()
                .active("周囲のユニットに[攻撃力 × 100%]のダメージを与える。ダメージは自身から離れるにつれて減少し、最小で[攻撃力 × 60%]になる。CD: 10s Range: 400");
        RodOfAges.update().ununique().passive("1分毎に+20 Health, +20 Mana, +2 Ability Powerを得るこの効果は10回まで発生する");
        ValorsReward.update().passive("Level Up時に8秒かけてHealthが150、Manaが200回復する");
        WardRefresh2.update().passive("購入時及びショップを訪れる度に5つのチャージを得る。");
        GhostWard2.update()
                .active("チャージを1つ消費してSight Wardと同様の効果があるオブジェクトを指定地点に設置する。このアイテムによって同時に設置できるWardの数は最大3個までで、4個目を設置するとこのアイテムによって設置された一番古いWardが消滅する。");
        RunaansHurricane.update()
                .passive("通常攻撃をした際に、周囲の2体の敵ユニットに10 + [攻撃力 × 50%]の物理DMを与える。これはOn-Hit Effectの効果を受ける。効果範囲: 375");
        Legion.update()
                .passive("近くの味方ユニットに次の効果を与える。味方Minionに対しては効果が1.5倍になる。+10 Armor, +25 Magic Resist, +10 Health Regen/5");
        RylaisCrystalScepter.update()
                .passive("スキルでダメージを与えた際にスロー(35%, 1.5s)を付与する。対象が複数のスキルまたは秒間ダメージスキルの場合、スローの効果は15%になる。");
        SeekersArmguard.update().passive("敵ユニットを倒す度に+0.5 Ability Power, +0.5 Armorを得る。この効果は30回分までスタックする。");
        Insight.update().passive("[自身の最大Mana × 3%]だけAbility Powerが増加する。");
        ManaShield.update().active("現在のManaの20%を消費し、消費した分のMana＋150の耐久値を持つシールドを得る。シールドは3秒間持続する。CD: 120s");
        LuckyShadow.update().passive("10秒毎に4Goldを得る。");
        ShardOfTrueIce.update()
                .active("対象の味方ユニットの周辺に4秒間持続する吹雪を発生させ、吹雪の範囲内にいる敵ユニットに30%のスローを与える。CD: 60s Range: 800 効果範囲: 200");
        SheenSpellblade.update().passive("スキル使用後の通常攻撃に、基本攻撃力の100%分の追加物理DMを付与するCD: 2s");
        ShurelyasReverie.update().active("近くの味方Championに3秒間+40% Movement Speedを与えるRange: 600 CD: 60s");
        WardRefresh1.update().passive("購入時及びショップを訪れる度に4つのチャージを得る。");
        GhostWard1.update()
                .active("チャージを1つ消費してSight Wardと同様の効果があるオブジェクトを指定地点に設置する。このアイテムによって同時に設置できるWardの数は最大2個までで、3個目を設置するとこのアイテムによって設置された一番古いWardが消滅する。");
        SightWard.update().ununique().active("視界1100を持つオブジェクトを指定地点に設置するオブジェクトは設置から約3秒後にステルス状態になり、3分間持続する");
        EnhancedMovement.update().passive("");
        Incinerate.update()
                .passive("通常攻撃またはDoTではないスキルによってダメージを与えた場合、自身のLvに応じて6-40の追加True Damageが付与される。このダメージは3秒かけて与えられる。");
        SpiritOftheSpectralWraithSV.update().passive("+20% Spell Vamp");
        SpiritOftheSpectralWraithSmite.update().passive("サモナースペルのSmiteのCDを20%減少させる。");
        Rend.update().passive("中立クリープに対する通常攻撃に10の追加TrueDMを付与する。");
        SpiritVisage.update().passive("自分から自分自身へのHP回復効果が20%増加する。");
        StatikkShiv.update()
                .passive("移動または通常攻撃を行うとその度にチャージが貯まっていく。 チャージが100に達した時、次の通常時に対象に雷を放ち100魔法DMを与える。雷は対象の付近の敵ユニット(範囲300)3体にも連鎖し同様のダメージを与える。雷によるダメージはクリティカルの影響を受ける。雷を放った後はチャージは0になる。建物を攻撃する時はチャージは増加するが雷は発生しない。");
        Stinger.update().passive("");
        SunfireCape.update().passive("周囲の敵ユニットに毎秒40魔法DMを与える。");
        SwordOftheDivinePassive.update()
                .ununique()
                .passive("UNIQUE ActiveがCD待ちの間は能力上昇が無くなる。敵Championキル時(アシストでは無効)に、UNIQUE Activeの現在のCDが50%解消される。");
        SwordOftheDivineActive.update()
                .active("3秒間または3回Critical Strikeが出るまでの間、+100% Attack Speedと+100% Critical Chanceを得る。CD: 60s");
        SwordOftheOccult.update()
                .passive("キルを得た際に2スタック、アシストを得た際に1スタックを得て(最大20スタック)、死亡時にその3割を失う。1スタックにつき+5 Damageを得る。20スタック時には+15% Movement Speedの効果を追加で得る。");
        TearManaCharge.update().passive("スキル使用時またはmana消費時に最大Manaが4増加する(最大増加量は750)。{1}。").variable(1, ItemCD, 3);
        TheBlackCleaverPassive.update()
                .ununique()
                .passive("敵championに物理DMを与えた際、対象のArmorを5%低下させる効果を付与する。5回（計25％）までスタックし、4秒間持続する。");
        TheBlackCleaverUniquePassive.update().passive("+10 Armor Penetration");
        TheBloodthirster.update()
                .ununique()
                .passive("敵ユニットを倒す度に+1 Damage, +0.20% Life Stealを得る。この効果は30回分までスタックし、死亡すると半分のスタックが失われる。");
        TheBrutalizer.update().passive("+10% Cooldown Reduction+10 Armor Penetration");
        TheHexCore.update().ununique().passive("");
        Thornmail.update().passive("敵の通常攻撃の元（Thornmail装備者のARによる軽減前）のダメージの30%を魔法DMとして敵に与える");
        TrinitySpellblade.update().passive("スキル使用後の通常攻撃に、基本攻撃力の150%分の追加物理DMを付与するCD: 2s");
        Hunt.update()
                .active("6秒間持続する無敵のゴーストを2体召喚する。ゴーストは最も近くにいる最大2人の敵Championの元まで移動していき(移動速度は450)、ゴーストが敵Championに触れた場合ゴーストが消滅し、その敵Championにスロー(40%,2.5s)を与え、2.5秒間対象の視界を得る。CD: 120s Range: 無限");
        VisionWard.update().ununique().active("ステルスを看破できる視界1000を持つオブジェクトを指定地点に設置するオブジェクトは設置から約3秒後にステルス状態になり、3分間持続する");
        VoidStaff.update().passive("+35% Magic Penetration");
        ColdSteel1.update().passive("通常攻撃を受けた際に対象に攻撃速度低下(15%,2s)を与える");
        WarmogsArmor.update().passive("[自身の最大Health × 1%]だけHealth Regen/5が増加する。");
        WillOftheAncients.update().passive("周囲の味方Championに+30 Ability Power, +20% Spell Vampを与える。");
        WitsEnd.update()
                .passive("通常攻撃に42の追加魔法DMを付与する。 通常攻撃に自身のMagic Resistを5増加させる効果を付与する。Magic Resistの増加は4回までスタックし、5秒間持続する。");
        Maim2.update().passive("Minionまたは中立クリープに対して通常攻撃をした際、25%の確率で500の追加魔法DMを付与する。");
        WrigglesLantern.update().active("Sight Wardと同等の効果があるオブジェクトを指定地点に設置する。CD: 180s");
        YoumuusGhostbladePassive.update().passive("");
        YoumuusGhostbladeActive.update()
                .active("Meleeなら6秒間、Rangedなら4秒間 +20% Movement Speed, +40% Attack Speedを得る。CD: 45s");
        ZekesHerald.update().passive("近くの味方Championに次の効果を与える  +10% Life Steal, +20 Attack Damage");
        Stasis.update().active("2.5秒間、自身を行動不能かつ無敵(ダメージ無効, ターゲット不可)にする。CD: 90s");

    }
}
