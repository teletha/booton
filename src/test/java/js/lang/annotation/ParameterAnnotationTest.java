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
import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;
import booton.translator.annotation.PrimitiveMarker;
import booton.translator.annotation.StringMarker;

/**
 * @version 2013/09/13 16:16:55
 */
@RunWith(ScriptRunner.class)
public class ParameterAnnotationTest {

    @Test
    @Ignore
    public void method() throws Exception {
        Method method = Annotated.class.getMethod("method", int.class, int.class, String.class);
        Annotation[][] annotations = method.getParameterAnnotations();
        assert annotations.length == 3;

        Annotation[] set = annotations[0];
        assert set.length == 1;
        assert set[0] instanceof PrimitiveMarker;

        PrimitiveMarker primitive = (PrimitiveMarker) set[0];
        assert primitive.intValue() == 2;

        set = annotations[1];
        assert set.length == 1;
        assert set[0] instanceof StringMarker;

        StringMarker string = (StringMarker) set[0];
        assert string.value().equals("string");

        set = annotations[2];
        assert set.length == 0;
    }

    /**
     * @version 2013/09/13 16:17:19
     */
    private static class Annotated {

        public void method(@PrimitiveMarker(intValue = 2) int first, @StringMarker("string") int second, String none) {
        }
    }
}
