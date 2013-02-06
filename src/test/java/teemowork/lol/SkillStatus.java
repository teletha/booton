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

        String[] tokens = text.split("\\$");

        for (int i = 0; i < tokens.length; i++) {
            if (i == 0) {
                this.tokens.add(tokens[0]);
            } else {
                this.tokens.add(new SkillVariable(Integer.parseInt(tokens[i].substring(0, 1))));
                this.tokens.add(tokens[i].substring(1));
            }
        }
        return this;
    }

    /**
     * <p>
     * Set variable.
     * </p>
     * 
     * @param id
     * @param status
     * @param base
     * @param diff
     * @return
     */
    SkillStatus variable(int id, Status status, double base, double diff) {
        for (Object token : tokens) {
            if (token instanceof SkillVariable) {
                SkillVariable variable = (SkillVariable) token;

                if (variable.id == id) {
                    variable.setStatus(status);
                    variable.setBase(base);
                    variable.setDiff(diff);
                }
            }
        }
        return this;
    }

    /**
     * <p>
     * Set damage variable.
     * </p>
     * 
     * @param id
     * @param type
     * @param base
     * @param diff
     * @param ratioType
     * @param ratio
     * @return
     */
    SkillStatus damage(int id, Status type, int base, int diff, Status ratioType, double ratio) {
        for (Object token : tokens) {
            if (token instanceof SkillVariable) {
                SkillVariable variable = (SkillVariable) token;

                if (variable.id == id) {
                    variable.setStatus(type);
                    variable.setBase(base);
                    variable.setDiff(diff);
                    variable.setRatioType(ratioType);
                    variable.setRatio(ratio);
                }
            }
        }
        return this;
    }
}
