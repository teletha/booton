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
 * @version 2009/08/21 11:40:12
 */
public class ErrorTranslator extends Translator<Throwable> {

    /**
     * @see Throwable#Throwable()
     */
    public String Throwable() {
        return "";
    }

    /**
     * @see Throwable#Throwable(String)
     */
    public String Throwable(String message) {
        return "this.message=" + param(0);
    }

    /**
     * @see Throwable#Throwable(String, Throwable)
     */
    public String Throwable(String message, Throwable throwable) {
        return "this.message=" + param(0) + ";this.cause=" + param(1);
    }

    /**
     * @see Throwable#Throwable(Throwable)
     */
    public String Throwable(Throwable throwable) {
        return "this.cause=" + param(0);
    }
}
