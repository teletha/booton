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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.time.Clock;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.time.temporal.ValueRange;
import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 16:23:42
 */
@JavaAPIProvider(java.time.LocalTime.class)
class LocalTime implements Temporal, TemporalAdjuster, Comparable<java.time.LocalTime> {

    /**
     * The minimum supported {@code LocalTime}, '00:00'. This is the time of midnight at the start
     * of the day.
     */
    public static final LocalTime MIN;

    /**
     * The maximum supported {@code LocalTime}, '23:59:59.999999999'. This is the time just before
     * midnight at the end of the day.
     */
    public static final LocalTime MAX;

    /**
     * The time of midnight at the start of the day, '00:00'.
     */
    public static final LocalTime MIDNIGHT;

    /**
     * The time of noon in the middle of the day, '12:00'.
     */
    public static final LocalTime NOON;

    /**
     * Constants for the local time of each hour.
     */
    private static final LocalTime[] HOURS = new LocalTime[24];
    static {
        for (int i = 0; i < HOURS.length; i++) {
            HOURS[i] = new LocalTime(i, 0, 0, 0);
        }
        MIDNIGHT = HOURS[0];
        NOON = HOURS[12];
        MIN = HOURS[0];
        MAX = new LocalTime(23, 59, 59, 999_999_999);
    }

    /**
     * Hours per day.
     */
    static final int HOURS_PER_DAY = 24;

    /**
     * Minutes per hour.
     */
    static final int MINUTES_PER_HOUR = 60;

    /**
     * Minutes per day.
     */
    static final int MINUTES_PER_DAY = MINUTES_PER_HOUR * HOURS_PER_DAY;

    /**
     * Seconds per minute.
     */
    static final int SECONDS_PER_MINUTE = 60;

    /**
     * Seconds per hour.
     */
    static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;

    /**
     * Seconds per day.
     */
    static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;

    /**
     * Milliseconds per day.
     */
    static final long MILLIS_PER_DAY = SECONDS_PER_DAY * 1000L;

    /**
     * Microseconds per day.
     */
    static final long MICROS_PER_DAY = SECONDS_PER_DAY * 1000_000L;

    /**
     * Nanos per second.
     */
    static final long NANOS_PER_SECOND = 1000_000_000L;

    /**
     * Nanos per minute.
     */
    static final long NANOS_PER_MINUTE = NANOS_PER_SECOND * SECONDS_PER_MINUTE;

    /**
     * Nanos per hour.
     */
    static final long NANOS_PER_HOUR = NANOS_PER_MINUTE * MINUTES_PER_HOUR;

    /**
     * Nanos per day.
     */
    static final long NANOS_PER_DAY = NANOS_PER_HOUR * HOURS_PER_DAY;

    /**
     * The hour.
     */
    private final byte hour;

    /**
     * The minute.
     */
    private final byte minute;

    /**
     * The second.
     */
    private final byte second;

    /**
     * The nanosecond.
     */
    private final int nano;

