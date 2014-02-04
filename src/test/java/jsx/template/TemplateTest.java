/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.template;

import kiss.I;

import org.junit.Test;

import booton.sample.Person;

/**
 * @version 2014/02/04 14:00:12
 */
public class TemplateTest {

    static {
        I.load(TemplateSample.class, true);
    }

    @Test
    public void testname() throws Exception {
        Person person = I.make(Person.class);
        person.setAge(12);
        person.setName("Satuki");

        TemplateSample sample = I.make(TemplateSample.class);
        sample.ui(person);
    }
}
