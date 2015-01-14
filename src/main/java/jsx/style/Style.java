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

import js.dom.Element;
import js.lang.NativeArray;

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
    public default String intern() {
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
        dom.style(this);
    }

    /**
     * <p>
     * Unapply this style from the specified element.
     * </p>
     * 
     * @param dom A element to unapply this style.
     */
    public default void unapplyFrom(Element dom) {
        dom.remove(this);
    }

    public default void assignTo(NativeArray<Style> styles, NativeArray<String> names, NativeArray<String> values) {
        StyleRule style = new StyleRule(names, values);

        // swap context rule and execute it
        PropertyDefinition.declarable = style;
        declare();
        PropertyDefinition.declarable = null;
    }

    public default Style when(boolean condition, Style style) {
        if (condition == false) {
            return this;
        }
        return new MultipleStyle(this, style);
    }

    /**
     * @param className
     * @return
     */
    public static Style getByName(String className) {
        return StaticStyle.pool.computeIfAbsent(className, name -> {
            return new StaticStyle(name);
        });
    }

    /**
     * @param object
     * @return
     */
    public default Style with(Style other) {
        return new MultipleStyle(this, other);
    }
}
