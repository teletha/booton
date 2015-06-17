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

import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 15:55:13
 */
@JavaAPIProvider(java.time.LocalDateTime.class)
class LocalDateTime {

    /**
     * Converts this date-time to an {@code Instant}.
     * <p>
     * This combines this local date-time and the specified offset to form an {@code Instant}.
     * <p>
     * This default implementation calculates from the epoch-day of the date and the second-of-day
     * of the time.
     *
     * @param offset the offset to use for the conversion, not null
     * @return an {@code Instant} representing the same instant, not null
     */
    public Instant toInstant(ZoneOffset offset) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from an {@code Instant} and zone ID.
     * <p>
     * This creates a local date-time based on the specified instant. First, the offset from
     * UTC/Greenwich is obtained using the zone ID and instant, which is simple as there is only one
     * valid offset for each instant. Then, the instant and offset are used to calculate the local
     * date-time.
     *
     * @param instant the instant to create the date-time from, not null
     * @param zone the time-zone, which may be an offset, not null
     * @return the local date-time, not null
     * @throws DateTimeException if the result exceeds the supported range
     */
    public static LocalDateTime ofInstant(Instant instant, ZoneId zone) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains an instance of {@code LocalDateTime} using seconds from the epoch of
     * 1970-01-01T00:00:00Z.
     * <p>
     * This allows the {@link ChronoField#INSTANT_SECONDS epoch-second} field to be converted to a
     * local date-time. This is primarily intended for low-level conversions rather than general
     * application usage.
     *
     * @param epochSecond the number of seconds from the epoch of 1970-01-01T00:00:00Z
     * @param nanoOfSecond the nanosecond within the second, from 0 to 999,999,999
     * @param offset the zone offset, not null
     * @return the local date-time, not null
     * @throws DateTimeException if the result exceeds the supported range, or if the nano-of-second
     *             is invalid
     */
    public static LocalDateTime ofEpochSecond(long epochSecond, int nanoOfSecond, ZoneOffset offset) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from a text string such as
     * {@code 2007-12-03T10:15:30}.
     * <p>
     * The string must represent a valid date-time and is parsed using
     * {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME}.
     *
     * @param text the text to parse such as "2007-12-03T10:15:30", not null
     * @return the parsed local date-time, not null
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public static LocalDateTime parse(CharSequence text) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
