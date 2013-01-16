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
    public void annotation() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Marked.class.isAnnotationPresent(Marker.class);
            }

        });
    }

    @Marker
    private static class Marked {
    }
}
