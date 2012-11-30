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

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.IntScript;
import booton.translator.api.ObjectScript;

/**
 * @version 2012/11/30 15:34:11
 */
public class StaticMemberTest extends ScriptTranslatorTestcase {

    @Test
    public void StringValueOf() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                return String.valueOf((Object) null);
            }
        });
    }

    @Test
    public void StaticMethod() {
        assertScript(new StaticMethod());
    }

    /**
     * @version 2009/08/20 13:15:34
     */
    private static class StaticMethod implements IntScript {

        /**
         * @see booton.translator.api.IntScript#execute(int)
         */
        public int execute(int value) {
            return compute();
        }

        private static int compute() {
            return 1;
        }
    }

    @Test
    public void StaticMethodWithParam() {
        assertScript(new StaticMethodWithParam());
    }

    /**
     * @version 2009/08/20 13:15:34
     */
    private static class StaticMethodWithParam implements IntScript {

        /**
         * @see booton.translator.api.IntScript#execute(int)
         */
        public int execute(int value) {
            return compute(value);
        }

        private static int compute(int value) {
            return value;
        }
    }

    @Test
    public void GetStaticField() {
        assertScript(new GetStaticField());
    }

    /**
     * @version 2009/08/20 13:15:34
     */
    private static class GetStaticField implements IntScript {

        private static int field = 10;

        /**
         * @see booton.translator.api.IntScript#execute(int)
         */
        public int execute(int value) {
            return field;
        }
    }

    @Test
    public void GetStaticFieldFromStaticMethod() {
        assertScript(new GetStaticFieldFromStaticMethod());
    }

    /**
     * @version 2009/08/20 13:15:34
     */
    private static class GetStaticFieldFromStaticMethod implements IntScript {

        private static int field = 10;

        /**
         * @see booton.translator.api.IntScript#execute(int)
         */
        public int execute(int value) {
            return compute();
        }

        private static int compute() {
            return field;
        }
    }

    @Test
    public void SetStaticField() {
        assertScript(new SetStaticField());
    }

    /**
     * @version 2009/08/20 13:15:34
     */
    private static class SetStaticField implements IntScript {

        private static int field;

        /**
         * @see booton.translator.api.IntScript#execute(int)
         */
        public int execute(int value) {
            field = value;

            return field;
        }
    }

    @Test
    public void StaticInitialization() {
        assertScript(new StaticInitialization());
    }

    /**
     * @version 2009/08/20 13:15:34
     */
    private static class StaticInitialization implements IntScript {

        private static final int field;

        static {
            field = 10;
        }

        /**
         * @see booton.translator.api.IntScript#execute(int)
         */
        public int execute(int value) {
            return field;
        }
    }
}
