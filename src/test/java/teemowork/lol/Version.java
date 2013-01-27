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

    P1154("preseason Balance Update 2", 2013, 1, 16),

    PBE("Public Beta Environment", 2013, 1, 26);

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
