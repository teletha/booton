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

    Sell,

    AS("Attack Speed", 3),

    ASPerLv,

    ASRatio,

    AD("Attack Damage"),

    ADPerLv,

    ADRatio,

    Critical("Critical Chanse"),

    CriticalPerLv,

    CriticalRatio,

    LS("Life Steal"),

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

    SV("Spell Vamp"),

    SVPerLv,

    SVRatio,

    CDR,

    CDRPerLv,

    CDRRatio,

    AR,

    ARPerLv,

    ARRatio,

    ARReduction,

    MR,

    MRPerLv,

    MRRatio,

    MRReduction,

    Range,

    RangePerLv,

    RangeRatio,

    MS,

    MSPerLv,

    MSRatio,

    ARPen,

    ARPenPerLv,

    ARPenRatio,

    MRPen,

    MRPenPerLv,

    MRPenRatio,

    Energy,

    EnergyPerLv,

    EnergyRatio,

    Ereg,

    EregPerLv,

    EregRatio,

    PhysicalDamage("Physical Damage"),

    MagicDamage("Magic Damage"),

    TrueDamage("True Damage"),

    Charm,

    Slow;

    /** The precision for value. */
    public final int precision;

    /** The status name. */
    public final String name;

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
        this(name, 0);
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
}
