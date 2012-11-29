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
package booton.translator.primitive;

import org.junit.Test;

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.ShortScript;

/**
 * @version 2009/08/06 11:00:20
 */
public class ShortTest extends ScriptTranslatorTestcase {

    @Test
    public void zero() {
        assertScript(new ShortScript() {

            public short execute(short value) {
                return 0;
            }
        });
    }

    @Test
    public void one() {
        assertScript(new ShortScript() {

            public short execute(short value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        assertScript(new ShortScript() {

            public short execute(short value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        assertScript(new ShortScript() {

            public short execute(short value) {
                return 3;
            }
        });
    }

    @Test
    public void minus() {
        assertScript(new ShortScript() {

            public short execute(short value) {
                return -1;
            }
        });
    }

    @Test
    public void max() {
        assertScript(new ShortScript() {

            public short execute(short value) {
                return Short.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        assertScript(new ShortScript() {

            public short execute(short value) {
                return Short.MIN_VALUE;
            }
        });
    }
}
