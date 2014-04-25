/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time;

import static java.time.temporal.ChronoField.*;
import static js.time.LocalTime.*;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 15:55:13
 */
@JavaAPIProvider(java.time.LocalDateTime.class)
class LocalDateTime implements Temporal, TemporalAdjuster, ChronoLocalDateTime<LocalDate> {

    private final LocalDate date;

    private final LocalTime time;

    /**
     * @param date
     * @param time
     */
    protected LocalDateTime(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getLong(TemporalField field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Gets the year field.
     * <p>
     * This method returns the primitive {@code int} value for the year.
     * <p>
     * The year returned by this method is proleptic as per {@code get(YEAR)}. To obtain the
     * year-of-era, use {@code get(YEAR_OF_ERA)}.
     *
     * @return the year, from MIN_YEAR to MAX_YEAR
     */
    public int getYear() {
        return date.getYear();
    }

    /**
     * Gets the month-of-year field from 1 to 12.
     * <p>
     * This method returns the month as an {@code int} from 1 to 12. Application code is frequently
     * clearer if the enum {@link Month} is used by calling {@link #getMonth()}.
     *
     * @return the month-of-year, from 1 to 12
     * @see #getMonth()
     */
    public int getMonthValue() {
        return date.getMonthValue();
    }

    /**
     * Gets the month-of-year field using the {@code Month} enum.
     * <p>
     * This method returns the enum {@link Month} for the month. This avoids confusion as to what
     * {@code int} values mean. If you need access to the primitive {@code int} value then the enum
     * provides the {@link Month#getValue() int value}.
     *
     * @return the month-of-year, not null
     * @see #getMonthValue()
     */
    public Month getMonth() {
        return date.getMonth();
    }

    /**
     * Gets the day-of-month field.
     * <p>
     * This method returns the primitive {@code int} value for the day-of-month.
     *
     * @return the day-of-month, from 1 to 31
     */
    public int getDayOfMonth() {
        return date.getDayOfMonth();
    }

    /**
     * Gets the day-of-year field.
     * <p>
     * This method returns the primitive {@code int} value for the day-of-year.
     *
     * @return the day-of-year, from 1 to 365, or 366 in a leap year
     */
    public int getDayOfYear() {
        return date.getDayOfYear();
    }

    /**
     * Gets the day-of-week field, which is an enum {@code DayOfWeek}.
     * <p>
     * This method returns the enum {@link DayOfWeek} for the day-of-week. This avoids confusion as
     * to what {@code int} values mean. If you need access to the primitive {@code int} value then
     * the enum provides the {@link DayOfWeek#getValue() int value}.
     * <p>
     * Additional information can be obtained from the {@code DayOfWeek}. This includes textual
     * names of the values.
     *
     * @return the day-of-week, not null
     */
    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }

    /**
     * Gets the hour-of-day field.
     *
     * @return the hour-of-day, from 0 to 23
     */
    public int getHour() {
        return time.getHour();
    }

    /**
     * Gets the minute-of-hour field.
     *
     * @return the minute-of-hour, from 0 to 59
     */
    public int getMinute() {
        return time.getMinute();
    }

    /**
     * Gets the second-of-minute field.
     *
     * @return the second-of-minute, from 0 to 59
     */
    public int getSecond() {
        return time.getSecond();
    }

    /**
     * Gets the nano-of-second field.
     *
     * @return the nano-of-second, from 0 to 999,999,999
     */
    public int getNano() {
        return time.getNano();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate toLocalDate() {
        return date;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime toLocalTime() {
        return time;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSupported(TemporalField field) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChronoLocalDateTime<LocalDate> plus(long amountToAdd, TemporalUnit unit) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in years added.
     * <p>
     * This method adds the specified amount to the years field in three steps:
     * <ol>
     * <li>Add the input years to the year field</li>
     * <li>Check if the resulting date would be invalid</li>
     * <li>Adjust the day-of-month to the last valid day if necessary</li>
     * </ol>
     * <p>
     * For example, 2008-02-29 (leap year) plus one year would result in the invalid date 2009-02-29
     * (standard year). Instead of returning an invalid result, the last valid day of the month,
     * 2009-02-28, is selected instead.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param years the years to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the years added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusYears(long years) {
        LocalDate newDate = date.plusYears(years);
        return with(newDate, time);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in months added.
     * <p>
     * This method adds the specified amount to the months field in three steps:
     * <ol>
     * <li>Add the input months to the month-of-year field</li>
     * <li>Check if the resulting date would be invalid</li>
     * <li>Adjust the day-of-month to the last valid day if necessary</li>
     * </ol>
     * <p>
     * For example, 2007-03-31 plus one month would result in the invalid date 2007-04-31. Instead
     * of returning an invalid result, the last valid day of the month, 2007-04-30, is selected
     * instead.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param months the months to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the months added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusMonths(long months) {
        LocalDate newDate = date.plusMonths(months);
        return with(newDate, time);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in weeks added.
     * <p>
     * This method adds the specified amount in weeks to the days field incrementing the month and
     * year fields as necessary to ensure the result remains valid. The result is only invalid if
     * the maximum/minimum year is exceeded.
     * <p>
     * For example, 2008-12-31 plus one week would result in 2009-01-07.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param weeks the weeks to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the weeks added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusWeeks(long weeks) {
        LocalDate newDate = date.plusWeeks(weeks);
        return with(newDate, time);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in days added.
     * <p>
     * This method adds the specified amount to the days field incrementing the month and year
     * fields as necessary to ensure the result remains valid. The result is only invalid if the
     * maximum/minimum year is exceeded.
     * <p>
     * For example, 2008-12-31 plus one day would result in 2009-01-01.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param days the days to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the days added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusDays(long days) {
        LocalDate newDate = date.plusDays(days);
        return with(newDate, time);
    }

    // -----------------------------------------------------------------------
    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in hours added.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param hours the hours to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the hours added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusHours(long hours) {
        return plusWithOverflow(date, hours, 0, 0, 0, 1);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in minutes added.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param minutes the minutes to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the minutes added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusMinutes(long minutes) {
        return plusWithOverflow(date, 0, minutes, 0, 0, 1);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in seconds added.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param seconds the seconds to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the seconds added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusSeconds(long seconds) {
        return plusWithOverflow(date, 0, 0, seconds, 0, 1);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period in nanoseconds added.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param nanos the nanos to add, may be negative
     * @return a {@code LocalDateTime} based on this date-time with the nanoseconds added, not null
     * @throws DateTimeException if the result exceeds the supported date range
     */
    public LocalDateTime plusNanos(long nanos) {
        return plusWithOverflow(date, 0, 0, 0, nanos, 1);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the specified period added.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param newDate the new date to base the calculation on, not null
     * @param hours the hours to add, may be negative
     * @param minutes the minutes to add, may be negative
     * @param seconds the seconds to add, may be negative
     * @param nanos the nanos to add, may be negative
     * @param sign the sign to determine add or subtract
     * @return the combined result, not null
     */
    private LocalDateTime plusWithOverflow(LocalDate newDate, long hours, long minutes, long seconds, long nanos, int sign) {
        // 9223372036854775808 long, 2147483648 int
        if ((hours | minutes | seconds | nanos) == 0) {
            return with(newDate, time);
        }
        long totDays = nanos / NANOS_PER_DAY + // max/24*60*60*1B
        seconds / SECONDS_PER_DAY + // max/24*60*60
        minutes / MINUTES_PER_DAY + // max/24*60
        hours / HOURS_PER_DAY; // max/24
        totDays *= sign; // total max*0.4237...
        long totNanos = nanos % NANOS_PER_DAY + // max 86400000000000
        (seconds % SECONDS_PER_DAY) * NANOS_PER_SECOND + // max 86400000000000
        (minutes % MINUTES_PER_DAY) * NANOS_PER_MINUTE + // max 86400000000000
        (hours % HOURS_PER_DAY) * NANOS_PER_HOUR; // max 86400000000000
        long curNoD = time.toNanoOfDay(); // max 86400000000000
        totNanos = totNanos * sign + curNoD; // total 432000000000000
        totDays += Math.floorDiv(totNanos, NANOS_PER_DAY);
        long newNoD = Math.floorMod(totNanos, NANOS_PER_DAY);
        LocalTime newTime = (newNoD == curNoD ? time : LocalTime.ofNanoOfDay(newNoD));
        return with(newDate.plusDays(totDays), newTime);
    }

    /**
     * Returns a copy of this date-time with the new date and time, checking to see if a new object
     * is in fact required.
     *
     * @param newDate the date of the new date-time, not null
     * @param newTime the time of the new date-time, not null
     * @return the date-time, not null
     */
    private LocalDateTime with(LocalDate newDate, LocalTime newTime) {
        if (date == newDate && time == newTime) {
            return this;
        }
        return new LocalDateTime(newDate, newTime);
    }

    /**
     * Returns an adjusted copy of this date-time.
     * <p>
     * This returns a {@code LocalDateTime}, based on this one, with the date-time adjusted. The
     * adjustment takes place using the specified adjuster strategy object. Read the documentation
     * of the adjuster to understand what adjustment will be made.
     * <p>
     * A simple adjuster might simply set the one of the fields, such as the year field. A more
     * complex adjuster might set the date to the last day of the month. A selection of common
     * adjustments is provided in {@link TemporalAdjuster}. These include finding the
     * "last day of the month" and "next Wednesday". Key date-time classes also implement the
     * {@code TemporalAdjuster} interface, such as {@link Month} and {@link java.time.MonthDay
     * MonthDay}. The adjuster is responsible for handling special cases, such as the varying
     * lengths of month and leap years.
     * <p>
     * For example this code returns a date on the last day of July:
     * 
     * <pre>
     *  import static java.time.Month.*;
     *  import static java.time.temporal.Adjusters.*;
     *
     *  result = localDateTime.with(JULY).with(lastDayOfMonth());
     * </pre>
     * <p>
     * The classes {@link LocalDate} and {@link LocalTime} implement {@code TemporalAdjuster}, thus
     * this method can be used to change the date, time or offset:
     * 
     * <pre>
     *  result = localDateTime.with(date);
     *  result = localDateTime.with(time);
     * </pre>
     * <p>
     * The result of this method is obtained by invoking the
     * {@link TemporalAdjuster#adjustInto(Temporal)} method on the specified adjuster passing
     * {@code this} as the argument.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param adjuster the adjuster to use, not null
     * @return a {@code LocalDateTime} based on {@code this} with the adjustment made, not null
     * @throws DateTimeException if the adjustment cannot be made
     * @throws ArithmeticException if numeric overflow occurs
     */
    @Override
    public LocalDateTime with(TemporalAdjuster adjuster) {
        // optimizations
        if (adjuster instanceof LocalDate) {
            return with((LocalDate) adjuster, time);
        } else if (adjuster instanceof LocalTime) {
            return with(date, (LocalTime) adjuster);
        } else if (adjuster instanceof LocalDateTime) {
            return (LocalDateTime) adjuster;
        }
        return (LocalDateTime) adjuster.adjustInto(this);
    }

    /**
     * Returns a copy of this date-time with the specified field set to a new value.
     * <p>
     * This returns a {@code LocalDateTime}, based on this one, with the value for the specified
     * field changed. This can be used to change any supported field, such as the year, month or
     * day-of-month. If it is not possible to set the value, because the field is not supported or
     * for some other reason, an exception is thrown.
     * <p>
     * In some cases, changing the specified field can cause the resulting date-time to become
     * invalid, such as changing the month from 31st January to February would make the day-of-month
     * invalid. In cases like this, the field is responsible for resolving the date. Typically it
     * will choose the previous valid date, which would be the last valid day of February in this
     * example.
     * <p>
     * If the field is a {@link ChronoField} then the adjustment is implemented here. The
     * {@link #isSupported(TemporalField) supported fields} will behave as per the matching method
     * on {@link LocalDate#with(TemporalField, long) LocalDate} or
     * {@link LocalTime#with(TemporalField, long) LocalTime}. All other {@code ChronoField}
     * instances will throw an {@code UnsupportedTemporalTypeException}.
     * <p>
     * If the field is not a {@code ChronoField}, then the result of this method is obtained by
     * invoking {@code TemporalField.adjustInto(Temporal, long)} passing {@code this} as the
     * argument. In this case, the field determines whether and how to adjust the instant.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param field the field to set in the result, not null
     * @param newValue the new value of the field in the result
     * @return a {@code LocalDateTime} based on {@code this} with the specified field set, not null
     * @throws DateTimeException if the field cannot be set
     * @throws UnsupportedTemporalTypeException if the field is not supported
     * @throws ArithmeticException if numeric overflow occurs
     */
    @Override
    public LocalDateTime with(TemporalField field, long newValue) {
        if (field instanceof ChronoField) {
            ChronoField f = (ChronoField) field;
            if (f.isTimeBased()) {
                return with(date, time.with(field, newValue));
            } else {
                return with(date.with(field, newValue), time);
            }
        }
        return field.adjustInto(this, newValue);
    }

    // -----------------------------------------------------------------------
    /**
     * Returns a copy of this {@code LocalDateTime} with the year altered. The time does not affect
     * the calculation and will be the same in the result. If the day-of-month is invalid for the
     * year, it will be changed to the last valid day of the month.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param year the year to set in the result, from MIN_YEAR to MAX_YEAR
     * @return a {@code LocalDateTime} based on this date-time with the requested year, not null
     * @throws DateTimeException if the year value is invalid
     */
    public LocalDateTime withYear(int year) {
        return with(date.withYear(year), time);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the month-of-year altered. The time does
     * not affect the calculation and will be the same in the result. If the day-of-month is invalid
     * for the year, it will be changed to the last valid day of the month.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param month the month-of-year to set in the result, from 1 (January) to 12 (December)
     * @return a {@code LocalDateTime} based on this date-time with the requested month, not null
     * @throws DateTimeException if the month-of-year value is invalid
     */
    public LocalDateTime withMonth(int month) {
        return with(date.withMonth(month), time);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the day-of-month altered. If the resulting
     * {@code LocalDateTime} is invalid, an exception is thrown. The time does not affect the
     * calculation and will be the same in the result.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param dayOfMonth the day-of-month to set in the result, from 1 to 28-31
     * @return a {@code LocalDateTime} based on this date-time with the requested day, not null
     * @throws DateTimeException if the day-of-month value is invalid, or if the day-of-month is
     *             invalid for the month-year
     */
    public LocalDateTime withDayOfMonth(int dayOfMonth) {
        return with(date.withDayOfMonth(dayOfMonth), time);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the day-of-year altered. If the resulting
     * {@code LocalDateTime} is invalid, an exception is thrown.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param dayOfYear the day-of-year to set in the result, from 1 to 365-366
     * @return a {@code LocalDateTime} based on this date with the requested day, not null
     * @throws DateTimeException if the day-of-year value is invalid, or if the day-of-year is
     *             invalid for the year
     */
    public LocalDateTime withDayOfYear(int dayOfYear) {
        return with(date.withDayOfYear(dayOfYear), time);
    }

    // -----------------------------------------------------------------------
    /**
     * Returns a copy of this {@code LocalDateTime} with the hour-of-day value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param hour the hour-of-day to set in the result, from 0 to 23
     * @return a {@code LocalDateTime} based on this date-time with the requested hour, not null
     * @throws DateTimeException if the hour value is invalid
     */
    public LocalDateTime withHour(int hour) {
        LocalTime newTime = time.withHour(hour);
        return with(date, newTime);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the minute-of-hour value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param minute the minute-of-hour to set in the result, from 0 to 59
     * @return a {@code LocalDateTime} based on this date-time with the requested minute, not null
     * @throws DateTimeException if the minute value is invalid
     */
    public LocalDateTime withMinute(int minute) {
        LocalTime newTime = time.withMinute(minute);
        return with(date, newTime);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the second-of-minute value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param second the second-of-minute to set in the result, from 0 to 59
     * @return a {@code LocalDateTime} based on this date-time with the requested second, not null
     * @throws DateTimeException if the second value is invalid
     */
    public LocalDateTime withSecond(int second) {
        LocalTime newTime = time.withSecond(second);
        return with(date, newTime);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the nano-of-second value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param nanoOfSecond the nano-of-second to set in the result, from 0 to 999,999,999
     * @return a {@code LocalDateTime} based on this date-time with the requested nanosecond, not
     *         null
     * @throws DateTimeException if the nano value is invalid
     */
    public LocalDateTime withNano(int nanoOfSecond) {
        LocalTime newTime = time.withNano(nanoOfSecond);
        return with(date, newTime);
    }

    /**
     * Returns a copy of this {@code LocalDateTime} with the time truncated.
     * <p>
     * Truncation returns a copy of the original date-time with fields smaller than the specified
     * unit set to zero. For example, truncating with the {@link ChronoUnit#MINUTES minutes} unit
     * will set the second-of-minute and nano-of-second field to zero.
     * <p>
     * The unit must have a {@linkplain TemporalUnit#getDuration() duration} that divides into the
     * length of a standard day without remainder. This includes all supplied time units on
     * {@link ChronoUnit} and {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param unit the unit to truncate to, not null
     * @return a {@code LocalDateTime} based on this date-time with the time truncated, not null
     * @throws DateTimeException if unable to truncate
     * @throws UnsupportedTemporalTypeException if the field is not supported
     */
    public LocalDateTime truncatedTo(TemporalUnit unit) {
        return with(date, time.truncatedTo(unit));
    }

    /**
     * @param out
     * @throws IOException
     */
    void writeExternal(DataOutput out) throws IOException {
    }

    /**
     * @param in
     * @return
     * @throws IOException
     */
    static LocalDateTime readExternal(DataInput in) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ChronoZonedDateTime<LocalDate> atZone(ZoneId zone) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from a temporal object.
     * <p>
     * This obtains an offset time based on the specified temporal. A {@code TemporalAccessor}
     * represents an arbitrary set of date and time information, which this factory converts to an
     * instance of {@code LocalDateTime}.
     * <p>
     * The conversion extracts and combines the {@code LocalDate} and the {@code LocalTime} from the
     * temporal object. Implementations are permitted to perform optimizations such as accessing
     * those fields that are equivalent to the relevant objects.
     * <p>
     * This method matches the signature of the functional interface {@link TemporalQuery} allowing
     * it to be used as a query via method reference, {@code LocalDateTime::from}.
     *
     * @param temporal the temporal object to convert, not null
     * @return the local date-time, not null
     * @throws DateTimeException if unable to convert to a {@code LocalDateTime}
     */
    public static LocalDateTime from(TemporalAccessor temporal) {
        if (temporal instanceof LocalDateTime) {
            return (LocalDateTime) temporal;
        } else if (temporal instanceof ZonedDateTime) {
            return (LocalDateTime) (Object) ((ZonedDateTime) temporal).toLocalDateTime();
        } else if (temporal instanceof OffsetDateTime) {
            return (LocalDateTime) (Object) ((OffsetDateTime) temporal).toLocalDateTime();
        }
        try {
            LocalDate date = LocalDate.from(temporal);
            LocalTime time = LocalTime.from(temporal);
            return new LocalDateTime(date, time);
        } catch (DateTimeException ex) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporal + " of type " + temporal.getClass()
                    .getName(), ex);
        }
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from year, month, day, hour and minute, setting
     * the second and nanosecond to zero.
     * <p>
     * This returns a {@code LocalDateTime} with the specified year, month, day-of-month, hour and
     * minute. The day must be valid for the year and month, otherwise an exception will be thrown.
     * The second and nanosecond fields will be set to zero.
     *
     * @param year the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month-of-year to represent, not null
     * @param dayOfMonth the day-of-month to represent, from 1 to 31
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @return the local date-time, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-month
     *             is invalid for the month-year
     */
    public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute);
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from year, month, day, hour, minute and second,
     * setting the nanosecond to zero.
     * <p>
     * This returns a {@code LocalDateTime} with the specified year, month, day-of-month, hour,
     * minute and second. The day must be valid for the year and month, otherwise an exception will
     * be thrown. The nanosecond field will be set to zero.
     *
     * @param year the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month-of-year to represent, not null
     * @param dayOfMonth the day-of-month to represent, from 1 to 31
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @param second the second-of-minute to represent, from 0 to 59
     * @return the local date-time, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-month
     *             is invalid for the month-year
     */
    public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second);
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from year, month, day, hour, minute, second and
     * nanosecond.
     * <p>
     * This returns a {@code LocalDateTime} with the specified year, month, day-of-month, hour,
     * minute, second and nanosecond. The day must be valid for the year and month, otherwise an
     * exception will be thrown.
     *
     * @param year the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month-of-year to represent, not null
     * @param dayOfMonth the day-of-month to represent, from 1 to 31
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @param second the second-of-minute to represent, from 0 to 59
     * @param nanoOfSecond the nano-of-second to represent, from 0 to 999,999,999
     * @return the local date-time, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-month
     *             is invalid for the month-year
     */
    public static LocalDateTime of(int year, Month month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second, nanoOfSecond);
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from year, month, day, hour and minute, setting
     * the second and nanosecond to zero.
     * <p>
     * This returns a {@code LocalDateTime} with the specified year, month, day-of-month, hour and
     * minute. The day must be valid for the year and month, otherwise an exception will be thrown.
     * The second and nanosecond fields will be set to zero.
     *
     * @param year the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month-of-year to represent, from 1 (January) to 12 (December)
     * @param dayOfMonth the day-of-month to represent, from 1 to 31
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @return the local date-time, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-month
     *             is invalid for the month-year
     */
    public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute);
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from year, month, day, hour, minute and second,
     * setting the nanosecond to zero.
     * <p>
     * This returns a {@code LocalDateTime} with the specified year, month, day-of-month, hour,
     * minute and second. The day must be valid for the year and month, otherwise an exception will
     * be thrown. The nanosecond field will be set to zero.
     *
     * @param year the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month-of-year to represent, from 1 (January) to 12 (December)
     * @param dayOfMonth the day-of-month to represent, from 1 to 31
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @param second the second-of-minute to represent, from 0 to 59
     * @return the local date-time, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-month
     *             is invalid for the month-year
     */
    public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second);
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from year, month, day, hour, minute, second and
     * nanosecond.
     * <p>
     * This returns a {@code LocalDateTime} with the specified year, month, day-of-month, hour,
     * minute, second and nanosecond. The day must be valid for the year and month, otherwise an
     * exception will be thrown.
     *
     * @param year the year to represent, from MIN_YEAR to MAX_YEAR
     * @param month the month-of-year to represent, from 1 (January) to 12 (December)
     * @param dayOfMonth the day-of-month to represent, from 1 to 31
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @param second the second-of-minute to represent, from 0 to 59
     * @param nanoOfSecond the nano-of-second to represent, from 0 to 999,999,999
     * @return the local date-time, not null
     * @throws DateTimeException if the value of any field is out of range, or if the day-of-month
     *             is invalid for the month-year
     */
    public static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond) {
        LocalDate date = LocalDate.of(year, month, dayOfMonth);
        LocalTime time = LocalTime.of(hour, minute, second, nanoOfSecond);
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from a date and time.
     *
     * @param date the local date, not null
     * @param time the local time, not null
     * @return the local date-time, not null
     */
    public static LocalDateTime of(LocalDate date, LocalTime time) {
        Objects.requireNonNull(date, "date");
        Objects.requireNonNull(time, "time");
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} using seconds from the epoch of
     * 1970-01-01T00:00:00Z.
     * <p>
     * This allows the {@link ChronoField#INSTANT_SECONDS epoch-second} field to be converted to a
     * local date-time. This is primarily intended for low-level conversions rather than general
     * application usage.
     *
     * @param epochSecond the number of seconds from the epoch of 1970-01-01T00:00:00Z
     * @param nanoOfSecond the nanosecond within the second, from 0 to 999,999,999
     * @param offset the zone offset, not null
     * @return the local date-time, not null
     * @throws DateTimeException if the result exceeds the supported range, or if the nano-of-second
     *             is invalid
     */
    public static LocalDateTime ofEpochSecond(long epochSecond, int nanoOfSecond, ZoneOffset offset) {
        Objects.requireNonNull(offset, "offset");
        NANO_OF_SECOND.checkValidValue(nanoOfSecond);
        long localSecond = epochSecond + offset.getTotalSeconds(); // overflow caught later
        long localEpochDay = Math.floorDiv(localSecond, 86400);
        int secsOfDay = (int) Math.floorMod(localSecond, 86400);
        LocalDate date = LocalDate.ofEpochDay(localEpochDay);
        LocalTime time = LocalTime.ofNanoOfDay(secsOfDay * 1000_000_000L + nanoOfSecond);
        return new LocalDateTime(date, time);
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from an {@code Instant} and zone ID.
     * <p>
     * This creates a local date-time based on the specified instant. First, the offset from
     * UTC/Greenwich is obtained using the zone ID and instant, which is simple as there is only one
     * valid offset for each instant. Then, the instant and offset are used to calculate the local
     * date-time.
     *
     * @param instant the instant to create the date-time from, not null
     * @param zone the time-zone, which may be an offset, not null
     * @return the local date-time, not null
     * @throws DateTimeException if the result exceeds the supported range
     */
    public static LocalDateTime ofInstant(Instant instant, ZoneId zone) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains an instance of {@code LocalDateTime} from a text string such as
     * {@code 2007-12-03T10:15:30}.
     * <p>
     * The string must represent a valid date-time and is parsed using
     * {@link java.time.format.DateTimeFormatter#ISO_LOCAL_DATE_TIME}.
     *
     * @param text the text to parse such as "2007-12-03T10:15:30", not null
     * @return the parsed local date-time, not null
     * @throws DateTimeParseException if the text cannot be parsed
     */
    public static LocalDateTime parse(CharSequence text) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
