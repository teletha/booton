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

/**
 * @version 2013/02/06 16:32:58
 */
public enum Status {

    Cost,

    CostPerLv,

    CostType,

    Sell,

    AS("攻撃速度", 3, "%"),

    ASPerLv,

    ASRatio,

    ASReduction("AS減少", 0, "%"),

    AD,

    ADPerLv,

    ADRatio,

    BounusAD,

    BounusADPerLv,

    BounusADRatio,

    Critical("Critical Chanse", 0, "%"),

    CriticalPerLv,

    CriticalRatio,

    LS("Life Steal", 0, "%"),

    LSPerLv,

    LSRatio,

    Health("Health"),

    HealthPerLv,

    HealthRatio,

    Hreg(2),

    HregPerLv(2),

    HregRatio(2),

    Mana("Mana"),

    ManaPerLv,

    ManaRatio,

    Mreg(2),

    MregPerLv(2),

    MregRatio(2),

    AP("Ability Power"),

    APPerLv,

    APRatio,

    SV("Spell Vamp", 0, "%"),

    SVPerLv,

    SVRatio,

    CD(1),

    CDPerLv,

    CDR("CD減少", 0, "%"),

    CDRPerLv,

    CDRRatio,

    AR,

    ARPerLv,

    ARRatio,

    ARReduction("AR減少"),

    MR,

    MRPerLv,

    MRRatio,

    MRReduction("MR減少"),

    Range,

    RangePerLv,

    RangeRatio,

    MS("移動速度"),

    MSPerLv,

    MSRatio("移動速度", 0, "%"),

    ARPen,

    ARPenPerLv,

    ARPenRatio(null, 0, "%"),

    ARPenRatioPerLv,

    MRPen,

    MRPenPerLv,

    MRPenRatio(null, 0, "%"),

    MRPenRatioPerLv,

    Energy,

    EnergyPerLv,

    EnergyRatio,

    Ereg,

    EregPerLv,

    EregRatio,

    Damage(""),

    PhysicalDamage("物理DM"),

    MagicDamage("魔法DM"),

    TrueDamage("TrueDM"),

    RestoreHealth("Health"),

    RestoreMana("Mana"),

    RestoreEnergy("気"),

    DamageReductionRation("DM減少", 0, "%"),

    PhysicalDamageReduction("物理DM減少"),

    Shield("シールド"),

    Lv,

    LvPerLv,

    LvRatio,

    Tenacity(null, 0, "%"),

    Charm("魅了", 3, "秒"),

    Stun("スタン", 3, "秒"),

    Snare("スネア", 3, "秒"),

    Silence("サイレンス", 3, "秒"),

    Knockup("打ち上げ", 3, "秒"),

    Knockback("ノックバック"),

    Slow("スロー", 0, "%"),

    Chill,

    Count("", 3, ""),

    Time("", 3, "秒"),

    CDRAwareTime("", 3, "秒"),

    TargetHealth("", 3, "%"),

    TargetCurrentHealth("対象の現在のHealth", 3, "%"),

    MissingHealth("Health損耗率", 3, "%"),

    Radius("範囲"),

    Length("長さ"),

    Distance("距離"),

    Gold;

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
        int round = 1;

        for (int i = 0; i < precision; i++) {
            round *= 10;
        }

        value *= round;
        value = Math.round(value);
        return value / round;
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
     * Format human-readable status with the specified value.
     * </p>
     * 
     * @param computed A value to display.
     * @return A formatted text.
     */
    public String format(double computed) {
        computed = round(computed);

        if (this == RestoreEnergy || this == RestoreHealth || this == RestoreMana) {
            return name + "が" + computed + "回復";
        }

        if (this == Gold) {
            return computed + name;
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