    /**
     * Constructor, previously validated.
     *
     * @param hour the hour-of-day to represent, validated from 0 to 23
     * @param minute the minute-of-hour to represent, validated from 0 to 59
     * @param second the second-of-minute to represent, validated from 0 to 59
     * @param nanoOfSecond the nano-of-second to represent, validated from 0 to 999,999,999
     */
    private LocalTime(int hour, int minute, int second, int nanoOfSecond) {
        this.hour = (byte) hour;
        this.minute = (byte) minute;
        this.second = (byte) second;
        this.nano = nanoOfSecond;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSupported(TemporalField field) {
        return false;
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
    public Temporal adjustInto(Temporal temporal) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSupported(TemporalUnit unit) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Temporal with(TemporalField field, long newValue) {
        return null;
    }

    /**
     * Returns a copy of this {@code LocalTime} with the hour-of-day value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param hour the hour-of-day to set in the result, from 0 to 23
     * @return a {@code LocalTime} based on this time with the requested hour, not null
     * @throws DateTimeException if the hour value is invalid
     */
    public LocalTime withHour(int hour) {
        if (this.hour == hour) {
            return this;
        }
        HOUR_OF_DAY.checkValidValue(hour);
        return create(hour, minute, second, nano);
    }

    /**
     * Returns a copy of this {@code LocalTime} with the minute-of-hour value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param minute the minute-of-hour to set in the result, from 0 to 59
     * @return a {@code LocalTime} based on this time with the requested minute, not null
     * @throws DateTimeException if the minute value is invalid
     */
    public LocalTime withMinute(int minute) {
        if (this.minute == minute) {
            return this;
        }
        MINUTE_OF_HOUR.checkValidValue(minute);
        return create(hour, minute, second, nano);
    }

    /**
     * Returns a copy of this {@code LocalTime} with the second-of-minute value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param second the second-of-minute to set in the result, from 0 to 59
     * @return a {@code LocalTime} based on this time with the requested second, not null
     * @throws DateTimeException if the second value is invalid
     */
    public LocalTime withSecond(int second) {
        if (this.second == second) {
            return this;
        }
        SECOND_OF_MINUTE.checkValidValue(second);
        return create(hour, minute, second, nano);
    }

    /**
     * Returns a copy of this {@code LocalTime} with the nano-of-second value altered.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param nanoOfSecond the nano-of-second to set in the result, from 0 to 999,999,999
     * @return a {@code LocalTime} based on this time with the requested nanosecond, not null
     * @throws DateTimeException if the nanos value is invalid
     */
    public LocalTime withNano(int nanoOfSecond) {
        if (this.nano == nanoOfSecond) {
            return this;
        }
        NANO_OF_SECOND.checkValidValue(nanoOfSecond);
        return create(hour, minute, second, nanoOfSecond);
    }

    /**
     * Returns a copy of this {@code LocalTime} with the time truncated.
     * <p>
     * Truncating the time returns a copy of the original time with fields smaller than the
     * specified unit set to zero. For example, truncating with the {@link ChronoUnit#MINUTES
     * minutes} unit will set the second-of-minute and nano-of-second field to zero.
     * <p>
     * The unit must have a {@linkplain TemporalUnit#getDuration() duration} that divides into the
     * length of a standard day without remainder. This includes all supplied time units on
     * {@link ChronoUnit} and {@link ChronoUnit#DAYS DAYS}. Other units throw an exception.
     * <p>
     * This instance is immutable and unaffected by this method call.
     *
     * @param unit the unit to truncate to, not null
     * @return a {@code LocalTime} based on this time with the time truncated, not null
     * @throws DateTimeException if unable to truncate
     * @throws UnsupportedTemporalTypeException if the unit is not supported
     */
    public LocalTime truncatedTo(TemporalUnit unit) {
        if (unit == ChronoUnit.NANOS) {
            return this;
        }
        Duration unitDur = unit.getDuration();
        if (unitDur.getSeconds() > SECONDS_PER_DAY) {
            throw new UnsupportedTemporalTypeException("Unit is too large to be used for truncation");
        }
        long dur = unitDur.toNanos();
        if ((NANOS_PER_DAY % dur) != 0) {
            throw new UnsupportedTemporalTypeException("Unit must divide into a standard day without remainder");
        }
        long nod = toNanoOfDay();
        return ofNanoOfDay((nod / dur) * dur);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Temporal plus(long amountToAdd, TemporalUnit unit) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long until(Temporal endExclusive, TemporalUnit unit) {
        return 0;
    }

    /**
     * Compares this {@code LocalTime} to another time.
     * <p>
     * The comparison is based on the time-line position of the local times within a day. It is
     * "consistent with equals", as defined by {@link Comparable}.
     *
     * @param other the other time to compare to, not null
     * @return the comparator value, negative if less, positive if greater
     * @throws NullPointerException if {@code other} is null
     */
    @Override
    public int compareTo(java.time.LocalTime time) {
        LocalTime other = (LocalTime) (Object) time;

        int cmp = Integer.compare(hour, other.hour);

        if (cmp == 0) {
            cmp = Integer.compare(minute, other.minute);

            if (cmp == 0) {
                cmp = Integer.compare(second, other.second);

                if (cmp == 0) {
                    cmp = Integer.compare(nano, other.nano);
                }
            }
        }
        return cmp;
    }

    /**
     * Checks if this {@code LocalTime} is after the specified time.
     * <p>
     * The comparison is based on the time-line position of the time within a day.
     *
     * @param other the other time to compare to, not null
     * @return true if this is after the specified time
     * @throws NullPointerException if {@code other} is null
     */
    public boolean isAfter(java.time.LocalTime other) {
        return compareTo(other) > 0;
    }

    /**
     * Checks if this {@code LocalTime} is before the specified time.
     * <p>
     * The comparison is based on the time-line position of the time within a day.
     *
     * @param other the other time to compare to, not null
     * @return true if this point is before the specified time
     * @throws NullPointerException if {@code other} is null
     */
    public boolean isBefore(java.time.LocalTime other) {
        return compareTo(other) < 0;
    }

    /**
     * Gets the hour-of-day field.
     *
     * @return the hour-of-day, from 0 to 23
     */
    public int getHour() {
        return hour;
    }

    /**
     * Gets the minute-of-hour field.
     *
     * @return the minute-of-hour, from 0 to 59
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Gets the second-of-minute field.
     *
     * @return the second-of-minute, from 0 to 59
     */
    public int getSecond() {
        return second;
    }

    /**
     * Gets the nano-of-second field.
     *
     * @return the nano-of-second, from 0 to 999,999,999
     */
    public int getNano() {
        return nano;
    }

    /**
     * Extracts the time as seconds of day, from {@code 0} to {@code 24 * 60 * 60 - 1}.
     *
     * @return the second-of-day equivalent to this time
     */
    public int toSecondOfDay() {
        int total = hour * SECONDS_PER_HOUR;
        total += minute * SECONDS_PER_MINUTE;
        total += second;
        return total;
    }

    /**
     * Extracts the time as nanos of day, from {@code 0} to {@code 24 * 60 * 60 * 1,000,000,000 - 1}
     * .
     *
     * @return the nano of day equivalent to this time
     */
    public long toNanoOfDay() {
        long total = hour * NANOS_PER_HOUR;
        total += minute * NANOS_PER_MINUTE;
        total += second * NANOS_PER_SECOND;
        total += nano;
        return total;
    }

    /**
     * Gets the range of valid values for the specified field.
     * <p>
     * The range object expresses the minimum and maximum valid values for a field. This time is
     * used to enhance the accuracy of the returned range. If it is not possible to return the
     * range, because the field is not supported or for some other reason, an exception is thrown.
     * <p>
     * If the field is a {@link ChronoField} then the query is implemented here. The
     * {@link #isSupported(TemporalField) supported fields} will return appropriate range instances.
     * All other {@code ChronoField} instances will throw an
     * {@code UnsupportedTemporalTypeException}.
     * <p>
     * If the field is not a {@code ChronoField}, then the result of this method is obtained by
     * invoking {@code TemporalField.rangeRefinedBy(TemporalAccessor)} passing {@code this} as the
     * argument. Whether the range can be obtained is determined by the field.
     *
     * @param field the field to query the range for, not null
     * @return the range of valid values for the field, not null
     * @throws DateTimeException if the range for the field cannot be obtained
     * @throws UnsupportedTemporalTypeException if the field is not supported
     */
    @Override
    // override for Javadoc
    public ValueRange range(TemporalField field) {
        return Temporal.super.range(field);
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
    static LocalTime readExternal(DataInput in) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains an instance of {@code LocalTime} from a temporal object.
     * <p>
     * This obtains a local time based on the specified temporal. A {@code TemporalAccessor}
     * represents an arbitrary set of date and time information, which this factory converts to an
     * instance of {@code LocalTime}.
     * <p>
     * The conversion uses the {@link TemporalQueries#localTime()} query, which relies on extracting
     * the {@link ChronoField#NANO_OF_DAY NANO_OF_DAY} field.
     * <p>
     * This method matches the signature of the functional interface {@link TemporalQuery} allowing
     * it to be used in queries via method reference, {@code LocalTime::from}.
     *
     * @param temporal the temporal object to convert, not null
     * @return the local time, not null
     * @throws DateTimeException if unable to convert to a {@code LocalTime}
     */
    public static LocalTime from(TemporalAccessor temporal) {
        Objects.requireNonNull(temporal, "temporal");
        LocalTime time = (LocalTime) (Object) temporal.query(TemporalQueries.localTime());
        if (time == null) {
            throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporal + " of type " + temporal.getClass()
                    .getName());
        }
        return time;
    }

    /**
     * Obtains the current time from the system clock in the default time-zone.
     * <p>
     * This will query the {@link Clock#systemDefaultZone() system clock} in the default time-zone
     * to obtain the current time.
     * <p>
     * Using this method will prevent the ability to use an alternate clock for testing because the
     * clock is hard-coded.
     *
     * @return the current time using the system clock and default time-zone, not null
     */
    public static LocalTime now() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains the current time from the system clock in the specified time-zone.
     * <p>
     * This will query the {@link Clock#system(ZoneId) system clock} to obtain the current time.
     * Specifying the time-zone avoids dependence on the default time-zone.
     * <p>
     * Using this method will prevent the ability to use an alternate clock for testing because the
     * clock is hard-coded.
     *
     * @param zone the zone ID to use, not null
     * @return the current time using the system clock, not null
     */
    public static LocalTime now(ZoneId zone) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains the current time from the specified clock.
     * <p>
     * This will query the specified clock to obtain the current time. Using this method allows the
     * use of an alternate clock for testing. The alternate clock may be introduced using
     * {@link Clock dependency injection}.
     *
     * @param clock the clock to use, not null
     * @return the current time, not null
     */
    public static LocalTime now(Clock clock) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Obtains an instance of {@code LocalTime} from an hour and minute.
     * <p>
     * This returns a {@code LocalTime} with the specified hour and minute. The second and
     * nanosecond fields will be set to zero.
     *
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @return the local time, not null
     * @throws DateTimeException if the value of any field is out of range
     */
    public static LocalTime of(int hour, int minute) {
        HOUR_OF_DAY.checkValidValue(hour);
        if (minute == 0) {
            return HOURS[hour]; // for performance
        }
        MINUTE_OF_HOUR.checkValidValue(minute);
        return new LocalTime(hour, minute, 0, 0);
    }

    /**
     * Obtains an instance of {@code LocalTime} from an hour, minute and second.
     * <p>
     * This returns a {@code LocalTime} with the specified hour, minute and second. The nanosecond
     * field will be set to zero.
     *
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @param second the second-of-minute to represent, from 0 to 59
     * @return the local time, not null
     * @throws DateTimeException if the value of any field is out of range
     */
    public static LocalTime of(int hour, int minute, int second) {
        HOUR_OF_DAY.checkValidValue(hour);
        if ((minute | second) == 0) {
            return HOURS[hour]; // for performance
        }
        MINUTE_OF_HOUR.checkValidValue(minute);
        SECOND_OF_MINUTE.checkValidValue(second);
        return new LocalTime(hour, minute, second, 0);
    }

    /**
     * Obtains an instance of {@code LocalTime} from an hour, minute, second and nanosecond.
     * <p>
     * This returns a {@code LocalTime} with the specified hour, minute, second and nanosecond.
     *
     * @param hour the hour-of-day to represent, from 0 to 23
     * @param minute the minute-of-hour to represent, from 0 to 59
     * @param second the second-of-minute to represent, from 0 to 59
     * @param nanoOfSecond the nano-of-second to represent, from 0 to 999,999,999
     * @return the local time, not null
     * @throws DateTimeException if the value of any field is out of range
     */
    public static LocalTime of(int hour, int minute, int second, int nanoOfSecond) {
        HOUR_OF_DAY.checkValidValue(hour);
        MINUTE_OF_HOUR.checkValidValue(minute);
        SECOND_OF_MINUTE.checkValidValue(second);
        NANO_OF_SECOND.checkValidValue(nanoOfSecond);
        return create(hour, minute, second, nanoOfSecond);
    }

    /**
     * Obtains an instance of {@code LocalTime} from a second-of-day value.
     * <p>
     * This returns a {@code LocalTime} with the specified second-of-day. The nanosecond field will
     * be set to zero.
     *
     * @param secondOfDay the second-of-day, from {@code 0} to {@code 24 * 60 * 60 - 1}
     * @return the local time, not null
     * @throws DateTimeException if the second-of-day value is invalid
     */
    public static LocalTime ofSecondOfDay(long secondOfDay) {
        SECOND_OF_DAY.checkValidValue(secondOfDay);
        int hours = (int) (secondOfDay / SECONDS_PER_HOUR);
        secondOfDay -= hours * SECONDS_PER_HOUR;
        int minutes = (int) (secondOfDay / SECONDS_PER_MINUTE);
        secondOfDay -= minutes * SECONDS_PER_MINUTE;
        return create(hours, minutes, (int) secondOfDay, 0);
    }

    /**
     * Obtains an instance of {@code LocalTime} from a nanos-of-day value.
     * <p>
     * This returns a {@code LocalTime} with the specified nanosecond-of-day.
     *
     * @param nanoOfDay the nano of day, from {@code 0} to {@code 24 * 60 * 60 * 1,000,000,000 - 1}
     * @return the local time, not null
     * @throws DateTimeException if the nanos of day value is invalid
     */
    public static LocalTime ofNanoOfDay(long nanoOfDay) {
        NANO_OF_DAY.checkValidValue(nanoOfDay);
        int hours = (int) (nanoOfDay / NANOS_PER_HOUR);
        nanoOfDay -= hours * NANOS_PER_HOUR;
        int minutes = (int) (nanoOfDay / NANOS_PER_MINUTE);
        nanoOfDay -= minutes * NANOS_PER_MINUTE;
        int seconds = (int) (nanoOfDay / NANOS_PER_SECOND);
        nanoOfDay -= seconds * NANOS_PER_SECOND;
        return create(hours, minutes, seconds, (int) nanoOfDay);
    }

    /**
     * Creates a local time from the hour, minute, second and nanosecond fields.
     * <p>
     * This factory may return a cached value, but applications must not rely on this.
     *
     * @param hour the hour-of-day to represent, validated from 0 to 23
     * @param minute the minute-of-hour to represent, validated from 0 to 59
     * @param second the second-of-minute to represent, validated from 0 to 59
     * @param nanoOfSecond the nano-of-second to represent, validated from 0 to 999,999,999
     * @return the local time, not null
     */
    private static LocalTime create(int hour, int minute, int second, int nanoOfSecond) {
        if ((minute | second | nanoOfSecond) == 0) {
            return HOURS[hour];
        }
        return new LocalTime(hour, minute, second, nanoOfSecond);
    }
}
