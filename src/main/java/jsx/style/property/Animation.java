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

import js.dom.CSSStyleSheet;
import jsx.style.PropertyDefinition;
import jsx.style.value.AnimationFrames;
import jsx.style.value.Numeric;
import jsx.style.value.Unit;

/**
 * @version 2015/10/05 23:16:01
 */
public class Animation extends PropertyDefinition<Animation> {

    /** The animation related property. */
    private Numeric duration = new Numeric(0, s);

    /** The animation related property. */
    private Numeric delay = new Numeric(0, s);

    /** The animation related property. */
    private String timing = "ease";

    /** The animation related property. */
    private String direction = "normal";

    /** The animation related property. */
    private String fill = "none";

    /** The animation related property. */
    private String play = "running";

    /** The animation related property. */
    private String iteration = "1";

    /**
     * <p>
     * The animation-name CSS property specifies a list of animations that should be applied to the
     * selected element. Each name indicates a @keyframes at-rule that defines the property values
     * for the animation sequence.
     * </p>
     * 
     * @return
     */
    public Animation name(String name) {
        value("animation-name", name);
        value("animation-duration", duration);
        value("animation-delay", delay);
        value("animation-timing-function", timing);
        value("animation-direction", direction);
        value("animation-fill-mode", fill);
        value("animation-iteration-count", iteration);
        value("animation-play-state", play);

        return this;
    }

    /**
     * <p>
     * The animation-name CSS property specifies a list of animations that should be applied to the
     * selected element. Each name indicates a @keyframes at-rule that defines the property values
     * for the animation sequence.
     * </p>
     * 
     * @return
     */
    public Animation name(AnimationFrames animation) {
        CSSStyleSheet.define(animation);

        return name(animation.name);
    }

    /**
     * <p>
     * The animation is currently playing.
     * </p>
     * 
     * @return
     */
    public Animation running() {
        play = "running";

        return this;
    }

    /**
     * <p>
     * The animation is currently paused.
     * </p>
     * 
     * @return
     */
    public Animation paused() {
        play = "paused";

        return this;
    }

    /**
     * <p>
     * The target will retain the computed values set by the last keyframe encountered during
     * execution. The last keyframe encountered depends on the value of animation-direction and
     * animation-iteration-count:
     * </p>
     * 
     * @return
     */
    public Animation forwards() {
        fill = "forwards";

        return this;
    }

    /**
     * <p>
     * The animation will apply the values defined in the first relevant keyframe as soon as it is
     * applied to the target, and retain this during the animation-delay period. The first relevant
     * keyframe depends of the value of animation-direction:
     * </p>
     * 
     * @return
     */
    public Animation backwards() {
        fill = "backwards";

        return this;
    }

    /**
     * <p>
     * The animation will follow the rules for both forwards and backwards, thus extending the
     * animation properties in both directions.
     * </p>
     * 
     * @return
     */
    public Animation both() {
        fill = "both";

        return this;
    }

    /**
     * <p>
     * The animation should reverse direction each cycle. When playing in reverse, the animation
     * steps are performed backward. In addition, timing functions are also reversed; for example,
     * an ease-in animation is replaced with an ease-out animation when played in reverse. The count
     * to determine if it is an even or an odd iteration starts at one.
     * </p>
     * 
     * @return
     */
    public Animation reverse() {
        direction = "reverse";

        return this;
    }

    /**
     * <p>
     * The animation plays backward each cycle. Each time the animation cycles, the animation resets
     * to the end state and start over again.
     * </p>
     * 
     * @return
     */
    public Animation alternate() {
        direction = "alternate";

        return this;
    }

    /**
     * <p>
     * The animation plays backward on the first play-through, then forward on the next, then
     * continues to alternate. The count to determinate if it is an even or an odd iteration starts
     * at one.
     * </p>
     * 
     * @return
     */
    public Animation alternateReverse() {
        direction = "alternate-reverse";

        return this;
    }

    /**
     * <p>
     * The animation-iteration-count CSS property defines the number of times an animation cycle
     * should be played before stopping.
     * </p>
     * 
     * @param time
     * @param unit
     * @return
     */
    public Animation iterationCount(int count) {
        iteration = String.valueOf(count);

        return this;
    }

    /**
     * <p>
     * The animation-iteration-count CSS property defines the number of times an animation cycle
     * should be played before stopping.
     * </p>
     * 
     * @param time
     * @param unit
     * @return
     */
    public Animation iterationInfinite() {
        iteration = "infinite";

        return this;
    }

    /**
     * <p>
     * The animation-duration CSS property specifies the length of time that an animation should
     * take to complete one cycle. A value of 0s, which is the default value, indicates that no
     * animation should occur.
     * </p>
     * 
     * @param time
     * @param unit
     * @return
     */
    public Animation duration(double time, Unit unit) {
        duration = new Numeric(time, unit);

        return this;
    }

    /**
     * <p>
     * The animation-delay CSS property specifies when the animation should start. This lets the
     * animation sequence begin some time after it's applied to an element. A value of 0s, which is
     * the default value of the property, indicates that the animation should begin as soon as it's
     * applied. Otherwise, the value specifies an offset from the moment the animation is applied to
     * the element; animation will begin that amount of time after being applied.
     * </p>
     * 
     * @param time
     * @param unit
     * @return
     */
    public Animation delay(double time, Unit unit) {
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
    public Animation linear() {
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
    public Animation ease() {
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
    public Animation easeIn() {
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
    public Animation easeInOut() {
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
    public Animation easeOut() {
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
    public Animation stepStart() {
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
    public Animation stepEnd() {
        timing = "step-end";
        return this;
    }
}
