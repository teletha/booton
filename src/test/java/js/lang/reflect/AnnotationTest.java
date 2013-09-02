/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.annotation.Annotation;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;
import booton.translator.annotation.PrimitiveMarker;

/**
 * @version 2013/09/03 0:32:13
 */
@RunWith(ScriptRunner.class)
public class AnnotationTest {

    @Test
    public void getAnnotation() throws Exception {
        PrimitiveMarker annotation = Annotated.class.getAnnotation(PrimitiveMarker.class);
        assert annotation != null;
        assert annotation instanceof Annotation;
        assert annotation instanceof PrimitiveMarker;
        assert annotation.intValue() == 5;
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @PrimitiveMarker(intValue = 5)
    private static class Annotated {
    }
}
