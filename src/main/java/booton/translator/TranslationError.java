/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @version 2012/11/30 9:30:19
 */
@SuppressWarnings("serial")
public class TranslationError extends Error {

    /** The message buffer. */
    private final StringBuilder builder = new StringBuilder("\r\n");

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
     * @param returnType A method return type.
     * @param parameterTypes A method parameters.
     * @return Chainable API.
     */
    public TranslationError writeMethod(int modifiers, String methodName, Class returnType, Class[] parameterTypes) {
        if (modifiers != 0) {
            builder.append(Modifier.toString(modifiers)).append(' ');
        }

        builder.append(returnType.getSimpleName()).append(' ');
        builder.append(methodName).append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].isArray()) {
                builder.append(parameterTypes[i].getSimpleName());
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
            }

            // add separator
            if (i < (parameterTypes.length - 1)) builder.append(',');
        }
        builder.append(')');

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
        return writeMethod(method.getModifiers(), method.getName(), method.getReturnType(), method.getParameterTypes());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage() {
        return builder.toString();
    }
}
