/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.sdk;

import org.junit.Test;

import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/15 16:45:04
 */
@SuppressWarnings("unused")
public class StringTest extends ScriptTester {

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
    public void length() {
        test(new Scriptable() {

            public int act() {
                return "java".length();
            }
        });
    }

    @Test
    public void substring() {
        test(new Scriptable() {

            public String act() {
                return "java".substring(2);
            }
        });
    }

    @Test
    public void substringBetween() {
        test(new Scriptable() {

            public String act() {
                return "java".substring(2, 4);
            }
        });
    }

    @Test
    public void toLowerCase() {
        test(new Scriptable() {

            public String act() {
                return "JAVA".toLowerCase();
            }
        });
    }

    @Test
    public void toUpperCase() {
        test(new Scriptable() {

            public String act() {
                return "java".toUpperCase();
            }
        });
    }

    @Test
    public void trim() {
        test(new Scriptable() {

            public String act() {
                return " j a v a ".trim();
            }
        });
    }

    @Test
    public void codePointAt() {
        test(new Scriptable() {

            public int act() {
                return "java".codePointAt(0);
            }
        });
    }

    @Test
    public void codePointBefore() {
        test(new Scriptable() {

            public int act() {
                return "java".codePointBefore(3);
            }
        });
    }

    @Test
    public void indexOf() {
        test(new Scriptable() {

            public int act() {
                return "java".indexOf("a");
            }
        });
    }

    @Test
    public void endsWith() {
        test(new Scriptable() {

            public boolean act() {
                return "java".endsWith("va");
            }
        });
    }

    @Test
    public void startsWith() {
        test(new Scriptable() {

            public boolean act() {
                return "java".startsWith("ja");
            }
        });
    }

    @Test
    public void concat() {
        test(new Scriptable() {

            public String act(String value) {
                return "java".concat(value);
            }
        });
    }

    @Test
    public void replace() {
        test(new Scriptable() {

            public String act(String value) {
                return "java".replace("java", value);
            }
        });
    }

    @Test
    public void replaceForChar() {
        test(new Scriptable() {

            public String act() {
                return "java".replace('a', 'o');
            }
        });
    }

    @Test
    public void replaceForCharWithExpression() {
        test(new Scriptable() {

            public String act(@Param(strings = {"ao"}) String value) {
                return "java".replace(value.charAt(0), value.charAt(1));
            }
        });
    }

    @Test
    public void replaceAll() {
        test(new Scriptable() {

            public String act() {
                return "java".replaceAll("a", "o");
            }
        });
    }

    @Test
    public void replaceAllWithRegex() {
        test(new Scriptable() {

            public String act() {
                return "jaaava".replaceAll("a+", "o");
            }
        });
    }

    @Test
    public void replaceAllWithEscapedRegex() {
        test(new Scriptable() {

            public String act() {
                return "j a v a".replaceAll("\\s", "");
            }
        });
    }

    @Test
    public void replaceAllWithEscapedRegexVariable() {
        test(new Scriptable() {

            public String act() {
                String regex = "\\s";
                return "j a v a".replaceAll(regex, "");
            }
        });
    }

    @Test
    public void replaceAllWithExpression() {
        test(new Scriptable() {

            public String act(@Param(strings = {"a"}) String value) {
                return "java".replaceAll(value, "o");
            }
        });
    }

    @Test
    public void replaceFirst() {
        test(new Scriptable() {

            public String act() {
                return "java".replaceFirst("a", "o");
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
