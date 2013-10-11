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
import jsx.Publishable;

/**
 * @version 2013/03/15 16:51:59
 */
public class MasterySet extends Publishable {

    /** The human-readable name. */
    private String name = "";

    /** The values for each masteries. */
    private int[] levels = new int[56];

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
    public MasterySet() {
        this(null);
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

        for (Mastery mastery : Mastery.VALUES) {
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
        case Mastery.Offense:
            return offense;

        case Mastery.Defense:
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

        if (mastery.type == Mastery.Offense) {
            if (offense < mastery.requirement) {
                return false;
            }

            if (mastery == WeaponExpertise && !isMax(Deadliness)) {
                return false;
            }

            if (mastery == ArcaneKnowledge && !isMax(Blast)) {
                return false;
            }

            if (mastery == Frenzy && !isMax(Lethality)) {
                return false;
            }
        } else if (mastery.type == Mastery.Defense) {
            if (defense < mastery.requirement) {
                return false;
            }

            if (mastery == VeteransScar && !isMax(Durability)) {
                return false;
            }

            if (mastery == Block && !isMax(Unyielding)) {
                return false;
            }
        } else if (mastery.type == Mastery.Utility) {
            if (utility < mastery.requirement) {
                return false;
            }

            if (mastery == Wealth && !isMax(Greed)) {
                return false;
            }

            if (mastery == Explorer && !isMax(Biscuiteer)) {
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
        if (mastery.type == Mastery.Offense) {
            if (unsafe(offenses, mastery)) {
                return false;
            }

            if (mastery == Deadliness && levels[WeaponExpertise.id] != 0) {
                return false;
            }

            if (mastery == Blast && levels[ArcaneKnowledge.id] != 0) {
                return false;
            }

            if (mastery == Lethality && levels[Frenzy.id] != 0) {
                return false;
            }
        } else if (mastery.type == Mastery.Defense) {
            if (unsafe(defenses, mastery)) {
                return false;
            }

            if (mastery == Durability && levels[VeteransScar.id] != 0) {
                return false;
            }

            if (mastery == Unyielding && levels[Block.id] != 0) {
                return false;
            }
        } else if (mastery.type == Mastery.Utility) {
            if (unsafe(utilities, mastery)) {
                return false;
            }

            if (mastery == Greed && levels[Wealth.id] != 0) {
                return false;
            }

            if (mastery == Biscuiteer && levels[Explorer.id] != 0) {
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
    private String encode(int level, int binarySize, int maxSize) {
        int step = 0;
        int value = 0;

        for (Mastery mastery : Mastery.VALUES) {
            if (mastery.getMaxLevel() == level) {
                value |= levels[mastery.id] << step;

                // step into next mastery
                step += binarySize;
            }
        }

        // serialization and zero padding
        String serialized = Integer.toString(value, 36);

        for (int i = serialized.length(); i < maxSize; i++) {
            serialized = "0" + serialized;
        }
        return serialized;
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
    private void decode(int level, int binarySize, String serialized) {
        int step = 0;
        int value = Integer.parseInt(serialized, 36);

        for (Mastery mastery : Mastery.VALUES) {
            if (mastery.getMaxLevel() == level) {
                int mask = (int) Math.pow(2, binarySize) - 1 << step;

                changeLevel(mastery, (value & mask) >> step);

                // step into next mastery
                step += binarySize;
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
        return encode(1, 1, 5) + encode(2, 2, 3) + encode(3, 2, 6) + encode(4, 3, 5);
    }

    /**
     * @return
     */
    public String getCode() {
        return encode(1, 1, 5) + encode(2, 2, 3) + encode(3, 2, 6) + encode(4, 3, 5);
    }

    /**
     * <p>
     * Set code.
     * </p>
     * 
     * @param serialized
     */
    public void setCode(String serialized) {
        if (serialized != null && serialized.length() == 19) {
            reset();

            decode(1, 1, serialized.substring(0, 5));
            decode(2, 2, serialized.substring(5, 8));
            decode(3, 2, serialized.substring(8, 14));
            decode(4, 3, serialized.substring(14, 19));

            publish(this);
        }
    }
}
