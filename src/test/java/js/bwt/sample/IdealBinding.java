/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt.sample;

import js.bwt.Bind;
import kiss.Disposable;

/**
 * @version 2013/08/02 9:09:58
 */
public class IdealBinding {

    private Person person;

    private InputUI input;

    private void setup() {
        Binder.bind(this, input, person);
    }

    @Bind
    private void fromUI(InputUI input) {
        // modify person
        person.name = input.value;
    }

    @Bind
    private void fromModel(Person person) {
        // modify element
        input.value = person.name;
    }

    /**
     * @version 2013/08/02 9:52:06
     */
    private static class InputUI {

        private String value;
    }

    /**
     * @version 2013/08/02 9:10:14
     */
    private static class Person {

        private String name;

        private int age;
    }

    /**
     * @version 2013/08/02 10:12:53
     */
    private static class Binder {

        private static Disposable bind(Object binding, Object... instances) {
            return null;
        }
    }
}
