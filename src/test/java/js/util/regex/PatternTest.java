/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.regex;

import java.util.regex.Pattern;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/28 8:39:00
 */
@RunWith(ScriptRunner.class)
public class PatternTest {

    @Test
    public void compile() {
        Pattern pattern = Pattern.compile("success");
        assert pattern.pattern().equals("success");
        assert pattern.matcher("success").matches();
        assert !pattern.matcher("fail").matches();
        assert !pattern.matcher("SUCCESS").matches();
    }

    @Test
    public void ignoreCase() {
        Pattern pattern = Pattern.compile("success", Pattern.CASE_INSENSITIVE);
        assert pattern.pattern().equals("success");
        assert pattern.matcher("success").matches();
        assert !pattern.matcher("fail").matches();
        assert pattern.matcher("SUCCESS").matches();
    }

    @Test
    public void matches() throws Exception {
        assert Pattern.matches("\\d+", "12345");
        assert !Pattern.matches("\\d+", "123F5");
    }
}
