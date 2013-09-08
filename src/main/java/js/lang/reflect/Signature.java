/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 2013/09/08 18:25:36
 */
class Signature {

    /** The declaring class. */
    private final GenericDeclaration declaration;

    /** The variable manager. */
    private final Map<String, TypeVariableInfo> variables = new HashMap();

    /** The variable declaring order. */
    final List types = new ArrayList();

    /**
     * 
     */
    Signature(String signatures, GenericDeclaration declaration) {
        this.declaration = declaration;

        for (String signature : signatures.split(" ")) {
            types.add(parseType(signature, declaration));
        }
    }

    private Type parseType(String signature, GenericDeclaration declaration) {
        for (int index = 0; index < signature.length(); index++) {
            char c = signature.charAt(index);

            if (c == ':') {
                TypeVariableInfo variable = get(signature.substring(0, index));
                variable.parse(split(signature.substring(index + 1), '&'));

                return variable;
            }

            if (c == '#') {
                return get(signature.substring(0, index));
            }

            if (c == '<') {
                return new ParameterizedTypeInfo(signature.substring(0, index), split(signature.substring(index + 1, signature.length() - 1), ','), declaration);
            }
        }
        return JSClass.forName(signature);
    }

    private TypeVariableInfo get(String name) {
        TypeVariableInfo variable = variables.get(name);

        if (variable == null) {
            variable = new TypeVariableInfo(name, declaration);
            variables.put(name, variable);
        }
        return variable;
    }

    private String[] split(String signature, char separator) {
        int start = 0;
        int nest = 0;
        List<String> values = new ArrayList();

        for (int i = 0; i < signature.length(); i++) {
            char c = signature.charAt(i);

            if (c == '<') {
                nest++;
            } else if (c == '>') {
                nest--;
            } else if (c == separator && nest == 0) {
                values.add(signature.substring(start, i));

                start = i + 1;
            }
        }
        values.add(signature.substring(start));

        return values.toArray(new String[values.size()]);
    }

    /**
     * @version 2013/09/07 22:35:55
     */
    class TypeVariableInfo implements TypeVariable {

        /** The variable name. */
        private final String name;

        /** The declaring class, constructor or method. */
        private final GenericDeclaration declaration;

        /** The upper bound of types. */
        private Type[] bounds;

        /**
         * 
         */
        private TypeVariableInfo(String name, GenericDeclaration declaration) {
            this.name = name;
            this.declaration = declaration;
        }

        private void parse(String[] uppers) {
            Type[] bounds = new Type[uppers.length];

            for (int i = 0; i < bounds.length; i++) {
                bounds[i] = parseType(uppers[i], declaration);
            }
            this.bounds = bounds;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type[] getBounds() {
            return bounds;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public GenericDeclaration getGenericDeclaration() {
            return declaration;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getName() {
            return name;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof TypeVariable) {
                TypeVariable variable = (TypeVariable) obj;

                return variable.getName().equals(name) && variable.getGenericDeclaration() == declaration && Arrays.equals(variable.getBounds(), bounds);
            }
            return false;
        }
    }

    /**
     * @version 2013/09/08 9:57:17
     */
    class ParameterizedTypeInfo implements ParameterizedType {

        /** The arugument types. */
        private final Type[] arguments;

        /** The raw type. */
        private final Type raw;

        /** The owner type. */
        private final Type owner;

        /**
         * @param arguments
         * @param raw
         * @param owner
         */
        private ParameterizedTypeInfo(String raw, String[] parameters, GenericDeclaration declaration) {
            this.raw = JSClass.forName(raw);
            this.owner = null;
            this.arguments = new Type[parameters.length];

            for (int i = 0; i < parameters.length; i++) {
                arguments[i] = parseType(parameters[i], declaration);
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type[] getActualTypeArguments() {
            return arguments;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type getRawType() {
            return raw;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Type getOwnerType() {
            return owner;
        }
    }

}
