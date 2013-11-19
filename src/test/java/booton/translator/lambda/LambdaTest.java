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

import java.util.function.BiFunction;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.Debuggable;
import booton.translator.ScriptRunner;

/**
 * @version 2013/11/03 14:41:38
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
    public void inlineSingleArgument() throws Exception {
        InlineSingleArgument instance = new InlineSingleArgument();

        assert instance.lambda((value) -> value + 10) == 15;
        assert instance.lambda((value) -> value * 10) == 50;
    }

    /**
     * @version 2013/11/18 10:28:11
     */
    private static class InlineSingleArgument {

        private int lambda(IntUnaryOperator operator) {
            return operator.applyAsInt(5);
        }
    }

    @Test
    public void inlineMultiArguments() throws Exception {
        assert new InlineMultiArguments().lambda((one, other) -> one / other + 10) == 12;
    }

    /**
     * @version 2013/11/18 10:28:11
     */
    private static class InlineMultiArguments {

        private int lambda(IntBinaryOperator operator) {
            return operator.applyAsInt(10, 5);
        }
    }

    /**
     * @version 2013/11/18 10:37:39
     */
    private static class ExternalVariableUser {

        private long forLong(LongSupplier supplier) {
            return supplier.getAsLong();
        }

        private Object forObject(Supplier supplier) {
            return supplier.get();
        }
    }

    @Test
    public void inlineUseLocalVariable() throws Exception {
        long value1 = 1;
        long value2 = 10;

        assert new ExternalVariableUser().forLong(() -> value1 - value2) == -9L;
    }

    private int value1 = 10;

    private long value2 = 1;

    @Test
    public void inlineUseFieldVariable() throws Exception {
        ExternalVariableUser instance = new ExternalVariableUser();
        assert instance.forLong(() -> value1 - value2) == 9L;
    }

    @Test
    public void inlineUseThisVariable() throws Exception {
        assert new ExternalVariableUser().forObject(() -> this) == this;
    }

    @Test
    public void inlineUseVariableAndArguments() throws Exception {
        int local1 = 10;
        int local2 = 5;

        InlineSingleArgument instance = new InlineSingleArgument();
        assert instance.lambda((value) -> value * local1 + local2 - value1) == 45;
    }

    @Test
    public void referInstanceMethodNoArgument() throws Exception {
        InstanceMethodNoArgument instance = new InstanceMethodNoArgument();
        assert instance.lambda(instance::ref);
    }

    /**
     * @version 2013/11/18 10:54:53
     */
    private static class InstanceMethodNoArgument {

        private boolean executed = false;

        private boolean lambda(Runnable function) {
            function.run();

            return executed;
        }

        private void ref() {
            executed = true;
        }
    }

    @Test
    public void referInstanceMethodNoArgumentWithReturn() throws Exception {
        InstanceMethodNoArgumentWithReturn instance = new InstanceMethodNoArgumentWithReturn();
        assert instance.lambda(instance::ref) == 100;
    }

    /**
     * @version 2013/11/18 10:54:53
     */
    private static class InstanceMethodNoArgumentWithReturn {

        private double lambda(DoubleSupplier function) {
            return function.getAsDouble();
        }

        private double ref() {
            return 100;
        }
    }

    @Test
    public void referAsToIntFunction() throws Exception {
        AsToIntFunction instance = new AsToIntFunction();
        assert instance.lambda(AsToIntFunction::ref) == 10;
    }

    /**
     * @version 2013/11/18 10:54:53
     */
    private static class AsToIntFunction {

        private int field = 10;

        private int lambda(ToIntFunction<AsToIntFunction> function) {
            return function.applyAsInt(this);
        }

        private int ref() {
            return field;
        }
    }

    @Test
    public void referAsFunction() throws Exception {
        AsFunction instance = new AsFunction();
        assert instance.lambda(AsFunction::ref).equals("test");
    }

    /**
     * @version 2013/11/18 10:54:53
     */
    private static class AsFunction {

        private String field = "test";

        private String lambda(Function<AsFunction, String> function) {
            return function.apply(this);
        }

        private String ref() {
            return field;
        }
    }

    @Test
    @Debuggable
    public void referAsFunctionByInterfaceAPI() throws Exception {
        AsFunctionByInterfaceAPI instance = new AsFunctionByInterfaceAPI();
        assert instance.bySupplier(instance::ref).equals("API Supplier");
        assert instance.byFunction(API::ref).equals("API Function");
    }

    /**
     * @version 2013/11/18 14:33:33
     */
    private static interface API {

        String ref();
    }

    /**
     * @version 2013/11/18 10:54:53
     */
    private static class AsFunctionByInterfaceAPI implements API {

        private String field = "API";

        private String bySupplier(Supplier<String> function) {
            return function.get() + " Supplier";
        }

        private String byFunction(Function<AsFunctionByInterfaceAPI, String> function) {
            return function.apply(this) + " Function";
        }

        public String ref() {
            return field;
        }
    }

    @Test
    @Debuggable
    public void referAsFunctionWithArgumentByInterfaceAPI() throws Exception {
        AsFunctionWithArgumentByInterfaceAPI instance = new AsFunctionWithArgumentByInterfaceAPI();
        assert instance.byFunction(instance::ref).equals("ArgumentAPI Supplier");
        assert instance.byBiFunction(ArgumentAPI::ref).equals("ArgumentAPI Function");
    }

    /**
     * @version 2013/11/18 14:33:33
     */
    private static interface ArgumentAPI {

        String ref(String value);
    }

    /**
     * @version 2013/11/18 10:54:53
     */
    private static class AsFunctionWithArgumentByInterfaceAPI implements ArgumentAPI {

        private String field = "API";

        private String byFunction(Function<String, String> function) {
            return function.apply("Argument") + " Supplier";
        }

        private String byBiFunction(BiFunction<AsFunctionWithArgumentByInterfaceAPI, String, String> function) {
            return function.apply(this, "Argument") + " Function";
        }

        public String ref(String value) {
            return value + field;
        }
    }

    // @Test
    // public void referInstanceMethodSingleArgument() throws Exception {
    // InstanceMethodSingleArgument instance = new InstanceMethodSingleArgument();
    // assert instance.lambda(instance::ref) == 10;
    // }
    //
    // /**
    // * @version 2013/11/18 10:54:53
    // */
    // private static class InstanceMethodSingleArgument {
    //
    // private int value = 0;
    //
    // private int lambda(IntConsumer function) {
    // function.accept(10);
    //
    // return value;
    // }
    //
    // private void ref(int value) {
    // this.value = value;
    // }
    // }
    //
    // @Test
    // public void instanceMethodReference() throws Exception {
    // Lambda lambda = new Lambda();
    // assert lambda.nothingInt(lambda::int7) == 7;
    // }
    //
    // @Test
    // public void defaultMethodReference() throws Exception {
    // Lambda lambda = new Lambda();
    // assert lambda.nothingInt(lambda::int3) == 3;
    // assert lambda.param10(lambda::multiply11) == 110;
    // }
    //
    // @Test
    // public void staticMethodReference() throws Exception {
    // Lambda lambda = new Lambda();
    // assert lambda.nothingInt(Lambda::int12) == 12;
    // }
    //
    // /**
    // * @version 2013/11/03 17:27:16
    // */
    // public static class Lambda implements DefaultMethod {
    //
    // /**
    // * @param runnable
    // * @return
    // */
    // private int nothingInt(IntValue value) {
    // return value.value();
    // }
    //
    // /**
    // * @param runnable
    // * @return
    // */
    // private Object nothingObject(ObjectValue value) {
    // return value.value();
    // }
    //
    // /**
    // * @param value
    // * @return
    // */
    // private int param10(IntParameter value) {
    // return value.value(10);
    // }
    //
    // /**
    // * @return
    // */
    // private int int7() {
    // return 7;
    // }
    //
    // /**
    // * @return
    // */
    // private static int int12() {
    // return 12;
    // }
    // }
    //
    // /**
    // * @version 2013/11/03 20:53:05
    // */
    // @FunctionalInterface
    // private static interface IntValue {
    //
    // /**
    // * @return
    // */
    // int value();
    // }
    //
    // /**
    // * @version 2013/11/03 20:53:05
    // */
    // @FunctionalInterface
    // private static interface ObjectValue {
    //
    // /**
    // * @return
    // */
    // Object value();
    // }
    //
    // /**
    // * @version 2013/11/03 20:53:34
    // */
    // @FunctionalInterface
    // private static interface IntParameter {
    //
    // /**
    // * @return
    // */
    // int value(int value);
    // }
    //
    // /**
    // * @version 2013/11/04 7:30:05
    // */
    // public static interface DefaultMethod {
    //
    // /**
    // * @return
    // */
    // default int int3() {
    // return 3;
    // }
    //
    // /**
    // * @return
    // */
    // default int multiply11(int value) {
    // return 11 * value;
    // }
    // }
    //
    // // @Test
    // // @Ignore
    // // public void lambda() throws Exception {
    // // List<String> values = Arrays.asList("One", "Two", "Three");
    // // values.replaceAll((String value) -> {
    // // return value + " Value";
    // // });
    // //
    // // assert values.get(0).equals("One Value");
    // // assert values.get(1).equals("Two Value");
    // // assert values.get(2).equals("Three Value");
    // // }
}
