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
 * @version 2009/08/05 17:03:59
 */
public class MethodParameterTest extends ScriptTranslatorTestcase {

    @Test
    public void Int() {
        assertScript(0, 1, new ScriptForInt() {

            public int execute(int value) {
                return value;
            }
        });
    }

    @Test
    public void Long() {
        assertScript(1234567890L, 1234567891L, new ScriptForLong() {

            public long execute(long value) {
                return value;
            }
        });
    }

    @Test
    public void Float() {
        assertScript(1.2F, 2.2F, new ScriptForFloat() {

            public float execute(float value) {
                return value;
            }
        });
    }

    @Test
    public void Double() {
        assertScript(1.23456789D, 2.23456789D, new ScriptForDouble() {

            public double execute(double value) {
                return value;
            }
        });
    }

    @Test
    public void Byte() {
        assertScript((byte) 0, (byte) 1, new ScriptForByte() {

            public byte execute(byte value) {
                return value;
            }
        });
    }

    @Test
    public void Short() {
        assertScript((short) 0, (short) 1, new ScriptForShort() {

            public short execute(short value) {
                return value;
            }
        });
    }

    @Test
    public void Boolean() {
        assertScript(new ScriptForBoolean() {

            public boolean execute(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void String() {
        assertScript("value", new ScriptForObject<String>() {

            public String execute(String value) {
                return value;
            }
        });
    }
}
