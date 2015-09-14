/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import javafx.beans.value.ObservableBooleanValue;

/**
 * @version 2015/09/14 17:04:11
 */
class ConditionalDeclarable implements Declarable {

    /** The declaration. */
    final Declarable declarable;

    /** The condition. */
    private final ObservableBooleanValue condition;

    /**
     * @param declarable
     * @param condition
     */
    ConditionalDeclarable(Declarable declarable, ObservableBooleanValue condition) {
        this.declarable = declarable;
        this.condition = condition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        if (condition.get()) {
            declarable.declare();
        }
    }
}
