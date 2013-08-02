/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

import js.bwt.model.Person;
import kiss.I;

import org.junit.Test;

/**
 * @version 2013/08/02 10:42:39
 */
public class BindingTest {

    static {
        I.load(Binds.class, true);
    }

    @Test
    public void String() throws Exception {
        FromUI instance = I.make(FromUI.class);
        assert instance.input.getValue() == null;
        assert instance.person.getName() == null;

        // bind
        Binder.bind(instance, instance.input);

        // set new value
        instance.input.setValue("set");

        assert instance.input.getValue().equals("set");
        assert instance.person.getName().equals("set");

        // set new value
        instance.input.setValue("change");

        assert instance.input.getValue().equals("change");
        assert instance.person.getName().equals("change");
    }

    /**
     * @version 2013/08/02 10:43:32
     */
    protected static class FromUI {

        private Person person;

        private Input input;

        /**
         * @param person
         * @param input
         */
        protected FromUI(Person person, Input input) {
            this.person = person;
            this.input = input;
        }

        @Bind
        protected void bind(Input input) {
            person.setName(input.getValue());
        }
    }
}
