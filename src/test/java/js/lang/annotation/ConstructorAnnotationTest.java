/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.annotation;

import java.lang.reflect.Constructor;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;
import booton.translator.annotation.PrimitiveMarker;

/**
 * @version 2013/09/04 11:11:54
 */
@RunWith(ScriptRunner.class)
public class ConstructorAnnotationTest {

    @Test
    public void annotation() throws Exception {
        Constructor<?> constructor = Annotated.class.getDeclaredConstructors()[0];
        PrimitiveMarker annotation = constructor.getAnnotation(PrimitiveMarker.class);
        assert annotation != null;
        assert annotation.intValue() == 100;
    }

    /**
     * @version 2013/09/04 11:12:53
     */
    private static class Annotated {

        /**
         * 
         */
        @PrimitiveMarker(intValue = 100)
        private Annotated() {
        }
    }
}
