/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.time.LocalDateTime;

import js.lang.NativeIntl.DateTimeFormat;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/09 23:02:23
 */
@RunWith(ScriptRunner.class)
public class NativeDateTimeFormatTest {

    @Test
    public void format() throws Exception {

        DateTimeFormat format = new DateTimeFormat("en");
        String text = format.format(LocalDateTime.of(2014, 3, 7, 1, 1));
        System.out.println(text);
    }
}
