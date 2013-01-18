/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.reflection;

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/18 11:13:39
 */
@SuppressWarnings("unused")
public class ClassTest extends ScriptTester {

    @Test
    public void NewInstance() throws Exception {
        test(new Scriptable() {

            int act() throws Exception {
                return Parent.class.newInstance().value;
            }
        });
    }

    @Test
    @Ignore
    public void GetMethods() throws Exception {
        test(new Scriptable() {

            int act() throws Exception {
                return Parent.class.getDeclaredMethods().length;
            }
        });
    }

    @Test
    @Ignore
    public void GetMethodsOverride() throws Exception {
        test(new Scriptable() {

            int act() throws Exception {
                return Child.class.getDeclaredMethods().length;
            }
        });
    }

    @Test
    public void IsAssignableFrom() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent.class.isAssignableFrom(Child.class);
            }
        });
    }

    @Test
    public void IsAssignableFromInvalidClass() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent.class.isAssignableFrom(AnyoneElse.class);
            }
        });
    }

    @Test
    public void IsAssignableFromSameClass() throws Exception {
        test(new Scriptable() {

            boolean act() throws Exception {
                return Parent.class.isAssignableFrom(Parent.class);
            }
        });
    }

    @Test
    public void GetSuperclass() throws Exception {
        test(new Scriptable() {

            Class act() throws Exception {
                return Child.class.getSuperclass();
            }
        });
    }

    /**
     * @version 2013/01/18 11:14:22
     */
    public static class Parent {

        private int value = 10;

        public int method() {
            return 1;
        }
    }

    /**
     * @version 2013/01/18 11:14:22
     */
    public static class Child extends Parent {

        @Override
        public int method() {
            return 10;
        }
    }

    /**
     * @version 2013/01/18 23:25:39
     */
    public static class AnyoneElse {

        private int value = 10;

        public int method() {
            return 1;
        }
    }
}
