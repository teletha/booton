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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 2013/10/28 15:23:03
 */
class CompilerRecorder {

    /** The igrnore classes. */
    private static Set<Class> ignores = new HashSet();

    /** The compiling route. */
    private static Deque<CompilerContext> route = new ArrayDeque();

    /**
     * <p>
     * Record starting script compiling.
     * </p>
     * 
     * @param script A target script.
     */
    static void startCompiling(Javascript script) {
        CompilerContext context = route.peekFirst();

        if (context == null || context.clazz != script.source) {
            route.addFirst(new CompilerContext(script.source));
        }
    }

    /**
     * <p>
     * Record finishing script compiling.
     * </p>
     * 
     * @param script A target script.
     */
    static void finishCompiling(Javascript script) {
        route.pollFirst();
    }

    /**
     * <p>
     * Record starting method compiling.
     * </p>
     * 
     * @param method A target method name.
     */
    static void recordMethodName(String method) {
        CompilerContext context = route.peekFirst();
        context.method = method;
        context.line = 1;
    }

    /**
     * <p>
     * Record line number.
     * </p>
     * 
     * @param line
     */
    static void recordMethodLineNumber(int line) {
        CompilerContext context = route.peekFirst();

        if (context.line == 1) {
            context.line = line - 1;
        }
    }

    /**
     * <p>
     * Enhance debug information and rethrow it.
     * </p>
     * 
     * @param error A error to enhance.
     * @return A enhanced error.
     */
    static TranslationError rethrow(TranslationError error) {
        for (CompilerContext context : route) {
            error.write(context);
        }
        return error;
    }

    /**
     * <p>
     * Add dependency for the current compiling script.
     * </p>
     * 
     * @param dependency A dependency class.
     */
    static void addDependency(Class dependency) {
        while (dependency.isArray()) {
            dependency = dependency.getComponentType();
        }

        if (!ignores.contains(dependency)) {
            CompilerContext context = route.peekFirst();

            if (context.clazz != dependency) {
                context.dependencies.add(dependency);
            }
        }
    }

    /**
     * <p>
     * Retrieve all dependencies for the current compiling script.
     * </p>
     * 
     * @return A set of dependency classes.
     */
    static Set<Class> getDependencies() {
        return route.peekFirst().dependencies;
    }

    /**
     * @version 2013/10/28 14:16:01
     */
    private static class CompilerContext {

        /** The dependencies. */
        private final Set<Class> dependencies = new HashSet();

        /** The current compiling class. */
        private final Class clazz;

        /** The current compiling method. */
        private String method;

        /** The current compiling method position. */
        private int line = 1;

        /**
         * 
         */
        private CompilerContext(Class clazz) {
            this.clazz = clazz;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(" at ").append(clazz.getName())
                    .append('.')
                    .append(method)
                    .append('(')
                    .append(clazz.getSimpleName())
                    .append(".java:")
                    .append(line)
                    .append(')');

            return builder.toString();
        }
    }
}
