/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.sample.Person;
import booton.soeur.ScriptRunner;
import js.lang.Global;
import js.lang.builtin.Storage;

/**
 * @version 2013/10/04 10:35:29
 */
@RunWith(ScriptRunner.class)
@Ignore
public class EmulateStorageTest {

    @Test
    public void storage() throws Exception {
        Storage storage = Global.localStorage;
        assert storage.length() == 0;
        assert storage.getItem("1") == null;

        storage.setItem("1", "one");
        assert storage.length() == 1;
        assert storage.getItem("1").equals("one");

        storage.removeItem("1");
        assert storage.length() == 0;
        assert storage.getItem("1") == null;
    }

    @Test
    public void model() throws Exception {
        Person person = new Person();
        person.setAge(16);
        person.setName("Yuigahama Yui");

        Storage storage = Global.localStorage;
        storage.set(person);

        Person other = storage.get(Person.class);
        assert other.getAge() == 16;
        assert other.getName().equals("Yuigahama Yui");
    }
}
