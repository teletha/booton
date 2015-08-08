/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time.zone;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.zone.ZoneRules;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/08 23:06:41
 */
@JavaAPIProvider(java.time.zone.ZoneOffsetTransition.class)
class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition> {

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

    // -----------------------------------------------------------------------
    /**
     * Obtains an instance defining a transition between two offsets.
     * <p>
     * Applications should normally obtain an instance from {@link ZoneRules}. This factory is only
     * intended for use when creating {@link ZoneRules}.
     *
     * @param transition the transition date-time at the transition, which never actually occurs,
     *            expressed local to the before offset, not null
     * @param offsetBefore the offset before the transition, not null
     * @param offsetAfter the offset at and after the transition, not null
     * @return the transition, not null
     * @throws IllegalArgumentException if {@code offsetBefore} and {@code offsetAfter} are equal,
     *             or {@code transition.getNano()} returns non-zero value
     */
    public static ZoneOffsetTransition of(LocalDateTime transition, ZoneOffset offsetBefore, ZoneOffset offsetAfter) {
        Objects.requireNonNull(transition, "transition");
        Objects.requireNonNull(offsetBefore, "offsetBefore");
        Objects.requireNonNull(offsetAfter, "offsetAfter");
        if (offsetBefore.equals(offsetAfter)) {
            throw new IllegalArgumentException("Offsets must not be equal");
        }
        if (transition.getNano() != 0) {
            throw new IllegalArgumentException("Nano-of-second must be zero");
        }
        return new ZoneOffsetTransition(transition, offsetBefore, offsetAfter);
    }

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

    // -----------------------------------------------------------------------
    /**
     * Defend against malicious streams.
     *
     * @param s the stream to read
     * @throws InvalidObjectException always
     */
    private void readObject(ObjectInputStream s) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    // -----------------------------------------------------------------------
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
     * Checks if the specified offset is valid during this transition.
     * <p>
     * This checks to see if the given offset will be valid at some point in the transition. A gap
     * will always return false. An overlap will return true if the offset is either the before or
     * after offset.
     *
     * @param offset the offset to check, null returns false
     * @return true if the offset is valid during the transition
     */
    public boolean isValidOffset(ZoneOffset offset) {
        return isGap() ? false : (getOffsetBefore().equals(offset) || getOffsetAfter().equals(offset));
    }

    /**
     * Gets the valid offsets during this transition.
     * <p>
     * A gap will return an empty list, while an overlap will return both offsets.
     *
     * @return the list of valid offsets
     */
    List<ZoneOffset> getValidOffsets() {
        if (isGap()) {
            return Collections.emptyList();
        }
        return Arrays.asList(getOffsetBefore(), getOffsetAfter());
    }

    // -----------------------------------------------------------------------
    /**
     * Compares this transition to another based on the transition instant.
     * <p>
     * This compares the instants of each transition. The offsets are ignored, making this order
     * inconsistent with equals.
     *
     * @param transition the transition to compare to, not null
     * @return the comparator value, negative if less, positive if greater
     */
    @Override
    public int compareTo(ZoneOffsetTransition transition) {
        return this.getInstant().compareTo(transition.getInstant());
    }

    // -----------------------------------------------------------------------
    /**
     * Checks if this object equals another.
     * <p>
     * The entire state of the object is compared.
     *
     * @param other the other object to compare to, null returns false
     * @return true if equal
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ZoneOffsetTransition) {
            ZoneOffsetTransition d = (ZoneOffsetTransition) other;
            return transition.equals(d.transition) && offsetBefore.equals(d.offsetBefore) && offsetAfter.equals(d.offsetAfter);
        }
        return false;
    }

    /**
     * Returns a suitable hash code.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return transition.hashCode() ^ offsetBefore.hashCode() ^ Integer.rotateLeft(offsetAfter.hashCode(), 16);
    }

    // -----------------------------------------------------------------------
    /**
     * Returns a string describing this object.
     *
     * @return a string for debugging, not null
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("Transition[")
                .append(isGap() ? "Gap" : "Overlap")
                .append(" at ")
                .append(transition)
                .append(offsetBefore)
                .append(" to ")
                .append(offsetAfter)
                .append(']');
        return buf.toString();
    }
}
