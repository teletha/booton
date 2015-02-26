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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import kiss.I;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import booton.translator.Debuggable;

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
    @Debuggable
    public void arrayReference() {
        IntFunction<String[]> function = String[]::new;
        String[] array = function.apply(4);

        assert array.length == 4;
        assert array instanceof String[];
        assert array.getClass() == String[].class;
    }

    @Test
    public void constructorReference() {
        Supplier<ConstructorReference> function = ConstructorReference::new;
        ConstructorReference instance = function.get();

        assert instance.value == -1;
        assert instance instanceof ConstructorReference;
        assert instance.getClass() == ConstructorReference.class;
        assert ConstructorReference.class.isAssignableFrom(instance.getClass());
    }

    @Test
    public void constructorReferenceWithParam() {
        IntFunction<ConstructorReference> function = ConstructorReference::new;
        ConstructorReference instance = function.apply(10);

        assert instance.value == 10;
        assert instance instanceof ConstructorReference;
        assert instance.getClass() == ConstructorReference.class;
        assert ConstructorReference.class.isAssignableFrom(instance.getClass());
    }

    /**
     * @version 2015/02/26 11:34:52
     */
    private static class ConstructorReference {

        private final int value;

        private ConstructorReference() {
            this.value = -1;
        }

        /**
         * @param value
         */
        private ConstructorReference(int value) {
            this.value = value;
        }
    }

    @Test
    public void methodReference() {
        MethodReference ref = new MethodReference();
        IntFunction<String> function = ref::intFunction;
        String result = function.apply(10);

        assert result.equals("10");
        assert function instanceof IntFunction;
        assert IntFunction.class.isAssignableFrom(function.getClass());
    }

    @Test
    public void staticMethodReference() {
        LongSupplier supplier = MethodReference::staticLongSupplier;
        long result = supplier.getAsLong();

        assert result == 20L;
        assert supplier instanceof LongSupplier;
        assert LongSupplier.class.isAssignableFrom(supplier.getClass());
    }

    /**
     * @version 2015/02/26 13:42:06
     */
    private static class MethodReference {

        public String intFunction(int value) {
            return String.valueOf(value);
        }

        public static long staticLongSupplier() {
            return 20L;
        }
    }

    @Test
    @Debuggable
    public void function() throws Exception {
        Property<List> property = new SimpleObjectProperty(new ArrayList());
        Property<Integer> result = I.observe(property).map(List::size).to();

        assert result.getValue() == 0;
    }
}
