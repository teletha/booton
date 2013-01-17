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
 * @version 2013/01/17 20:10:20
 */
@SuppressWarnings("unused")
public class ClassAnnotationTest extends ScriptTester {

    @Test
    public void NoAnnotated() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return NoAnnotated.class.isAnnotationPresent(PrimitiveMarker.class);
            }
        });
    }

    @Test
    public void NotReferenced() throws Exception {
        test(new Scriptable() {

            boolean act() {
                return Annotated.class.isAnnotationPresent(NotReferenced.class);
            }
        });
    }

    @Test
    public void Annotated() throws Exception {
        test(new Scriptable() {

            int act() {
                return Annotated.class.getAnnotation(PrimitiveMarker.class).intValue();
            }
        });
    }

    @Test
    public void MultipleValues() throws Exception {
        test(new Scriptable() {

            double act() {
                PrimitiveMarker marker = MultipleValues.class.getAnnotation(PrimitiveMarker.class);

                return marker.floatValue() + marker.doubleValue();
            }
        });
    }

    @Test
    public void StringValue() throws Exception {
        test(new Scriptable() {

            String act() {
                return StringValue.class.getAnnotation(StringMarker.class).value();
            }
        });
    }

    @Test
    public void ClassValue() throws Exception {
        test(new Scriptable() {

            Class act() {
                return ClassValue.class.getAnnotation(ClassMarker.class).value();
            }
        });
    }

    /**
     * @version 2013/01/17 9:50:06
     */
    private static class NoAnnotated {
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @PrimitiveMarker(intValue = 5)
    private static class Annotated {
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @PrimitiveMarker(floatValue = 1.2f, doubleValue = -0.2444456343343)
    private static class MultipleValues {
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @StringMarker("define")
    private static class StringValue {
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @ClassMarker(ClassValue.class)
    private static class ClassValue {
    }
}
