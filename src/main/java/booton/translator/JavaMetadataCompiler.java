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
import java.util.Objects;
import java.util.Set;

import kiss.I;

import org.junit.runner.RunWith;

import booton.Necessary;
import booton.Unnecessary;

/**
 * @version 2013/10/10 9:13:49
 */
class JavaMetadataCompiler {

    /** The ignorable annotation classes. */
    private static final Set<Class<? extends Annotation>> ignorables = new HashSet();

    static {
        try {
            ignorables.add(JavaAPIProvider.class);
            ignorables.add(JavascriptAPIProvider.class);
            ignorables.add(JavascriptNativeProperty.class);
            ignorables.add(JavascriptNativePropertyAccessor.class);
            ignorables.add(RunWith.class);
            ignorables.add(Override.class);
            ignorables.add(Necessary.class);
            ignorables.add(Unnecessary.class);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /** The code writer. */
    private final ScriptWriter code = new ScriptWriter();

    /**
     * 
     */
    JavaMetadataCompiler(Class clazz) {
        List<Metadata> elements = new ArrayList();

        // class
        elements.add(new ClassMetadata(clazz));

        // constructors
        for (Constructor constructor : clazz.getDeclaredConstructors()) {
            elements.add(new ConstructorMetadata(constructor));
        }

        // fields
        for (Field field : clazz.getDeclaredFields()) {
            if (!field.getName().equals("serialVersionUID")) {
                elements.add(new FieldMetadata(field));
            }
        }

        // methods
        for (Method method : clazz.getDeclaredMethods()) {
            if (!TranslatorManager.isIgnorableMethod(method) && !method.isBridge()) {
                elements.add(new MethodMetadata(method));
            }
        }

        // write metadata
        code.append("{");
        for (int i = 0; i < elements.size(); i++) {
            Metadata metadata = elements.get(i);
            code.append(metadata.name, ":", "[");
            metadata.defineMetadata();
            code.append(",");
            metadata.defineAnnotation();
            code.append("]").separator();
        }
        code.append("}");
    }

    /**
     * <p>
     * Compile annotation value.
     * </p>
     * 
     * @param value
     */
    static String compileValue(Object value) {
        if (value == null) {
            return "null";
        }

        Class type = value.getClass();

        if (type == String.class || type == char.class || type == Character.class) {
            return "\"" + value + "\"";
        } else if (type == Class.class) {
            Javascript.require((Class) value);

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code.toString();
    }

    /**
     * <p>
     * Cehck whether the spcified annotation set is valid or not.
     * </p>
     * 
     * @param annotations
     * @return
     */
    private static boolean hasAnnotation(Annotation[][] annotations) {
        for (Annotation[] list : annotations) {
            if (hasAnnotation(list)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Cehck whether the spcified annotation set is valid or not.
     * </p>
     * 
     * @param annotations
     * @return
     */
    private static boolean hasAnnotation(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (!ignorables.contains(annotation.annotationType())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @version 2013/05/29 19:49:06
     */
    private abstract class Metadata {

        /** The class, constructor, field or method name. */
        private final String name;

        /** The annotation. */
        private final AnnotatedElement element;

        /**
         * @param name A runtime name.
         * @param element An {@link AnnotatedElement}.
         */
        private Metadata(String name, AnnotatedElement element) {
            this.name = name;
            this.element = element;
        }

        /**
         * 
         */
        protected abstract void defineMetadata();

        /**
         * 
         */
        protected void defineAnnotation() {
            writeAnnotation(-1, element.getDeclaredAnnotations());
        }

        /**
         * <p>
         * Write annotaion definition.
         * </p>
         * 
         * @param annotations
         */
        protected void writeAnnotation(Annotation[][] annotations) {
            if (hasAnnotation(annotations)) {
                code.append(",", "{");

                for (int i = 0; i < annotations.length; i++) {
                    writeAnnotation(i, annotations[i]);
                }
                code.append("}");
            }
        }

        /**
         * <p>
         * Write annotaion definition.
         * </p>
         * 
         * @param annotations
         */
        protected void writeAnnotation(int index, Annotation[] annotations) {
            if (hasAnnotation(annotations)) {
                if (index < 0) {
                    code.append("{");
                } else {
                    code.append(index, ":{");
                }

                for (Annotation annotation : annotations) {
                    if (!ignorables.contains(annotation.annotationType())) {
                        Javascript.require(annotation.annotationType());

                        writeAnnotation(annotation);
                        code.separator();
                    }
                }
                code.append("}").separator();
            }
        }

        /**
         * <p>
         * Compile annotation to javascript.
         * </p>
         */
        protected void writeAnnotation(Annotation annotation) {
            Class type = annotation.annotationType();
            code.append(Javascript.computeSimpleClassName(type), ":", "{");

            // collect annotation methods and compile to javascript expression
            for (Method method : type.getDeclaredMethods()) {
                method.setAccessible(true);

                try {
                    Object value = method.invoke(annotation);
                    Object defaultValue = method.getDefaultValue();

                    if (!Objects.equals(value, defaultValue)) {
                        code.append(Javascript.computeMethodName(method), ":", "function() {return " + compileValue(value) + ";}")
                                .separator();
                    }
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
            code.append("}");
        }
    }

    /**
     * @version 2013/09/07 10:21:55
     */
    private class ClassMetadata extends Metadata {

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
        protected void defineMetadata() {
            int modifier = clazz.getModifiers();

            if (clazz.isMemberClass()) {
                modifier |= 0x00008000;
            }

            if (clazz.isAnonymousClass()) {
                modifier |= 0x00010000;
            }

            if (clazz.isLocalClass()) {
                modifier |= 0x00020000;
            }

            // code.append(modifier);
            code.append(modifier, ",\"" + JavaAPIProviders.revert(clazz).getName() + "\"", ",", new JavaSignatureCompiler(clazz.getTypeParameters()), ",", new JavaSignatureCompiler(clazz.getGenericSuperclass()), ",", new JavaSignatureCompiler(clazz.getGenericInterfaces()));
        }
    }

    /**
     * @version 2013/09/03 22:50:57
     */
    private class FieldMetadata extends Metadata {

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
        protected void defineMetadata() {
            code.append(field.getModifiers(), ",\"", field.getName(), "\",", new JavaSignatureCompiler(field.getGenericType()));
        }
    }

    /**
     * @version 2013/10/10 9:13:44
     */
    private class MethodMetadata extends Metadata {

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
        protected void defineMetadata() {
            String methodName = method.getName();

            if (methodName.startsWith("$alias$")) {
                methodName = methodName.substring(7);
            }

            code.append(method.getModifiers(), ",");
            code.append(new JavaSignatureCompiler(method.getTypeParameters()), ",");
            code.append(new JavaSignatureCompiler(method.getGenericParameterTypes()), ",");
            code.append(new JavaSignatureCompiler(method.getGenericExceptionTypes()), ",");
            code.append(new JavaSignatureCompiler(method.getGenericReturnType()), ",").string(methodName);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void defineAnnotation() {
            super.defineAnnotation();

            writeAnnotation(method.getParameterAnnotations());
        }
    }

    /**
     * @version 2013/05/12 13:35:36
     */
    private class ConstructorMetadata extends Metadata {

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
        protected void defineMetadata() {
            code.append(constructor.getModifiers()).append(",");
            code.append(new JavaSignatureCompiler(constructor.getTypeParameters()), ",");
            code.append(new JavaSignatureCompiler(constructor.getGenericParameterTypes()), ",");
            code.append(new JavaSignatureCompiler(constructor.getGenericExceptionTypes()));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void defineAnnotation() {
            super.defineAnnotation();

            writeAnnotation(constructor.getParameterAnnotations());
        }
    }
}
