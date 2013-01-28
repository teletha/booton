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
 * @version 2013/01/27 0:36:31
 */
public enum Version {

    P0000("Release", 2009, 10, 27),

    P1148("Late September", 2012, 9, 26),

    P1149("World Championship Hotfix", 2012, 9, 18),

    P1150("Shadow Isles", 2012, 10, 25),

    P1151("End of Season 2", 2012, 11, 13),

    P1152("Preseason 3", 2012, 12, 4),

    P1153("Preseason Balance Update 1", 2012, 12, 14),

    P1154("Preseason Balance Update 2", 2013, 1, 16),

    PBE("Public Beta Environment", 2013, 1, 26);

    /** The latest stable version. */
    public static final Version Latest = P1154;

    /** The version name. */
    public final String name;

    /** The released year. */
    public final int year;

    /** The released month. */
    public final int month;

    /** The released day. */
    public final int day;

    /**
     * <p>
     * Create new version.
     * </p>
     * 
     * @param name A name.
     * @param year The released year.
     * @param month The released month.
     * @param day The released day.
     */
    Version(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }
}
