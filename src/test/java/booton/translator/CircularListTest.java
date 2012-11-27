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

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @version 2009/08/19 22:47:51
 */
public class CircularListTest {

    @Test
    public void test() {
        CircularList list = new CircularList();
        list.record(0);
        list.record(1);
        list.record(2);
        list.record(3);
        list.record(4);

        assertTrue(list.match(4));
        assertTrue(list.match(3, 4));
        assertTrue(list.match(0, 1, 2, 3, 4));
    }

    /**
     * @version 2009/08/19 22:49:15
     */
    private static class CircularList {

        private int recordIndex = 0;

        private int[] records = new int[5];

        /**
         * Record the specified instruction.
         */
        private final void record(int opcode) {
            records[recordIndex++] = opcode;

            if (recordIndex == 5) {
                recordIndex = 0; // loop index
            }
        }

        /**
         * Pattern matching for the recent constructions.
         * 
         * @param first A oldest instruction.
         * @param second A middle instruction.
         * @param third A latest instruction.
         * @return A result.
         */
        private final boolean match(int... opcodes) {
            for (int i = 0; i < opcodes.length; i++) {
                if (records[(recordIndex + i + 5 - opcodes.length) % 5] != opcodes[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
