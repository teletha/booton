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
 * @version 2013/03/16 23:49:50
 */
public class DescriptionView implements Subscriber {

    /** The target descriptor to view. */
    private final Descriptor descriptor;

    /** The root element. */
    private final jQuery root;

    /** The passive element. */
    private final jQuery passiveDescription;

    /**
     * <p>
     * Create view for {@link Descriptor}.
     * </p>
     * 
     * @param root
     */
    public DescriptionView(Descriptor descriptor, jQuery root) {
        this.descriptor = descriptor;
        this.root = root;
        this.passiveDescription = root.child(Passive.class);
    }

    protected int getCurrentLevel() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receive() {
        passiveDescription.empty();

        List passive = descriptor.getPassive();

        if (!passive.isEmpty()) {
            for (Object token : passive) {
                if (token instanceof Variable) {
                    writeVariable(passiveDescription, (Variable) token, getCurrentLevel());
                } else {
                    passiveDescription.append(token.toString());
                }
            }
        }
    }

    /**
     * <p>
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
                    element.addClass(Current.class);
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
     * Write skill amplifier.
     * </p>
     * 
     * @param root A element to write.
     * @param amplifiers A list of skill amplifiers.
     * @param level A current skill level.
     */
    private void writeAmplifier(jQuery root, List<Variable> amplifiers, int level) {
        for (Variable amplifier : amplifiers) {
            jQuery element = root.child(Amplifier.class);
            element.append("+");

            int size = amplifier.getResolver().estimateSize();

            for (int i = 1; i <= size; i++) {
                jQuery value = element.child(Value.class).text(Mathematics.round(amplifier.calculate(i), 4));

                if (size != 1 && i == level) {
                    value.addClass(Current.class);
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
