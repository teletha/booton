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

import static teemowork.model.Status.*;

import java.util.List;
import java.util.Map;

import js.lang.NativeArray;
import js.util.ArrayList;
import js.util.HashMap;
import teemowork.model.VariableResolver.Diff;

/**
 * @version 2013/01/29 1:55:25
 */
public class ItemStatus {

    /** The value store. */
    private NativeArray<Double> values;

    /** The variable store. */
    private NativeArray<Variable> variables;

    /** The item build. */
    Item[] build;

    public Map<String, List> passives;

    /**
     * @param name
     */
    ItemStatus(ItemStatus previous) {
        if (previous != null) {
            values = previous.values.copy();
            variables = previous.variables;
            build = previous.build;
            passives = previous.passives;
        } else {
            values = new NativeArray();
            variables = new NativeArray();
            build = new Item[0];
            passives = new HashMap();
        }
    }

    /**
     * <p>
     * Set skill passive ability.
     * </p>
     */
    ItemStatus passive(String name, String text) {
        List tokens = new ArrayList();

        for (String token : text.split("[\\{\\}]")) {
            if (token.length() != 1 || !Character.isDigit(token.charAt(0))) {
                tokens.add(token);
            } else {
                int id = Integer.parseInt(token);
                Variable variable = variables.get(id);

                if (variable == null) {
                    variable = new Variable();
                    variables.set(id, variable);
                }
                tokens.add(variable);
            }
        }
        passives.put(name, tokens);

        return this;
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @return A chainable API.
     */
    ItemStatus variable(int id, Status status) {
        return variable(id, status, 0);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @return A chainable API.
     */
    ItemStatus variable(int id, Status status, double base) {
        return variable(id, status, base, 0);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @return A chainable API.
     */
    ItemStatus variable(int id, Status status, double base, double diff) {
        return variable(id, status, base, diff, null, null);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param resolver A resolver.
     * @return Chainable API.
     */
    ItemStatus variable(int id, Status status, VariableResolver resolver) {
        return variable(id, status, resolver, null, null);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @param amplifier A first amplifier.
     * @return Chainable API.
     */
    ItemStatus variable(int id, Status status, double base, double diff, Variable amplifier) {
        return variable(id, status, base, diff, amplifier, null);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param base A base value.
     * @param diff A diff value.
     * @param first A first amplifier.
     * @param second A second amplifier.
     * @return Chainable API.
     */
    ItemStatus variable(int id, Status status, double base, double diff, Variable first, Variable second) {
        return variable(id, status, new Diff(base, diff, 0), first, second);
    }

    /**
     * <p>
     * Set new variable.
     * </p>
     * 
     * @param id A variable identifier.
     * @param status A variable type.
     * @param resolver A resolver.
     * @param first A first amplifier.
     * @param second A second amplifier.
     * @return Chainable API.
     */
    ItemStatus variable(int id, Status status, VariableResolver resolver, Variable first, Variable second) {
        Variable variable = variables.get(id);
        variable.setStatus(status);
        variable.setResolver(resolver);

        if (first != null) {
            variable.amplifiers.add(first);
        }

        if (second != null) {
            variable.amplifiers.add(second);
        }
        return this;
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
    ItemStatus set(Status status, double value) {
        values.set(status.ordinal(), value);

        return this;
    }

    /**
     * <p>
     * Retrieve status value.
     * </p>
     * 
     * @param status A target status.
     * @return Chainable API.
     */
    ItemStatus cost(double base) {
        set(Cost, base);

        return this;
    }

    /**
     * <p>
     * Set build items.
     * </p>
     * 
     * @param items
     * @return
     */
    ItemStatus build(Item... items) {
        this.build = items;

        return this;
    }
}
