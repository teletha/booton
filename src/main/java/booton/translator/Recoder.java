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
 * @version 2013/10/24 1:17:14
 */
public class Recoder {

    /** The compiling route. */
    private static Deque<Javascript> compiling = new ArrayDeque();

    private static String method;

    public static void add(Javascript script) {
        compiling.addFirst(script);
    }

    public static void remove() {
        compiling.removeFirst();
    }

    public static void addMethod(String name) {
        method = name;
    }

    public static TranslationError write(TranslationError error) {
        for (Javascript script : compiling) {
            if (method == null) {
                error.write(" at ", script.source.getName());
            } else {
                error.write(" at ", script.source.getName() + "." + method);
                method = null;
            }

        }
        return error;
    }

    public static Javascript getCurrent() {
        return compiling.peekFirst();
    }
}
