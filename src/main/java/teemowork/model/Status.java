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

import js.math.Mathematics;

/**
 * @version 2013/06/06 20:22:40
 */
public enum Status {

    // ==================================================
    // Damage Type
    // ==================================================
    /** Any Damage */
    Damage("ダメージ"), DamageRatio(Damage), CriticalDamageRatio("クリティカルダメージ", 2),

    /** Physical Daname */
    PhysicalDamage("物理DM"),

    /** Magic Damage */
    MagicDamage("魔法DM"),

    /** True Damage */
    TrueDamage("TrueDM"),

    /** ATtack Damage */
    AttackDamage("通常攻撃によるダメージ"), AttackDamageRatio(AttackDamage),

    /** Dealt Damage */
    DealtDamage("与えたDM"), DealtDamageRatio(DealtDamage),

    /** Received Damage */
    ReceivedDamage("受けたDM"), ReceivedDamageRatio(ReceivedDamage), ReceivedDOriginalamageRatio("軽減前の受けたDM"),

    /** Received Damage */
    PreventedDamage("軽減したDM"), PreventedDamageRatio(ReceivedDamage),

    // ==================================================
    // Health Related
    // ==================================================
    /** Health */
    Health, HealthPerLv, HealthRatio("Health"), BounusHealth("増加Health"),

    /** Health Regeneration */
    Hreg(2), HregPerLv(2), HregRatio("Hreg", 2),

    /** Health Cost */
    LoseHealth("Health"),

    // ==================================================
    // Mana Related
    // ==================================================
    /** Mana */
    Mana("Mana"), ManaPerLv, ManaRatio("Mana"), BounusMana("増加Mana"),

    /** Mana Regeneration */
    Mreg(2), MregPerLv(2), MregRatio("Mreg", 2),

    // ==================================================
    // Energy Related
    // ==================================================
    /** Energy */
    Energy, EnergyPerLv, EnergyRatio("Energy"),

    /** Energy Regeneration */
    Ereg, EregPerLv, EregRatio("Energy"),

    // ==================================================
    // My Health Reference
    // ==================================================
    CurrentHealthRatio("現在のHealth"),

    MissingHealthRatio("失ったHealth"),

    MissingHealthPercentage("Health損耗率"),

    // ==================================================
    // Target Health Reference
    // ==================================================
    TargetMaxHealthRatio("対象の最大Health"),

    TargetCurrentHealthRatio("対象の現在のHealth"),

    TargetMissingHealthRatio("対象の減っているHealth"),

    TargetMissingHealthPercentage("対象のHealth損耗率"),

    // ==================================================
    // My Mana Reference
    // ==================================================
    CurrentManaRatio("現在のMana"),

    MissingManaRatio("失ったMana"),

    MissingManaPercentage("Mana損耗率"),

    // ==================================================
    // Target Mana Related Reference
    // ==================================================
    TargetAP("対象のAP"),

    TargetManaRatio("対象の最大Mana"),

    TargetCurrentManaRatio("対象の現在のMana"),

    TargetMissingManaRatio("対象の減っているMana"),

    TargetMissingManaPercetage("対象のMana損耗率"),

    // ==================================================
    // Attack Related
    // ==================================================
    /** Attack Damage */
    AD, ADPerLv, ADRatio("AD"), BounusAD("増加AD"), BaseAD("基礎AD"),

    /** Attack Speed */
    AS(3), ASPerLv(3), ASRatio("攻撃速度"),

    /** life Steal */
    LS("Life Steal"), LSPerLv, LSRatio,

    /** Critical Chance */
    Critical("Critical Chance"), CriticalPerLv, CriticalRatio,

    // ==================================================
    // Ability Power Related
    // ==================================================
    /** Ability Power */
    AP, APPerLv, APRatio("AP", 2),

    /** Cooldown Reduction */
    CDR("CD減少"), CDRPerLv, CDRRatio, CDRUnaware("CD減少の影響を受けない"),

    /** Spell Vamp */
    SV("Spell Vamp"), SVPerLv, SVRatio,

    // ==================================================
    // AR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    ARPen, ARPenPerLv,

