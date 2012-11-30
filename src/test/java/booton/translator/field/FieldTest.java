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
import booton.translator.api.BooleanScript;
import booton.translator.api.DoubleScript;
import booton.translator.api.FloatScript;
import booton.translator.api.IntScript;
import booton.translator.api.LongScript;

/**
 * @version 2012/11/30 15:34:04
 */
public class FieldTest extends ScriptTranslatorTestcase {

    @Test
    public void IntField() {
        assertScript(new IntField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class IntField implements IntScript {

        private int field = 10;

        public int execute(int value) {
            return field;
        }
    }

    @Test
    public void IntFieldWithExpresison() {
        assertScript(new IntFieldWithExpresison());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class IntFieldWithExpresison implements IntScript {

        private int field = 10;

        public int execute(int value) {
            return field + value;
        }
    }

    @Test
    public void LongField() {
        assertScript(new LongField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class LongField implements LongScript {

        private long field = 9876543210L;

        public long execute(long value) {
            return field;
        }
    }

    @Test
    public void FloatField() {
        assertScript(new FloatField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class FloatField implements FloatScript {

        private float field = 3.1415f;

        public float execute(float value) {
            return field;
        }
    }

    @Test
    public void DoubleField() {
        assertScript(new DoubleField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class DoubleField implements DoubleScript {

        private double field = 3.14159265358979323846264338327950288419716939937510d;

        public double execute(double value) {
            return field;
        }
    }

    @Test
    public void BooleanField() {
        assertScript(new BooleanField());
    }

    /**
     * @version 2009/08/18 18:54:24
     */
    private static class BooleanField implements BooleanScript {

        private boolean field = false;

        public boolean execute(boolean value) {
            return field;
        }
    }

    @Test
    public void Extend() {
        assertScript(new ExtendChild());
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
    private static class ExtendChild extends ExtendBase implements IntScript {

        public int execute(int value) {
            return value + field;
        }
    }

    @Test
    public void Override() {
        assertScript(new OverrideChild());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class OverrideBase {

        @SuppressWarnings("unused")
        protected int field = 10;
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class OverrideChild extends OverrideBase implements IntScript {

        protected int field = 5;

        public int execute(int value) {
            return value + this.field;
        }
    }

    @Test
    public void Super() {
        assertScript(new SuperChild());
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
    private static class SuperChild extends SuperBase implements IntScript {

        protected int field = 5;

        public int execute(int value) {
            return value + this.field + super.field;
        }
    }
}
