/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/03/13 10:13:10
 */
@RunWith(ScriptRunner.class)
public class LocaleTest {

    private Locale US = Locale.US;

    private Locale JAPAN = Locale.JAPAN;

    @Test
    public void getScript() throws Exception {
        assert US.getScript().equals("");
        assert JAPAN.getScript().equals("");
    }

    @Test
    public void getUnicodeLocaleType() throws Exception {
        assert US.getUnicodeLocaleType("us") == null;
        assert JAPAN.getUnicodeLocaleType("jp") == null;
    }
}
