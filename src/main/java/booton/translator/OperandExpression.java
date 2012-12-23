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
 * @version 2009/08/21 0:10:03
 */
class OperandExpression extends Operand {

    /** The actual string expression of this operand. */
    private Object expression;

    /**
     * 
     */
    OperandExpression(Object expression) {
        this.expression = expression;
    }

    /**
     * @see booton.translator.Operand#invert()
     */
    @Override
    Operand invert() {
        if (expression != null) {
            String value = expression.toString();

            if (value.charAt(0) == '(') {
                expression = "!".concat(value);
            } else if (value.charAt(0) == '!') {
                expression = value.substring(1);
            }
        }

        // API definition
        return this;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return expression == null ? null : expression.toString();
    }
}
