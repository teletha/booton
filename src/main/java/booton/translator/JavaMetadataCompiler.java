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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kiss.I;

import org.junit.runner.RunWith;

/**
 * @version 2013/05/29 19:49:16
 */
class JavaMetadataCompiler {

    /** The reusable method. */
    private static final Method annotationType;

    /** The ignorable annotation classes. */
    private static final Set<Class<? extends Annotation>> ignorables = new HashSet();

    static {
        try {
            annotationType = Annotation.class.getMethod("annotationType");

            ignorables.add(JavaAPIProvider.class);
            ignorables.add(JavascriptAPIProvider.class);
            ignorables.add(RunWith.class);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /** The target class. */
    private final Class clazz;

    /** The code writer. */
    private final ScriptBuffer code = new ScriptBuffer();

    /**
     * 
     */
    JavaMetadataCompiler(Javascript script) {
        this.clazz = script.source;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        List<Metadata> elements = new ArrayList();

        // class
        elements.add(new ClassMetadata(clazz));

        // constructors
        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            elements.add(new ConstructorMetadata(constructor));
        }

        // fields
        for (Field field : clazz.getDeclaredFields()) {
            elements.add(new FieldMetadata(field));
        }

        // methods
        for (Method method : clazz.getDeclaredMethods()) {
            elements.add(new MethodMetadata(method));
        }

        // compile
        code.append("{");

        for (int i = 0; i < elements.size(); i++) {
            Metadata element = elements.get(i);
            code.append(element.name).append(":");
            compileMetadata(element);

            if (i < elements.size() - 1) {
                code.separator();
            }
        }
        code.append("}");

        // API definition
        return code.toString();
    }

    /**
     * <p>
     * Compile annotation to javascript.
     * </p>
     */
    private void compileMetadata(Metadata metadata) {
        List<Annotation> annotations = metadata.annotations;

        code.append("[");

        // write metadata
        code.append(metadata);

        if (!annotations.isEmpty()) {
            code.append(",");

            for (int i = 0; i < annotations.size(); i++) {
                compileAnnotation(annotations.get(i));

                if (i < annotations.size() - 1) {
                    code.append(",");
                }
            }
        }

        code.append("]");
    }

    /**
     * <p>
     * Compile annotation to javascript.
     * </p>
     */
    private void compileAnnotation(Annotation annotation) {
        Class type = annotation.annotationType();
        code.append("{");
        write(Javascript.computeMethodName(annotationType), Javascript.computeClass(type));

        // collect annotation methods and compile to javascript expression
        Method[] methods = type.getDeclaredMethods();

        for (int i = 0; i < methods.length; i++) {
            code.separator();

            try {
                Method method = methods[i];
                write(Javascript.computeMethodName(method), compileValue(method.invoke(annotation)));
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
        code.append("}");
    }

    /**
     * <p>
     * Helper method to write annotation property.
     * </p>
     */
    private void write(String name, String value) {
        code.write(name, ":", "function() {return", value, ";}");
    }

    /**
     * <p>
     * Compile annotation value.
     * </p>
     * 
     * @param value
     */
    private String compileValue(Object value) {
        Class type = value.getClass();

        if (type == String.class) {
            return "\"" + value + "\"";
        } else if (type == Class.class) {
            return Javascript.computeClass((Class) value);
        } else if (type.isEnum()) {
            Javascript.require(type);

            return Javascript.computeClassName(type) + "." + Javascript.computeFieldName(type, ((Enum) value).name());
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

    private static String convert(Class[] types) {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < types.length; i++) {
            builder.append('"').append(Javascript.computeSimpleClassName(types[i])).append('"');

            if (i + 1 != types.length) {
                builder.append(",");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * @version 2013/05/29 19:49:06
     */
    private static abstract class Metadata {

        /** The class, constructor, field or method name. */
        private final String name;

        /** The annotation. */
        private final List<Annotation> annotations = new ArrayList();

        /**
         * @param name
         * @param annotations
         */
        private Metadata(String name, AnnotatedElement element) {
            this.name = name;

            for (Annotation annotation : element.getAnnotations()) {
                Class type = annotation.annotationType();

                if (!ignorables.contains(type)) {
                    Javascript.require(type);

                    annotations.add(annotation);
                }
            }
        }
    }

    /**
     * @version 2013/05/12 14:07:59
     */
    private static class ClassMetadata extends Metadata {

        /** The clazz . */
        private final Class clazz;

        /**
         * @param clazz
         */
        private ClassMetadata(Class clazz) {
            super("$", clazz);
            this.clazz = clazz;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return String.valueOf(clazz.getModifiers());
        }
    }

    /**
     * @version 2013/04/07 3:05:00
     */
    private static class MethodMetadata extends Metadata {

        /** The method . */
        private final Method method;

        /**
         * @param method
         */
        private MethodMetadata(Method method) {
            super(Javascript.computeMethodName(method), method);
            this.method = method;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(method.getModifiers()).append(",");
            builder.append('"')
                    .append(Javascript.computeSimpleClassName(method.getReturnType()))
                    .append('"')
                    .append(",");
            builder.append(convert(method.getParameterTypes()));

            return builder.toString();
        }
    }

    /**
     * @version 2013/04/07 3:05:00
     */
    private static class FieldMetadata extends Metadata {

        /** The field . */
        private final Field field;

        /**
         * @param field
         */
        private FieldMetadata(Field field) {
            super(Javascript.computeFieldName(field), field);
            this.field = field;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("-").append(field.getModifiers()).append(",");
            builder.append('"').append(Javascript.computeSimpleClassName(field.getType())).append('"');

            return builder.toString();
        }
    }

    /**
     * @version 2013/05/12 13:35:36
     */
    private static class ConstructorMetadata extends Metadata {

        /** The constructor . */
        private final Constructor constructor;

        /**
         * @param constructor
         */
        private ConstructorMetadata(Constructor constructor) {
            super(Javascript.computeMethodName(constructor), constructor);
            this.constructor = constructor;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(constructor.getModifiers()).append(",");
            builder.append(convert(constructor.getParameterTypes()));

            return builder.toString();
        }
    }
}
