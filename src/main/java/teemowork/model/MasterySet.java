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
import js.bind.Notifiable;

/**
 * @version 2013/03/13 17:07:25
 */
public class MasterySet extends Notifiable {

    private int[] levels = new int[56];

    private int[] offenses = new int[7];

    private int[] defenses = new int[7];

    private int[] utilities = new int[7];

    private int offense = 0;

    private int defense = 0;

    private int utility = 0;

    /**
     * <p>
     * Level up the specified mastery.
     * </p>
     * 
     * @param mastery
     */
    public void up(Mastery mastery) {
        if (isAvailable(mastery)) {
            int current = levels[mastery.id];

            if (current < mastery.level) {
                levels[mastery.id] = current + 1;

                switch (mastery.type) {
                case Mastery.Offense:
                    offense++;
                    offenses[mastery.rank] = offenses[mastery.rank] + 1;
                    break;

                case Mastery.Defense:
                    defense++;
                    defenses[mastery.rank] = defenses[mastery.rank] + 1;
                    break;

                default:
                    utility++;
                    utilities[mastery.rank] = utilities[mastery.rank] + 1;
                    break;
                }

                fire();
            }
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
        if (isUnavailable(mastery)) {
            int current = levels[mastery.id];

            if (0 < current) {
                levels[mastery.id] = current - 1;

                switch (mastery.type) {
                case Mastery.Offense:
                    offense--;
                    offenses[mastery.rank] = offenses[mastery.rank] - 1;
                    break;

                case Mastery.Defense:
                    defense--;
                    defenses[mastery.rank] = defenses[mastery.rank] - 1;
                    break;

                default:
                    utility--;
                    utilities[mastery.rank] = utilities[mastery.rank] - 1;
                    break;
                }

                fire();
            }
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
        return levels[mastery.id] == mastery.level;
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

    public String encode() {
        String value = "";

        for (int i = 0; i < levels.length; i++) {
            value += levels[i];
        }
        return value;
    }

    /**
     * <p>
     * </p>
     * 
     * @param text
     */
    public void decode(String text) {
        for (int i = 0; i < text.length(); i++) {
            int level = Integer.parseInt(String.valueOf(text.charAt(i)));

            for (int j = 0; j < level; j++) {
                up(Mastery.get(i));
            }
        }
    }
}
