/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.sdk;

import org.junit.Test;

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.BooleanScript;
import booton.translator.api.IntScript;
import booton.translator.api.ObjectScript;

/**
 * @version 2012/11/30 15:32:50
 */
public class StringTest extends ScriptTranslatorTestcase {

    @Test
    public void empty() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "";
            }
        });
    }

    @Test
    public void basic() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "java";
            }
        });
    }

    @Test
    public void length() {
        test(new IntScript() {

            public int execute(int value) {
                return "java".length();
            }
        });
    }

    @Test
    public void substring() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "java".substring(2);
            }
        });
    }

    @Test
    public void substringBetween() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "java".substring(2, 4);
            }
        });
    }

    @Test
    public void toLowerCase() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "JAVA".toLowerCase();
            }
        });
    }

    @Test
    public void toUpperCase() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "java".toUpperCase();
            }
        });
    }

    @Test
    public void trim() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return " j a v a ".trim();
            }
        });
    }

    @Test
    public void codePointAt() {
        test(new IntScript() {

            public int execute(int value) {
                return "java".codePointAt(0);
            }
        });
    }

    @Test
    public void codePointBefore() {
        test(new IntScript() {

            public int execute(int value) {
                return "java".codePointBefore(3);
            }
        });
    }

    @Test
    public void indexOf() {
        test(new IntScript() {

            public int execute(int value) {
                return "java".indexOf("a");
            }
        });
    }

    @Test
    public void endsWith() {
        assertScript(new BooleanScript() {

            public boolean execute(boolean value) {
                return "java".endsWith("va");
            }
        });
    }

    @Test
    public void startsWith() {
        assertScript(new BooleanScript() {

            public boolean execute(boolean value) {
                return "java".startsWith("ja");
            }
        });
    }

    @Test
    public void concat() {
        assertScript("script", new ObjectScript<String>() {

            public String execute(String value) {
                return "java".concat(value);
            }
        });
    }

    @Test
    public void replace() {
        assertScript("script", new ObjectScript<String>() {

            public String execute(String value) {
                return "java".replace("java", value);
            }
        });
    }

    @Test
    public void replaceForChar() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "java".replace('a', 'o');
            }
        });
    }

    @Test
    public void replaceForCharWithExpression() {
        assertScript("ao", new ObjectScript<String>() {

            public String execute(String value) {
                return "java".replace(value.charAt(0), value.charAt(1));
            }
        });
    }

    @Test
    public void replaceAll() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "java".replaceAll("a", "o");
            }
        });
    }

    @Test
    public void replaceAllWithExpression() {
        assertScript("a", new ObjectScript<String>() {

            public String execute(String value) {
                return "java".replaceAll(value, "o");
            }
        });
    }

    @Test
    public void replaceFirst() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return "java".replaceFirst("a", "o");
            }
        });
    }

    @Test
    public void addition() {
        assertScript("script", new ObjectScript<String>() {

            public String execute(String value) {
                return "java" + value + "Test";
            }
        });
    }
}
