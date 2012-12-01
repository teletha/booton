/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.field;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/11/30 15:34:11
 */
@SuppressWarnings("unused")
public class StaticMemberTest extends ScriptTester {

    @Test
    public void StringValueOf() {
        test(new Scriptable() {

            public String act() {
                return String.valueOf((Object) null);
            }
        });
    }

    @Test
    public void StaticMethod() {
        test(new StaticMethod());
    }

    /**
     * @version 2012/12/01 3:42:25
     */
    private static class StaticMethod implements Scriptable {

        public int act() {
            return compute();
        }

        private static int compute() {
            return 1;
        }
    }

    @Test
    public void StaticMethodWithParam() {
        test(new StaticMethodWithParam());
    }

    /**
     * @version 2012/12/01 3:42:21
     */
    private static class StaticMethodWithParam implements Scriptable {

        public int act(int value) {
            return compute(value);
        }

        private static int compute(int value) {
            return value;
        }
    }

    @Test
    public void GetStaticField() {
        test(new GetStaticField());
    }

    /**
     * @version 2012/12/01 3:42:15
     */
    private static class GetStaticField implements Scriptable {

        private static int field = 10;

        public int act() {
            return field;
        }
    }

    @Test
    public void GetStaticFieldFromStaticMethod() {
        test(new GetStaticFieldFromStaticMethod());
    }

    /**
     * @version 2012/12/01 3:42:12
     */
    private static class GetStaticFieldFromStaticMethod implements Scriptable {

        private static int field = 10;

        public int act() {
            return compute();
        }

        private static int compute() {
            return field;
        }
    }

    @Test
    public void SetStaticField() {
        test(new SetStaticField());
    }

    /**
     * @version 2012/12/01 3:42:08
     */
    private static class SetStaticField implements Scriptable {

        private static int field;

        public int act(int value) {
            field = value;

            return field;
        }
    }

    @Test
    public void StaticInitialization() {
        test(new StaticInitialization());
    }

    /**
     * @version 2012/12/01 3:42:04
     */
    private static class StaticInitialization implements Scriptable {

        private static final int field;

        static {
            field = 10;
        }

        public int act() {
            return field;
        }
    }
}
