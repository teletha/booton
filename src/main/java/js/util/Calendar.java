/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 14:31:15
 */
@JavaAPIProvider(java.util.Calendar.class)
class Calendar {

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the era, e.g., AD or BC in
     * the Julian calendar. This is a calendar-specific value; see subclass documentation.
     *
     * @see GregorianCalendar#AD
     * @see GregorianCalendar#BC
     */
    public final static int ERA = 0;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the year. This is a
     * calendar-specific value; see subclass documentation.
     */
    public final static int YEAR = 1;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the month. This is a
     * calendar-specific value. The first month of the year in the Gregorian and Julian calendars is
     * <code>JANUARY</code> which is 0; the last depends on the number of months in a year.
     *
     * @see #JANUARY
     * @see #FEBRUARY
     * @see #MARCH
     * @see #APRIL
     * @see #MAY
     * @see #JUNE
     * @see #JULY
     * @see #AUGUST
     * @see #SEPTEMBER
     * @see #OCTOBER
     * @see #NOVEMBER
     * @see #DECEMBER
     * @see #UNDECIMBER
     */
    public final static int MONTH = 2;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the week number within the
     * current year. The first week of the year, as defined by <code>getFirstDayOfWeek()</code> and
     * <code>getMinimalDaysInFirstWeek()</code>, has value 1. Subclasses define the value of
     * <code>WEEK_OF_YEAR</code> for days before the first week of the year.
     *
     * @see #getFirstDayOfWeek
     * @see #getMinimalDaysInFirstWeek
     */
    public final static int WEEK_OF_YEAR = 3;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the week number within the
     * current month. The first week of the month, as defined by <code>getFirstDayOfWeek()</code>
     * and <code>getMinimalDaysInFirstWeek()</code>, has value 1. Subclasses define the value of
     * <code>WEEK_OF_MONTH</code> for days before the first week of the month.
     *
     * @see #getFirstDayOfWeek
     * @see #getMinimalDaysInFirstWeek
     */
    public final static int WEEK_OF_MONTH = 4;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the day of the month. This
     * is a synonym for <code>DAY_OF_MONTH</code>. The first day of the month has value 1.
     *
     * @see #DAY_OF_MONTH
     */
    public final static int DATE = 5;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the day of the month. This
     * is a synonym for <code>DATE</code>. The first day of the month has value 1.
     *
     * @see #DATE
     */
    public final static int DAY_OF_MONTH = 5;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the day number within the
     * current year. The first day of the year has value 1.
     */
    public final static int DAY_OF_YEAR = 6;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the day of the week. This
     * field takes values <code>SUNDAY</code>, <code>MONDAY</code>, <code>TUESDAY</code>,
     * <code>WEDNESDAY</code>, <code>THURSDAY</code>, <code>FRIDAY</code>, and <code>SATURDAY</code>
     * .
     *
     * @see #SUNDAY
     * @see #MONDAY
     * @see #TUESDAY
     * @see #WEDNESDAY
     * @see #THURSDAY
     * @see #FRIDAY
     * @see #SATURDAY
     */
    public final static int DAY_OF_WEEK = 7;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the ordinal number of the
     * day of the week within the current month. Together with the <code>DAY_OF_WEEK</code> field,
     * this uniquely specifies a day within a month. Unlike <code>WEEK_OF_MONTH</code> and
     * <code>WEEK_OF_YEAR</code>, this field's value does <em>not</em> depend on
     * <code>getFirstDayOfWeek()</code> or <code>getMinimalDaysInFirstWeek()</code>.
     * <code>DAY_OF_MONTH 1</code> through <code>7</code> always correspond to
     * <code>DAY_OF_WEEK_IN_MONTH
     * 1</code>; <code>8</code> through <code>14</code> correspond to
     * <code>DAY_OF_WEEK_IN_MONTH 2</code>, and so on. <code>DAY_OF_WEEK_IN_MONTH 0</code> indicates
     * the week before <code>DAY_OF_WEEK_IN_MONTH 1</code>. Negative values count back from the end
     * of the month, so the last Sunday of a month is specified as
     * <code>DAY_OF_WEEK = SUNDAY, DAY_OF_WEEK_IN_MONTH = -1</code>. Because negative values count
     * backward they will usually be aligned differently within the month than positive values. For
     * example, if a month has 31 days, <code>DAY_OF_WEEK_IN_MONTH -1</code> will overlap
     * <code>DAY_OF_WEEK_IN_MONTH 5</code> and the end of <code>4</code>.
     *
     * @see #DAY_OF_WEEK
     * @see #WEEK_OF_MONTH
     */
    public final static int DAY_OF_WEEK_IN_MONTH = 8;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating whether the
     * <code>HOUR</code> is before or after noon. E.g., at 10:04:15.250 PM the <code>AM_PM</code> is
     * <code>PM</code>.
     *
     * @see #AM
     * @see #PM
     * @see #HOUR
     */
    public final static int AM_PM = 9;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the hour of the morning or
     * afternoon. <code>HOUR</code> is used for the 12-hour clock (0 - 11). Noon and midnight are
     * represented by 0, not by 12. E.g., at 10:04:15.250 PM the <code>HOUR</code> is 10.
     *
     * @see #AM_PM
     * @see #HOUR_OF_DAY
     */
    public final static int HOUR = 10;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the hour of the day.
     * <code>HOUR_OF_DAY</code> is used for the 24-hour clock. E.g., at 10:04:15.250 PM the
     * <code>HOUR_OF_DAY</code> is 22.
     *
     * @see #HOUR
     */
    public final static int HOUR_OF_DAY = 11;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the minute within the hour.
     * E.g., at 10:04:15.250 PM the <code>MINUTE</code> is 4.
     */
    public final static int MINUTE = 12;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the second within the
     * minute. E.g., at 10:04:15.250 PM the <code>SECOND</code> is 15.
     */
    public final static int SECOND = 13;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the millisecond within the
     * second. E.g., at 10:04:15.250 PM the <code>MILLISECOND</code> is 250.
     */
    public final static int MILLISECOND = 14;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the raw offset from GMT in
     * milliseconds.
     * <p>
     * This field reflects the correct GMT offset value of the time zone of this
     * <code>Calendar</code> if the <code>TimeZone</code> implementation subclass supports
     * historical GMT offset changes.
     */
    public final static int ZONE_OFFSET = 15;

