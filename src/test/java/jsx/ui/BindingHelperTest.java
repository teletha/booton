/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import kiss.I;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/10/02 14:44:13
 */
@RunWith(ScriptRunner.class)
public class BindingHelperTest {

    @Test
    public void filter() {
        Person person1 = new Person("HimeragiYukina", 15);
        Person person2 = new Person("AibaAsagi", 16);
        Person person3 = new Person("KirasakaSayaka", 16);

        ListProperty<Person> list = I.make(ListProperty.class);
        list.add(person1);
        list.add(person2);
        list.add(person3);

        ListProperty<Person> filtered = BindingHelper.filter(list, v -> v.age.get() < 16);

        assert list.size() == 3;
        assert filtered.size() == 1;

        Person person4 = new Person("AkatukiNagisa", 15);
        list.add(person4);
        assert list.size() == 4;
        assert filtered.size() == 2;

        person3.age.set(15);
        assert list.size() == 4;
        assert filtered.size() == 3;
    }

    /**
     * @version 2014/10/02 14:48:14
     */
    private static class Person {

        /** The age property. */
        public final IntegerProperty age = new SimpleIntegerProperty();

        /** The name property. */
        public final StringProperty name = new SimpleStringProperty();

        /**
         * @param name
         * @param age
         */
        private Person(String name, int age) {
            this.name.set(name);
            this.age.set(age);
        }
    }
}
