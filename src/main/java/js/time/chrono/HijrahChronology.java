/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time.chrono;

import java.time.Clock;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.AbstractChronology;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.chrono.Chronology;
import java.time.chrono.Era;
import java.time.chrono.HijrahDate;
import java.time.chrono.HijrahEra;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/08 23:24:56
 */
@JavaAPIProvider(java.time.chrono.HijrahChronology.class)
public class HijrahChronology extends AbstractChronology {

    /**
     * The Hijrah Calendar id.
     */
    private final transient String typeId;

    /**
     * The Hijrah calendarType.
     */
    private final transient String calendarType;

    /**
     * Singleton instance of the Islamic Umm Al-Qura calendar of Saudi Arabia. Other Hijrah
     * chronology variants may be available from {@link Chronology#getAvailableChronologies}.
     */
    public static final HijrahChronology INSTANCE = new HijrahChronology("");

    /**
     * Array of epoch days indexed by Hijrah Epoch month. Computed by {@link #loadCalendarData}.
     */
    private transient int[] hijrahEpochMonthStartDays;

    /**
     * The minimum epoch day of this Hijrah calendar. Computed by {@link #loadCalendarData}.
     */
    private transient int minEpochDay;

    /**
     * The maximum epoch day for which calendar data is available. Computed by
     * {@link #loadCalendarData}.
     */
    private transient int maxEpochDay;

    /**
     * The minimum epoch month. Computed by {@link #loadCalendarData}.
     */
    private transient int hijrahStartEpochMonth;

    /**
     * The minimum length of a month. Computed by {@link #createEpochMonths}.
     */
    private transient int minMonthLength;

    /**
     * The maximum length of a month. Computed by {@link #createEpochMonths}.
     */
    private transient int maxMonthLength;

    /**
     * The minimum length of a year in days. Computed by {@link #createEpochMonths}.
     */
    private transient int minYearLength;

    /**
     * The maximum length of a year in days. Computed by {@link #createEpochMonths}.
     */
    private transient int maxYearLength;

    /**
     * Static initialization of the predefined calendars found in the lib/calendars.properties file.
     */
    static {
        // try {
        // calendarProperties = sun.util.calendar.BaseCalendar.getCalendarProperties();
        // } catch (IOException ioe) {
        // throw new InternalError("Can't initialize lib/calendars.properties", ioe);
        // }
        //
        // try {
        // INSTANCE = new HijrahChronology("Hijrah-umalqura");
        // // Register it by its aliases
        // AbstractChronology.registerChrono(INSTANCE, "Hijrah");
        // AbstractChronology.registerChrono(INSTANCE, "islamic");
        // } catch (DateTimeException ex) {
        // // Absence of Hijrah calendar is fatal to initializing this class.
        // PlatformLogger logger = PlatformLogger.getLogger("java.time.chrono");
        // logger.severe("Unable to initialize Hijrah calendar: Hijrah-umalqura", ex);
        // throw new RuntimeException("Unable to initialize Hijrah-umalqura calendar",
        // ex.getCause());
        // }
        // registerVariants();
    }

    /**
     * Create a HijrahChronology for the named variant. The resource and calendar type are retrieved
     * from properties in the {@code calendars.properties}. The property names are
     * {@code "calendar.hijrah." + id} and {@code "calendar.hijrah." + id + ".type"}
     * 
     * @param id the id of the calendar
     * @throws DateTimeException if the calendar type is missing from the properties file.
     * @throws IllegalArgumentException if the id is empty
     */
    private HijrahChronology(String id) {
        this.typeId = id;
        this.calendarType = "";
    }

    /**
     * Check and ensure that the calendar data has been initialized. The initialization check is
     * performed at the boundary between public and package methods. If a public calls another
     * public method a check is not necessary in the caller. The constructors of HijrahDate call
     * {@link #getEpochDay} or {@link #getHijrahDateInfo} so every call from HijrahDate to a
     * HijrahChronology via package private methods has been checked.
     *
     * @throws DateTimeException if the calendar data configuration is malformed or IOExceptions
     *             occur loading the data
     */
    private void checkCalendarInit() {
        // // Keep this short so it can be inlined for performance
        // if (initComplete == false) {
        // loadCalendarData();
        // initComplete = true;
        // }
    }

    // -----------------------------------------------------------------------
    /**
     * Gets the ID of the chronology.
     * <p>
     * The ID uniquely identifies the {@code Chronology}. It can be used to lookup the
     * {@code Chronology} using {@link Chronology#of(String)}.
     *
     * @return the chronology ID, non-null
     * @see #getCalendarType()
     */
    @Override
    public String getId() {
        return typeId;
    }

