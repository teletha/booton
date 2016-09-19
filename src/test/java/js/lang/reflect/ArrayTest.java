/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.Array;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/20 0:49:06
 */
@RunWith(ScriptRunner.class)
public class ArrayTest {

    private int[] ints = {0, 1, 2, 3, 4};

    private long[] longs = {-1, 0, 1};

    private float[] floats = {0, 1.1F, 2.2F};

    private double[] doubles = {0, 1.1, 2.2, 3.3};

    @Test
    public void length() throws Exception {
        assert Array.getLength(ints) == 5;
        assert Array.getLength(doubles) == 4;
    }

    @Test(expected = NullPointerException.class)
    public void lengthNull() throws Exception {
        Array.getLength(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void lengthNotArray() throws Exception {
        Array.getLength(new Object());
    }

    @Test
    public void newInstance() throws Exception {
        Object array = Array.newInstance(int.class, 10);
        assert Array.getLength(array) == 10;
        assert Array.getInt(array, 0) == 0;
        assert Array.getInt(array, 1) == 0;
        assert Array.getInt(array, 9) == 0;

        array = Array.newInstance(float.class, 3);
        assert Array.getLength(array) == 3;
        assert Array.getFloat(array, 0) == 0;
        assert Array.getFloat(array, 1) == 0;
        assert Array.getFloat(array, 2) == 0;
    }

    @Test
    public void get() throws Exception {
        assert Array.getInt(ints, 0) == 0;
        assert Array.getLong(longs, 0) == -1;
        assert Array.getFloat(floats, 0) == 0;
        assert Array.getDouble(doubles, 0) == 0;
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getOutOfIndex1() throws Exception {
        Array.getInt(ints, -1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getOutOfIndex2() throws Exception {
        Array.getInt(ints, 100);
    }

    @Test
    public void primitiveInt() throws Exception {
        Object array = Array.newInstance(int.class, 1);
        assert Array.getInt(array, 0) == 0;
        assert array.getClass() == int[].class;

        Array.setInt(array, 0, 10);
        assert Array.getInt(array, 0) == 10;
    }

    @Test
    public void primitiveLong() throws Exception {
        Object array = Array.newInstance(long.class, 1);
        assert Array.getLong(array, 0) == 0;

        Array.setLong(array, 0, 10);
        assert Array.getLong(array, 0) == 10;
    }

    @Test
    public void primitiveFloat() throws Exception {
        Object array = Array.newInstance(float.class, 1);
        assert Array.getFloat(array, 0) == 0;

        Array.setFloat(array, 0, 10);
        assert Array.getFloat(array, 0) == 10;
    }

    @Test
    public void primitiveDouble() throws Exception {
        Object array = Array.newInstance(double.class, 1);
        assert Array.getDouble(array, 0) == 0;

        Array.setDouble(array, 0, 10);
        assert Array.getDouble(array, 0) == 10;
    }

    @Test
    public void primitiveBoolean() throws Exception {
        Object array = Array.newInstance(boolean.class, 1);
        assert !Array.getBoolean(array, 0);

        Array.setBoolean(array, 0, true);
        assert Array.getBoolean(array, 0);
    }

    @Test
    public void primitiveShort() throws Exception {
        Object array = Array.newInstance(short.class, 1);
        assert Array.getShort(array, 0) == 0;

        Array.setShort(array, 0, (short) 2);
        assert Array.getShort(array, 0) == 2;
    }

    @Test
    public void primitiveByte() throws Exception {
        Object array = Array.newInstance(byte.class, 1);
        assert Array.getByte(array, 0) == 0;

        Array.setByte(array, 0, (byte) 2);
        assert Array.getByte(array, 0) == 2;
    }
}
