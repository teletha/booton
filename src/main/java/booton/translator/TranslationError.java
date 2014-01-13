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

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import jdk.internal.org.objectweb.asm.Type;

/**
 * @version 2013/04/14 14:47:13
 */
@SuppressWarnings("serial")
public class TranslationError extends Error {

    /** The message buffer. */
    private final StringBuilder builder = new StringBuilder("\r\n");

    /** The current processing script. */
    Javascript script;

    /**
     * 
     */
    public TranslationError() {
    }

    /**
     * With cause.
     * 
     * @param cause
     */
    public TranslationError(Throwable cause) {
        super(cause);
    }

    /**
     * <p>
     * Write error message.
     * </p>
     * 
     * @param messages An error message.
     * @return Chainable API.
     */
    public TranslationError write(Object... messages) {
        for (Object message : messages) {
            builder.append(message);
        }
        builder.append("\r\n");

        // chainalbe API
        return this;
    }

    /**
     * <p>
     * Write method type.
     * </p>
     * 
     * @param methodName A method name.
     * @param parameterTypes A method parameters.
     * @return Chainable API.
     */
    public TranslationError writeMethod(Method method) {
        return writeMethod(method.getModifiers(), method.getName(), method.getReturnType(), method.getParameterTypes(), true);
    }

    /**
     * <p>
     * Write method type.
     * </p>
     * 
     * @param methodName A method name.
     * @param returnType A method return type.
     * @param parameterTypes A method parameters.
     * @return Chainable API.
     */
    public TranslationError writeMethod(int modifiers, String methodName, Class returnType, Class[] parameterTypes) {
        return writeMethod(modifiers, methodName, returnType, parameterTypes, true);
    }

    /**
     * <p>
     * </p>
     * 
     * @param name
     * @param returnType
     * @param parameterTypes
     */
    public void writeMethod(String name, Type returnType, Type[] parameterTypes) {
        Class[] parameters = new Class[parameterTypes.length];

        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = JavaMethodCompiler.convert(parameterTypes[i]);
        }

        writeMethod(Modifier.PUBLIC, name, JavaMethodCompiler.convert(returnType), parameters, false);
    }

    /**
     * <p>
     * Write method type.
     * </p>
     * 
     * @param methodName A method name.
     * @param returnType A method return type.
     * @param parameterTypes A method parameters.
     * @return Chainable API.
     */
    private TranslationError writeMethod(int modifiers, String methodName, Class returnType, Class[] parameterTypes, boolean body) {
        builder.append("\r\n\t");

        if (modifiers != 0) {
            builder.append(Modifier.toString(modifiers)).append(' ');
        }

        builder.append(returnType.getSimpleName()).append(' ');
        builder.append(methodName).append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].isArray()) {
                builder.append(parameterTypes[i].getSimpleName()).append(" param").append(i);
            } else {
                Class type = parameterTypes[i];
                int dimensions = 0;

                while (type.isArray()) {
                    dimensions++;
                    type = type.getComponentType();
                }

                builder.append(type.getSimpleName());
                for (int j = 0; j < dimensions; j++) {
                    builder.append("[]");
                }
                builder.append(" param").append(i);
            }

            // add separator
            if (i < (parameterTypes.length - 1)) builder.append(',');
        }
        builder.append(") {\r\n");

        // write body
        if (body) {
            builder.append("\t\treturn that + \".").append(methodName).append("(");
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i == 0) {
                    builder.append("\"");
                }

                builder.append(" + param(").append(i).append(")");

                if (i == parameterTypes.length - 1) {
                    builder.append(" + \"");
                } else {
                    builder.append(" + \",\"");
                }
            }
            builder.append(")\";\r\n");
        } else {
            builder.append("\t\t// Write your implementation.\r\n");
        }

        builder.append("\t}\r\n");

        // chainalbe API
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return builder.toString();
    }

    /**
     * <p>
     * Write method type.
     * </p>
     * 
     * @param field A field.
     * @return Chainable API.
     */
    public TranslationError writeField(Field field) {
        Class type = field.getType();

        builder.append("\t")
                .append(Modifier.toString(field.getModifiers()))
                .append(" ")
                .append(type.getSimpleName())
                .append(" ")
                .append(field.getName())
                .append(" = ");

        if (type.isPrimitive()) {
            if (type == boolean.class) {
                builder.append("true");
            } else if (type == char.class) {
                builder.append("''");
            } else {
                builder.append("0");
            }
        } else {
            builder.append("null");
        }
        builder.append("; // write your code");
        builder.append("\r\n");

        // chainalbe API
        return this;
    }

    /**
     * <p>
     * Write constructor type.
     * </p>
     * 
     * @param constructor A constructor.
     * @return Chainable API.
     */
    public void writeConstructor(Constructor constructor) {
    }
}
