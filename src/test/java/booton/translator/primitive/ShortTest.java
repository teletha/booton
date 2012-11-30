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

import booton.translator.api.ScriptTester;
import booton.translator.api.Scriptable;

/**
 * @version 2012/12/01 2:07:31
 */
@SuppressWarnings("unused")
public class ShortTest extends ScriptTester {

    @Test
    public void zero() {
        test(new Scriptable() {

            short act(short value) {
                return 0;
            }
        });
    }

    @Test
    public void one() {
        test(new Scriptable() {

            short act(short value) {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        test(new Scriptable() {

            short act(short value) {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        test(new Scriptable() {

            short act(short value) {
                return 3;
            }
        });
    }

    @Test
    public void minus() {
        test(new Scriptable() {

            short act(short value) {
                return -1;
            }
        });
    }

    @Test
    public void max() {
        test(new Scriptable() {

            short act(short value) {
                return Short.MAX_VALUE;
            }
        });
    }

    @Test
    public void min() {
        test(new Scriptable() {

            short act(short value) {
                return Short.MIN_VALUE;
            }
        });
    }
}
