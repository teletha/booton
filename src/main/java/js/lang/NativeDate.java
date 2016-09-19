/*
 * Copyright (C) 2016 Nameless Production Committee
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
     * Creates JavaScript Date instances which let you work with dates and times.
     * </p>
     */
    public NativeDate(long time) {
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
    }

    /**
     * <p>
     * The getFullYear() method returns the year of the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getFullYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * <p>
     * Returns the month (0-11) in the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getMonth() {
        return calendar.get(Calendar.MONTH);
    }

    /**
     * <p>
     * Returns the day of the month (1-31) for the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getDate() {
        return calendar.get(Calendar.DATE);
    }

    /**
     * <p>
     * Returns the hour (0-23) in the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getHours() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * <p>
     * Returns the minutes (0-59) in the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getMinutes() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * <p>
     * Returns the seconds (0-59) in the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getSeconds() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * <p>
     * Returns the milliseconds (0-999) in the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getMillseconds() {
        return calendar.get(Calendar.MILLISECOND);
    }

    /**
     * <p>
     * Returns the day of the week (0-6) for the specified date according to local time.
     * </p>
     * 
     * @return
     */
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_WEEK);
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
     * @version 2014/05/26 16:48:27
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
         * Creates JavaScript Date instances which let you work with dates and times.
         * </p>
         */
        public String NativeDate(long time) {
            return "new Date(" + param(0) + ")";
        }

        /**
         * <p>
         * The getFullYear() method returns the year of the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getFullYear() {
            return that + ".getFullYear()";
        }

        /**
         * <p>
         * Returns the month (0-11) in the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getMonth() {
            return that + ".getMonth()";
        }

        /**
         * <p>
         * Returns the day of the month (1-31) for the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getDate() {
            return that + ".getDate()";
        }

        /**
         * <p>
         * Returns the hour (0-23) in the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getHours() {
            return that + ".getHours()";
        }

        /**
         * <p>
         * Returns the minutes (0-59) in the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getMinutes() {
            return that + ".getMinutes()";
        }

        /**
         * <p>
         * Returns the seconds (0-59) in the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getSeconds() {
            return that + ".getSeconds()";
        }

        /**
         * <p>
         * Returns the milliseconds (0-999) in the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getMillseconds() {
            return that + ".getMillseconds()";
        }

        /**
         * <p>
         * Returns the day of the week (0-6) for the specified date according to local time.
         * </p>
         * 
         * @return
         */
        public String getDay() {
            return that + ".getDay()";
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
            return long64(that + ".getTime()");
        }

        /**
         * <p>
         * Returns the number of milliseconds elapsed since 1 January 1970 00:00:00 UTC.
         * </p>
         * 
         * @return
         */
        public String now() {
            return long64("Date.now()");
        }
    }
}
