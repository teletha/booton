/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.text;

import java.util.Arrays;
import java.util.Locale;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/07/19 20:52:31
 */
@JavaAPIProvider(java.text.DateFormatSymbols.class)
class DateFormatSymbols {

    /**
     * Era strings. For example: "AD" and "BC". An array of 2 strings, indexed by
     * <code>Calendar.BC</code> and <code>Calendar.AD</code>.
     * 
     * @serial
     */
    String eras[] = null;

    /**
     * Month strings. For example: "January", "February", etc. An array of 13 strings (some
     * calendars have 13 months), indexed by <code>Calendar.JANUARY</code>,
     * <code>Calendar.FEBRUARY</code>, etc.
     * 
     * @serial
     */
    String months[] = null;

    /**
     * Short month strings. For example: "Jan", "Feb", etc. An array of 13 strings (some calendars
     * have 13 months), indexed by <code>Calendar.JANUARY</code>, <code>Calendar.FEBRUARY</code>,
     * etc.
     * 
     * @serial
     */
    String shortMonths[] = null;

    /**
     * Weekday strings. For example: "Sunday", "Monday", etc. An array of 8 strings, indexed by
     * <code>Calendar.SUNDAY</code>, <code>Calendar.MONDAY</code>, etc. The element
     * <code>weekdays[0]</code> is ignored.
     * 
     * @serial
     */
    String weekdays[] = null;

    /**
     * Short weekday strings. For example: "Sun", "Mon", etc. An array of 8 strings, indexed by
     * <code>Calendar.SUNDAY</code>, <code>Calendar.MONDAY</code>, etc. The element
     * <code>shortWeekdays[0]</code> is ignored.
     * 
     * @serial
     */
    String shortWeekdays[] = null;

    /**
     * AM and PM strings. For example: "AM" and "PM". An array of 2 strings, indexed by
     * <code>Calendar.AM</code> and <code>Calendar.PM</code>.
     * 
     * @serial
     */
    String ampms[] = null;

    /**
     * Localized names of time zones in this locale. This is a two-dimensional array of strings of
     * size <em>n</em> by <em>m</em>, where <em>m</em> is at least 5. Each of the <em>n</em> rows is
     * an entry containing the localized names for a single <code>TimeZone</code>. Each such row
     * contains (with <code>i</code> ranging from 0..<em>n</em>-1):
     * <ul>
     * <li><code>zoneStrings[i][0]</code> - time zone ID</li>
     * <li><code>zoneStrings[i][1]</code> - long name of zone in standard time</li>
     * <li><code>zoneStrings[i][2]</code> - short name of zone in standard time</li>
     * <li><code>zoneStrings[i][3]</code> - long name of zone in daylight saving time</li>
     * <li><code>zoneStrings[i][4]</code> - short name of zone in daylight saving time</li>
     * </ul>
     * The zone ID is <em>not</em> localized; it's one of the valid IDs of the
     * {@link java.util.TimeZone TimeZone} class that are not
     * <a href="../java/util/TimeZone.html#CustomID">custom IDs</a>. All other entries are localized
     * names.
     * 
     * @see java.util.TimeZone
     * @serial
     */
    String zoneStrings[][] = null;

    /**
     * Localized date-time pattern characters. For example, a locale may wish to use 'u' rather than
     * 'y' to represent years in its date format pattern strings. This string must be exactly 18
     * characters long, with the index of the characters described by
     * <code>DateFormat.ERA_FIELD</code>, <code>DateFormat.YEAR_FIELD</code>, etc. Thus, if the
     * string were "Xz...", then localized patterns would use 'X' for era and 'z' for year.
     * 
     * @serial
     */
    String localPatternChars = null;

    /**
     * Gets era strings. For example: "AD" and "BC".
     * 
     * @return the era strings.
     */
    public String[] getEras() {
        return Arrays.copyOf(eras, eras.length);
    }

    /**
     * Sets era strings. For example: "AD" and "BC".
     * 
     * @param newEras the new era strings.
     */
    public void setEras(String[] newEras) {
        eras = Arrays.copyOf(newEras, newEras.length);
    }

    /**
     * Gets month strings. For example: "January", "February", etc.
     * <p>
     * If the language requires different forms for formatting and stand-alone usages, this method
     * returns month names in the formatting form. For example, the preferred month name for January
     * in the Czech language is <em>ledna</em> in the formatting form, while it is <em>leden</em> in
     * the stand-alone form. This method returns {@code "ledna"} in this case. Refer to the
     * <a href="http://unicode.org/reports/tr35/#Calendar_Elements"> Calendar Elements in the
     * Unicode Locale Data Markup Language (LDML) specification</a> for more details.
     *
     * @return the month strings.
     */
    public String[] getMonths() {
        return Arrays.copyOf(months, months.length);
    }

