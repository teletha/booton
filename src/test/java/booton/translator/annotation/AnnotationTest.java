/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.annotation;

import org.junit.Ignore;
import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/18 1:16:16
 */
@SuppressWarnings("unused")
public class AnnotationTest extends ScriptTester {

    @Test
    @Ignore
    public void NoAnnotated() throws Exception {
        test(new Scriptable() {

            Class act() {
                return Annotated.class.getAnnotation(PrimitiveMarker.class).annotationType();
            }
        });
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @PrimitiveMarker(intValue = 5)
    private static class Annotated {
    }

}
