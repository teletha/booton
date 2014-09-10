/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import javafx.beans.value.ObservableValue;

import kiss.Events;
import booton.virtual.VirtualStructure;

/**
 * @version 2014/08/22 11:27:22
 */
public class Output<V> extends UI {

    protected Events<V> value;

    public Output(ObservableValue<V> value) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure box) {
    }
}
