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

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 2013/09/11 0:39:23
 */
class JavaSignatureCompiler {

    /** The code buffer. */
    private final ScriptWriter code = new ScriptWriter();

    /** The compiled variable names. */
    private final Set<String> names = new HashSet();

    /**
     * @param types
     * @param separator
     */
    JavaSignatureCompiler(Type type) {
        if (type != Object.class) {
            compile(type);
        }
    }

    /**
     * @param types
     */
    JavaSignatureCompiler(Type[] types) {
        compile(types, " ");
    }

    /**
     * <p>
     * Compile generic types.
     * </p>
     * 
     * @param types
     * @return
     */
    private void compile(Type[] types, String separator) {
        for (int i = 0; i < types.length; i++) {
            compile(types[i]);

            if (i + 1 != types.length) {
                code.append(separator);
            }
        }
    }

    /**
     * <p>
     * Compile {@link Type}.
     * </p>
     * 
     * @param type
     */
    private void compile(Type type) {
        if (type == null) {
            return;
        }

        if (type instanceof TypeVariable) {
            TypeVariable variable = (TypeVariable) type;

            if (names.add(variable.getName())) {
                compile((TypeVariable) type);
            } else {
                code.append(variable.getName(), "#");
            }
        } else if (type instanceof ParameterizedType) {
            compile((ParameterizedType) type);
        } else if (type instanceof WildcardType) {

        } else if (type instanceof GenericArrayType) {
            compile((GenericArrayType) type);
        } else {
            Class clazz = (Class) type;

            Javascript.require(clazz);

            code.append(Javascript.computeSimpleClassName(clazz));
        }
    }

    /**
     * <p>
     * Compile {@link GenericArrayType}.
     * </p>
     * 
     * @param array
     */
    private void compile(GenericArrayType array) {
        code.append("[");
        compile(array.getGenericComponentType());
    }

    /**
     * <p>
     * Compile {@link TypeVariable}.
     * </p>
     * 
     * @param variable
     */
    private void compile(TypeVariable variable) {
        code.append(variable.getName(), ":");
        compile(variable.getBounds(), "&");
    }

    /**
     * <p>
     * Compile {@link ParameterizedType}.
     * </p>
     * 
     * @param parameterized
     */
    private void compile(ParameterizedType parameterized) {
        compile(parameterized.getRawType());
        code.append("<");
        compile(parameterized.getActualTypeArguments(), ",");
        code.append(">");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return code.length() == 0 ? "" : '"' + code.toString() + '"';
    }
}
