/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.sdk;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/16 21:33:44
 */
@SuppressWarnings("unused")
public class ObjectTest extends ScriptTester {

    /**
     * @version 2013/01/16 21:36:02
     */
    private static class Klass {
    }

    @Test
    public void Equals() throws Exception {
        test(new Scriptable() {

            boolean act() {
                Object one = new Klass();
                return one.equals(one);
            }
        });
    }

    @Test
    public void EqualsBetweenDifferentInstance() throws Exception {
        test(new Scriptable() {

            boolean act() {
                Object one = new Klass();
                Object two = new Klass();
                return one.equals(two);
            }
        });
    }

    @Test
    public void HashCode() throws Exception {
        test(new Scriptable() {

            boolean act() {
                Object one = new Klass();
                return one.hashCode() == one.hashCode();
            }
        });
    }

    @Test
    public void HashCodeBetweenDifferentInstance() throws Exception {
        test(new Scriptable() {

            boolean act() {
                Object one = new Klass();
                Object two = new Klass();
                return one.hashCode() != two.hashCode();
            }
        });
    }

    @Test
    public void GetClass() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return new Klass().getClass() == Klass.class;
            }
        });
    }
}
