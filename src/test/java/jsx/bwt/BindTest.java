/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import kiss.I;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.sample.Person;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/11 9:55:28
 */
@RunWith(ScriptRunner.class)
public class BindTest {

    static {
        I.load(Binds.class, true);
    }

    @Test
    public void bind() throws Exception {
        Listener listener = I.make(Listener.class);

        Person person = new Person();
        person.setAge(16);
        person.setName("Yuigahama Yui");
        assert listener.age == 0;
        assert listener.name == null;

        listener.set(person);
        assert listener.age == 16;
        assert listener.name.equals("Yuigahama Yui");

        person.setAge(27);
        assert listener.age == 27;

        person.setName("Hiratuka Sizuka");
        assert listener.name.equals("Hiratuka Sizuka");
    }

    /**
     * @version 2013/10/11 10:01:31
     */
    protected static class Listener {

        private String name;

        private int age;

        @Bind
        protected void set(Person person) {
            name = person.getName();
            age = person.getAge();
        }
    }
}
