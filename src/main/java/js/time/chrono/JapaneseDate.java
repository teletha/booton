/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time.chrono;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseEra;
import java.time.temporal.TemporalField;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/09 14:02:17
 */
@JavaAPIProvider(java.time.chrono.JapaneseDate.class)
class JapaneseDate extends ChronoLocalDateImpl<JapaneseDate> {

    /**
     * The first day supported by the JapaneseChronology is Meiji 6, January 1st.
     */
    static final LocalDate MEIJI_6_ISODATE = LocalDate.of(1873, 1, 1);

    /**
     * {@inheritDoc}
     */
    @Override
    public Chronology getChronology() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int lengthOfMonth() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChronoPeriod until(ChronoLocalDate endDateExclusive) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLong(TemporalField field) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    JapaneseDate plusYears(long yearsToAdd) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    JapaneseDate plusMonths(long monthsToAdd) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    JapaneseDate plusDays(long daysToAdd) {
        return null;
    }

    /**
     * Obtains a {@code JapaneseDate} representing a date in the Japanese calendar system from the
     * era, year-of-era, month-of-year and day-of-month fields.
     * <p>
     * This returns a {@code JapaneseDate} with the specified fields. The day must be valid for the
     * year and month, otherwise an exception will be thrown.
     * <p>
     * The Japanese month and day-of-month are the same as those in the ISO calendar system. They
     * are not reset when the era changes. For example: <pre>
     *  6th Jan Showa 64 = ISO 1989-01-06
     *  7th Jan Showa 64 = ISO 1989-01-07
     *  8th Jan Heisei 1 = ISO 1989-01-08
     *  9th Jan Heisei 1 = ISO 1989-01-09
     * </pre>
     *
     * @param era the Japanese era, not null
     * @param yearOfEra the Japanese year-of-era
     * @param month the Japanese month-of-year, from 1 to 12
     * @param dayOfMonth the Japanese day-of-month, from 1 to 31
     * @return the date in Japanese calendar system, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-month
     *             is invalid for the month-year, or if the date is not a Japanese era
     */
    public static JapaneseDate of(JapaneseEra era, int yearOfEra, int month, int dayOfMonth) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains a {@code JapaneseDate} representing a date in the Japanese calendar system from the
     * era, year-of-era and day-of-year fields.
     * <p>
     * This returns a {@code JapaneseDate} with the specified fields. The day must be valid for the
     * year, otherwise an exception will be thrown.
     * <p>
     * The day-of-year in this factory is expressed relative to the start of the year-of-era. This
     * definition changes the normal meaning of day-of-year only in those years where the
     * year-of-era is reset to one due to a change in the era. For example: <pre>
     *  6th Jan Showa 64 = day-of-year 6
     *  7th Jan Showa 64 = day-of-year 7
     *  8th Jan Heisei 1 = day-of-year 1
     *  9th Jan Heisei 1 = day-of-year 2
     * </pre>
     *
     * @param era the Japanese era, not null
     * @param yearOfEra the Japanese year-of-era
     * @param dayOfYear the chronology day-of-year, from 1 to 366
     * @return the date in Japanese calendar system, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-year is
     *             invalid for the year
     */
    static JapaneseDate ofYearDay(JapaneseEra era, int yearOfEra, int dayOfYear) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
