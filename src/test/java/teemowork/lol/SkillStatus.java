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

import js.lang.NativeArray;
import js.util.ArrayList;

/**
 * @version 2013/01/27 20:32:01
 */
public class SkillStatus {

    /** The value store. */
    private NativeArray<Double> values;

    /** The skill cost type. */
    private SkillCost cost;

    /** The toggle flag. */
    private boolean isToggle;

    /** The skill description. */
    public final List passive;

    /** The skill description. */
    public final List active;

    /**
     * @param name
     */
    SkillStatus(SkillStatus previous) {
        if (previous != null) {
            values = previous.values.copy();
            passive = previous.passive;
            active = previous.active;
            isToggle = previous.isToggle;
            cost = previous.cost;
        } else {
            values = new NativeArray();
            passive = new ArrayList();
            active = new ArrayList();
            isToggle = false;
            cost = SkillCost.Mana;
        }
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return A result.
     */
    public double get(Status status) {
        Double value = values.get(status.ordinal());

        return value == null ? 0 : value;
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return A result.
     */
    public double getPassive(Status status, int level) {
        for (Object token : passive) {
            if (token instanceof SkillVariable) {
                SkillVariable variable = (SkillVariable) token;

                if (variable.status == status) {
                    return variable.base * (level);
                }
            }
        }
        return 0;
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    SkillStatus set(Status status, double value) {
        values.set(status.ordinal(), value);

        return this;
    }

    /**
     * <p>
     * Set skill passive ability.
     * </p>
     */
    SkillStatus passive(String text) {
        // clear previous version
        this.passive.clear();

        String[] tokens = text.split("[\\{\\}]");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.length() != 1) {
                this.passive.add(token);
            } else {
                this.passive.add(new SkillVariable(Integer.parseInt(token)));
            }
        }
        return this;
    }

    /**
     * <p>
     * Describe this ability.
     * </p>
     * 
     * @param text
     * @return
     */
    SkillStatus active(String text) {
        // clear previous version
        this.active.clear();

        String[] tokens = text.split("[\\{\\}]");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.length() != 1) {
                this.active.add(token);
            } else {
                this.active.add(new SkillVariable(Integer.parseInt(token)));
            }
        }
        return this;
    }

    /**
     * <p>
     * Set variable with amplifiers.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @param ratioType First amplifier type.
     * @param ratio First amplifier ration.
     * @return A chainable API.
     */
    SkillStatus variable(int id, Status status, double base, double diff) {
        return variable(id, status, base, diff, null, 0);
    }

    /**
     * <p>
     * Set variable with amplifiers.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @param ratioType First amplifier type.
     * @param ratio First amplifier ration.
     * @return A chainable API.
     */
    SkillStatus variable(int id, Status status, double base, double diff, Status ratioType, double ratio) {
        return variable(id, status, base, diff, ratioType, ratio, null, 0);
    }

    /**
     * <p>
     * Set variable with amplifiers.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @param ratioType1 First amplifier type.
     * @param ratio1 First amplifier ration.
     * @param ratioType2 Second amplifier type.
     * @param ratio2 Second amplifier ration.
     * @return A chainable API.
     */
    SkillStatus variable(int id, Status status, double base, double diff, Status ratioType1, double ratio1, Status ratioType2, double ratio2) {
        List[] lists = {passive, active};

        for (List list : lists) {
            for (Object token : list) {
                if (token instanceof SkillVariable) {
                    SkillVariable variable = (SkillVariable) token;

                    if (variable.id == id) {
                        variable.status = status;
                        variable.base = base;
                        variable.diff = diff;

                        if (ratioType1 != null) {
                            variable.amplifiers.add(ratioType1);
                            variable.amplifierRatios.add(ratio1);
                        }

                        if (ratioType2 != null) {
                            variable.amplifiers.add(ratioType2);
                            variable.amplifierRatios.add(ratio2);
                        }
                    }
                }
            }
        }
        return this;
    }

    /**
     * <p>
     * Set cooldown time.
     * </p>
     * 
     * @param base A base time.
     * @param diff A diff time.
     */
    SkillStatus cd(double base) {
        return cd(base, 0);
    }

    /**
     * <p>
     * Set cooldown time.
     * </p>
     * 
     * @param base A base time.
     * @param diff A diff time.
     */
    SkillStatus cd(double base, double diff) {
        values.set(CD.ordinal(), base);
        values.set(CDPerLv.ordinal(), diff);

        return this;
    }

    /**
     * <p>
     * Set skill cost.
     * </p>
     * 
     * @param base A base cost.
     * @param diff A diff cost.
     */
    SkillStatus cost(double base) {
        return cost(SkillCost.Mana, base, 0);
    }

    /**
     * <p>
     * Set skill cost.
     * </p>
     * 
     * @param base A base cost.
     * @param diff A diff cost.
     */
    SkillStatus cost(double base, double diff) {
        return cost(SkillCost.Mana, base, diff);
    }

    /**
     * <p>
     * Set skill cost.
     * </p>
     * 
     * @param base A base cost.
     * @param diff A diff cost.
     */
    SkillStatus cost(SkillCost type, double base, double diff) {
        values.set(Cost.ordinal(), base);
        values.set(CostPerLv.ordinal(), diff);
        cost = type;

        return this;
    }

    /**
     * <p>
     * Retrieve skill cost type.
     * </p>
     * 
     * @return
     */
    public SkillCost getCostType() {
        return cost;
    }

    /**
     * <p>
     * Set skill range.
     * </p>
     * 
     * @param range
     */
    SkillStatus range(double range) {
        values.set(Range.ordinal(), range);

        return this;
    }

    /**
     * <p>
     * Retrieve this skill is toggle type or not.
     * </p>
     * 
     * @return A result.
     */
    public boolean isToggle() {
        return isToggle;
    }

    /**
     * <p>
     * Set this skill is togglable.
     * </p>
     * 
     * @return
     */
    SkillStatus toggle() {
        isToggle = true;

        return this;
    }
}
