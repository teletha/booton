/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/11/07 2:12:10
 */
@RunWith(ScriptRunner.class)
public class ConstructorReferenceTest {

    @Test
    public void intParameter() throws Exception {
        Function<Integer, Constructors> function = Constructors::new;
        assert function.apply(1).value.equals("Int1");
    }

    @Test
    public void longParameter() throws Exception {
        Function<Long, Constructors> function = Constructors::new;
        assert function.apply(10L).value.equals("Long10");
    }

    @Test
    public void multiParameter() throws Exception {
        BiFunction<Integer, Integer, Constructors> function = Constructors::new;
        assert function.apply(10, 5).value.equals("Sum15");
    }

    @Test
    public void noParameter() throws Exception {
        Supplier<Constructors> function = Constructors::new;
        assert function.get().value.equals("default");
    }

    /**
     * @version 2013/11/07 2:13:34
     */
    public static class Constructors {

        private String value;

        /**
         * 
         */
        public Constructors() {
            this.value = "default";
        }

        /**
         * @param value
         */
        public Constructors(int value) {
            this.value = "Int" + value;
        }

        /**
         * @param value
         */
        public Constructors(long value) {
            this.value = "Long" + value;
        }

        /**
         * @param value
         */
        public Constructors(int one, int two) {
            this.value = "Sum" + (one + two);
        }
    }
}
