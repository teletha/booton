/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.stream;

import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/06/25 19:03:02
 */
@RunWith(ScriptRunner.class)
public class StreamTest {

    @Test
    @Ignore
    public void count() throws Exception {
        Stream<String> stream = Stream.of("A", "B", "C");
        assert stream.count() == 3;
    }
}
