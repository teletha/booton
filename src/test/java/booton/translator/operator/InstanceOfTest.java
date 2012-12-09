/*
 * Copyright (C) 2009 Nameless Production Committee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package booton.translator.operator;

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/01 3:43:44
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
    @Ignore
    public void InstanceOfObject() {
        test(new OBJECT());
    }

    private static class OBJECT implements Scriptable {

        public boolean act() {
            return this instanceof Object;
        }
    }
}
