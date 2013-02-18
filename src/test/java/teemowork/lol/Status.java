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
    // Health Related
    // ==================================================
    /** Health */
    Health, HealthPerLv, HealthRatio("Health", 0, "%"),

    /** Health Regeneration */
    Hreg(2), HregPerLv(2), HregRatio("Hreg", 2, "%"),

    // ==================================================
    // Mana Related
    // ==================================================
    /** Mana */
    Mana("Mana"), ManaPerLv, ManaRatio("Mana", 0, "%"),

    /** Mana Regeneration */
    Mreg(2), MregPerLv(2), MregRatio("Mana", 2, "%"),

    // ==================================================
    // Energy Related
    // ==================================================
    /** Energy */
    Energy, EnergyPerLv, EnergyRatio("Energy", 0, "%"),

    /** Energy Regeneration */
    Ereg, EregPerLv, EregRatio("Energy", 0, "%"),

    // ==================================================
    // My Health Reference
    // ==================================================
    CurrentHealth("現在のHealth"),

    MissingHealth("失ったHealth"),

    MissingHealthRatio("Health損耗率"),

    // ==================================================
    // Target Health Reference
    // ==================================================
    TargetHealth("対象の最大Health"),

    TargetCurrentHealth("対象の現在のHealth"),

    TargetMissingHealth("対象の減っているHealth"),

    TargetMissingHealthPercentage("対象のHealth損耗率"),

    // ==================================================
    // My Mana Reference
    // ==================================================
    CurrentMana("現在のMana"),

    MissingMana("失ったMana"),

    MissingManaRatio("Mana損耗率"),

    // ==================================================
    // Target Mana Reference
    // ==================================================
    TargetMana("対象の最大Mana"),

    TargetCurrentMana("対象の現在のMana"),

    TargetMissingMana("対象の減っているMana"),

    TargetMissingManaPercetage("対象のMana損耗率"),

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
    // Ability Power Related
    // ==================================================
    /** Ability Power */
    AP, APPerLv, APRatio,

    /** Cooldown Reduction */
    CDR("CD減少", 0, "%"), CDRPerLv, CDRRatio,

    /** Spell Vamp */
    SV("Spell Vamp", 0, "%"), SVPerLv, SVRatio,

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
    // Defense Related
    // ==================================================
    /** Attack Damage Resistance */
    AR, ARPerLv, ARRatio("AR", 3, "%"),

    /** Magic Damage Resistance */
    MR, MRPerLv, MRRatio("MR", 3, "%"),

    /** General Damage Reduction */
    DamageReduction, DamageReductionRatio,

    /** Physical Damage Reduction */
    PhysicalDamageReduction, PhysicalDamageReductionRatio,

    /** Magic Damage Reduction */
    MagicDamageReduction, MagicDamageReductionRatio,

    /** Attack Damage Reduction */
    AttackDamageReduction, AttackDamageReductionRatio,

    /** Shield */
    Shield("シールド"), PhysicalShield("物理DM用シールド"), MagicShield("魔法DM用シールド"),

    // ==================================================
    // Other Status Related
    // ==================================================
    /** Range */
    Range("射程"), RangePerLv, RangeRatio("射程"),

    /** Level */
    Lv, LvPerLv,

    /** Tenacity */
    Tenacity(null, 0, "%"), TenacityPerLv(null, 0, "%"),

    /** Experiment */
    Experiment("経験値"), ExperimentRatio("経験値", 0, "%"),

    /** Cooldown */
    CD, CDPerLv,

    Damage("与えたダメージ", 3, "%"),

    // ==================================================
    // Damage Type
    // ==================================================
    PhysicalDamage("物理DM"),

    MagicDamage("魔法DM"),

    TrueDamage("TrueDM"),

    // ==================================================
    // Heal Related
    // ==================================================
    RestoreHealth("Health"),

    RestoreHealthRatio("Health回復量", 3, "%"),

    RestoreMana("Mana"),

    RestoreEnergy("気"),

    // ==================================================
    // Crowd Control
    // ==================================================
    Charm("魅了", 3, "秒"),

    Stun("スタン", 3, "秒"),

    Snare("スネア", 3, "秒"),

    Fear("Fear", 3, "秒"),

    Terrified("Terrified", 3, "秒"),

    Silence("サイレンス", 3, "秒"),

    Blind("ブラインド", 0, "%"),

    Taunt("タウント", 3, "秒"),

    Suppression("サプレッション", 3, "秒"),

    Knockup("打ち上げ", 3, "秒"),

    Knockback("ノックバック"),

    MSSlow("移動速度低下"), MSSlowRatio("スロー", 0, "%"),

    ASSlow("攻撃速度低下"), ASSlowRatio("攻撃速度低下", 0, "%"),

    // ==================================================
    // Movement Related
    // ==================================================
    /** Movement Speed */
    MS("移動速度"), MSPerLv, MSRatio("移動速度"),

    /** Ignor Slow */
    IgnoreSlow(MSSlowRatio.name + "無効"),

    /** Ignore Unit Collision */
    IgnoreUnitCollision("ユニット衝突無効"),

    // ==================================================
    // Buff
    // ==================================================
    Stealth("ステルス"),

    // ==================================================
    // Special Condition
    // ==================================================
    Chill,

    // ==================================================
    // Time Related
    // ==================================================
    Time("", 3, "秒"),

    Duration("経過秒数"),

    CDRAwareTime("", 3, "秒"),

    Count("", 3, ""), Radius("範囲"),

    Length("長さ"),

    Distance("距離"),

    Gold,

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
    // public final String unit;

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
    }

    public String getUnit() {
        switch (this) {
        case Time:
        case Snare:
        case Silence:
        case Charm:
        case Stun:
        case Blind:
        case Taunt:
        case Fear:
        case Terrified:
        case Knockup:
        case Suppression:
        case CDRAwareTime:
            return "秒";

        case ASRatio:
        case MSRatio:
        case CDR:
        case SV:
        case LS:
        case ASSlowRatio:
        case MSSlowRatio:
        case DamageReductionRatio:
        case PhysicalDamageReductionRatio:
        case MagicDamageReductionRatio:
        case AttackDamageReductionRatio:
        case TargetCurrentHealth:
            return "%";

        default:
            return "";
        }
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
        case MS:
            return name + "が" + computed + "増加";

        case MSRatio:
            return name + "が" + computed + "%増加";

        case DamageReductionRatio:
            return "ダメージを" + computed + "%軽減";

        case PhysicalDamageReduction:
            return "物理ダメージを" + computed + "軽減";

        case RestoreEnergy:
        case RestoreHealth:
        case RestoreMana:
            return name + "が" + (computed == 0 ? "" : computed) + "回復";

        case ReduceCooldown:
            return "CDが" + (computed == 0 ? "" : computed + "秒") + "解消";

        case ASRatio:
        case ADRatio:
        case ARRatio:
        case MRRatio:
        case ExperimentRatio:
            if (computed == 0) {
                return name;
            } else {
                return name + "が" + computed + getUnit();
            }

        case TargetCurrentHealth:
            return name + "の" + computed + getUnit();

        case Gold:
            return computed + name;

        default:
            break;
        }

        if (computed == 0) {
            return name;
        }
        return name + computed + getUnit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
