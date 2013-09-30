/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import java.util.Date;

import booton.translator.Translator;

/**
 * @version 2013/01/08 12:03:52
 */
class DateCoder extends Translator<Date> {

    /**
     * Allocates a <code>Date</code> object and initializes it so that it represents the time at
     * which it was allocated, measured to the nearest millisecond.
     * 
     * @see java.lang.System#currentTimeMillis()
     */
    public String Date() {
        return "new Date()";
    }

    /**
     * Allocates a <code>Date</code> object and initializes it to represent the specified number of
     * milliseconds since the standard base time known as "the epoch", namely January 1, 1970,
     * 00:00:00 GMT.
     * 
     * @param date the milliseconds since January 1, 1970, 00:00:00 GMT.
     * @see java.lang.System#currentTimeMillis()
     */
    public String Date(long date) {
        return "new Date(" + param(0) + ")";
    }

    /**
     * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this
     * <tt>Date</tt> object.
     * 
     * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this
     *         date.
     */
    public String getTime() {
        return that + ".getTime()";
    }

    /**
     * Return a copy of this object.
     */
    public String clone() {
        return that;
    }
}
