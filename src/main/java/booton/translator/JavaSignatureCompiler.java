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
 * @version 2013/09/08 8:53:56
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
     * @param separator
     */
    JavaSignatureCompiler(Type[] types, String separator) {
        compile(types, separator);
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
            code.append(Javascript.computeSimpleClassName((Class) type));
        }
    }

    private void compile(GenericArrayType array) {
        code.append("[");
        compile(array.getGenericComponentType());
    }

    private void compile(TypeVariable variable) {
        code.append(variable.getName(), ":");
        compile(variable.getBounds(), "&");
    }

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
        return '"' + code.toString() + '"';
    }
}