    /**
     * Sets month strings. For example: "January", "February", etc.
     * 
     * @param newMonths the new month strings.
     */
    public void setMonths(String[] newMonths) {
        months = Arrays.copyOf(newMonths, newMonths.length);
    }

    /**
     * Gets short month strings. For example: "Jan", "Feb", etc.
     * <p>
     * If the language requires different forms for formatting and stand-alone usages, This method
     * returns short month names in the formatting form. For example, the preferred abbreviation for
     * January in the Catalan language is <em>de gen.</em> in the formatting form, while it is
     * <em>gen.</em> in the stand-alone form. This method returns {@code "de gen."} in this case.
     * Refer to the <a href="http://unicode.org/reports/tr35/#Calendar_Elements"> Calendar Elements
     * in the Unicode Locale Data Markup Language (LDML) specification</a> for more details.
     *
     * @return the short month strings.
     */
    public String[] getShortMonths() {
        return Arrays.copyOf(shortMonths, shortMonths.length);
    }

    /**
     * Sets short month strings. For example: "Jan", "Feb", etc.
     * 
     * @param newShortMonths the new short month strings.
     */
    public void setShortMonths(String[] newShortMonths) {
        shortMonths = Arrays.copyOf(newShortMonths, newShortMonths.length);
    }

    /**
     * Gets weekday strings. For example: "Sunday", "Monday", etc.
     * 
     * @return the weekday strings. Use <code>Calendar.SUNDAY</code>, <code>Calendar.MONDAY</code>,
     *         etc. to index the result array.
     */
    public String[] getWeekdays() {
        return Arrays.copyOf(weekdays, weekdays.length);
    }

    /**
     * Sets weekday strings. For example: "Sunday", "Monday", etc.
     * 
     * @param newWeekdays the new weekday strings. The array should be indexed by
     *            <code>Calendar.SUNDAY</code>, <code>Calendar.MONDAY</code>, etc.
     */
    public void setWeekdays(String[] newWeekdays) {
        weekdays = Arrays.copyOf(newWeekdays, newWeekdays.length);
    }

    /**
     * Gets short weekday strings. For example: "Sun", "Mon", etc.
     * 
     * @return the short weekday strings. Use <code>Calendar.SUNDAY</code>,
     *         <code>Calendar.MONDAY</code>, etc. to index the result array.
     */
    public String[] getShortWeekdays() {
        return Arrays.copyOf(shortWeekdays, shortWeekdays.length);
    }

    /**
     * Sets short weekday strings. For example: "Sun", "Mon", etc.
     * 
     * @param newShortWeekdays the new short weekday strings. The array should be indexed by
     *            <code>Calendar.SUNDAY</code>, <code>Calendar.MONDAY</code>, etc.
     */
    public void setShortWeekdays(String[] newShortWeekdays) {
        shortWeekdays = Arrays.copyOf(newShortWeekdays, newShortWeekdays.length);
    }

    /**
     * Gets ampm strings. For example: "AM" and "PM".
     * 
     * @return the ampm strings.
     */
    public String[] getAmPmStrings() {
        return Arrays.copyOf(ampms, ampms.length);
    }

    /**
     * Sets ampm strings. For example: "AM" and "PM".
     * 
     * @param newAmpms the new ampm strings.
     */
    public void setAmPmStrings(String[] newAmpms) {
        ampms = Arrays.copyOf(newAmpms, newAmpms.length);
    }

