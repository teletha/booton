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
 * @version 2013/01/23 23:37:52
 */
public enum Status {

    Cost,

    AS(3),

    ASPerLv,

    ASRatio,

    AD,

    ADPerLv,

    ADRatio,

    Critical,

    CriticalPerLv,

    CriticalRatio,

    LS,

    LSPerLv,

    LSRatio,

    Health,

    HealthPerLv,

    HealthRatio,

    Hreg(2),

    HregPerLv(2),

    HregRatio(2),

    Mana,

    ManaPerLv,

    ManaRatio,

    Mreg(2),

    MregPerLv(2),

    MregRatio(2),

    AP,

    APPerLv,

    APRatio,

    SV,

    SVPerLv,

    SVRatio,

    CDR,

    CDRPerLv,

    CDRRatio,

    AR,

    ARPerLv,

    ARRatio,

    MR,

    MRPerLv,

    MRRatio,

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

    EregRatio;

    /** The precision for value. */
    public final int precision;

    /**
     * @param precision
     */
    private Status() {
        this(0);
    }

    /**
     * @param precision
     */
    private Status(int precision) {
        this.precision = precision;
    }
}
