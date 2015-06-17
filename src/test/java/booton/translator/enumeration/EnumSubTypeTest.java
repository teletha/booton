/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.enumeration;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/01/02 0:21:34
 */
@RunWith(ScriptRunner.class)
public class EnumSubTypeTest {

    @Test
    public void commonMethod() throws Exception {
        assert Kaii.Cat.character().equals("Hanekawa Tubasa");
        assert Kaii.Snake.character().equals("Sengoku Nadeko");
    }

    /**
     * @version 2014/01/01 22:58:55
     */
    private static enum Kaii {

        Snake {

            public String character() {
                return "Sengoku Nadeko";
            }

        },

        Cat {

            public String character() {
                return "Hanekawa Tubasa";
            }
        };

        public abstract String character();
    }
}
