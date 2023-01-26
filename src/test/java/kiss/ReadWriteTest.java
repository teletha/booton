/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.sample.Person;
import booton.sample.beans.Collections;
import booton.sample.beans.Primitives;
import booton.sample.beans.StringList;
import booton.sample.beans.StringMap;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/02 11:28:35
 */
@RunWith(ScriptRunner.class)
public class ReadWriteTest {

    @Test
    public void bean() {
        Person person = I.make(Person.class);
        person.setAge(16);
        person.setName("Yuigahama Yui");

        Person other = writeThenRead(person);

        assert other.getAge() == 16;
        assert other.getName().equals("Yuigahama Yui");
    }

    @Test
    public void primitives() throws Exception {
        Primitives primitives = I.make(Primitives.class);
        primitives.setIntValue(10);
        primitives.setBooleanValue(true);
        primitives.setByteValue((byte) 2);
        primitives.setCharValue('a');
        primitives.setDoubleValue(9.3443456345634D);
        primitives.setFloatValue(0.533f);
        primitives.setLongValue(3020103L);
        primitives.setShortValue((short) 19);

        Primitives other = writeThenRead(primitives);

        assert other.getByteValue() == 2;
        assert other.getCharValue() == 'a';
        assert other.getDoubleValue() == 9.3443456345634D;
        assert other.getFloatValue() == 0.533f;
        assert other.getIntValue() == 10;
        // assert other.getLongValue() == 3020103L;
        assert other.getShortValue() == 19;
    }

    @Test
    public void listProperty() throws Exception {
        List<String> list = new ArrayList();
        list.add("one");
        list.add("two");
        list.add("three");

        Collections collections = I.make(Collections.class);
        collections.setList(list);

        Collections other = writeThenRead(collections);
        assert other.getList().size() == 3;
        assert other.getList().get(0).equals("one");
        assert other.getList().get(1).equals("two");
        assert other.getList().get(2).equals("three");
    }

    @Test
    public void mapProperty() throws Exception {
        Map<String, String> map = new HashMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        Collections collections = I.make(Collections.class);
        collections.setMap(map);

        Collections other = writeThenRead(collections);
        assert other.getMap().size() == 3;
        assert other.getMap().get("1").equals("one");
        assert other.getMap().get("2").equals("two");
        assert other.getMap().get("3").equals("three");
    }

    @Test
    public void list() throws Exception {
        List<String> list = new StringList();
        list.add("one");
        list.add("two");
        list.add("three");

        List<String> other = writeThenRead(list);
        assert other.size() == 3;
        assert other.get(0).equals("one");
        assert other.get(1).equals("two");
        assert other.get(2).equals("three");
    }

    @Test
    public void map() throws Exception {
        Map<String, String> map = new StringMap();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        Map<String, String> other = writeThenRead(map);
        assert other.size() == 3;
        assert other.get("1").equals("one");
        assert other.get("2").equals("two");
        assert other.get("3").equals("three");
    }

    /**
     * <p>
     * Helper method to write and read model.
     * </p>
     * 
     * @param model
     * @return
     */
    private <T> T writeThenRead(T model) {
        StringBuilder builder = new StringBuilder();
        I.write(model, builder);
        T other = I.json(builder.toString(), (Class<T>) model.getClass());

        assert other != model;
        return other;
    }
}
