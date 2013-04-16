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
package booton.translator.method;

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/07 10:51:19
 */
@SuppressWarnings("unused")
public class ThrowTest extends ScriptTester {

    @Test
    public void exception() {
        test(new Scriptable() {

            public int act() throws Exception {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    return 10;
                }
            }
        });
    }

    @Test
    public void exceptionWithParam() {
        test(new Scriptable() {

            public String act(String value) throws Exception {
                try {
                    throw new Exception("test");
                } catch (Exception e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Test
    public void runtimeException() {
        test(new Scriptable() {

            public String act() {
                try {
                    throw new RuntimeException("test");
                } catch (RuntimeException e) {
                    return e.getMessage();
                }
            }
        });
    }

    @Test
    public void error() {
        test(new Scriptable() {

            public String act() {
                try {
                    throw new Error("test");
                } catch (Error e) {
                    return e.getMessage();
                }
            }
        });
    }
}
