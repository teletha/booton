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

import booton.soeur.ScriptRunner;
import booton.translator.annotation.MultipleMarker;
import booton.translator.annotation.MultipleMarkerContainer;
import booton.translator.annotation.StringMarker;

/**
 * @version 2013/12/11 12:29:21
 */
@RunWith(ScriptRunner.class)
public class RepeatableAnnotationTest {

    @Test
    public void getAnnotation() throws Exception {
        assert Repeatable.class.getAnnotation(MultipleMarker.class) == null;
        assert Repeatable.class.getAnnotation(MultipleMarkerContainer.class) != null;
    }

    @Test
    public void getDeclaredAnnotation() throws Exception {
        assert Repeatable.class.getDeclaredAnnotation(MultipleMarker.class) == null;
        assert Repeatable.class.getDeclaredAnnotation(MultipleMarkerContainer.class) != null;
    }

    @Test
    public void getDeclaredAnnotations() throws Exception {
        Annotation[] annotations = Repeatable.class.getDeclaredAnnotations();
        assert annotations != null;
        assert annotations.length == 1;

        MultipleMarkerContainer container = (MultipleMarkerContainer) annotations[0];
        MultipleMarker[] markers = container.value();
        assert markers != null;
        assert markers.length == 2;
        assert markers[0].value() == 20;
        assert markers[1].value() == 30;

        annotations = Child.class.getDeclaredAnnotations();
        assert annotations != null;
        assert annotations.length == 1;
        assert ((MultipleMarker) annotations[0]).value() == 40;
    }

    @Test
    public void getAnnotationsByType() throws Exception {
        MultipleMarker[] markers = Repeatable.class.getAnnotationsByType(MultipleMarker.class);
        assert markers != null;
        assert markers.length == 2;
        assert markers[0].value() == 20;
        assert markers[1].value() == 30;

        markers = Child.class.getAnnotationsByType(MultipleMarker.class);
        assert markers != null;
        assert markers.length == 1;
        assert markers[0].value() == 40;
    }

    @Test
    public void getDeclaredAnnotationsByType() throws Exception {
        MultipleMarker[] markers = Repeatable.class.getDeclaredAnnotationsByType(MultipleMarker.class);
        assert markers != null;
        assert markers.length == 2;
        assert markers[0].value() == 20;
        assert markers[1].value() == 30;

        markers = Child.class.getDeclaredAnnotationsByType(MultipleMarker.class);
        assert markers != null;
        assert markers.length == 1;
        assert markers[0].value() == 40;

        StringMarker[] no = NoRepeatable.class.getDeclaredAnnotationsByType(StringMarker.class);
        assert no != null;
        assert no.length == 1;
        assert no[0].value().equals("Tobiichi Origami");
    }

    /**
     * @version 2013/12/11 12:30:51
     */
    @MultipleMarker(20)
    @MultipleMarker(30)
    private static class Repeatable {
    }

    /**
     * @version 2013/12/11 12:30:51
     */
    @MultipleMarker(40)
    private static class Child extends Repeatable {
    }

    /**
     * @version 2013/12/11 12:30:51
     */
    @StringMarker("Tobiichi Origami")
    private static class NoRepeatable {
    }
}