    /**
     * Field number for <code>get</code> and <code>set</code> indicating the daylight saving offset
     * in milliseconds.
     * <p>
     * This field reflects the correct daylight saving offset value of the time zone of this
     * <code>Calendar</code> if the <code>TimeZone</code> implementation subclass supports
     * historical Daylight Saving Time schedule changes.
     */
    public final static int DST_OFFSET = 16;

    /**
     * The number of distinct fields recognized by <code>get</code> and <code>set</code>. Field
     * numbers range from <code>0..FIELD_COUNT-1</code>.
     */
    public final static int FIELD_COUNT = 17;

    /**
     * Value of the {@link #DAY_OF_WEEK} field indicating Sunday.
     */
    public final static int SUNDAY = 1;

    /**
     * Value of the {@link #DAY_OF_WEEK} field indicating Monday.
     */
    public final static int MONDAY = 2;

    /**
     * Value of the {@link #DAY_OF_WEEK} field indicating Tuesday.
     */
    public final static int TUESDAY = 3;

    /**
     * Value of the {@link #DAY_OF_WEEK} field indicating Wednesday.
     */
    public final static int WEDNESDAY = 4;

    /**
     * Value of the {@link #DAY_OF_WEEK} field indicating Thursday.
     */
    public final static int THURSDAY = 5;

    /**
     * Value of the {@link #DAY_OF_WEEK} field indicating Friday.
     */
    public final static int FRIDAY = 6;

    /**
     * Value of the {@link #DAY_OF_WEEK} field indicating Saturday.
     */
    public final static int SATURDAY = 7;

    /**
     * Value of the {@link #MONTH} field indicating the first month of the year in the Gregorian and
     * Julian calendars.
     */
    public final static int JANUARY = 0;

    /**
     * Value of the {@link #MONTH} field indicating the second month of the year in the Gregorian
     * and Julian calendars.
     */
    public final static int FEBRUARY = 1;

    /**
     * Value of the {@link #MONTH} field indicating the third month of the year in the Gregorian and
     * Julian calendars.
     */
    public final static int MARCH = 2;

    /**
     * Value of the {@link #MONTH} field indicating the fourth month of the year in the Gregorian
     * and Julian calendars.
     */
    public final static int APRIL = 3;

    /**
     * Value of the {@link #MONTH} field indicating the fifth month of the year in the Gregorian and
     * Julian calendars.
     */
    public final static int MAY = 4;

    /**
     * Value of the {@link #MONTH} field indicating the sixth month of the year in the Gregorian and
     * Julian calendars.
     */
    public final static int JUNE = 5;

