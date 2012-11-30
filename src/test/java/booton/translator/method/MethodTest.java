/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.method;

import org.junit.Test;

import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/12/01 3:57:02
 */
@SuppressWarnings("unused")
public class MethodTest extends ScriptTester {

    @Test
    public void Basic() {
        test(new Basic());
    }

    /**
     * @version 2012/12/01 3:55:41
     */
    private static class Basic implements Scriptable {

        public int act() {
            return compute();
        }

        private int compute() {
            return -10;
        }
    }

    @Test
    public void Param() {
        test(new Param());
    }

    /**
     * @version 2012/12/01 3:55:43
     */
    private static class Param implements Scriptable {

        public int act(int value) {
            return compute(value);
        }

        private int compute(int value) {
            return 100 + value;
        }
    }

    @Test
    public void MultipleParams() {
        test(new MultipleParams());
    }

    /**
     * @version 2012/12/01 3:55:45
     */
    private static class MultipleParams implements Scriptable {

        public int act(int value) {
            return compute(value, value + 1);
        }

        private int compute(int first, int second) {
            return first * second;
        }
    }

    @Test
    public void ArrayParam() {
        test(new ArrayParam());
    }

    /**
     * @version 2012/12/01 3:55:48
     */
    private static class ArrayParam implements Scriptable {

        public int act(int value) {
            int[] ints = {value, value + 1, value + 2};

            return compute(ints);
        }

        private int compute(int[] values) {
            int i = 0;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void VariableParam() {
        test(new VariableParam());
    }

    /**
     * @version 2012/12/01 3:55:52
     */
    private static class VariableParam implements Scriptable {

        public int act(int value) {
            return compute(value, value + 1, value + 2);
        }

        private int compute(int... values) {
            int i = 0;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void VariableParamWithBase() {
        test(new VariableParamWithBase());
    }

    /**
     * @version 2012/12/01 3:55:55
     */
    private static class VariableParamWithBase implements Scriptable {

        public int act(int value) {
            return compute(value, value + 1, value + 2);
        }

        private int compute(int base, int... values) {
            int i = base * base;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void VariableParamWithBaseOnly() {
        test(new VariableParamWithBaseOnly());
    }

    /**
     * @version 2012/12/01 3:55:59
     */
    private static class VariableParamWithBaseOnly implements Scriptable {

        public int act(int value) {
            return compute(value);
        }

        private int compute(int base, int... values) {
            int i = base * base;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void Nest() {
        test(new Nest());
    }

    /**
     * @version 2012/12/01 3:56:02
     */
    private static class Nest implements Scriptable {

        public int act(int value) {
            return compute(value, nest(value));
        }

        private int compute(int first, int second) {
            return first * second;
        }

        private int nest(int value) {
            return value + value;
        }
    }

    @Test
    public void Overload() {
        test(new Overload());
    }

    /**
     * @version 2012/12/01 3:56:04
     */
    private static class Overload implements Scriptable {

        public int act(int value) {
            return compute(value);
        }

        private int compute(int value) {
            return value * value;
        }

        private String compute(String value) {
            return value.substring(1);
        }
    }

    @Test
    public void ExtendPublic() {
        test(new ExtendPublic());
    }

    /**
     * @version 2012/12/01 3:56:06
     */
    private static class BasePublic {

        public int compute() {
            return 10;
        }
    }

    /**
     * @version 2012/12/01 3:56:10
     */
    private static class ExtendPublic extends BasePublic implements Scriptable {

        public int act(int value) {
            return value + compute();
        }
    }

    @Test
    public void ExtendProtected() {
        test(new ExtendProtected());
    }

    /**
     * @version 2012/12/01 3:56:12
     */
    private static class BaseProtected {

        protected int compute() {
            return 10;
        }
    }

    /**
     * @version 2012/12/01 3:56:17
     */
    private static class ExtendProtected extends BaseProtected implements Scriptable {

        public int act(int value) {
            return value + compute();
        }
    }

    @Test
    public void ExtendPackage() {
        test(new ExtendPackage());
    }

    /**
     * @version 2012/12/01 3:56:19
     */
    private static class BasePackage {

        int compute() {
            return 10;
        }
    }

    /**
     * @version 2012/12/01 3:56:22
     */
    private static class ExtendPackage extends BasePackage implements Scriptable {

        public int act(int value) {
            return value + compute();
        }
    }

    @Test
    public void Override() {
        test(new OverrideChild());
    }

    /**
     * @version 2012/12/01 3:56:46
     */
    private static class OverrideBase {

        public int compute(int value) {
            return value + 1;
        }
    }

    /**
     * @version 2012/12/01 3:56:45
     */
    private static class OverrideChild extends OverrideBase implements Scriptable {

        public int act(int value) {
            return compute(value);
        }

        @Override
        public int compute(int value) {
            return value - 1;
        }
    }

    @Test
    public void Super() {
        test(new SuperChild());
    }

    /**
     * @version 2012/12/01 3:56:42
     */
    static class SuperBase {

        public int compute(int value) {
            return value + 1;
        }
    }

    /**
     * @version 2012/12/01 3:56:40
     */
    static class SuperChild extends SuperBase implements Scriptable {

        public int act(int value) {
            return this.compute(value) + super.compute(value);
        }

        @Override
        public int compute(int value) {
            return value - 1;
        }
    }
}
