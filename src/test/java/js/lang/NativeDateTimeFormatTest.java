/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import js.lang.NativeIntl.DateTimeFormat;
import js.lang.NativeIntl.DateTimeFormat.Option;

/**
 * @version 2015/08/08 9:45:04
 */
@RunWith(ScriptRunner.class)
public class NativeDateTimeFormatTest {

    @Test
    public void format() throws Exception {
        DateTimeFormat en = new DateTimeFormat("en");
        DateTimeFormat jp = new DateTimeFormat("jp");

        assert en.format(0).equals("70/01/01 0:00");
        assert jp.format(0).equals("70/01/01 0:00");
    }

    public void option() throws Exception {
        Option option = new Option();
        option.year = "numeric";

        DateTimeFormat format = new DateTimeFormat("en", option);
        String text = format.format(0);
        System.out.println(text);
    }

}