    /**
     * Value of the {@link #MONTH} field indicating the seventh month of the year in the Gregorian
     * and Julian calendars.
     */
    public final static int JULY = 6;

    /**
     * Value of the {@link #MONTH} field indicating the eighth month of the year in the Gregorian
     * and Julian calendars.
     */
    public final static int AUGUST = 7;

    /**
     * Value of the {@link #MONTH} field indicating the ninth month of the year in the Gregorian and
     * Julian calendars.
     */
    public final static int SEPTEMBER = 8;

    /**
     * Value of the {@link #MONTH} field indicating the tenth month of the year in the Gregorian and
     * Julian calendars.
     */
    public final static int OCTOBER = 9;

    /**
     * Value of the {@link #MONTH} field indicating the eleventh month of the year in the Gregorian
     * and Julian calendars.
     */
    public final static int NOVEMBER = 10;

    /**
     * Value of the {@link #MONTH} field indicating the twelfth month of the year in the Gregorian
     * and Julian calendars.
     */
    public final static int DECEMBER = 11;

    /**
     * Value of the {@link #MONTH} field indicating the thirteenth month of the year. Although
     * <code>GregorianCalendar</code> does not use this value, lunar calendars do.
     */
    public final static int UNDECIMBER = 12;

    /**
     * Value of the {@link #AM_PM} field indicating the period of the day from midnight to just
     * before noon.
     */
    public final static int AM = 0;

    /**
     * Value of the {@link #AM_PM} field indicating the period of the day from noon to just before
     * midnight.
     */
    public final static int PM = 1;

    /**
     * A style specifier for {@link #getDisplayNames(int, int, Locale) getDisplayNames} indicating
     * names in all styles, such as "January" and "Jan".
     *
     * @see #SHORT_FORMAT
     * @see #LONG_FORMAT
     * @see #SHORT_STANDALONE
     * @see #LONG_STANDALONE
     * @see #SHORT
     * @see #LONG
     * @since 1.6
     */
    public static final int ALL_STYLES = 0;

