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
 * @version 2013/08/16 20:39:33
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
        assert "" instanceof String;
    }

    @Test
    public void startsWith() {
        assert "abc".startsWith("ab");
        assert "abcd".startsWith("bc", 1);
        assert !"abc".startsWith("zzz");
    }

    @Test
    public void endsWith() {
        assert "abc".endsWith("bc");
        assert !"abc".endsWith("zzz");
    }

    @Test
    public void isEmpty() {
        assert "".isEmpty();
        assert !" ".isEmpty();
        assert !"a".isEmpty();
        assert !"\t".isEmpty();
    }

    @Test
    public void compare() {
        assert "b".compareTo("b") == 0;
        assert "a".compareTo("b") == -1;
        assert "c".compareTo("b") == 1;
    }

    @Test
    public void hash() {
        String one = new String("not interned");
        String other = new String("not interned");

        assert one.hashCode() == other.hashCode();
    }
}
