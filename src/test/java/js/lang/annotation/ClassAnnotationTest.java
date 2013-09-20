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

import java.lang.annotation.Annotation;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;
import booton.translator.annotation.NotReferenced;
import booton.translator.annotation.PrimitiveMarker;
import booton.translator.annotation.StringMarker;

/**
 * @version 2013/09/03 0:32:13
 */
@RunWith(ScriptRunner.class)
public class ClassAnnotationTest {

    @Test
    public void isAnnotationPresent() throws Exception {
        assert Annotated.class.isAnnotationPresent(PrimitiveMarker.class);
        assert !Annotated.class.isAnnotationPresent(NotReferenced.class);
    }

    @Test
    public void getAnnotation() throws Exception {
        PrimitiveMarker annotation = Annotated.class.getAnnotation(PrimitiveMarker.class);
        assert annotation != null;
        assert annotation instanceof Annotation;
        assert annotation instanceof PrimitiveMarker;
        assert annotation.intValue() == 5;
        assert annotation.booleanValue();
        assert annotation.longValue() == 10;
        assert annotation.annotationType() == PrimitiveMarker.class;

        assert annotation == Annotated.class.getAnnotation(PrimitiveMarker.class);
    }

    @Test
    public void getAnnotationNotReferenced() throws Exception {
        NotReferenced annotation = Annotated.class.getAnnotation(NotReferenced.class);
        assert annotation == null;
    }

    @Test
    public void getAnnotations() throws Exception {
        Annotation[] annotations = Annotated.class.getAnnotations();
        assert annotations instanceof Annotation[];
        assert annotations.length == 2;
        assert annotations[0] instanceof StringMarker;
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @PrimitiveMarker(intValue = 5)
    @StringMarker("value")
    private static class Annotated {
    }
}
