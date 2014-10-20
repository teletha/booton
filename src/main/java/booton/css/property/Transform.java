/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import static booton.css.Vendor.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import booton.css.CSSProperty;
import booton.css.CSSValue;
import booton.css.StyleDeclarable;
import booton.css.Unit;
import booton.css.Vendor;
import booton.css.value.Numeric;

/**
 * @version 2013/07/23 22:34:54
 */
public class Transform extends CSSProperty<Transform> {

    /** The function list. */
    private final List<Function> functions = new ArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(StyleDeclarable writer) {
        writer.property("transform", functions, Webkit);
    }

    /**
     * <p>
     * The rotate() CSS function defines a transformation that moves the element around a fixed
     * point (as specified by the transform-origin property) without deforming it. The amount of
     * movement is defined by the specified angle; if positive, the movement will be clockwise, if
     * negative, it will be counter-clockwise. A rotation by 180° is called point reflection.
     * </p>
     * 
     * @param angle The angle of the rotation.
     * @param unit The unit of the rotation.
     * @return Chainable API.
     */
    public Transform rotate(double angle, Unit unit) {
        return rotate(new Numeric(angle, unit));
    }

    /**
     * <p>
     * The rotate() CSS function defines a transformation that moves the element around a fixed
     * point (as specified by the transform-origin property) without deforming it. The amount of
     * movement is defined by the specified angle; if positive, the movement will be clockwise, if
     * negative, it will be counter-clockwise. A rotation by 180° is called point reflection.
     * </p>
     * 
     * @param angle the angle of the rotation.
     * @return Chainable API.
     */
    public Transform rotate(Numeric angle) {
        functions.add(new Function("rotate", new Parameter(angle)));

        return chain();
    }

    /**
     * <p>
     * The rotateX()CSS function defines a transformation that moves the element around the abscissa
     * without deforming it. The amount of movement is defined by the specified angle; if positive,
     * the movement will be clockwise, if negative, it will be counter-clockwise.
     * </p>
     * 
     * @param angle The angle of the rotation.
     * @param unit The unit of the rotation.
     * @return Chainable API.
     */
    public Transform rotateX(double angle, Unit unit) {
        return rotateX(new Numeric(angle, unit));
    }

    /**
     * <p>
     * The rotateX()CSS function defines a transformation that moves the element around the abscissa
     * without deforming it. The amount of movement is defined by the specified angle; if positive,
     * the movement will be clockwise, if negative, it will be counter-clockwise.
     * </p>
     * 
     * @param angle the angle of the rotation.
     * @return Chainable API.
     */
    public Transform rotateX(Numeric angle) {
        functions.add(new Function("rotateX", new Parameter(angle)));

        return chain();
    }

    /**
     * <p>
     * The rotateY()CSS function defines a transformation that moves the element around the ordinate
     * without deforming it. The amount of movement is defined by the specified angle; if positive,
     * the movement will be clockwise, if negative, it will be counter-clockwise.
     * </p>
     * 
     * @param angle The angle of the rotation.
     * @param unit The unit of the rotation.
     * @return Chainable API.
     */
    public Transform rotateY(double angle, Unit unit) {
        return rotateY(new Numeric(angle, unit));
    }

    /**
     * <p>
     * The rotateY()CSS function defines a transformation that moves the element around the ordinate
     * without deforming it. The amount of movement is defined by the specified angle; if positive,
     * the movement will be clockwise, if negative, it will be counter-clockwise.
     * </p>
     * 
     * @param angle the angle of the rotation.
     * @return Chainable API.
     */
    public Transform rotateY(Numeric angle) {
        functions.add(new Function("rotateY", new Parameter(angle)));

        return chain();
    }

    /**
     * <p>
     * The rotateZ()CSS function defines a transformation that moves the element around the z-axis
     * without deforming it. The amount of movement is defined by the specified angle; if positive,
     * the movement will be clockwise, if negative, it will be counter-clockwise.
     * </p>
     * 
     * @param angle The angle of the rotation.
     * @param unit The unit of the rotation.
     * @return Chainable API.
     */
    public Transform rotateZ(double angle, Unit unit) {
        return rotateZ(new Numeric(angle, unit));
    }

