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

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/17 17:55:39
 */
@SuppressWarnings("unused")
public class StringConstructorTest extends ScriptTester {

    @Test
    public void empty() {
        test(new Scriptable() {

            public String act() {
                return "";
            }
        });
    }

    @Test
    public void basic() {
        test(new Scriptable() {

            public String act() {
                return "java";
            }
        });
    }

    @Test
    public void quote() {
        test(new Scriptable() {

            public String act(String value) {
                return "\"";
            }
        });
    }

    @Test
    public void tab() {
        test(new Scriptable() {

            public String act(String value) {
                return "\t";
            }
        });
    }

    @Test
    public void linebreak() {
        test(new Scriptable() {

            public String act(String value) {
                return "\r\n";
            }
        });
    }

    @Test
    public void formfeed() {
        test(new Scriptable() {

            public String act(String value) {
                return "\f";
            }
        });
    }

    @Test
    public void backspace() {
        test(new Scriptable() {

            public String act(String value) {
                return "\b";
            }
        });
    }

    @Test
    public void singlequote() {
        test(new Scriptable() {

            public String act(String value) {
                return "\'";
            }
        });
    }

    @Test
    public void unicode() {
        test(new Scriptable() {

            public String act(String value) {
                return "\u3040";
            }
        });
    }

    @Test
    public void addition() {
        test(new Scriptable() {

            public String act(String value) {
                return "java" + value + "Test";
            }
        });
    }

    @Test
    public void constructorEmpty() {
        test(new Scriptable() {

            public String act(String value) {
                return new String();
            }
        });
    }

    @Test
    public void constructorCopy() {
        test(new Scriptable() {

            public String act(String value) {
                return new String("test");
            }
        });
    }

    @Test
    public void constructorCharArray() {
        test(new Scriptable() {

            public String act(String value) {
                return new String(new char[] {'t', 'e', 's', 't'});
            }
        });
    }

    @Test
    public void constructorCharArrayWithOffset() {
        test(new Scriptable() {

            public String act(String value) {
                return new String(new char[] {'t', 'e', 's', 't'}, 0, 2);
            }
        });
    }
}
