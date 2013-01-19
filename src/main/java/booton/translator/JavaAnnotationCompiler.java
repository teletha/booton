/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import kiss.I;

import org.objectweb.asm.Type;

/**
 * @version 2013/01/17 21:15:48
 */
class JavaAnnotationCompiler {

    /** The reuse. */
    private static final Method annotationType;

    static {
        try {
            annotationType = Annotation.class.getMethod("annotationType");
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /** The code writer. */
    private final ScriptBuffer code = new ScriptBuffer();

    /** The annotated elements. */
    private final List<Annotated> elements = new ArrayList();

    /**
     * 
     */
    JavaAnnotationCompiler(Class clazz) {
        // class
        register("$", clazz);

        // constructors
        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            register(Javascript.computeMethodName(clazz, "<init>", Type.getConstructorDescriptor(constructor)), constructor);
        }

        // fields
        for (Field field : clazz.getDeclaredFields()) {
            register(Javascript.computeFieldName(clazz, field.getName()), field);
        }

        // methods
        for (Method method : clazz.getDeclaredMethods()) {
            register(Javascript.computeMethodName(clazz, method.getName(), Type.getMethodDescriptor(method)), method);
        }

        // compile
        if (!elements.isEmpty()) {
            code.append("{");

            for (int i = 0; i < elements.size(); i++) {
                Annotated element = elements.get(i);
                code.append("\"").append(element.name).append("\":");
                compileAnnotations(element.annotations);

                if (i < elements.size() - 1) {
                    code.append(",");
                }
            }
            code.append("}");
        }
    }

    /**
     * <p>
     * Register annotated element.
     * </p>
     * 
     * @param name
     * @param annotations
     */
    private void register(String name, AnnotatedElement element) {
        Annotation[] annotations = element.getAnnotations();

        if (annotations.length != 0) {
            elements.add(new Annotated(name, annotations));
        }
    }

    /**
     * <p>
     * Check whether some annotation is declared or not.
     * </p>
     * 
     * @return
     */
    public boolean hasAnnotation() {
        return !elements.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code.toString();
    }

    /**
     * <p>
     * Compile annotation to javascript.
     * </p>
     */
    private void compileAnnotations(Annotation[] annotations) {
        if (annotations.length != 0) {
            code.append("[");

            for (int i = 0; i < annotations.length; i++) {
                compileAnnotation(annotations[i]);

                if (i < annotations.length - 1) {
                    code.append(",");
                }
            }
            code.append("]");
        }
    }

    /**
     * <p>
     * Compile annotation to javascript.
     * </p>
     */
    private void compileAnnotation(Annotation annotation) {
        Class type = annotation.annotationType();
        code.append("{")
                .append(Javascript.computeMethodName(annotationType))
                .append(":")
                .append("function() {return ")
                .append(Javascript.computeClass(type))
                .append(";},");

        // collect annotation methods
        List<Method> methods = new ArrayList();

        for (Method method : type.getMethods()) {
            if (method.getDeclaringClass() == type) {
                methods.add(method);
            }
        }

        // compile annotation to javascript
        for (int i = 0; i < methods.size(); i++) {
            try {
                Method method = methods.get(i);
                String methodName = Javascript.computeMethodName(type, method.getName(), Type.getMethodDescriptor(method));

                code.append(methodName)
                        .append(":")
                        .append("function() {return ")
                        .append(compileValue(method.invoke(annotation)))
                        .append(";}");

                if (i < methods.size() - 1) {
                    code.append(",");
                }
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
        code.append("}");
    }

    /**
     * <p>
     * Compile annotation value.
     * </p>
     * 
     * @param buffer
     * @param type
     * @param value
     */
    private String compileValue(Object value) {
        Class type = value.getClass();

        if (type == String.class) {
            return "\"" + value + "\"";
        } else if (type == Class.class) {
            return Javascript.computeClassName((Class) value) + ".$";
        } else if (type.isArray()) {
            StringBuilder builder = new StringBuilder("[");

            int size = Array.getLength(value);

            for (int i = 0; i < size; i++) {
                builder.append(compileValue(Array.get(value, i)));

                if (i < size - 1) {
                    builder.append(',');
                }
            }
            builder.append(']');

            return builder.toString();
        } else {
            return value.toString();
        }
    }

    /**
     * @version 2013/01/17 14:03:18
     */
    private static class Annotated {

        /** The class, constructor, field or method name. */
        private final String name;

        /** The annotation. */
        private final Annotation[] annotations;

        /**
         * @param name
         * @param annotations
         */
        private Annotated(String name, Annotation[] annotations) {
            this.name = name;
            this.annotations = annotations;
        }
    }
}
