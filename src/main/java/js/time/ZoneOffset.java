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

import static js.time.LocalTime.*;

import java.time.DateTimeException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/29 9:40:57
 */
@JavaAPIProvider(java.time.ZoneOffset.class)
class ZoneOffset {

    /** Cache of time-zone offset by offset in seconds. */
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap<>(16, 0.75f, 4);

    /** Cache of time-zone offset by ID. */
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap<>(16, 0.75f, 4);

    /**
     * The abs maximum seconds.
     */
    private static final int MAX_SECONDS = 18 * SECONDS_PER_HOUR;

    /**
     * The time-zone offset for UTC, with an ID of 'Z'.
     */
    public static final ZoneOffset UTC = ZoneOffset.ofTotalSeconds(0);

    /**
     * The total offset in seconds.
     */
    private final int totalSeconds;

    /**
     * The string form of the time-zone offset.
     */
    private final transient String id;

    /**
     * Constructor.
     *
     * @param totalSeconds the total time-zone offset in seconds, from -64800 to +64800
     */
    private ZoneOffset(int totalSeconds) {
        this.totalSeconds = totalSeconds;
        this.id = buildId(totalSeconds);
    }

    /**
     * Gets the total zone offset in seconds.
     * <p>
     * This is the primary way to access the offset amount. It returns the total of the hours,
     * minutes and seconds fields as a single offset that can be added to a time.
     *
     * @return the total zone offset amount in seconds
     */
    public int getTotalSeconds() {
        return totalSeconds;
    }

    /**
     * Gets the normalized zone offset ID.
     * <p>
     * The ID is minor variation to the standard ISO-8601 formatted string for the offset. There are
     * three formats:
     * <ul>
     * <li>{@code Z} - for UTC (ISO-8601)
     * <li>{@code +hh:mm} or {@code -hh:mm} - if the seconds are zero (ISO-8601)
     * <li>{@code +hh:mm:ss} or {@code -hh:mm:ss} - if the seconds are non-zero (not ISO-8601)
     * </ul>
     *
     * @return the zone offset ID, not null
     */
    public String getId() {
        return id;
    }

    /**
     * Obtains an instance of {@code ZoneOffset} specifying the total offset in seconds
     * <p>
     * The offset must be in the range {@code -18:00} to {@code +18:00}, which corresponds to -64800
     * to +64800.
     *
     * @param totalSeconds the total time-zone offset in seconds, from -64800 to +64800
     * @return the ZoneOffset, not null
     * @throws DateTimeException if the offset is not in the required range
     */
    public static ZoneOffset ofTotalSeconds(int totalSeconds) {
        if (Math.abs(totalSeconds) > MAX_SECONDS) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (totalSeconds % (15 * SECONDS_PER_MINUTE) == 0) {
            Integer totalSecs = totalSeconds;
            ZoneOffset result = SECONDS_CACHE.get(totalSecs);
            if (result == null) {
                result = new ZoneOffset(totalSeconds);
                SECONDS_CACHE.putIfAbsent(totalSecs, result);
                result = SECONDS_CACHE.get(totalSecs);
                ID_CACHE.putIfAbsent(result.getId(), result);
            }
            return result;
        } else {
            return new ZoneOffset(totalSeconds);
        }
    }

    private static String buildId(int totalSeconds) {
        if (totalSeconds == 0) {
            return "Z";
        } else {
            int absTotalSeconds = Math.abs(totalSeconds);
            StringBuilder buf = new StringBuilder();
            int absHours = absTotalSeconds / SECONDS_PER_HOUR;
            int absMinutes = (absTotalSeconds / SECONDS_PER_MINUTE) % MINUTES_PER_HOUR;
            buf.append(totalSeconds < 0 ? "-" : "+")
                    .append(absHours < 10 ? "0" : "")
                    .append(absHours)
                    .append(absMinutes < 10 ? ":0" : ":")
                    .append(absMinutes);
            int absSeconds = absTotalSeconds % SECONDS_PER_MINUTE;
            if (absSeconds != 0) {
                buf.append(absSeconds < 10 ? ":0" : ":").append(absSeconds);
            }
            return buf.toString();
        }
    }
}
