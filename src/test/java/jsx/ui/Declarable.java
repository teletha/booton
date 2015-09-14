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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

import kiss.Events;

/**
 * @version 2015/09/14 17:03:51
 */
public interface Declarable {

    void declare();

    /**
     * <p>
     * Return the conditional {@link Declarable} which is applied only when the specified condition
     * is true.
     * </p>
     * 
     * @param condition A condition.
     * @return A conditional {@link Declarable}.
     */
    public default Declarable when(boolean condition) {
        return when(new SimpleBooleanProperty(condition));
    }

    /**
     * <p>
     * Return the conditional {@link Declarable} which is applied only when the specified condition
     * is true.
     * </p>
     * 
     * @param condition A condition.
     * @return A conditional {@link Declarable}.
     */
    public default Declarable when(Events<Boolean> condition) {
        BooleanProperty property = new SimpleBooleanProperty();
        condition.to(property::setValue);
        return when(property);
    }

    /**
     * <p>
     * Return the conditional {@link Declarable} which is applied only when the specified condition
     * is true.
     * </p>
     * 
     * @param condition A condition.
     * @return A conditional {@link Declarable}.
     */
    public default Declarable when(ObservableBooleanValue condition) {
        return new ConditionalDeclarable(this, condition);
    }
}
