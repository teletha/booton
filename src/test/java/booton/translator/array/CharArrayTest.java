/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.array;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2012/11/30 13:30:30
 */
@SuppressWarnings("unused")
public class CharArrayTest extends ScriptTester {

    @Test
    public void get() throws Exception {
        test(new Scriptable() {

            char act() {
                char[] array = {'a'};

                return array[0];
            }
        });
    }

    @Test
    public void Array() {
        test(new Scriptable() {

            public char[] act() {
                char[] array = new char[2];
                array[0] = 'a';
                array[1] = 'b';

                return array;
            }
        });
    }

    @Test
    public void single() throws Exception {
        test(new Scriptable() {

            char[] act() {
                char[] array = new char[1];
                array[0] = 'a';

                return array;
            }
        });
    }

    @Test
    public void multiple() throws Exception {
        test(new Scriptable() {

            char[] act() {
                char[] array = new char[3];
                array[0] = 'a';
                array[1] = 'b';
                array[2] = 'c';

                return array;
            }
        });
    }

    @Test
    public void expression() throws Exception {
        test(new Scriptable() {

            char[] act(char value) {
                char[] array = new char[1];
                array[0] = value;

                return array;
            }
        });
    }

    @Test
    public void multiDimension() throws Exception {
        test(new Scriptable() {

            char[][] act() {
                char[][] array = new char[2][];
                array[0] = new char[] {'a', 'b'};
                array[1] = new char[] {'c', 'd'};

                return array;
            }
        });
    }

    @Test
    public void shorthandSingle() throws Exception {
        test(new Scriptable() {

            char[] act() {
                return new char[] {'a'};
            }
        });
    }

    @Test
    public void shorthandMultiple() throws Exception {
        test(new Scriptable() {

            char[] act() {
                return new char[] {'a', 'b', 'c'};
            }
        });
    }

    @Test
    public void shorthandWithNumeric() throws Exception {
        test(new Scriptable() {

            char[] act() {
                return new char[] {'2', '1', '0'};
            }
        });
    }

    @Test
    public void shorthandWithExpression() throws Exception {
        test(new Scriptable() {

            char[] act(char value) {
                return new char[] {value};
            }
        });
    }

    @Test
    public void shorthandTooMany() throws Exception {
        test(new Scriptable() {

            char[] act() {
                return new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q'};
            }
        });
    }

    @Test
    public void shorthandMultiDimension() throws Exception {
        test(new Scriptable() {

            char[][] act() {
                return new char[][] { {'1', '2'}, {'a', 'b'}};
            }
        });
    }
}
