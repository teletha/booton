/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.time.Instant;

import js.lang.NativeDate;
import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/11 15:45:25
 */
@JavaAPIProvider(java.util.Date.class)
class Date {

    /** The native date. */
    private NativeDate date;

    /**
     * @param time
     */
    private Date(long time) {
        this.date = new NativeDate(time);
    }

    /**
     * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this
     * <tt>Date</tt> object.
     *
     * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this
     *         date.
     */
    public long getTime() {
        return date.getTime();
    }

    /**
     * Obtains an instance of {@code Date} from an {@code Instant} object.
     * <p>
     * {@code Instant} uses a precision of nanoseconds, whereas {@code Date} uses a precision of
     * milliseconds. The conversion will trancate any excess precision information as though the
     * amount in nanoseconds was subject to integer division by one million.
     * <p>
     * {@code Instant} can store points on the time-line further in the future and further in the
     * past than {@code Date}. In this scenario, this method will throw an exception.
     *
     * @param instant the instant to convert
     * @return a {@code Date} representing the same point on the time-line as the provided instant
     * @exception NullPointerException if {@code instant} is null.
     * @exception IllegalArgumentException if the instant is too large to represent as a
     *                {@code Date}
     * @since 1.8
     */
    public static java.util.Date from(Instant instant) {
        try {
            return (java.util.Date) (Object) new Date(instant.toEpochMilli());
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    /**
     * Converts this {@code Date} object to an {@code Instant}.
     * <p>
     * The conversion creates an {@code Instant} that represents the same point on the time-line as
     * this {@code Date}.
     *
     * @return an instant representing the same point on the time-line as this {@code Date} object
     * @since 1.8
     */
    public Instant toInstant() {
        return Instant.ofEpochMilli(getTime());
    }
}
