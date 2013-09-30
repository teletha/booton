/*
 * Copyright (C) 2013 Nameless Production Committee.
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

/**
 * @version 2013/08/23 23:35:09
 */
abstract class Operand {

    /** The flag for operand duplication. */
    boolean duplicated = false;

    /**
     * @param type
     * @return
     */
    Operand cast(Class type) {
        return this;
    }

    /**
     * <p>
     * Invert operand value if we can.
     * </p>
     * 
     * @return A inverted operand.
     */
    Operand invert() {
        return this;
    }

    /**
     * <p>
     * Disclose the outmost parenthesis if we can.
     * </p>
     * 
     * @return A disclosed operand.
     */
    Operand disclose() {
        return this;
    }

    /**
     * <p>
     * Infer the type of this {@link Operand}.
     * </p>
     * 
     * @return
     */
    abstract InferredType infer();
}
