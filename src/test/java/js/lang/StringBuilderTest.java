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
    public void appendPrimitive() throws Exception {
        StringBuilder builder = new StringBuilder();
        assert builder.append(1).toString().equals("1");
        assert builder.append(0.1D).toString().equals("10.1");
        assert builder.append(12345678901L).toString().equals("10.112345678901");
        assert builder.append(9.9F).toString().equals("10.1123456789019.9");
        assert builder.append(false).toString().equals("10.1123456789019.9false");
        assert builder.append((short) 24).toString().equals("10.1123456789019.9false24");
        assert builder.append((byte) 0).toString().equals("10.1123456789019.9false240");
    }

    @Test
    public void appendString() throws Exception {
        StringBuilder builder = new StringBuilder();
        assert builder.append("add").toString().equals("add");
        assert builder.append("").toString().equals("add");
        assert builder.append(this).toString().equals("addTest");
        assert builder.append((String) null).toString().equals("addTestnull");
    }

    @Test
    public void appendNull() throws Exception {
        StringBuilder builder = new StringBuilder();
        assert builder.append((String) null).toString().equals("null");
        assert builder.append((Object) null).toString().equals("nullnull");
    }

    @Test
    public void appendCharSequence() throws Exception {
        StringBuilder builder = new StringBuilder("");
        assert builder.append((CharSequence) "value").toString().equals("value");
        assert builder.append((CharSequence) "").toString().equals("value");
        assert builder.append((CharSequence) null).toString().equals("valuenull");
    }

    @Test
    public void appendCharSequenceRange() throws Exception {
        StringBuilder builder = new StringBuilder("");
        assert builder.append((CharSequence) "value", 2, 3).toString().equals("l");
        assert builder.append((CharSequence) "value", 2, 2).toString().equals("l");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharSequenceInvalidStartRange() throws Exception {
        new StringBuilder().append("value", -1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharSequenceInvalidEndRange() throws Exception {
        new StringBuilder().append("value", 1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharSequenceInvalidRange() throws Exception {
        new StringBuilder().append("value", 2, 1);
    }

    @Test
    public void appendChar() throws Exception {
        StringBuilder builder = new StringBuilder();
        assert builder.append(new char[] {'v', 'a', 'l', 'u', 'e'}).toString().equals("value");
        assert builder.append(new char[0]).toString().equals("value");
    }

    @Test(expected = NullPointerException.class)
    public void appendCharNull() throws Exception {
        new StringBuilder().append((char[]) null);
    }

    @Test
    public void appendCharRange() throws Exception {
        StringBuilder builder = new StringBuilder();
        assert builder.append(new char[] {'v', 'a', 'l', 'u', 'e'}, 1, 3).toString().equals("alu");
        assert builder.append(new char[0], 0, 0).toString().equals("alu");
    }

    @Test(expected = NullPointerException.class)
    public void appendCharRangeNull() throws Exception {
        new StringBuilder().append((char[]) null, 0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharInvalidStartRange() throws Exception {
        new StringBuilder().append("value".toCharArray(), -1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharInvalidEndRange() throws Exception {
        new StringBuilder().append("value".toCharArray(), 1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharInvalidRange() throws Exception {
        new StringBuilder().append("value".toCharArray(), 2, -1);
    }

    @Test
    public void insertPrimitive() throws Exception {
        StringBuilder builder = new StringBuilder("0123456789");
        assert builder.insert(8, 0).toString().equals("01234567089");
        assert builder.insert(7, 0.1F).toString().equals("01234560.17089");
        assert builder.insert(5, 987654321098L).toString().equals("01234987654321098560.17089");
        assert builder.insert(4, -9.876543210987D).toString().equals("0123-9.8765432109874987654321098560.17089");
        assert builder.insert(3, true).toString().equals("012true3-9.8765432109874987654321098560.17089");
        assert builder.insert(2, (short) 8).toString().equals("0182true3-9.8765432109874987654321098560.17089");
        assert builder.insert(1, (byte) 2).toString().equals("02182true3-9.8765432109874987654321098560.17089");
    }

    @Test
    public void insertString() throws Exception {
        StringBuilder builder = new StringBuilder("0123");
        assert builder.insert(2, "value").toString().equals("01value23");
        assert builder.insert(1, "").toString().equals("01value23");
        assert builder.insert(0, (String) null).toString().equals("null01value23");
    }

    @Test
    public void insertCharSequence() throws Exception {
        StringBuilder builder = new StringBuilder("0123");
        assert builder.insert(2, (CharSequence) "value").toString().equals("01value23");
        assert builder.insert(1, (CharSequence) "").toString().equals("01value23");
        assert builder.insert(0, (CharSequence) null).toString().equals("null01value23");
    }

    @Test
    public void insertCharSequenceRange() throws Exception {
        StringBuilder builder = new StringBuilder("0123");
        assert builder.insert(2, (CharSequence) "value", 2, 3).toString().equals("01l23");
        assert builder.insert(2, (CharSequence) "value", 2, 2).toString().equals("01l23");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharSequenceInvalidStartRange() throws Exception {
        new StringBuilder("value").insert(2, "value", -1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharSequenceInvalidEndRange() throws Exception {
        new StringBuilder("value").insert(2, "value", 1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharSequenceInvalidRange() throws Exception {
        new StringBuilder("value").insert(2, "value", 2, 1);
    }

    @Test
    public void insertChar() throws Exception {
        StringBuilder builder = new StringBuilder("0123");
        assert builder.insert(2, new char[] {'v', 'a', 'l', 'u', 'e'}).toString().equals("01value23");
        assert builder.insert(1, new char[0]).toString().equals("01value23");
    }

    @Test(expected = NullPointerException.class)
    public void insertCharNull() throws Exception {
        new StringBuilder("value").insert(2, (char[]) null);
    }

    @Test
    public void insertCharRange() throws Exception {
        StringBuilder builder = new StringBuilder("0123");
        assert builder.insert(2, new char[] {'v', 'a', 'l', 'u', 'e'}, 1, 3).toString().equals("01alu23");
        assert builder.insert(1, new char[0], 0, 0).toString().equals("01alu23");
    }

    @Test(expected = NullPointerException.class)
    public void insertCharRangeNull() throws Exception {
        new StringBuilder("value").insert(2, (char[]) null, 0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharInvalidStartRange() throws Exception {
        new StringBuilder("value").insert(2, "value".toCharArray(), -1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharInvalidEndRange() throws Exception {
        new StringBuilder("value").insert(2, "value".toCharArray(), 1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharInvalidRange() throws Exception {
        new StringBuilder("value").insert(2, "value".toCharArray(), 2, -1);
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
