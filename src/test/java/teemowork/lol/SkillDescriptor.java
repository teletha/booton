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

import java.util.Map;
import java.util.Map.Entry;

import js.lang.NativeArray;
import js.util.HashMap;

/**
 * @version 2013/01/27 20:32:01
 */
public class SkillDescriptor {

    /** The value store. */
    private NativeArray<Double> values;

    private String description;

    private Map<Integer, Variable> variables;

    /**
     * @param name
     */
    SkillDescriptor(SkillDescriptor previous) {
        if (previous != null) {
            values = previous.values.copy();
            description = previous.description;
            variables = previous.variables;
        } else {
            values = new NativeArray();
            description = "";
            variables = new HashMap();
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
    public SkillDescriptor set(Status status, double value) {
        values.set(status.ordinal(), value);

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
    public SkillDescriptor damage(int id, Damage type, int base, int diff, Status ratioType, double ratio) {
        variables.put(id, new Variable(type, base, diff, ratioType, ratio));

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
    public SkillDescriptor text(String text) {
        this.description = text;

        return this;
    }

    /**
     * <p>
     * Retrieve description.
     * </p>
     * 
     * @return
     */
    public String getText() {
        String text = description;

        for (Entry<Integer, Variable> entry : variables.entrySet()) {
            text = text.replace("\\\\$" + entry.getKey(), entry.getValue().toString());
        }

        return text;
    }

    /**
     * @version 2013/02/02 23:04:44
     */
    private static class Variable {

        private Damage type;

        private int base;

        private int diff;

        private Status ratioType;

        private double ratio;

        /**
         * @param type
         * @param base
         * @param diff
         * @param ratioType
         * @param ratio
         */
        private Variable(Damage type, int base, int diff, Status ratioType, double ratio) {
            this.type = type;
            this.base = base;
            this.diff = diff;
            this.ratioType = ratioType;
            this.ratio = ratio;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {

            return type + " " + "";
        }
    }
}
