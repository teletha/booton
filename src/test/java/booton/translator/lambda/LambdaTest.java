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
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2015/02/26 10:53:13
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
        // assert clazz != Runnable.class;
        assert lambda instanceof Runnable;
        assert Runnable.class.isAssignableFrom(clazz);
    }

    @Test
    public void useLocalVariable() {
        int local = 10;

        IntSupplier supplier = () -> {
            return local;
        };

        assert supplier.getAsInt() == 10;
    }

    @Test
    public void constructor() {
        Supplier<ConstructorAsLambda> function = ConstructorAsLambda::new;
        ConstructorAsLambda instance = function.get();

        assert instance.value == -1;
        assert instance instanceof ConstructorAsLambda;
        assert instance.getClass() == ConstructorAsLambda.class;
        assert ConstructorAsLambda.class.isAssignableFrom(instance.getClass());
    }

    @Test
    public void constructorWithParam() {
        IntFunction<ConstructorAsLambda> function = ConstructorAsLambda::new;
        ConstructorAsLambda instance = function.apply(10);

        assert instance.value == 10;
        assert instance instanceof ConstructorAsLambda;
        assert instance.getClass() == ConstructorAsLambda.class;
        assert ConstructorAsLambda.class.isAssignableFrom(instance.getClass());
    }

    /**
     * @version 2015/02/26 11:34:52
     */
    private static class ConstructorAsLambda {

        private final int value;

        private ConstructorAsLambda() {
            this.value = -1;
        }

        /**
         * @param value
         */
        private ConstructorAsLambda(int value) {
            this.value = value;
        }
    }
}
