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

import booton.css.CSSProperty;
import booton.css.StyleDeclarable;
import booton.css.Unit;
import booton.css.value.Numeric;

/**
 * @version 2013/07/23 0:48:06
 */
public class Transition extends CSSProperty<Transition> {

    /**
     * <p>
     * The transition-property CSS property is used to specify the names of CSS properties to which
     * a transition effect should be applied.
     * </p>
     */
    public final Property property = new Property();

    /**
     * <p>
     * The CSS transition-timing-function property is used to describe how the intermediate values
     * of the CSS properties being affected by a transition effect are calculated. This in essence
     * lets you establish an acceleration curve, so that the speed of the transition can vary over
     * its duration.
     * </p>
     */
    public final Timing timing = new Timing();

    /** The time duration. */
    private Numeric duration;

    /** The time delay. */
    private Numeric delay;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void write(StyleDeclarable writer) {
        // super.write(writer);

        writer.property("-webkit-transition", property, duration, timing, delay);
        writer.property("transition", property, duration, timing, delay);

        // writer.property("transition-duration", duration, Webkit);
        // writer.property("transition-delay", delay, Webkit);
    }

    /**
     * <p>
     * The transition-duration CSS property specifies the number of seconds or milliseconds a
     * transition animation should take to complete. By default, the value is 0s, meaning that no
     * animation will occur.
     * </p>
     * 
     * @param time
     * @param unit
     * @return
     */
    public Transition duration(double time, Unit unit) {
        duration = new Numeric(time, unit);

        return chain();
    }

    /**
     * <p>
     * The transition-delay CSS property specifies the amount of time to wait between a change being
     * requested to a property that is to be transitioned and the start of the transition effect.
     * </p>
     * 
     * @param time
     * @param unit
     * @return
     */
    public Transition delay(double time, Unit unit) {
        delay = new Numeric(time, unit);

        return chain();
    }

    /**
     * <p>
     * The transition-property CSS property is used to specify the names of CSS properties to which
     * a transition effect should be applied.
     * </p>
     * 
     * @param id A string identifying the property to which a transition effect should be applied
     *            when its value changes. This identifier is composed by case-insensitive letter a
     *            to z, numbers 0 to 9, an underscore (_) or a dash(-). The first non-dash character
     *            must be a letter (that is no number at the beginning of it, even preceded by a
     *            dash). Also two dashes are forbidden at the beginning of the identifier.
     * @return Chainable API.
     */
    public Transition property(String id) {
        return property.specify(id);
    }

    /**
     * @version 2013/07/23 16:33:59
     */
    public class Property {

        /** The property/. */
        private String value;

        /**
         * <p>
         * All properties that can have an animated transition will do so.
         * </p>
         * 
         * @return
         */
        public Transition all() {
            value = "all";
            return chain();
        }

        /**
         * <p>
         * No properties will transition.
         * </p>
         * 
         * @return
         */
        public Transition none() {
            value = "none";
            return chain();
        }

        /**
         * <p>
         * The transition-property CSS property is used to specify the names of CSS properties to
         * which a transition effect should be applied.
         * </p>
         * 
         * @param id A string identifying the property to which a transition effect should be
         *            applied when its value changes. This identifier is composed by
         *            case-insensitive letter a to z, numbers 0 to 9, an underscore (_) or a
         *            dash(-). The first non-dash character must be a letter (that is no number at
         *            the beginning of it, even preceded by a dash). Also two dashes are forbidden
         *            at the beginning of the identifier.
         * @return Chainable API.
         */
        private Transition specify(String id) {
            value = id;
            return chain();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return value;
        }
    }

    /**
     * @version 2013/07/23 16:33:52
     */
    public class Timing {

        /** The timing. */
        private String value;

        /**
         * <p>
         * This keyword represents the timing function cubic-bezier(0.0, 0.0, 1.0, 1.0). Using this
         * timing function, the animation goes from its initial state to its final one regularly,
         * with a constant speed.
         * </p>
         * 
         * @return
         */
        public Transition linear() {
            value = "liner";
            return chain();
        }

        /**
         * <p>
         * This keyword represents the timing function cubic-bezier(0.25, 0.1, 0.25, 1.0). This
         * function is similar to ease-in-out, though it accelerates more sharply at the beginning
         * and the acceleration already starts to slow down near the middle of it.
         * </p>
         * 
         * @return
         */
        public Transition ease() {
            value = "ease";
            return chain();
        }

        /**
         * <p>
         * This keyword represents the timing function cubic-bezier(0.42, 0.0, 1.0, 1.0). The
         * animation begins slowly, then progressively accelerates until the final state is reached
         * and the animation stops abruptly.
         * </p>
         * 
         * @return
         */
        public Transition easeIn() {
            value = "ease-in";
            return chain();
        }

        /**
         * <p>
         * This keyword represents the timing function cubic-bezier(0.42, 0.0, 0.58, 1.0). With this
         * timing function, the animation starts slowly, accelerates than slows down when
         * approaching to its final state. At the begin, it behaves similarly to the ease-in
         * function, at the end, it is similar to the ease-out function.
         * </p>
         * 
         * @return
         */
        public Transition easeInOut() {
            value = "ease-in-out";
            return chain();
        }

        /**
         * <p>
         * This keyword represents the timing function cubic-bezier(0.0, 0.0, 0.58, 1.0). The
         * animation starts quickly then slow progressively down when approaching to its final
         * state.
         * </p>
         * 
         * @return
         */
        public Transition easeOut() {
            value = "ease-out";
            return chain();
        }

        /**
         * <p>
         * This keyword represents the timing function steps(1, start). Using this timing function,
         * the animation jumps immediately to the end state and stay in that position until the end
         * of the animation.
         * </p>
         * 
         * @return
         */
        public Transition stepStart() {
            value = "step-start";
            return chain();
        }

        /**
         * <p>
         * This keyword represents the timing function steps(1, end). Using this timing function,
         * the animation stays in its initial state until the end, where it directly jumps to its
         * final position.
         * </p>
         * 
         * @return
         */
        public Transition stepEnd() {
            value = "step-end";
            return chain();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return value;
        }
    }
}
