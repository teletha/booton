/*
 * Copyright (C) 2016 Nameless Production Committee
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
import booton.translator.annotation.InheritableMarker;
import booton.translator.annotation.NotReferenced;
import booton.translator.annotation.PrimitiveMarker;
import booton.translator.annotation.StringMarker;

/**
 * @version 2013/09/21 22:20:30
 */
@RunWith(ScriptRunner.class)
public class ClassAnnotationTest {

    @Test
    public void isAnnotationPresent() throws Exception {
        assert Annotated.class.isAnnotationPresent(PrimitiveMarker.class);
        assert !Annotated.class.isAnnotationPresent(NotReferenced.class);

        assert Parent.class.isAnnotationPresent(InheritableMarker.class);
        assert Parent.class.isAnnotationPresent(PrimitiveMarker.class);
        assert Base.class.isAnnotationPresent(InheritableMarker.class);
        assert !Base.class.isAnnotationPresent(PrimitiveMarker.class);
        assert Child.class.isAnnotationPresent(InheritableMarker.class);
        assert !Child.class.isAnnotationPresent(PrimitiveMarker.class);
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

        PrimitiveMarker a1;
        StringMarker a2;

        if (annotations[0] instanceof PrimitiveMarker) {
            a1 = (PrimitiveMarker) annotations[0];
            a2 = (StringMarker) annotations[1];
        } else {
            a1 = (PrimitiveMarker) annotations[1];
            a2 = (StringMarker) annotations[0];
        }

        assert a1.intValue() == 5;
        assert a2.value().equals("value");
    }

    @Test
    public void inheritable() throws Exception {
        InheritableMarker annotation = Base.class.getAnnotation(InheritableMarker.class);
        assert annotation != null;
        assert annotation.value().equals("parent");
        assert annotation == Parent.class.getAnnotation(InheritableMarker.class);

        annotation = Child.class.getAnnotation(InheritableMarker.class);
        assert annotation != null;
        assert annotation.value().equals("child");
        assert annotation != Parent.class.getAnnotation(InheritableMarker.class);
    }

    /**
     * @version 2013/01/17 9:50:08
     */
    @PrimitiveMarker(intValue = 5)
    @StringMarker("value")
    private static class Annotated {
    }

    /**
     * @version 2013/09/21 21:33:33
     */
    @PrimitiveMarker(intValue = 50)
    @InheritableMarker("parent")
    private static class Parent {
    }

    /**
     * @version 2013/09/21 21:33:33
     */
    private static class Base extends Parent {
    }

    /**
     * @version 2013/09/21 21:33:33
     */
    @InheritableMarker("child")
    private static class Child extends Base {
    }
}
