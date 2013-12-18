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

import static teemowork.model.Mastery.*;
import jsx.event.Publishable;

/**
 * @version 2013/03/15 16:51:59
 */
public class MasterySet extends Publishable {

    /** The human-readable name. */
    private String name = "";

    /** The values for each masteries. */
    private int[] levels = new int[60];

    /** The categorized sum of offense tree. */
    private int[] offenses = new int[7];

    /** The categorized sum of defense tree. */
    private int[] defenses = new int[7];

    /** The categorized sum of utility tree. */
    private int[] utilities = new int[7];

    /** The sum of offense tree. */
    private int offense = 0;

    /** The sum of defense tree. */
    private int defense = 0;

    /** The sum of utility tree. */
    private int utility = 0;

    /**
     * <p>
     * Create new empty {@link MasterySet}.
     * </p>
     */
    public MasterySet(Version version) {
        this((String) null);
    }

    /**
     * <p>
     * Build {@link MasterySet} by the specified text expression.
     * </p>
     * 
     * @param serialized A serialized text expression.
     */
    public MasterySet(String serialized) {
        setCode(serialized);
    }

    /**
     * Get the name property of this {@link MasterySet}.
     * 
     * @return The name property.
     */
    public String getName() {
        return name.length() == 0 ? getCode() : name;
    }

    /**
     * Set the name property of this {@link MasterySet}.
     * 
     * @param name The name value to set.
     */
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    /**
     * <p>
     * Level up the specified mastery.
     * </p>
     * 
     * @param mastery
     */
    public void up(Mastery mastery) {
        if (isAvailable(mastery) && changeLevel(mastery, 1)) {
            publish(this);
        }
    }

    /**
     * <p>
     * Level up the specified mastery.
     * </p>
     * 
     * @param mastery
     */
    public void down(Mastery mastery) {
        if (isUnavailable(mastery) && changeLevel(mastery, -1)) {
            publish(this);
        }
    }

    /**
     * <p>
     * Reset all points.
     * </p>
     */
    public void reset() {
        boolean changed = false;

        for (Mastery mastery : Mastery.getMastery(Version.Latest)) {
            if (changeLevel(mastery, -4)) {
                changed = true;
            }
        }

        if (changed) {
            publish(this);
        }
    }

    /**
     * <p>
     * Retrieve the specified mastery level.
     * </p>
     * 
     * @param mastery A target mastery.
     * @return A level.
     */
    public int getLevel(Mastery mastery) {
        return levels[mastery.id];
    }

    /**
     * <p>
     * Sum points in all trees.
     * </p>
     * 
     * @return A result.
     */
    public int getSum() {
        return offense + defense + utility;
    }

    /**
     * <p>
     * Sum points in the specified tree.
     * </p>
     * 
     * @param type A tree type.
     * @return A result.
     */
    public int getSum(int type) {
        switch (type) {
        case MasterySeason3.Offense:
            return offense;

        case MasterySeason3.Defense:
            return defense;

        default:
            return utility;
        }
    }

