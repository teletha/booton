/*
 * Copyright (C) 2013 Nameless Production Committee
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

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/28 12:57:57
 */
@RunWith(ScriptRunner.class)
public class StringBuilderTest {

    @Test
    public void constructor() throws Exception {
        assert new StringBuilder().toString().equals("");
        assert new StringBuilder("init").toString().equals("init");
    }

    @Test
    public void append() throws Exception {
        StringBuilder builder = new StringBuilder();
        assert builder.append(1).toString().equals("1");
        assert builder.append(0.1D).toString().equals("10.1");
        assert builder.append(12345678901L).toString().equals("10.112345678901");

        builder = new StringBuilder();
        assert builder.append("add").toString().equals("add");
        assert builder.append(this).toString().equals("addTest");
    }

    @Test
    public void appendNull() throws Exception {
        StringBuilder builder = new StringBuilder();
        assert builder.append((String) null).toString().equals("null");
        assert builder.append((Object) null).toString().equals("nullnull");
    }

    @Test
    public void insert() throws Exception {
        StringBuilder builder = new StringBuilder("0123456789");
        assert builder.insert(8, 0).toString().equals("01234567089");
    }

    @Test
    public void delete() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("test");
        builder.delete(0, 2);

        assert builder.toString().equals("st");
    }

    @Test
    public void deleteCharAt() throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("test");
        builder.deleteCharAt(1);

        assert builder.toString().equals("tst");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Test";
    }
}
