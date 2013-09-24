/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.Calendar;

import booton.translator.Translator;

/**
 * @version 2013/09/24 22:53:19
 */
public class NativeDate {

    private Calendar calendar;

    /**
     * <p>
     * Creates JavaScript Date instances which let you work with dates and times.
     * </p>
     */
    public NativeDate() {
        calendar = Calendar.getInstance();
    }

    /**
     * <p>
     * Returns the numeric value corresponding to the time for the specified date according to
     * universal time.
     * </p>
     * 
     * @return
     */
    public long getTime() {
        return calendar.getTimeInMillis();
    }

    /**
     * <p>
     * Returns the number of milliseconds elapsed since 1 January 1970 00:00:00 UTC.
     * </p>
     * 
     * @return
     */
    public static long now() {
        return System.currentTimeMillis();
    }

    /**
     * @version 2013/09/24 22:56:20
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativeDate> {

        /**
         * <p>
         * Creates JavaScript Date instances which let you work with dates and times.
         * </p>
         */
        public String NativeDate() {
            return "new Date()";
        }

        /**
         * <p>
         * Returns the numeric value corresponding to the time for the specified date according to
         * universal time.
         * </p>
         * 
         * @return
         */
        public String getTime() {
            return that + ".getTime()";
        }

        /**
         * <p>
         * Returns the number of milliseconds elapsed since 1 January 1970 00:00:00 UTC.
         * </p>
         * 
         * @return
         */
        public String now() {
            return "Date.now()";
        }
    }
}
