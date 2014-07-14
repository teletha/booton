/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.time.ZoneId;
import java.util.PropertyPermission;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/25 16:49:27
 */
@JavaAPIProvider(java.util.TimeZone.class)
class TimeZone {

    /** The default time zone. */
    private static TimeZone def;

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

    /**
     * Converts this {@code TimeZone} object to a {@code ZoneId}.
     *
     * @return a {@code ZoneId} representing the same time zone as this {@code TimeZone}
     * @since 1.8
     */
    public ZoneId toZoneId() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

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
}
