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

import booton.Person;
import booton.translator.api.IntScript;
import booton.translator.api.ObjectScript;

/**
 * @version 2009/08/20 18:22:56
 */
public class UserDefinedClassTest extends ScriptTranslatorTestcase {

    @Test
    public void UserClass() {
        assertScript(new IntScript() {

            public int execute(int value) {
                Person user = new Person();
                user.setAge(value);

                return user.getAge();
            }
        });
    }

    @Test
    public void UserClassToString() {
        assertScript("Hitagi", new ObjectScript<String>() {

            public String execute(String value) {
                Person user = new Person();
                user.setAge(17);
                user.setFirstName(value);
                user.setLastName(value + value);

                return user.toString();
            }
        });
    }
}
