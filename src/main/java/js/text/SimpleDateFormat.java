/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.text;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/05/18 13:08:42
 */
@JavaAPIProvider(java.text.SimpleDateFormat.class)
class SimpleDateFormat extends DateFormat {

    /**
     * {@inheritDoc}
     */
    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date parse(String source, ParsePosition pos) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Parses text from the beginning of the given string to produce a date. The method may not use
     * the entire text of the given string.
     * <p>
     * See the {@link #parse(String, ParsePosition)} method for more information on date parsing.
     *
     * @param source A <code>String</code> whose beginning should be parsed.
     * @return A <code>Date</code> parsed from the string.
     * @exception ParseException if the beginning of the specified string cannot be parsed.
     */
    @Override
    public Date parse(String source) throws ParseException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();

    }
}
