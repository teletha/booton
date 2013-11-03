/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.lambda;

import static booton.translator.lambda.LambdaTest.Lambda.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/11/03 14:41:38
 */
@RunWith(ScriptRunner.class)
public class LambdaTest {

    private int value = 21;

    @Test
    public void lambda() throws Exception {
        Lambda lambda = new Lambda();
        assert lambda.nothingInt(() -> 1) == 1;
    }

    @Test
    public void localVariableReference() throws Exception {
        int value1 = 1;
        int value2 = 10;

        Lambda lambda = new Lambda();
        assert lambda.nothingInt(() -> value1 - value2) == -9;
    }

    @Test
    public void fieldReference() throws Exception {
        Lambda lambda = new Lambda();
        assert lambda.nothingInt(() -> value) == 21;
    }

    @Test
    public void thisReference() throws Exception {
        Lambda lambda = new Lambda();
        assert lambda.nothingObject(() -> this) == this;
    }

    @Test
    public void parameter() throws Exception {
        int variable = 3;

        Lambda lambda = new Lambda();
        assert lambda.param10((int param) -> param + 10) == 20;
        assert lambda.param10((int param) -> param * 10) == 100;
        assert lambda.param10((int param) -> param * variable) == 30;
    }

    @Test
    public void instanceMethodReference() throws Exception {
        Lambda lambda = new Lambda();
        assert lambda.nothingInt(lambda::int7) == 7;
    }

    @Test
    public void defaultMethodReference() throws Exception {
        Lambda lambda = new Lambda();
        assert lambda.nothingInt(lambda::int3) == 3;
        assert lambda.param10(lambda::multiply11) == 110;
    }

    @Test
    public void staticMethodReference() throws Exception {
        Lambda lambda = new Lambda();
        assert lambda.nothingInt(Lambda::int12) == 12;
    }

    /**
     * @version 2013/11/03 17:27:16
     */
    public static class Lambda implements DefaultMethod {

        /**
         * @param runnable
         * @return
         */
        private int nothingInt(IntValue value) {
            return value.value();
        }

        /**
         * @param runnable
         * @return
         */
        private Object nothingObject(ObjectValue value) {
            return value.value();
        }

        /**
         * @param value
         * @return
         */
        private int param10(IntParameter value) {
            return value.value(10);
        }

        /**
         * @return
         */
        private int int7() {
            return 7;
        }

        /**
         * @return
         */
        private static int int12() {
            return 12;
        }
    }

    /**
     * @version 2013/11/03 20:53:05
     */
    @FunctionalInterface
    private static interface IntValue {

        /**
         * @return
         */
        int value();
    }

    /**
     * @version 2013/11/03 20:53:05
     */
    @FunctionalInterface
    private static interface ObjectValue {

        /**
         * @return
         */
        Object value();
    }

    /**
     * @version 2013/11/03 20:53:34
     */
    @FunctionalInterface
    private static interface IntParameter {

        /**
         * @return
         */
        int value(int value);
    }

    /**
     * @version 2013/11/04 7:30:05
     */
    public static interface DefaultMethod {

        /**
         * @return
         */
        default int int3() {
            return 3;
        }

        /**
         * @return
         */
        default int multiply11(int value) {
            return 11 * value;
        }
    }

    // @Test
    // @Ignore
    // public void lambda() throws Exception {
    // List<String> values = Arrays.asList("One", "Two", "Three");
    // values.replaceAll((String value) -> {
    // return value + " Value";
    // });
    //
    // assert values.get(0).equals("One Value");
    // assert values.get(1).equals("Two Value");
    // assert values.get(2).equals("Three Value");
    // }
}
