/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/09/07 2:59:28
 */
@RunWith(ScriptRunner.class)
public class FieldTest {

    @Test
    public void getType() throws Exception {
        assert Definition.class.getField("intValue").getType() == int.class;
        assert Definition.class.getField("longValue").getType() == long.class;
        assert Definition.class.getField("booleanValue").getType() == boolean.class;
        assert Definition.class.getField("stringValue").getType() == String.class;
    }

    @Test
    public void getDeclaringClass() throws Exception {
        assert Definition.class.getField("intValue").getDeclaringClass() == Definition.class;
        assert Definition.class.getField("longValue").getDeclaringClass() == Definition.class;

    }

    @Test
    public void intValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("intValue");

        assert definition.intValue == 0;
        assert field.getInt(definition) == 0;
        field.setInt(definition, 10);
        assert definition.intValue == 10;
        assert field.getInt(definition) == 10;
    }

    @Test
    public void longValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("longValue");

        assert definition.longValue == 0;
        assert field.getLong(definition) == 0;
        field.setLong(definition, 10);
        assert definition.longValue == 10;
        assert field.getLong(definition) == 10;
    }

    @Test
    public void floatValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("floatValue");

        assert definition.floatValue == 0;
        assert field.getFloat(definition) == 0;
        field.setFloat(definition, 10);
        assert definition.floatValue == 10;
        assert field.getFloat(definition) == 10;
    }

    @Test
    public void doubleValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("doubleValue");

        assert definition.doubleValue == 0;
        assert field.getDouble(definition) == 0;
        field.setDouble(definition, 10);
        assert definition.doubleValue == 10;
        assert field.getDouble(definition) == 10;
    }

    @Test
    public void byteValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("byteValue");

        assert definition.byteValue == 0;
        assert field.getByte(definition) == 0;
        field.setByte(definition, (byte) 2);
        assert definition.byteValue == 2;
        assert field.getByte(definition) == 2;
    }

    @Test
    public void shortValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("shortValue");

        assert definition.shortValue == 0;
        assert field.getShort(definition) == 0;
        field.setShort(definition, (short) 2);
        assert definition.shortValue == 2;
        assert field.getShort(definition) == 2;
    }

    @Test
    public void booleanValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("booleanValue");

        assert !definition.booleanValue;
        assert !field.getBoolean(definition);
        field.setBoolean(definition, true);
        assert definition.booleanValue;
        assert field.getBoolean(definition);
    }

    @Test
    public void charValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("charValue");

        assert definition.charValue == 'a';
        assert field.getChar(definition) == 'a';
        field.setChar(definition, 'b');
        assert definition.charValue == 'b';
        assert field.getChar(definition) == 'b';
    }

    @Test
    public void objectValue() throws Exception {
        Definition definition = new Definition();
        Field field = Definition.class.getField("stringValue");

        assert definition.stringValue.equals("a");
        assert field.get(definition).equals("a");
        field.set(definition, "b");
        assert definition.stringValue.equals("b");
        assert field.get(definition).equals("b");
    }

    /**
     * @version 2013/09/07 1:22:35
     */
    private static class Definition {

        public int intValue;

        public long longValue;

        public float floatValue;

        public double doubleValue;

        public byte byteValue;

        public short shortValue;

        public boolean booleanValue;

        public char charValue = 'a';

        public String stringValue = "a";
    }
}
