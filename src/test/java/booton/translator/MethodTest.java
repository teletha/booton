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
 * @version 2009/08/18 19:19:10
 */
public class MethodTest extends ScriptTranslatorTestcase {

    @Test
    public void Basic() {
        assertScript(new Basic());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class Basic implements ScriptForInt {

        public int execute(int value) {
            return compute();
        }

        private int compute() {
            return -10;
        }
    }

    @Test
    public void Param() {
        assertScript(new Param());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class Param implements ScriptForInt {

        public int execute(int value) {
            return compute(value);
        }

        private int compute(int value) {
            return 100 + value;
        }
    }

    @Test
    public void MultipleParams() {
        assertScript(new MultipleParams());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class MultipleParams implements ScriptForInt {

        public int execute(int value) {
            return compute(value, value + 1);
        }

        private int compute(int first, int second) {
            return first * second;
        }
    }

    @Test
    public void ArrayParam() {
        assertScript(new ArrayParam());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class ArrayParam implements ScriptForInt {

        public int execute(int value) {
            int[] ints = {value, value + 1, value + 2};

            return compute(ints);
        }

        private int compute(int[] values) {
            int i = 0;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void VariableParam() {
        assertScript(new VariableParam());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class VariableParam implements ScriptForInt {

        public int execute(int value) {
            return compute(value, value + 1, value + 2);
        }

        private int compute(int... values) {
            int i = 0;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void VariableParamWithBase() {
        assertScript(new VariableParamWithBase());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class VariableParamWithBase implements ScriptForInt {

        public int execute(int value) {
            return compute(value, value + 1, value + 2);
        }

        private int compute(int base, int... values) {
            int i = base * base;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void VariableParamWithBaseOnly() {
        assertScript(new VariableParamWithBaseOnly());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class VariableParamWithBaseOnly implements ScriptForInt {

        public int execute(int value) {
            return compute(value);
        }

        private int compute(int base, int... values) {
            int i = base * base;

            for (int j = 0; j < values.length; j++) {
                i += values[j];
            }

            return i;
        }
    }

    @Test
    public void Nest() {
        assertScript(new Nest());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class Nest implements ScriptForInt {

        public int execute(int value) {
            return compute(value, nest(value));
        }

        private int compute(int first, int second) {
            return first * second;
        }

        private int nest(int value) {
            return value + value;
        }
    }

    @Test
    public void Overload() {
        assertScript(new Overload());
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class Overload implements ScriptForInt {

        public int execute(int value) {
            return compute(value);
        }

        private int compute(int value) {
            return value * value;
        }

        @SuppressWarnings("unused")
        private String compute(String value) {
            return value.substring(1);
        }
    }

    @Test
    public void ExtendPublic() {
        assertScript(new ExtendPublic());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class BasePublic {

        public int compute() {
            return 10;
        }
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class ExtendPublic extends BasePublic implements ScriptForInt {

        public int execute(int value) {
            return value + compute();
        }
    }

    @Test
    public void ExtendProtected() {
        assertScript(new ExtendProtected());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class BaseProtected {

        protected int compute() {
            return 10;
        }
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class ExtendProtected extends BaseProtected implements ScriptForInt {

        public int execute(int value) {
            return value + compute();
        }
    }

    @Test
    public void ExtendPackage() {
        assertScript(new ExtendPackage());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class BasePackage {

        int compute() {
            return 10;
        }
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class ExtendPackage extends BasePackage implements ScriptForInt {

        public int execute(int value) {
            return value + compute();
        }
    }

    @Test
    public void Override() {
        assertScript(new OverrideChild());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    private static class OverrideBase {

        @SuppressWarnings("unused")
        public int compute(int value) {
            return value + 1;
        }
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    private static class OverrideChild extends OverrideBase implements ScriptForInt {

        public int execute(int value) {
            return compute(value);
        }

        @Override
        public int compute(int value) {
            return value - 1;
        }
    }

    @Test
    public void Super() {
        assertScript(new SuperChild());
    }

    /**
     * @version 2009/09/01 2:51:35
     */
    static class SuperBase {

        public int compute(int value) {
            return value + 1;
        }
    }

    /**
     * @version 2009/08/18 19:19:52
     */
    static class SuperChild extends SuperBase implements ScriptForInt {

        public int execute(int value) {
            return this.compute(value) + super.compute(value);
        }

        @Override
        public int compute(int value) {
            return value - 1;
        }
    }
}
