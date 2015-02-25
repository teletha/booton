/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.lambda;

import java.util.function.Consumer;
import java.util.function.IntSupplier;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import booton.translator.Debuggable;

/**
 * @version 2015/02/24 11:23:21
 */
@RunWith(ScriptRunner.class)
public class LambdaTest {

    @Test
    public void inlineNoArguments() throws Exception {
        InlineNoArguments instance = new InlineNoArguments();
        assert instance.lambda(() -> 10) == 10;
    }

    /**
     * @version 2013/11/18 10:28:11
     */
    private static class InlineNoArguments {

        private int lambda(IntSupplier supplier) {
            return supplier.getAsInt();
        }
    }

    @Test
    public void setFieldOnly() {
        SetFieldOnly operation = new SetFieldOnly();
        assert operation.value == 10;
    }

    /**
     * @version 2014/10/06 9:54:57
     */
    private static class SetFieldOnly {

        private int value;

        private SetFieldOnly() {
            lambda(v -> value = v);
        }

        private void lambda(Consumer<Integer> consumer) {
            consumer.accept(10);
        }
    }

    @Test
    public void clazz() {
        Runnable lambda = () -> {
        };

        Class clazz = lambda.getClass();
        assert clazz != Runnable.class;
        assert lambda instanceof Runnable;
        assert Runnable.class.isAssignableFrom(clazz);
    }

    @Test
    @Debuggable
    public void localVariable() {
        int local = 10;

        IntSupplier supplier = () -> {
            return local;
        };

        assert supplier.getAsInt() == 10;
    }
}
