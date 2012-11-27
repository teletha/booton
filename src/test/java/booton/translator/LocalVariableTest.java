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

/**
 * @version 2009/12/09 8:40:00
 */
public class LocalVariableTest extends ScriptTranslatorTestcase {

    @Test
    public void parallel() {
        assertScript(0, 5, new ScriptForInt() {

            /**
             * @see booton.translator.ScriptForInt#execute(int)
             */
            public int execute(int value) {
                if (value < 3) {
                    int x = value;

                    value = value - 1;
                    value = x * value;
                } else {
                    int y = value;

                    value = value + 1;
                    value = y * value;
                }
                return value;
            }
        });
    }
}
