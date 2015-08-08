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

import static java.time.temporal.ChronoField.*;
import static js.time.LocalTime.*;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Objects;

import js.lang.NativeDate;

/**
 * @version 2014/04/29 9:51:26
 */
// @JavaAPIProvider(java.time.Instant.class)
class Instant {

    /**
     * Constant for the 1970-01-01T00:00:00Z epoch instant.
     */
    public static final Instant EPOCH = new Instant(0, 0);

    /**
     * The minimum supported epoch second.
     */
    private static final long MIN_SECOND = -31557014167219200L;

    /**
     * The maximum supported epoch second.
     */
    private static final long MAX_SECOND = 31556889864403199L;

    /**
     * The number of seconds from the epoch of 1970-01-01T00:00:00Z.
     */
    private final long seconds;

    /**
     * The number of nanoseconds, later along the time-line, from the seconds field. This is always
     * positive, and never exceeds 999,999,999.
     */
    private final int nanos;

    /**
     * Constructs an instance of {@code Instant} using seconds from the epoch of
     * 1970-01-01T00:00:00Z and nanosecond fraction of second.
     *
     * @param epochSecond the number of seconds from 1970-01-01T00:00:00Z
     * @param nanos the nanoseconds within the second, must be positive
     */
    private Instant(long epochSecond, int nanos) {
        this.seconds = epochSecond;
        this.nanos = nanos;
    }

    /**
     * Converts this instant to the number of milliseconds from the epoch of 1970-01-01T00:00:00Z.
     * <p>
     * If this instant represents a point on the time-line too far in the future or past to fit in a
     * {@code long} milliseconds, then an exception is thrown.
     * <p>
     * If this instant has greater than millisecond precision, then the conversion will drop any
     * excess precision information as though the amount in nanoseconds was subject to integer
     * division by one million.
     *
     * @return the number of milliseconds since the epoch of 1970-01-01T00:00:00Z
     * @throws ArithmeticException if numeric overflow occurs
     */
    public long toEpochMilli() {
        long millis = Math.multiplyExact(seconds, 1000);
        return millis + nanos / 1000_000;
    }

    /**
     * Obtains an instance of {@code Instant} using milliseconds from the epoch of
     * 1970-01-01T00:00:00Z.
     * <p>
     * The seconds and nanoseconds are extracted from the specified milliseconds.
     *
     * @param epochMilli the number of milliseconds from 1970-01-01T00:00:00Z
     * @return an instant, not null
     * @throws DateTimeException if the instant exceeds the maximum or minimum instant
     */
    public static Instant ofEpochMilli(long epochMilli) {
        long secs = Math.floorDiv(epochMilli, 1000);
        int mos = (int) Math.floorMod(epochMilli, 1000);
        return create(secs, mos * 1000_000);
    }

    /**
     * Obtains an instance of {@code Instant} using seconds and nanoseconds.
     *
     * @param seconds the length of the duration in seconds
     * @param nanoOfSecond the nano-of-second, from 0 to 999,999,999
     * @throws DateTimeException if the instant exceeds the maximum or minimum instant
     */
    private static Instant create(long seconds, int nanoOfSecond) {
        if ((seconds | nanoOfSecond) == 0) {
            return EPOCH;
        }
        if (seconds < MIN_SECOND || seconds > MAX_SECOND) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(seconds, nanoOfSecond);
    }

    /**
     * Obtains the current instant from the system clock.
     * <p>
     * This will query the {@link Clock#systemUTC() system UTC clock} to obtain the current instant.
     * <p>
     * Using this method will prevent the ability to use an alternate time-source for testing
     * because the clock is effectively hard-coded.
     *
     * @return the current instant using the system clock, not null
     */
    public static Instant now() {
        return new Instant(NativeDate.now(), 0);
    }

    // -----------------------------------------------------------------------
    /**
     * Obtains an instance of {@code Instant} from a temporal object.
     * <p>
     * This obtains an instant based on the specified temporal. A {@code TemporalAccessor}
     * represents an arbitrary set of date and time information, which this factory converts to an
     * instance of {@code Instant}.
     * <p>
     * The conversion extracts the {@link ChronoField#INSTANT_SECONDS INSTANT_SECONDS} and
     * {@link ChronoField#NANO_OF_SECOND NANO_OF_SECOND} fields.
     * <p>
     * This method matches the signature of the functional interface {@link TemporalQuery} allowing
     * it to be used as a query via method reference, {@code Instant::from}.
     *
     * @param temporal the temporal object to convert, not null
     * @return the instant, not null
     * @throws DateTimeException if unable to convert to an {@code Instant}
     */
    public static Instant from(TemporalAccessor temporal) {
        if (temporal instanceof Instant) {
            return (Instant) temporal;
        }
        Objects.requireNonNull(temporal, "temporal");
        try {
            long instantSecs = temporal.getLong(INSTANT_SECONDS);
            int nanoOfSecond = temporal.get(NANO_OF_SECOND);
            return Instant.ofEpochSecond(instantSecs, nanoOfSecond);
        } catch (DateTimeException ex) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + temporal + " of type " + temporal.getClass()
                    .getName(), ex);
        }
    }

    /**
     * Obtains an instance of {@code Instant} using seconds from the epoch of 1970-01-01T00:00:00Z.
     * <p>
     * The nanosecond field is set to zero.
     *
     * @param epochSecond the number of seconds from 1970-01-01T00:00:00Z
     * @return an instant, not null
     * @throws DateTimeException if the instant exceeds the maximum or minimum instant
     */
    public static Instant ofEpochSecond(long epochSecond) {
        return create(epochSecond, 0);
    }

    /**
     * Obtains an instance of {@code Instant} using seconds from the epoch of 1970-01-01T00:00:00Z
     * and nanosecond fraction of second.
     * <p>
     * This method allows an arbitrary number of nanoseconds to be passed in. The factory will alter
     * the values of the second and nanosecond in order to ensure that the stored nanosecond is in
     * the range 0 to 999,999,999. For example, the following will result in the exactly the same
     * instant: <pre>
     *  Instant.ofEpochSecond(3, 1);
     *  Instant.ofEpochSecond(4, -999_999_999);
     *  Instant.ofEpochSecond(2, 1000_000_001);
     * </pre>
     *
     * @param epochSecond the number of seconds from 1970-01-01T00:00:00Z
     * @param nanoAdjustment the nanosecond adjustment to the number of seconds, positive or
     *            negative
     * @return an instant, not null
     * @throws DateTimeException if the instant exceeds the maximum or minimum instant
     * @throws ArithmeticException if numeric overflow occurs
     */
    public static Instant ofEpochSecond(long epochSecond, long nanoAdjustment) {
        long secs = Math.addExact(epochSecond, Math.floorDiv(nanoAdjustment, NANOS_PER_SECOND));
        int nos = (int) Math.floorMod(nanoAdjustment, NANOS_PER_SECOND);
        return create(secs, nos);
    }

}
