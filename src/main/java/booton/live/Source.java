/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 2013/08/08 11:48:31
 */
public class Source {

    /** The source code name. */
    public final String name;

    /** The source code. */
    private final String[] lines;

    /** The class name mapping. */
    private final Map<String, String> classNames = new HashMap();

    /**
     * <p>
     * Create source code map.
     * </p>
     * 
     * @param source A source code.
     */
    public Source(String name, String source) {
        this(name, source.split("\\r\\n"));
    }

    /**
     * <p>
     * Create source code map.
     * </p>
     * 
     * @param lines A source code.
     */
    public Source(String name, List<String> lines) {
        this(name, lines.toArray(new String[lines.size()]));
    }

    /**
     * <p>
     * Create source code map.
     * </p>
     * 
     * @param lines A source code.
     */
    public Source(String name, String[] lines) {
        this.name = name;
        this.lines = lines;

        // construct class name mapping
        Pattern pattern = Pattern.compile("^\\s*\\/\\/\\sclass\\s(.+)\\s(.+)");

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {
                classNames.put(matcher.group(2), matcher.group(1));
            }
        }
    }

    /**
     * <p>
     * </p>
     * 
     * @param lineNumber
     */
    public StackTraceElement search(int lineNumber) {
        Pattern line = Pattern.compile("^\\s*\\/\\/\\s(\\d+)");
        String number = find(lineNumber - 1, line).group(1);

        Pattern pattern = Pattern.compile("^\\s*\\/\\/\\s+(.+)#(.+)\\(.*\\)");
        Matcher matcher = find(lineNumber, pattern);
        String fqcn = matcher.group(1);
        String method = matcher.group(2);
        int index = fqcn.lastIndexOf(".");
        String className = index == -1 ? fqcn : fqcn.substring(index + 1);

        return new StackTraceElement(fqcn, method, className + ".java", Integer.parseInt(number));
    }

    /**
     * <p>
     * </p>
     * 
     * @param start
     * @param pattern
     * @return
     */
    private Matcher find(int start, Pattern pattern) {
        Matcher matcher = pattern.matcher(lines[start]);

        while (!matcher.matches()) {
            matcher = pattern.matcher(lines[start--]);
        }
        return matcher;
    }

    /**
     * <p>
     * Decrypt class name.
     * </p>
     * 
     * @param name
     * @return
     */
    String decodeClassName(String name) {
        if (name.startsWith("boot.")) {
            name = name.substring(5);
        }

        String decrypted = classNames.get(name);
        return decrypted == null ? name : decrypted;
    }

    /**
     * <p>
     * Helper method to find method block from the specified line number.
     * </p>
     * 
     * @param number
     * @return
     */
    public String findBlock(int number) {
        int start = findMethodStart(number);
        int end = findMethodEnd(number, lines[start].indexOf("//"));

        StringBuilder builder = new StringBuilder();

        for (int i = start; i < end; i++) {
            builder.append(lines[i].replaceAll("\t", "  "));

            if (i == number - 1) {
                builder.append("        <<<  ERROR");
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }

    /**
     * <p>
     * Search start position of the method declaration.
     * </p>
     * 
     * @param number
     * @return
     */
    private int findMethodStart(int number) {
        number = Math.min(number, lines.length - 1);

        for (int i = number; 0 <= i; i--) {
            if (lines[i].contains(":function(")) {
                return i - 1;
            }
        }

        return 1;
    }

    /**
     * <p>
     * Search end position of the method declaration.
     * </p>
     * 
     * @param number
     * @return
     */
    private int findMethodEnd(int number, int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append("\t");
        }
        builder.append("}");

        String prefix = builder.toString();

        for (int i = number; i < lines.length; i++) {
            if (lines[i].startsWith(prefix)) {
                return i + 1;
            }
        }
        return lines.length - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (String line : lines) {
            builder.append(line).append("\r\n");
        }
        return builder.toString();
    }
}