    /**
     * Gets the calendar type of the Islamic calendar.
     * <p>
     * The calendar type is an identifier defined by the
     * <em>Unicode Locale Data Markup Language (LDML)</em> specification. It can be used to lookup
     * the {@code Chronology} using {@link Chronology#of(String)}.
     *
     * @return the calendar system type; non-null if the calendar has a standard type, otherwise
     *         null
     * @see #getId()
     */
    @Override
    public String getCalendarType() {
        return calendarType;
    }

    // -----------------------------------------------------------------------
    /**
     * Obtains a local date in Hijrah calendar system from the era, year-of-era, month-of-year and
     * day-of-month fields.
     *
     * @param era the Hijrah era, not null
     * @param yearOfEra the year-of-era
     * @param month the month-of-year
     * @param dayOfMonth the day-of-month
     * @return the Hijrah local date, not null
     * @throws DateTimeException if unable to create the date
     * @throws ClassCastException if the {@code era} is not a {@code HijrahEra}
     */
    @Override
    public HijrahDate date(Era era, int yearOfEra, int month, int dayOfMonth) {
        return date(prolepticYear(era, yearOfEra), month, dayOfMonth);
    }

    /**
     * Obtains a local date in Hijrah calendar system from the proleptic-year, month-of-year and
     * day-of-month fields.
     *
     * @param prolepticYear the proleptic-year
     * @param month the month-of-year
     * @param dayOfMonth the day-of-month
     * @return the Hijrah local date, not null
     * @throws DateTimeException if unable to create the date
     */
    @Override
    public HijrahDate date(int prolepticYear, int month, int dayOfMonth) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
        // return HijrahDate.of(this, prolepticYear, month, dayOfMonth);
    }

    /**
     * Obtains a local date in Hijrah calendar system from the era, year-of-era and day-of-year
     * fields.
     *
     * @param era the Hijrah era, not null
     * @param yearOfEra the year-of-era
     * @param dayOfYear the day-of-year
     * @return the Hijrah local date, not null
     * @throws DateTimeException if unable to create the date
     * @throws ClassCastException if the {@code era} is not a {@code HijrahEra}
     */
    @Override
    public HijrahDate dateYearDay(Era era, int yearOfEra, int dayOfYear) {
        return dateYearDay(prolepticYear(era, yearOfEra), dayOfYear);
    }

    /**
     * Obtains a local date in Hijrah calendar system from the proleptic-year and day-of-year
     * fields.
     *
     * @param prolepticYear the proleptic-year
     * @param dayOfYear the day-of-year
     * @return the Hijrah local date, not null
     * @throws DateTimeException if the value of the year is out of range, or if the day-of-year is
     *             invalid for the year
     */
    @Override
    public HijrahDate dateYearDay(int prolepticYear, int dayOfYear) {
        // HijrahDate date = HijrahDate.of(this, prolepticYear, 1, 1);
        // if (dayOfYear > date.lengthOfYear()) {
        // throw new DateTimeException("Invalid dayOfYear: " + dayOfYear);
        // }
        // return date.plusDays(dayOfYear - 1);

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains a local date in the Hijrah calendar system from the epoch-day.
     *
     * @param epochDay the epoch day
     * @return the Hijrah local date, not null
     * @throws DateTimeException if unable to create the date
     */
    @Override // override with covariant return type
    public HijrahDate dateEpochDay(long epochDay) {
        // return HijrahDate.ofEpochDay(this, epochDay);

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    @Override
    public HijrahDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override
    public HijrahDate dateNow(ZoneId zone) {
        return dateNow(Clock.system(zone));
    }

    @Override
    public HijrahDate dateNow(Clock clock) {
        return date(LocalDate.now(clock));
    }

    @Override
    public HijrahDate date(TemporalAccessor temporal) {
        // if (temporal instanceof HijrahDate) {
        // return (HijrahDate) temporal;
        // }
        // return HijrahDate.ofEpochDay(this, temporal.getLong(EPOCH_DAY));

        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChronoLocalDateTime<HijrahDate> localDateTime(TemporalAccessor temporal) {
        return (ChronoLocalDateTime<HijrahDate>) super.localDateTime(temporal);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(TemporalAccessor temporal) {
        return (ChronoZonedDateTime<HijrahDate>) super.zonedDateTime(temporal);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ChronoZonedDateTime<HijrahDate> zonedDateTime(Instant instant, ZoneId zone) {
        return (ChronoZonedDateTime<HijrahDate>) super.zonedDateTime(instant, zone);
    }

    // -----------------------------------------------------------------------
    @Override
    public boolean isLeapYear(long prolepticYear) {
        checkCalendarInit();
        int epochMonth = yearToEpochMonth((int) prolepticYear);
        if (epochMonth < 0 || epochMonth > maxEpochDay) {
            throw new DateTimeException("Hijrah date out of range");
        }
        int len = getYearLength((int) prolepticYear);
        return (len > 354);
    }

    @Override
    public int prolepticYear(Era era, int yearOfEra) {
        if (era instanceof HijrahEra == false) {
            throw new ClassCastException("Era must be HijrahEra");
        }
        return yearOfEra;
    }

    @Override
    public HijrahEra eraOf(int eraValue) {
        switch (eraValue) {
        case 1:
            return HijrahEra.AH;
        default:
            throw new DateTimeException("invalid Hijrah era");
        }
    }

    @Override
    public List<Era> eras() {
        return Arrays.<Era> asList(HijrahEra.values());
    }

    // -----------------------------------------------------------------------
    @Override
    public ValueRange range(ChronoField field) {
        checkCalendarInit();
        if (field instanceof ChronoField) {
            ChronoField f = field;
            switch (f) {
            case DAY_OF_MONTH:
                return ValueRange.of(1, 1, getMinimumMonthLength(), getMaximumMonthLength());
            case DAY_OF_YEAR:
                return ValueRange.of(1, getMaximumDayOfYear());
            case ALIGNED_WEEK_OF_MONTH:
                return ValueRange.of(1, 5);
            case YEAR:
            case YEAR_OF_ERA:
                return ValueRange.of(getMinimumYear(), getMaximumYear());
            case ERA:
                return ValueRange.of(1, 1);
            default:
                return field.range();
            }
        }
        return field.range();
    }

    // -----------------------------------------------------------------------
    @Override // override for return type
    public HijrahDate resolveDate(Map<TemporalField, Long> fieldValues, ResolverStyle resolverStyle) {
        return (HijrahDate) super.resolveDate(fieldValues, resolverStyle);
    }

    // -----------------------------------------------------------------------
    /**
     * Check the validity of a year.
     *
     * @param prolepticYear the year to check
     */
    int checkValidYear(long prolepticYear) {
        if (prolepticYear < getMinimumYear() || prolepticYear > getMaximumYear()) {
            throw new DateTimeException("Invalid Hijrah year: " + prolepticYear);
        }
        return (int) prolepticYear;
    }

    void checkValidDayOfYear(int dayOfYear) {
        if (dayOfYear < 1 || dayOfYear > getMaximumDayOfYear()) {
            throw new DateTimeException("Invalid Hijrah day of year: " + dayOfYear);
        }
    }

    void checkValidMonth(int month) {
        if (month < 1 || month > 12) {
            throw new DateTimeException("Invalid Hijrah month: " + month);
        }
    }

    // -----------------------------------------------------------------------
    /**
     * Returns an array containing the Hijrah year, month and day computed from the epoch day.
     *
     * @param epochDay the EpochDay
     * @return int[0] = YEAR, int[1] = MONTH, int[2] = DATE
     */
    int[] getHijrahDateInfo(int epochDay) {
        checkCalendarInit(); // ensure that the chronology is initialized
        if (epochDay < minEpochDay || epochDay >= maxEpochDay) {
            throw new DateTimeException("Hijrah date out of range");
        }

        int epochMonth = epochDayToEpochMonth(epochDay);
        int year = epochMonthToYear(epochMonth);
        int month = epochMonthToMonth(epochMonth);
        int day1 = epochMonthToEpochDay(epochMonth);
        int date = epochDay - day1; // epochDay - dayOfEpoch(year, month);

        int dateInfo[] = new int[3];
        dateInfo[0] = year;
        dateInfo[1] = month + 1; // change to 1-based.
        dateInfo[2] = date + 1; // change to 1-based.
        return dateInfo;
    }

    /**
     * Return the epoch day computed from Hijrah year, month, and day.
     *
     * @param prolepticYear the year to represent, 0-origin
     * @param monthOfYear the month-of-year to represent, 1-origin
     * @param dayOfMonth the day-of-month to represent, 1-origin
     * @return the epoch day
     */
    long getEpochDay(int prolepticYear, int monthOfYear, int dayOfMonth) {
        checkCalendarInit(); // ensure that the chronology is initialized
        checkValidMonth(monthOfYear);
        int epochMonth = yearToEpochMonth(prolepticYear) + (monthOfYear - 1);
        if (epochMonth < 0 || epochMonth >= hijrahEpochMonthStartDays.length) {
            throw new DateTimeException("Invalid Hijrah date, year: " + prolepticYear + ", month: " + monthOfYear);
        }
        if (dayOfMonth < 1 || dayOfMonth > getMonthLength(prolepticYear, monthOfYear)) {
            throw new DateTimeException("Invalid Hijrah day of month: " + dayOfMonth);
        }
        return epochMonthToEpochDay(epochMonth) + (dayOfMonth - 1);
    }

    /**
     * Returns day of year for the year and month.
     *
     * @param prolepticYear a proleptic year
     * @param month a month, 1-origin
     * @return the day of year, 1-origin
     */
    int getDayOfYear(int prolepticYear, int month) {
        return yearMonthToDayOfYear(prolepticYear, (month - 1));
    }

    /**
     * Returns month length for the year and month.
     *
     * @param prolepticYear a proleptic year
     * @param monthOfYear a month, 1-origin.
     * @return the length of the month
     */
    int getMonthLength(int prolepticYear, int monthOfYear) {
        int epochMonth = yearToEpochMonth(prolepticYear) + (monthOfYear - 1);
        if (epochMonth < 0 || epochMonth >= hijrahEpochMonthStartDays.length) {
            throw new DateTimeException("Invalid Hijrah date, year: " + prolepticYear + ", month: " + monthOfYear);
        }
        return epochMonthLength(epochMonth);
    }

    /**
     * Returns year length. Note: The 12th month must exist in the data.
     *
     * @param prolepticYear a proleptic year
     * @return year length in days
     */
    int getYearLength(int prolepticYear) {
        return yearMonthToDayOfYear(prolepticYear, 12);
    }

    /**
     * Return the minimum supported Hijrah year.
     *
     * @return the minimum
     */
    int getMinimumYear() {
        return epochMonthToYear(0);
    }

    /**
     * Return the maximum supported Hijrah ear.
     *
     * @return the minimum
     */
    int getMaximumYear() {
        return epochMonthToYear(hijrahEpochMonthStartDays.length - 1) - 1;
    }

    /**
     * Returns maximum day-of-month.
     *
     * @return maximum day-of-month
     */
    int getMaximumMonthLength() {
        return maxMonthLength;
    }

    /**
     * Returns smallest maximum day-of-month.
     *
     * @return smallest maximum day-of-month
     */
    int getMinimumMonthLength() {
        return minMonthLength;
    }

    /**
     * Returns maximum day-of-year.
     *
     * @return maximum day-of-year
     */
    int getMaximumDayOfYear() {
        return maxYearLength;
    }

    /**
     * Returns smallest maximum day-of-year.
     *
     * @return smallest maximum day-of-year
     */
    int getSmallestMaximumDayOfYear() {
        return minYearLength;
    }

    /**
     * Returns the epochMonth found by locating the epochDay in the table. The epochMonth is the
     * index in the table
     *
     * @param epochDay
     * @return The index of the element of the start of the month containing the epochDay.
     */
    private int epochDayToEpochMonth(int epochDay) {
        // binary search
        int ndx = Arrays.binarySearch(hijrahEpochMonthStartDays, epochDay);
        if (ndx < 0) {
            ndx = -ndx - 2;
        }
        return ndx;
    }

    /**
     * Returns the year computed from the epochMonth
     *
     * @param epochMonth the epochMonth
     * @return the Hijrah Year
     */
    private int epochMonthToYear(int epochMonth) {
        return (epochMonth + hijrahStartEpochMonth) / 12;
    }

    /**
     * Returns the epochMonth for the Hijrah Year.
     *
     * @param year the HijrahYear
     * @return the epochMonth for the beginning of the year.
     */
    private int yearToEpochMonth(int year) {
        return (year * 12) - hijrahStartEpochMonth;
    }

    /**
     * Returns the Hijrah month from the epochMonth.
     *
     * @param epochMonth the epochMonth
     * @return the month of the Hijrah Year
     */
    private int epochMonthToMonth(int epochMonth) {
        return (epochMonth + hijrahStartEpochMonth) % 12;
    }

    /**
     * Returns the epochDay for the start of the epochMonth.
     *
     * @param epochMonth the epochMonth
     * @return the epochDay for the start of the epochMonth.
     */
    private int epochMonthToEpochDay(int epochMonth) {
        return hijrahEpochMonthStartDays[epochMonth];

    }

    /**
     * Returns the day of year for the requested HijrahYear and month.
     *
     * @param prolepticYear the Hijrah year
     * @param month the Hijrah month
     * @return the day of year for the start of the month of the year
     */
    private int yearMonthToDayOfYear(int prolepticYear, int month) {
        int epochMonthFirst = yearToEpochMonth(prolepticYear);
        return epochMonthToEpochDay(epochMonthFirst + month) - epochMonthToEpochDay(epochMonthFirst);
    }

    /**
     * Returns the length of the epochMonth. It is computed from the start of the following month
     * minus the start of the requested month.
     *
     * @param epochMonth the epochMonth; assumed to be within range
     * @return the length in days of the epochMonth
     */
    private int epochMonthLength(int epochMonth) {
        // The very last entry in the epochMonth table is not the start of a month
        return hijrahEpochMonthStartDays[epochMonth + 1] - hijrahEpochMonthStartDays[epochMonth];
    }
}
