/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

import org.junit.Test;

import booton.sample.Person;

/**
 * @version 2013/11/06 16:16:05
 */
public class IdealBindableInput {

    @Test
    public void base() throws Exception {
        Person person = new Person();
        person.setAge(10);

        Input<Integer> input = new Input(person::getAge, person::setAge);
        System.out.println(person.getAge());
    }

    private void modify(Person model) {
        System.out.println("change model");
    }

    private static class Input<T> {

        private Input(IntSupplier supplier, IntConsumer consumer) {
            System.out.println(supplier.getAsInt());
            consumer.accept(30);
        }
    }

}
