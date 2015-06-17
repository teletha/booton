/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import booton.translator.annotation.PrimitiveMarker;

/**
 * @version 2013/09/07 0:08:56
 */
@RunWith(ScriptRunner.class)
public class MethodAnnotationTest {

    @Test
    public void getAnnotation() throws Exception {
        Method method = Annotated.class.getMethod("method");
        PrimitiveMarker annotation = method.getAnnotation(PrimitiveMarker.class);
        assert annotation != null;
        assert annotation instanceof Annotation;
        assert annotation instanceof PrimitiveMarker;
        assert annotation.intValue() == 10;
        assert annotation.booleanValue();
        assert annotation.doubleValue() == 3.14;
        assert annotation.annotationType() == PrimitiveMarker.class;

        assert annotation == method.getAnnotation(PrimitiveMarker.class);
    }

    /**
     * @version 2013/09/07 0:08:50
     */
    private static class Annotated {

        @PrimitiveMarker(doubleValue = 3.14)
        public void method() {
        }
    }
}
