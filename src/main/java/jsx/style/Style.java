/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

import js.lang.NativeArray;
import jsx.collection.DualList;
import kiss.Events;

/**
 * @version 2015/01/29 10:00:25
 */
public interface Style {

    /**
     * <p>
     * Declare styles.
     * </p>
     */
    void declare();

    public default Object locator() {
        return this;
    }

    /**
     * <p>
     * Compute style class name.
     * </p>
     * 
     * @return A style class name.
     */
    public default String className() {
        return "STYLE" + hashCode();
    }

    public default void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        StyleRule style = new StyleRule(inlines);

        // swap context rule and execute it
        PropertyDefinition.declarable = style;
        declare();
        PropertyDefinition.declarable = null;
    }

    /**
     * <p>
     * Compose this style and the specified style.
     * </p>
     * 
     * @param other An other style to compose.
     * @return A composed style.
     */
    public default Style with(Style other) {
        return new MultipleStyle(this, other);
    }

    /**
     * <p>
     * Return the conditional style which is applied only when the specified condition is true.
     * </p>
     * 
     * @param condition A condition.
     * @return A conditional {@link Style}.
     */
    public default Style when(boolean condition) {
        return when(new SimpleBooleanProperty(condition));
    }

    /**
     * <p>
     * Return the conditional style which is applied only when the specified condition is true.
     * </p>
     * 
     * @param condition A condition.
     * @return A conditional {@link Style}.
     */
    public default Style when(Events<Boolean> condition) {
        BooleanProperty property = new SimpleBooleanProperty();
        condition.to(property::setValue);
        return when(property);
    }

    /**
     * <p>
     * Return the conditional style which is applied only when the specified condition is true.
     * </p>
     * 
     * @param condition A condition.
     * @return A conditional {@link Style}.
     */
    public default Style when(ObservableBooleanValue condition) {
        return new ConditionalStyle(this, condition);
    }
}
