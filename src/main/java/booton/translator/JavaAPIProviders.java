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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Set;
import java.util.Spliterator;

import kiss.ClassListener;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;

import org.objectweb.asm.Type;

import booton.JDKEmulator;

/**
 * @version 2013/10/03 12:43:41
 */
@Manageable(lifestyle = Singleton.class)
class JavaAPIProviders implements ClassListener<JavaAPIProvider> {

    /** The mapping between Java class and JS implementation class. */
    private static final Map<Class, Definition> definitions = new HashMap();

    /** The mapping between Java class and JS implementation class. */
    private static final Map<Class, Class> revert = new HashMap();

    static {
        builtin(Iterable.class);
        builtin(Map.class);
        builtin(Spliterator.class);
        builtin(Spliterator.OfInt.class);
        builtin(Spliterator.OfLong.class);
        builtin(Spliterator.OfDouble.class);
        builtin(PrimitiveIterator.class);
        builtin(PrimitiveIterator.OfInt.class);
        builtin(PrimitiveIterator.OfLong.class);
        builtin(PrimitiveIterator.OfDouble.class);
    }

    private static void builtin(Class type) {
        try {
            type = Class.forName(type.getName().replace("java.", "js."));

            I.make(JavaAPIProviders.class).load(type);
        } catch (ClassNotFoundException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(Class<JavaAPIProvider> clazz) {
        Class api = find(clazz);

        if (api != null && !definitions.containsKey(api)) {
            definitions.put(api, new Definition(clazz));
            revert.put(clazz, api);
        }

        Class parent = clazz.getSuperclass();

        if (parent != null) {
            load(parent);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unload(Class<JavaAPIProvider> clazz) {
        Class api = find(clazz);

        if (api != null && !definitions.containsKey(api)) {
            definitions.remove(api);
            revert.remove(clazz);
        }

        Class parent = clazz.getSuperclass();

        if (parent != null) {
            unload(parent);
        }
    }

    private Class find(Class<?> declared) {
        JavaAPIProvider api = declared.getAnnotation(JavaAPIProvider.class);

        if (api == null) {
            return null;
        }

        Class type = api.value();

        if (type == JDKEmulator.class) {
            try {
                type = Class.forName(declared.getName().replace("js.", "java."));

            } catch (ClassNotFoundException e) {
                throw I.quiet(e);
            }
        }
        return type;
    }

    /**
     * <p>
     * Chech the specified Java class has Javascript runtime class (normaly, it is simplified).
     * </p>
     * 
     * @param type A target class to search.
     * @return A result.
     */
    static boolean hasProvider(Class type) {
        return definitions.containsKey(type);
    }

    /**
     * <p>
     * Convert Javascript runtime class to Java class.
     * </p>
     * 
     * @param type A target class to convert.
     * @return A converted class.
     */
    static Class revert(Class type) {
        Class java = revert.get(type);

        return java == null ? type : java;
    }

    /**
     * <p>
     * Convert Java class to Javascript runtime class (normaly, it is simplified).
     * </p>
     * 
     * @param type A target class to convert.
     * @return A converted class.
     */
    static Class convert(Class type) {
        Definition definition = definitions.get(type);

        return definition == null ? type : definition.clazz;
    }

    /**
     * <p>
     * Validate method implementation in Javascript class.
     * </p>
     * 
     * @param owner A method owner class.
     * @param name A method name.
     * @param description A method descriptor.
     * @return A original method descriptor.
     */
    static String validateMethod(Class owner, String name, String description) {
        Definition definition = definitions.get(owner);

        if (definition == null) {
            return description;
        }

        String originalDescriptor = definition.methods.get(computeMethodSignature(name, description));

        if (originalDescriptor == null) {
            TranslationError error = new TranslationError();
            error.write("You must define the method in " + definition.clazz + ".");
            error.writeMethod(name, Type.getReturnType(description), Type.getArgumentTypes(description));

            throw error;
        }
        return originalDescriptor;
    }

    /**
     * <p>
     * Validate method implementation in Javascript class.
     * </p>
     * 
     * @param owner
     * @param description
     */
    static void validateField(Class owner, Field field) {
        Definition definition = definitions.get(owner);

        if (definition != null && !definition.fields.contains(field.getName())) {
            TranslationError error = new TranslationError();
            error.write("You must define the field in ", definition.clazz, ".");
            error.write("");
            error.writeField(field);

            throw error;
        }
    }

    /**
     * <p>
     * Compute method signature.
     * </p>
     * 
     * @param name A method name.
     * @param description A method descriptor.
     * @return A signature of the specified method.
     */
    private static String computeMethodSignature(String name, String description) {
        return name + description.substring(0, description.indexOf(')') + 1);
    }

    /**
     * <p>
     * Cache for API definitions.
     * </p>
     * 
     * @version 2013/09/01 13:09:28
     */
    private static class Definition {

        /** The actual provider class. */
        private final Class clazz;

        /** The method signatures. */
        private final Map<String, String> methods = new HashMap();

        /** The method signatures. */
        private final Set<String> fields = new HashSet();

        /**
         * @param clazz
         */
        private Definition(Class clazz) {
            this.clazz = clazz;

            for (Method method : clazz.getMethods()) {
                String descriptor = Type.getMethodDescriptor(method);
                methods.put(computeMethodSignature(method.getName(), descriptor), descriptor);
            }

            for (Method method : clazz.getDeclaredMethods()) {
                String descriptor = Type.getMethodDescriptor(method);
                methods.put(computeMethodSignature(method.getName(), descriptor), descriptor);
            }

            for (Field field : clazz.getFields()) {
                fields.add(field.getName());
            }

            for (Field field : clazz.getDeclaredFields()) {
                fields.add(field.getName());
            }
        }
    }
}