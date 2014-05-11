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

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 16:23:42
 */
@JavaAPIProvider(java.time.LocalTime.class)
class LocalTime {

    /**
     * The minimum supported {@code LocalTime}, '00:00'. This is the time of midnight at the start
     * of the day.
     */
    public static final LocalTime MIN;

    /**
     * The maximum supported {@code LocalTime}, '23:59:59.999999999'. This is the time just before
     * midnight at the end of the day.
     */
    public static final LocalTime MAX;

    /**
     * The time of midnight at the start of the day, '00:00'.
     */
    public static final LocalTime MIDNIGHT;

    /**
     * The time of noon in the middle of the day, '12:00'.
     */
    public static final LocalTime NOON;

    /**
     * Constants for the local time of each hour.
     */
    private static final LocalTime[] HOURS = new LocalTime[24];
    static {
        for (int i = 0; i < HOURS.length; i++) {
            HOURS[i] = new LocalTime(i, 0, 0, 0);
        }
        MIDNIGHT = HOURS[0];
        NOON = HOURS[12];
        MIN = HOURS[0];
        MAX = new LocalTime(23, 59, 59, 999_999_999);
    }

    /**
     * Hours per day.
     */
    static final int HOURS_PER_DAY = 24;

    /**
     * Minutes per hour.
     */
    static final int MINUTES_PER_HOUR = 60;

    /**
     * Minutes per day.
     */
    static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;

    /**
     * Seconds per minute.
     */
    static final int SECONDS_PER_MINUTE = 60;

    /**
     * Seconds per hour.
     */
    static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

    /**
     * Seconds per day.
     */
    static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;

    /**
     * Milliseconds per day.
     */
    static final long MILLIS_PER_DAY = SECONDS_PER_DAY * 1000L;

    /**
     * Microseconds per day.
     */
    static final long MICROS_PER_DAY = SECONDS_PER_DAY * 1000_000L;

    /**
     * Nanos per second.
     */
    static final long NANOS_PER_SECOND = 1000_000_000L;

    /**
     * Nanos per minute.
     */
    static final long NANOS_PER_MINUTE = NANOS_PER_SECOND * SECONDS_PER_MINUTE;

    /**
     * Nanos per hour.
     */
    static final long NANOS_PER_HOUR = NANOS_PER_MINUTE * MINUTES_PER_HOUR;

    /**
     * Nanos per day.
     */
    static final long NANOS_PER_DAY = NANOS_PER_HOUR * HOURS_PER_DAY;

    /**
     * The hour.
     */
    private final byte hour;

    /**
     * The minute.
     */
    private final byte minute;

    /**
     * The second.
     */
    private final byte second;

    /**
     * The nanosecond.
     */
    private final int nano;

    /**
     * Constructor, previously validated.
     *
     * @param hour the hour-of-day to represent, validated from 0 to 23
     * @param minute the minute-of-hour to represent, validated from 0 to 59
     * @param second the second-of-minute to represent, validated from 0 to 59
     * @param nanoOfSecond the nano-of-second to represent, validated from 0 to 999,999,999
     */
    private LocalTime(int hour, int minute, int second, int nanoOfSecond) {
        this.hour = (byte) hour;
        this.minute = (byte) minute;
        this.second = (byte) second;
        this.nano = nanoOfSecond;
    }
}
