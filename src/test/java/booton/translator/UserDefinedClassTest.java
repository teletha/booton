/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import org.junit.Test;

import booton.Person;
import booton.translator.api.IntScript;
import booton.translator.api.ObjectScript;

/**
 * @version 2012/11/30 15:33:32
 */
public class UserDefinedClassTest extends ScriptTranslatorTestcase {

    @Test
    public void UserClass() {
        assertScript(new IntScript() {

            public int execute(int value) {
                Person user = new Person();
                user.setAge(value);

                return user.getAge();
            }
        });
    }

    @Test
    public void UserClassToString() {
        assertScript("Hitagi", new ObjectScript<String>() {

            public String execute(String value) {
                Person user = new Person();
                user.setAge(17);
                user.setFirstName(value);
                user.setLastName(value + value);

                return user.toString();
            }
        });
    }
}
