/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.enumeration;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/01/22 15:36:20
 */
@SuppressWarnings("unused")
public class EnumTest extends ScriptTester {

    /**
     * @version 2013/01/22 15:38:31
     */
    private static enum Number {
        One, Two, Three;
    }

    @Test
    public void name() throws Exception {
        test(new Scriptable() {

            String act() {
                String name = Number.One.name();
                assert name.equals("One");

                return name;
            }
        });
    }

    @Test
    public void ordinal() throws Exception {
        test(new Scriptable() {

            int act() {
                int index = Number.One.ordinal();
                assert index == 0;

                return index;
            }
        });
    }

    @Test
    public void values() throws Exception {
        test(new Scriptable() {

            String act() {
                Number[] numbers = Number.values();
                assert numbers.length == 3;
                assert numbers[0] == Number.One;
                assert numbers[1] == Number.Two;
                assert numbers[2] == Number.Three;

                return numbers[2].name();
            }
        });
    }

    @Test
    public void valueOf() throws Exception {
        test(new Scriptable() {

            String act() {
                return Number.valueOf("One").name();
            }
        });
    }

    @Test
    public void field() throws Exception {
        test(new Scriptable() {

            String act() {
                return Field.Two.field;
            }
        });
    }

    /**
     * @version 2013/01/22 15:38:31
     */
    private static enum Field {
        One("A"), Two("B"), Three("C");

        private final String field;

        /**
         * 
         */
        private Field(String value) {
            this.field = value;
        }
    }

    @Test
    public void method() throws Exception {
        test(new Scriptable() {

            String act() {
                return Method.Three.method();
            }
        });
    }

    /**
     * @version 2013/01/22 15:38:31
     */
    private static enum Method {
        One("A"), Two("B"), Three("C");

        private final String field;

        /**
         * 
         */
        private Method(String value) {
            this.field = value;
        }

        private String method() {
            return field;
        }
    }
}
