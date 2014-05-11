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

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/31 23:28:11
 */
@RunWith(ScriptRunner.class)
public class StringBufferTest {

    @Test
    public void constructor() throws Exception {
        assert new StringBuffer().toString().equals("");
        assert new StringBuffer("init").toString().equals("init");
    }

    @Test
    public void appendPrimitive() throws Exception {
        StringBuffer builder = new StringBuffer();
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
        StringBuffer builder = new StringBuffer();
        assert builder.append("add").toString().equals("add");
        assert builder.append("").toString().equals("add");
        assert builder.append(this).toString().equals("addTest");
        assert builder.append((String) null).toString().equals("addTestnull");
    }

    @Test
    public void appendNull() throws Exception {
        StringBuffer builder = new StringBuffer();
        assert builder.append((String) null).toString().equals("null");
        assert builder.append((Object) null).toString().equals("nullnull");
    }

    @Test
    public void appendCharSequence() throws Exception {
        StringBuffer builder = new StringBuffer("");
        assert builder.append((CharSequence) "value").toString().equals("value");
        assert builder.append((CharSequence) "").toString().equals("value");
        assert builder.append((CharSequence) null).toString().equals("valuenull");
    }

    @Test
    public void appendCharSequenceRange() throws Exception {
        StringBuffer builder = new StringBuffer("");
        assert builder.append((CharSequence) "value", 2, 3).toString().equals("l");
        assert builder.append((CharSequence) "value", 2, 2).toString().equals("l");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharSequenceInvalidStartRange() throws Exception {
        new StringBuffer().append("value", -1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharSequenceInvalidEndRange() throws Exception {
        new StringBuffer().append("value", 1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharSequenceInvalidRange() throws Exception {
        new StringBuffer().append("value", 2, 1);
    }

    @Test
    public void appendChar() throws Exception {
        StringBuffer builder = new StringBuffer();
        assert builder.append(new char[] {'v', 'a', 'l', 'u', 'e'}).toString().equals("value");
        assert builder.append(new char[0]).toString().equals("value");
    }

    @Test(expected = NullPointerException.class)
    public void appendCharNull() throws Exception {
        new StringBuffer().append((char[]) null);
    }

    @Test
    public void appendCharRange() throws Exception {
        StringBuffer builder = new StringBuffer();
        assert builder.append(new char[] {'v', 'a', 'l', 'u', 'e'}, 1, 3).toString().equals("alu");
        assert builder.append(new char[0], 0, 0).toString().equals("alu");
    }

    @Test(expected = NullPointerException.class)
    public void appendCharRangeNull() throws Exception {
        new StringBuffer().append((char[]) null, 0, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharInvalidStartRange() throws Exception {
        new StringBuffer().append("value".toCharArray(), -1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharInvalidEndRange() throws Exception {
        new StringBuffer().append("value".toCharArray(), 1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void appendCharInvalidRange() throws Exception {
        new StringBuffer().append("value".toCharArray(), 2, -1);
    }

    @Test
    public void insertPrimitive() throws Exception {
        StringBuffer builder = new StringBuffer("0123456789");
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
        StringBuffer builder = new StringBuffer("0123");
        assert builder.insert(2, "value").toString().equals("01value23");
        assert builder.insert(1, "").toString().equals("01value23");
        assert builder.insert(0, (String) null).toString().equals("null01value23");
    }

    @Test
    public void insertCharSequence() throws Exception {
        StringBuffer builder = new StringBuffer("0123");
        assert builder.insert(2, (CharSequence) "value").toString().equals("01value23");
        assert builder.insert(1, (CharSequence) "").toString().equals("01value23");
        assert builder.insert(0, (CharSequence) null).toString().equals("null01value23");
    }

    @Test
    public void insertCharSequenceRange() throws Exception {
        StringBuffer builder = new StringBuffer("0123");
        assert builder.insert(2, (CharSequence) "value", 2, 3).toString().equals("01l23");
        assert builder.insert(2, (CharSequence) "value", 2, 2).toString().equals("01l23");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharSequenceInvalidStartRange() throws Exception {
        new StringBuffer("value").insert(2, "value", -1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharSequenceInvalidEndRange() throws Exception {
        new StringBuffer("value").insert(2, "value", 1, 100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertCharSequenceInvalidRange() throws Exception {
        new StringBuffer("value").insert(2, "value", 2, 1);
    }

    @Test
    public void insertChar() throws Exception {
        StringBuffer builder = new StringBuffer("0123");
        assert builder.insert(2, new char[] {'v', 'a', 'l', 'u', 'e'}).toString().equals("01value23");
        assert builder.insert(1, new char[0]).toString().equals("01value23");
    }

    @Test(expected = NullPointerException.class)
    public void insertCharNull() throws Exception {
        new StringBuffer("value").insert(2, (char[]) null);
    }

    @Test
    public void insertCharRange() throws Exception {
        StringBuffer builder = new StringBuffer("0123");
        assert builder.insert(2, new char[] {'v', 'a', 'l', 'u', 'e'}, 1, 3).toString().equals("01alu23");
        assert builder.insert(1, new char[0], 0, 0).toString().equals("01alu23");
    }

    @Test(expected = NullPointerException.class)
    public void insertCharRangeNull() throws Exception {
        new StringBuffer("value").insert(2, (char[]) null, 0, 0);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void insertCharInvalidStartRange() throws Exception {
        new StringBuffer("value").insert(2, "value".toCharArray(), -1, 3);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void insertCharInvalidEndRange() throws Exception {
        new StringBuffer("value").insert(2, "value".toCharArray(), 1, 100);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void insertCharInvalidRange() throws Exception {
        new StringBuffer("value").insert(2, "value".toCharArray(), 2, -1);
    }

    @Test
    public void charAt() throws Exception {
        StringBuffer builder = new StringBuffer("test");
        assert builder.charAt(1) == 'e';
        assert builder.charAt(2) == 's';
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void charAtInvalidRange1() throws Exception {
        new StringBuffer("test").charAt(-10);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void charAtInvalidRange2() throws Exception {
        new StringBuffer("test").charAt(4);
    }

    @Test
    public void delete() throws Exception {
        StringBuffer builder = new StringBuffer("test");
        assert builder.delete(0, 2).toString().equals("st");
        assert builder.delete(0, 0).toString().equals("st");
        assert builder.delete(0, 100).toString().equals("");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void deleteInvalidStartRange1() throws Exception {
        new StringBuffer("test").delete(-100, 2);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void deleteInvalidStartRange2() throws Exception {
        new StringBuffer("test").delete(4, 0);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void deleteInvalidRange() throws Exception {
        new StringBuffer("test").delete(3, 2).equals("test");
    }

    @Test
    public void deleteCharAt() throws Exception {
        StringBuffer builder = new StringBuffer("test");
        assert builder.deleteCharAt(1).toString().equals("tst");
        assert builder.deleteCharAt(2).toString().equals("ts");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void deleteCharInvalidRange1() throws Exception {
        new StringBuffer("test").deleteCharAt(-10);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void deleteCharInvalidRange2() throws Exception {
        new StringBuffer("test").deleteCharAt(4);
    }

    @Test
    public void indexOf() throws Exception {
        StringBuffer builder = new StringBuffer("speak like a child");
        assert builder.indexOf("a") == 3;
        assert builder.indexOf("children") == -1;
    }

    @Test(expected = NullPointerException.class)
    public void indexOfNull() throws Exception {
        new StringBuffer("speak like a child").indexOf(null);
    }

    @Test
    public void indexOfFrom() throws Exception {
        StringBuffer builder = new StringBuffer("speak like a child");
        assert builder.indexOf("a", 6) == 11;
        assert builder.indexOf("a", -1) == 3;
        assert builder.indexOf("a", 100) == -1;
    }

    @Test(expected = NullPointerException.class)
    public void indexOfFromNull() throws Exception {
        new StringBuffer("speak like a child").indexOf(null, 3);
    }

    @Test
    public void lastIndexOf() throws Exception {
        StringBuffer builder = new StringBuffer("speak like a child");
        assert builder.lastIndexOf("a") == 11;
        assert builder.lastIndexOf("children") == -1;
    }

    @Test(expected = NullPointerException.class)
    public void lastIndexOfNull() throws Exception {
        new StringBuffer("speak like a child").lastIndexOf(null);
    }

    @Test
    public void lastIndexOfFrom() throws Exception {
        StringBuffer builder = new StringBuffer("speak like a child");
        assert builder.lastIndexOf("a", 14) == 11;
        assert builder.lastIndexOf("a", 8) == 3;
        assert builder.lastIndexOf("a", -10) == -1;
        assert builder.lastIndexOf("a", 200) == 11;
    }

    @Test(expected = NullPointerException.class)
    public void lastIndexOfFromNull() throws Exception {
        new StringBuffer("speak like a child").lastIndexOf(null, 3);
    }

    @Test
    public void replace() throws Exception {
        StringBuffer builder = new StringBuffer("speak like a child");
        assert builder.replace(0, 5, "sleep").toString().equals("sleep like a child");
        assert builder.replace(0, 500, "as").toString().equals("as");
        assert builder.replace(2, 2, "h").toString().equals("ash");
    }

    @Test(expected = NullPointerException.class)
    public void replaceNull() throws Exception {
        new StringBuffer("speak like a child").replace(3, 5, null);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void replaceInvalidStartRange1() throws Exception {
        new StringBuffer("speak like a child").replace(-100, 5, "test");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void replaceInvalidStartRange2() throws Exception {
        new StringBuffer("speak like a child").replace(100, 101, "test");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void replaceInvalidEndRange() throws Exception {
        new StringBuffer("speak like a child").replace(4, 3, "test");
    }

    @Test
    public void substring() throws Exception {
        StringBuffer builder = new StringBuffer("speak like a child");
        assert builder.substring(11).equals("a child");
        assert builder.substring(0).equals("speak like a child");
        assert builder.substring(18).equals("");

        assert builder.substring(0, 5).equals("speak");
        assert builder.substring(6, 10).equals("like");
        assert builder.substring(11, 18).equals("a child");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringInvalidRange1() throws Exception {
        new StringBuffer("speak like a child").substring(-1);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringInvalidRange2() throws Exception {
        new StringBuffer("speak like a child").substring(100);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringInvalidRange3() throws Exception {
        new StringBuffer("speak like a child").substring(-1, 3);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringInvalidRange4() throws Exception {
        new StringBuffer("speak like a child").substring(100, 101);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringInvalidRange5() throws Exception {
        new StringBuffer("speak like a child").substring(2, 101);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringInvalidRange6() throws Exception {
        new StringBuffer("speak like a child").substring(10, 2);
    }

    @Test
    public void subSequence() throws Exception {
        StringBuffer builder = new StringBuffer("speak like a child");
        assert builder.subSequence(0, 5).toString().equals("speak");
        assert builder.subSequence(6, 10).toString().equals("like");
        assert builder.subSequence(11, 18).toString().equals("a child");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void subSequenceInvalidRange1() throws Exception {
        new StringBuffer("speak like a child").subSequence(-1, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void subSequenceInvalidRange2() throws Exception {
        new StringBuffer("speak like a child").subSequence(100, 101);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void subSequenceInvalidRange3() throws Exception {
        new StringBuffer("speak like a child").subSequence(2, 101);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void subSequenceInvalidRange4() throws Exception {
        new StringBuffer("speak like a child").subSequence(10, 2);
    }

    @Test
    public void reverse() throws Exception {
        StringBuffer builder = new StringBuffer("live");
        assert builder.reverse().toString().equals("evil");
    }

    @Test
    public void setChar() throws Exception {
        StringBuffer builder = new StringBuffer("live");
        builder.setCharAt(1, 'o');
        assert builder.toString().equals("love");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setCharInvalidRange1() throws Exception {
        new StringBuffer("live").setCharAt(-1, 'x');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setCharInvalidRange2() throws Exception {
        new StringBuffer("live").setCharAt(4, 'x');
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setCharInvalidRange3() throws Exception {
        new StringBuffer("live").setCharAt(100, 'x');
    }

    @Test
    public void interfaces() {
        StringBuffer builder = new StringBuffer();
        assert builder instanceof Appendable;
        assert builder instanceof CharSequence;
        assert builder instanceof StringBuffer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Test";
    }
}
