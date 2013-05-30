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
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;
import teemowork.model.variable.VariableResolver.Diff;

/**
 * @version 2013/05/30 20:35:46
 */
public abstract class Describable<T extends Descriptor> {

    /** The current processing object. */
    private static Describable current;

    /** The version manager. */
    private final Descriptor[] versions = new Descriptor[Version.values().length];

    /**
     * <p>
     * Retrieve the maximum level of this object.
     * </p>
     * 
     * @return The maximum level.
     */
    public abstract int getMaxLevel();

    /**
     * <p>
     * Create new descriptor.
     * </p>
     * 
     * @param previous
     * @return
     */
    protected abstract T createDescriptor(T previous);

    /**
     * <p>
     * Retrieve a descriptor of the specified version.
     * </p>
     */
    public final T getDescriptor(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            Descriptor descriptor = versions[i];

            if (descriptor != null) {
                return (T) descriptor;
            }
        }
        return createDescriptor(null);
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @return A oldest descriptor.
     */
    protected final T update() {
        return update(Version.P0000);
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @return A descriptor of the specified version.
     */
    protected final T update(Version version) {
        T descriptor = createDescriptor(getDescriptor(version));

        // versioning management
        versions[version.ordinal()] = descriptor;

        // for helper methods
        current = this;

        // API definition
        return descriptor;
    }

    /**
     * <p>
     * Create skill AP amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AP rate.
     * @return
     */
    protected static final Variable ap(double rate) {
        return amplify(AP, rate);
    }

    /**
     * <p>
     * Create skill AD amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AD rate.
     * @return
     */
    protected static final Variable ad(double rate) {
        return amplify(AD, rate);
    }

    /**
     * <p>
     * Create skill AD amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AD rate.
     * @return
     */
    protected static final Variable bounusAD(double rate) {
        return amplify(BounusAD, rate);
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base) {
        return amplify(status, base, 0);
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base, double diff) {
        return amplify(status, new Diff(base, diff, current.getMaxLevel()));
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, VariableResolver resolver) {
        return new Variable(status, resolver);
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base, double diff, Variable amplifier) {
        return amplify(status, base, diff, amplifier, null);
    }

    /**
     * <p>
     * Helper method to create nre amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    protected static final Variable amplify(Status status, double base, double diff, Variable first, Variable second) {
        Variable variable = amplify(status, base, diff);
        variable.add(first);
        variable.add(second);

        return variable;
    }
}
