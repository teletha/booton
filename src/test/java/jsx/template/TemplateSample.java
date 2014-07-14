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
import booton.sample.Person;

/**
 * @version 2014/02/04 8:46:28
 */
public class TemplateSample {

    public void use() {
        ui(I.make(Person.class));
    }

    @Template
    public void ui(Person person) {
        String name = person.getName();

        if (20 <= person.getAge()) {
            list(() -> {
                for (Person friend : person.getFriends()) {
                    item(friend.getName() + " (" + friend.getAge() + ")");
                }
            });
        }
    }

    void list(Runnable a) {

    }

    void item(Object... contents) {

    }

    @Template
    public void html(Person person) throws Exception {
        p(person.getName());
        ol(() -> {
            for (Person friend : person.getFriends()) {
                li(friend.getName());
            }
        });
    }

    void ol(Runnable a) {

    }

    void p(Object... contents) {

    }

    void li(Object... contents) {

    }

    public static class TemplateView {

        /**
         * 
         */
        public TemplateView(Runnable a) {
        }
    }

    public static class Computable {

        void compute() {

        }
    }
}
