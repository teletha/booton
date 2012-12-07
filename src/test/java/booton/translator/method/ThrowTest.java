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
    public void Exception() {
        test(new Scriptable() {

            public Object act() throws Exception {
                throw new Exception();
            }
        });
    }

    @Test
    public void ExceptionWithParam() {
        test(new Scriptable() {

            public String act(String value) throws Exception {
                throw new Exception(value);
            }
        });
    }

    @Test
    public void RuntimeException() {
        test(new Scriptable() {

            public String act() {
                throw new RuntimeException();
            }
        });
    }

    @Test
    public void Error() {
        test(new Scriptable() {

            public String act() {
                throw new Error();
            }
        });
    }
}
