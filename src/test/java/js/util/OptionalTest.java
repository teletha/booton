/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/30 19:56:07
 */
@RunWith(ScriptRunner.class)
public class OptionalTest {

    @Test
    public void get() throws Exception {
        Optional<String> optional = Optional.of("test");

        assert optional.isPresent();
        assert optional.orElse("other").equals("test");
        assert optional.get().equals("test");
    }

    @Test
    public void equals() throws Exception {
        Optional<String> optional1 = Optional.of("test");
        Optional<String> optional2 = Optional.of("test");

        assert optional1.equals(optional2);
    }

    @Test(expected = NoSuchElementException.class)
    public void empty() throws Exception {
        Optional<String> optional = Optional.empty();

        assert !optional.isPresent();
        assert optional.orElse("other").equals("other");
        optional.get();
    }
}
