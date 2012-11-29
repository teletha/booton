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

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.BooleanScript;
import booton.translator.api.ByteScript;
import booton.translator.api.DoubleScript;
import booton.translator.api.FloatScript;
import booton.translator.api.IntScript;
import booton.translator.api.LongScript;
import booton.translator.api.ObjectScript;
import booton.translator.api.ShortScript;

/**
 * @version 2009/08/05 17:03:59
 */
public class MethodParameterTest extends ScriptTranslatorTestcase {

    @Test
    public void Int() {
        assertScript(0, 1, new IntScript() {

            public int execute(int value) {
                return value;
            }
        });
    }

    @Test
    public void Long() {
        assertScript(1234567890L, 1234567891L, new LongScript() {

            public long execute(long value) {
                return value;
            }
        });
    }

    @Test
    public void Float() {
        assertScript(1.2F, 2.2F, new FloatScript() {

            public float execute(float value) {
                return value;
            }
        });
    }

    @Test
    public void Double() {
        assertScript(1.23456789D, 2.23456789D, new DoubleScript() {

            public double execute(double value) {
                return value;
            }
        });
    }

    @Test
    public void Byte() {
        assertScript((byte) 0, (byte) 1, new ByteScript() {

            public byte execute(byte value) {
                return value;
            }
        });
    }

    @Test
    public void Short() {
        assertScript((short) 0, (short) 1, new ShortScript() {

            public short execute(short value) {
                return value;
            }
        });
    }

    @Test
    public void Boolean() {
        assertScript(new BooleanScript() {

            public boolean execute(boolean value) {
                return value;
            }
        });
    }

    @Test
    public void String() {
        assertScript("value", new ObjectScript<String>() {

            public String execute(String value) {
                return value;
            }
        });
    }
}
