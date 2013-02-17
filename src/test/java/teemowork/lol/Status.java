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

import js.math.Mathematics;

/**
 * @version 2013/02/06 16:32:58
 */
public enum Status {

    /** Cost */
    Cost, CostPerLv,

    Sell,

    // ==================================================
    // Attack Related
    // ==================================================
    /** Attack Damage */
    AD, ADPerLv, ADRatio("AD", 0, "%"),

    /** Attack Speed */
    AS(3), ASPerLv(3), ASRatio("攻撃速度", 0, "%"),

    /** life Steal */
    LS("Life Steal", 0, "%"), LSPerLv, LSRatio,

    /** Critical Chance */
    Critical("Critical Chanse", 0, "%"), CriticalPerLv, CriticalRatio,

    // ==================================================
    // Ability Related
    // ==================================================
    /** Ability Power */
    AP, APPerLv, APRatio,

    /** Cooldown Reduction */
    CDR("CD減少", 0, "%"), CDRPerLv, CDRRatio,

    /** Spell Vamp */
    SV("Spell Vamp", 0, "%"), SVPerLv, SVRatio,

    Health("Health"),

    HealthPerLv,

    HealthRatio,

    Hreg(2),

    HregPerLv(2),

    HregRatio("Hreg", 2, "%"),

    Mana("Mana"),

    ManaPerLv,

    ManaRatio,

    Mreg(2),

    MregPerLv(2),

    MregRatio(2),

    // ==================================================
    // Defense Related
    // ==================================================
    /** Attack Damage Resistance */
    AR, ARPerLv, ARRatio(AR.name, 3, "%"),

    MR,

    MRPerLv,

    MRRatio(MR.name(), 3, "%"),

    Range,

    RangePerLv,

    RangeRatio,

    MS("移動速度"),

    MSPerLv,

    MSRatio("移動速度", 0, "%"),

    // ==================================================
    // AR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    ARPen, ARPenPerLv,

    /** Percentage Penetration */
    ARPenRatio(ARPen.name(), 0, "%"), ARPenRatioPerLv,

    /** Flat Reduction */
    ARReduction("AR減少"),

    /** Percentage Reduction */
    ARReductionRatio("AR減少", 0, "%"),

    // ==================================================
    // MR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    MRPen, MRPenPerLv,

    /** Percentage Penetration */
    MRPenRatio(MRPen.name(), 0, "%"), MRPenRatioPerLv,

    /** Flat Reduction */
    MRReduction("MR減少"),

    /** Percentage Reduction */
    MRReductionRatio("MR減少", 0, "%"),

    // ==================================================
    // Energy
    // ==================================================
    Energy,

    EnergyPerLv,

    EnergyRatio,

    Ereg,

    EregPerLv,

    EregRatio,

    /** Cooldown */
    CD, CDPerLv,

    Damage("与えたダメージ", 3, "%"),

    PhysicalDamage("物理DM"),

    MagicDamage("魔法DM"),

    TrueDamage("TrueDM"),

    RestoreHealth("Health"),

    RestoreHealthRatio("Health回復量", 3, "%"),

    RestoreMana("Mana"),

    RestoreEnergy("気"),

    DamageReductionRatio("DM", 0, "%"),

    PhysicalDamageReduction("物理DM減少"),

    NormalAttackDamageReduction("通常攻撃DM減少"),

    Shield("シールド"),

    MagicShield("魔法DM用シールド"),

    Lv,

    LvPerLv,

    LvRatio,

    Tenacity(null, 0, "%"),

    TenacityPerLv(null, 0, "%"),

    Charm("魅了", 3, "秒"),

    Stun("スタン", 3, "秒"),

    Snare("スネア", 3, "秒"),

    Fear("Fear", 3, "秒"),

    Terrified("Terrified", 3, "秒"),

    Silence("サイレンス", 3, "秒"),

    Taunt("タウント", 3, "秒"),

    Suppression("サプレッション", 3, "秒"),

    Knockup("打ち上げ", 3, "秒"),

    Knockback("ノックバック"),

    Slow("スロー", 0, "%"),

    ASSlow("攻撃速度低下", 0, "%"),

    Blind("ブラインド", 0, "%"),

    Chill,

    Count("", 3, ""),

    Time("", 3, "秒"),

    Duration("経過秒数"),

    CDRAwareTime("", 3, "秒"),

    CurrentHealth("現在のHealth", 0, "%"),

    CurrentMana("現在のMana", 0, "%"),

    TargetHealth("対象の最大Health", 3, "%"),

    TargetCurrentHealth("対象の現在のHealth", 0, "%"),

    TargetMissingHealth("対象の減っているHealth", 0, "%"),

    MissingHealth("失ったHealth"),

    MissingHealthRatio("Health損耗率"),

    Radius("範囲"),

    Length("長さ"),

    Distance("距離"),

    Gold,

    Experiment("経験値"),

    ExperimentRatio("経験値", 0, "%"),

    BounusAD("増加AD"),

    BounusHealth("増加Health"),

    BounusMS("増加移動速度"),

    EnemyChampion("敵Championの数"),

    ReduceCooldown,

    Percentage("", 0, "%"),

    Charge,

    Stack("スタック");

    /** The status name. */
    public final String name;

    /** The unit. */
    public final String unit;

    /** The precision for value. */
    private final int precision;

    /**
     * @param precision
     */
    private Status() {
        this(0);
    }

    /**
     * @param precision
     */
    private Status(String name) {
        this(name, 0, null);
    }

    /**
     * @param precision
     */
    private Status(int precision) {
        this(null, precision, null);
    }

    /**
     * @param name
     */
    private Status(String name, int precision, String unit) {
        this.name = name == null ? name() : name;
        this.precision = precision;
        this.unit = unit == null ? "" : unit;
    }

    /**
     * <p>
     * Round up the specified value decimal for this state.
     * </p>
     * 
     * @param value
     * @return
     */
    public double round(double value) {
        return Mathematics.round(value, precision);
    }

    /**
     * <p>
     * Find per level status.
     * </p>
     * 
     * @return
     */
    public Status per() {
        return Status.valueOf(name() + "PerLv");
    }

    /**
     * <p>
     * Compute values.
     * </p>
     * 
     * @param one
     * @param other
     * @return
     */
    public double compute(double one, double other) {
        switch (this) {
        case ARPenRatio:
        case ARReductionRatio:
        case MRPenRatio:
        case MRReductionRatio:
        case Tenacity:
            return (1 - (1 - one / 100) * (1 - other / 100)) * 100;

        default:
            return one + other;
        }
    }

    /**
     * <p>
     * Format human-readable status with the specified value.
     * </p>
     * 
     * @param computed A value to display.
     * @return A formatted text.
     */
    public String format(double computed) {
        computed = round(computed);

        switch (this) {
        case RestoreEnergy:
        case RestoreHealth:
        case RestoreMana:
            return name + "が" + (computed == 0 ? "" : computed) + "回復";

        case ReduceCooldown:
            return "CDが" + (computed == 0 ? "" : computed + "秒") + "解消";

        case ASRatio:
        case MSRatio:
        case ADRatio:
        case ARRatio:
        case MRRatio:
        case ExperimentRatio:
            if (computed == 0) {
                return name;
            } else {
                return name + "が" + computed + unit;
            }

        case TargetCurrentHealth:
            return name + "の" + computed + unit;

        case Gold:
            return computed + name;

        default:
            break;
        }

        if (computed == 0) {
            return name;
        }
        return name + computed + unit;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
