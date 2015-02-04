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

import javafx.beans.property.Property;

import js.lang.NativeArray;
import jsx.collection.DualList;

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
     * If the specified condition is true, compose this style and the specified style.
     * </p>
     * 
     * @param condition A condition.
     * @param other An other style to compose.
     * @return A composed style.
     */
    public default Style withIf(boolean condition, Style other) {
        return condition ? with(other) : this;
    }

    /**
     * <p>
     * If the specified condition is true, compose this style and the specified style.
     * </p>
     * 
     * @param condition A condition.
     * @param other An other style to compose.
     * @return A composed style.
     */
    public default Style withIf(Property<Boolean> condition, Style other) {
        Boolean state = condition.getValue();

        if (state == null) {
            return this;
        }
        return withIf(state.booleanValue(), other);
    }
}
