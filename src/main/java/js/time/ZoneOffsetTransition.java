/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time;

import java.time.Duration;

/**
 * @version 2015/08/08 16:40:06
 */
// @JavaAPIProvider(java.time.zone.ZoneOffsetTransition.class)
class ZoneOffsetTransition {

    /**
     * The local transition date-time at the transition.
     */
    private final LocalDateTime transition;

    /**
     * The offset before transition.
     */
    private final ZoneOffset offsetBefore;

    /**
     * The offset after transition.
     */
    private final ZoneOffset offsetAfter;

    /**
     * Creates an instance defining a transition between two offsets.
     *
     * @param transition the transition date-time with the offset before the transition, not null
     * @param offsetBefore the offset before the transition, not null
     * @param offsetAfter the offset at and after the transition, not null
     */
    ZoneOffsetTransition(LocalDateTime transition, ZoneOffset offsetBefore, ZoneOffset offsetAfter) {
        this.transition = transition;
        this.offsetBefore = offsetBefore;
        this.offsetAfter = offsetAfter;
    }

    /**
     * Gets the transition instant.
     * <p>
     * This is the instant of the discontinuity, which is defined as the first instant that the
     * 'after' offset applies.
     * <p>
     * The methods {@link #getInstant()}, {@link #getDateTimeBefore()} and
     * {@link #getDateTimeAfter()} all represent the same instant.
     *
     * @return the transition instant, not null
     */
    public Instant getInstant() {
        return transition.toInstant(offsetBefore);
    }

    /**
     * Gets the transition instant as an epoch second.
     *
     * @return the transition epoch second
     */
    public long toEpochSecond() {
        return transition.toEpochSecond(offsetBefore);
    }

    // -------------------------------------------------------------------------
    /**
     * Gets the local transition date-time, as would be expressed with the 'before' offset.
     * <p>
     * This is the date-time where the discontinuity begins expressed with the 'before' offset. At
     * this instant, the 'after' offset is actually used, therefore the combination of this
     * date-time and the 'before' offset will never occur.
     * <p>
     * The combination of the 'before' date-time and offset represents the same instant as the
     * 'after' date-time and offset.
     *
     * @return the transition date-time expressed with the before offset, not null
     */
    public LocalDateTime getDateTimeBefore() {
        return transition;
    }

    /**
     * Gets the local transition date-time, as would be expressed with the 'after' offset.
     * <p>
     * This is the first date-time after the discontinuity, when the new offset applies.
     * <p>
     * The combination of the 'before' date-time and offset represents the same instant as the
     * 'after' date-time and offset.
     *
     * @return the transition date-time expressed with the after offset, not null
     */
    public LocalDateTime getDateTimeAfter() {
        return transition.plusSeconds(getDurationSeconds());
    }

    /**
     * Gets the offset before the transition.
     * <p>
     * This is the offset in use before the instant of the transition.
     *
     * @return the offset before the transition, not null
     */
    public ZoneOffset getOffsetBefore() {
        return offsetBefore;
    }

    /**
     * Gets the offset after the transition.
     * <p>
     * This is the offset in use on and after the instant of the transition.
     *
     * @return the offset after the transition, not null
     */
    public ZoneOffset getOffsetAfter() {
        return offsetAfter;
    }

    /**
     * Gets the duration of the transition.
     * <p>
     * In most cases, the transition duration is one hour, however this is not always the case. The
     * duration will be positive for a gap and negative for an overlap. Time-zones are second-based,
     * so the nanosecond part of the duration will be zero.
     *
     * @return the duration of the transition, positive for gaps, negative for overlaps
     */
    public Duration getDuration() {
        return Duration.ofSeconds(getDurationSeconds());
    }

    /**
     * Gets the duration of the transition in seconds.
     *
     * @return the duration in seconds
     */
    private int getDurationSeconds() {
        return getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds();
    }

    /**
     * Does this transition represent a gap in the local time-line.
     * <p>
     * Gaps occur where there are local date-times that simply do not exist. An example would be
     * when the offset changes from {@code +01:00} to {@code +02:00}. This might be described as
     * 'the clocks will move forward one hour tonight at 1am'.
     *
     * @return true if this transition is a gap, false if it is an overlap
     */
    public boolean isGap() {
        return getOffsetAfter().getTotalSeconds() > getOffsetBefore().getTotalSeconds();
    }

    /**
     * Does this transition represent an overlap in the local time-line.
     * <p>
     * Overlaps occur where there are local date-times that exist twice. An example would be when
     * the offset changes from {@code +02:00} to {@code +01:00}. This might be described as 'the
     * clocks will move back one hour tonight at 2am'.
     *
     * @return true if this transition is an overlap, false if it is a gap
     */
    public boolean isOverlap() {
        return getOffsetAfter().getTotalSeconds() < getOffsetBefore().getTotalSeconds();
    }

    /**
     * Creates an instance from epoch-second and offsets.
     *
     * @param epochSecond the transition epoch-second
     * @param offsetBefore the offset before the transition, not null
     * @param offsetAfter the offset at and after the transition, not null
     */
    ZoneOffsetTransition(long epochSecond, ZoneOffset offsetBefore, ZoneOffset offsetAfter) {
        this.transition = LocalDateTime.ofEpochSecond(epochSecond, 0, offsetBefore);
        this.offsetBefore = offsetBefore;
        this.offsetAfter = offsetAfter;
    }
}
