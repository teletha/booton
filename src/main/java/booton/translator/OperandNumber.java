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

/**
 * @version 2009/08/20 22:05:18
 */
class OperandNumber extends Operand {

    /** The actual value of this operand. */
    final Number value;

    /**
     * 
     */
    OperandNumber(Number value) {
        this.value = value;
    }

    /**
     * @see booton.translator.Operand#cast(java.lang.Class)
     */
    @Override
    protected Operand cast(Class type) {
        if (type == char.class) {
            return new OperandString(String.valueOf((char) value.intValue()));
        }
        return super.cast(type);
    }

    /**
     * @see booton.translator.Operand#toString()
     */
    @Override
    public String toString() {
        return value.toString();
    }
}
