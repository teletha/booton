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

import js.bind.Subscriber;
import js.math.Mathematics;
import js.util.jQuery;
import teemowork.model.DescriptionViewStyle.Amplifier;
import teemowork.model.DescriptionViewStyle.ComputedValue;
import teemowork.model.DescriptionViewStyle.Current;
import teemowork.model.DescriptionViewStyle.Passive;
import teemowork.model.DescriptionViewStyle.Separator;
import teemowork.model.DescriptionViewStyle.Value;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2013/03/23 12:41:01
 */
public abstract class DescriptionView implements Subscriber {

    /** The passive element. */
    private final jQuery description;

    /** The target descriptor to view. */
    private final Describable describable;

    /** The target type. */
    private final boolean forPassive;

    /**
     * <p>
     * Create view for {@link Describable}.
     * </p>
     * 
     * @param root
     */
    public DescriptionView(jQuery root, Describable describable, boolean forPassive) {
        this.description = root.child(Passive.class);
        this.describable = describable;
        this.forPassive = forPassive;
    }

    /**
     * <p>
     * Specify the current level of descriptor.
     * </p>
     * 
     * @return
     */
    protected abstract int getLevel();

    /**
     * <p>
     * Specify the current version of descriptor.
     * </p>
     * 
     * @return
     */
    protected abstract Version getVersion();

    /**
     * {@inheritDoc}
     */
    @Override
    public final void receive() {
        description.empty();

        Descriptor descriptor = describable.getDescriptor(getVersion());
        List tokens = forPassive ? descriptor.getPassive() : descriptor.getActive();

        if (!tokens.isEmpty()) {
            for (Object token : tokens) {
                if (token instanceof Variable) {
                    writeVariable(description, (Variable) token, getLevel());
                } else {
                    description.append(token.toString());
                }
            }
        }
    }

    /**
     * <p>
     * Helper method to write variable.
     * </p>
     * 
     * @param root
     * @param variable
     * @param level
     */
    private void writeVariable(jQuery root, Variable variable, int level) {
        VariableResolver resolver = variable.getResolver();
        Status status = variable.getStatus();
        List<Variable> amplifiers = variable.getAmplifiers();

        // compute current value
        root.child(ComputedValue.class).text(status.format(variable.calculate(Math.max(1, level))));

        // All values
        int size = resolver.estimateSize();

        if (1 < size || !amplifiers.isEmpty()) {
            root.append("(");

            for (int i = 1; i <= size; i++) {
                jQuery element = root.child(Value.class).text(Mathematics.round(resolver.compute(i), 2));

                if (i == level) {
                    element.add(Current.class);
                }

                if (i != size) {
                    root.child(Separator.class).text("/");
                }
            }

            writeAmplifier(root, amplifiers, level);
            root.append(")");
        }
    }

    /**
     * <p>
     * Helper method to write variable as amplifier.
     * </p>
     * 
     * @param root A element to write.
     * @param amplifiers A list of variable amplifiers.
     * @param level A current variable level.
     */
    private void writeAmplifier(jQuery root, List<Variable> amplifiers, int level) {
        for (Variable amplifier : amplifiers) {
            jQuery element = root.child(Amplifier.class);
            element.append("+");

            int size = amplifier.getResolver().estimateSize();

            for (int i = 1; i <= size; i++) {
                jQuery value = element.child(Value.class).text(Mathematics.round(amplifier.calculate(i), 4));

                if (size != 1 && i == level) {
                    value.add(Current.class);
                }

                if (i != size) {
                    element.child(Separator.class).text("/");
                }
            }

            element.append(amplifier.getStatus().getUnit());
            if (!amplifier.getAmplifiers().isEmpty()) {
                element.append("(");
                writeAmplifier(element, amplifier.getAmplifiers(), level);
                element.append(")");
            }
            element.append(amplifier.getStatus().name);
        }
    }
}
