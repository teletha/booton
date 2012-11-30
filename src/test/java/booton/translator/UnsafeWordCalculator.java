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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @version 2012/11/30 15:33:24
 */
public class UnsafeWordCalculator {

    /**
     * The sorterd reserved words in ECMA Script.It is no need to contains the word which has both
     * upper case letter and lower case letter (e.g NaN). Because our naming strategy doesn't output
     * the word which has mixed letter.
     */
    private static final String[] reserved = {"abstract", "boolean", "break", "byte", "case", "catch", "char", "class",
            "const", "continue", "debugger", "default", "delete", "do", "double", "else", "enum", "export", "extends",
            "false", "final", "finally", "float", "for", "function", "goto", "if", "implements", "import", "in",
            "instanceof", "int", "interface", "label", "long", "name", "native", "new", "null", "package", "private",
            "protected", "prototype", "public", "return", "short", "static", "super", "switch", "synchronized", "this",
            "throw", "throws", "transient", "true", "try", "typeof", "var", "void", "volatile", "while", "with"};

    /**
     * The sorterd unsafe words in some ECMA Script Runtime Environemnt. These words contain some
     * unsafe words in some ECMA Script Runtime Environment. It is no need to contains the word
     * which has both upper case letter and lower case letter (e.g NaN). Because our naming strategy
     * doesn't output the word which has mixed letter.
     */
    private static final String[] unsafe = {"as", "is", "use"};

    /**
     * The sorterd property names in Function. It is no need to contains the word which has both
     * upper case letter and lower case letter (e.g NaN). Because our naming strategy doesn't output
     * the word which has mixed letter.
     */
    private static final String[] function = {"apply", "arguments", "arity", "call", "caller", "constructor", "length",
            "unwatch", "watch"};

    /**
     * The sorterd property names in Booton. It is no need to contains the word which has both upper
     * case letter and lower case letter (e.g NaN). Because our naming strategy doesn't output the
     * word which has mixed letter.
     */
    private static final String[] booton = {"base", "bind", "css", "define", "extend", "fire", "html", "load", "once",
            "repository", "unbind"};

    /**
     * Output
     */
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList();

        // collect unsafe words
        List<String> words = new ArrayList();
        words.addAll(Arrays.asList(reserved));
        words.addAll(Arrays.asList(unsafe));
        words.addAll(Arrays.asList(function));
        words.addAll(Arrays.asList(booton));

        root: for (int i = 0; i < words.size(); i++) {
            // 'a'-head word is safe because our munging implementation can't output 'a'-head value
            // except for 'a'
            if (words.get(i).charAt(0) == 'a') {
                continue;
            }

            int sum = 0;

            for (int j = 0, length = words.get(i).length(); j < length; j++) {
                char c = words.get(i).charAt(length - j - 1);

                // Exclude the word which contains unused character because our munging
                // implementation uses alphabetical hex number(a to p).
                if ('p' < c) {
                    continue root;
                }

                sum += (c - 97) * (1 << 4 * j);

                // exclude large number (it is enough to represent identifier)
                if ((1 << 19) < sum) {
                    continue root;
                }
            }

            ints.add(sum);
        }

        // sort
        Collections.sort(ints);

        // build expression to copy and paste
        StringBuilder builder = new StringBuilder();
        builder.append("private static final int[] unsafe = {");

        for (int i = 0; i < ints.size(); i++) {
            builder.append(ints.get(i));

            if (i != ints.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("};");

        // output
        System.out.println(builder);
    }
}
