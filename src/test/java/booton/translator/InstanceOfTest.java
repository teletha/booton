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
package booton.translator;

import org.junit.Test;

import booton.translator.api.BooleanScript;

/**
 * @version 2009/09/02 19:04:59
 */
public class InstanceOfTest extends ScriptTranslatorTestcase {

    @Test
    public void InstanceOf() {
        assertScript(new Base());
    }

    private static class Base implements BooleanScript {

        public boolean execute(boolean value) {
            return this instanceof Base;
        }
    }

    @Test
    public void InstanceOfChild() {
        assertScript(new Child1());
    }

    private static class Child1 extends Base {

        public boolean execute(boolean value) {
            return this instanceof Child1;
        }
    }

    @Test
    public void InstanceOfBase() {
        assertScript(new Child2());
    }

    private static class Child2 extends Base {

        public boolean execute(boolean value) {
            return this instanceof Base;
        }
    }

    @Test
    public void InstanceOfObject() {
        assertScript(new OBJECT());
    }

    private static class OBJECT implements BooleanScript {

        public boolean execute(boolean value) {
            return this instanceof Object;
        }
    }
}