    /**
     * Gets time zone strings. Use of this method is discouraged; use
     * {@link java.util.TimeZone#getDisplayName() TimeZone.getDisplayName()} instead.
     * <p>
     * The value returned is a two-dimensional array of strings of size <em>n</em> by <em>m</em>,
     * where <em>m</em> is at least 5. Each of the <em>n</em> rows is an entry containing the
     * localized names for a single <code>TimeZone</code>. Each such row contains (with
     * <code>i</code> ranging from 0..<em>n</em>-1):
     * <ul>
     * <li><code>zoneStrings[i][0]</code> - time zone ID</li>
     * <li><code>zoneStrings[i][1]</code> - long name of zone in standard time</li>
     * <li><code>zoneStrings[i][2]</code> - short name of zone in standard time</li>
     * <li><code>zoneStrings[i][3]</code> - long name of zone in daylight saving time</li>
     * <li><code>zoneStrings[i][4]</code> - short name of zone in daylight saving time</li>
     * </ul>
     * The zone ID is <em>not</em> localized; it's one of the valid IDs of the
     * {@link java.util.TimeZone TimeZone} class that are not
     * <a href="../util/TimeZone.html#CustomID">custom IDs</a>. All other entries are localized
     * names. If a zone does not implement daylight saving time, the daylight saving time names
     * should not be used.
     * <p>
     * If {@link #setZoneStrings(String[][]) setZoneStrings} has been called on this
     * <code>DateFormatSymbols</code> instance, then the strings provided by that call are returned.
     * Otherwise, the returned array contains names provided by the Java runtime and by installed
     * {@link java.util.spi.TimeZoneNameProvider TimeZoneNameProvider} implementations.
     *
     * @return the time zone strings.
     * @see #setZoneStrings(String[][])
     */
    public String[][] getZoneStrings() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Sets time zone strings. The argument must be a two-dimensional array of strings of size
     * <em>n</em> by <em>m</em>, where <em>m</em> is at least 5. Each of the <em>n</em> rows is an
     * entry containing the localized names for a single <code>TimeZone</code>. Each such row
     * contains (with <code>i</code> ranging from 0..<em>n</em>-1):
     * <ul>
     * <li><code>zoneStrings[i][0]</code> - time zone ID</li>
     * <li><code>zoneStrings[i][1]</code> - long name of zone in standard time</li>
     * <li><code>zoneStrings[i][2]</code> - short name of zone in standard time</li>
     * <li><code>zoneStrings[i][3]</code> - long name of zone in daylight saving time</li>
     * <li><code>zoneStrings[i][4]</code> - short name of zone in daylight saving time</li>
     * </ul>
     * The zone ID is <em>not</em> localized; it's one of the valid IDs of the
     * {@link java.util.TimeZone TimeZone} class that are not
     * <a href="../util/TimeZone.html#CustomID">custom IDs</a>. All other entries are localized
     * names.
     *
     * @param newZoneStrings the new time zone strings.
     * @exception IllegalArgumentException if the length of any row in <code>newZoneStrings</code>
     *                is less than 5
     * @exception NullPointerException if <code>newZoneStrings</code> is null
     * @see #getZoneStrings()
     */
    public void setZoneStrings(String[][] newZoneStrings) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Gets localized date-time pattern characters. For example: 'u', 't', etc.
     * 
     * @return the localized date-time pattern characters.
     */
    public String getLocalPatternChars() {
        return localPatternChars;
    }

    /**
     * Sets localized date-time pattern characters. For example: 'u', 't', etc.
     * 
     * @param newLocalPatternChars the new localized date-time pattern characters.
     */
    public void setLocalPatternChars(String newLocalPatternChars) {
        // Call toString() to throw an NPE in case the argument is null
        localPatternChars = newLocalPatternChars.toString();
    }

    /**
     * Gets the <code>DateFormatSymbols</code> instance for the default locale. This method provides
     * access to <code>DateFormatSymbols</code> instances for locales supported by the Java runtime
     * itself as well as for those supported by installed
     * {@link java.text.spi.DateFormatSymbolsProvider DateFormatSymbolsProvider} implementations.
     * <p>
     * This is equivalent to calling {@link #getInstance(Locale)
     * getInstance(Locale.getDefault(Locale.Category.FORMAT))}.
     * 
     * @see java.util.Locale#getDefault(java.util.Locale.Category)
     * @see java.util.Locale.Category#FORMAT
     * @return a <code>DateFormatSymbols</code> instance.
     * @since 1.6
     */
    public static final DateFormatSymbols getInstance() {
        return new DateFormatSymbols();
    }

    /**
     * Gets the <code>DateFormatSymbols</code> instance for the specified locale. This method
     * provides access to <code>DateFormatSymbols</code> instances for locales supported by the Java
     * runtime itself as well as for those supported by installed
     * {@link java.text.spi.DateFormatSymbolsProvider DateFormatSymbolsProvider} implementations.
     * 
     * @param locale the given locale.
     * @return a <code>DateFormatSymbols</code> instance.
     * @exception NullPointerException if <code>locale</code> is null
     * @since 1.6
     */
    public static final DateFormatSymbols getInstance(Locale locale) {
        return getInstance();
    }

    /**
     * Returns an array of all locales for which the <code>getInstance</code> methods of this class
     * can return localized instances. The returned array represents the union of locales supported
     * by the Java runtime and by installed {@link java.text.spi.DateFormatSymbolsProvider
     * DateFormatSymbolsProvider} implementations. It must contain at least a <code>Locale</code>
     * instance equal to {@link java.util.Locale#US Locale.US}.
     *
     * @return An array of locales for which localized <code>DateFormatSymbols</code> instances are
     *         available.
     * @since 1.6
     */
    public static Locale[] getAvailableLocales() {
        return Locale.getAvailableLocales();
    }
}
