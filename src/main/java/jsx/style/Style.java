/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import java.util.Optional;

import js.dom.Element;
import js.lang.NativeArray;
import jsx.collection.DualList;

/**
 * @version 2014/10/24 13:58:41
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
     * Compute internal class name.
     * </p>
     * 
     * @return
     */
    public default String id() {
        return "STYLE" + hashCode();
    }

    /**
     * <p>
     * Apply this style to the specified element.
     * </p>
     * 
     * @param dom A element to apply this style.
     */
    public default void applyTo(Element dom) {
        // do nothing
    }

    /**
     * <p>
     * Unapply this style from the specified element.
     * </p>
     * 
     * @param dom A element to unapply this style.
     */
    public default void unapplyFrom(Element dom) {
        // do nothing
    }

    public default void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        StyleRule style = new StyleRule(inlines);

        // swap context rule and execute it
        PropertyDefinition.declarable = style;
        declare();
        PropertyDefinition.declarable = null;
    }

    public default Style when(Style style, boolean condition) {
        if (condition == false) {
            return this;
        }
        return new MultipleStyle(this, style);
    }

    /**
     * @param string
     * @param levelDescription
     * @return
     */
    public default Optional<Style> when(String attributeName, String attributeValue) {
        return when(attributeName != null && attributeName.length() != 0 && attributeValue != null && attributeValue
                .length() != 0);
    }

    /**
     * @param b
     * @return
     */
    public default Optional<Style> when(boolean condition) {
        if (condition) {
            return Optional.of(this);
        } else {
            return Optional.empty();
        }
    }

    /**
     * @param object
     * @return
     */
    public default Style with(Style other) {
        return new MultipleStyle(this, other);
    }
}
