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

import js.lang.reflect.Signature;
import kiss.I;

import org.objectweb.asm.Type;

/**
 * @version 2013/01/17 21:15:48
 */
class JavaAnnotationCompiler {

    /** The reusable method. */
    private static final Method annotationType;

    static {
        try {
            annotationType = Annotation.class.getMethod("annotationType");
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /** The current processing script. */
    private final Javascript script;

    /** The code writer. */
    private final ScriptBuffer code = new ScriptBuffer();

    /** The annotated elements. */
    private final List<Annotated> elements = new ArrayList();

    /**
     * 
     */
    JavaAnnotationCompiler(Javascript script, Class clazz) {
        this.script = script;

        // class
        register("$", clazz);

        // constructors
        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            register(Javascript.computeMethodName(constructor), constructor);
        }

        // fields
        for (Field field : clazz.getDeclaredFields()) {
            register(Javascript.computeFieldName(field), field);
        }

        // methods
        for (Method method : clazz.getDeclaredMethods()) {
            register(Javascript.computeMethodName(method), method);
        }

        // compile
        if (!elements.isEmpty()) {
            code.append("{");

            for (int i = 0; i < elements.size(); i++) {
                Annotated element = elements.get(i);
                code.append(element.name).append(":");
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
        List<Annotation> list = new ArrayList();

        for (Annotation annotation : annotations) {
            if (annotation.annotationType() != JavaAPIProvider.class) {
                list.add(annotation);
            }
        }

        if (!list.isEmpty()) {
            List<Annotation> defined = new ArrayList();
            defined.addAll(list);

            if (element instanceof Method) {
                defined.add(new MethodSignature((Method) element));
            }

            if (element instanceof Field) {
                defined.add(new FieldSignature((Field) element));
            }
            elements.add(new Annotated(name, defined.toArray(new Annotation[defined.size()])));
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
        code.append("{");
        write(Javascript.computeMethodName(annotationType), Javascript.computeClass(type));

        // collect annotation methods and compile to javascript expression
        Method[] methods = type.getDeclaredMethods();

        for (int i = 0; i < methods.length; i++) {
            code.separator();

            try {
                Method method = methods[i];
                String methodName = Javascript.computeMethodName(type, method.getName(), Type.getMethodDescriptor(method));

                write(methodName, compileValue(method.invoke(annotation)));
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
        code.append(name, ": ", "function() {", "return ", value, ";", "}");
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
            return Javascript.computeClass((Class) value);
        } else if (type.isEnum()) {
            script.require(type);

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

    /**
     * @version 2013/04/07 3:05:00
     */
    private static class MethodSignature implements Signature {

        /** The method . */
        private final Method method;

        /**
         * @param method
         */
        private MethodSignature(Method method) {
            this.method = method;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<? extends Annotation> annotationType() {
            return Signature.class;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String returnType() {
            return Javascript.computeSimpleClassName(method.getReturnType());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class[] parameterTypes() {
            return method.getParameterTypes();
        }
    }

    /**
     * @version 2013/04/07 3:05:00
     */
    private static class FieldSignature implements Signature {

        /** The field . */
        private final Field field;

        /**
         * @param field
         */
        private FieldSignature(Field field) {
            this.field = field;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class<? extends Annotation> annotationType() {
            return Signature.class;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String returnType() {
            return Javascript.computeSimpleClassName(field.getType());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Class[] parameterTypes() {
            return new Class[0];
        }
    }
}
