/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import java.util.Date;

import booton.translator.Translator;

/**
 * @version 2013/01/08 12:03:52
 */
class DateCoder extends Translator<Date> {

    public String Date() {
        return "new Date()";
    }

    public String getTime() {
        return that + ".getTime()";
    }
}
