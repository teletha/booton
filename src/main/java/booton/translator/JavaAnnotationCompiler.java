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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import kiss.I;

import org.objectweb.asm.Type;

/**
 * @version 2013/01/17 13:58:58
 */
class JavaAnnotationCompiler {

    /** The compiling class. */
    private final Class clazz;

    /** The code writer. */
    private final ScriptBuffer code = new ScriptBuffer();

    /** The annotated elements. */
    private final List<Annotated> elements = new ArrayList();

    /**
     * 
     */
    JavaAnnotationCompiler(Class clazz) {
        this.clazz = clazz;

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
        code.append("[").string(Javascript.computeSimpleClassName(type)).append(",{");

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
                Class returnType = method.getReturnType();
                String methodName = Javascript.computeMethodName(type, method.getName(), Type.getMethodDescriptor(method));
                Object methodValue = method.invoke(annotation);

                if (returnType == String.class) {
                    methodValue = "\"" + methodValue + "\"";
                } else if (returnType == Class.class) {
                    methodValue = Javascript.computeClassName((Class) methodValue) + ".$";
                }

                code.append(methodName).append(":").append("function() {return ").append(methodValue).append(";}");

                if (i < methods.size() - 1) {
                    code.append(",");
                }
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
        code.append("}]");
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
