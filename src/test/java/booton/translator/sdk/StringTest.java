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

import booton.translator.api.Param;
import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/11/30 15:32:50
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
}