    /** Percentage Penetration */
    ARPenRatio("ARPen"), ARPenRatioPerLv,

    /** Flat Reduction */
    ARReduction("AR減少"),

    /** Percentage Reduction */
    ARReductionRatio("AR減少"),

    // ==================================================
    // MR Penetrations and Reductions
    // ==================================================
    /** Flat Penetration */
    MRPen, MRPenPerLv,

    /** Percentage Penetration */
    MRPenRatio("MRPen"), MRPenRatioPerLv,

    /** Flat Reduction */
    MRReduction("MR減少"),

    /** Percentage Reduction */
    MRReductionRatio("MR減少"),

    // ==================================================
    // Defense Related
    // ==================================================
    /** Attack Damage Resistance */
    AR, ARPerLv, ARRatio("AR", 3), BounusAR("増加AR"),

    /** Magic Damage Resistance */
    MR, MRPerLv, MRRatio("MR", 3), BounusMR("増加MR"),

    /** General Damage Reduction */
    DamageReduction(Damage), DamageReductionRatio(Damage),

    /** Physical Damage Reduction */
    PhysicalDamageReduction(PhysicalDamage), PhysicalDamageReductionRatio(PhysicalDamage),

    /** Magic Damage Reduction */
    MagicDamageReduction(MagicDamage), MagicDamageReductionRatio(MagicDamage),

    /** Attack Damage Reduction */
    AttackDamageReduction(AttackDamage), AttackDamageReductionRatio(AttackDamage),

    /** Other Status Reduction */
    ADReduction(AD),

    /** Movement Slow Reduction */
    MSSlowReduction("スロー"), MSSlowReductionRatio("スロー"),

    /** Shield */
    Shield("シールド"), PhysicalShield("物理DM用シールド"), MagicShield("魔法DM用シールド"), SpellShield("スペルシールド"),

    // ==================================================
    // Other Status Related
    // ==================================================
    /** Range */
    Range("射程"), RangePerLv, RangeRatio("射程"),

    /** Projectile Speed. */
    ProjectileSpeed("投射速度"),

    /** Grow Body Size */
    Grow("サイズ"),

    /** Level */
    Lv,

    /** Tenacity */
    Tenacity("Tenacity"), TenacityPerLv,

    /** Experiment */
    Experiment("経験値"), ExperimentRatio("経験値"),

    /** Cooldown */
    CD(1), CDPerLv, CDDecrease(1), CDDecreaseRatio(1), ItemCD("CD", 1),

    // ==================================================
    // Heal Related
    // ==================================================
    RestoreHealth("Health"),

    RestoreHealthRatio("Health回復量", 3),

    RestoreMana("Mana"),

    RestoreEnergy("気"),

    // ==================================================
    // Crowd Control and Debuff
    // ==================================================
    Charm("魅了", 3),

    Stun("スタン", 3),

    Snare("スネア", 3),

    Fear("Fear", 3),

    Terrified("Terrified", 3),

    Silence("サイレンス", 3),

    Blind("ブラインド", 3),

    Taunt("タウント", 3),

    Suppression("サプレッション", 3),

    Knockup("打ち上げ", 3),

    Knockback("ノックバック"),

    MSSlow("移動速度低下"), MSSlowRatio("スロー"),

    ASSlow("攻撃速度低下"), ASSlowRatio(ASSlow),

    Wounds("HP回復量半減"),

    Foggy("視界低下"),

    // ==================================================
    // Movement Related
    // ==================================================
    /** Movement Speed */
    MS("移動速度"), MSPerLv, MSRatio("移動速度"), BounusMS("増加移動速度"),

    /** Ignore Slow */
    IgnoreSlow(MSSlowRatio.name + "無効"),

    /** Ignore Unit Collision */
    IgnoreUnitCollision("ユニット衝突無効"),

    // ==================================================
    // State
    // ==================================================
    /** Ignore Crowd Control */
    IgnoreCC("CC無効"),

    Stealth("ステルス"),

    Visionable("視界を得る"),

    NotSpellCast("このスキルはSpellcastとして扱われない"),

    Chill,

    // ==================================================
    // Cost Related
    // ==================================================
    /** Cost */
    Cost, CostPerLv,

