/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/07/22 16:16:33
 */
@RunWith(ScriptRunner.class)
public class ClassValueTest {

    @Test
    public void get() {
        StringValue map = new StringValue();
        assert map.count == 0;
        assert map.get(Class.class).equals("Class");
        assert map.count == 1;
        assert map.get(Class.class).equals("Class");
        assert map.count == 1;
        assert map.get(Void.class) == null;
        assert map.count == 2;
        assert map.get(Void.class) == null;
        assert map.count == 2;
    }

    /**
     * @version 2014/07/22 16:17:11
     */
    private static class StringValue extends ClassValue<String> {

        private int count = 0;

        /**
         * {@inheritDoc}
         */
        @Override
        protected String computeValue(Class<?> type) {
            count++;

            if (type == Void.class) {
                return null;
            }
            return type.getSimpleName();
        }
    }
}