    /**
     * <p>
     * The rotateZ()CSS function defines a transformation that moves the element around the z-axis
     * without deforming it. The amount of movement is defined by the specified angle; if positive,
     * the movement will be clockwise, if negative, it will be counter-clockwise.
     * </p>
     * 
     * @param angle the angle of the rotation.
     * @return Chainable API.
     */
    public Transform rotateZ(Numeric angle) {
        functions.add(new Function("rotateZ", new Parameter(angle)));

        return chain();
    }

    /**
     * <p>
     * The scale() CSS function modify the size of the element. It can either augment or decrease
     * its size and as the amount of scaling is defined by a vector, if can do so more in one
     * direction than in another one.
     * </p>
     * 
     * @param scale The abscissa and ordinate of the scaling vector.
     * @return Chainable API.
     */
    public Transform scale(double scale) {
        functions.add(new Function("scale", new Parameter(scale)));

        return chain();
    }

    /**
     * <p>
     * The scale() CSS function modify the size of the element. It can either augment or decrease
     * its size and as the amount of scaling is defined by a vector, if can do so more in one
     * direction than in another one.
     * </p>
     * 
     * @param scaleX The abscissa of the scaling vector.
     * @param scaleY The ordinate of the scaling vector.
     * @return Chainable API.
     */
    public Transform scale(double scaleX, double scaleY) {
        functions.add(new Function("scale", new Parameter(scaleX), new Parameter(scaleY)));

        return chain();
    }

    /**
     * <p>
     * The scaleX() CSS function modifies the abscissa of each element point by a constant factor,
     * except if this scale factor is 1, in which case the function is the identity transform. The
     * scaling is not isotropic and the angles of the element are not conserved.
     * </p>
     * 
     * @param scale The scaling factor to apply on the abscissa of each point of the element.
     * @return Chainable API.
     */
    public Transform scaleX(double scale) {
        functions.add(new Function("scaleX", new Parameter(scale)));

        return chain();
    }

    /**
     * <p>
     * The scaleY() CSS function modifies the ordinate of each element point by a constant factor
     * except if this scale factor is 1, in which case the function is the identity transform. The
     * scaling is not isotropic and the angles of the element are not conserved.
     * </p>
     * 
     * @param scale The scaling factor to apply on the ordinate of each point of the element.
     * @return Chainable API.
     */
    public Transform scaleY(double scale) {
        functions.add(new Function("scaleY", new Parameter(scale)));

        return chain();
    }

    /**
     * <p>
     * The scaleZ() CSS function modifies the z-coordinate of each element point by a constant
     * facto, except if this scale factor is 1, in which case the function is the identity
     * transform. The scaling is not isotropic and the angles of the element are not conserved.
     * </p>
     * 
     * @param scale The scaling factor to apply on the z-coordinate of each point of the element.
     * @return Chainable API.
     */
    public Transform scaleZ(double scale) {
        functions.add(new Function("scaleZ", new Parameter(scale)));

        return chain();
    }

    /**
     * <p>
     * The skew() CSS function is a shear mapping, or transvection, distorting each point of an
     * element by a certain angle in each direction. It is done by increasing each coordinate by a
     * value proportionate to the specified angle and to the distance to the origin. The more far
     * from the origin, the more away the point is, the greater will be the value added to it.
     * </p>
     * 
     * @param angle The angle to use to distort the element along the abscissa and ordinate.
     * @param unit The unit to use to distort the element along the abscissa and ordinate.
     * @return Chainable API.
     */
    public Transform skew(double angle, Unit unit) {
        return skew(new Numeric(angle, unit));
    }

    /**
     * <p>
     * The skew() CSS function is a shear mapping, or transvection, distorting each point of an
     * element by a certain angle in each direction. It is done by increasing each coordinate by a
     * value proportionate to the specified angle and to the distance to the origin. The more far
     * from the origin, the more away the point is, the greater will be the value added to it.
     * </p>
     * 
     * @param value The angle to use to distort the element along the abscissa and ordinate.
     * @return Chainable API.
     */
    public Transform skew(Numeric value) {
        functions.add(new Function("skew", new Parameter(value)));

        return chain();
    }

