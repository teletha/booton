/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import java.util.ArrayList;
import java.util.List;

import kiss.I;
import booton.css.CSSProperty;
import booton.css.CSSWriter;
import booton.css.Unit;
import booton.css.Value;

/**
 * @version 2012/12/26 21:35:04
 */
public class Transform extends CSSProperty<Transform> {

    /** The function list. */
    private List<String> functions = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(CSSWriter writer) {
        writer.property("transform", I.join(functions, " "));
    }

    /**
     * <p>
     * The rotate() CSS function defines a transformation that moves the element around a fixed
     * point (as specified by the transform-origin property) without deforming it. The amount of
     * movement is defined by the specified angle; if positive, the movement will be clockwise, if
     * negative, it will be counter-clockwise. A rotation by 180° is called point reflection.
     * </p>
     * 
     * @param angle
     * @param unit
     * @return
     */
    public Transform rotate(double angle, Unit unit) {
        functions.add("rotate(" + new Value(angle, unit) + ")");

        return chain();
    }

    /**
     * <p>
     * The scale() CSS function modify the size of the element. It can either augment or decrease
     * its size and as the amount of scaling is defined by a vector, if can do so more in one
     * direction than in another one.
     * </p>
     * 
     * @param scale
     */
    public Transform scale(double scale) {
        functions.add("scale(" + scale + ")");

        return chain();
    }

    /**
     * <p>
     * The scale() CSS function modify the size of the element. It can either augment or decrease
     * its size and as the amount of scaling is defined by a vector, if can do so more in one
     * direction than in another one.
     * </p>
     * 
     * @param scaleX
     * @param scaleY
     */
    public Transform scale(double scaleX, double scaleY) {
        functions.add("scale(" + scaleX + "," + scaleY + ")");

        return chain();
    }
}
