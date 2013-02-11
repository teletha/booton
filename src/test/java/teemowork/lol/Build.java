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

import static teemowork.lol.Status.*;

import java.util.List;
import java.util.Set;

import js.bind.Notifiable;
import js.util.ArrayList;
import js.util.HashSet;
import teemowork.model.MasterySet;
import teemowork.model.Rune;

/**
 * @version 2013/01/25 14:31:39
 */
public class Build extends Notifiable {

    /** The selected champion. */
    public final Champion champion;

    /** The version. */
    private Version version = Version.Latest;

    /** The level. */
    private int level = 1;

    /** The item list. */
    private Item[] items = new Item[6];

    /** The item list. */
    private int[] itemCounts = {1, 1, 1, 1, 1, 1};

    /** The skill order. */
    private int[] skills = new int[18];

    /** The skill level. */
    private int[] skillLevel = {0, 1, 1, 1, 1};

    /** The mastery. */
    private MasterySet mastery;

    /** The rune list. */
    private List<Rune> marks = new ArrayList();

    /** The rune list. */
    private List<Rune> glyphs = new ArrayList();

    /** The rune list. */
    private List<Rune> seals = new ArrayList();

    /** The rune list. */
    private List<Rune> quintessences = new ArrayList();

    /** The first cache for computed value. */
    private List<Computed> cache = new ArrayList(Status.values().length);

    /**
     * @param champion
     */
    public Build(Champion champion) {
        this.champion = champion;

        items[0] = Item.DeathfireGrasp;
    }

    /**
     * Get the level property of this {@link Build}.
     * 
     * @return The level property.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Set the level property of this {@link Build}.
     * 
     * @param level The level value to set.
     */
    public void setLevel(int level) {
        if (0 < level && level < 19) {
            this.level = level;

            fire();
        }
    }

    /**
     * Get the patch property of this {@link Build}.
     * 
     * @return The patch property.
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Set the patch property of this {@link Build}.
     * 
     * @param version The patch value to set.
     */
    public void setVersion(Version version) {
        if (version != null) {
            this.version = version;

            fire();
        }
    }

    /**
     * <p>
     * Compute build status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    public Computed get(Status status) {
        switch (status) {
        case MSRatio:
        case ARPen:
        case ARPenRatio:
        case MRPen:
        case MRPerLv:
        case Energy:
        case Ereg:
            return new Computed(0, 0, status);

        case AS:
            double baseAS = champion.getStatus(version).get(AS);
            double levelAS = champion.getStatus(version).get(ASPerLv) * (level - 1);
            return new Computed(baseAS * (1 + levelAS / 100), baseAS * (1 + (levelAS + sum(ASRatio)) / 100), status);

        default:
            Status per = Status.valueOf(status.name() + "PerLv");
            Status ratio = Status.valueOf(status.name() + "Ratio");

            double base = base(status);
            double computed = (base + sum(status) + sum(per) * level) * (1 + sum(ratio) / 100);

            return new Computed(base, computed, status);
        }
    }

    /**
     * <p>
     * Set item.
     * </p>
     * 
     * @param index A index to store item.
     * @param item A item to store.
     */
    public void setItem(int index, Item item) {
        if (0 <= index && index <= 5) {
            items[index] = item;
            itemCounts[index] = 1;

            fire();
        }
    }

    /**
     * <p>
     * Increase skill level.
     * </p>
     * 
     * @param skill
     */
    public void up(Skill skill) {
        int index = skill.key.ordinal();
        int now = skillLevel[index];

        if (now < skill.getMaxLevel()) {
            skillLevel[index] = now + 1;

            fire();
        }
    }

    /**
     * <p>
     * Retrieve skill level.
     * </p>
     * 
     * @param skill A target skill.
     * @return A skill level.
     */
    public int getLevel(Skill skill) {
        return skillLevel[skill.key.ordinal()];
    }

    /**
     * <p>
     * Decrease skill level.
     * </p>
     * 
     * @param skill
     */
    public void down(Skill skill) {
        int index = skill.key.ordinal();
        int now = skillLevel[index];

        if (1 < now) {
            skillLevel[index] = now - 1;

            fire();
        }
    }

    /**
     * <p>
     * Compute champion base status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    private double base(Status status) {
        switch (status) {
        case MS:
        case MSRatio:
        case ARPen:
        case ARPenRatio:
        case MRPen:
        case MRPenRatio:
        case Energy:
        case Ereg:
            return champion.getStatus(version).get(status);

        default:
            Status per = Status.valueOf(status.name() + "PerLv");
            return champion.getStatus(version).get(status) + champion.getStatus(version).get(per) * level;
        }
    }

    /**
     * <p>
     * Compute sum of the specified improvements.
     * </p>
     * 
     * @param improvementType A target type.
     * @return A sum value.
     */
    private double sum(Status status) {
        double sum = 0;

        // manage unique ability
        Set<String> names = new HashSet();

        for (int i = 0; i < 6; i++) {
            Item item = items[i];

            if (item != null) {
                ItemStatus descriptor = item.getStatus(version);

                // compute item status
                sum += descriptor.get(status);

                for (ItemAbility ability : descriptor.abilities) {
                    ItemAbilityStatus abilityDescriptor = ability.getStatus(version);

                    if (abilityDescriptor.isUnique() && names.contains(ability.name)) {
                        continue;
                    }
                    names.add(ability.name);

                    // compute ability status
                    sum += abilityDescriptor.get(status) * itemCounts[i];
                }
            }
        }

        // for (Rune rune : marks) {
        // sum += rune.improvement.get(status, version);
        // }
        //
        // for (Rune rune : seals) {
        // sum += rune.improvement.get(status, version);
        // }
        //
        // for (Rune rune : glyphs) {
        // sum += rune.improvement.get(status, version);
        // }
        //
        // for (Rune rune : quintessences) {
        // sum += rune.improvement.get(status, version);
        // }

        return sum;
    }

    /**
     * @version 2013/01/25 13:42:02
     */
    public class Computed {

        /** The champion base value. */
        public final double base;

        /** The computed value. */
        public final double value;

        /** The increased value. */
        public final double increased;

        /**
         * @param base A base value.
         * @param value A computed value.
         */
        private Computed(double base, double value, Status status) {
            this.base = status.round(base);
            this.value = status.round(value);
            this.increased = status.round(value - base);

            cache.set(status.ordinal(), this);
        }

        /**
         * <p>
         * Retrieve computed value as String expression.
         * </p>
         * 
         * @return A computed value.
         */
        public String value() {
            return String.valueOf(value);
        }

        /**
         * <p>
         * Retrieve base value as String expression.
         * </p>
         * 
         * @return A base value.
         */
        public String base() {
            return String.valueOf(base);
        }

        /**
         * <p>
         * Retrieve increased value as String expression.
         * </p>
         * 
         * @return A increased value.
         */
        public String increased() {
            return String.valueOf(increased);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return value();
        }
    }
}
