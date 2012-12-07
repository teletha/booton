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
package booton.translator.builtin;

import booton.translator.Translator;

/**
 * @version 2009/08/19 0:17:49
 */
public class StringTranslatorForBuilder extends Translator<StringBuilder> {

    /**
     * @see StringBuilder#StringBuilder(String)
     */
    public String StringBuilder() {
        return "";
    }

    /**
     * @see StringBuilder#StringBuilder(String)
     */
    public String StringBuilder(String str) {
        return param(0);
    }

    /**
     * @see StringBuilder#StringBuilder(int)
     */
    public String StringBuilder(int value) {
        return param(0);
    }

    /**
     * @see StringBuilder#append(boolean)
     */
    public String append(boolean value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#append(char)
     */
    public String append(char value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#append(int)
     */
    public String append(int value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#append(long)
     */
    public String append(long value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#append(float)
     */
    public String append(float value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#append(double)
     */
    public String append(double value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#append(String)
     */
    public String append(String value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#append(Object)
     */
    public String append(Object value) {
        return that + "+" + param(0);
    }

    /**
     * @see StringBuilder#toString()
     */
    public String toString() {
        return that;
    }
}
