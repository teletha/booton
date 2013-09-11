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
 * @version 2013/09/07 10:22:02
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
            elements.add(new FieldMetadata(field));
        }

        // methods
        for (Method method : clazz.getDeclaredMethods()) {
            if (!TranslatorManager.isSerializerMethod(method)) {
                elements.add(new MethodMetadata(method));
            }
        }

        // write metadata
        code.append("{");

        for (int i = 0; i < elements.size(); i++) {
            Metadata metadata = elements.get(i);
            code.append(metadata.name, ":", "[");
            metadata.writeMetadata();
            code.append(",", "{");
            metadata.writeAnnotation();
            code.append("}]");

            if (i < elements.size() - 1) {
                code.separator();
            }
        }
        code.append("}");
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
        code.write(name, ":", "function() {return ", value, ";}");
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

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code.toString();
    }

    /**
     * <p>
     * Compile metadata.
     * </p>
     * 
     * @param clazz
     * @param writer
     */
    public static void compile(Class clazz, ScriptWriter writer) {

    }

    /**
     * @version 2013/05/29 19:49:06
     */
    private abstract class Metadata {

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

        /**
         * 
         */
        protected abstract void writeMetadata();

        /**
         * 
         */
        protected void writeAnnotation() {
            writeAnnotation("$", annotations.toArray(new Annotation[annotations.size()]));
        }

        /**
         * <p>
         * Write annotations.
         * </p>
         * 
         * @param name
         * @param annotations
         */
        protected void writeAnnotation(String name, Annotation[] annotations) {
            code.append(name, ":{");
            for (int i = 0; i < annotations.length; i++) {
                compileAnnotation(annotations[i]);

                if (i + 1 != annotations.length) {
                    code.separator();
                }
            }
            code.append("}");
        }

        /**
         * <p>
         * Compile annotation to javascript.
         * </p>
         */
        private void compileAnnotation(Annotation annotation) {
            Class type = annotation.annotationType();
            code.append(Javascript.computeSimpleClassName(type), ":", "{");

            // collect annotation methods and compile to javascript expression
            Method[] methods = type.getDeclaredMethods();

            for (int i = 0; i < methods.length; i++) {
                try {
                    // code.append(Javascript.computeMethodName(methods[i]), ":",
                    // compileValue(methods[i].invoke(annotation)));
                    write(Javascript.computeMethodName(methods[i]), compileValue(methods[i].invoke(annotation)));

                    if (i + 1 != methods.length) {
                        code.separator();
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
        protected void writeMetadata() {
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
            code.append(modifier, ",", new JavaSignatureCompiler(clazz.getTypeParameters()), ",", new JavaSignatureCompiler(clazz.getGenericSuperclass()), ",", new JavaSignatureCompiler(clazz.getGenericInterfaces()));
        }
    }

    /**
     * @version 2013/04/07 3:05:00
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
        protected void writeMetadata() {
            code.append(method.getModifiers(), ",");
            code.append(new JavaSignatureCompiler(method.getTypeParameters()), ",");
            code.append(new JavaSignatureCompiler(method.getGenericParameterTypes()), ",");
            code.append(new JavaSignatureCompiler(method.getGenericExceptionTypes()), ",");
            code.append(new JavaSignatureCompiler(method.getGenericReturnType()), ",").string(method.getName());
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
        protected void writeMetadata() {
            code.append(field.getModifiers(), ",\"", field.getName(), "\",", new JavaSignatureCompiler(field.getGenericType()));
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
        protected void writeMetadata() {
            code.append(constructor.getModifiers()).append(",");
            code.append(new JavaSignatureCompiler(constructor.getTypeParameters()), ",");
            code.append(new JavaSignatureCompiler(constructor.getGenericParameterTypes()), ",");
            code.append(new JavaSignatureCompiler(constructor.getGenericExceptionTypes()));
        }
    }
}
