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

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/03/16 13:36:52
 */
public abstract class Descriptor<T extends Descriptor> {

    /** The ability description. */
    private List passive;

    /** The ability description. */
    private List active;

    /**
     * <p>
     * Define descriptor.
     * </p>
     * 
     * @param previous
     */
    protected Descriptor(Descriptor<T> previous) {
        if (previous == null) {
            passive = new ArrayList();
            active = new ArrayList();
        } else {
            passive = previous.passive;
            active = previous.active;
        }
    }

    /**
     * <p>
     * Write passive ability.
     * </p>
     * 
     * @param text
     * @return
     */
    protected T passive(String text) {

        // Chainable API
        return (T) this;
    }

    /**
     * <p>
     * Write active ability.
     * </p>
     * 
     * @param text
     * @return
     */
    protected T active(String text) {

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

        for (String token : text.split("[\\{\\}]")) {
            if (token.length() != 1 || !Character.isDigit(token.charAt(0))) {
                tokens.add(token);
            } else {
                tokens.add(new VariableReference(token));
            }
        }
        return tokens;
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
