/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time.format;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.format.TextStyle;
import java.time.temporal.TemporalQueries;
import java.util.Locale;
import java.util.Set;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/04/24 15:16:38
 */
@JavaAPIProvider(java.time.format.DateTimeFormatterBuilder.class)
class DateTimeFormatterBuilder {

    /** The formatter. */
    private StringBuilder builder = new StringBuilder();

    /**
     * Appends the time-zone name, such as 'British Summer Time', to the formatter.
     * <p>
     * This appends an instruction to format/parse the textual name of the zone to the builder.
     * <p>
     * During formatting, the zone is obtained using a mechanism equivalent to querying the temporal
     * with {@link TemporalQueries#zoneId()}. If the zone is a {@code ZoneOffset} it will be printed
     * using the result of {@link ZoneOffset#getId()}. If the zone is not an offset, the textual
     * name will be looked up for the locale set in the {@link DateTimeFormatter}. If the temporal
     * object being printed represents an instant, then the text will be the summer or winter time
     * text as appropriate. If the lookup for text does not find any suitable reuslt, then the
     * {@link ZoneId#getId() ID} will be printed instead. If the zone cannot be obtained then an
     * exception is thrown unless the section of the formatter is optional.
     * <p>
     * During parsing, either the textual zone name, the zone ID or the offset is accepted. Many
     * textual zone names are not unique, such as CST can be for both "Central Standard Time" and
     * "China Standard Time". In this situation, the zone id will be determined by the region
     * information from formatter's {@link DateTimeFormatter#getLocale() locale} and the standard
     * zone id for that area, for example, America/New_York for the America Eastern zone. The
     * {@link #appendZoneText(TextStyle, Set)} may be used to specify a set of preferred
     * {@link ZoneId} in this situation.
     *
     * @param textStyle the text style to use, not null
     * @return this, for chaining, not null
     */
    public DateTimeFormatterBuilder appendZoneText(TextStyle textStyle) {
        switch (textStyle) {
        case FULL:
        case FULL_STANDALONE:
            builder.append("ZZ");
            break;

        default:
            builder.append("z");
            break;
        }
        return this;
    }

    /**
     * Completes this builder by creating the {@code DateTimeFormatter} using the default locale.
     * <p>
     * This will create a formatter with the {@linkplain Locale#getDefault(Locale.Category) default
     * FORMAT locale}. Numbers will be printed and parsed using the standard DecimalStyle. The
     * resolver style will be {@link ResolverStyle#SMART SMART}.
     * <p>
     * Calling this method will end any open optional sections by repeatedly calling
     * {@link #optionalEnd()} before creating the formatter.
     * <p>
     * This builder can still be used after creating the formatter if desired, although the state
     * may have been changed by calls to {@code optionalEnd}.
     *
     * @return the created formatter, not null
     */
    public DateTimeFormatter toFormatter() {
        return toFormatter(Locale.getDefault(Locale.Category.FORMAT));
    }

    /**
     * Completes this builder by creating the {@code DateTimeFormatter} using the specified locale.
     * <p>
     * This will create a formatter with the specified locale. Numbers will be printed and parsed
     * using the standard DecimalStyle. The resolver style will be {@link ResolverStyle#SMART SMART}.
     * <p>
     * Calling this method will end any open optional sections by repeatedly calling
     * {@link #optionalEnd()} before creating the formatter.
     * <p>
     * This builder can still be used after creating the formatter if desired, although the state
     * may have been changed by calls to {@code optionalEnd}.
     *
     * @param locale the locale to use for formatting, not null
     * @return the created formatter, not null
     */
    public DateTimeFormatter toFormatter(Locale locale) {
        return (DateTimeFormatter) (Object) new js.time.format.DateTimeFormatter(builder.toString());
    }
}
