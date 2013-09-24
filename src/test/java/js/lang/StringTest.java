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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/08/27 14:36:00
 */
@RunWith(ScriptRunner.class)
public class StringTest {

    @Test
    public void length() throws Exception {
        assert "".length() == 0;
        assert "a".length() == 1;
    }

    @Test
    public void clazz() throws Exception {
        assert "".getClass() == String.class;
    }

    @Test
    public void instanceOf() {
        Object o = "";

        assert o instanceof String;
        assert o instanceof CharSequence;
        assert o instanceof Comparable;
        assert !(o instanceof Character);
    }

    @Test
    public void isAssignableFrom() {
        Class o = "".getClass();

        assert String.class.isAssignableFrom(o);
        assert CharSequence.class.isAssignableFrom(o);
        assert Comparable.class.isAssignableFrom(o);
        assert !Character.class.isAssignableFrom(o);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void charAtOutOfRange1() throws Exception {
        "abc".charAt(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void charAtOutOfRange2() throws Exception {
        "abc".charAt(100);
    }

    @Test
    public void codePointAt() throws Exception {
        assert "abc".codePointAt(0) == 97;
        assert "abc".codePointAt(1) == 98;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void codePointAtOutOfRange1() throws Exception {
        "abc".codePointAt(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void codePointAtOutOfRange2() throws Exception {
        "abc".codePointAt(3);
    }

    @Test
    public void codePointBefore() throws Exception {
        assert "abc".codePointBefore(1) == 97;
        assert "abc".codePointBefore(2) == 98;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void codePointBeforeOutOfRange1() throws Exception {
        "abc".codePointBefore(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void codePointBeforeOutOfRange2() throws Exception {
        "abc".codePointBefore(4);
    }

    @Test
    public void compare() {
        String o = "b";

        assert o.compareTo("b") == 0;
        assert o.compareTo("c") == -1;
        assert o.compareTo("a") == 1;
    }

    @Test
    public void concat() throws Exception {
        assert "a".concat("b").equals("ab");
        assert "a".concat("").equals("a");
    }

    @Test(expected = NullPointerException.class)
    public void concatNull() throws Exception {
        "a".concat(null);
    }

    @Test
    public void contains() throws Exception {
        assert "abc".contains("bc");
        assert "abc".contains("");
        assert !"abc".contains("z");
    }

    @Test(expected = NullPointerException.class)
    public void containsNull() throws Exception {
        "".contains(null);
    }

    @Test
    public void startsWith() {
        assert "abc".startsWith("ab");
        assert !"abc".startsWith("zzz");
        assert "abc".startsWith("");
        assert "abcd".startsWith("bc", 1);
        assert !"abc".startsWith("a", 100);
        assert !"abc".startsWith("a", -1);
    }

    @Test(expected = NullPointerException.class)
    public void startsWithNull() {
        "abc".startsWith(null);
    }

    @Test
    public void endsWith() {
        assert "abc".endsWith("bc");
        assert !"abc".endsWith("ab");
        assert !"abc".endsWith("zzzz");
        assert "abc".endsWith("");
    }

    @Test(expected = NullPointerException.class)
    public void endsWithNull() {
        "abc".endsWith(null);
    }

    @Test
    public void equals() throws Exception {
        assert "as".equals("as");
        assert !"as".equals("AS");
    }

    @Test
    public void equalsIgnoreCase() throws Exception {
        assert "as".equalsIgnoreCase("as");
        assert "as".equalsIgnoreCase("AS");
    }

    @Test
    public void hash() {
        String one = new String("not interned");
        String other = new String("not interned");

        assert one.hashCode() == other.hashCode();
    }

    @Test
    public void indexOf() throws Exception {
        assert "abcde".indexOf("cd") == 2;
        assert "abcde".indexOf("z") == -1;
    }

    @Test
    public void indexOfWithPosition() throws Exception {
        assert "abcabc".indexOf("b", -1) == 1;
        assert "abcabc".indexOf("b", 3) == 4;
        assert "abcabc".indexOf("b", 5) == -1;
        assert "abcabc".indexOf("b", 10) == -1;
    }

    @Test
    public void indexOfChar() throws Exception {
        int code = "c".codePointAt(0);

        assert "abcde".indexOf(code) == 2;
        assert "abcde".indexOf(0) == -1;
    }

    @Test
    public void indexOfCharWithPosition() throws Exception {
        int code = "b".codePointAt(0);

        assert "abcabc".indexOf(code, 3) == 4;
        assert "abcabc".indexOf(code, 5) == -1;
    }

    @Test
    public void intern() throws Exception {
        assert "a".intern() == "a";
    }

    @Test
    public void isEmpty() {
        assert "".isEmpty();
        assert !" ".isEmpty();
        assert !"a".isEmpty();
        assert !"\t".isEmpty();
    }

    @Test
    public void lastIndexOf() throws Exception {
        assert "abcde".lastIndexOf("cd") == 2;
        assert "abcde".lastIndexOf("z") == -1;
    }

    @Test
    public void lastIndexOfWithPosition() throws Exception {
        assert "abcabc".lastIndexOf("b", 5) == 4;
        assert "abcabc".lastIndexOf("b", 3) == 1;
        assert "abcabc".lastIndexOf("b", 0) == -1;
        assert "abcabc".lastIndexOf("b", -10) == -1;
    }

    @Test
    public void lastIndexOfChar() throws Exception {
        int code = "c".codePointAt(0);

        assert "abcde".lastIndexOf(code) == 2;
        assert "abcde".lastIndexOf(0) == -1;
    }

    @Test
    public void lastIndexOfCharWithPosition() throws Exception {
        int code = "b".codePointAt(0);

        assert "abcabc".lastIndexOf(code, 5) == 4;
        assert "abcabc".lastIndexOf(code, 3) == 1;
        assert "abcabc".lastIndexOf(code, 0) == -1;
        assert "abcabc".lastIndexOf(code, -10) == -1;
    }

    @Test
    public void replace() throws Exception {
        assert "abcabc".replace("a", "A").equals("AbcAbc");
        assert "abcabc".replace("ab", "").equals("cc");
        assert "abcabc".replace("", "A").equals("AaAbAcAaAbAcA");
        assert "aaa".replace("aa", "b").equals("ba");
    }

    @Test(expected = NullPointerException.class)
    public void replaceNull1() throws Exception {
        "abcabc".replace(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void replaceNull2() throws Exception {
        "abcabc".replace("a", null);
    }

    @Test(expected = NullPointerException.class)
    public void replaceNull3() throws Exception {
        "abcabc".replace(null, "a");
    }

    @Test
    public void replaceChar() throws Exception {
        assert "abcabc".replace('a', 'A').equals("AbcAbc");
    }

    @Test
    public void replaceCharWithExpression() throws Exception {
        String text = "aA";
        assert "abcabc".replace(text.charAt(0), text.charAt(1)).equals("AbcAbc");
    }

    @Test
    public void replaceAll() throws Exception {
        assert "abcabc".replaceAll("a", "A").equals("AbcAbc");
        assert "jaaava".replaceAll("a+", "o").equals("jovo");
        assert " j a v a ".replaceAll("\\s", "").equals("java");

        String variable = "a";
        assert "abcabc".replaceAll(variable, "A").equals("AbcAbc");

        String regex = "a+";
        assert "jaaava".replaceAll(regex, "o").equals("jovo");
    }

    @Test
    public void replaceFirst() throws Exception {
        assert "abcabc".replaceFirst("a", "A").equals("Abcabc");
        assert "jaaava".replaceFirst("a+", "o").equals("jova");
        assert " j a v a ".replaceFirst("\\s", "").equals("j a v a ");
    }

    @Test
    public void regionMatches() throws Exception {
        assert "abcdef".regionMatches(false, 2, "oocdoo", 2, 2);
        assert "abcdef".regionMatches(true, 2, "ooCDoo", 2, 2);
    }

    @Test
    public void split() throws Exception {
        String[] values = "abcabc".split("b");
        assert values.length == 3;
        assert values[0].equals("a");
        assert values[1].equals("ca");
        assert values[2].equals("c");

        values = "a1ca23c".split("\\d+");
        assert values.length == 3;
        assert values[0].equals("a");
        assert values[1].equals("ca");
        assert values[2].equals("c");
    }

    @Test(expected = NullPointerException.class)
    public void splitNull() throws Exception {
        "".split(null);
    }

    @Test
    @Ignore
    public void splitLimit() throws Exception {
        String[] values = "abcabc".split("b", 2);
        assert values.length == 2;
        assert values[0].equals("a");
        assert values[1].equals("cabc");

        values = "a1ca23c".split("\\d+", 2);
        assert values.length == 2;
        assert values[0].equals("a");
        assert values[1].equals("ca23c");
    }

    @Test
    public void subSequence() throws Exception {
        assert "abcde".subSequence(0, 2).equals("ab");
        assert "abcde".subSequence(2, 4).equals("cd");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void subSequenceOutOfRange1() throws Exception {
        "abcde".subSequence(0, 10);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void subSequenceOutOfRange2() throws Exception {
        "abcde".subSequence(-10, 2);
    }

    @Test
    public void substring() throws Exception {
        assert "abcde".substring(3).equals("de");
        assert "abcde".substring(0, 2).equals("ab");
        assert "abcde".substring(2, 4).equals("cd");
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void subSequenceOutOfRange3() throws Exception {
        "abcde".subSequence(3, 1);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringOutOfRange1() throws Exception {
        "abcde".substring(0, 10);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringOutOfRange2() throws Exception {
        "abcde".substring(-10, 2);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void substringOutOfRange3() throws Exception {
        "abcde".substring(3, 1);
    }

    @Test
    public void toCharArray() throws Exception {
        char[] values = "abc".toCharArray();
        assert values.length == 3;
    }

    @Test
    public void toLowerCase() throws Exception {
        assert "abc".toLowerCase().equals("abc");
        assert "ABC".toLowerCase().equals("abc");
        assert "123$#&!%@<>?".toUpperCase().equals("123$#&!%@<>?");
    }

    @Test
    public void toUpperCase() throws Exception {
        assert "abc".toUpperCase().equals("ABC");
        assert "ABC".toUpperCase().equals("ABC");
        assert "123$#&!%@<>?".toUpperCase().equals("123$#&!%@<>?");
    }

    @Test
    public void trim() throws Exception {
        assert "".trim().equals("");
        assert " a b c ".trim().equals("a b c");
        assert "a".trim().equals("a");
        assert "\tQ\t".trim().equals("Q");
        assert "\r\nQ\r\n".trim().equals("Q");
    }

    @Test
    public void valueOf() throws Exception {
        assert String.valueOf((Object) null).equals("null");
        assert String.valueOf(new char[] {'a', 'b', 'c'}).equals("abc");
        assert String.valueOf(1).equals("1");
        assert String.valueOf(1234567890L).equals("1234567890");
        assert String.valueOf(0.1F).equals("0.1");
        assert String.valueOf(0.12345678901D).equals("0.12345678901");
        assert String.valueOf(true).equals("true");
        assert String.valueOf('Q').equals("Q");
    }
}