    /**
     * <p>
     * The skew() CSS function is a shear mapping, or transvection, distorting each point of an
     * element by a certain angle in each direction. It is done by increasing each coordinate by a
     * value proportionate to the specified angle and to the distance to the origin. The more far
     * from the origin, the more away the point is, the greater will be the value added to it.
     * </p>
     * 
     * @param angleX The angle to use to distort the element along the abscissa.
     * @param unitX The unit to use to distort the element along the abscissa.
     * @param angleY The angle to use to distort the element along the ordinate.
     * @param unitY The unit to use to distort the element along the ordinate.
     * @return Chainable API.
     */
    public Transform skew(double angleX, Unit unitX, double angleY, Unit unitY) {
        return skew(new Numeric(angleX, unitX), new Numeric(angleY, unitY));
    }

    /**
     * <p>
     * The skew() CSS function is a shear mapping, or transvection, distorting each point of an
     * element by a certain angle in each direction. It is done by increasing each coordinate by a
     * value proportionate to the specified angle and to the distance to the origin. The more far
     * from the origin, the more away the point is, the greater will be the value added to it.
     * </p>
     * 
     * @param angleX The angle to use to distort the element along the abscissa.
     * @param angleY The angle to use to distort the element along the ordinate.
     * @return Chainable API.
     */
    public Transform skew(Numeric angleX, Numeric angleY) {
        functions.add(new Function("skew", new Parameter(angleX), new Parameter(angleY)));

        return chain();
    }

    /**
     * <p>
     * The skewX() CSS function is an horizontal shear mapping distorting each point of an element
     * by a certain angle in the horizontal direction. It is done by increasing the abscissa
     * coordinate by a value proportionate to the specified angle and to the distance to the origin.
     * The more far from the origin, the more away the point is, the greater will be the value added
     * to it.
     * </p>
     * 
     * @param angle The angle to use to distort the element along the abscissa.
     * @param unit The unit to use to distort the element along the abscissa.
     * @return Chainable API.
     */
    public Transform skewX(double angle, Unit unit) {
        return skewX(new Numeric(angle, unit));
    }

    /**
     * <p>
     * The skewX() CSS function is an horizontal shear mapping distorting each point of an element
     * by a certain angle in the horizontal direction. It is done by increasing the abscissa
     * coordinate by a value proportionate to the specified angle and to the distance to the origin.
     * The more far from the origin, the more away the point is, the greater will be the value added
     * to it.
     * </p>
     * 
     * @param value The angle to use to distort the element along the abscissa.
     * @return Chainable API.
     */
    public Transform skewX(Numeric value) {
        functions.add(new Function("skewX", new Parameter(value)));

        return chain();
    }

    /**
     * <p>
     * The skewY() CSS function is an vertical shear mapping distorting each point of an element by
     * a certain angle in the vertical direction. It is done by increasing the ordinate coordinate
     * by a value proportionate to the specified angle and to the distance to the origin. The more
     * far from the origin, the more away the point is, the greater will be the value added to it.
     * </p>
     * 
     * @param angle The angle to use to distort the element along the ordinate.
     * @param unit The unit to use to distort the element along the ordinate.
     * @return Chainable API.
     */
    public Transform skewY(double angle, Unit unit) {
        return skewY(new Numeric(angle, unit));
    }

    /**
     * <p>
     * The skewY() CSS function is an vertical shear mapping distorting each point of an element by
     * a certain angle in the vertical direction. It is done by increasing the ordinate coordinate
     * by a value proportionate to the specified angle and to the distance to the origin. The more
     * far from the origin, the more away the point is, the greater will be the value added to it.
     * </p>
     * 
     * @param value The angle to use to distort the element along the ordinate.
     * @return Chainable API.
     */
    public Transform skewY(Numeric value) {
        functions.add(new Function("skewY", new Parameter(value)));

        return chain();
    }

    /**
     * <p>
     * The translateX() CSS function moves horizontally the element on the plane. This
     * transformation is characterized by a <length> defining how much it moves horizontally.
     * </p>
     * 
     * @param size The abscissa of the translating vector.
     * @param unit The unit of the translating vector.
     * @return Chainable API.
     */
    public Transform translate(double size, Unit unit) {
        return translate(new Numeric(size, unit));
    }

