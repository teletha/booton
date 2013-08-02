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

/**
 * @version 2013/08/02 9:09:58
 */
public class WhatIsBinding {

    private Person person;

    private InputUI input;

    private void setup() {
        input.bind(this);
        person.bind(this);
    }

    private void fromUI(InputUI input) {
        // modify person
        person.setName(input.getValue());
    }

    private void fromModel(Person person) {
        // modify element
        input.setValue(person.getName());
    }

    /**
     * @version 2013/08/02 9:52:06
     */
    private static class InputUI {

        private String value;

        /**
         * Get the value property of this {@link WhatIsBinding.InputUI}.
         * 
         * @return The value property.
         */
        protected String getValue() {
            return value;
        }

        /**
         * Set the value property of this {@link WhatIsBinding.InputUI}.
         * 
         * @param value The value value to set.
         */
        protected void setValue(String value) {
            this.value = value;

            // fire change event
            fire(this);
        }

        private void bind(Object subscriber) {
            // register event listeners
        }

        private void fire(Object event) {
            // fire event to listeners
        }
    }

    /**
     * @version 2013/08/02 9:10:14
     */
    private static class Person {

        private String name;

        private int age;

        /**
         * Get the name property of this {@link WhatIsBinding.Person}.
         * 
         * @return The name property.
         */
        protected String getName() {
            return name;
        }

        /**
         * Set the name property of this {@link WhatIsBinding.Person}.
         * 
         * @param name The name value to set.
         */
        protected void setName(String name) {
            this.name = name;

            // fire change event
            fire(this);
        }

        /**
         * Get the age property of this {@link WhatIsBinding.Person}.
         * 
         * @return The age property.
         */
        protected int getAge() {
            return age;
        }

        /**
         * Set the age property of this {@link WhatIsBinding.Person}.
         * 
         * @param age The age value to set.
         */
        protected void setAge(int age) {
            this.age = age;

            // fire change event
            fire(this);
        }

        private void bind(Object subscriber) {
            // register event listeners
        }

        private void fire(Object event) {
            // fire event to listeners
        }
    }
}
