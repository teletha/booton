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
import java.util.Set;

import kiss.ClassListener;
import kiss.Manageable;
import kiss.Singleton;

import org.objectweb.asm.Type;

/**
 * @version 2013/08/15 17:34:41
 */
@Manageable(lifestyle = Singleton.class)
class JavaAPIProviders implements ClassListener<JavaAPIProvider> {

    /** The mapping between Java class and JS implementation class. */
    private static final Map<Class, JavaAPIProviders.Definition> definitions = new HashMap();

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(Class<JavaAPIProvider> clazz) {
        JavaAPIProvider api = clazz.getAnnotation(JavaAPIProvider.class);

        if (api != null && !definitions.containsKey(api.value())) {
            definitions.put(api.value(), new Definition(clazz));
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
        JavaAPIProvider api = clazz.getAnnotation(JavaAPIProvider.class);

        if (api != null && !definitions.containsKey(api.value())) {
            definitions.remove(api.value());
        }

        Class parent = clazz.getSuperclass();

        if (parent != null) {
            load(parent);
        }
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
     * Convert Java class to Javascript runtime class (normaly, it is simplified).
     * </p>
     * 
     * @param type A target class to convert.
     * @return A converted class.
     */
    static Class convert(Class type) {
        JavaAPIProviders.Definition definition = definitions.get(type);

        return definition == null ? type : definition.clazz;
    }

    /**
     * <p>
     * Validate method implementation in Javascript class.
     * </p>
     * 
     * @param owner
     * @param name
     * @param description
     */
    static void validateMethod(Class owner, String name, String description) {
        JavaAPIProviders.Definition definition = definitions.get(owner);

        if (definition != null && !definition.methods.contains(name + description)) {
            TranslationError error = new TranslationError();
            error.write("You must define the method in " + definition.clazz + ".");
            error.writeMethod(name, Type.getReturnType(description), Type.getArgumentTypes(description));

            throw error;
        }
    }

    /**
     * <p>
     * Validate method implementation in Javascript class.
     * </p>
     * 
     * @param owner
     * @param name
     * @param description
     */
    static void validateField(Class owner, Field field) {
        JavaAPIProviders.Definition definition = definitions.get(owner);

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
     * Cache for API definitions.
     * </p>
     * 
     * @version 2013/04/14 14:07:33
     */
    private static class Definition {

        /** The actual provider class. */
        private final Class clazz;

        /** The method signatures. */
        private final Set<String> methods = new HashSet();

        /** The method signatures. */
        private final Set<String> fields = new HashSet();

        /**
         * @param clazz
         */
        private Definition(Class clazz) {
            this.clazz = clazz;

            for (Method method : clazz.getMethods()) {
                methods.add(method.getName() + Type.getMethodDescriptor(method));
            }

            for (Method method : clazz.getDeclaredMethods()) {
                methods.add(method.getName() + Type.getMethodDescriptor(method));
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