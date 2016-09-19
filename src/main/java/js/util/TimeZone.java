/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.PropertyPermission;
import java.util.ResourceBundle;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 16:49:27
 */
@JavaAPIProvider(java.util.TimeZone.class)
class TimeZone {

    /** The default time zone. */
    private static TimeZone def;

    /**
     * The string identifier of this <code>TimeZone</code>. This is a programmatic identifier used
     * internally to look up <code>TimeZone</code> objects from the system table and also to map
     * them to their localized display names. <code>ID</code> values are unique in the system table
     * but may not be for dynamically created zones.
     * 
     * @serial
     */
    private String ID;

    /**
     * Gets the ID of this time zone.
     * 
     * @return the ID of this time zone.
     */
    public String getID() {
        return ID;
    }

    /**
     * Sets the time zone ID. This does not change any other data in the time zone object.
     * 
     * @param ID the new time zone ID.
     */
    public void setID(String ID) {
        if (ID == null) {
            throw new NullPointerException();
        }
        this.ID = ID;
    }

    /**
     * Returns a long standard time name of this {@code TimeZone} suitable for presentation to the
     * user in the default locale.
     * <p>
     * This method is equivalent to: <blockquote><pre>
     * getDisplayName(false, {@link #LONG},
     *                Locale.getDefault({@link Locale.Category#DISPLAY}))
     * </pre></blockquote>
     *
     * @return the human-readable name of this time zone in the default locale.
     * @since 1.2
     * @see #getDisplayName(boolean, int, Locale)
     * @see Locale#getDefault(Locale.Category)
     * @see Locale.Category
     */
    public final String getDisplayName() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns a long standard time name of this {@code TimeZone} suitable for presentation to the
     * user in the specified {@code locale}.
     * <p>
     * This method is equivalent to: <blockquote><pre>
     * getDisplayName(false, {@link #LONG}, locale)
     * </pre></blockquote>
     *
     * @param locale the locale in which to supply the display name.
     * @return the human-readable name of this time zone in the given locale.
     * @exception NullPointerException if {@code locale} is {@code null}.
     * @since 1.2
     * @see #getDisplayName(boolean, int, Locale)
     */
    public final String getDisplayName(Locale locale) {
        return getDisplayName();
    }

    /**
     * Returns a name in the specified {@code style} of this {@code TimeZone} suitable for
     * presentation to the user in the default locale. If the specified {@code daylight} is
     * {@code true}, a Daylight Saving Time name is returned (even if this {@code TimeZone} doesn't
     * observe Daylight Saving Time). Otherwise, a Standard Time name is returned.
     * <p>
     * This method is equivalent to: <blockquote><pre>
     * getDisplayName(daylight, style,
     *                Locale.getDefault({@link Locale.Category#DISPLAY}))
     * </pre></blockquote>
     *
     * @param daylight {@code true} specifying a Daylight Saving Time name, or {@code false}
     *            specifying a Standard Time name
     * @param style either {@link #LONG} or {@link #SHORT}
     * @return the human-readable name of this time zone in the default locale.
     * @exception IllegalArgumentException if {@code style} is invalid.
     * @since 1.2
     * @see #getDisplayName(boolean, int, Locale)
     * @see Locale#getDefault(Locale.Category)
     * @see Locale.Category
     * @see java.text.DateFormatSymbols#getZoneStrings()
     */
    public final String getDisplayName(boolean daylight, int style) {
        return getDisplayName();
    }

    /**
     * Returns a name in the specified {@code style} of this {@code TimeZone} suitable for
     * presentation to the user in the specified {@code
     * locale}. If the specified {@code daylight} is {@code true}, a Daylight Saving Time name is
     * returned (even if this {@code TimeZone} doesn't observe Daylight Saving Time). Otherwise, a
     * Standard Time name is returned.
     * <p>
     * When looking up a time zone name, the
     * {@linkplain ResourceBundle.Control#getCandidateLocales(String,Locale) default
     * <code>Locale</code> search path of <code>ResourceBundle</code>} derived from the specified
     * {@code locale} is used. (No
     * {@linkplain ResourceBundle.Control#getFallbackLocale(String,Locale) fallback
     * <code>Locale</code>} search is performed.) If a time zone name in any {@code Locale} of the
     * search path, including {@link Locale#ROOT}, is found, the name is returned. Otherwise, a
     * string in the <a href="#NormalizedCustomID">normalized custom ID format</a> is returned.
     *
     * @param daylight {@code true} specifying a Daylight Saving Time name, or {@code false}
     *            specifying a Standard Time name
     * @param style either {@link #LONG} or {@link #SHORT}
     * @param locale the locale in which to supply the display name.
     * @return the human-readable name of this time zone in the given locale.
     * @exception IllegalArgumentException if {@code style} is invalid.
     * @exception NullPointerException if {@code locale} is {@code null}.
     * @since 1.2
     * @see java.text.DateFormatSymbols#getZoneStrings()
     */
    public String getDisplayName(boolean daylight, int style, Locale locale) {
        return getDisplayName();
    }

    /**
     * Returns the offset of this time zone from UTC at the specified date. If Daylight Saving Time
     * is in effect at the specified date, the offset value is adjusted with the amount of daylight
     * saving.
     * <p>
     * This method returns a historically correct offset value if an underlying TimeZone
     * implementation subclass supports historical Daylight Saving Time schedule and GMT offset
     * changes.
     *
     * @param date the date represented in milliseconds since January 1, 1970 00:00:00 GMT
     * @return the amount of time in milliseconds to add to UTC to get local time.
     * @see Calendar#ZONE_OFFSET
     * @see Calendar#DST_OFFSET
     * @since 1.4
     */
    public int getOffset(long date) {
        if (inDaylightTime(new Date(date))) {
            return getRawOffset() + getDSTSavings();
        }
        return getRawOffset();
    }

    /**
     * Returns the amount of time in milliseconds to add to UTC to get standard time in this time
     * zone. Because this value is not affected by daylight saving time, it is called <I>raw
     * offset</I>.
     * <p>
     * If an underlying <code>TimeZone</code> implementation subclass supports historical GMT offset
     * changes, the method returns the raw offset value of the current date. In Honolulu, for
     * example, its raw offset changed from GMT-10:30 to GMT-10:00 in 1947, and this method always
     * returns -36000000 milliseconds (i.e., -10 hours).
     *
     * @return the amount of raw offset time in milliseconds to add to UTC.
     * @see Calendar#ZONE_OFFSET
     */
    public int getRawOffset() {
        return 0;
    }

    /**
     * Returns the amount of time to be added to local standard time to get local wall clock time.
     * <p>
     * The default implementation returns 3600000 milliseconds (i.e., one hour) if a call to
     * {@link #useDaylightTime()} returns {@code true}. Otherwise, 0 (zero) is returned.
     * <p>
     * If an underlying {@code TimeZone} implementation subclass supports historical and future
     * Daylight Saving Time schedule changes, this method returns the amount of saving time of the
     * last known Daylight Saving Time rule that can be a future prediction.
     * <p>
     * If the amount of saving time at any given time stamp is required, construct a
     * {@link Calendar} with this {@code
     * TimeZone} and the time stamp, and call {@link Calendar#get(int) Calendar.get}{@code (}
     * {@link Calendar#DST_OFFSET}{@code )}.
     *
     * @return the amount of saving time in milliseconds
     * @since 1.4
     * @see #inDaylightTime(Date)
     * @see #getOffset(long)
     * @see #getOffset(int,int,int,int,int,int)
     * @see Calendar#ZONE_OFFSET
     */
    public int getDSTSavings() {
        if (useDaylightTime()) {
            return 3600000;
        }
        return 0;
    }

    /**
     * Queries if this {@code TimeZone} uses Daylight Saving Time.
     * <p>
     * If an underlying {@code TimeZone} implementation subclass supports historical and future
     * Daylight Saving Time schedule changes, this method refers to the last known Daylight Saving
     * Time rule that can be a future prediction and may not be the same as the current rule.
     * Consider calling {@link #observesDaylightTime()} if the current rule should also be taken
     * into account.
     *
     * @return {@code true} if this {@code TimeZone} uses Daylight Saving Time, {@code false},
     *         otherwise.
     * @see #inDaylightTime(Date)
     * @see Calendar#DST_OFFSET
     */
    public boolean useDaylightTime() {
        return false;
    }

    /**
     * Queries if the given {@code date} is in Daylight Saving Time in this time zone.
     *
     * @param date the given Date.
     * @return {@code true} if the given date is in Daylight Saving Time, {@code false}, otherwise.
     */
    public boolean inDaylightTime(Date date) {
        return false;
    }

    // /**
    // * Converts this {@code TimeZone} object to a {@code ZoneId}.
    // *
    // * @return a {@code ZoneId} representing the same time zone as this {@code TimeZone}
    // * @since 1.8
    // */
    // public ZoneId toZoneId() {
    // return ZoneId.of(getID(), ZoneId.SHORT_IDS);
    // }

    /**
     * Creates a copy of this <code>TimeZone</code>.
     *
     * @return a clone of this <code>TimeZone</code>
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            TimeZone other = (TimeZone) super.clone();
            other.ID = ID;
            return other;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    // /**
    // * Converts this {@code TimeZone} object to a {@code ZoneId}.
    // *
    // * @return a {@code ZoneId} representing the same time zone as this {@code TimeZone}
    // * @since 1.8
    // */
    // public ZoneId toZoneId() {
    // String id = getID();
    // if ("EST".equals(id)) return ZoneId.of("America/New_York");
    // if ("MST".equals(id)) return ZoneId.of("America/Denver");
    // if ("HST".equals(id)) return ZoneId.of("America/Honolulu");
    // return ZoneId.of(id, ZoneId.SHORT_IDS);
    // }

    /**
     * Gets the default {@code TimeZone} of the Java virtual machine. If the cached default
     * {@code TimeZone} is available, its clone is returned. Otherwise, the method takes the
     * following steps to determine the default time zone.
     * <ul>
     * <li>Use the {@code user.timezone} property value as the default time zone ID if it's
     * available.</li>
     * <li>Detect the platform time zone ID. The source of the platform time zone and ID mapping may
     * vary with implementation.</li>
     * <li>Use {@code GMT} as the last resort if the given or detected time zone ID is unknown.</li>
     * </ul>
     * <p>
     * The default {@code TimeZone} created from the ID is cached, and its clone is returned. The
     * {@code user.timezone} property value is set to the ID upon return.
     *
     * @return the default {@code TimeZone}
     * @see #setDefault(TimeZone)
     */
    public static TimeZone getDefault() {
        return def;
    }

    /**
     * Sets the {@code TimeZone} that is returned by the {@code getDefault} method. {@code zone} is
     * cached. If {@code zone} is null, the cached default {@code TimeZone} is cleared. This method
     * doesn't change the value of the {@code user.timezone} property.
     *
     * @param zone the new default {@code TimeZone}, or null
     * @throws SecurityException if the security manager's {@code checkPermission} denies
     *             {@code PropertyPermission("user.timezone",
     *                           "write")}
     * @see #getDefault
     * @see PropertyPermission
     */
    public static void setDefault(TimeZone zone) {
        def = zone;
    }

    /**
     * Gets the <code>TimeZone</code> for the given ID.
     *
     * @param ID the ID for a <code>TimeZone</code>, either an abbreviation such as "PST", a full
     *            name such as "America/Los_Angeles", or a custom ID such as "GMT-8:00". Note that
     *            the support of abbreviations is for JDK 1.1.x compatibility only and full names
     *            should be used.
     * @return the specified <code>TimeZone</code>, or the GMT zone if the given ID cannot be
     *         understood.
     */
    public static synchronized TimeZone getTimeZone(String ID) {
        return getTimeZone(ID, true);
    }

    private static TimeZone getTimeZone(String ID, boolean fallback) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
