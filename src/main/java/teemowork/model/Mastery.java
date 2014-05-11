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

import static teemowork.model.Version.*;

/**
 * @version 2013/03/13 14:34:14
 */
public abstract class Mastery extends Describable<MasteryDescriptor> {

    /** The tree type. */
    public static final int Offense = 0;

    /** The tree type. */
    public static final int Defense = 1;

    /** The tree type. */
    public static final int Utility = 2;

    /** The mastery name. */
    public final String name;

    /** The system name. */
    public final String system;

    /** The tree type. */
    public final int type;

    /** The rank. */
    public final int rank;

    /** The required point. */
    public final int requirement;

    /** The requirement mastery. */
    public final Mastery dependency;

    /** The requirement mastery. */
    public Mastery dependedBy;

    /** The mastery id. */
    public final int id;

    /** The maximum level. */
    private final int level;

    /**
     * <p>
     * Define mastery.
     * </p>
     * 
     * @param name A mastery name.
     * @param level A max level.
     */
    Mastery(String name, int level, int type, int rank, int id, Mastery dependency) {
        this.name = name;
        this.system = name.replaceAll("[\\s-,!':/]", "");
        this.level = level;
        this.type = type;
        this.rank = rank;
        this.id = id;
        this.requirement = rank * 4;
        this.dependency = dependency;

        if (dependency != null) {
            dependency.dependedBy = this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return level;
    }

    /**
     * <p>
     * Compute full path to icon image.
     * </p>
     * 
     * @return
     */
    public abstract String getIcon();

    /**
     * <p>
     * Compute full path to icon image.
     * </p>
     * 
     * @return
     */
    public abstract String getSpriteImage();

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * <p>
     * Find masteries for the specified {@link Version}.
     * </p>
     * 
     * @param version
     * @return
     */
    public static Mastery[] getMastery(Version version) {
        if (version.isLessThan(P314)) {
            return MasterySeason3.Masteries;
        }
        return MasterySeason4.Masteries;
    }

    /**
     * <p>
     * Find masteries for the specified {@link Version}.
     * </p>
     * 
     * @param version
     * @return
     */
    public static Mastery[][][] getMasteryTree(Version version) {
        if (version.isLessThan(P314)) {
            return MasterySeason3.Trees;
        }
        return MasterySeason4.Trees;
    }
}
