/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.text;

import java.text.Format;
import java.util.Date;
import java.util.TimeZone;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/07/19 20:45:53
 */
@JavaAPIProvider(java.text.DateFormat.class)
abstract class DateFormat extends Format {

    private boolean lenient;

    /**
     * Formats a Date into a date/time string.
     * 
     * @param date the time value to be formatted into a time string.
     * @return the formatted time string.
     */
    public final String format(Date date) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Sets the time zone for the calendar of this {@code DateFormat} object. This method is
     * equivalent to the following call. <blockquote><pre>{@code
     * getCalendar().setTimeZone(zone)
     * }</pre></blockquote>
     * <p>
     * The {@code TimeZone} set by this method is overwritten by a
     * {@link #setCalendar(java.util.Calendar) setCalendar} call.
     * <p>
     * The {@code TimeZone} set by this method may be overwritten as a result of a call to the parse
     * method.
     *
     * @param zone the given new time zone.
     */
    public void setTimeZone(TimeZone zone) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Specify whether or not date/time parsing is to be lenient. With lenient parsing, the parser
     * may use heuristics to interpret inputs that do not precisely match this object's format. With
     * strict parsing, inputs must match this object's format.
     * <p>
     * This method is equivalent to the following call. <blockquote><pre>{@code
     * getCalendar().setLenient(lenient)
     * }</pre></blockquote>
     * <p>
     * This leniency value is overwritten by a call to {@link #setCalendar(java.util.Calendar)
     * setCalendar()}.
     *
     * @param lenient when {@code true}, parsing is lenient
     * @see java.util.Calendar#setLenient(boolean)
     */
    public void setLenient(boolean lenient) {
        this.lenient = lenient;
    }
}
