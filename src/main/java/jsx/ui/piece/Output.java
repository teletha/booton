/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import java.util.function.Function;

import javafx.beans.binding.IntegerExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure.ContainerDescriptor;
import kiss.I;

/**
 * @version 2014/08/22 11:27:22
 */
public class Output extends LowLevelWidget<Output> {

    /** The text contents. */
    public final StringProperty text;

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public Output(IntegerExpression value) {
        this(value, v -> String.valueOf(v));
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public Output(IntegerExpression value, Function<Integer, String> converter) {
        this.text = new SimpleStringProperty(converter.apply(value.getValue()));

        I.observe(value).as(Integer.class).map(converter).to(v -> text.set(v));
    }

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    Output(StringProperty text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String virtualizeName() {
        return "div";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeStructure(ContainerDescriptor descriptor) {
        descriptor.〡$(text.get());
    }

}
