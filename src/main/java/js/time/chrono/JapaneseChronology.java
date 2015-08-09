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

import java.time.chrono.AbstractChronology;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Era;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ValueRange;
import java.util.List;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/09 14:07:53
 */
@JavaAPIProvider(java.time.chrono.JapaneseChronology.class)
class JapaneseChronology extends AbstractChronology {

    /**
     * Singleton instance for Japanese chronology.
     */
    public static final JapaneseChronology INSTANCE = new JapaneseChronology();

    /**
     * {@inheritDoc}
     */
    @Override
    public String getId() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCalendarType() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChronoLocalDate date(int prolepticYear, int month, int dayOfMonth) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChronoLocalDate dateYearDay(int prolepticYear, int dayOfYear) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChronoLocalDate dateEpochDay(long epochDay) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChronoLocalDate date(TemporalAccessor temporal) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isLeapYear(long prolepticYear) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int prolepticYear(Era era, int yearOfEra) {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Era eraOf(int eraValue) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Era> eras() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ValueRange range(ChronoField field) {
        return null;
    }
}
