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

import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.TemporalQuery;
import java.util.Objects;

/**
 * @version 2014/04/24 15:23:34
 */
// @JavaAPIProvider(java.time.format.DateTimeFormatter.class)
class DateTimeFormatter {

    /**
     * The ISO date-time formatter that formats or parses a date-time without an offset, such as
     * '2011-12-03T10:15:30'.
     * <p>
     * This returns an immutable formatter capable of formatting and parsing the ISO-8601 extended
     * offset date-time format. The format consists of:
     * <ul>
     * <li>The {@link #ISO_LOCAL_DATE}
     * <li>The letter 'T'. Parsing is case insensitive.
     * <li>The {@link #ISO_LOCAL_TIME}
     * </ul>
     * <p>
     * The returned formatter has a chronology of ISO set to ensure dates in other calendar systems
     * are correctly converted. It has no override zone and uses the {@link ResolverStyle#STRICT
     * STRICT} resolver style.
     */
    public static final DateTimeFormatter ISO_LOCAL_DATE_TIME = new DateTimeFormatter("YYYY-MM-DDThh:mm:ss+Z");

    /** The pattern. */
    private final String format;

    /**
     * @param format
     */
    DateTimeFormatter(String format) {
        this.format = format;
    }

    /**
     * Fully parses the text producing an object of the specified type.
     * <p>
     * Most applications should use this method for parsing. It parses the entire text to produce
     * the required date-time. The query is typically a method reference to a
     * {@code from(TemporalAccessor)} method. For example:
     * 
     * <pre>
     *  LocalDateTime dt = parser.parse(str, LocalDateTime::from);
     * </pre>
     * If the parse completes without reading the entire length of the text, or a problem occurs
     * during parsing or merging, then an exception is thrown.
     *
     * @param <T> the type of the parsed date-time
     * @param text the text to parse, not null
     * @param query the query defining the type to parse to, not null
     * @return the parsed date-time, not null
     * @throws DateTimeParseException if unable to parse the requested result
     */
    public <T> T parse(CharSequence text, TemporalQuery<T> query) {
        Objects.requireNonNull(text, "text");
        Objects.requireNonNull(query, "query");

        try {
            return parseResolved0(text, null).query(query);
        } catch (DateTimeParseException ex) {
            throw ex;
        } catch (RuntimeException ex) {
            throw createError(text, ex);
        }
    }
}
