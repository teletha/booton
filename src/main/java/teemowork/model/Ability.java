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
    public static final Ability AbyssalAura = new Ability("AbyssalAura");

    /** The ability. */
    public static final Ability AegisLegion = new Ability("Legion", true);

    /** The ability. */
    public static final Ability ArchangelInsight = new Ability("Insight", true);

    /** The ability. */
    public static final Ability ManaCharge = new Ability("Mana Charge", true);

    /** The ability. */
    public static final Ability AtheneRestore = new Ability("AtheneRestore");

    /** The ability. */
    public static final Ability ManaFont = new Ability("Mana Font", true);

    /** The ability. */
    public static final Ability AtamDamage = new Ability("AtamDamage");

    /** The ability. */
    public static final Ability HexCorePower = new Ability("HexCorePower");

    /** The ability. */
    public static final Ability HexCoreDeath = new Ability("HexCoreDeath");

    /** The ability. */
    public static final Ability HexCoreGravity = new Ability("HexCoreGravity");

    /** The ability. */
    public static final Ability HexCoreTransfer = new Ability("HexCoreTransfer");

    /** The ability. */
    public static final Ability Avarice = new Ability("Avarice", true);

    /** The ability. */
    public static final Ability Greed = new Ability("Greed", true);

    /** The ability. */
    public static final Ability Valor = new Ability("Valor", true);

    /** The ability. */
    public static final Ability Promote = new Ability("Promote", true);

    /** The ability. */
    public static final Ability Banshee = new Ability("Banshee");

    /** The ability. */
    public static final Ability EnhancedMovement2 = new Ability("Enhanced Movement", true);

    /** The ability. */
    public static final Ability Bilgewater = new Ability("Bilgewater");

    /** The ability. */
    public static final Ability BotRKPassive = new Ability("BotRKPassive");

    /** The ability. */
    public static final Ability BotRKActive = new Ability("BotRKActive");

    /** The ability name. */
    public final String name;

    /** The visible name. */
    public final boolean visible;

    /**
     * Create new ability with invisible name.
     */
    Ability(String name) {
        this(name, false);
    }

    /**
     * <p>
     * Create new ability.
     * </p>
     * 
     * @param name
     */
    Ability(String name, boolean visible) {
        this.name = name;
        this.visible = visible;
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
        Valor.update()
                .passive("{1}の味方ユニットは{2}を得る。味方ミニオンは与えるダメージが15%増加する。")
                .aura()
                .variable(1, Radius)
                .variable(2, Hreg, 10);
        Promote.update()
                .active("近くのSiege MinionをAnti-Turret-Minionに変身させる。Anti-Turret-Minionが敵ユニットを倒した場合、そのゴールドが得られる。またAnti-Turret Minionはタワーを最優先で攻撃する。{1}。")
                .variable(1, ItemCD, 180);
        Banshee.update().passive("敵Championからのスキルを無効化するシールドを張る。シールドはスキルを無効化すると消費され、25秒間敵Championからダメージを受けないと再生する。");
        EnhancedMovement2.update().passive("{1}する。").variable(1, MS, 45);
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
    }
}