    Sell,

    Gold, GoldPer10Sec,

    // ==================================================
    // Time Related
    // ==================================================
    Time("", 3), CDRAwareTime(""), RespawnTimeReductionRatio("死亡時間"),

    Duration("経過秒数"),

    Count("", 3), Radius("範囲"),

    Length("長さ"),

    Distance("距離"),

    MissileSpeed("弾速"),

    EnemyChampion("敵Championの数"),

    Value("", 0),

    Percentage(""),

    Charge,

    Stack("スタック"), ConsumedStack("消費したスタック");

    /** The status name. */
    public final String name;

    /** The unit. */
    // public final String unit;

    /** The precision for value. */
    public final int precision;

    /**
     * @param precision
     */
    private Status() {
        this(1);
    }

    /**
     * @param name
     */
    private Status(String name) {
        this(name, 1);
    }

    /**
     * @param status
     */
    private Status(Status status) {
        this(status.name, 1);
    }

    /**
     * @param precision
     */
    private Status(int precision) {
        this(null, precision);
    }

    /**
     * @param name
     */
    private Status(String name, int precision) {
        this.name = name == null ? name() : name;
        this.precision = precision;
    }

    /**
     * <p>
     * Test status type.
     * </p>
     * 
     * @return
     */
    public boolean isPerLv() {
        return name().endsWith("PerLv");
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
     * Find ratio status.
     * </p>
     * 
     * @return
     */
    public Status ratio() {
        return Status.valueOf(name() + "Ratio");
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

    public String getUnit() {
        if (name().endsWith("Ratio")) {
            return "%";
        }

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
        case Wounds:
        case Knockup:
        case Suppression:
        case CDRAwareTime:
        case CDDecrease:
            return "秒";

        case Stealth:
            return "秒間";

        case CDR:
        case Critical:
        case SV:
        case LS:
        case Tenacity:
        case Percentage:
        case Grow:
            return "%";

        default:
            return "";
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
        switch (this) {
        case Critical:
        case MS:
        case DamageRatio:
        case CriticalDamageRatio:
        case AttackDamage:
        case AttackDamageRatio:
        case MSRatio:
        case ASRatio:
        case ADRatio:
        case APRatio:
        case ARRatio:
        case MRRatio:
        case HealthRatio:
        case ManaRatio:
        case HregRatio:
        case MregRatio:
        case ExperimentRatio:
        case RestoreHealthRatio:
        case Grow:
            return name + "が" + formatValue(computed) + "増加";

        case DamageReduction:
        case DamageReductionRatio:
        case PhysicalDamageReduction:
        case PhysicalDamageReductionRatio:
        case MagicDamageReduction:
        case MagicDamageReductionRatio:
        case AttackDamageReduction:
        case AttackDamageReductionRatio:
        case MSSlowReduction:
        case MSSlowReductionRatio:
        case RespawnTimeReductionRatio:
            return name + "を" + formatValue(computed) + "軽減";

        case ADReduction:
            return name + "が" + formatValue(computed) + "減少";

        case LoseHealth:
            return name + "を" + formatValue(computed) + "消費";

        case RestoreEnergy:
        case RestoreHealth:
        case RestoreMana:
            return name + "が" + formatValue(computed) + "回復";

        case CDDecrease:
        case CDDecreaseRatio:
            return "CDが" + formatValue(computed) + "解消";

        case Stealth:
            return formatValue(computed) + "ステルス";

        case Gold:
            return formatValue(computed) + "Gold";

        case GoldPer10Sec:
            return "10秒毎に" + formatValue(computed) + "Gold";

        case Range:
            return "射程が" + formatValue(computed) + "増加";

        case Knockback:
            String length = formatValue(computed);

            if (length.length() == 0) {
                return name;
            } else {
                return name + "(距離" + formatValue(computed) + ")";
            }

        case Stack:
        case ConsumedStack:
            return formatValue(computed) + "スタック";
        }
        return name + formatValue(computed);
    }

    /**
     * <p>
     * Helper method to format value.
     * </p>
     * 
     * @param value
     * @return
     */
    private String formatValue(double value) {
        return value == 0 ? "" : round(value) + getUnit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
