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

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.sample.Person;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/13 11:20:06
 */
@RunWith(ScriptRunner.class)
public class BindableInputTest {

    static {
        I.load(Binds.class, true);
    }

    @Test
    @Ignore
    public void input() throws Exception {
        Person person = I.make(Person.class);

        BindableInput<Person> input = I.make(BindableInput.class);
        input.bind(person, "age");

        assert input.form.val().endsWith("0");

        person.setAge(16);
        assert input.form.val().equals("16");
    }
}
