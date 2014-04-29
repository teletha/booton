/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time;

import java.time.DateTimeException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/29 9:51:26
 */
@JavaAPIProvider(java.time.Instant.class)
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

}
