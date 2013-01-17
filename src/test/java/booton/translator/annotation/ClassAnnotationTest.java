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

import org.junit.Test;

import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2013/01/16 16:03:45
 */
@SuppressWarnings("unused")
public class ClassAnnotationTest extends ScriptTester {

    @Test
    public void Annotated() throws Exception {
        test(new Scriptable() {

            int act() {
                return Annotated.class.getAnnotation(Marker.class).intValue();
            }
        });
    }

    @Test
    public void NotAnnotated() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return NotAnnotated.class.isAnnotationPresent(Marker.class);
            }
        });
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @Marker(intValue = 5)
    private static class Annotated {
    }

    /**
     * @version 2013/01/17 9:50:06
     */
    private static class NotAnnotated {
    }
}
