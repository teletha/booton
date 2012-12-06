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
 * @version 2012/12/01 2:28:13
 */
@SuppressWarnings("unused")
public class FieldTest extends ScriptTester {

    @Test
    public void IntField() {
        test(new IntField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class IntField implements Scriptable {

        private int field = 10;

        public int act(int value) {
            return field;
        }
    }

    @Test
    public void IntFieldWithExpresison() {
        test(new IntFieldWithExpresison());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class IntFieldWithExpresison implements Scriptable {

        private int field = 10;

        public int act(int value) {
            return field + value;
        }
    }

    @Test
    public void LongField() {
        test(new LongField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class LongField implements Scriptable {

        private long field = 9876543210L;

        public long act(long value) {
            return field;
        }
    }

    @Test
    public void FloatField() {
        test(new FloatField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class FloatField implements Scriptable {

        private float field = 3.1415f;

        public float act(float value) {
            return field;
        }
    }

    @Test
    public void DoubleField() {
        test(new DoubleField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class DoubleField implements Scriptable {

        private double field = 3.14159265358979323846264338327950288419716939937510d;

        public double act(double value) {
            return field;
        }
    }

    @Test
    public void BooleanField() {
        test(new BooleanField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class BooleanField implements Scriptable {

        private boolean field = false;

        public boolean act(boolean value) {
            return field;
        }
    }

    @Test
    public void Extend() {
        test(new ExtendChild());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class ExtendBase {

        public int field = 10;
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class ExtendChild extends ExtendBase implements Scriptable {

        public int act(int value) {
            return value + field;
        }
    }

    @Test
    public void Override() {
        test(new OverrideChild());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class OverrideBase {

        protected int field = 10;
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class OverrideChild extends OverrideBase implements Scriptable {

        protected int field = 5;

        public int act(int value) {
            return value + this.field;
        }
    }

    @Test
    public void Super() {
        test(new SuperChild());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class SuperBase {

        protected int field = 10;
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class SuperChild extends SuperBase implements Scriptable {

        protected int field = 5;

        public int act(int value) {
            return value + this.field + super.field;
        }
    }
}
