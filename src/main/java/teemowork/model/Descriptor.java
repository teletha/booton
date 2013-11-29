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

import static js.lang.Global.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;
import teemowork.model.variable.VariableResolver.Diff;

/**
 * @version 2013/03/16 13:36:52
 */
public abstract class Descriptor<T extends Descriptor> {

    /** The target object to describe. */
    protected final Describable describable;

    /** The previous version. */
    private final Descriptor<T> previous;

    /** The ability description. */
    private List passive;

    /** The ability description. */
    private List active;

    /** The flag for initialization of variable pool. */
    private boolean initializable = true;

    /** The variable store. */
    private Map<String, Variable> variables;

    /**
     * <p>
     * Define descriptor.
     * </p>
     * 
     * @param previous
     */
    protected Descriptor(Describable describable, Descriptor<T> previous) {
        this.describable = describable;
        this.previous = previous;

        if (previous == null) {
            passive = new ArrayList();
            active = new ArrayList();
            variables = new HashMap();

            initializable = false;
        } else {
            passive = previous.passive;
            active = previous.active;
            variables = previous.variables;
        }
    }

    /**
     * <p>
     * Helper method to update.
     * </p>
     * 
     * @param version
     * @return
     */
    public T update(Version version) {
        return (T) describable.update(version);
    }

    /**
     * <p>
     * Retrieve passive text.
     * </p>
     * 
     * @return
     */
    public final List getPassive() {
        List tokens = new ArrayList();

        for (Object token : passive) {
            if (token instanceof VariableReference) {
                tokens.add(variables.get(token.toString()));
            } else {
                tokens.add(token);
            }
        }
        return tokens;
    }

    /**
     * <p>
     * Write passive ability.
     * </p>
     * 
     * @param text
     * @return
     */
    protected final T passive(String text) {
        passive = parse(text);

        // Chainable API
        return (T) this;
    }

    /**
     * <p>
     * Test descriptor type.
     * </p>
     * 
     * @return A result.
     */
    public final boolean isActive() {
        return active.size() != 0;
    }

    /**
     * <p>
     * Retrieve active text.
     * </p>
     * 
     * @return
     */
    public final List getActive() {
        List tokens = new ArrayList();

        for (Object token : active) {
            if (token instanceof VariableReference) {
                tokens.add(variables.get(token.toString()));
            } else {
                tokens.add(token);
            }
        }
        return tokens;
    }

    /**
     * <p>
     * Write active ability.
     * </p>
     * 
     * @param text
     * @return
     */
    protected final T active(String text) {
        active = parse(text);

        // Chainable API
        return (T) this;
    }

    /**
     * <p>
     * Parse skill text.
     * </p>
     * 
     * @param tokens A list of text tokens.
     * @param text A skill text.
     */
    private List parse(String text) {
        List tokens = new ArrayList();

        for (String token : text.split("[\\{\\}<>]")) {
            if (token.equals("br")) {
                tokens.add(document.createElement("br"));
            } else if (token.length() == 0 || !isDigit(token)) {
                tokens.add(token);
            } else {
                tokens.add(new VariableReference(token));
            }
        }
        return tokens;
    }

    /**
     * <p>
     * Helper method to check text type.
     * </p>
     * 
     * @param text
     * @return
     */
    private boolean isDigit(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
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
    protected final T variable(int id, Status status) {
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
    protected final T variable(int id, Status status, double base) {
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
    protected final T variable(int id, Status status, double base, double diff) {
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
    protected final T variable(int id, Status status, VariableResolver resolver) {
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
    protected final T variable(int id, Status status, double base, double diff, Variable amplifier) {
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
    protected final T variable(int id, Status status, double base, double diff, Variable first, Variable second) {
        return variable(id, status, new Diff(base, diff, describable.getMaxLevel()), first, second);
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
    protected final T variable(int id, Status status, VariableResolver resolver, Variable first, Variable second) {
        Variable variable = new Variable(status, resolver);
        variable.add(first);
        variable.add(second);

        if (id < 0) {
            id *= -1;
            variable.setConditional();
        }

        if (initializable) {
            initializable = false;
            variables = new HashMap();

            if (previous != null) {
                variables.putAll(previous.variables);
            }
        }
        variables.put(String.valueOf(id), variable);

        return (T) this;
    }

    /**
     * @version 2013/03/16 13:53:03
     */
    private static class VariableReference {

        /** The variable name. */
        private final String name;

        /**
         * @param name
         */
        private VariableReference(String name) {
            this.name = name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return name;
        }
    }
}