    /**
     * <p>
     * The translateX() CSS function moves horizontally the element on the plane. This
     * transformation is characterized by a <length> defining how much it moves horizontally.
     * </p>
     * 
     * @param value The abscissa of the translating vector.
     * @return Chainable API.
     */
    public Transform translate(Numeric value) {
        functions.add(new Function("translate", new Parameter(value)));

        return chain();
    }

    /**
     * <p>
     * The translateX() CSS function moves horizontally the element on the plane. This
     * transformation is characterized by a <length> defining how much it moves horizontally.
     * </p>
     * 
     * @param size The abscissa of the translating vector.
     * @param unit The unit of the translating vector.
     * @return Chainable API.
     */
    public Transform translateX(double size, Unit unit) {
        return translateX(new Numeric(size, unit));
    }

    /**
     * <p>
     * The translateX() CSS function moves horizontally the element on the plane. This
     * transformation is characterized by a <length> defining how much it moves horizontally.
     * </p>
     * 
     * @param value The abscissa of the translating vector.
     * @return Chainable API.
     */
    public Transform translateX(Numeric value) {
        functions.add(new Function("translateX", new Parameter(value)));

        return chain();
    }

    /**
     * <p>
     * The translateY() CSS function moves vertically the element on the plane. This transformation
     * is characterized by a <length> defining how much it moves vertically.
     * </p>
     * 
     * @param size The ordinate of the translating vector.
     * @param unit The unit of the translating vector.
     * @return Chainable API.
     */
    public Transform translateY(double size, Unit unit) {
        return translateY(new Numeric(size, unit));
    }

    /**
     * <p>
     * The translateY() CSS function moves vertically the element on the plane. This transformation
     * is characterized by a <length> defining how much it moves vertically.
     * </p>
     * 
     * @param value The ordinate of the translating vector.
     * @return Chainable API.
     */
    public Transform translateY(Numeric value) {
        functions.add(new Function("translateY", new Parameter(value)));

        return chain();
    }

    /**
     * <p>
     * The translateZ() CSS function moves the element along the z-axis of the 3D space. This
     * transformation is characterized by a <length> defining how much it moves.
     * </p>
     * 
     * @param size The z-component of the translating vector.
     * @param unit The unit of the translating vector.
     * @return Chainable API.
     */
    public Transform translateZ(double size, Unit unit) {
        return translateZ(new Numeric(size, unit));
    }

    /**
     * <p>
     * The translateZ() CSS function moves the element along the z-axis of the 3D space. This
     * transformation is characterized by a <length> defining how much it moves.
     * </p>
     * 
     * @param value The z-component of the translating vector.
     * @return Chainable API.
     */
    public Transform translateZ(Numeric value) {
        functions.add(new Function("translateZ", new Parameter(value)));

        return chain();
    }

    /**
     * @version 2013/07/23 21:58:04
     */
    private static class Parameter extends Numeric {

        /**
         * @param value
         * @param unit
         */
        private Parameter(double value, Unit unit) {
            super(value, unit);
        }

        /**
         * @param size
         */
        private Parameter(double size) {
            super(size);
        }

        /**
         * @param numeric
         */
        private Parameter(Numeric numeric) {
            super(numeric);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected EnumSet<Vendor> vendors() {
            return super.vendors();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String valueFor(Vendor vendor) {
            return super.valueFor(vendor);
        }
    }

    /**
     * @version 2013/07/23 21:43:45
     */
    private static class Function extends CSSValue {

        /** The function name. */
        private final String function;

        /** The function parameter list. */
        private final Parameter[] parameters;

        /**
         * <p>
         * Create function definition.
         * </p>
         * 
         * @param function
         * @param parameters
         */
        private Function(String function, Parameter... parameters) {
            this.function = function;
            this.parameters = parameters;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected EnumSet<Vendor> vendors() {
            EnumSet<Vendor> vendors = EnumSet.noneOf(Vendor.class);

            for (Parameter parameter : parameters) {
                vendors.addAll(parameter.vendors());
            }
            return vendors;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected String valueFor(Vendor vendor) {
            StringBuilder builder = new StringBuilder();
            builder.append(function).append('(');

            for (int i = 0; i < parameters.length; i++) {
                builder.append(parameters[i].valueFor(vendor));

                if (i + 1 != parameters.length) {
                    builder.append(',');
                }
            }
            builder.append(')');

            return builder.toString();
        }
    }
}
