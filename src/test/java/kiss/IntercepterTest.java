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

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/08/02 12:35:43
 */
@SuppressWarnings("unused")
public class IntercepterTest extends ScriptTester {

    @Test
    public void make() throws Exception {
        test(new Scriptable() {

            private String act() {
                Person person = I.make(Person.class);

                return person.name;
            }
        });
    }

    /**
     * @version 2013/08/02 12:37:28
     */
    private static class Person {

        private String name = "none";
    }
}
