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

import java.util.ArrayList;
import java.util.List;

import jsx.event.Publishable;

/**
 * @version 2013/12/13 9:11:59
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

    P303("3.03", 2013, 2, 28),

    P304("3.04", 2013, 3, 19),

    P305("3.5", 2013, 3, 28),

    P3051("3.5 Balance", 2013, 4, 10),

    P306("3.6", 2013, 4, 30),

    P307("3.7", 2013, 5, 16),

    P308("3.8", 2013, 6, 11),

    P309("3.9", 2013, 7, 10),

    P310("3.10", 2013, 7, 31),

    P310A("3.10a", 2013, 8, 21),

    P311("3.11", 2013, 9, 2),

    P312("3.12", 2013, 10, 1),

    P313("3.13", 2013, 10, 29),

    P314("3.14", 2013, 11, 20),

    P315("3.15", 2013, 12, 13),

    P410("4.1", 2014, 1, 15),

    PBE("Public Beta Environment", 2013, 1, 26);

    /** The latest stable version. */
    public static final Version Latest = P410;

    /** The selected version. */
    private static Version selection = Latest;

    /** The version name. */
    public final String name;

    /** The released year. */
    public final int year;

    /** The released month. */
    public final int month;

    /** The released day. */
    public final int day;

    /** The patch info. */
    public final List<Describable> info = new ArrayList();

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

    /**
     * <p>
     * Compare version.
     * </p>
     * 
     * @param other
     * @return
     */
    public boolean isLessThan(Version other) {
        return compareTo(other) == -1;
    }

    /**
     * <p>
     * Record patch info.
     * </p>
     * 
     * @param describable
     */
    protected void record(Describable describable) {
        info.add(describable);
    }

    /**
     * <p>
     * Set the current selected version.
     * </p>
     * 
     * @param version
     */
    public static void setSelection(Version version) {
        if (version != null) {
            selection = version;

            Publishable.Global.publish(selection);
        }
    }

    /**
     * <p>
     * Set the current selected version.
     * </p>
     */
    public static Version getSelection() {
        return selection;
    }
}