    static final int STANDALONE_MASK = 0x8000;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} equivalent to
     * {@link #SHORT_FORMAT}.
     *
     * @see #SHORT_STANDALONE
     * @see #LONG
     * @since 1.6
     */
    public static final int SHORT = 1;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} equivalent to {@link #LONG_FORMAT}
     * .
     *
     * @see #LONG_STANDALONE
     * @see #SHORT
     * @since 1.6
     */
    public static final int LONG = 2;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} indicating a narrow name used for
     * format. Narrow names are typically single character strings, such as "M" for Monday.
     *
     * @see #NARROW_STANDALONE
     * @see #SHORT_FORMAT
     * @see #LONG_FORMAT
     * @since 1.8
     */
    public static final int NARROW_FORMAT = 4;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} indicating a narrow name
     * independently. Narrow names are typically single character strings, such as "M" for Monday.
     *
     * @see #NARROW_FORMAT
     * @see #SHORT_STANDALONE
     * @see #LONG_STANDALONE
     * @since 1.8
     */
    public static final int NARROW_STANDALONE = NARROW_FORMAT | STANDALONE_MASK;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} indicating a short name used for
     * format.
     *
     * @see #SHORT_STANDALONE
     * @see #LONG_FORMAT
     * @see #LONG_STANDALONE
     * @since 1.8
     */
    public static final int SHORT_FORMAT = 1;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} indicating a long name used for
     * format.
     *
     * @see #LONG_STANDALONE
     * @see #SHORT_FORMAT
     * @see #SHORT_STANDALONE
     * @since 1.8
     */
    public static final int LONG_FORMAT = 2;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} indicating a short name used
     * independently, such as a month abbreviation as calendar headers.
     *
     * @see #SHORT_FORMAT
     * @see #LONG_FORMAT
     * @see #LONG_STANDALONE
     * @since 1.8
     */
    public static final int SHORT_STANDALONE = SHORT | STANDALONE_MASK;

    /**
     * A style specifier for {@link #getDisplayName(int, int, Locale) getDisplayName} and
     * {@link #getDisplayNames(int, int, Locale) getDisplayNames} indicating a long name used
     * independently, such as a month name as calendar headers.
     *
     * @see #LONG_FORMAT
     * @see #SHORT_FORMAT
     * @see #SHORT_STANDALONE
     * @since 1.8
     */
    public static final int LONG_STANDALONE = LONG | STANDALONE_MASK;

    private long time;

    private boolean lenient;

    private TimeZone zone;

    /**
     * Gets what the first day of the week is; e.g., <code>SUNDAY</code> in the U.S.,
     * <code>MONDAY</code> in France.
     *
     * @return the first day of the week.
     * @see #setFirstDayOfWeek(int)
     * @see #getMinimalDaysInFirstWeek()
     */
    public int getFirstDayOfWeek() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Gets what the minimal days required in the first week of the year are; e.g., if the first
     * week is defined as one that contains the first day of the first month of a year, this method
     * returns 1. If the minimal days required must be a full week, this method returns 7.
     *
     * @return the minimal days required in the first week of the year.
     * @see #setMinimalDaysInFirstWeek(int)
     */
    public int getMinimalDaysInFirstWeek() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the minimum value for the given calendar field of this <code>Calendar</code>
     * instance. The minimum value is defined as the smallest value returned by the {@link #get(int)
     * get} method for any possible time value. The minimum value depends on calendar system
     * specific parameters of the instance.
     *
     * @param field the calendar field.
     * @return the minimum value for the given calendar field.
     * @see #getMaximum(int)
     * @see #getGreatestMinimum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    public int getMinimum(int field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the maximum value for the given calendar field of this <code>Calendar</code>
     * instance. The maximum value is defined as the largest value returned by the {@link #get(int)
     * get} method for any possible time value. The maximum value depends on calendar system
     * specific parameters of the instance.
     *
     * @param field the calendar field.
     * @return the maximum value for the given calendar field.
     * @see #getMinimum(int)
     * @see #getGreatestMinimum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    public int getMaximum(int field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the highest minimum value for the given calendar field of this <code>Calendar</code>
     * instance. The highest minimum value is defined as the largest value returned by
     * {@link #getActualMinimum(int)} for any possible time value. The greatest minimum value
     * depends on calendar system specific parameters of the instance.
     *
     * @param field the calendar field.
     * @return the highest minimum value for the given calendar field.
     * @see #getMinimum(int)
     * @see #getMaximum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    public int getGreatestMinimum(int field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the lowest maximum value for the given calendar field of this <code>Calendar</code>
     * instance. The lowest maximum value is defined as the smallest value returned by
     * {@link #getActualMaximum(int)} for any possible time value. The least maximum value depends
     * on calendar system specific parameters of the instance. For example, a <code>Calendar</code>
     * for the Gregorian calendar system returns 28 for the <code>DAY_OF_MONTH</code> field, because
     * the 28th is the last day of the shortest month of this calendar, February in a common year.
     *
     * @param field the calendar field.
     * @return the lowest maximum value for the given calendar field.
     * @see #getMinimum(int)
     * @see #getMaximum(int)
     * @see #getGreatestMinimum(int)
     * @see #getActualMinimum(int)
     * @see #getActualMaximum(int)
     */
    public int getLeastMaximum(int field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the minimum value that the specified calendar field could have, given the time value
     * of this <code>Calendar</code>.
     * <p>
     * The default implementation of this method uses an iterative algorithm to determine the actual
     * minimum value for the calendar field. Subclasses should, if possible, override this with a
     * more efficient implementation - in many cases, they can simply return
     * <code>getMinimum()</code>.
     *
     * @param field the calendar field
     * @return the minimum of the given calendar field for the time value of this
     *         <code>Calendar</code>
     * @see #getMinimum(int)
     * @see #getMaximum(int)
     * @see #getGreatestMinimum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMaximum(int)
     * @since 1.2
     */
    public int getActualMinimum(int field) {
        int fieldValue = getGreatestMinimum(field);
        int endValue = getMinimum(field);

        // if we know that the minimum value is always the same, just return it
        if (fieldValue == endValue) {
            return fieldValue;
        }

        // clone the calendar so we don't mess with the real one, and set it to
        // accept anything for the field values
        Calendar work = (Calendar) this.clone();
        work.setLenient(true);

        // now try each value from getLeastMaximum() to getMaximum() one by one until
        // we get a value that normalizes to another value. The last value that
        // normalizes to itself is the actual minimum for the current date
        int result = fieldValue;

        do {
            work.set(field, fieldValue);
            if (work.get(field) != fieldValue) {
                break;
            } else {
                result = fieldValue;
                fieldValue--;
            }
        } while (fieldValue >= endValue);

        return result;
    }

    /**
     * Returns the maximum value that the specified calendar field could have, given the time value
     * of this <code>Calendar</code>. For example, the actual maximum value of the
     * <code>MONTH</code> field is 12 in some years, and 13 in other years in the Hebrew calendar
     * system.
     * <p>
     * The default implementation of this method uses an iterative algorithm to determine the actual
     * maximum value for the calendar field. Subclasses should, if possible, override this with a
     * more efficient implementation.
     *
     * @param field the calendar field
     * @return the maximum of the given calendar field for the time value of this
     *         <code>Calendar</code>
     * @see #getMinimum(int)
     * @see #getMaximum(int)
     * @see #getGreatestMinimum(int)
     * @see #getLeastMaximum(int)
     * @see #getActualMinimum(int)
     * @since 1.2
     */
    public int getActualMaximum(int field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the value of the given calendar field. In lenient mode, all calendar fields are
     * normalized. In non-lenient mode, all calendar fields are validated and this method throws an
     * exception if any calendar fields have out-of-range values. The normalization and validation
     * are handled by the {@link #complete()} method, which process is calendar system dependent.
     *
     * @param field the given calendar field.
     * @return the value for the given calendar field.
     * @throws ArrayIndexOutOfBoundsException if the specified field is out of range (
     *             <code>field &lt; 0 || field &gt;= FIELD_COUNT</code>).
     * @see #set(int,int)
     * @see #complete()
     */
    public int get(int field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Sets the given calendar field to the given value. The value is not interpreted by this method
     * regardless of the leniency mode.
     *
     * @param field the given calendar field.
     * @param value the value to be set for the given calendar field.
     * @throws ArrayIndexOutOfBoundsException if the specified field is out of range (
     *             <code>field &lt; 0 || field &gt;= FIELD_COUNT</code>). in non-lenient mode.
     * @see #set(int,int,int)
     * @see #set(int,int,int,int,int)
     * @see #set(int,int,int,int,int,int)
     * @see #get(int)
     */
    public void set(int field, int value) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Sets the values for the calendar fields <code>YEAR</code>, <code>MONTH</code>, and
     * <code>DAY_OF_MONTH</code>. Previous values of other calendar fields are retained. If this is
     * not desired, call {@link #clear()} first.
     *
     * @param year the value used to set the <code>YEAR</code> calendar field.
     * @param month the value used to set the <code>MONTH</code> calendar field. Month value is
     *            0-based. e.g., 0 for January.
     * @param date the value used to set the <code>DAY_OF_MONTH</code> calendar field.
     * @see #set(int,int)
     * @see #set(int,int,int,int,int)
     * @see #set(int,int,int,int,int,int)
     */
    public final void set(int year, int month, int date) {
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, date);
    }

    /**
     * Sets the values for the calendar fields <code>YEAR</code>, <code>MONTH</code>,
     * <code>DAY_OF_MONTH</code>, <code>HOUR_OF_DAY</code>, and <code>MINUTE</code>. Previous values
     * of other fields are retained. If this is not desired, call {@link #clear()} first.
     *
     * @param year the value used to set the <code>YEAR</code> calendar field.
     * @param month the value used to set the <code>MONTH</code> calendar field. Month value is
     *            0-based. e.g., 0 for January.
     * @param date the value used to set the <code>DAY_OF_MONTH</code> calendar field.
     * @param hourOfDay the value used to set the <code>HOUR_OF_DAY</code> calendar field.
     * @param minute the value used to set the <code>MINUTE</code> calendar field.
     * @see #set(int,int)
     * @see #set(int,int,int)
     * @see #set(int,int,int,int,int,int)
     */
    public final void set(int year, int month, int date, int hourOfDay, int minute) {
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, date);
        set(HOUR_OF_DAY, hourOfDay);
        set(MINUTE, minute);
    }

    /**
     * Sets the values for the fields <code>YEAR</code>, <code>MONTH</code>,
     * <code>DAY_OF_MONTH</code>, <code>HOUR_OF_DAY</code>, <code>MINUTE</code>, and
     * <code>SECOND</code>. Previous values of other fields are retained. If this is not desired,
     * call {@link #clear()} first.
     *
     * @param year the value used to set the <code>YEAR</code> calendar field.
     * @param month the value used to set the <code>MONTH</code> calendar field. Month value is
     *            0-based. e.g., 0 for January.
     * @param date the value used to set the <code>DAY_OF_MONTH</code> calendar field.
     * @param hourOfDay the value used to set the <code>HOUR_OF_DAY</code> calendar field.
     * @param minute the value used to set the <code>MINUTE</code> calendar field.
     * @param second the value used to set the <code>SECOND</code> calendar field.
     * @see #set(int,int)
     * @see #set(int,int,int)
     * @see #set(int,int,int,int,int)
     */
    public final void set(int year, int month, int date, int hourOfDay, int minute, int second) {
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, date);
        set(HOUR_OF_DAY, hourOfDay);
        set(MINUTE, minute);
        set(SECOND, second);
    }

    /**
     * Tells whether date/time interpretation is to be lenient.
     *
     * @return <code>true</code> if the interpretation mode of this calendar is lenient;
     *         <code>false</code> otherwise.
     * @see #setLenient(boolean)
     */
    public boolean isLenient() {
        return lenient;
    }

    /**
     * Specifies whether or not date/time interpretation is to be lenient. With lenient
     * interpretation, a date such as "February 942, 1996" will be treated as being equivalent to
     * the 941st day after February 1, 1996. With strict (non-lenient) interpretation, such dates
     * will cause an exception to be thrown. The default is lenient.
     *
     * @param lenient <code>true</code> if the lenient mode is to be turned on; <code>false</code>
     *            if it is to be turned off.
     * @see #isLenient()
     * @see java.text.DateFormat#setLenient
     */
    public void setLenient(boolean lenient) {
        this.lenient = lenient;
    }

    /**
     * Gets the time zone.
     *
     * @return the time zone object associated with this calendar.
     */
    public TimeZone getTimeZone() {
        return zone;
    }

    /**
     * Sets the time zone with the given time zone value.
     *
     * @param value the given time zone.
     */
    public void setTimeZone(TimeZone value) {
        this.zone = value;
    }

    /**
     * Returns a <code>Date</code> object representing this <code>Calendar</code>'s time value
     * (millisecond offset from the <a href="#Epoch">Epoch</a>").
     *
     * @return a <code>Date</code> representing the time value.
     * @see #setTime(Date)
     * @see #getTimeInMillis()
     */
    public final Date getTime() {
        return new Date(getTimeInMillis());
    }

    /**
     * Sets this Calendar's time with the given <code>Date</code>.
     * <p>
     * Note: Calling <code>setTime()</code> with <code>Date(Long.MAX_VALUE)</code> or
     * <code>Date(Long.MIN_VALUE)</code> may yield incorrect field values from <code>get()</code>.
     *
     * @param date the given Date.
     * @see #getTime()
     * @see #setTimeInMillis(long)
     */
    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }

    /**
     * Returns this Calendar's time value in milliseconds.
     *
     * @return the current time as UTC milliseconds from the epoch.
     * @see #getTime()
     * @see #setTimeInMillis(long)
     */
    public long getTimeInMillis() {
        return time;
    }

    /**
     * Sets this Calendar's current time from the given long value.
     *
     * @param millis the new time in UTC milliseconds from the epoch.
     * @see #setTime(Date)
     * @see #getTimeInMillis()
     */
    public void setTimeInMillis(long millis) {
        time = millis;
    }

    /**
     * Creates and returns a copy of this object.
     *
     * @return a copy of this object.
     */
    @Override
    public Object clone() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Gets a calendar using the default time zone and locale. The <code>Calendar</code> returned is
     * based on the current time in the default time zone with the default
     * {@link Locale.Category#FORMAT FORMAT} locale.
     *
     * @return a Calendar.
     */
    public static Calendar getInstance() {
        return getInstance(TimeZone.getDefault(), Locale.getDefault(Locale.Category.FORMAT));
    }

    /**
     * Gets a calendar using the specified time zone and default locale. The <code>Calendar</code>
     * returned is based on the current time in the given time zone with the default
     * {@link Locale.Category#FORMAT FORMAT} locale.
     *
     * @param zone the time zone to use
     * @return a Calendar.
     */
    public static Calendar getInstance(TimeZone zone) {
        return getInstance(zone, Locale.getDefault(Locale.Category.FORMAT));
    }

    /**
     * Gets a calendar using the default time zone and specified locale. The <code>Calendar</code>
     * returned is based on the current time in the default time zone with the given locale.
     *
     * @param aLocale the locale for the week data
     * @return a Calendar.
     */
    public static Calendar getInstance(Locale aLocale) {
        return getInstance(TimeZone.getDefault(), aLocale);
    }

    /**
     * Gets a calendar with the specified time zone and locale. The <code>Calendar</code> returned
     * is based on the current time in the given time zone with the given locale.
     *
     * @param zone the time zone to use
     * @param aLocale the locale for the week data
     * @return a Calendar.
     */
    public static Calendar getInstance(TimeZone zone, Locale aLocale) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