    /**
     * <p>
     * Test requirements.
     * </p>
     * 
     * @param mastery A target.
     * @return A result.
     */
    public boolean isAvailable(Mastery mastery) {
        if (offense + defense + utility == 30) {
            return false;
        }

        if (mastery.dependency != null && !isMax(mastery.dependency)) {
            return false;
        }

        if (mastery.type == Mastery.Offense) {
            if (offense < mastery.requirement) {
                return false;
            }
        } else if (mastery.type == Mastery.Defense) {
            if (defense < mastery.requirement) {
                return false;
            }
        } else if (mastery.type == Mastery.Utility) {
            if (utility < mastery.requirement) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Helper method to test level.
     * </p>
     * 
     * @param mastery
     * @return
     */
    public boolean isMax(Mastery mastery) {
        return levels[mastery.id] == mastery.getMaxLevel();
    }

    /**
     * <p>
     * Test un-requirements.
     * </p>
     * 
     * @param mastery A target.
     * @return A result.
     */
    private boolean isUnavailable(Mastery mastery) {
        if (mastery.dependedBy != null && levels[mastery.dependedBy.id] != 0) {
            return false;
        }

        if (mastery.type == Mastery.Offense) {
            if (unsafe(offenses, mastery)) {
                return false;
            }
        } else if (mastery.type == Mastery.Defense) {
            if (unsafe(defenses, mastery)) {
                return false;
            }
        } else if (mastery.type == Mastery.Utility) {
            if (unsafe(utilities, mastery)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Helper method to test level.
     * </p>
     * 
     * @param values
     * @param mastery
     * @return
     */
    private boolean unsafe(int[] values, Mastery mastery) {
        for (int i = values.length - 1; mastery.rank < i; i--) {
            if (values[i] != 0) {
                int sum = 0;

                for (int j = 0; j < i; j++) {
                    sum += values[j];
                }

                if (sum <= i * 4) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * <p>
     * Encode as text expression.
     * </p>
     * 
     * @param level A target level.
     * @param binarySize A minimum requirement size for each value.
     * @param maxSize A maximum requirement size for calculated value.
     * @return A serialized text.
     */
    private String encode() {
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < levels.length; i = i + 5) {
            StringBuilder builder = new StringBuilder();

            for (int j = 0; j < 5; j++) {
                builder.append(levels[i + j]);
            }

            String value = Integer.toString(Integer.valueOf(builder.toString()), 36);

            for (int j = value.length(); j < 3; j++) {
                value = "0" + value;
            }
            encoded.append(value);
        }
        return encoded.toString();
    }

    /**
     * <p>
     * Decode text expression.
     * </p>
     * 
     * @param level A target level.
     * @param binarySize A minimum requirement size for each value.
     * @param serialized A text expression.
     */
    private void decode(String serialized) {
        Mastery[] masteries = Mastery.getMastery(Version.Latest);

        for (int i = 0; i < serialized.length(); i = i + 3) {
            String value = String.valueOf(Integer.parseInt(serialized.substring(i, i + 3), 36));

            for (int j = value.length(); j < 5; j++) {
                value = "0" + value;
            }

            for (int j = 0; j < value.length(); j++) {
                Mastery mastery = masteries[i / 3 * 5 + j];

                if (mastery != null) {
                    changeLevel(mastery, Integer.valueOf(value.charAt(j)));
                }
            }
        }
    }

    /**
     * <p>
     * Helper method to compute mastery level.
     * </p>
     * 
     * @param mastery A target mastery to change level.
     * @param value A difference. (accept negative value)
     * @return true if the mastery level is changed.
     */
    private boolean changeLevel(Mastery mastery, int value) {
        int rank = mastery.rank;
        int current = levels[mastery.id];

        // validate value range
        if (current + value < 0) {
            value = -current;
        } else if (mastery.getMaxLevel() < current + value) {
            value = mastery.getMaxLevel() - current;
        }

        if (value == 0) {
            return false;
        }

        // assign value
        levels[mastery.id] = current + value;

        switch (mastery.type) {
        case Offense:
            offense += value;
            offenses[rank] = offenses[rank] + value;
            break;

        case Defense:
            defense += value;
            defenses[rank] = defenses[rank] + value;
            break;

        default:
            utility += value;
            utilities[rank] = utilities[rank] + value;
            break;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MasterySet) {
            MasterySet other = (MasterySet) obj;

            return name.equals(other.name);
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return encode();
    }

    /**
     * @return
     */
    public String getCode() {
        return encode();
    }

    /**
     * <p>
     * Set code.
     * </p>
     * 
     * @param serialized
     */
    public void setCode(String serialized) {
        if (serialized != null) {
            reset();
            decode(serialized);
            publish(this);
        }
    }
}
