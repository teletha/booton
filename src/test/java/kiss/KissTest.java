/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.Person;
import booton.translator.ScriptRunner;

/**
 * @version 2013/09/24 13:54:25
 */
@RunWith(ScriptRunner.class)
public class KissTest {

    @Test
    public void make() throws Exception {
        Person person = I.make(Person.class);
        person.setAge(10);

        assert person.getAge() == 10;
    }
}
