/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.operator;

import java.io.Serializable;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/04/11 11:05:08
 */
@SuppressWarnings("unused")
public class InstanceOfTest extends ScriptTester {

    @Test
    public void InstanceOf() {
        test(new Base());
    }

    private static class Base implements Scriptable {

        public boolean act() {
            return this instanceof Base;
        }
    }

    @Test
    public void InstanceOfChild() {
        test(new Child1());
    }

    private static class Child1 extends Base {

        public boolean act() {
            return this instanceof Child1;
        }
    }

    @Test
    public void InstanceOfBase() {
        test(new Child2());
    }

    private static class Child2 extends Base {

        public boolean act() {
            return this instanceof Base;
        }
    }

    @Test
    public void InstanceOfObject() {
        test(new OBJECT());
    }

    private static class OBJECT implements Scriptable {

        public boolean act() {
            return this instanceof Object;
        }
    }

    @Test
    public void InstanceOfInterface() {
        test(new ValidInterface());
    }

    private static class ValidInterface implements Scriptable {

        public boolean act() {
            return this instanceof Scriptable;
        }
    }

    @Test
    public void InstanceOfInvalidInterface() {
        test(new ValidInterface());
    }

    private static class InivalidInterface implements Scriptable {

        public boolean act() {
            return this instanceof Serializable;
        }
    }
}
