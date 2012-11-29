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

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.api.ObjectScript;
import booton.translator.api.ThrowableScript;

/**
 * @version 2009/08/21 11:30:16
 */
@Ignore
public class ThrowTest extends ScriptTranslatorTestcase {

    @Test
    public void Exception() {
        assertScript(new ThrowableScript() {

            public Object execute(Object value) throws Exception {
                throw new Exception();
            }
        });
    }

    @Test
    public void ExceptionWithParam() {
        assertScript("message", new ThrowableScript<String>() {

            public String execute(String value) throws Exception {
                throw new Exception(value);
            }
        });
    }

    @Test
    public void RuntimeException() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                throw new RuntimeException();
            }
        });
    }

    @Test
    public void Error() {
        assertScript(new ObjectScript<String>() {

            public String execute(String value) {
                throw new Error();
            }
        });
    }
}
