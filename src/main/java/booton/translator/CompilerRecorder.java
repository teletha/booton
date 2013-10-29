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

/**
 * @version 2013/10/29 10:54:48
 */
class CompilerRecorder {

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

        if (context == null || context.script != script) {
            route.addFirst(new CompilerContext(script));
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
     * Retrieve the current compiling script.
     * </p>
     * 
     * @return The current compiling script.
     */
    static Javascript getCurrent() {
        return route.peekFirst().script;
    }

    /**
     * @version 2013/10/28 14:16:01
     */
    private static class CompilerContext {

        /** The current compiling class. */
        private final Javascript script;

        /** The current compiling method. */
        private String method;

        /** The current compiling method position. */
        private int line = 1;

        /**
         * @param script An associated script.
         */
        private CompilerContext(Javascript script) {
            this.script = script;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder(" at ").append(script.source.getName())
                    .append('.')
                    .append(method)
                    .append('(')
                    .append(script.source.getSimpleName())
                    .append(".java:")
                    .append(line)
                    .append(')');

            return builder.toString();
        }
    }
}
