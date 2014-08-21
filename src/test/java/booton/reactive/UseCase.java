/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.function.Consumer;

import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;

import booton.reactive.css.Color;
import booton.reactive.sample.Group;
import booton.reactive.sample.Person;

/**
 * @version 2014/08/21 13:31:48
 */
public class UseCase extends Reactive {

    /** The variable */
    public final Variable<String> name = new Variable<String>() {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void style() {
            // class A
            font.color(Color.Black);

            if (get().startsWith("A")) {
                // class A B
                font.color(Color.White);

                if (get().endsWith("A")) {
                    // class A B C
                    font.color(Color.White);
                }
            }

            if (condition()) {
                // class A D
                font.color(Color.White);
            }
        }

        /**
         * Some condition.
         * 
         * @return
         */
        private boolean condition() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return condition() ? "****" : get();
        };
    };

    public final Variable<Integer> size = new Variable();

    public final Group group = new Group();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void template() {
        hbox(() -> {
            for (Person person : group.members) {
                text("Hello ", person, "!");
            }
        });

        hbox(group.members, person -> {
            text("Hello ", $(person.name), "!");
        });
    }

    private static class Component {

    }

    private <T> Var<T> $(ObservableValue<T> value) {
        return null;
    }

    private static class Var<T> {

    }

    private <T> void hbox(ObservableList<T> list, Consumer<T> builder) {

    }

    @Target(ElementType.TYPE_USE)
    private static @interface A {

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new UseCase();
    }
}
