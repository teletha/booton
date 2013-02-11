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

    /** The skill description. */
    private List tokens;

    /**
     * @param name
     */
    SkillStatus(SkillStatus previous) {
        if (previous != null) {
            values = previous.values.copy();
            tokens = previous.tokens;
        } else {
            values = new NativeArray();
            tokens = new ArrayList();
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
     * @return Chainable API.
     */
    SkillStatus set(Status status, double value) {
        values.set(status.ordinal(), value);

        return this;
    }

    /**
     * <p>
     * Retrieve description tokens.
     * </p>
     * 
     * @return
     */
    public List getDescriptionTokens() {
        return tokens;
    }

    /**
     * <p>
     * Retrieve description.
     * </p>
     * 
     * @return
     */
    public String getDescription() {
        String text = "";

        for (Object token : tokens) {
            text += token;
        }
        return text;
    }

    /**
     * <p>
     * Describe this ability.
     * </p>
     * 
     * @param text
     * @return
     */
    SkillStatus description(String text) {
        // clear previous version
        this.tokens.clear();

        String[] tokens = text.split("[\\{\\}]");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.length() != 1) {
                this.tokens.add(token);
            } else {
                this.tokens.add(new SkillVariable(Integer.parseInt(token)));
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
        for (Object token : tokens) {
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
        values.set(CostType.ordinal(), (double) type.ordinal());

        return this;
    }
}
