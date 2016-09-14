/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import static jsx.style.value.Unit.*;

import jsx.style.PropertyDefinition;
import jsx.style.StyleRule;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;
import jsx.ui.Style;

/**
 * @version 2014/10/29 23:29:19
 */
public class Transition extends PropertyDefinition<Transition> {

    /** The transition related property. */
    private Numeric duration = new Numeric(0, s);

    /** The transition related property. */
    private Numeric delay = new Numeric(0, s);

    /** The transition related property. */
    private String timing = "ease";

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

        return this;
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

        return this;
    }

    /**
     * <p>
     * This keyword represents the timing function cubic-bezier(0.0, 0.0, 1.0, 1.0). Using this
     * timing function, the animation goes from its initial state to its final one regularly, with a
     * constant speed.
     * </p>
     * 
     * @return
     */
    public Transition linear() {
        timing = "liner";
        return this;
    }

    /**
     * <p>
     * This keyword represents the timing function cubic-bezier(0.25, 0.1, 0.25, 1.0). This function
     * is similar to ease-in-out, though it accelerates more sharply at the beginning and the
     * acceleration already starts to slow down near the middle of it.
     * </p>
     * 
     * @return
     */
    public Transition ease() {
        timing = "ease";
        return this;
    }

    /**
     * <p>
     * This keyword represents the timing function cubic-bezier(0.42, 0.0, 1.0, 1.0). The animation
     * begins slowly, then progressively accelerates until the final state is reached and the
     * animation stops abruptly.
     * </p>
     * 
     * @return
     */
    public Transition easeIn() {
        timing = "ease-in";
        return this;
    }

    /**
     * <p>
     * This keyword represents the timing function cubic-bezier(0.42, 0.0, 0.58, 1.0). With this
     * timing function, the animation starts slowly, accelerates than slows down when approaching to
     * its final state. At the begin, it behaves similarly to the ease-in function, at the end, it
     * is similar to the ease-out function.
     * </p>
     * 
     * @return
     */
    public Transition easeInOut() {
        timing = "ease-in-out";
        return this;
    }

    /**
     * <p>
     * This keyword represents the timing function cubic-bezier(0.0, 0.0, 0.58, 1.0). The animation
     * starts quickly then slow progressively down when approaching to its final state.
     * </p>
     * 
     * @return
     */
    public Transition easeOut() {
        timing = "ease-out";
        return this;
    }

    /**
     * <p>
     * This keyword represents the timing function steps(1, start). Using this timing function, the
     * animation jumps immediately to the end state and stay in that position until the end of the
     * animation.
     * </p>
     * 
     * @return
     */
    public Transition stepStart() {
        timing = "step-start";
        return this;
    }

    /**
     * <p>
     * This keyword represents the timing function steps(1, end). Using this timing function, the
     * animation stays in its initial state until the end, where it directly jumps to its final
     * position.
     * </p>
     * 
     * @return
     */
    public Transition stepEnd() {
        timing = "step-end";
        return this;
    }

    /**
     * <p>
     * Declare class change effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void when(Style other, Style sub) {
        when("$." + other.name(), sub);
    }

    /**
     * <p>
     * Declare class change effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenIn(Style other, Style sub) {
        when("." + other.name() + " $", sub);
    }

    /**
     * <p>
     * Declare class change effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenWith(Style other, Style sub) {
        when("." + other.name() + "$", sub);
    }

    /**
     * <p>
     * Declare hover effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenHover(Style sub) {
        when("$:hover", sub);
    }

    /**
     * <p>
     * Declare hover effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenParentHover(Style sub) {
        when("*:hover>$", sub);
    }

    /**
     * <p>
     * Declare hover effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenParentHover(Style parent, Style sub) {
        when("." + parent.name() + ":hover $", sub);
    }

    /**
     * <p>
     * Declare hover effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenSiblingHover(Style sub) {
        when("*:hover~$", sub);
    }

    /**
     * <p>
     * Declare hover effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenAdjacentHover(Style sub) {
        when("*:hover+$", sub);
    }

    /**
     * <p>
     * Declare active effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenActive(Style sub) {
        when("$:active", sub);
    }

    /**
     * <p>
     * Declare focus effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenFocus(Style sub) {
        when("$:focus", sub);
    }

    /**
     * <p>
     * Declare check effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenCheck(Style sub) {
        when("$:checked", sub);
    }

    /**
     * <p>
     * Declare valid effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenValid(Style sub) {
        when("$:valid", sub);
    }

    /**
     * <p>
     * Declare invalid effect.
     * </p>
     * 
     * @param sub A style of this effect.
     */
    public void whenInvalid(Style sub) {
        when("$:invalid", sub);
    }

    /**
     * <p>
     * Create transitable sub rule and parse it.
     * </p>
     */
    private void when(String selector, Style sub) {
        StyleRule rule = createSubRule(selector, sub);

        value("transition-property", join(rule.properties.keys(), v -> v));
        value("transition-duration", join(rule.properties.keys(), v -> duration));
        value("transition-delay", join(rule.properties.keys(), v -> delay));
        value("transition-timing-function", join(rule.properties.keys(), v -> timing));
    }

    public void whenever() {
        value("transition-property", "all");
        value("transition-duration", duration);
        value("transition-delay", delay);
        value("transition-timing-function", timing);
    }
}
