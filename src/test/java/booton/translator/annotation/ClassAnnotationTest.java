/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.annotation;

import org.junit.Test;

import booton.soeur.ScriptTester;
import booton.soeur.Scriptable;

/**
 * @version 2013/12/11 20:21:06
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

    @Test
    public void StringArrayValue() throws Exception {
        test(new Scriptable() {

            String[] act() {
                return StringArrayValue.class.getAnnotation(StringArrayMarker.class).value();
            }
        });
    }

    @Test
    public void PrimitiveArrayValue() throws Exception {
        test(new Scriptable() {

            int[] act() {
                return PrimitiveArrayValue.class.getAnnotation(PrimitiveArrayMarker.class).value();
            }
        });
    }

    @Test
    public void AnnotationValue() throws Exception {
        test(new Scriptable() {

            int act() {
                return AnnotationValue.class.getAnnotation(AnnotationMarker.class).value().intValue();
            }
        });
    }

    @Test
    public void AnnotationArrayValue() throws Exception {
        test(new Scriptable() {

            int act() {
                return AnnotationArrayValue.class.getAnnotation(AnnotationArrayMarker.class).value()[1].intValue();
            }
        });
    }

    @Test
    public void RepeatableSingleValue() throws Exception {
        test(new Scriptable() {

            int act() {
                return RepeatableSingleValue.class.getAnnotation(MultipleMarker.class).value();
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

    /**
     * @version 2013/01/17 9:50:08
     */
    @StringArrayMarker({"one", "two", "three"})
    private static class StringArrayValue {
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @PrimitiveArrayMarker({1, 2, 3})
    private static class PrimitiveArrayValue {
    }

    /**
     * @version 2013/12/11 19:45:09
     */
    @AnnotationMarker(@PrimitiveMarker(intValue = 20))
    private static class AnnotationValue {
    }

    /**
     * @version 2013/12/11 19:45:09
     */
    @AnnotationArrayMarker({@PrimitiveMarker(intValue = 20), @PrimitiveMarker(intValue = 30)})
    private static class AnnotationArrayValue {
    }

    /**
     * @version 2013/12/11 12:15:34
     */
    @MultipleMarker(10)
    private static class RepeatableSingleValue {
    }
}
