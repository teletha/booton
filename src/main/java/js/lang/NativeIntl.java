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

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import booton.translator.Translator;

/**
 * @version 2014/03/09 20:41:43
 */
public class NativeIntl {

    /**
     * @version 2014/03/09 22:53:15
     */
    public static class DateTimeFormat {

        /** The formatter. */
        private final DateTimeFormatter format;

        /**
         * <p>
         * The Intl.DateTimeFormat object is a constructor for objects that enable language
         * sensitive date and time formatting.
         * </p>
         */
        public DateTimeFormat(String locales) {
            format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
        }

        /**
         * <p>
         * The Intl.DateTimeFormat object is a constructor for objects that enable language
         * sensitive date and time formatting.
         * </p>
         */
        public DateTimeFormat(String locales, Option option) {
            format = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT);
        }

        /**
         * <p>
         * Returns a getter function that formats a date according to the locale and formatting
         * options of this DateTimeFormat object.
         * </p>
         * 
         * @param date The date to format.
         * @return
         */
        public String format(Date date) {
            return format.format(date.toInstant());
        }

        /**
         * <p>
         * Returns a getter function that formats a date according to the locale and formatting
         * options of this DateTimeFormat object.
         * </p>
         * 
         * @param date The date to format.
         * @return
         */
        public String format(TemporalAccessor date) {
            return format.format(date);
        }

        /**
         * <p>
         * Returns a getter function that formats a date according to the locale and formatting
         * options of this DateTimeFormat object.
         * </p>
         * 
         * @param date The date to format.
         * @return
         */
        public String format(long date) {
            return format.format(LocalDateTime.ofEpochSecond(date, 0, ZoneOffset.UTC));
        }

        /**
         * @version 2014/04/21 13:28:26
         */
        public static class Option implements JavascriptNative {

            @JavascriptNativeProperty
            public String localeMatcher;

            @JavascriptNativeProperty
            public String formatMatcher;

            @JavascriptNativeProperty
            public boolean hour12;

            @JavascriptNativeProperty
            public String timeZone;

            @JavascriptNativeProperty
            public String weekday;

            @JavascriptNativeProperty
            public String era;

            @JavascriptNativeProperty
            public String year;

            @JavascriptNativeProperty
            public String month;

            @JavascriptNativeProperty
            public String hour;

            @JavascriptNativeProperty
            public String minute;

            @JavascriptNativeProperty
            public String second;
        }

        /**
         * @version 2014/03/09 22:56:14
         */
        @SuppressWarnings("unused")
        private static class Coder extends Translator<DateTimeFormat> {

            /**
             * <p>
             * The Intl.DateTimeFormat object is a constructor for objects that enable language
             * sensitive date and time formatting.
             * </p>
             */
            public String DateTimeFormat(String locales) {
                return "new Intl.DateTimeFormat(" + param(0) + ")";
            }

            /**
             * <p>
             * The Intl.DateTimeFormat object is a constructor for objects that enable language
             * sensitive date and time formatting.
             * </p>
             */
            public String DateTimeFormat(String locales, Option option) {
                return "new Intl.DateTimeFormat(" + param(0) + "," + param(1) + ")";
            }

            /**
             * <p>
             * Returns a getter function that formats a date according to the locale and formatting
             * options of this DateTimeFormat object.
             * </p>
             * 
             * @param date The date to format.
             * @return
             */
            public String format(long date) {
                return that + ".format(" + param(0) + ")";
            }
        }
    }

    /**
     * @version 2014/03/09 20:42:39
     */
    public static class NumberFormat {

        /**
         * <p>
         * The Intl.NumberFormat object is a constructor for objects that enable language sensitive
         * number formatting.
         * </p>
         * 
         * @param locales
         */
        public NumberFormat(String locales) {

        }

        /**
         * @version 2014/03/09 21:00:44
         */
        private static class Coder extends Translator<NumberFormat> {

        }
    }
}
